package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import java.util.List;

public final class ah implements NodeApi {

    public static class C1148a implements GetConnectedNodesResult {
        private final List<Node> alZ;
        private final Status yz;

        public C1148a(Status status, List<Node> list) {
            this.yz = status;
            this.alZ = list;
        }

        public List<Node> getNodes() {
            return this.alZ;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    public static class C1149b implements GetLocalNodeResult {
        private final Node ama;
        private final Status yz;

        public C1149b(Status status, Node node) {
            this.yz = status;
            this.ama = node;
        }

        public Node getNode() {
            return this.ama;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    class C12601 extends C1212d<GetLocalNodeResult> {
        final /* synthetic */ ah alX;

        C12601(ah ahVar) {
            this.alX = ahVar;
        }

        protected void m4281a(au auVar) throws RemoteException {
            auVar.m3892p(this);
        }

        protected GetLocalNodeResult av(Status status) {
            return new C1149b(status, null);
        }

        protected /* synthetic */ Result mo2535c(Status status) {
            return av(status);
        }
    }

    class C12612 extends C1212d<GetConnectedNodesResult> {
        final /* synthetic */ ah alX;

        C12612(ah ahVar) {
            this.alX = ahVar;
        }

        protected void m4284a(au auVar) throws RemoteException {
            auVar.m3893q(this);
        }

        protected GetConnectedNodesResult aw(Status status) {
            return new C1148a(status, null);
        }

        protected /* synthetic */ Result mo2535c(Status status) {
            return aw(status);
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, final NodeListener listener) {
        return client.mo926a(new C1212d<Status>(this) {
            final /* synthetic */ ah alX;

            protected void m4287a(au auVar) throws RemoteException {
                auVar.m3883a((C0152d) this, listener);
            }

            public /* synthetic */ Result mo2535c(Status status) {
                return m4289d(status);
            }

            public Status m4289d(Status status) {
                return new Status(13);
            }
        });
    }

    public PendingResult<GetConnectedNodesResult> getConnectedNodes(GoogleApiClient client) {
        return client.mo926a(new C12612(this));
    }

    public PendingResult<GetLocalNodeResult> getLocalNode(GoogleApiClient client) {
        return client.mo926a(new C12601(this));
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final NodeListener listener) {
        return client.mo926a(new C1212d<Status>(this) {
            final /* synthetic */ ah alX;

            protected void m4291a(au auVar) throws RemoteException {
                auVar.m3889b((C0152d) this, listener);
            }

            public /* synthetic */ Result mo2535c(Status status) {
                return m4293d(status);
            }

            public Status m4293d(Status status) {
                return new Status(13);
            }
        });
    }
}
