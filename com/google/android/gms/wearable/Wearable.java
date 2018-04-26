package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.C0148b;
import com.google.android.gms.common.api.Api.C0149c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.gy;
import com.google.android.gms.wearable.internal.C0981e;
import com.google.android.gms.wearable.internal.C0982f;
import com.google.android.gms.wearable.internal.ae;
import com.google.android.gms.wearable.internal.ah;
import com.google.android.gms.wearable.internal.au;

public class Wearable {
    public static final Api<WearableOptions> API = new Api(yI, yH, new Scope[0]);
    public static final DataApi DataApi = new C0982f();
    public static final MessageApi MessageApi = new ae();
    public static final NodeApi NodeApi = new ah();
    public static final C0537b alp = new C0981e();
    public static final C0149c<au> yH = new C0149c();
    private static final C0148b<au, WearableOptions> yI = new C09721();

    static class C09721 implements C0148b<au, WearableOptions> {
        C09721() {
        }

        public au m3123a(Context context, Looper looper, gy gyVar, WearableOptions wearableOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (wearableOptions == null) {
                WearableOptions wearableOptions2 = new WearableOptions(new Builder());
            }
            return new au(context, looper, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public static final class WearableOptions implements Optional {

        public static class Builder {
            public WearableOptions build() {
                return new WearableOptions();
            }
        }

        private WearableOptions(Builder builder) {
        }
    }

    private Wearable() {
    }
}
