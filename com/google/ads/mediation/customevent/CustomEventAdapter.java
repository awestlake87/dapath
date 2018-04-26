package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.eu;

public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View f83n;
    private CustomEventBanner f84o;
    private CustomEventInterstitial f85p;

    private static final class C0989a implements CustomEventBannerListener {
        private final CustomEventAdapter f78q;
        private final MediationBannerListener f79r;

        public C0989a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f78q = customEventAdapter;
            this.f79r = mediationBannerListener;
        }

        public void onClick() {
            eu.m1019z("Custom event adapter called onFailedToReceiveAd.");
            this.f79r.onClick(this.f78q);
        }

        public void onDismissScreen() {
            eu.m1019z("Custom event adapter called onFailedToReceiveAd.");
            this.f79r.onDismissScreen(this.f78q);
        }

        public void onFailedToReceiveAd() {
            eu.m1019z("Custom event adapter called onFailedToReceiveAd.");
            this.f79r.onFailedToReceiveAd(this.f78q, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            eu.m1019z("Custom event adapter called onFailedToReceiveAd.");
            this.f79r.onLeaveApplication(this.f78q);
        }

        public void onPresentScreen() {
            eu.m1019z("Custom event adapter called onFailedToReceiveAd.");
            this.f79r.onPresentScreen(this.f78q);
        }

        public void onReceivedAd(View view) {
            eu.m1019z("Custom event adapter called onReceivedAd.");
            this.f78q.m3168a(view);
            this.f79r.onReceivedAd(this.f78q);
        }
    }

    private class C0990b implements CustomEventInterstitialListener {
        private final CustomEventAdapter f80q;
        private final MediationInterstitialListener f81s;
        final /* synthetic */ CustomEventAdapter f82t;

        public C0990b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.f82t = customEventAdapter;
            this.f80q = customEventAdapter2;
            this.f81s = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            eu.m1019z("Custom event adapter called onDismissScreen.");
            this.f81s.onDismissScreen(this.f80q);
        }

        public void onFailedToReceiveAd() {
            eu.m1019z("Custom event adapter called onFailedToReceiveAd.");
            this.f81s.onFailedToReceiveAd(this.f80q, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            eu.m1019z("Custom event adapter called onLeaveApplication.");
            this.f81s.onLeaveApplication(this.f80q);
        }

        public void onPresentScreen() {
            eu.m1019z("Custom event adapter called onPresentScreen.");
            this.f81s.onPresentScreen(this.f80q);
        }

        public void onReceivedAd() {
            eu.m1019z("Custom event adapter called onReceivedAd.");
            this.f81s.onReceivedAd(this.f82t);
        }
    }

    private static <T> T m3167a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            eu.m1014D("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    private void m3168a(View view) {
        this.f83n = view;
    }

    public void destroy() {
        if (this.f84o != null) {
            this.f84o.destroy();
        }
        if (this.f85p != null) {
            this.f85p.destroy();
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.f83n;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener listener, Activity activity, CustomEventServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f84o = (CustomEventBanner) m3167a(serverParameters.className);
        if (this.f84o == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f84o.requestBannerAd(new C0989a(this, listener), activity, serverParameters.label, serverParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener listener, Activity activity, CustomEventServerParameters serverParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f85p = (CustomEventInterstitial) m3167a(serverParameters.className);
        if (this.f85p == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f85p.requestInterstitialAd(new C0990b(this, this, listener), activity, serverParameters.label, serverParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void showInterstitial() {
        this.f85p.showInterstitial();
    }
}
