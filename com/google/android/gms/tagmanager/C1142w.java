package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0272b;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.List;
import java.util.Map;

class C1142w extends df {
    private static final String ID = C0268a.DATA_LAYER_WRITE.toString();
    private static final String VALUE = C0272b.VALUE.toString();
    private static final String aft = C0272b.CLEAR_PERSISTENT_DATA_LAYER_PREFIX.toString();
    private final DataLayer aeu;

    public C1142w(DataLayer dataLayer) {
        super(ID, VALUE);
        this.aeu = dataLayer;
    }

    private void m3849a(C1082a c1082a) {
        if (c1082a != null && c1082a != dh.mX()) {
            String j = dh.m1722j(c1082a);
            if (j != dh.nc()) {
                this.aeu.bN(j);
            }
        }
    }

    private void m3850b(C1082a c1082a) {
        if (c1082a != null && c1082a != dh.mX()) {
            Object o = dh.m1730o(c1082a);
            if (o instanceof List) {
                for (Object o2 : (List) o2) {
                    if (o2 instanceof Map) {
                        this.aeu.push((Map) o2);
                    }
                }
            }
        }
    }

    public void mo3111y(Map<String, C1082a> map) {
        m3850b((C1082a) map.get(VALUE));
        m3849a((C1082a) map.get(aft));
    }
}
