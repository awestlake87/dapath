package com.google.android.gms.internal;

import android.os.Looper;
import android.text.TextUtils;

public final class hm {
    public static void m1224A(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void m1225C(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void m1226a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void m1227a(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static String aE(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Given String is empty or null");
    }

    public static void ay(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static void az(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static <T> T m1228b(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static String m1229b(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    public static void m1230b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void m1231b(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> T m1232f(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException("null reference");
    }
}
