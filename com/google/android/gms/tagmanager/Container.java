package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0276c.C1077f;
import com.google.android.gms.internal.C0276c.C1080i;
import com.google.android.gms.internal.C0276c.C1081j;
import com.google.android.gms.internal.C0295d.C1082a;
import com.google.android.gms.tagmanager.C0952s.C0485a;
import com.google.android.gms.tagmanager.cd.C0456a;
import com.google.android.gms.tagmanager.cq.C0464c;
import com.google.android.gms.tagmanager.cq.C0468g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
    private final String aet;
    private final DataLayer aeu;
    private cs aev;
    private Map<String, FunctionCallMacroCallback> aew = new HashMap();
    private Map<String, FunctionCallTagCallback> aex = new HashMap();
    private volatile long aey;
    private volatile String aez = "";
    private final Context mContext;

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    private class C0917a implements C0485a {
        final /* synthetic */ Container aeA;

        private C0917a(Container container) {
            this.aeA = container;
        }

        public Object mo2286b(String str, Map<String, Object> map) {
            FunctionCallMacroCallback bF = this.aeA.bF(str);
            return bF == null ? null : bF.getValue(str, map);
        }
    }

    private class C0918b implements C0485a {
        final /* synthetic */ Container aeA;

        private C0918b(Container container) {
            this.aeA = container;
        }

        public Object mo2286b(String str, Map<String, Object> map) {
            FunctionCallTagCallback bG = this.aeA.bG(str);
            if (bG != null) {
                bG.execute(str, map);
            }
            return dh.nc();
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, C1081j resource) {
        this.mContext = context;
        this.aeu = dataLayer;
        this.aet = containerId;
        this.aey = lastRefreshTime;
        m1588a(resource.fK);
        if (resource.fJ != null) {
            m1591a(resource.fJ);
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, C0464c resource) {
        this.mContext = context;
        this.aeu = dataLayer;
        this.aet = containerId;
        this.aey = lastRefreshTime;
        m1589a(resource);
    }

    private void m1588a(C1077f c1077f) {
        if (c1077f == null) {
            throw new NullPointerException();
        }
        try {
            m1589a(cq.m1684b(c1077f));
        } catch (C0468g e) {
            bh.m1642A("Not loading resource: " + c1077f + " because it is invalid: " + e.toString());
        }
    }

    private void m1589a(C0464c c0464c) {
        this.aez = c0464c.getVersion();
        C0464c c0464c2 = c0464c;
        m1590a(new cs(this.mContext, c0464c2, this.aeu, new C0917a(), new C0918b(), bI(this.aez)));
    }

    private synchronized void m1590a(cs csVar) {
        this.aev = csVar;
    }

    private void m1591a(C1080i[] c1080iArr) {
        List arrayList = new ArrayList();
        for (Object add : c1080iArr) {
            arrayList.add(add);
        }
        ln().m1712h(arrayList);
    }

    private synchronized cs ln() {
        return this.aev;
    }

    FunctionCallMacroCallback bF(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.aew) {
            functionCallMacroCallback = (FunctionCallMacroCallback) this.aew.get(str);
        }
        return functionCallMacroCallback;
    }

    FunctionCallTagCallback bG(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.aex) {
            functionCallTagCallback = (FunctionCallTagCallback) this.aex.get(str);
        }
        return functionCallTagCallback;
    }

    void bH(String str) {
        ln().bH(str);
    }

    ag bI(String str) {
        if (cd.md().me().equals(C0456a.CONTAINER_DEBUG)) {
        }
        return new bq();
    }

    public boolean getBoolean(String key) {
        cs ln = ln();
        if (ln == null) {
            bh.m1642A("getBoolean called for closed container.");
            return dh.na().booleanValue();
        }
        try {
            return dh.m1728n((C1082a) ln.cj(key).getObject()).booleanValue();
        } catch (Exception e) {
            bh.m1642A("Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.");
            return dh.na().booleanValue();
        }
    }

    public String getContainerId() {
        return this.aet;
    }

    public double getDouble(String key) {
        cs ln = ln();
        if (ln == null) {
            bh.m1642A("getDouble called for closed container.");
            return dh.mZ().doubleValue();
        }
        try {
            return dh.m1725m((C1082a) ln.cj(key).getObject()).doubleValue();
        } catch (Exception e) {
            bh.m1642A("Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.");
            return dh.mZ().doubleValue();
        }
    }

    public long getLastRefreshTime() {
        return this.aey;
    }

    public long getLong(String key) {
        cs ln = ln();
        if (ln == null) {
            bh.m1642A("getLong called for closed container.");
            return dh.mY().longValue();
        }
        try {
            return dh.m1724l((C1082a) ln.cj(key).getObject()).longValue();
        } catch (Exception e) {
            bh.m1642A("Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.");
            return dh.mY().longValue();
        }
    }

    public String getString(String key) {
        cs ln = ln();
        if (ln == null) {
            bh.m1642A("getString called for closed container.");
            return dh.nc();
        }
        try {
            return dh.m1722j((C1082a) ln.cj(key).getObject());
        } catch (Exception e) {
            bh.m1642A("Calling getString() threw an exception: " + e.getMessage() + " Returning default value.");
            return dh.nc();
        }
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    String lm() {
        return this.aez;
    }

    public void registerFunctionCallMacroCallback(String customMacroName, FunctionCallMacroCallback customMacroCallback) {
        if (customMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.aew) {
            this.aew.put(customMacroName, customMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String customTagName, FunctionCallTagCallback customTagCallback) {
        if (customTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.aex) {
            this.aex.put(customTagName, customTagCallback);
        }
    }

    void release() {
        this.aev = null;
    }

    public void unregisterFunctionCallMacroCallback(String customMacroName) {
        synchronized (this.aew) {
            this.aew.remove(customMacroName);
        }
    }

    public void unregisterFunctionCallTagCallback(String customTagName) {
        synchronized (this.aex) {
            this.aex.remove(customTagName);
        }
    }
}
