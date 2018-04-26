package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;

abstract class bx extends cc {
    public bx(String str) {
        super(str);
    }

    protected boolean mo3103a(C1082a c1082a, C1082a c1082a2, Map<String, C1082a> map) {
        dg k = dh.m1723k(c1082a);
        dg k2 = dh.m1723k(c1082a2);
        return (k == dh.nb() || k2 == dh.nb()) ? false : mo3148a(k, k2, (Map) map);
    }

    protected abstract boolean mo3148a(dg dgVar, dg dgVar2, Map<String, C1082a> map);
}
