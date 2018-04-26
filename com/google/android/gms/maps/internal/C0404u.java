package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C1030e;
import com.google.android.gms.internal.hm;
import com.google.android.gms.maps.internal.C0386c.C0842a;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class C0404u {
    private static Context aaj;
    private static C0386c aak;

    public static C0386c m1505H(Context context) throws GooglePlayServicesNotAvailableException {
        hm.m1232f(context);
        if (aak != null) {
            return aak;
        }
        C0404u.m1506I(context);
        aak = C0404u.m1507J(context);
        try {
            aak.mo2091a(C1030e.m3260h(C0404u.getRemoteContext(context).getResources()), (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            return aak;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    private static void m1506I(Context context) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        switch (isGooglePlayServicesAvailable) {
            case 0:
                return;
            default:
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
    }

    private static C0386c m1507J(Context context) {
        if (C0404u.jJ()) {
            Log.i(C0404u.class.getSimpleName(), "Making Creator statically");
            return (C0386c) C0404u.m1509c(C0404u.jK());
        }
        Log.i(C0404u.class.getSimpleName(), "Making Creator dynamically");
        return C0842a.ax((IBinder) C0404u.m1508a(C0404u.getRemoteContext(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
    }

    private static <T> T m1508a(ClassLoader classLoader, String str) {
        try {
            return C0404u.m1509c(((ClassLoader) hm.m1232f(classLoader)).loadClass(str));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to find dynamic class " + str);
        }
    }

    private static <T> T m1509c(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + cls.getName());
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unable to call the default constructor of " + cls.getName());
        }
    }

    private static Context getRemoteContext(Context context) {
        if (aaj == null) {
            if (C0404u.jJ()) {
                aaj = context.getApplicationContext();
            } else {
                aaj = GooglePlayServicesUtil.getRemoteContext(context);
            }
        }
        return aaj;
    }

    private static boolean jJ() {
        return false;
    }

    private static Class<?> jK() {
        try {
            return VERSION.SDK_INT < 15 ? Class.forName("com.google.android.gms.maps.internal.CreatorImplGmm6") : Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
