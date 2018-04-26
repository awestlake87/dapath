package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0272b;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;

class C0937e extends aj {
    private static final String ID = C0268a.ADWORDS_CLICK_REFERRER.toString();
    private static final String aek = C0272b.COMPONENT.toString();
    private static final String ael = C0272b.CONVERSION_ID.toString();
    private final Context kO;

    public C0937e(Context context) {
        super(ID, ael);
        this.kO = context;
    }

    public boolean lh() {
        return true;
    }

    public C1082a mo2295w(Map<String, C1082a> map) {
        C1082a c1082a = (C1082a) map.get(ael);
        if (c1082a == null) {
            return dh.nd();
        }
        String j = dh.m1722j(c1082a);
        c1082a = (C1082a) map.get(aek);
        String d = ay.m1633d(this.kO, j, c1082a != null ? dh.m1722j(c1082a) : null);
        return d != null ? dh.m1733r(d) : dh.nd();
    }
}
