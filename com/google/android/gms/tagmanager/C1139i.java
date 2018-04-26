package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0272b;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class C1139i extends df {
    private static final String ID = C0268a.ARBITRARY_PIXEL.toString();
    private static final String URL = C0272b.URL.toString();
    private static final String aem = C0272b.ADDITIONAL_PARAMS.toString();
    private static final String aen = C0272b.UNREPEATABLE.toString();
    static final String aeo = ("gtm_" + ID + "_unrepeatable");
    private static final Set<String> aep = new HashSet();
    private final C0476a aeq;
    private final Context mContext;

    public interface C0476a {
        aq li();
    }

    class C09411 implements C0476a {
        final /* synthetic */ Context qu;

        C09411(Context context) {
            this.qu = context;
        }

        public aq li() {
            return C0956y.m3066N(this.qu);
        }
    }

    public C1139i(Context context) {
        this(context, new C09411(context));
    }

    C1139i(Context context, C0476a c0476a) {
        super(ID, URL);
        this.aeq = c0476a;
        this.mContext = context;
    }

    private synchronized boolean bB(String str) {
        boolean z = true;
        synchronized (this) {
            if (!bD(str)) {
                if (bC(str)) {
                    aep.add(str);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    boolean bC(String str) {
        return this.mContext.getSharedPreferences(aeo, 0).contains(str);
    }

    boolean bD(String str) {
        return aep.contains(str);
    }

    public void mo3111y(Map<String, C1082a> map) {
        String j = map.get(aen) != null ? dh.m1722j((C1082a) map.get(aen)) : null;
        if (j == null || !bB(j)) {
            Builder buildUpon = Uri.parse(dh.m1722j((C1082a) map.get(URL))).buildUpon();
            C1082a c1082a = (C1082a) map.get(aem);
            if (c1082a != null) {
                Object o = dh.m1730o(c1082a);
                if (o instanceof List) {
                    for (Object o2 : (List) o2) {
                        if (o2 instanceof Map) {
                            for (Entry entry : ((Map) o2).entrySet()) {
                                buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                            }
                        } else {
                            bh.m1642A("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + buildUpon.build().toString());
                            return;
                        }
                    }
                }
                bh.m1642A("ArbitraryPixel: additional params not a list: not sending partial hit: " + buildUpon.build().toString());
                return;
            }
            String uri = buildUpon.build().toString();
            this.aeq.li().bR(uri);
            bh.m1644C("ArbitraryPixel: url = " + uri);
            if (j != null) {
                synchronized (C1139i.class) {
                    aep.add(j);
                    cy.m1714a(this.mContext, aeo, j, "true");
                }
            }
        }
    }
}
