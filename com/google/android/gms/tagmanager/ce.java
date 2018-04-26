package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0272b;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;

class ce extends aj {
    private static final String ID = C0268a.RANDOM.toString();
    private static final String agF = C0272b.MIN.toString();
    private static final String agG = C0272b.MAX.toString();

    public ce() {
        super(ID, new String[0]);
    }

    public boolean lh() {
        return false;
    }

    public C1082a mo2295w(Map<String, C1082a> map) {
        double doubleValue;
        double d;
        C1082a c1082a = (C1082a) map.get(agF);
        C1082a c1082a2 = (C1082a) map.get(agG);
        if (!(c1082a == null || c1082a == dh.nd() || c1082a2 == null || c1082a2 == dh.nd())) {
            dg k = dh.m1723k(c1082a);
            dg k2 = dh.m1723k(c1082a2);
            if (!(k == dh.nb() || k2 == dh.nb())) {
                double doubleValue2 = k.doubleValue();
                doubleValue = k2.doubleValue();
                if (doubleValue2 <= doubleValue) {
                    d = doubleValue2;
                    return dh.m1733r(Long.valueOf(Math.round(((doubleValue - d) * Math.random()) + d)));
                }
            }
        }
        doubleValue = 2.147483647E9d;
        d = 0.0d;
        return dh.m1733r(Long.valueOf(Math.round(((doubleValue - d) * Math.random()) + d)));
    }
}
