package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0272b;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class di extends df {
    private static final String ID = C0268a.UNIVERSAL_ANALYTICS.toString();
    private static final String aiA = C0272b.TRANSACTION_DATALAYER_MAP.toString();
    private static final String aiB = C0272b.TRANSACTION_ITEM_DATALAYER_MAP.toString();
    private static Map<String, String> aiC;
    private static Map<String, String> aiD;
    private static final String aiw = C0272b.ACCOUNT.toString();
    private static final String aix = C0272b.ANALYTICS_PASS_THROUGH.toString();
    private static final String aiy = C0272b.ANALYTICS_FIELDS.toString();
    private static final String aiz = C0272b.TRACK_TRANSACTION.toString();
    private final DataLayer aeu;
    private final Set<String> aiE;
    private final de aiF;

    public di(Context context, DataLayer dataLayer) {
        this(context, dataLayer, new de(context));
    }

    di(Context context, DataLayer dataLayer, de deVar) {
        super(ID, new String[0]);
        this.aeu = dataLayer;
        this.aiF = deVar;
        this.aiE = new HashSet();
        this.aiE.add("");
        this.aiE.add("0");
        this.aiE.add("false");
    }

    private Map<String, String> m3824G(Map<String, C1082a> map) {
        C1082a c1082a = (C1082a) map.get(aiA);
        if (c1082a != null) {
            return m3828c(c1082a);
        }
        if (aiC == null) {
            Map hashMap = new HashMap();
            hashMap.put("transactionId", "&ti");
            hashMap.put("transactionAffiliation", "&ta");
            hashMap.put("transactionTax", "&tt");
            hashMap.put("transactionShipping", "&ts");
            hashMap.put("transactionTotal", "&tr");
            hashMap.put("transactionCurrency", "&cu");
            aiC = hashMap;
        }
        return aiC;
    }

    private Map<String, String> m3825H(Map<String, C1082a> map) {
        C1082a c1082a = (C1082a) map.get(aiB);
        if (c1082a != null) {
            return m3828c(c1082a);
        }
        if (aiD == null) {
            Map hashMap = new HashMap();
            hashMap.put("name", "&in");
            hashMap.put("sku", "&ic");
            hashMap.put("category", "&iv");
            hashMap.put("price", "&ip");
            hashMap.put("quantity", "&iq");
            hashMap.put("currency", "&cu");
            aiD = hashMap;
        }
        return aiD;
    }

    private void m3826a(Tracker tracker, Map<String, C1082a> map) {
        String cu = cu("transactionId");
        if (cu == null) {
            bh.m1642A("Cannot find transactionId in data layer.");
            return;
        }
        List<Map> linkedList = new LinkedList();
        try {
            Map p = m3830p((C1082a) map.get(aiy));
            p.put("&t", "transaction");
            for (Entry entry : m3824G(map).entrySet()) {
                m3827b(p, (String) entry.getValue(), cu((String) entry.getKey()));
            }
            linkedList.add(p);
            List<Map> ne = ne();
            if (ne != null) {
                for (Map map2 : ne) {
                    if (map2.get("name") == null) {
                        bh.m1642A("Unable to send transaction item hit due to missing 'name' field.");
                        return;
                    }
                    Map p2 = m3830p((C1082a) map.get(aiy));
                    p2.put("&t", "item");
                    p2.put("&ti", cu);
                    for (Entry entry2 : m3825H(map).entrySet()) {
                        m3827b(p2, (String) entry2.getValue(), (String) map2.get(entry2.getKey()));
                    }
                    linkedList.add(p2);
                }
            }
            for (Map map22 : linkedList) {
                tracker.send(map22);
            }
        } catch (Throwable e) {
            bh.m1646b("Unable to send transaction", e);
        }
    }

    private void m3827b(Map<String, String> map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    private Map<String, String> m3828c(C1082a c1082a) {
        Object o = dh.m1730o(c1082a);
        if (!(o instanceof Map)) {
            return null;
        }
        Map map = (Map) o;
        Map<String, String> linkedHashMap = new LinkedHashMap();
        for (Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    private String cu(String str) {
        Object obj = this.aeu.get(str);
        return obj == null ? null : obj.toString();
    }

    private boolean m3829e(Map<String, C1082a> map, String str) {
        C1082a c1082a = (C1082a) map.get(str);
        return c1082a == null ? false : dh.m1728n(c1082a).booleanValue();
    }

    private List<Map<String, String>> ne() {
        Object obj = this.aeu.get("transactionProducts");
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                if (!(obj2 instanceof Map)) {
                    throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
                }
            }
            return (List) obj;
        }
        throw new IllegalArgumentException("transactionProducts should be of type List.");
    }

    private Map<String, String> m3830p(C1082a c1082a) {
        if (c1082a == null) {
            return new HashMap();
        }
        Map<String, String> c = m3828c(c1082a);
        if (c == null) {
            return new HashMap();
        }
        String str = (String) c.get("&aip");
        if (str != null && this.aiE.contains(str.toLowerCase())) {
            c.remove("&aip");
        }
        return c;
    }

    public void mo3111y(Map<String, C1082a> map) {
        Tracker cm = this.aiF.cm("_GTM_DEFAULT_TRACKER_");
        if (m3829e(map, aix)) {
            cm.send(m3830p((C1082a) map.get(aiy)));
        } else if (m3829e(map, aiz)) {
            m3826a(cm, map);
        } else {
            bh.m1645D("Ignoring unknown tag.");
        }
    }
}
