package com.google.android.gms.panorama;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C0147a;
import com.google.android.gms.common.api.Api.C0148b;
import com.google.android.gms.common.api.Api.C0149c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.kf;
import com.google.android.gms.internal.kg;

public final class Panorama {
    public static final Api<NoOptions> API = new Api(yI, yH, new Scope[0]);
    public static final PanoramaApi PanoramaApi = new kf();
    public static final C0149c<kg> yH = new C0149c();
    static final C0148b<kg, NoOptions> yI = new C08961();

    static class C08961 implements C0148b<kg, NoOptions> {
        C08961() {
        }

        public /* synthetic */ C0147a mo880a(Context context, Looper looper, gy gyVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m2887d(context, looper, gyVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public kg m2887d(Context context, Looper looper, gy gyVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new kg(context, looper, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    private Panorama() {
    }
}
