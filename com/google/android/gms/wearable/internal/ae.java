package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public final class ae implements MessageApi {

    public static class C1147a implements SendMessageResult {
        private final int ra;
        private final Status yz;

        public C1147a(Status status, int i) {
            this.yz = status;
            this.ra = i;
        }

        public int getRequestId() {
            return this.ra;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private PendingResult<Status> m3161a(GoogleApiClient googleApiClient, final MessageListener messageListener, final IntentFilter[] intentFilterArr) {
        return googleApiClient.mo926a(new C1212d<Status>(this) {
            final /* synthetic */ ae alT;

            protected void m4273a(au auVar) throws RemoteException {
                auVar.m3882a((C0152d) this, messageListener, intentFilterArr);
            }

            public /* synthetic */ Result mo2535c(Status status) {
                return m4275d(status);
            }

            public Status m4275d(Status status) {
                return new Status(13);
            }
        });
    }

    public PendingResult<Status> addListener(GoogleApiClient client, MessageListener listener) {
        return m3161a(client, listener, null);
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final MessageListener listener) {
        return client.mo926a(new C1212d<Status>(this) {
            final /* synthetic */ ae alT;

            protected void m4277a(au auVar) throws RemoteException {
                auVar.m3881a((C0152d) this, listener);
            }

            public /* synthetic */ Result mo2535c(Status status) {
                return m4279d(status);
            }

            public Status m4279d(Status status) {
                return new Status(13);
            }
        });
    }

    public PendingResult<SendMessageResult> sendMessage(GoogleApiClient client, final String nodeId, final String action, final byte[] data) {
        return client.mo926a(new C1212d<SendMessageResult>(this) {
            final /* synthetic */ ae alT;

            protected void m4270a(au auVar) throws RemoteException {
                auVar.m3886a(this, nodeId, action, data);
            }

            protected SendMessageResult au(Status status) {
                return new C1147a(status, -1);
            }

            protected /* synthetic */ Result mo2535c(Status status) {
                return au(status);
            }
        });
    }
}
