package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C0147a;
import com.google.android.gms.common.api.Api.C0148b;
import com.google.android.gms.common.api.Api.C0149c;
import com.google.android.gms.common.api.C0153a.C1002b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.ja;
import com.google.android.gms.internal.jg;

public class ActivityRecognition {
    public static final Api<NoOptions> API = new Api(yI, yH, new Scope[0]);
    public static ActivityRecognitionApi ActivityRecognitionApi = new ja();
    public static final String CLIENT_NAME = "activity_recognition";
    private static final C0149c<jg> yH = new C0149c();
    private static final C0148b<jg, NoOptions> yI = new C08011();

    static class C08011 implements C0148b<jg, NoOptions> {
        C08011() {
        }

        public /* synthetic */ C0147a mo880a(Context context, Looper looper, gy gyVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m2832c(context, looper, gyVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public jg m2832c(Context context, Looper looper, gy gyVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new jg(context, looper, connectionCallbacks, onConnectionFailedListener, ActivityRecognition.CLIENT_NAME);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public static abstract class C1193a<R extends Result> extends C1002b<R, jg> {
        public C1193a() {
            super(ActivityRecognition.yH);
        }
    }

    private ActivityRecognition() {
    }
}
