package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognition.C1193a;
import com.google.android.gms.location.ActivityRecognitionApi;

public class ja implements ActivityRecognitionApi {

    private static abstract class C1246a extends C1193a<Status> {
        private C1246a() {
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4251d(status);
        }

        public Status m4251d(Status status) {
            return status;
        }
    }

    public PendingResult<Status> removeActivityUpdates(GoogleApiClient client, final PendingIntent callbackIntent) {
        return client.mo927b(new C1246a(this) {
            final /* synthetic */ ja Vv;

            protected void m4635a(jg jgVar) throws RemoteException {
                jgVar.removeActivityUpdates(callbackIntent);
                m1984b(Status.En);
            }
        });
    }

    public PendingResult<Status> requestActivityUpdates(GoogleApiClient client, final long detectionIntervalMillis, final PendingIntent callbackIntent) {
        return client.mo927b(new C1246a(this) {
            final /* synthetic */ ja Vv;

            protected void m4633a(jg jgVar) throws RemoteException {
                jgVar.requestActivityUpdates(detectionIntervalMillis, callbackIntent);
                m1984b(Status.En);
            }
        });
    }
}
