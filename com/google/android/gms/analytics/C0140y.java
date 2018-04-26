package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class C0140y {
    static String m87a(C0139x c0139x, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c0139x.dk());
        if (c0139x.dm() > 0) {
            long dm = j - c0139x.dm();
            if (dm >= 0) {
                stringBuilder.append("&qt").append("=").append(dm);
            }
        }
        stringBuilder.append("&z").append("=").append(c0139x.dl());
        return stringBuilder.toString();
    }

    static String encode(String input) {
        try {
            return URLEncoder.encode(input, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("URL encoding failed for: " + input);
        }
    }

    static Map<String, String> m88u(Map<String, String> map) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            if (((String) entry.getKey()).startsWith("&") && entry.getValue() != null) {
                CharSequence substring = ((String) entry.getKey()).substring(1);
                if (!TextUtils.isEmpty(substring)) {
                    hashMap.put(substring, entry.getValue());
                }
            }
        }
        return hashMap;
    }
}
