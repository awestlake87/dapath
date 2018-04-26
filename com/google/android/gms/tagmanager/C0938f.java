package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;

class C0938f extends aj {
    private static final String ID = C0268a.APP_ID.toString();
    private final Context mContext;

    public C0938f(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean lh() {
        return true;
    }

    public C1082a mo2295w(Map<String, C1082a> map) {
        return dh.m1733r(this.mContext.getPackageName());
    }
}
