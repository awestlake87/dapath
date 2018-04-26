package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0272b;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class cg extends aj {
    private static final String ID = C0268a.REGEX_GROUP.toString();
    private static final String agH = C0272b.ARG0.toString();
    private static final String agI = C0272b.ARG1.toString();
    private static final String agJ = C0272b.IGNORE_CASE.toString();
    private static final String agK = C0272b.GROUP.toString();

    public cg() {
        super(ID, agH, agI);
    }

    public boolean lh() {
        return true;
    }

    public C1082a mo2295w(Map<String, C1082a> map) {
        C1082a c1082a = (C1082a) map.get(agH);
        C1082a c1082a2 = (C1082a) map.get(agI);
        if (c1082a == null || c1082a == dh.nd() || c1082a2 == null || c1082a2 == dh.nd()) {
            return dh.nd();
        }
        int i = 64;
        if (dh.m1728n((C1082a) map.get(agJ)).booleanValue()) {
            i = 66;
        }
        C1082a c1082a3 = (C1082a) map.get(agK);
        int intValue;
        if (c1082a3 != null) {
            Long l = dh.m1724l(c1082a3);
            if (l == dh.mY()) {
                return dh.nd();
            }
            intValue = l.intValue();
            if (intValue < 0) {
                return dh.nd();
            }
        }
        intValue = 1;
        try {
            CharSequence j = dh.m1722j(c1082a);
            Object obj = null;
            Matcher matcher = Pattern.compile(dh.m1722j(c1082a2), i).matcher(j);
            if (matcher.find() && matcher.groupCount() >= intValue) {
                obj = matcher.group(intValue);
            }
            return obj == null ? dh.nd() : dh.m1733r(obj);
        } catch (PatternSyntaxException e) {
            return dh.nd();
        }
    }
}
