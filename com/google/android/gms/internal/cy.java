package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

public final class cy {
    public static int m879a(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            eu.m1014D("Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            eu.m1014D("Unexpected type for intent response code. " + obj.getClass().getName());
            return 5;
        }
    }

    public static int m880c(Intent intent) {
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            eu.m1014D("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            eu.m1014D("Unexpected type for intent response code. " + obj.getClass().getName());
            return 5;
        }
    }

    public static String m881d(Intent intent) {
        return intent == null ? null : intent.getStringExtra("INAPP_PURCHASE_DATA");
    }

    public static String m882e(Intent intent) {
        return intent == null ? null : intent.getStringExtra("INAPP_DATA_SIGNATURE");
    }

    public static String m883p(String str) {
        String str2 = null;
        if (str != null) {
            try {
                str2 = new JSONObject(str).getString("developerPayload");
            } catch (JSONException e) {
                eu.m1014D("Fail to parse purchase data");
            }
        }
        return str2;
    }

    public static String m884q(String str) {
        String str2 = null;
        if (str != null) {
            try {
                str2 = new JSONObject(str).getString("purchaseToken");
            } catch (JSONException e) {
                eu.m1014D("Fail to parse purchase data");
            }
        }
        return str2;
    }
}
