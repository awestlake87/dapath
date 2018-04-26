package com.google.android.gms.internal;

import android.util.Log;
import com.google.ads.AdRequest;

public final class eu {
    public static void m1011A(String str) {
        if (m1018p(6)) {
            Log.e(AdRequest.LOGTAG, str);
        }
    }

    public static void m1012B(String str) {
        if (m1018p(4)) {
            Log.i(AdRequest.LOGTAG, str);
        }
    }

    public static void m1013C(String str) {
        if (m1018p(2)) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    public static void m1014D(String str) {
        if (m1018p(5)) {
            Log.w(AdRequest.LOGTAG, str);
        }
    }

    public static void m1015a(String str, Throwable th) {
        if (m1018p(3)) {
            Log.d(AdRequest.LOGTAG, str, th);
        }
    }

    public static void m1016b(String str, Throwable th) {
        if (m1018p(6)) {
            Log.e(AdRequest.LOGTAG, str, th);
        }
    }

    public static void m1017c(String str, Throwable th) {
        if (m1018p(5)) {
            Log.w(AdRequest.LOGTAG, str, th);
        }
    }

    public static boolean m1018p(int i) {
        return (i >= 5 || Log.isLoggable(AdRequest.LOGTAG, i)) && i != 2;
    }

    public static void m1019z(String str) {
        if (m1018p(3)) {
            Log.d(AdRequest.LOGTAG, str);
        }
    }
}
