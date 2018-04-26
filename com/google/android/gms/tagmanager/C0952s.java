package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0272b;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class C0952s extends aj {
    private static final String ID = C0268a.FUNCTION_CALL.toString();
    private static final String aeW = C0272b.FUNCTION_CALL_NAME.toString();
    private static final String aem = C0272b.ADDITIONAL_PARAMS.toString();
    private final C0485a aeX;

    public interface C0485a {
        Object mo2286b(String str, Map<String, Object> map);
    }

    public C0952s(C0485a c0485a) {
        super(ID, aeW);
        this.aeX = c0485a;
    }

    public boolean lh() {
        return false;
    }

    public C1082a mo2295w(Map<String, C1082a> map) {
        String j = dh.m1722j((C1082a) map.get(aeW));
        Map hashMap = new HashMap();
        C1082a c1082a = (C1082a) map.get(aem);
        if (c1082a != null) {
            Object o = dh.m1730o(c1082a);
            if (o instanceof Map) {
                for (Entry entry : ((Map) o).entrySet()) {
                    hashMap.put(entry.getKey().toString(), entry.getValue());
                }
            } else {
                bh.m1645D("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return dh.nd();
            }
        }
        try {
            return dh.m1733r(this.aeX.mo2286b(j, hashMap));
        } catch (Exception e) {
            bh.m1645D("Custom macro/tag " + j + " threw exception " + e.getMessage());
            return dh.nd();
        }
    }
}
