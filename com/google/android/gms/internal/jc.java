package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.LocationClient.OnAddGeofencesResultListener;
import com.google.android.gms.location.LocationClient.OnRemoveGeofencesResultListener;
import com.google.android.gms.location.LocationServices.C1194a;
import com.google.android.gms.location.LocationStatusCodes;
import java.util.ArrayList;
import java.util.List;

public class jc implements GeofencingApi {

    private static abstract class C1248a extends C1194a<Status> {
        private C1248a() {
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4255d(status);
        }

        public Status m4255d(Status status) {
            return status;
        }
    }

    public PendingResult<Status> addGeofences(GoogleApiClient client, List<Geofence> geofences, final PendingIntent pendingIntent) {
        List list;
        if (geofences != null) {
            List arrayList = new ArrayList(geofences.size());
            for (Geofence geofence : geofences) {
                hm.m1230b(geofence instanceof jh, (Object) "Geofence must be created using Geofence.Builder.");
                arrayList.add((jh) geofence);
            }
            list = arrayList;
        } else {
            list = null;
        }
        return client.mo927b(new C1248a(this) {
            final /* synthetic */ jc VE;

            class C07651 implements OnAddGeofencesResultListener {
                final /* synthetic */ C14001 VF;

                C07651(C14001 c14001) {
                    this.VF = c14001;
                }

                public void onAddGeofencesResult(int statusCode, String[] geofenceRequestIds) {
                    this.VF.m1984b(LocationStatusCodes.cK(statusCode));
                }
            }

            protected void m4651a(jg jgVar) throws RemoteException {
                jgVar.addGeofences(list, pendingIntent, new C07651(this));
            }
        });
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient client, final PendingIntent pendingIntent) {
        return client.mo927b(new C1248a(this) {
            final /* synthetic */ jc VE;

            class C07661 implements OnRemoveGeofencesResultListener {
                final /* synthetic */ C14012 VG;

                C07661(C14012 c14012) {
                    this.VG = c14012;
                }

                public void onRemoveGeofencesByPendingIntentResult(int statusCode, PendingIntent pendingIntent) {
                    this.VG.m1984b(LocationStatusCodes.cK(statusCode));
                }

                public void onRemoveGeofencesByRequestIdsResult(int statusCode, String[] geofenceRequestIds) {
                    Log.wtf("GeofencingImpl", "Request ID callback shouldn't have been called");
                }
            }

            protected void m4653a(jg jgVar) throws RemoteException {
                jgVar.removeGeofences(pendingIntent, new C07661(this));
            }
        });
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient client, final List<String> geofenceRequestIds) {
        return client.mo927b(new C1248a(this) {
            final /* synthetic */ jc VE;

            class C07671 implements OnRemoveGeofencesResultListener {
                final /* synthetic */ C14023 VI;

                C07671(C14023 c14023) {
                    this.VI = c14023;
                }

                public void onRemoveGeofencesByPendingIntentResult(int statusCode, PendingIntent pendingIntent) {
                    Log.wtf("GeofencingImpl", "PendingIntent callback shouldn't have been called");
                }

                public void onRemoveGeofencesByRequestIdsResult(int statusCode, String[] geofenceRequestIds) {
                    this.VI.m1984b(LocationStatusCodes.cK(statusCode));
                }
            }

            protected void m4655a(jg jgVar) throws RemoteException {
                jgVar.removeGeofences(geofenceRequestIds, new C07671(this));
            }
        });
    }
}
