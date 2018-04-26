package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.C0181b;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.drive.internal.C0621p.C1223j;
import com.google.android.gms.drive.internal.C0621p.C1302k;
import com.google.android.gms.drive.internal.aa.C0616a;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.C1092e;
import com.google.android.gms.internal.hh;
import com.google.android.gms.internal.hi;
import com.google.android.gms.internal.hm;
import java.util.HashMap;
import java.util.Map;

public class C1015r extends hb<aa> {
    private final String IQ;
    private final Bundle IR;
    private DriveId IS;
    private DriveId IT;
    final ConnectionCallbacks IU;
    Map<DriveId, Map<Listener<?>, C1021x<?>>> IV = new HashMap();
    private final String yQ;

    public C1015r(Context context, Looper looper, gy gyVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String[] strArr, Bundle bundle) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.yQ = (String) hm.m1228b(gyVar.fj(), (Object) "Must call Api.ClientBuilder.setAccountName()");
        this.IQ = gyVar.fn();
        this.IU = connectionCallbacks;
        this.IR = bundle;
    }

    protected aa m3217O(IBinder iBinder) {
        return C0616a.m2061P(iBinder);
    }

    <C extends DriveEvent> PendingResult<Status> m3218a(GoogleApiClient googleApiClient, final DriveId driveId, final int i, Listener<C> listener) {
        PendingResult<Status> c1302k;
        hm.m1230b(C0181b.m272a(i, driveId), (Object) "id");
        hm.m1228b((Object) listener, (Object) "listener");
        hm.m1226a(isConnected(), "Client must be connected");
        synchronized (this.IV) {
            Map map = (Map) this.IV.get(driveId);
            if (map == null) {
                map = new HashMap();
                this.IV.put(driveId, map);
            }
            if (map.containsKey(listener)) {
                c1302k = new C1302k(googleApiClient, Status.En);
            } else {
                final C1021x c1021x = new C1021x(getLooper(), i, listener);
                map.put(listener, c1021x);
                c1302k = googleApiClient.mo927b(new C1223j(this) {
                    final /* synthetic */ C1015r IZ;

                    protected void m4390a(C1015r c1015r) throws RemoteException {
                        c1015r.gp().mo949a(new AddEventListenerRequest(driveId, i, null), c1021x, null, new aw(this));
                    }
                });
            }
        }
        return c1302k;
    }

    protected void mo2551a(int i, IBinder iBinder, Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.IS = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.IT = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
        }
        super.mo2551a(i, iBinder, bundle);
    }

    protected void mo2552a(hi hiVar, C1092e c1092e) throws RemoteException {
        String packageName = getContext().getPackageName();
        hm.m1232f(c1092e);
        hm.m1232f(packageName);
        hm.m1232f(fs());
        Bundle bundle = new Bundle();
        bundle.putString("proxy_package_name", this.IQ);
        bundle.putAll(this.IR);
        hiVar.mo1763a((hh) c1092e, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, packageName, fs(), this.yQ, bundle);
    }

    PendingResult<Status> m3221b(GoogleApiClient googleApiClient, final DriveId driveId, final int i, Listener<?> listener) {
        PendingResult<Status> c1302k;
        hm.m1230b(C0181b.m272a(i, driveId), (Object) "id");
        hm.m1226a(isConnected(), "Client must be connected");
        hm.m1228b((Object) listener, (Object) "listener");
        synchronized (this.IV) {
            Map map = (Map) this.IV.get(driveId);
            if (map == null) {
                c1302k = new C1302k(googleApiClient, Status.En);
            } else {
                final C1021x c1021x = (C1021x) map.remove(listener);
                if (c1021x == null) {
                    c1302k = new C1302k(googleApiClient, Status.En);
                } else {
                    if (map.isEmpty()) {
                        this.IV.remove(driveId);
                    }
                    c1302k = googleApiClient.mo927b(new C1223j(this) {
                        final /* synthetic */ C1015r IZ;

                        protected void m4392a(C1015r c1015r) throws RemoteException {
                            c1015r.gp().mo966a(new RemoveEventListenerRequest(driveId, i), c1021x, null, new aw(this));
                        }
                    });
                }
            }
        }
        return c1302k;
    }

    protected String bu() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    protected String bv() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    public void disconnect() {
        aa aaVar = (aa) ft();
        if (aaVar != null) {
            try {
                aaVar.mo959a(new DisconnectRequest());
            } catch (RemoteException e) {
            }
        }
        super.disconnect();
        this.IV.clear();
    }

    public aa gp() {
        return (aa) ft();
    }

    public DriveId gq() {
        return this.IS;
    }

    public DriveId gr() {
        return this.IT;
    }

    protected /* synthetic */ IInterface mo2555x(IBinder iBinder) {
        return m3217O(iBinder);
    }
}
