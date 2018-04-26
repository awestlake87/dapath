package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C0148b;
import com.google.android.gms.common.api.Api.C0149c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;

public final class ff {
    public static final C0149c<fx> xI = new C0149c();
    private static final C0148b<fx, NoOptions> xJ = new C07301();
    public static final Api<NoOptions> xK = new Api(xJ, xI, new Scope[0]);
    public static final ft xL = new fy();

    static class C07301 implements C0148b<fx, NoOptions> {
        C07301() {
        }

        public fx m2579a(Context context, Looper looper, gy gyVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new fx(context, looper, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }
}
