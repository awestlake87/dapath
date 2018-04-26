package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;

class C0924b extends aj {
    private static final String ID = C0268a.ADVERTISER_ID.toString();
    private final C0449a aej;

    public C0924b(Context context) {
        this(C0449a.m1617M(context));
    }

    C0924b(C0449a c0449a) {
        super(ID, new String[0]);
        this.aej = c0449a;
    }

    public boolean lh() {
        return false;
    }

    public C1082a mo2295w(Map<String, C1082a> map) {
        String ld = this.aej.ld();
        return ld == null ? dh.nd() : dh.m1733r(ld);
    }
}
