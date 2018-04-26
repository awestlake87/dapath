package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

public final class ca<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final bv nT;

    class C02771 implements Runnable {
        final /* synthetic */ ca nW;

        C02771(ca caVar) {
            this.nW = caVar;
        }

        public void run() {
            try {
                this.nW.nT.onAdClicked();
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdClicked.", e);
            }
        }
    }

    class C02782 implements Runnable {
        final /* synthetic */ ca nW;

        C02782(ca caVar) {
            this.nW = caVar;
        }

        public void run() {
            try {
                this.nW.nT.onAdOpened();
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdOpened.", e);
            }
        }
    }

    class C02793 implements Runnable {
        final /* synthetic */ ca nW;

        C02793(ca caVar) {
            this.nW = caVar;
        }

        public void run() {
            try {
                this.nW.nT.onAdLoaded();
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdLoaded.", e);
            }
        }
    }

    class C02804 implements Runnable {
        final /* synthetic */ ca nW;

        C02804(ca caVar) {
            this.nW = caVar;
        }

        public void run() {
            try {
                this.nW.nT.onAdClosed();
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdClosed.", e);
            }
        }
    }

    class C02826 implements Runnable {
        final /* synthetic */ ca nW;

        C02826(ca caVar) {
            this.nW = caVar;
        }

        public void run() {
            try {
                this.nW.nT.onAdLeftApplication();
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdLeftApplication.", e);
            }
        }
    }

    class C02837 implements Runnable {
        final /* synthetic */ ca nW;

        C02837(ca caVar) {
            this.nW = caVar;
        }

        public void run() {
            try {
                this.nW.nT.onAdOpened();
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdOpened.", e);
            }
        }
    }

    class C02848 implements Runnable {
        final /* synthetic */ ca nW;

        C02848(ca caVar) {
            this.nW = caVar;
        }

        public void run() {
            try {
                this.nW.nT.onAdLoaded();
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdLoaded.", e);
            }
        }
    }

    class C02859 implements Runnable {
        final /* synthetic */ ca nW;

        C02859(ca caVar) {
            this.nW = caVar;
        }

        public void run() {
            try {
                this.nW.nT.onAdClosed();
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdClosed.", e);
            }
        }
    }

    public ca(bv bvVar) {
        this.nT = bvVar;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        eu.m1019z("Adapter called onClick.");
        if (et.bW()) {
            try {
                this.nT.onAdClicked();
                return;
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdClicked.", e);
                return;
            }
        }
        eu.m1014D("onClick must be called on the main UI thread.");
        et.sv.post(new C02771(this));
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        eu.m1019z("Adapter called onDismissScreen.");
        if (et.bW()) {
            try {
                this.nT.onAdClosed();
                return;
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdClosed.", e);
                return;
            }
        }
        eu.m1014D("onDismissScreen must be called on the main UI thread.");
        et.sv.post(new C02804(this));
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        eu.m1019z("Adapter called onDismissScreen.");
        if (et.bW()) {
            try {
                this.nT.onAdClosed();
                return;
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdClosed.", e);
                return;
            }
        }
        eu.m1014D("onDismissScreen must be called on the main UI thread.");
        et.sv.post(new C02859(this));
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, final ErrorCode errorCode) {
        eu.m1019z("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (et.bW()) {
            try {
                this.nT.onAdFailedToLoad(cb.m843a(errorCode));
                return;
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        eu.m1014D("onFailedToReceiveAd must be called on the main UI thread.");
        et.sv.post(new Runnable(this) {
            final /* synthetic */ ca nW;

            public void run() {
                try {
                    this.nW.nT.onAdFailedToLoad(cb.m843a(errorCode));
                } catch (Throwable e) {
                    eu.m1017c("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, final ErrorCode errorCode) {
        eu.m1019z("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (et.bW()) {
            try {
                this.nT.onAdFailedToLoad(cb.m843a(errorCode));
                return;
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        eu.m1014D("onFailedToReceiveAd must be called on the main UI thread.");
        et.sv.post(new Runnable(this) {
            final /* synthetic */ ca nW;

            public void run() {
                try {
                    this.nW.nT.onAdFailedToLoad(cb.m843a(errorCode));
                } catch (Throwable e) {
                    eu.m1017c("Could not call onAdFailedToLoad.", e);
                }
            }
        });
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        eu.m1019z("Adapter called onLeaveApplication.");
        if (et.bW()) {
            try {
                this.nT.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        eu.m1014D("onLeaveApplication must be called on the main UI thread.");
        et.sv.post(new C02826(this));
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        eu.m1019z("Adapter called onLeaveApplication.");
        if (et.bW()) {
            try {
                this.nT.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        eu.m1014D("onLeaveApplication must be called on the main UI thread.");
        et.sv.post(new Runnable(this) {
            final /* synthetic */ ca nW;

            {
                this.nW = r1;
            }

            public void run() {
                try {
                    this.nW.nT.onAdLeftApplication();
                } catch (Throwable e) {
                    eu.m1017c("Could not call onAdLeftApplication.", e);
                }
            }
        });
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        eu.m1019z("Adapter called onPresentScreen.");
        if (et.bW()) {
            try {
                this.nT.onAdOpened();
                return;
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdOpened.", e);
                return;
            }
        }
        eu.m1014D("onPresentScreen must be called on the main UI thread.");
        et.sv.post(new C02837(this));
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        eu.m1019z("Adapter called onPresentScreen.");
        if (et.bW()) {
            try {
                this.nT.onAdOpened();
                return;
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdOpened.", e);
                return;
            }
        }
        eu.m1014D("onPresentScreen must be called on the main UI thread.");
        et.sv.post(new C02782(this));
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        eu.m1019z("Adapter called onReceivedAd.");
        if (et.bW()) {
            try {
                this.nT.onAdLoaded();
                return;
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdLoaded.", e);
                return;
            }
        }
        eu.m1014D("onReceivedAd must be called on the main UI thread.");
        et.sv.post(new C02848(this));
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        eu.m1019z("Adapter called onReceivedAd.");
        if (et.bW()) {
            try {
                this.nT.onAdLoaded();
                return;
            } catch (Throwable e) {
                eu.m1017c("Could not call onAdLoaded.", e);
                return;
            }
        }
        eu.m1014D("onReceivedAd must be called on the main UI thread.");
        et.sv.post(new C02793(this));
    }
}
