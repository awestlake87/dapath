package com.google.android.gms.internal;

import java.util.Map;

public final class dz {
    private ex lN;
    private final Object ls = new Object();
    private int pJ = -2;
    private String qB;
    private eb qC;
    public final bc qD = new C07131(this);
    public final bc qE = new C07142(this);

    class C07131 implements bc {
        final /* synthetic */ dz qF;

        C07131(dz dzVar) {
            this.qF = dzVar;
        }

        public void mo1576b(ex exVar, Map<String, String> map) {
            synchronized (this.qF.ls) {
                eb ebVar = new eb(map);
                eu.m1014D("Invalid " + ebVar.getType() + " request error: " + ebVar.by());
                this.qF.pJ = 1;
                this.qF.ls.notify();
            }
        }
    }

    class C07142 implements bc {
        final /* synthetic */ dz qF;

        C07142(dz dzVar) {
            this.qF = dzVar;
        }

        public void mo1576b(ex exVar, Map<String, String> map) {
            synchronized (this.qF.ls) {
                eb ebVar = new eb(map);
                String url = ebVar.getUrl();
                if (url == null) {
                    eu.m1014D("URL missing in loadAdUrl GMSG.");
                    return;
                }
                if (url.contains("%40mediation_adapters%40")) {
                    eu.m1013C("Ad request URL modified to " + url.replaceAll("%40mediation_adapters%40", el.m966a(exVar.getContext(), (String) map.get("check_adapters"), this.qF.qB)));
                }
                this.qF.qC = ebVar;
                this.qF.ls.notify();
            }
        }
    }

    public dz(String str) {
        this.qB = str;
    }

    public void m928b(ex exVar) {
        synchronized (this.ls) {
            this.lN = exVar;
        }
    }

    public eb bx() {
        eb ebVar;
        synchronized (this.ls) {
            while (this.qC == null && this.pJ == -2) {
                try {
                    this.ls.wait();
                } catch (InterruptedException e) {
                    eu.m1014D("Ad request service was interrupted.");
                    ebVar = null;
                }
            }
            ebVar = this.qC;
        }
        return ebVar;
    }

    public int getErrorCode() {
        int i;
        synchronized (this.ls) {
            i = this.pJ;
        }
        return i;
    }
}
