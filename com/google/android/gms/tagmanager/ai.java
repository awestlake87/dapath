package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0276c.C1074c;
import com.google.android.gms.internal.C0276c.C1075d;
import com.google.android.gms.internal.C0276c.C1080i;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Map;

class ai {
    private static void m1621a(DataLayer dataLayer, C1075d c1075d) {
        for (C1082a j : c1075d.eS) {
            dataLayer.bN(dh.m1722j(j));
        }
    }

    public static void m1622a(DataLayer dataLayer, C1080i c1080i) {
        if (c1080i.fI == null) {
            bh.m1645D("supplemental missing experimentSupplemental");
            return;
        }
        m1621a(dataLayer, c1080i.fI);
        m1623b(dataLayer, c1080i.fI);
        m1625c(dataLayer, c1080i.fI);
    }

    private static void m1623b(DataLayer dataLayer, C1075d c1075d) {
        for (C1082a c : c1075d.eR) {
            Map c2 = m1624c(c);
            if (c2 != null) {
                dataLayer.push(c2);
            }
        }
    }

    private static Map<String, Object> m1624c(C1082a c1082a) {
        Object o = dh.m1730o(c1082a);
        if (o instanceof Map) {
            return (Map) o;
        }
        bh.m1645D("value: " + o + " is not a map value, ignored.");
        return null;
    }

    private static void m1625c(DataLayer dataLayer, C1075d c1075d) {
        for (C1074c c1074c : c1075d.eT) {
            if (c1074c.eM == null) {
                bh.m1645D("GaExperimentRandom: No key");
            } else {
                Object obj = dataLayer.get(c1074c.eM);
                Long valueOf = !(obj instanceof Number) ? null : Long.valueOf(((Number) obj).longValue());
                long j = c1074c.eN;
                long j2 = c1074c.eO;
                if (!c1074c.eP || valueOf == null || valueOf.longValue() < j || valueOf.longValue() > j2) {
                    if (j <= j2) {
                        obj = Long.valueOf(Math.round((Math.random() * ((double) (j2 - j))) + ((double) j)));
                    } else {
                        bh.m1645D("GaExperimentRandom: random range invalid");
                    }
                }
                dataLayer.bN(c1074c.eM);
                Map c = dataLayer.m1609c(c1074c.eM, obj);
                if (c1074c.eQ > 0) {
                    if (c.containsKey("gtm")) {
                        Object obj2 = c.get("gtm");
                        if (obj2 instanceof Map) {
                            ((Map) obj2).put("lifetime", Long.valueOf(c1074c.eQ));
                        } else {
                            bh.m1645D("GaExperimentRandom: gtm not a map");
                        }
                    } else {
                        c.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(c1074c.eQ)));
                    }
                }
                dataLayer.push(c);
            }
        }
    }
}
