package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.fu.C0733a;
import com.google.android.gms.internal.hb.C1092e;

public class fx extends hb<fu> {
    public fx(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, new String[0]);
    }

    protected fu m3594C(IBinder iBinder) {
        return C0733a.m2590A(iBinder);
    }

    protected void mo2552a(hi hiVar, C1092e c1092e) throws RemoteException {
        hiVar.mo1764b(c1092e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName());
    }

    protected String bu() {
        return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
    }

    protected String bv() {
        return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
    }

    public fu dR() {
        return (fu) ft();
    }

    protected /* synthetic */ IInterface mo2555x(IBinder iBinder) {
        return m3594C(iBinder);
    }
}
