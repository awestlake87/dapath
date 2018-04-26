package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.hm;
import java.lang.reflect.Method;

public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static Method aea = null;
    private static final Object qp = new Object();

    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }

    private static void m1587L(Context context) throws ClassNotFoundException, NoSuchMethodException {
        aea = context.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[]{Context.class});
    }

    public static void installIfNeeded(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        hm.m1228b((Object) context, (Object) "Context must not be null");
        GooglePlayServicesUtil.m141z(context);
        Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
        if (remoteContext == null) {
            Log.e("ProviderInstaller", "Failed to get remote context");
            throw new GooglePlayServicesNotAvailableException(8);
        }
        synchronized (qp) {
            try {
                if (aea == null) {
                    m1587L(remoteContext);
                }
                aea.invoke(null, new Object[]{remoteContext});
            } catch (Exception e) {
                Log.e("ProviderInstaller", "Failed to install provider: " + e.getMessage());
                throw new GooglePlayServicesNotAvailableException(8);
            }
        }
    }

    public static void installIfNeededAsync(final Context context, final ProviderInstallListener listener) {
        hm.m1228b((Object) context, (Object) "Context must not be null");
        hm.m1228b((Object) listener, (Object) "Listener must not be null");
        hm.ay("Must be called on the UI thread");
        new AsyncTask<Void, Void, Integer>() {
            protected Integer m1585b(Void... voidArr) {
                try {
                    ProviderInstaller.installIfNeeded(context);
                    return Integer.valueOf(0);
                } catch (GooglePlayServicesRepairableException e) {
                    return Integer.valueOf(e.getConnectionStatusCode());
                } catch (GooglePlayServicesNotAvailableException e2) {
                    return Integer.valueOf(e2.errorCode);
                }
            }

            protected void m1586d(Integer num) {
                if (num.intValue() == 0) {
                    listener.onProviderInstalled();
                    return;
                }
                listener.onProviderInstallFailed(num.intValue(), GooglePlayServicesUtil.m126Z(num.intValue()));
            }

            protected /* synthetic */ Object doInBackground(Object[] x0) {
                return m1585b((Void[]) x0);
            }

            protected /* synthetic */ void onPostExecute(Object x0) {
                m1586d((Integer) x0);
            }
        }.execute(new Void[0]);
    }
}
