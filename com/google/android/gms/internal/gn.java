package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;

public class gn {
    private static boolean Cl = false;
    private boolean Cm;
    private boolean Cn;
    private String Co;
    private final String mTag;

    public gn(String str) {
        this(str, es());
    }

    public gn(String str, boolean z) {
        this.mTag = str;
        this.Cm = z;
        this.Cn = false;
    }

    private String m1136e(String str, Object... objArr) {
        String format = String.format(str, objArr);
        return !TextUtils.isEmpty(this.Co) ? this.Co + format : format;
    }

    public static boolean es() {
        return Cl;
    }

    public void m1137a(String str, Object... objArr) {
        if (er()) {
            Log.v(this.mTag, m1136e(str, objArr));
        }
    }

    public void m1138a(Throwable th, String str, Object... objArr) {
        if (eq() || Cl) {
            Log.d(this.mTag, m1136e(str, objArr), th);
        }
    }

    public void ap(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = null;
        } else {
            str2 = String.format("[%s] ", new Object[]{str});
        }
        this.Co = str2;
    }

    public void m1139b(String str, Object... objArr) {
        if (eq() || Cl) {
            Log.d(this.mTag, m1136e(str, objArr));
        }
    }

    public void m1140c(String str, Object... objArr) {
        Log.i(this.mTag, m1136e(str, objArr));
    }

    public void m1141d(String str, Object... objArr) {
        Log.w(this.mTag, m1136e(str, objArr));
    }

    public boolean eq() {
        return this.Cm;
    }

    public boolean er() {
        return this.Cn;
    }
}
