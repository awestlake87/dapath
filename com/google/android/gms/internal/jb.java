package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationServices.C1194a;

public class jb implements FusedLocationProviderApi {

    private static abstract class C1247a extends C1194a<Status> {
        private C1247a() {
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4253d(status);
        }

        public Status m4253d(Status status) {
            return status;
        }
    }

    public Location getLastLocation(GoogleApiClient client) {
        try {
            return LocationServices.m1478e(client).getLastLocation();
        } catch (Exception e) {
            return null;
        }
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, final PendingIntent callbackIntent) {
        return client.mo927b(new C1247a(this) {
            final /* synthetic */ jb Vy;

            protected void m4645a(jg jgVar) throws RemoteException {
                jgVar.removeLocationUpdates(callbackIntent);
                m1984b(Status.En);
            }
        });
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, final LocationListener listener) {
        return client.mo927b(new C1247a(this) {
            final /* synthetic */ jb Vy;

            protected void m4643a(jg jgVar) throws RemoteException {
                jgVar.removeLocationUpdates(listener);
                m1984b(Status.En);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final PendingIntent callbackIntent) {
        return client.mo927b(new C1247a(this) {
            final /* synthetic */ jb Vy;

            protected void m4641a(jg jgVar) throws RemoteException {
                jgVar.requestLocationUpdates(request, callbackIntent);
                m1984b(Status.En);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final LocationListener listener) {
        return client.mo927b(new C1247a(this) {
            final /* synthetic */ jb Vy;

            protected void m4637a(jg jgVar) throws RemoteException {
                jgVar.requestLocationUpdates(request, listener);
                m1984b(Status.En);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final LocationListener listener, final Looper looper) {
        return client.mo927b(new C1247a(this) {
            final /* synthetic */ jb Vy;

            protected void m4639a(jg jgVar) throws RemoteException {
                jgVar.requestLocationUpdates(request, listener, looper);
                m1984b(Status.En);
            }
        });
    }

    public PendingResult<Status> setMockLocation(GoogleApiClient client, final Location mockLocation) {
        return client.mo927b(new C1247a(this) {
            final /* synthetic */ jb Vy;

            protected void m4649a(jg jgVar) throws RemoteException {
                jgVar.setMockLocation(mockLocation);
                m1984b(Status.En);
            }
        });
    }

    public PendingResult<Status> setMockMode(GoogleApiClient client, final boolean isMockMode) {
        return client.mo927b(new C1247a(this) {
            final /* synthetic */ jb Vy;

            protected void m4647a(jg jgVar) throws RemoteException {
                jgVar.setMockMode(isMockMode);
                m1984b(Status.En);
            }
        });
    }
}
