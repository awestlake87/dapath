package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;

class bz extends aj {
    private static final String ID = C0268a.OS_VERSION.toString();

    public bz() {
        super(ID, new String[0]);
    }

    public boolean lh() {
        return true;
    }

    public C1082a mo2295w(Map<String, C1082a> map) {
        return dh.m1733r(VERSION.RELEASE);
    }
}
