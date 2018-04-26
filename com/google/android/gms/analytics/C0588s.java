package com.google.android.gms.analytics;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.C0581c.C0110b;
import com.google.android.gms.analytics.C0581c.C0111c;
import com.google.android.gms.internal.fd;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

class C0588s implements ag, C0110b, C0111c {
    private final Context mContext;
    private C0112d tU;
    private final C0114f tV;
    private boolean tX;
    private volatile long uh;
    private volatile C0128a ui;
    private volatile C0108b uj;
    private C0112d uk;
    private final GoogleAnalytics ul;
    private final Queue<C0131d> um;
    private volatile int un;
    private volatile Timer uo;
    private volatile Timer up;
    private volatile Timer uq;
    private boolean ur;
    private boolean us;
    private boolean ut;
    private C0116i uu;
    private long uv;

    class C01262 implements Runnable {
        final /* synthetic */ C0588s uw;

        C01262(C0588s c0588s) {
            this.uw = c0588s;
        }

        public void run() {
            this.uw.cM();
        }
    }

    private enum C0128a {
        CONNECTING,
        CONNECTED_SERVICE,
        CONNECTED_LOCAL,
        BLOCKED,
        PENDING_CONNECTION,
        PENDING_DISCONNECT,
        DISCONNECTED
    }

    private class C0129b extends TimerTask {
        final /* synthetic */ C0588s uw;

        private C0129b(C0588s c0588s) {
            this.uw = c0588s;
        }

        public void run() {
            if (this.uw.ui == C0128a.CONNECTED_SERVICE && this.uw.um.isEmpty() && this.uw.uh + this.uw.uv < this.uw.uu.currentTimeMillis()) {
                aa.m39C("Disconnecting due to inactivity");
                this.uw.bs();
                return;
            }
            this.uw.uq.schedule(new C0129b(this.uw), this.uw.uv);
        }
    }

    private class C0130c extends TimerTask {
        final /* synthetic */ C0588s uw;

        private C0130c(C0588s c0588s) {
            this.uw = c0588s;
        }

        public void run() {
            if (this.uw.ui == C0128a.CONNECTING) {
                this.uw.cO();
            }
        }
    }

    private static class C0131d {
        private final Map<String, String> uG;
        private final long uH;
        private final String uI;
        private final List<fd> uJ;

        public C0131d(Map<String, String> map, long j, String str, List<fd> list) {
            this.uG = map;
            this.uH = j;
            this.uI = str;
            this.uJ = list;
        }

        public Map<String, String> cR() {
            return this.uG;
        }

        public long cS() {
            return this.uH;
        }

        public List<fd> cT() {
            return this.uJ;
        }

        public String getPath() {
            return this.uI;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PATH: ");
            stringBuilder.append(this.uI);
            if (this.uG != null) {
                stringBuilder.append("  PARAMS: ");
                for (Entry entry : this.uG.entrySet()) {
                    stringBuilder.append((String) entry.getKey());
                    stringBuilder.append("=");
                    stringBuilder.append((String) entry.getValue());
                    stringBuilder.append(",  ");
                }
            }
            return stringBuilder.toString();
        }
    }

    private class C0132e extends TimerTask {
        final /* synthetic */ C0588s uw;

        private C0132e(C0588s c0588s) {
            this.uw = c0588s;
        }

        public void run() {
            this.uw.cP();
        }
    }

    class C05871 implements C0116i {
        final /* synthetic */ C0588s uw;

        C05871(C0588s c0588s) {
            this.uw = c0588s;
        }

        public long currentTimeMillis() {
            return System.currentTimeMillis();
        }
    }

    C0588s(Context context, C0114f c0114f) {
        this(context, c0114f, null, GoogleAnalytics.getInstance(context));
    }

    C0588s(Context context, C0114f c0114f, C0112d c0112d, GoogleAnalytics googleAnalytics) {
        this.um = new ConcurrentLinkedQueue();
        this.uv = 300000;
        this.uk = c0112d;
        this.mContext = context;
        this.tV = c0114f;
        this.ul = googleAnalytics;
        this.uu = new C05871(this);
        this.un = 0;
        this.ui = C0128a.DISCONNECTED;
    }

    private Timer m1926a(Timer timer) {
        if (timer != null) {
            timer.cancel();
        }
        return null;
    }

    private synchronized void bs() {
        if (this.uj != null && this.ui == C0128a.CONNECTED_SERVICE) {
            this.ui = C0128a.PENDING_DISCONNECT;
            this.uj.disconnect();
        }
    }

