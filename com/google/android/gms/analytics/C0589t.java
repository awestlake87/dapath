package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Process;
import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import com.google.android.gms.internal.fd;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

class C0589t extends Thread implements C0114f {
    private static C0589t uO;
    private volatile boolean mClosed = false;
    private final Context mContext;
    private final LinkedBlockingQueue<Runnable> uK = new LinkedBlockingQueue();
    private volatile boolean uL = false;
    private volatile List<fd> uM;
    private volatile String uN;
    private volatile ag uP;

    class C01342 implements Runnable {
        final /* synthetic */ C0589t uR;

        C01342(C0589t c0589t) {
            this.uR = c0589t;
        }

        public void run() {
            this.uR.uP.cq();
        }
    }

    class C01353 implements Runnable {
        final /* synthetic */ C0589t uR;

        C01353(C0589t c0589t) {
            this.uR = c0589t;
        }

        public void run() {
            this.uR.uP.cl();
        }
    }

    class C01364 implements Runnable {
        final /* synthetic */ C0589t uR;

        C01364(C0589t c0589t) {
            this.uR = c0589t;
        }

        public void run() {
            this.uR.uP.cs();
        }
    }

    private C0589t(Context context) {
        super("GAThread");
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    static int m1939O(String str) {
        int i = 1;
        if (!TextUtils.isEmpty(str)) {
            i = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char charAt = str.charAt(length);
                i = (((i << 6) & 268435455) + charAt) + (charAt << 14);
                int i2 = 266338304 & i;
                if (i2 != 0) {
                    i ^= i2 >> 21;
                }
            }
        }
        return i;
    }

    private String m1942a(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    private String m1950q(Map<String, String> map) {
        return map.containsKey("useSecure") ? ak.m53d((String) map.get("useSecure"), true) ? "https:" : "http:" : "https:";
    }

    private boolean m1951r(Map<String, String> map) {
        if (map.get("&sf") == null) {
            return false;
        }
        double a = ak.m50a((String) map.get("&sf"), 100.0d);
        if (a >= 100.0d) {
            return false;
        }
        if (((double) (C0589t.m1939O((String) map.get("&cid")) % 10000)) < a * 100.0d) {
            return false;
        }
        String str = map.get("&t") == null ? EnvironmentCompat.MEDIA_UNKNOWN : (String) map.get("&t");
        aa.m39C(String.format("%s hit sampled out", new Object[]{str}));
        return true;
    }

    private void m1952s(Map<String, String> map) {
        C0120m s = C0578a.m1872s(this.mContext);
        ak.m52a(map, "&adid", s.getValue("&adid"));
        ak.m52a(map, "&ate", s.getValue("&ate"));
    }

    private void m1953t(Map<String, String> map) {
        C0120m cu = C0582g.cu();
        ak.m52a(map, "&an", cu.getValue("&an"));
        ak.m52a(map, "&av", cu.getValue("&av"));
        ak.m52a(map, "&aid", cu.getValue("&aid"));
        ak.m52a(map, "&aiid", cu.getValue("&aiid"));
        map.put("&v", "1");
    }

    static C0589t m1954x(Context context) {
        if (uO == null) {
            uO = new C0589t(context);
        }
        return uO;
    }

    static String m1955y(Context context) {
        try {
            FileInputStream openFileInput = context.openFileInput("gaInstallData");
            byte[] bArr = new byte[8192];
            int read = openFileInput.read(bArr, 0, 8192);
            if (openFileInput.available() > 0) {
                aa.m37A("Too much campaign data, ignoring it.");
                openFileInput.close();
                context.deleteFile("gaInstallData");
                return null;
            }
            openFileInput.close();
            context.deleteFile("gaInstallData");
            if (read <= 0) {
                aa.m40D("Campaign file is empty.");
                return null;
            }
            String str = new String(bArr, 0, read);
            aa.m38B("Campaign found: " + str);
            return str;
        } catch (FileNotFoundException e) {
            aa.m38B("No campaign data found.");
            return null;
        } catch (IOException e2) {
            aa.m37A("Error reading campaign data.");
            context.deleteFile("gaInstallData");
            return null;
        }
    }

    void m1956a(Runnable runnable) {
        this.uK.add(runnable);
    }

    public void cl() {
        m1956a(new C01353(this));
    }

    public void cq() {
        m1956a(new C01342(this));
    }

    public void cs() {
        m1956a(new C01364(this));
    }

    public LinkedBlockingQueue<Runnable> ct() {
        return this.uK;
    }

    public Thread getThread() {
        return this;
    }

    protected void init() {
        this.uP.cL();
        this.uM = new ArrayList();
        this.uM.add(new fd("appendVersion", "&_v".substring(1), "ma4.0.2"));
        this.uM.add(new fd("appendQueueTime", "&qt".substring(1), null));
        this.uM.add(new fd("appendCacheBuster", "&z".substring(1), null));
    }

    public void mo878p(Map<String, String> map) {
        final Map hashMap = new HashMap(map);
        String str = (String) map.get("&ht");
        if (str != null) {
            try {
                Long.valueOf(str);
            } catch (NumberFormatException e) {
                str = null;
            }
        }
        if (str == null) {
            hashMap.put("&ht", Long.toString(System.currentTimeMillis()));
        }
        m1956a(new Runnable(this) {
            final /* synthetic */ C0589t uR;

            public void run() {
                this.uR.m1952s(hashMap);
                if (TextUtils.isEmpty((CharSequence) hashMap.get("&cid"))) {
                    hashMap.put("&cid", C0583h.cv().getValue("&cid"));
                }
                if (!GoogleAnalytics.getInstance(this.uR.mContext).getAppOptOut() && !this.uR.m1951r(hashMap)) {
                    if (!TextUtils.isEmpty(this.uR.uN)) {
                        C0138u.cU().m84u(true);
                        hashMap.putAll(new HitBuilder().setCampaignParamsFromUrl(this.uR.uN).build());
                        C0138u.cU().m84u(false);
                        this.uR.uN = null;
                    }
                    this.uR.m1953t(hashMap);
                    this.uR.uP.mo866b(C0140y.m88u(hashMap), Long.valueOf((String) hashMap.get("&ht")).longValue(), this.uR.m1950q(hashMap), this.uR.uM);
                }
            }
        });
    }

    public void run() {
        Process.setThreadPriority(10);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            aa.m40D("sleep interrupted in GAThread initialize");
        }
        try {
            if (this.uP == null) {
                this.uP = new C0588s(this.mContext, this);
            }
            init();
            this.uN = C0589t.m1955y(this.mContext);
            aa.m39C("Initialized GA Thread");
        } catch (Throwable th) {
            aa.m37A("Error initializing the GAThread: " + m1942a(th));
            aa.m37A("Google Analytics will not start up.");
            this.uL = true;
        }
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.uK.take();
                if (!this.uL) {
                    runnable.run();
                }
            } catch (InterruptedException e2) {
                aa.m38B(e2.toString());
            } catch (Throwable th2) {
                aa.m37A("Error on GAThread: " + m1942a(th2));
                aa.m37A("Google Analytics is shutting down.");
                this.uL = true;
            }
        }
    }
}
