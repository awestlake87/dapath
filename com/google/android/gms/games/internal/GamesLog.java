package com.google.android.gms.games.internal;

import com.google.android.gms.internal.hf;

public final class GamesLog {
    private static final hf OV = new hf("Games");

    private GamesLog() {
    }

    public static void m479a(String str, String str2, Throwable th) {
        OV.m1178a(str, str2, th);
    }

    public static void m480b(String str, String str2, Throwable th) {
        OV.m1179b(str, str2, th);
    }

    public static void m481i(String str, String str2) {
        OV.m1180i(str, str2);
    }

    public static void m482j(String str, String str2) {
        OV.m1181j(str, str2);
    }

    public static void m483k(String str, String str2) {
        OV.m1182k(str, str2);
    }
}
