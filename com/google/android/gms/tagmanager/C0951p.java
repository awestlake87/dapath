package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;

class C0951p extends aj {
    private static final String ID = C0268a.CONTAINER_VERSION.toString();
    private final String aeU;

    public C0951p(String str) {
        super(ID, new String[0]);
        this.aeU = str;
    }

    public boolean lh() {
        return true;
    }

    public C1082a mo2295w(Map<String, C1082a> map) {
        return this.aeU == null ? dh.nd() : dh.m1733r(this.aeU);
    }
}
