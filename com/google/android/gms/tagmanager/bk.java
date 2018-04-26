package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;

class bk extends aj {
    private static final String ID = C0268a.MOBILE_ADWORDS_UNIQUE_ID.toString();
    private final Context mContext;

    public bk(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    protected String m2965O(Context context) {
        return Secure.getString(context.getContentResolver(), "android_id");
    }

    public boolean lh() {
        return true;
    }

    public C1082a mo2295w(Map<String, C1082a> map) {
        String O = m2965O(this.mContext);
        return O == null ? dh.nd() : dh.m1733r(O);
    }
}
