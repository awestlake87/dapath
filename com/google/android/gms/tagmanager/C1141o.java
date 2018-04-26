package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.C0153a.C0602a;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.C0276c.C1077f;
import com.google.android.gms.internal.C0276c.C1081j;
import com.google.android.gms.internal.ij;
import com.google.android.gms.internal.il;
import com.google.android.gms.internal.le.C1114a;
import com.google.android.gms.tagmanager.C1140n.C0481a;
import com.google.android.gms.tagmanager.bg.C0454a;
import com.google.android.gms.tagmanager.cd.C0456a;
import com.google.android.gms.tagmanager.cq.C0464c;

class C1141o extends C0602a<ContainerHolder> {
    private final Looper DF;
    private final TagManager aeF;
    private final C0948d aeI;
    private final cf aeJ;
    private final int aeK;
    private C0950f aeL;
    private volatile C1140n aeM;
    private volatile boolean aeN;
    private C1081j aeO;
    private String aeP;
    private C0949e aeQ;
    private C0483a aeR;
    private final ij aef;
    private final String aet;
    private long aey;
    private final Context mContext;

    interface C0483a {
        boolean mo2349b(Container container);
    }

    class C09441 implements C0481a {
        final /* synthetic */ C1141o aeS;

        C09441(C1141o c1141o) {
            this.aeS = c1141o;
        }

        public void bJ(String str) {
            this.aeS.bJ(str);
        }

        public String lo() {
            return this.aeS.lo();
        }

        public void lq() {
            bh.m1645D("Refresh ignored: container loaded as default only.");
        }
    }

    private class C0946b implements bg<C1114a> {
        final /* synthetic */ C1141o aeS;

        private C0946b(C1141o c1141o) {
            this.aeS = c1141o;
        }

        public void m3030a(C1114a c1114a) {
            C1081j c1081j;
            if (c1114a.aiH != null) {
                c1081j = c1114a.aiH;
            } else {
                C1077f c1077f = c1114a.fK;
                c1081j = new C1081j();
                c1081j.fK = c1077f;
                c1081j.fJ = null;
                c1081j.fL = c1077f.fg;
            }
            this.aeS.m3837a(c1081j, c1114a.aiG, true);
        }

        public void mo2350a(C0454a c0454a) {
            if (!this.aeS.aeN) {
                this.aeS.m3847w(0);
            }
        }

        public /* synthetic */ void mo2351i(Object obj) {
            m3030a((C1114a) obj);
        }

        public void lv() {
        }
    }

    private class C0947c implements bg<C1081j> {
        final /* synthetic */ C1141o aeS;

        private C0947c(C1141o c1141o) {
            this.aeS = c1141o;
        }

