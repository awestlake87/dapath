package com.google.android.gms.internal;

import android.util.Base64;

class C0715e implements C0365m {
    C0715e() {
    }

    public String mo1692a(byte[] bArr, boolean z) {
        return Base64.encodeToString(bArr, z ? 11 : 2);
    }

    public byte[] mo1693a(String str, boolean z) throws IllegalArgumentException {
        return Base64.decode(str, z ? 11 : 2);
    }
}
