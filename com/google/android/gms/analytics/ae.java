package com.google.android.gms.analytics;

import android.content.Context;
import android.util.DisplayMetrics;

class ae implements C0120m {
    private static Object tq = new Object();
    private static ae wZ;
    private final Context mContext;

    protected ae(Context context) {
        this.mContext = context;
    }

    public static ae dv() {
        ae aeVar;
        synchronized (tq) {
            aeVar = wZ;
        }
        return aeVar;
    }

    public static void m1887u(Context context) {
        synchronized (tq) {
            if (wZ == null) {
                wZ = new ae(context);
            }
        }
    }

    public boolean m1888J(String str) {
        return "&sr".equals(str);
    }

    protected String dw() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
    }

    public String getValue(String field) {
        return (field != null && field.equals("&sr")) ? dw() : null;
    }
}
