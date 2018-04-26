package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public final class bg implements bc {
    private final bd nd;

    public bg(bd bdVar) {
        this.nd = bdVar;
    }

    private static boolean m2480a(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int m2481b(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return eo.bS();
            }
            if ("l".equalsIgnoreCase(str)) {
                return eo.bR();
            }
        }
        return -1;
    }

    public void mo1576b(ex exVar, Map<String, String> map) {
        String str = (String) map.get("a");
        if (str == null) {
            eu.m1014D("Action missing from an open GMSG.");
            return;
        }
        ey cb = exVar.cb();
        if ("expand".equalsIgnoreCase(str)) {
            if (exVar.ce()) {
                eu.m1014D("Cannot expand WebView that is already expanded.");
            } else {
                cb.m1042a(m2480a(map), m2481b(map));
            }
        } else if ("webapp".equalsIgnoreCase(str)) {
            str = (String) map.get("u");
            if (str != null) {
                cb.m1043a(m2480a(map), m2481b(map), str);
            } else {
                cb.m1044a(m2480a(map), m2481b(map), (String) map.get("html"), (String) map.get("baseurl"));
            }
        } else if ("in_app_purchase".equalsIgnoreCase(str)) {
            str = (String) map.get("product_id");
            String str2 = (String) map.get("report_urls");
            if (this.nd == null) {
                return;
            }
            if (str2 == null || str2.isEmpty()) {
                this.nd.mo3092a(str, new ArrayList());
                return;
            }
            this.nd.mo3092a(str, new ArrayList(Arrays.asList(str2.split(" "))));
        } else {
            cb.m1036a(new ce((String) map.get("i"), (String) map.get("u"), (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
        }
    }
}
