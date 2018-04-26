package com.google.android.gms.maps.internal;

public final class C0384a {
    public static Boolean m1485a(byte b) {
        switch (b) {
            case (byte) 0:
                return Boolean.FALSE;
            case (byte) 1:
                return Boolean.TRUE;
            default:
                return null;
        }
    }

    public static byte m1486c(Boolean bool) {
        return bool != null ? bool.booleanValue() ? (byte) 1 : (byte) 0 : (byte) -1;
    }
}
