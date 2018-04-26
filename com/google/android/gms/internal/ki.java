package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.C0149c;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.Plus.C1195a;
import com.google.android.gms.plus.internal.C1138e;

public final class ki implements Account {

    private static abstract class C1251a extends C1195a<Status> {
        private C1251a() {
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4260d(status);
        }

        public Status m4260d(Status status) {
            return status;
        }
    }

    class C14051 extends C1251a {
        final /* synthetic */ ki acd;

        C14051(ki kiVar) {
            this.acd = kiVar;
            super();
        }

        protected void m4659a(C1138e c1138e) {
            c1138e.m3808m(this);
        }
    }

    private static C1138e m2790a(GoogleApiClient googleApiClient, C0149c<C1138e> c0149c) {
        boolean z = true;
        hm.m1230b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        hm.m1226a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        C1138e c1138e = (C1138e) googleApiClient.mo925a((C0149c) c0149c);
        if (c1138e == null) {
            z = false;
        }
        hm.m1226a(z, "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        return c1138e;
    }

    public void clearDefaultAccount(GoogleApiClient googleApiClient) {
        m2790a(googleApiClient, Plus.yH).clearDefaultAccount();
    }

    public String getAccountName(GoogleApiClient googleApiClient) {
        return m2790a(googleApiClient, Plus.yH).getAccountName();
    }

    public PendingResult<Status> revokeAccessAndDisconnect(GoogleApiClient googleApiClient) {
        return googleApiClient.mo927b(new C14051(this));
    }
}
