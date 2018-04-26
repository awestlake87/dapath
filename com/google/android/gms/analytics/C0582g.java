package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

class C0582g implements C0120m {
    private static C0582g tG;
    private static Object tq = new Object();
    protected String tC;
    protected String tD;
    protected String tE;
    protected String tF;

    protected C0582g() {
    }

    private C0582g(Context context) {
        PackageManager packageManager = context.getPackageManager();
        this.tE = context.getPackageName();
        this.tF = packageManager.getInstallerPackageName(this.tE);
        String str = this.tE;
        String str2 = null;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                str = packageManager.getApplicationLabel(packageInfo.applicationInfo).toString();
                str2 = packageInfo.versionName;
            }
        } catch (NameNotFoundException e) {
            aa.m37A("Error retrieving package info: appName set to " + str);
        }
        this.tC = str;
        this.tD = str2;
    }

    public static C0582g cu() {
        return tG;
    }

    public static void m1909u(Context context) {
        synchronized (tq) {
            if (tG == null) {
                tG = new C0582g(context);
            }
        }
    }

    public boolean m1910J(String str) {
        return "&an".equals(str) || "&av".equals(str) || "&aid".equals(str) || "&aiid".equals(str);
    }

    public String getValue(String field) {
        if (field == null) {
            return null;
        }
        if (field.equals("&an")) {
            return this.tC;
        }
        if (field.equals("&av")) {
            return this.tD;
        }
        if (field.equals("&aid")) {
            return this.tE;
        }
        return field.equals("&aiid") ? this.tF : null;
    }
}
