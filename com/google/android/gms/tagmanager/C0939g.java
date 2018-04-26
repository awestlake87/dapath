package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;

class C0939g extends aj {
    private static final String ID = C0268a.APP_NAME.toString();
    private final Context mContext;

    public C0939g(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean lh() {
        return true;
    }

    public C1082a mo2295w(Map<String, C1082a> map) {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            return dh.m1733r(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
        } catch (Throwable e) {
            bh.m1646b("App name is not found.", e);
            return dh.nd();
        }
    }
}
