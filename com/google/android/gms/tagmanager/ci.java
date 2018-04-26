package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;

class ci extends aj {
    private static final String ID = C0268a.RESOLUTION.toString();
    private final Context mContext;

    public ci(Context context) {
        super(ID, new String[0]);
        this.mContext = context;
    }

    public boolean lh() {
        return true;
    }

    public C1082a mo2295w(Map<String, C1082a> map) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        return dh.m1733r(i + "x" + displayMetrics.heightPixels);
    }
}
