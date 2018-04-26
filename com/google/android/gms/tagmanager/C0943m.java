package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0272b;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;

class C0943m extends aj {
    private static final String ID = C0268a.CONSTANT.toString();
    private static final String VALUE = C0272b.VALUE.toString();

    public C0943m() {
        super(ID, VALUE);
    }

    public static String lk() {
        return ID;
    }

    public static String ll() {
        return VALUE;
    }

    public boolean lh() {
        return true;
    }

    public C1082a mo2295w(Map<String, C1082a> map) {
        return (C1082a) map.get(VALUE);
    }
}
