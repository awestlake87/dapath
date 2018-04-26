package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C0147a;
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
import com.google.android.gms.internal.jb;
import com.google.android.gms.internal.jc;
import com.google.android.gms.internal.jg;

public class LocationServices {
    public static final Api<NoOptions> API = new Api(yI, yH, new Scope[0]);
    public static FusedLocationProviderApi FusedLocationApi = new jb();
    public static GeofencingApi GeofencingApi = new jc();
    private static final C0149c<jg> yH = new C0149c();
    private static final C0148b<jg, NoOptions> yI = new C08021();

    static class C08021 implements C0148b<jg, NoOptions> {
        C08021() {
        }

        public /* synthetic */ C0147a mo880a(Context context, Looper looper, gy gyVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m2836c(context, looper, gyVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public jg m2836c(Context context, Looper looper, gy gyVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new jg(context, looper, connectionCallbacks, onConnectionFailedListener, "locationServices");
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public static abstract class C1194a<R extends Result> extends C1002b<R, jg> {
        public C1194a() {
            super(LocationServices.yH);
        }
    }

    private LocationServices() {
    }

    public static jg m1478e(GoogleApiClient googleApiClient) {
        boolean z = true;
        hm.m1230b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        jg jgVar = (jg) googleApiClient.mo925a(yH);
        if (jgVar == null) {
            z = false;
        }
        hm.m1226a(z, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return jgVar;
    }
}
