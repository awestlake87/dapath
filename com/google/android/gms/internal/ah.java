package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0255g;
import com.google.android.gms.dynamic.C1030e;
import com.google.android.gms.internal.aq.C0674a;
import com.google.android.gms.internal.ar.C0676a;

public final class ah extends C0255g<ar> {
    private static final ah lR = new ah();

    private ah() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public static aq m2450a(Context context, al alVar, String str, bs bsVar) {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            aq b = lR.m2451b(context, alVar, str, bsVar);
            if (b != null) {
                return b;
            }
        }
        eu.m1019z("Using AdManager from the client jar.");
        return new C1119u(context, alVar, str, bsVar, new ev(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, true));
    }

    private aq m2451b(Context context, al alVar, String str, bs bsVar) {
        try {
            return C0674a.m2466f(((ar) m469G(context)).mo1606a(C1030e.m3260h(context), alVar, str, bsVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE));
        } catch (Throwable e) {
            eu.m1017c("Could not create remote AdManager.", e);
            return null;
        } catch (Throwable e2) {
            eu.m1017c("Could not create remote AdManager.", e2);
            return null;
        }
    }

    protected ar m2452c(IBinder iBinder) {
        return C0676a.m2468g(iBinder);
    }

    protected /* synthetic */ Object mo1585d(IBinder iBinder) {
        return m2452c(iBinder);
    }
}
