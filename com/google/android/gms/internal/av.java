package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

public final class av {
    private AdListener lQ;
    private InAppPurchaseListener mB;
    private PlayStorePurchaseListener mC;
    private final Context mContext;
    private AppEventListener mh;
    private String mj;
    private final bs mw;
    private final ak mx;
    private aq my;
    private String mz;

    public av(Context context) {
        this(context, ak.aF());
    }

    public av(Context context, ak akVar) {
        this.mw = new bs();
        this.mContext = context;
        this.mx = akVar;
    }

    private void m823k(String str) throws RemoteException {
        if (this.mj == null) {
            m824l(str);
        }
        this.my = ah.m2450a(this.mContext, new al(), this.mj, this.mw);
        if (this.lQ != null) {
            this.my.mo1594a(new ag(this.lQ));
        }
        if (this.mh != null) {
            this.my.mo1595a(new an(this.mh));
        }
        if (this.mB != null) {
            this.my.mo1596a(new dh(this.mB));
        }
        if (this.mC != null) {
            this.my.mo1597a(new dl(this.mC), this.mz);
        }
    }

    private void m824l(String str) {
        if (this.my == null) {
            throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + str + " is called.");
        }
    }

    public void m825a(at atVar) {
        try {
            if (this.my == null) {
                m823k("loadAd");
            }
            if (this.my.mo1598a(this.mx.m783a(this.mContext, atVar))) {
                this.mw.m3492c(atVar.aI());
            }
        } catch (Throwable e) {
            eu.m1017c("Failed to load ad.", e);
        }
    }

    public AdListener getAdListener() {
        return this.lQ;
    }

    public String getAdUnitId() {
        return this.mj;
    }

    public AppEventListener getAppEventListener() {
        return this.mh;
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.mB;
    }

    public boolean isLoaded() {
        boolean z = false;
        try {
            if (this.my != null) {
                z = this.my.isReady();
            }
        } catch (Throwable e) {
            eu.m1017c("Failed to check if ad is ready.", e);
        }
        return z;
    }

    public void setAdListener(AdListener adListener) {
        try {
            this.lQ = adListener;
            if (this.my != null) {
                this.my.mo1594a(adListener != null ? new ag(adListener) : null);
            }
        } catch (Throwable e) {
            eu.m1017c("Failed to set the AdListener.", e);
        }
    }

    public void setAdUnitId(String adUnitId) {
        if (this.mj != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.mj = adUnitId;
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.mh = appEventListener;
            if (this.my != null) {
                this.my.mo1595a(appEventListener != null ? new an(appEventListener) : null);
            }
        } catch (Throwable e) {
            eu.m1017c("Failed to set the AppEventListener.", e);
        }
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        if (this.mC != null) {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        try {
            this.mB = inAppPurchaseListener;
            if (this.my != null) {
                this.my.mo1596a(inAppPurchaseListener != null ? new dh(inAppPurchaseListener) : null);
            }
        } catch (Throwable e) {
            eu.m1017c("Failed to set the InAppPurchaseListener.", e);
        }
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String publicKey) {
        try {
            this.mC = playStorePurchaseListener;
            if (this.my != null) {
                this.my.mo1597a(playStorePurchaseListener != null ? new dl(playStorePurchaseListener) : null, publicKey);
            }
        } catch (Throwable e) {
            eu.m1017c("Failed to set the play store purchase parameter.", e);
        }
    }

    public void show() {
        try {
            m824l("show");
            this.my.showInterstitial();
        } catch (Throwable e) {
            eu.m1017c("Failed to show interstitial.", e);
        }
    }
}
