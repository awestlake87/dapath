package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.internal.dm.C0297a;
import com.google.android.gms.internal.dp.C0305a;
import com.google.android.gms.internal.ds.C0306a;
import com.google.android.gms.internal.ey.C0318a;
import org.json.JSONException;
import org.json.JSONObject;

public class dn extends em implements C0305a, C0318a {
    private final bt kB;
    private final ex lN;
    private final Object ls = new Object();
    private final Context mContext;
    private bm nf;
    private final C0359k pA;
    private em pB;
    private du pC;
    private boolean pD = false;
    private bk pE;
    private bq pF;
    private final C0297a px;
    private final Object py = new Object();
    private final C0306a pz;

    class C02981 implements Runnable {
        final /* synthetic */ dn pG;

        C02981(dn dnVar) {
            this.pG = dnVar;
        }

        public void run() {
            this.pG.onStop();
        }
    }

    class C03003 implements Runnable {
        final /* synthetic */ dn pG;

        C03003(dn dnVar) {
            this.pG = dnVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r7 = this;
            r0 = r7.pG;
            r6 = r0.ls;
            monitor-enter(r6);
            r0 = r7.pG;	 Catch:{ all -> 0x005f }
            r0 = r0.pC;	 Catch:{ all -> 0x005f }
            r0 = r0.errorCode;	 Catch:{ all -> 0x005f }
            r1 = -2;
            if (r0 == r1) goto L_0x0014;
        L_0x0012:
            monitor-exit(r6);	 Catch:{ all -> 0x005f }
        L_0x0013:
            return;
        L_0x0014:
            r0 = r7.pG;	 Catch:{ all -> 0x005f }
            r0 = r0.lN;	 Catch:{ all -> 0x005f }
            r0 = r0.cb();	 Catch:{ all -> 0x005f }
            r1 = r7.pG;	 Catch:{ all -> 0x005f }
            r0.m1038a(r1);	 Catch:{ all -> 0x005f }
            r0 = r7.pG;	 Catch:{ all -> 0x005f }
            r0 = r0.pC;	 Catch:{ all -> 0x005f }
            r0 = r0.errorCode;	 Catch:{ all -> 0x005f }
            r1 = -3;
            if (r0 != r1) goto L_0x0062;
        L_0x002e:
            r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005f }
            r0.<init>();	 Catch:{ all -> 0x005f }
            r1 = "Loading URL in WebView: ";
            r0 = r0.append(r1);	 Catch:{ all -> 0x005f }
            r1 = r7.pG;	 Catch:{ all -> 0x005f }
            r1 = r1.pC;	 Catch:{ all -> 0x005f }
            r1 = r1.oA;	 Catch:{ all -> 0x005f }
            r0 = r0.append(r1);	 Catch:{ all -> 0x005f }
            r0 = r0.toString();	 Catch:{ all -> 0x005f }
            com.google.android.gms.internal.eu.m1013C(r0);	 Catch:{ all -> 0x005f }
            r0 = r7.pG;	 Catch:{ all -> 0x005f }
            r0 = r0.lN;	 Catch:{ all -> 0x005f }
            r1 = r7.pG;	 Catch:{ all -> 0x005f }
            r1 = r1.pC;	 Catch:{ all -> 0x005f }
            r1 = r1.oA;	 Catch:{ all -> 0x005f }
            r0.loadUrl(r1);	 Catch:{ all -> 0x005f }
        L_0x005d:
            monitor-exit(r6);	 Catch:{ all -> 0x005f }
            goto L_0x0013;
        L_0x005f:
            r0 = move-exception;
            monitor-exit(r6);	 Catch:{ all -> 0x005f }
            throw r0;
        L_0x0062:
            r0 = "Loading HTML in WebView.";
            com.google.android.gms.internal.eu.m1013C(r0);	 Catch:{ all -> 0x005f }
            r0 = r7.pG;	 Catch:{ all -> 0x005f }
            r0 = r0.lN;	 Catch:{ all -> 0x005f }
            r1 = r7.pG;	 Catch:{ all -> 0x005f }
            r1 = r1.pC;	 Catch:{ all -> 0x005f }
            r1 = r1.oA;	 Catch:{ all -> 0x005f }
            r1 = com.google.android.gms.internal.eo.m991v(r1);	 Catch:{ all -> 0x005f }
            r2 = r7.pG;	 Catch:{ all -> 0x005f }
            r2 = r2.pC;	 Catch:{ all -> 0x005f }
            r2 = r2.qe;	 Catch:{ all -> 0x005f }
            r3 = "text/html";
            r4 = "UTF-8";
            r5 = 0;
            r0.loadDataWithBaseURL(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x005f }
            goto L_0x005d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.dn.3.run():void");
        }
    }

    private static final class C0302a extends Exception {
        private final int pJ;

        public C0302a(String str, int i) {
            super(str);
            this.pJ = i;
        }

        public int getErrorCode() {
            return this.pJ;
        }
    }

    public dn(Context context, C0306a c0306a, C0359k c0359k, ex exVar, bt btVar, C0297a c0297a) {
        this.kB = btVar;
        this.px = c0297a;
        this.lN = exVar;
        this.mContext = context;
        this.pz = c0306a;
        this.pA = c0359k;
    }

    private al m2541a(ds dsVar) throws C0302a {
        if (this.pC.qj == null) {
            throw new C0302a("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.pC.qj.split("x");
        if (split.length != 2) {
            throw new C0302a("Could not parse the ad size from the ad response: " + this.pC.qj, 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (al alVar : dsVar.kT.mg) {
                float f = this.mContext.getResources().getDisplayMetrics().density;
                int i = alVar.width == -1 ? (int) (((float) alVar.widthPixels) / f) : alVar.width;
                int i2 = alVar.height == -2 ? (int) (((float) alVar.heightPixels) / f) : alVar.height;
                if (parseInt == i && parseInt2 == i2) {
                    return new al(alVar, dsVar.kT.mg);
                }
            }
            throw new C0302a("The ad size from the ad response was not one of the requested sizes: " + this.pC.qj, 0);
        } catch (NumberFormatException e) {
            throw new C0302a("Could not parse the ad size from the ad response: " + this.pC.qj, 0);
        }
    }

    private void m2543a(ds dsVar, long j) throws C0302a {
        synchronized (this.py) {
            this.pE = new bk(this.mContext, dsVar, this.kB, this.nf);
        }
        this.pF = this.pE.m833a(j, 60000);
        switch (this.pF.nL) {
            case 0:
                return;
            case 1:
                throw new C0302a("No fill from any mediation ad networks.", 3);
            default:
                throw new C0302a("Unexpected mediation result: " + this.pF.nL, 0);
        }
    }

    private void bn() throws C0302a {
        if (this.pC.errorCode != -3) {
            if (TextUtils.isEmpty(this.pC.qe)) {
                throw new C0302a("No fill from ad server.", 3);
            } else if (this.pC.qg) {
                try {
                    this.nf = new bm(this.pC.qe);
                } catch (JSONException e) {
                    throw new C0302a("Could not parse mediation config: " + this.pC.qe, 0);
                }
            }
        }
    }

    private boolean m2546c(long j) throws C0302a {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.ls.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new C0302a("Ad request cancelled.", -1);
        }
    }

    private void m2548e(long j) throws C0302a {
        et.sv.post(new C03003(this));
        m2550h(j);
    }

    private void m2549g(long j) throws C0302a {
        while (m2546c(j)) {
            if (this.pC != null) {
                synchronized (this.py) {
                    this.pB = null;
                }
                if (this.pC.errorCode != -2 && this.pC.errorCode != -3) {
                    throw new C0302a("There was a problem getting an ad response. ErrorCode: " + this.pC.errorCode, this.pC.errorCode);
                }
                return;
            }
        }
        throw new C0302a("Timed out waiting for ad response.", 2);
    }

    private void m2550h(long j) throws C0302a {
        while (m2546c(j)) {
            if (this.pD) {
                return;
            }
        }
        throw new C0302a("Timed out waiting for WebView to finish loading.", 2);
    }

    public void mo1690a(du duVar) {
        synchronized (this.ls) {
            eu.m1019z("Received ad response.");
            this.pC = duVar;
            this.ls.notify();
        }
    }

    public void mo1577a(ex exVar) {
        synchronized (this.ls) {
            eu.m1019z("WebView finished loading.");
            this.pD = true;
            this.ls.notify();
        }
    }

    public void bh() {
        synchronized (this.ls) {
            long j;
            al alVar;
            final ef efVar;
            eu.m1019z("AdLoaderBackgroundTask started.");
            C0331g z = this.pA.m1324z();
            ds dsVar = new ds(this.pz, z.mo1744b(this.mContext), z.mo1740a(this.mContext));
            al alVar2 = null;
            int i = -2;
            long j2 = -1;
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                em a = dp.m906a(this.mContext, dsVar, this);
                synchronized (this.py) {
                    this.pB = a;
                    if (this.pB == null) {
                        throw new C0302a("Could not start the ad request service.", 0);
                    }
                }
                m2549g(elapsedRealtime);
                j2 = SystemClock.elapsedRealtime();
                bn();
                if (dsVar.kT.mg != null) {
                    alVar2 = m2541a(dsVar);
                }
                if (this.pC.qg) {
                    m2543a(dsVar, elapsedRealtime);
                } else if (this.pC.qm) {
                    m2553f(elapsedRealtime);
                } else {
                    m2548e(elapsedRealtime);
                }
                j = j2;
                alVar = alVar2;
            } catch (C0302a e) {
                i = e.getErrorCode();
                if (i == 3 || i == -1) {
                    eu.m1012B(e.getMessage());
                } else {
                    eu.m1014D(e.getMessage());
                }
                if (this.pC == null) {
                    this.pC = new du(i);
                } else {
                    this.pC = new du(i, this.pC.nx);
                }
                et.sv.post(new C02981(this));
                j = j2;
                alVar = alVar2;
            }
            if (!TextUtils.isEmpty(this.pC.qo)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.pC.qo);
                } catch (Throwable e2) {
                    eu.m1016b("Error parsing the JSON for Active View.", e2);
                }
                efVar = new ef(dsVar.pX, this.lN, this.pC.nt, i, this.pC.nu, this.pC.qi, this.pC.orientation, this.pC.nx, dsVar.qa, this.pC.qg, this.pF == null ? this.pF.nM : null, this.pF == null ? this.pF.nN : null, this.pF == null ? this.pF.nO : null, this.nf, this.pF == null ? this.pF.nP : null, this.pC.qh, alVar, this.pC.qf, j, this.pC.qk, this.pC.ql, r29);
                et.sv.post(new Runnable(this) {
                    final /* synthetic */ dn pG;

                    public void run() {
                        synchronized (this.pG.ls) {
                            this.pG.px.mo3091a(efVar);
                        }
                    }
                });
            }
            JSONObject jSONObject2 = null;
            if (this.pF == null) {
            }
            if (this.pF == null) {
            }
            if (this.pF == null) {
            }
            if (this.pF == null) {
            }
            efVar = new ef(dsVar.pX, this.lN, this.pC.nt, i, this.pC.nu, this.pC.qi, this.pC.orientation, this.pC.nx, dsVar.qa, this.pC.qg, this.pF == null ? this.pF.nM : null, this.pF == null ? this.pF.nN : null, this.pF == null ? this.pF.nO : null, this.nf, this.pF == null ? this.pF.nP : null, this.pC.qh, alVar, this.pC.qf, j, this.pC.qk, this.pC.ql, jSONObject2);
            et.sv.post(/* anonymous class already generated */);
        }
    }

    protected void m2553f(long j) throws C0302a {
        int i;
        int i2;
        al V = this.lN.m1025V();
        if (V.mf) {
            i = this.mContext.getResources().getDisplayMetrics().widthPixels;
            i2 = this.mContext.getResources().getDisplayMetrics().heightPixels;
        } else {
            i = V.widthPixels;
            i2 = V.heightPixels;
        }
        final C0304do c0304do = new C0304do(this, this.lN, i, i2);
        et.sv.post(new Runnable(this) {
            final /* synthetic */ dn pG;

            public void run() {
                synchronized (this.pG.ls) {
                    if (this.pG.pC.errorCode != -2) {
                        return;
                    }
                    this.pG.lN.cb().m1038a(this.pG);
                    c0304do.m904b(this.pG.pC);
                }
            }
        });
        m2550h(j);
        if (c0304do.bq()) {
            eu.m1019z("Ad-Network indicated no fill with passback URL.");
            throw new C0302a("AdNetwork sent passback url", 3);
        } else if (!c0304do.br()) {
            throw new C0302a("AdNetwork timed out", 2);
        }
    }

    public void onStop() {
        synchronized (this.py) {
            if (this.pB != null) {
                this.pB.cancel();
            }
            this.lN.stopLoading();
            eo.m975a(this.lN);
            if (this.pE != null) {
                this.pE.cancel();
            }
        }
    }
}
