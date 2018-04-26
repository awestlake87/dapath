package com.google.android.gms.internal;

import android.content.Intent;

public class cz {
    private final String mz;

    public cz(String str) {
        this.mz = str;
    }

    public boolean m885a(String str, int i, Intent intent) {
        if (str == null || intent == null) {
            return false;
        }
        String d = cy.m881d(intent);
        String e = cy.m882e(intent);
        if (d == null || e == null) {
            return false;
        }
        if (!str.equals(cy.m883p(d))) {
            eu.m1014D("Developer payload not match.");
            return false;
        } else if (this.mz == null || da.m887b(this.mz, d, e)) {
            return true;
        } else {
            eu.m1014D("Fail to verify signature.");
            return false;
        }
    }

    public String bm() {
        return eo.bT();
    }
}
