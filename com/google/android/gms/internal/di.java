package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.dynamic.C0255g;
import com.google.android.gms.dynamic.C1030e;
import com.google.android.gms.internal.dd.C0703a;
import com.google.android.gms.internal.de.C0705a;

public final class di extends C0255g<de> {
    private static final di pv = new di();

    private static final class C0296a extends Exception {
        public C0296a(String str) {
            super(str);
        }
    }

    private di() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    private static boolean m2536b(Activity activity) throws C0296a {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
        }
        throw new C0296a("InAppPurchaseManager requires the useClientJar flag in intent extras.");
    }

    public static dd m2537d(Activity activity) {
        try {
            if (!m2536b(activity)) {
                return pv.m2538e(activity);
            }
            eu.m1019z("Using AdOverlay from the client jar.");
            return new cu(activity);
        } catch (C0296a e) {
            eu.m1014D(e.getMessage());
            return null;
        }
    }

    private dd m2538e(Activity activity) {
        try {
            return C0703a.m2530r(((de) m469G(activity)).mo1674b(C1030e.m3260h(activity)));
        } catch (Throwable e) {
            eu.m1017c("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (Throwable e2) {
            eu.m1017c("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }

    protected /* synthetic */ Object mo1585d(IBinder iBinder) {
        return m2540v(iBinder);
    }

    protected de m2540v(IBinder iBinder) {
        return C0705a.m2532s(iBinder);
    }
}
