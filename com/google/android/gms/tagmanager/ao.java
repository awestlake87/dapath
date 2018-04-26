package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0272b;
import com.google.android.gms.internal.C0295d.C1082a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

class ao extends aj {
    private static final String ID = C0268a.HASH.toString();
    private static final String afA = C0272b.INPUT_FORMAT.toString();
    private static final String afE = C0272b.ALGORITHM.toString();
    private static final String afy = C0272b.ARG0.toString();

    public ao() {
        super(ID, afy);
    }

    private byte[] m2943c(String str, byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance(str);
        instance.update(bArr);
        return instance.digest();
    }

    public boolean lh() {
        return true;
    }

    public C1082a mo2295w(Map<String, C1082a> map) {
        C1082a c1082a = (C1082a) map.get(afy);
        if (c1082a == null || c1082a == dh.nd()) {
            return dh.nd();
        }
        byte[] bytes;
        String j = dh.m1722j(c1082a);
        c1082a = (C1082a) map.get(afE);
        String j2 = c1082a == null ? "MD5" : dh.m1722j(c1082a);
        c1082a = (C1082a) map.get(afA);
        String j3 = c1082a == null ? "text" : dh.m1722j(c1082a);
        if ("text".equals(j3)) {
            bytes = j.getBytes();
        } else if ("base16".equals(j3)) {
            bytes = C0477j.bE(j);
        } else {
            bh.m1642A("Hash: unknown input format: " + j3);
            return dh.nd();
        }
        try {
            return dh.m1733r(C0477j.m1741d(m2943c(j2, bytes)));
        } catch (NoSuchAlgorithmException e) {
            bh.m1642A("Hash: unknown algorithm: " + j2);
            return dh.nd();
        }
    }
}
