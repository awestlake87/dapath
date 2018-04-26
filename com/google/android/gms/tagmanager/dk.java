package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0295d.C1082a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class dk {
    private static by<C1082a> m1737a(by<C1082a> byVar) {
        try {
            return new by(dh.m1733r(cv(dh.m1722j((C1082a) byVar.getObject()))), byVar.ma());
        } catch (Throwable e) {
            bh.m1646b("Escape URI: unsupported encoding", e);
            return byVar;
        }
    }

    private static by<C1082a> m1738a(by<C1082a> byVar, int i) {
        if (m1740q((C1082a) byVar.getObject())) {
            switch (i) {
                case 12:
                    return m1737a(byVar);
                default:
                    bh.m1642A("Unsupported Value Escaping: " + i);
                    return byVar;
            }
        }
        bh.m1642A("Escaping can only be applied to strings.");
        return byVar;
    }

    static by<C1082a> m1739a(by<C1082a> byVar, int... iArr) {
        by a;
        for (int a2 : iArr) {
            a = m1738a(a, a2);
        }
        return a;
    }

    static String cv(String str) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    private static boolean m1740q(C1082a c1082a) {
        return dh.m1730o(c1082a) instanceof String;
    }
}
