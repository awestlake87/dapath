package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;

class ah extends aj {
    private static final String ID = C0268a.EVENT.toString();
    private final cs aev;

    public ah(cs csVar) {
        super(ID, new String[0]);
        this.aev = csVar;
    }

    public boolean lh() {
        return false;
    }

    public C1082a mo2295w(Map<String, C1082a> map) {
        String mH = this.aev.mH();
        return mH == null ? dh.nd() : dh.m1733r(mH);
    }
}
