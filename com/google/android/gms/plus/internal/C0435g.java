package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C1030e;
import com.google.android.gms.internal.hm;
import com.google.android.gms.plus.PlusOneDummyView;
import com.google.android.gms.plus.internal.C0431c.C0911a;

public final class C0435g {
    private static Context aaj;
    private static C0431c abS;

    public static class C0434a extends Exception {
        public C0434a(String str) {
            super(str);
        }
    }

    private static C0431c m1580K(Context context) throws C0434a {
        hm.m1232f(context);
        if (abS == null) {
            if (aaj == null) {
                aaj = GooglePlayServicesUtil.getRemoteContext(context);
                if (aaj == null) {
                    throw new C0434a("Could not get remote context.");
                }
            }
            try {
                abS = C0911a.bl((IBinder) aaj.getClassLoader().loadClass("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl").newInstance());
            } catch (ClassNotFoundException e) {
                throw new C0434a("Could not load creator class.");
            } catch (InstantiationException e2) {
                throw new C0434a("Could not instantiate creator.");
            } catch (IllegalAccessException e3) {
                throw new C0434a("Could not access creator.");
            }
        }
        return abS;
    }

    public static View m1581a(Context context, int i, int i2, String str, int i3) {
        if (str != null) {
            return (View) C1030e.m3259e(C0435g.m1580K(context).mo2263a(C1030e.m3260h(context), i, i2, str, i3));
        }
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            return new PlusOneDummyView(context, i);
        }
    }
}
