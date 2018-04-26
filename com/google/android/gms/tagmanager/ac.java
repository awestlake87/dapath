package com.google.android.gms.tagmanager;

import android.util.Base64;
import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0272b;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;

class ac extends aj {
    private static final String ID = C0268a.ENCODE.toString();
    private static final String afA = C0272b.INPUT_FORMAT.toString();
    private static final String afB = C0272b.OUTPUT_FORMAT.toString();
    private static final String afy = C0272b.ARG0.toString();
    private static final String afz = C0272b.NO_PADDING.toString();

    public ac() {
        super(ID, afy);
    }

    public boolean lh() {
        return true;
    }

    public C1082a mo2295w(Map<String, C1082a> map) {
        C1082a c1082a = (C1082a) map.get(afy);
        if (c1082a == null || c1082a == dh.nd()) {
            return dh.nd();
        }
        String j = dh.m1722j(c1082a);
        c1082a = (C1082a) map.get(afA);
        String j2 = c1082a == null ? "text" : dh.m1722j(c1082a);
        c1082a = (C1082a) map.get(afB);
        String j3 = c1082a == null ? "base16" : dh.m1722j(c1082a);
        c1082a = (C1082a) map.get(afz);
        int i = (c1082a == null || !dh.m1728n(c1082a).booleanValue()) ? 2 : 3;
        try {
            byte[] bytes;
            Object d;
            if ("text".equals(j2)) {
                bytes = j.getBytes();
            } else if ("base16".equals(j2)) {
                bytes = C0477j.bE(j);
            } else if ("base64".equals(j2)) {
                bytes = Base64.decode(j, i);
            } else if ("base64url".equals(j2)) {
                bytes = Base64.decode(j, i | 8);
            } else {
                bh.m1642A("Encode: unknown input format: " + j2);
                return dh.nd();
            }
            if ("base16".equals(j3)) {
                d = C0477j.m1741d(bytes);
            } else if ("base64".equals(j3)) {
                d = Base64.encodeToString(bytes, i);
            } else if ("base64url".equals(j3)) {
                d = Base64.encodeToString(bytes, i | 8);
            } else {
                bh.m1642A("Encode: unknown output format: " + j3);
                return dh.nd();
            }
            return dh.m1733r(d);
        } catch (IllegalArgumentException e) {
            bh.m1642A("Encode: invalid input:");
            return dh.nd();
        }
    }
}
