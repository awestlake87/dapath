package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;

class C0940h extends aj {
    private static final String ID = C0268a.APP_VERSION.toString();
    private final Context mContext;

    public C0940h(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean lh() {
        return true;
    }

    public C1082a mo2295w(Map<String, C1082a> map) {
        try {
            return dh.m1733r(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
        } catch (NameNotFoundException e) {
            bh.m1642A("Package name " + this.mContext.getPackageName() + " not found. " + e.getMessage());
            return dh.nd();
        }
    }
}
