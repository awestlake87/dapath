package com.google.android.gms.tagmanager;

import android.os.Build;
import android.support.v4.os.EnvironmentCompat;
import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;

class aa extends aj {
    private static final String ID = C0268a.DEVICE_NAME.toString();

    public aa() {
        super(ID, new String[0]);
    }

    public boolean lh() {
        return true;
    }

    public C1082a mo2295w(Map<String, C1082a> map) {
        String str = Build.MANUFACTURER;
        Object obj = Build.MODEL;
        if (!(obj.startsWith(str) || str.equals(EnvironmentCompat.MEDIA_UNKNOWN))) {
            obj = str + " " + obj;
        }
        return dh.m1733r(obj);
    }
}
