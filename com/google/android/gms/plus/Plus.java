package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.C0148b;
import com.google.android.gms.common.api.Api.C0149c;
import com.google.android.gms.common.api.C0153a.C1002b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.ki;
import com.google.android.gms.internal.kj;
import com.google.android.gms.internal.kk;
import com.google.android.gms.internal.kl;
import com.google.android.gms.internal.km;
import com.google.android.gms.plus.internal.C0916h;
import com.google.android.gms.plus.internal.C1138e;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import java.util.HashSet;
import java.util.Set;

public final class Plus {
    public static final Api<PlusOptions> API = new Api(yI, yH, new Scope[0]);
    public static final Account AccountApi = new ki();
    public static final Moments MomentsApi = new kl();
    public static final People PeopleApi = new km();
    public static final Scope SCOPE_PLUS_LOGIN = new Scope(Scopes.PLUS_LOGIN);
    public static final Scope SCOPE_PLUS_PROFILE = new Scope(Scopes.PLUS_ME);
    public static final C0429b abp = new kk();
    public static final C0428a abq = new kj();
    public static final C0149c<C1138e> yH = new C0149c();
    static final C0148b<C1138e, PlusOptions> yI = new C08971();

    static class C08971 implements C0148b<C1138e, PlusOptions> {
        C08971() {
        }

        public C1138e m2889a(Context context, Looper looper, gy gyVar, PlusOptions plusOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (plusOptions == null) {
                plusOptions = new PlusOptions();
            }
            return new C1138e(context, looper, connectionCallbacks, onConnectionFailedListener, new C0916h(gyVar.fj(), gyVar.fm(), (String[]) plusOptions.abs.toArray(new String[0]), new String[0], context.getPackageName(), context.getPackageName(), null, new PlusCommonExtras()));
        }

        public int getPriority() {
            return 2;
        }
    }

    public static final class PlusOptions implements Optional {
        final String abr;
        final Set<String> abs;

        public static final class Builder {
            String abr;
            final Set<String> abs = new HashSet();

            public Builder addActivityTypes(String... activityTypes) {
                hm.m1228b((Object) activityTypes, (Object) "activityTypes may not be null.");
                for (Object add : activityTypes) {
                    this.abs.add(add);
                }
                return this;
            }

            public PlusOptions build() {
                return new PlusOptions();
            }

            public Builder setServerClientId(String clientId) {
                this.abr = clientId;
                return this;
            }
        }

        private PlusOptions() {
            this.abr = null;
            this.abs = new HashSet();
        }

        private PlusOptions(Builder builder) {
            this.abr = builder.abr;
            this.abs = builder.abs;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    public static abstract class C1195a<R extends Result> extends C1002b<R, C1138e> {
        public C1195a() {
            super(Plus.yH);
        }
    }

    private Plus() {
    }

    public static C1138e m1550a(GoogleApiClient googleApiClient, C0149c<C1138e> c0149c) {
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
}