        public void mo2350a(C0454a c0454a) {
            if (this.aeS.aeM != null) {
                this.aeS.m1984b(this.aeS.aeM);
            } else {
                this.aeS.m1984b(this.aeS.ap(Status.Eq));
            }
            this.aeS.m3847w(3600000);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void m3034b(com.google.android.gms.internal.C0276c.C1081j r6) {
            /*
            r5 = this;
            r1 = r5.aeS;
            monitor-enter(r1);
            r0 = r6.fK;	 Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x002a;
        L_0x0007:
            r0 = r5.aeS;	 Catch:{ all -> 0x0065 }
            r0 = r0.aeO;	 Catch:{ all -> 0x0065 }
            r0 = r0.fK;	 Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x0020;
        L_0x0011:
            r0 = "Current resource is null; network resource is also null";
            com.google.android.gms.tagmanager.bh.m1642A(r0);	 Catch:{ all -> 0x0065 }
            r0 = r5.aeS;	 Catch:{ all -> 0x0065 }
            r2 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
            r0.m3847w(r2);	 Catch:{ all -> 0x0065 }
            monitor-exit(r1);	 Catch:{ all -> 0x0065 }
        L_0x001f:
            return;
        L_0x0020:
            r0 = r5.aeS;	 Catch:{ all -> 0x0065 }
            r0 = r0.aeO;	 Catch:{ all -> 0x0065 }
            r0 = r0.fK;	 Catch:{ all -> 0x0065 }
            r6.fK = r0;	 Catch:{ all -> 0x0065 }
        L_0x002a:
            r0 = r5.aeS;	 Catch:{ all -> 0x0065 }
            r2 = r5.aeS;	 Catch:{ all -> 0x0065 }
            r2 = r2.aef;	 Catch:{ all -> 0x0065 }
            r2 = r2.currentTimeMillis();	 Catch:{ all -> 0x0065 }
            r4 = 0;
            r0.m3837a(r6, r2, r4);	 Catch:{ all -> 0x0065 }
            r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0065 }
            r0.<init>();	 Catch:{ all -> 0x0065 }
            r2 = "setting refresh time to current time: ";
            r0 = r0.append(r2);	 Catch:{ all -> 0x0065 }
            r2 = r5.aeS;	 Catch:{ all -> 0x0065 }
            r2 = r2.aey;	 Catch:{ all -> 0x0065 }
            r0 = r0.append(r2);	 Catch:{ all -> 0x0065 }
            r0 = r0.toString();	 Catch:{ all -> 0x0065 }
            com.google.android.gms.tagmanager.bh.m1644C(r0);	 Catch:{ all -> 0x0065 }
            r0 = r5.aeS;	 Catch:{ all -> 0x0065 }
            r0 = r0.lu();	 Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x0063;
        L_0x005e:
            r0 = r5.aeS;	 Catch:{ all -> 0x0065 }
            r0.m3836a(r6);	 Catch:{ all -> 0x0065 }
        L_0x0063:
            monitor-exit(r1);	 Catch:{ all -> 0x0065 }
            goto L_0x001f;
        L_0x0065:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0065 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.o.c.b(com.google.android.gms.internal.c$j):void");
        }

        public /* synthetic */ void mo2351i(Object obj) {
            m3034b((C1081j) obj);
        }

        public void lv() {
        }
    }

    private class C0948d implements C0481a {
        final /* synthetic */ C1141o aeS;

        private C0948d(C1141o c1141o) {
            this.aeS = c1141o;
        }

        public void bJ(String str) {
            this.aeS.bJ(str);
        }

        public String lo() {
            return this.aeS.lo();
        }

        public void lq() {
            if (this.aeS.aeJ.mo2302do()) {
                this.aeS.m3847w(0);
            }
        }
    }

    interface C0949e extends Releasable {
        void mo3104a(bg<C1081j> bgVar);

        void bM(String str);

        void mo3106e(long j, String str);
    }

    interface C0950f extends Releasable {
        void mo3107a(bg<C1114a> bgVar);

        void mo3108b(C1114a c1114a);

        C0464c dn(int i);

        void lw();
    }

    C1141o(Context context, TagManager tagManager, Looper looper, String str, int i, C0950f c0950f, C0949e c0949e, ij ijVar, cf cfVar) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.mContext = context;
        this.aeF = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.DF = looper;
        this.aet = str;
        this.aeK = i;
        this.aeL = c0950f;
        this.aeQ = c0949e;
        this.aeI = new C0948d();
        this.aeO = new C1081j();
        this.aef = ijVar;
        this.aeJ = cfVar;
        if (lu()) {
            bJ(cd.md().mf());
        }
    }

    public C1141o(Context context, TagManager tagManager, Looper looper, String str, int i, C0484r c0484r) {
        this(context, tagManager, looper, str, i, new cp(context, str), new co(context, str, c0484r), il.gb(), new bf(30, 900000, 5000, "refreshing", il.gb()));
    }

    private void m3834H(final boolean z) {
        this.aeL.mo3107a(new C0946b());
        this.aeQ.mo3104a(new C0947c());
        C0464c dn = this.aeL.dn(this.aeK);
        if (dn != null) {
            this.aeM = new C1140n(this.aeF, this.DF, new Container(this.mContext, this.aeF.getDataLayer(), this.aet, 0, dn), this.aeI);
        }
        this.aeR = new C0483a(this) {
            final /* synthetic */ C1141o aeS;

            public boolean mo2349b(Container container) {
                return z ? container.getLastRefreshTime() + 43200000 >= this.aeS.aef.currentTimeMillis() : !container.isDefault();
            }
        };
        if (lu()) {
            this.aeQ.mo3106e(0, "");
        } else {
            this.aeL.lw();
        }
    }

