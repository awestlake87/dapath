package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.C0146a;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C0371s;
import com.google.android.gms.internal.C0371s.C0797a;
import com.google.android.gms.internal.hm;
import java.io.IOException;

public final class AdvertisingIdClient {

    public static final class Info {
        private final boolean kA;
        private final String kz;

        public Info(String advertisingId, boolean limitAdTrackingEnabled) {
            this.kz = advertisingId;
            this.kA = limitAdTrackingEnabled;
        }

        public String getId() {
            return this.kz;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.kA;
        }
    }

    static Info m13a(Context context, C0146a c0146a) throws IOException {
        try {
            C0371s b = C0797a.m2824b(c0146a.ew());
            Info info = new Info(b.getId(), b.mo1917a(true));
            try {
                context.unbindService(c0146a);
            } catch (Throwable e) {
                Log.i("AdvertisingIdClient", "getAdvertisingIdInfo unbindService failed.", e);
            }
            return info;
        } catch (Throwable e2) {
            Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
            throw new IOException("Remote exception");
        } catch (InterruptedException e3) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            try {
                context.unbindService(c0146a);
            } catch (Throwable e4) {
                Log.i("AdvertisingIdClient", "getAdvertisingIdInfo unbindService failed.", e4);
            }
        }
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        hm.az("Calling this from your main thread can lead to deadlock");
        return m13a(context, m14j(context));
    }

    static C0146a m14j(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 0);
            try {
                GooglePlayServicesUtil.m141z(context);
                Object c0146a = new C0146a();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
                if (context.bindService(intent, c0146a, 1)) {
                    return c0146a;
                }
                throw new IOException("Connection failure");
            } catch (Throwable e) {
                throw new IOException(e);
            }
        } catch (NameNotFoundException e2) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }
}
