package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.dynamic.C0255g;
import com.google.android.gms.dynamic.C1030e;
import com.google.android.gms.internal.cn.C0695a;
import com.google.android.gms.internal.co.C0697a;

public final class cm extends C0255g<co> {
    private static final cm oS = new cm();

    private static final class C0292a extends Exception {
        public C0292a(String str) {
            super(str);
        }
    }

    private cm() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static cn m2510a(Activity activity) {
        try {
            if (!m2511b(activity)) {
                return oS.m2512c(activity);
            }
            eu.m1019z("Using AdOverlay from the client jar.");
            return new cf(activity);
        } catch (C0292a e) {
            eu.m1014D(e.getMessage());
            return null;
        }
    }

    private static boolean m2511b(Activity activity) throws C0292a {
        Intent intent = activity.getIntent();
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            return intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        throw new C0292a("Ad overlay requires the useClientJar flag in intent extras.");
    }

    private cn m2512c(Activity activity) {
        try {
            return C0695a.m2516m(((co) m469G(activity)).mo1664a(C1030e.m3260h(activity)));
        } catch (Throwable e) {
            eu.m1017c("Could not create remote AdOverlay.", e);
            return null;
        } catch (Throwable e2) {
            eu.m1017c("Could not create remote AdOverlay.", e2);
            return null;
        }
    }

    protected /* synthetic */ Object mo1585d(IBinder iBinder) {
        return m2514l(iBinder);
    }

    protected co m2514l(IBinder iBinder) {
        return C0697a.m2518n(iBinder);
    }
}
