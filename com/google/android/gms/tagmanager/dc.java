package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;

abstract class dc extends cc {
    public dc(String str) {
        super(str);
    }

    protected boolean mo3103a(C1082a c1082a, C1082a c1082a2, Map<String, C1082a> map) {
        String j = dh.m1722j(c1082a);
        String j2 = dh.m1722j(c1082a2);
        return (j == dh.nc() || j2 == dh.nc()) ? false : mo3147a(j, j2, (Map) map);
    }

    protected abstract boolean mo3147a(String str, String str2, Map<String, C1082a> map);
}