    private void cK() {
        this.uo = m1926a(this.uo);
        this.up = m1926a(this.up);
        this.uq = m1926a(this.uq);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void cM() {
        /*
        r7 = this;
        monitor-enter(r7);
        r1 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0074 }
        r2 = r7.tV;	 Catch:{ all -> 0x0074 }
        r2 = r2.getThread();	 Catch:{ all -> 0x0074 }
        r1 = r1.equals(r2);	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x0021;
    L_0x0011:
        r1 = r7.tV;	 Catch:{ all -> 0x0074 }
        r1 = r1.ct();	 Catch:{ all -> 0x0074 }
        r2 = new com.google.android.gms.analytics.s$2;	 Catch:{ all -> 0x0074 }
        r2.<init>(r7);	 Catch:{ all -> 0x0074 }
        r1.add(r2);	 Catch:{ all -> 0x0074 }
    L_0x001f:
        monitor-exit(r7);
        return;
    L_0x0021:
        r1 = r7.ur;	 Catch:{ all -> 0x0074 }
        if (r1 == 0) goto L_0x0028;
    L_0x0025:
        r7.cl();	 Catch:{ all -> 0x0074 }
    L_0x0028:
        r1 = com.google.android.gms.analytics.C0588s.C01273.ux;	 Catch:{ all -> 0x0074 }
        r2 = r7.ui;	 Catch:{ all -> 0x0074 }
        r2 = r2.ordinal();	 Catch:{ all -> 0x0074 }
        r1 = r1[r2];	 Catch:{ all -> 0x0074 }
        switch(r1) {
            case 1: goto L_0x0036;
            case 2: goto L_0x007f;
            case 3: goto L_0x0035;
            case 4: goto L_0x0035;
            case 5: goto L_0x0035;
            case 6: goto L_0x00da;
            default: goto L_0x0035;
        };	 Catch:{ all -> 0x0074 }
    L_0x0035:
        goto L_0x001f;
    L_0x0036:
        r1 = r7.um;	 Catch:{ all -> 0x0074 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x0077;
    L_0x003e:
        r1 = r7.um;	 Catch:{ all -> 0x0074 }
        r1 = r1.poll();	 Catch:{ all -> 0x0074 }
        r0 = r1;
        r0 = (com.google.android.gms.analytics.C0588s.C0131d) r0;	 Catch:{ all -> 0x0074 }
        r6 = r0;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
        r1.<init>();	 Catch:{ all -> 0x0074 }
        r2 = "Sending hit to store  ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0074 }
        r1 = r1.append(r6);	 Catch:{ all -> 0x0074 }
        r1 = r1.toString();	 Catch:{ all -> 0x0074 }
        com.google.android.gms.analytics.aa.m39C(r1);	 Catch:{ all -> 0x0074 }
        r1 = r7.tU;	 Catch:{ all -> 0x0074 }
        r2 = r6.cR();	 Catch:{ all -> 0x0074 }
        r3 = r6.cS();	 Catch:{ all -> 0x0074 }
        r5 = r6.getPath();	 Catch:{ all -> 0x0074 }
        r6 = r6.cT();	 Catch:{ all -> 0x0074 }
        r1.mo837a(r2, r3, r5, r6);	 Catch:{ all -> 0x0074 }
        goto L_0x0036;
    L_0x0074:
        r1 = move-exception;
        monitor-exit(r7);
        throw r1;
    L_0x0077:
        r1 = r7.tX;	 Catch:{ all -> 0x0074 }
        if (r1 == 0) goto L_0x001f;
    L_0x007b:
        r7.cN();	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
    L_0x007f:
        r1 = r7.um;	 Catch:{ all -> 0x0074 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x00d0;
    L_0x0087:
        r1 = r7.um;	 Catch:{ all -> 0x0074 }
        r1 = r1.peek();	 Catch:{ all -> 0x0074 }
        r0 = r1;
        r0 = (com.google.android.gms.analytics.C0588s.C0131d) r0;	 Catch:{ all -> 0x0074 }
        r6 = r0;
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0074 }
        r1.<init>();	 Catch:{ all -> 0x0074 }
        r2 = "Sending hit to service   ";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0074 }
        r1 = r1.append(r6);	 Catch:{ all -> 0x0074 }
        r1 = r1.toString();	 Catch:{ all -> 0x0074 }
        com.google.android.gms.analytics.aa.m39C(r1);	 Catch:{ all -> 0x0074 }
        r1 = r7.ul;	 Catch:{ all -> 0x0074 }
        r1 = r1.isDryRunEnabled();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x00ca;
    L_0x00af:
        r1 = r7.uj;	 Catch:{ all -> 0x0074 }
        r2 = r6.cR();	 Catch:{ all -> 0x0074 }
        r3 = r6.cS();	 Catch:{ all -> 0x0074 }
        r5 = r6.getPath();	 Catch:{ all -> 0x0074 }
        r6 = r6.cT();	 Catch:{ all -> 0x0074 }
        r1.mo849a(r2, r3, r5, r6);	 Catch:{ all -> 0x0074 }
    L_0x00c4:
        r1 = r7.um;	 Catch:{ all -> 0x0074 }
        r1.poll();	 Catch:{ all -> 0x0074 }
        goto L_0x007f;
    L_0x00ca:
        r1 = "Dry run enabled. Hit not actually sent to service.";
        com.google.android.gms.analytics.aa.m39C(r1);	 Catch:{ all -> 0x0074 }
        goto L_0x00c4;
    L_0x00d0:
        r1 = r7.uu;	 Catch:{ all -> 0x0074 }
        r1 = r1.currentTimeMillis();	 Catch:{ all -> 0x0074 }
        r7.uh = r1;	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
    L_0x00da:
        r1 = "Need to reconnect";
        com.google.android.gms.analytics.aa.m39C(r1);	 Catch:{ all -> 0x0074 }
        r1 = r7.um;	 Catch:{ all -> 0x0074 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x0074 }
        if (r1 != 0) goto L_0x001f;
    L_0x00e7:
        r7.cP();	 Catch:{ all -> 0x0074 }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.s.cM():void");
    }

    private void cN() {
        this.tU.cq();
        this.tX = false;
    }

    private synchronized void cO() {
        if (this.ui != C0128a.CONNECTED_LOCAL) {
            cK();
            aa.m39C("falling back to local store");
            if (this.uk != null) {
                this.tU = this.uk;
            } else {
                C0586r cE = C0586r.cE();
                cE.m1923a(this.mContext, this.tV);
                this.tU = cE.cH();
            }
            this.ui = C0128a.CONNECTED_LOCAL;
            cM();
        }
    }

    private synchronized void cP() {
        if (this.ut || this.uj == null || this.ui == C0128a.CONNECTED_LOCAL) {
            aa.m40D("client not initialized.");
            cO();
        } else {
            try {
                this.un++;
                m1926a(this.up);
                this.ui = C0128a.CONNECTING;
                this.up = new Timer("Failed Connect");
                this.up.schedule(new C0130c(), 3000);
                aa.m39C("connecting to Analytics service");
                this.uj.connect();
            } catch (SecurityException e) {
                aa.m40D("security exception on connectToService");
                cO();
            }
        }
    }

    private void cQ() {
        this.uo = m1926a(this.uo);
        this.uo = new Timer("Service Reconnect");
        this.uo.schedule(new C0132e(), 5000);
    }

    public synchronized void mo865a(int i, Intent intent) {
        this.ui = C0128a.PENDING_CONNECTION;
        if (this.un < 2) {
            aa.m40D("Service unavailable (code=" + i + "), will retry.");
            cQ();
        } else {
            aa.m40D("Service unavailable (code=" + i + "), using local store.");
            cO();
        }
    }

    public void mo866b(Map<String, String> map, long j, String str, List<fd> list) {
        aa.m39C("putHit called");
        this.um.add(new C0131d(map, j, str, list));
        cM();
    }

    public void cL() {
        if (this.uj == null) {
            this.uj = new C0581c(this.mContext, this, this);
            cP();
        }
    }

    public void cl() {
        aa.m39C("clearHits called");
        this.um.clear();
        switch (this.ui) {
            case CONNECTED_LOCAL:
                this.tU.mo840l(0);
                this.ur = false;
                return;
            case CONNECTED_SERVICE:
                this.uj.cl();
                this.ur = false;
                return;
            default:
                this.ur = true;
                return;
        }
    }

    public void cq() {
        switch (this.ui) {
            case CONNECTED_LOCAL:
                cN();
                return;
            case CONNECTED_SERVICE:
                return;
            default:
                this.tX = true;
                return;
        }
    }

    public synchronized void cs() {
        if (!this.ut) {
            aa.m39C("setForceLocalDispatch called.");
            this.ut = true;
            switch (this.ui) {
                case CONNECTED_LOCAL:
                case PENDING_CONNECTION:
                case PENDING_DISCONNECT:
                case DISCONNECTED:
                    break;
                case CONNECTED_SERVICE:
                    bs();
                    break;
                case CONNECTING:
                    this.us = true;
                    break;
                default:
                    break;
            }
        }
    }

    public synchronized void onConnected() {
        this.up = m1926a(this.up);
        this.un = 0;
        aa.m39C("Connected to service");
        this.ui = C0128a.CONNECTED_SERVICE;
        if (this.us) {
            bs();
            this.us = false;
        } else {
            cM();
            this.uq = m1926a(this.uq);
            this.uq = new Timer("disconnect check");
            this.uq.schedule(new C0129b(), this.uv);
        }
    }

    public synchronized void onDisconnected() {
        if (this.ui == C0128a.PENDING_DISCONNECT) {
            aa.m39C("Disconnected from service");
            cK();
            this.ui = C0128a.DISCONNECTED;
        } else {
            aa.m39C("Unexpected disconnect.");
            this.ui = C0128a.PENDING_CONNECTION;
            if (this.un < 2) {
                cQ();
            } else {
                cO();
            }
        }
    }
}
