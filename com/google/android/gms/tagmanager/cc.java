package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0272b;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;

abstract class cc extends aj {
    private static final String afy = C0272b.ARG0.toString();
    private static final String agv = C0272b.ARG1.toString();

    public cc(String str) {
        super(str, afy, agv);
    }

    protected abstract boolean mo3103a(C1082a c1082a, C1082a c1082a2, Map<String, C1082a> map);

    public boolean lh() {
        return true;
    }

    public C1082a mo2295w(Map<String, C1082a> map) {
        for (C1082a c1082a : map.values()) {
            if (c1082a == dh.nd()) {
                return dh.m1733r(Boolean.valueOf(false));
            }
        }
        C1082a c1082a2 = (C1082a) map.get(afy);
        C1082a c1082a3 = (C1082a) map.get(agv);
        boolean a = (c1082a2 == null || c1082a3 == null) ? false : mo3103a(c1082a2, c1082a3, map);
        return dh.m1733r(Boolean.valueOf(a));
    }
}
