package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0272b;
import com.google.android.gms.internal.C0295d.C1082a;
import com.google.android.gms.tagmanager.cq.C0462a;
import com.google.android.gms.tagmanager.cq.C0464c;
import com.google.android.gms.tagmanager.cq.C0465d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ba {
    public static C0464c bY(String str) throws JSONException {
        C1082a k = m1638k(new JSONObject(str));
        C0465d mr = C0464c.mr();
        for (int i = 0; i < k.fP.length; i++) {
            mr.m1672a(C0462a.mn().m1670b(C0272b.INSTANCE_NAME.toString(), k.fP[i]).m1670b(C0272b.FUNCTION.toString(), dh.cp(C0943m.lk())).m1670b(C0943m.ll(), k.fQ[i]).mq());
        }
        return mr.mu();
    }

    private static C1082a m1638k(Object obj) throws JSONException {
        return dh.m1733r(m1639l(obj));
    }

    static Object m1639l(Object obj) throws JSONException {
        if (obj instanceof JSONArray) {
            throw new RuntimeException("JSONArrays are not supported");
        } else if (JSONObject.NULL.equals(obj)) {
            throw new RuntimeException("JSON nulls are not supported");
        } else if (!(obj instanceof JSONObject)) {
            return obj;
        } else {
            JSONObject jSONObject = (JSONObject) obj;
            Map hashMap = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                hashMap.put(str, m1639l(jSONObject.get(str)));
            }
            return hashMap;
        }
    }
}
