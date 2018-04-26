package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;

class C1200q extends dc {
    private static final String ID = C0268a.CONTAINS.toString();

    public C1200q() {
        super(ID);
    }

    protected boolean mo3147a(String str, String str2, Map<String, C1082a> map) {
        return str.contains(str2);
    }
}
