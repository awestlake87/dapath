package com.google.android.gms.internal;

import android.util.Log;

public final class hf {
    private final String GI;

    public hf(String str) {
        this.GI = (String) hm.m1232f(str);
    }

    public void m1178a(String str, String str2, Throwable th) {
        if (ap(4)) {
            Log.i(str, str2, th);
        }
    }

    public boolean ap(int i) {
        return Log.isLoggable(this.GI, i);
    }

    public void m1179b(String str, String str2, Throwable th) {
        if (ap(6)) {
            Log.e(str, str2, th);
        }
    }

    public void m1180i(String str, String str2) {
        if (ap(2)) {
            Log.v(str, str2);
        }
    }

    public void m1181j(String str, String str2) {
        if (ap(5)) {
            Log.w(str, str2);
        }
    }

    public void m1182k(String str, String str2) {
        if (ap(6)) {
            Log.e(str, str2);
        }
    }
}
