package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0272b;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;

class C0953u extends aj {
    private static final String ID = C0268a.CUSTOM_VAR.toString();
    private static final String NAME = C0272b.NAME.toString();
    private static final String afi = C0272b.DEFAULT_VALUE.toString();
    private final DataLayer aeu;

    public C0953u(DataLayer dataLayer) {
        super(ID, NAME);
        this.aeu = dataLayer;
    }

    public boolean lh() {
        return false;
    }

    public C1082a mo2295w(Map<String, C1082a> map) {
        Object obj = this.aeu.get(dh.m1722j((C1082a) map.get(NAME)));
        if (obj != null) {
            return dh.m1733r(obj);
        }
        C1082a c1082a = (C1082a) map.get(afi);
        return c1082a != null ? c1082a : dh.nd();
    }
}
