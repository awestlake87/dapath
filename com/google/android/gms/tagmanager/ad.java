package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;

class ad extends dc {
    private static final String ID = C0268a.ENDS_WITH.toString();

    public ad() {
        super(ID);
    }

    protected boolean mo3147a(String str, String str2, Map<String, C1082a> map) {
        return str.endsWith(str2);
    }
}