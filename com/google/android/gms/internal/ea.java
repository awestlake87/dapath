package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class ea {
    private int mOrientation = -1;
    private String qG;
    private String qH;
    private String qI;
    private List<String> qJ;
    private String qK;
    private String qL;
    private List<String> qM;
    private long qN = -1;
    private boolean qO = false;
    private final long qP = -1;
    private List<String> qQ;
    private long qR = -1;

    private static String m929a(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        return (list == null || list.isEmpty()) ? null : (String) list.get(0);
    }

    private static long m930b(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            try {
                return (long) (Float.parseFloat(str2) * 1000.0f);
            } catch (NumberFormatException e) {
                eu.m1014D("Could not parse float from " + str + " header: " + str2);
            }
        }
        return -1;
    }

    private static List<String> m931c(Map<String, List<String>> map, String str) {
        List list = (List) map.get(str);
        if (!(list == null || list.isEmpty())) {
            String str2 = (String) list.get(0);
            if (str2 != null) {
                return Arrays.asList(str2.trim().split("\\s+"));
            }
        }
        return null;
    }

    private void m932e(Map<String, List<String>> map) {
        this.qG = m929a(map, "X-Afma-Ad-Size");
    }

    private void m933f(Map<String, List<String>> map) {
        List c = m931c(map, "X-Afma-Click-Tracking-Urls");
        if (c != null) {
            this.qJ = c;
        }
    }

    private void m934g(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Debug-Dialog");
        if (list != null && !list.isEmpty()) {
            this.qK = (String) list.get(0);
        }
    }

    private void m935h(Map<String, List<String>> map) {
        List c = m931c(map, "X-Afma-Tracking-Urls");
        if (c != null) {
            this.qM = c;
        }
    }

    private void m936i(Map<String, List<String>> map) {
        long b = m930b(map, "X-Afma-Interstitial-Timeout");
        if (b != -1) {
            this.qN = b;
        }
    }

    private void m937j(Map<String, List<String>> map) {
        this.qL = m929a(map, "X-Afma-ActiveView");
    }

    private void m938k(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Mediation");
        if (list != null && !list.isEmpty()) {
            this.qO = Boolean.valueOf((String) list.get(0)).booleanValue();
        }
    }

    private void m939l(Map<String, List<String>> map) {
        List c = m931c(map, "X-Afma-Manual-Tracking-Urls");
        if (c != null) {
            this.qQ = c;
        }
    }

    private void m940m(Map<String, List<String>> map) {
        long b = m930b(map, "X-Afma-Refresh-Rate");
        if (b != -1) {
            this.qR = b;
        }
    }

    private void m941n(Map<String, List<String>> map) {
        List list = (List) map.get("X-Afma-Orientation");
        if (list != null && !list.isEmpty()) {
            String str = (String) list.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                this.mOrientation = eo.bS();
            } else if ("landscape".equalsIgnoreCase(str)) {
                this.mOrientation = eo.bR();
            }
        }
    }

    public void m942a(String str, Map<String, List<String>> map, String str2) {
        this.qH = str;
        this.qI = str2;
        m943d(map);
    }

    public void m943d(Map<String, List<String>> map) {
        m932e(map);
        m933f(map);
        m934g(map);
        m935h(map);
        m936i((Map) map);
        m938k(map);
        m939l(map);
        m940m(map);
        m941n(map);
        m937j(map);
    }

    public du m944i(long j) {
        return new du(this.qH, this.qI, this.qJ, this.qM, this.qN, this.qO, -1, this.qQ, this.qR, this.mOrientation, this.qG, j, this.qK, this.qL);
    }
}
