package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.C0148b;
import com.google.android.gms.common.api.Api.C0149c;
import com.google.android.gms.common.api.C0153a.C1002b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.iw;

public final class Address {
    public static final Api<AddressOptions> API = new Api(yI, yH, new Scope[0]);
    static final C0149c<iw> yH = new C0149c();
    private static final C0148b<iw, AddressOptions> yI = new C06651();

    static class C06651 implements C0148b<iw, AddressOptions> {
        C06651() {
        }

        public iw m2436a(Context context, Looper looper, gy gyVar, AddressOptions addressOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            hm.m1230b(context instanceof Activity, (Object) "An Activity must be used for Address APIs");
            if (addressOptions == null) {
                addressOptions = new AddressOptions();
            }
            return new iw((Activity) context, looper, connectionCallbacks, onConnectionFailedListener, gyVar.getAccountName(), addressOptions.theme);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public static final class AddressOptions implements HasOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int theme) {
            this.theme = theme;
        }
    }

    private static abstract class C1175a extends C1002b<Status, iw> {
        public C1175a() {
            super(Address.yH);
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4055d(status);
        }

        public Status m4055d(Status status) {
            return status;
        }
    }

    public static void requestUserAddress(GoogleApiClient googleApiClient, final UserAddressRequest request, final int requestCode) {
        googleApiClient.mo926a(new C1175a() {
            protected void m4244a(iw iwVar) throws RemoteException {
                iwVar.m3684a(request, requestCode);
                m1984b(Status.En);
            }
        });
    }
}
