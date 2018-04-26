package com.google.android.gms.internal;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class bb {
    public static final bc mT = new C06791();
    public static final bc mU = new C06802();
    public static final bc mV = new C06813();
    public static final bc mW = new C06824();
    public static final bc mX = new C06835();
    public static final bc mY = new C06846();
    public static final bc mZ = new C06857();
    public static final bc na = new C06868();
    public static final bc nb = new bh();

    static class C06791 implements bc {
        C06791() {
        }

        public void mo1576b(ex exVar, Map<String, String> map) {
        }
    }

    static class C06802 implements bc {
        C06802() {
        }

        public void mo1576b(ex exVar, Map<String, String> map) {
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                eu.m1014D("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            Map hashMap = new HashMap();
            PackageManager packageManager = exVar.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) != null));
            }
            exVar.m1029a("openableURLs", hashMap);
        }
    }

    static class C06813 implements bc {
        C06813() {
        }

        public void mo1576b(ex exVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                eu.m1014D("URL missing from click GMSG.");
                return;
            }
            Uri a;
            Uri parse = Uri.parse(str);
            try {
                C0359k cc = exVar.cc();
                if (cc != null && cc.m1323b(parse)) {
                    a = cc.m1320a(parse, exVar.getContext());
                    new es(exVar.getContext(), exVar.cd().sw, a.toString()).start();
                }
            } catch (C0361l e) {
                eu.m1014D("Unable to append parameter to URL: " + str);
            }
            a = parse;
            new es(exVar.getContext(), exVar.cd().sw, a.toString()).start();
        }
    }

    static class C06824 implements bc {
        C06824() {
        }

        public void mo1576b(ex exVar, Map<String, String> map) {
            cf ca = exVar.ca();
            if (ca == null) {
                eu.m1014D("A GMSG tried to close something that wasn't an overlay.");
            } else {
                ca.close();
            }
        }
    }

    static class C06835 implements bc {
        C06835() {
        }

        public void mo1576b(ex exVar, Map<String, String> map) {
            cf ca = exVar.ca();
            if (ca == null) {
                eu.m1014D("A GMSG tried to use a custom close button on something that wasn't an overlay.");
            } else {
                ca.m3569j("1".equals(map.get("custom_close")));
            }
        }
    }

    static class C06846 implements bc {
        C06846() {
        }

        public void mo1576b(ex exVar, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                eu.m1014D("URL missing from httpTrack GMSG.");
            } else {
                new es(exVar.getContext(), exVar.cd().sw, str).start();
            }
        }
    }

    static class C06857 implements bc {
        C06857() {
        }

        public void mo1576b(ex exVar, Map<String, String> map) {
            eu.m1012B("Received log message: " + ((String) map.get("string")));
        }
    }

    static class C06868 implements bc {
        C06868() {
        }

        public void mo1576b(ex exVar, Map<String, String> map) {
            String str = (String) map.get("ty");
            String str2 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt((String) map.get("tx"));
                int parseInt2 = Integer.parseInt(str);
                int parseInt3 = Integer.parseInt(str2);
                C0359k cc = exVar.cc();
                if (cc != null) {
                    cc.m1324z().mo1742a(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                eu.m1014D("Could not parse touch parameters from gmsg.");
            }
        }
    }
}
