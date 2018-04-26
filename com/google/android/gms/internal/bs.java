package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.bt.C0688a;
import java.util.Map;

public final class bs extends C0688a {
    private Map<Class<? extends NetworkExtras>, NetworkExtras> nQ;

    private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> bu m3491n(String str) throws RemoteException {
        try {
            Class cls = Class.forName(str, false, bs.class.getClassLoader());
            if (MediationAdapter.class.isAssignableFrom(cls)) {
                MediationAdapter mediationAdapter = (MediationAdapter) cls.newInstance();
                return new bz(mediationAdapter, (com.google.ads.mediation.NetworkExtras) this.nQ.get(mediationAdapter.getAdditionalParametersType()));
            } else if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom(cls)) {
                return new bx((com.google.android.gms.ads.mediation.MediationAdapter) cls.newInstance());
            } else {
                eu.m1014D("Could not instantiate mediation adapter: " + str + " (not a valid adapter).");
                throw new RemoteException();
            }
        } catch (Throwable th) {
            eu.m1014D("Could not instantiate mediation adapter: " + str + ". " + th.getMessage());
            RemoteException remoteException = new RemoteException();
        }
    }

    public void m3492c(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        this.nQ = map;
    }

    public bu mo1611m(String str) throws RemoteException {
        return m3491n(str);
    }
}
