package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0272b;
import com.google.android.gms.internal.C0295d.C1082a;
import com.google.android.gms.plus.PlusShare;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class az extends aj {
    private static final String ID = C0268a.JOINER.toString();
    private static final String afU = C0272b.ITEM_SEPARATOR.toString();
    private static final String afV = C0272b.KEY_VALUE_SEPARATOR.toString();
    private static final String afW = C0272b.ESCAPE.toString();
    private static final String afy = C0272b.ARG0.toString();

    private enum C0452a {
        NONE,
        URL,
        BACKSLASH
    }

    public az() {
        super(ID, afy);
    }

    private String m2957a(String str, C0452a c0452a, Set<Character> set) {
        switch (c0452a) {
            case URL:
                try {
                    return dk.cv(str);
                } catch (Throwable e) {
                    bh.m1646b("Joiner: unsupported encoding", e);
                    return str;
                }
            case BACKSLASH:
                String replace = str.replace("\\", "\\\\");
                String str2 = replace;
                for (Character ch : set) {
                    CharSequence ch2 = ch.toString();
                    str2 = str2.replace(ch2, "\\" + ch2);
                }
                return str2;
            default:
                return str;
        }
    }

    private void m2958a(StringBuilder stringBuilder, String str, C0452a c0452a, Set<Character> set) {
        stringBuilder.append(m2957a(str, c0452a, set));
    }

    private void m2959a(Set<Character> set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    public boolean lh() {
        return true;
    }

    public C1082a mo2295w(Map<String, C1082a> map) {
        C1082a c1082a = (C1082a) map.get(afy);
        if (c1082a == null) {
            return dh.nd();
        }
        C0452a c0452a;
        C1082a c1082a2 = (C1082a) map.get(afU);
        String j = c1082a2 != null ? dh.m1722j(c1082a2) : "";
        c1082a2 = (C1082a) map.get(afV);
        String j2 = c1082a2 != null ? dh.m1722j(c1082a2) : "=";
        C0452a c0452a2 = C0452a.NONE;
        c1082a2 = (C1082a) map.get(afW);
        Set set;
        if (c1082a2 != null) {
            String j3 = dh.m1722j(c1082a2);
            if (PlusShare.KEY_CALL_TO_ACTION_URL.equals(j3)) {
                c0452a = C0452a.URL;
                set = null;
            } else if ("backslash".equals(j3)) {
                c0452a = C0452a.BACKSLASH;
                set = new HashSet();
                m2959a(set, j);
                m2959a(set, j2);
                set.remove(Character.valueOf('\\'));
            } else {
                bh.m1642A("Joiner: unsupported escape type: " + j3);
                return dh.nd();
            }
        }
        set = null;
        c0452a = c0452a2;
        StringBuilder stringBuilder = new StringBuilder();
        switch (c1082a.type) {
            case 2:
                Object obj = 1;
                C1082a[] c1082aArr = c1082a.fO;
                int length = c1082aArr.length;
                int i = 0;
                while (i < length) {
                    C1082a c1082a3 = c1082aArr[i];
                    if (obj == null) {
                        stringBuilder.append(j);
                    }
                    m2958a(stringBuilder, dh.m1722j(c1082a3), c0452a, set);
                    i++;
                    obj = null;
                }
                break;
            case 3:
                for (int i2 = 0; i2 < c1082a.fP.length; i2++) {
                    if (i2 > 0) {
                        stringBuilder.append(j);
                    }
                    String j4 = dh.m1722j(c1082a.fP[i2]);
                    String j5 = dh.m1722j(c1082a.fQ[i2]);
                    m2958a(stringBuilder, j4, c0452a, set);
                    stringBuilder.append(j2);
                    m2958a(stringBuilder, j5, c0452a, set);
                }
                break;
            default:
                m2958a(stringBuilder, dh.m1722j(c1082a), c0452a, set);
                break;
        }
        return dh.m1733r(stringBuilder.toString());
    }
}
