package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0272b;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;

class ax extends aj {
    private static final String ID = C0268a.INSTALL_REFERRER.toString();
    private static final String aek = C0272b.COMPONENT.toString();
    private final Context kO;

    public ax(Context context) {
        super(ID, new String[0]);
        this.kO = context;
    }

    public boolean lh() {
        return true;
    }

    public C1082a mo2295w(Map<String, C1082a> map) {
        String e = ay.m1635e(this.kO, ((C1082a) map.get(aek)) != null ? dh.m1722j((C1082a) map.get(aek)) : null);
        return e != null ? dh.m1733r(e) : dh.nd();
    }
}
