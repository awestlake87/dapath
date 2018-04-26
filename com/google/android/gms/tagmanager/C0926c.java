package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;

class C0926c extends aj {
    private static final String ID = C0268a.ADVERTISING_TRACKING_ENABLED.toString();
    private final C0449a aej;

    public C0926c(Context context) {
        this(C0449a.m1617M(context));
    }

    C0926c(C0449a c0449a) {
        super(ID, new String[0]);
        this.aej = c0449a;
    }

    public boolean lh() {
        return false;
    }

    public C1082a mo2295w(Map<String, C1082a> map) {
        return dh.m1733r(Boolean.valueOf(!this.aej.isLimitAdTrackingEnabled()));
    }
}
