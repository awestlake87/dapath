package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.hb.C1092e;
import com.google.android.gms.internal.ke.C0780a;

public class kg extends hb<ke> {
    public kg(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, (String[]) null);
    }

    protected void mo2552a(hi hiVar, C1092e c1092e) throws RemoteException {
        hiVar.mo1755a((hh) c1092e, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), new Bundle());
    }

    public ke bj(IBinder iBinder) {
        return C0780a.bi(iBinder);
    }

    protected String bu() {
        return "com.google.android.gms.panorama.service.START";
    }

    protected String bv() {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }

    public /* synthetic */ IInterface mo2555x(IBinder iBinder) {
        return bj(iBinder);
    }
}
