package com.google.android.gms.analytics;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.fd;
import com.google.android.gms.internal.fe;
import com.google.android.gms.internal.fe.C0729a;
import java.util.List;
import java.util.Map;

class C0581c implements C0108b {
    private Context mContext;
    private fe tA;
    private ServiceConnection tx;
    private C0110b ty;
    private C0111c tz;

    final class C0109a implements ServiceConnection {
        final /* synthetic */ C0581c tB;

        C0109a(C0581c c0581c) {
            this.tB = c0581c;
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            aa.m39C("service connected, binder: " + binder);
            try {
                if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(binder.getInterfaceDescriptor())) {
                    aa.m39C("bound to service");
                    this.tB.tA = C0729a.m2577z(binder);
                    this.tB.co();
                    return;
                }
            } catch (RemoteException e) {
            }
            this.tB.mContext.unbindService(this);
            this.tB.tx = null;
            this.tB.tz.mo865a(2, null);
        }

        public void onServiceDisconnected(ComponentName component) {
            aa.m39C("service disconnected: " + component);
            this.tB.tx = null;
            this.tB.ty.onDisconnected();
        }
    }

    public interface C0110b {
        void onConnected();

        void onDisconnected();
    }

    public interface C0111c {
        void mo865a(int i, Intent intent);
    }

    public C0581c(Context context, C0110b c0110b, C0111c c0111c) {
        this.mContext = context;
        if (c0110b == null) {
            throw new IllegalArgumentException("onConnectedListener cannot be null");
        }
        this.ty = c0110b;
        if (c0111c == null) {
            throw new IllegalArgumentException("onConnectionFailedListener cannot be null");
        }
        this.tz = c0111c;
    }

    private fe cm() {
        cn();
        return this.tA;
    }

    private void co() {
        cp();
    }

    private void cp() {
        this.ty.onConnected();
    }

    public void mo849a(Map<String, String> map, long j, String str, List<fd> list) {
        try {
            cm().mo1696a(map, j, str, list);
        } catch (RemoteException e) {
            aa.m37A("sendHit failed: " + e);
        }
    }

    public void cl() {
        try {
            cm().cl();
        } catch (RemoteException e) {
            aa.m37A("clear hits failed: " + e);
        }
    }

    protected void cn() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect() {
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, "com.google.android.gms.analytics.service.AnalyticsService"));
        intent.putExtra("app_package_name", this.mContext.getPackageName());
        if (this.tx != null) {
            aa.m37A("Calling connect() while still connected, missing disconnect().");
            return;
        }
        this.tx = new C0109a(this);
        boolean bindService = this.mContext.bindService(intent, this.tx, 129);
        aa.m39C("connect: bindService returned " + bindService + " for " + intent);
        if (!bindService) {
            this.tx = null;
            this.tz.mo865a(1, null);
        }
    }

    public void disconnect() {
        this.tA = null;
        if (this.tx != null) {
            try {
                this.mContext.unbindService(this.tx);
            } catch (IllegalStateException e) {
            } catch (IllegalArgumentException e2) {
            }
            this.tx = null;
            this.ty.onDisconnected();
        }
    }

    public boolean isConnected() {
        return this.tA != null;
    }
}