    private synchronized void m3836a(C1081j c1081j) {
        if (this.aeL != null) {
            C1114a c1114a = new C1114a();
            c1114a.aiG = this.aey;
            c1114a.fK = new C1077f();
            c1114a.aiH = c1081j;
            this.aeL.mo3108b(c1114a);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m3837a(com.google.android.gms.internal.C0276c.C1081j r9, long r10, boolean r12) {
        /*
        r8 = this;
        r6 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        monitor-enter(r8);
        if (r12 == 0) goto L_0x000c;
    L_0x0006:
        r0 = r8.aeN;	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r8);
        return;
    L_0x000c:
        r0 = r8.isReady();	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x0016;
    L_0x0012:
        r0 = r8.aeM;	 Catch:{ all -> 0x006a }
        if (r0 != 0) goto L_0x0016;
    L_0x0016:
        r8.aeO = r9;	 Catch:{ all -> 0x006a }
        r8.aey = r10;	 Catch:{ all -> 0x006a }
        r0 = 0;
        r2 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        r4 = r8.aey;	 Catch:{ all -> 0x006a }
        r4 = r4 + r6;
        r6 = r8.aef;	 Catch:{ all -> 0x006a }
        r6 = r6.currentTimeMillis();	 Catch:{ all -> 0x006a }
        r4 = r4 - r6;
        r2 = java.lang.Math.min(r2, r4);	 Catch:{ all -> 0x006a }
        r0 = java.lang.Math.max(r0, r2);	 Catch:{ all -> 0x006a }
        r8.m3847w(r0);	 Catch:{ all -> 0x006a }
        r0 = new com.google.android.gms.tagmanager.Container;	 Catch:{ all -> 0x006a }
        r1 = r8.mContext;	 Catch:{ all -> 0x006a }
        r2 = r8.aeF;	 Catch:{ all -> 0x006a }
        r2 = r2.getDataLayer();	 Catch:{ all -> 0x006a }
        r3 = r8.aet;	 Catch:{ all -> 0x006a }
        r4 = r10;
        r6 = r9;
        r0.<init>(r1, r2, r3, r4, r6);	 Catch:{ all -> 0x006a }
        r1 = r8.aeM;	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x006d;
    L_0x0049:
        r1 = new com.google.android.gms.tagmanager.n;	 Catch:{ all -> 0x006a }
        r2 = r8.aeF;	 Catch:{ all -> 0x006a }
        r3 = r8.DF;	 Catch:{ all -> 0x006a }
        r4 = r8.aeI;	 Catch:{ all -> 0x006a }
        r1.<init>(r2, r3, r0, r4);	 Catch:{ all -> 0x006a }
        r8.aeM = r1;	 Catch:{ all -> 0x006a }
    L_0x0056:
        r1 = r8.isReady();	 Catch:{ all -> 0x006a }
        if (r1 != 0) goto L_0x000a;
    L_0x005c:
        r1 = r8.aeR;	 Catch:{ all -> 0x006a }
        r0 = r1.mo2349b(r0);	 Catch:{ all -> 0x006a }
        if (r0 == 0) goto L_0x000a;
    L_0x0064:
        r0 = r8.aeM;	 Catch:{ all -> 0x006a }
        r8.m1984b(r0);	 Catch:{ all -> 0x006a }
        goto L_0x000a;
    L_0x006a:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x006d:
        r1 = r8.aeM;	 Catch:{ all -> 0x006a }
        r1.m3833a(r0);	 Catch:{ all -> 0x006a }
        goto L_0x0056;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.o.a(com.google.android.gms.internal.c$j, long, boolean):void");
    }

    private boolean lu() {
        cd md = cd.md();
        return (md.me() == C0456a.CONTAINER || md.me() == C0456a.CONTAINER_DEBUG) && this.aet.equals(md.getContainerId());
    }

    private synchronized void m3847w(long j) {
        if (this.aeQ == null) {
            bh.m1645D("Refresh requested, but no network load scheduler.");
        } else {
            this.aeQ.mo3106e(j, this.aeO.fL);
        }
    }

    protected ContainerHolder ap(Status status) {
        if (this.aeM != null) {
            return this.aeM;
        }
        if (status == Status.Eq) {
            bh.m1642A("timer expired: setting result to failure");
        }
        return new C1140n(status);
    }

    synchronized void bJ(String str) {
        this.aeP = str;
        if (this.aeQ != null) {
            this.aeQ.bM(str);
        }
    }

    protected /* synthetic */ Result mo2535c(Status status) {
        return ap(status);
    }

    synchronized String lo() {
        return this.aeP;
    }

    public void lr() {
        C0464c dn = this.aeL.dn(this.aeK);
        if (dn != null) {
            m1984b(new C1140n(this.aeF, this.DF, new Container(this.mContext, this.aeF.getDataLayer(), this.aet, 0, dn), new C09441(this)));
        } else {
            String str = "Default was requested, but no default container was found";
            bh.m1642A(str);
            m1984b(ap(new Status(10, str, null)));
        }
        this.aeQ = null;
        this.aeL = null;
    }

    public void ls() {
        m3834H(false);
    }

    public void lt() {
        m3834H(true);
    }
}
