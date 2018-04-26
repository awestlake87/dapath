package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0272b;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class ch extends dc {
    private static final String ID = C0268a.REGEX.toString();
    private static final String agJ = C0272b.IGNORE_CASE.toString();

    public ch() {
        super(ID);
    }

    protected boolean mo3147a(String str, String str2, Map<String, C1082a> map) {
        try {
            return Pattern.compile(str2, dh.m1728n((C1082a) map.get(agJ)).booleanValue() ? 66 : 64).matcher(str).find();
        } catch (PatternSyntaxException e) {
            return false;
        }
    }
}
