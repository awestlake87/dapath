package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ij;
import com.google.android.gms.internal.il;
import java.io.IOException;

class C0449a {
    private static C0449a aeh;
    private static Object tq = new Object();
    private volatile long aec;
    private volatile long aed;
    private volatile long aee;
    private final ij aef;
    private C0448a aeg;
    private volatile boolean mClosed;
    private final Context mContext;
    private final Thread sf;
    private volatile Info ts;

    class C04472 implements Runnable {
        final /* synthetic */ C0449a aei;

        C04472(C0449a c0449a) {
            this.aei = c0449a;
        }

        public void run() {
            this.aei.le();
        }
    }

    public interface C0448a {
        Info lg();
    }

    class C09231 implements C0448a {
        final /* synthetic */ C0449a aei;

        C09231(C0449a c0449a) {
            this.aei = c0449a;
        }

        public Info lg() {
            Info info = null;
            try {
                info = AdvertisingIdClient.getAdvertisingIdInfo(this.aei.mContext);
            } catch (IllegalStateException e) {
                bh.m1645D("IllegalStateException getting Advertising Id Info");
            } catch (GooglePlayServicesRepairableException e2) {
                bh.m1645D("GooglePlayServicesRepairableException getting Advertising Id Info");
            } catch (IOException e3) {
                bh.m1645D("IOException getting Ad Id Info");
            } catch (GooglePlayServicesNotAvailableException e4) {
                bh.m1645D("GooglePlayServicesNotAvailableException getting Advertising Id Info");
            } catch (Exception e5) {
                bh.m1645D("Unknown exception. Could not get the Advertising Id Info.");
            }
            return info;
        }
    }

    private C0449a(Context context) {
        this(context, null, il.gb());
    }

    C0449a(Context context, C0448a c0448a, ij ijVar) {
        this.aec = 900000;
        this.aed = 30000;
        this.mClosed = false;
        this.aeg = new C09231(this);
        this.aef = ijVar;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        if (c0448a != null) {
            this.aeg = c0448a;
        }
        this.sf = new Thread(new C04472(this));
    }

    static C0449a m1617M(Context context) {
        if (aeh == null) {
            synchronized (tq) {
                if (aeh == null) {
                    aeh = new C0449a(context);
                    aeh.start();
                }
            }
        }
        return aeh;
    }

    private void le() {
        Process.setThreadPriority(10);
        while (!this.mClosed) {
            try {
                this.ts = this.aeg.lg();
                Thread.sleep(this.aec);
            } catch (InterruptedException e) {
                bh.m1643B("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    private void lf() {
        if (this.aef.currentTimeMillis() - this.aee >= this.aed) {
            interrupt();
            this.aee = this.aef.currentTimeMillis();
        }
    }

    void interrupt() {
        this.sf.interrupt();
    }

    public boolean isLimitAdTrackingEnabled() {
        lf();
        return this.ts == null ? true : this.ts.isLimitAdTrackingEnabled();
    }

    public String ld() {
        lf();
        return this.ts == null ? null : this.ts.getId();
    }

    void start() {
        this.sf.start();
    }
}
