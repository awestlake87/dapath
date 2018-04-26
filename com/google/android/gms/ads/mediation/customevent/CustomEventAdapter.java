package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.eu;

public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
    private View f88n;
    private CustomEventBanner sW;
    private CustomEventInterstitial sX;

    private static final class C0991a implements CustomEventBannerListener {
        private final MediationBannerListener f86l;
        private final CustomEventAdapter sY;

        public C0991a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.sY = customEventAdapter;
            this.f86l = mediationBannerListener;
        }

        public void onAdClicked() {
            eu.m1019z("Custom event adapter called onAdClicked.");
            this.f86l.onAdClicked(this.sY);
        }

        public void onAdClosed() {
            eu.m1019z("Custom event adapter called onAdClosed.");
            this.f86l.onAdClosed(this.sY);
        }

        public void onAdFailedToLoad(int errorCode) {
            eu.m1019z("Custom event adapter called onAdFailedToLoad.");
            this.f86l.onAdFailedToLoad(this.sY, errorCode);
        }

        public void onAdLeftApplication() {
            eu.m1019z("Custom event adapter called onAdLeftApplication.");
            this.f86l.onAdLeftApplication(this.sY);
        }

        public void onAdLoaded(View view) {
            eu.m1019z("Custom event adapter called onAdLoaded.");
            this.sY.m3171a(view);
            this.f86l.onAdLoaded(this.sY);
        }

        public void onAdOpened() {
            eu.m1019z("Custom event adapter called onAdOpened.");
            this.f86l.onAdOpened(this.sY);
        }
    }

    private class C0992b implements CustomEventInterstitialListener {
        private final MediationInterstitialListener f87m;
        private final CustomEventAdapter sY;
        final /* synthetic */ CustomEventAdapter sZ;

        public C0992b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.sZ = customEventAdapter;
            this.sY = customEventAdapter2;
            this.f87m = mediationInterstitialListener;
        }

        public void onAdClicked() {
            eu.m1019z("Custom event adapter called onAdClicked.");
            this.f87m.onAdClicked(this.sY);
        }

        public void onAdClosed() {
            eu.m1019z("Custom event adapter called onAdClosed.");
            this.f87m.onAdClosed(this.sY);
        }

        public void onAdFailedToLoad(int errorCode) {
            eu.m1019z("Custom event adapter called onFailedToReceiveAd.");
            this.f87m.onAdFailedToLoad(this.sY, errorCode);
        }

        public void onAdLeftApplication() {
            eu.m1019z("Custom event adapter called onAdLeftApplication.");
            this.f87m.onAdLeftApplication(this.sY);
        }

        public void onAdLoaded() {
            eu.m1019z("Custom event adapter called onReceivedAd.");
            this.f87m.onAdLoaded(this.sZ);
        }

        public void onAdOpened() {
            eu.m1019z("Custom event adapter called onAdOpened.");
            this.f87m.onAdOpened(this.sY);
        }
    }

    private static <T> T m3170a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            eu.m1014D("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    private void m3171a(View view) {
        this.f88n = view;
    }

    public View getBannerView() {
        return this.f88n;
    }

    public void onDestroy() {
        if (this.sW != null) {
            this.sW.onDestroy();
        }
        if (this.sX != null) {
            this.sX.onDestroy();
        }
    }

    public void onPause() {
        if (this.sW != null) {
            this.sW.onPause();
        }
        if (this.sX != null) {
            this.sX.onPause();
        }
    }

    public void onResume() {
        if (this.sW != null) {
            this.sW.onResume();
        }
        if (this.sX != null) {
            this.sX.onResume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener listener, Bundle serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle customEventExtras) {
        this.sW = (CustomEventBanner) m3170a(serverParameters.getString("class_name"));
        if (this.sW == null) {
            listener.onAdFailedToLoad(this, 0);
            return;
        }
        this.sW.requestBannerAd(context, new C0991a(this, listener), serverParameters.getString("parameter"), adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getBundle(serverParameters.getString("class_name")));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener listener, Bundle serverParameters, MediationAdRequest mediationAdRequest, Bundle customEventExtras) {
        this.sX = (CustomEventInterstitial) m3170a(serverParameters.getString("class_name"));
        if (this.sX == null) {
            listener.onAdFailedToLoad(this, 0);
            return;
        }
        this.sX.requestInterstitialAd(context, new C0992b(this, this, listener), serverParameters.getString("parameter"), mediationAdRequest, customEventExtras == null ? null : customEventExtras.getBundle(serverParameters.getString("class_name")));
    }

    public void showInterstitial() {
        this.sX.showInterstitial();
    }
}
