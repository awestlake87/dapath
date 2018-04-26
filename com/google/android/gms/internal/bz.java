package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.C0252d;
import com.google.android.gms.dynamic.C1030e;
import com.google.android.gms.internal.bu.C0690a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class bz<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends C0690a {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> nU;
    private final NETWORK_EXTRAS nV;

    public bz(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.nU = mediationAdapter;
        this.nV = network_extras;
    }

    private SERVER_PARAMETERS m3499b(String str, int i, String str2) throws RemoteException {
        Map hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str3 = (String) keys.next();
                    hashMap.put(str3, jSONObject.getString(str3));
                }
            } catch (Throwable th) {
                eu.m1017c("Could not get MediationServerParameters.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class serverParametersType = this.nU.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        MediationServerParameters mediationServerParameters = (MediationServerParameters) serverParametersType.newInstance();
        mediationServerParameters.load(hashMap);
        return mediationServerParameters;
    }

    public void mo1612a(C0252d c0252d, ai aiVar, String str, bv bvVar) throws RemoteException {
        mo1613a(c0252d, aiVar, str, null, bvVar);
    }

    public void mo1613a(C0252d c0252d, ai aiVar, String str, String str2, bv bvVar) throws RemoteException {
        if (this.nU instanceof MediationInterstitialAdapter) {
            eu.m1019z("Requesting interstitial ad from adapter.");
            try {
                ((MediationInterstitialAdapter) this.nU).requestInterstitialAd(new ca(bvVar), (Activity) C1030e.m3259e(c0252d), m3499b(str, aiVar.lW, str2), cb.m845e(aiVar), this.nV);
            } catch (Throwable th) {
                eu.m1017c("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            eu.m1014D("MediationAdapter is not a MediationInterstitialAdapter: " + this.nU.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void mo1614a(C0252d c0252d, al alVar, ai aiVar, String str, bv bvVar) throws RemoteException {
        mo1615a(c0252d, alVar, aiVar, str, null, bvVar);
    }

    public void mo1615a(C0252d c0252d, al alVar, ai aiVar, String str, String str2, bv bvVar) throws RemoteException {
        if (this.nU instanceof MediationBannerAdapter) {
            eu.m1019z("Requesting banner ad from adapter.");
            try {
                ((MediationBannerAdapter) this.nU).requestBannerAd(new ca(bvVar), (Activity) C1030e.m3259e(c0252d), m3499b(str, aiVar.lW, str2), cb.m844b(alVar), cb.m845e(aiVar), this.nV);
            } catch (Throwable th) {
                eu.m1017c("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            eu.m1014D("MediationAdapter is not a MediationBannerAdapter: " + this.nU.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void destroy() throws RemoteException {
        try {
            this.nU.destroy();
        } catch (Throwable th) {
            eu.m1017c("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public C0252d getView() throws RemoteException {
        if (this.nU instanceof MediationBannerAdapter) {
            try {
                return C1030e.m3260h(((MediationBannerAdapter) this.nU).getBannerView());
            } catch (Throwable th) {
                eu.m1017c("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            eu.m1014D("MediationAdapter is not a MediationBannerAdapter: " + this.nU.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public void pause() throws RemoteException {
        throw new RemoteException();
    }

    public void resume() throws RemoteException {
        throw new RemoteException();
    }

    public void showInterstitial() throws RemoteException {
        if (this.nU instanceof MediationInterstitialAdapter) {
            eu.m1019z("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.nU).showInterstitial();
            } catch (Throwable th) {
                eu.m1017c("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            eu.m1014D("MediationAdapter is not a MediationInterstitialAdapter: " + this.nU.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }
}
