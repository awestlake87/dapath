package com.google.ads.mediation.admob;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.et;
import java.util.Date;
import java.util.Set;

public final class AdMobAdapter implements MediationBannerAdapter, MediationInterstitialAdapter {
    private AdView f76i;
    private InterstitialAd f77j;

    private static final class C0574a extends AdListener {
        private final AdMobAdapter f69k;
        private final MediationBannerListener f70l;

        public C0574a(AdMobAdapter adMobAdapter, MediationBannerListener mediationBannerListener) {
            this.f69k = adMobAdapter;
            this.f70l = mediationBannerListener;
        }

        public void onAdClosed() {
            this.f70l.onAdClosed(this.f69k);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f70l.onAdFailedToLoad(this.f69k, errorCode);
        }

        public void onAdLeftApplication() {
            this.f70l.onAdLeftApplication(this.f69k);
        }

        public void onAdLoaded() {
            this.f70l.onAdLoaded(this.f69k);
        }

        public void onAdOpened() {
            this.f70l.onAdClicked(this.f69k);
            this.f70l.onAdOpened(this.f69k);
        }
    }

    private static final class C0575b extends AdListener {
        private final AdMobAdapter f71k;
        private final MediationInterstitialListener f72m;

        public C0575b(AdMobAdapter adMobAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f71k = adMobAdapter;
            this.f72m = mediationInterstitialListener;
        }

        public void onAdClosed() {
            this.f72m.onAdClosed(this.f71k);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f72m.onAdFailedToLoad(this.f71k, errorCode);
        }

        public void onAdLeftApplication() {
            this.f72m.onAdLeftApplication(this.f71k);
        }

        public void onAdLoaded() {
            this.f72m.onAdLoaded(this.f71k);
        }

        public void onAdOpened() {
            this.f72m.onAdOpened(this.f71k);
        }
    }

    private static AdRequest m3166a(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        Builder builder = new Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(et.m1009r(context));
        }
        if (bundle2.getInt("tagForChildDirectedTreatment") != -1) {
            builder.tagForChildDirectedTreatment(bundle2.getInt("tagForChildDirectedTreatment") == 1);
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("gw", 1);
        bundle.putString("mad_hac", bundle2.getString("mad_hac"));
        if (!TextUtils.isEmpty(bundle2.getString("adJson"))) {
            bundle.putString("_ad", bundle2.getString("adJson"));
        }
        bundle.putBoolean("_noRefresh", true);
        builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        return builder.build();
    }

    public View getBannerView() {
        return this.f76i;
    }

    public void onDestroy() {
        if (this.f76i != null) {
            this.f76i.destroy();
            this.f76i = null;
        }
        if (this.f77j != null) {
            this.f77j = null;
        }
    }

    public void onPause() {
        if (this.f76i != null) {
            this.f76i.pause();
        }
    }

    public void onResume() {
        if (this.f76i != null) {
            this.f76i.resume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener bannerListener, Bundle serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle extras) {
        this.f76i = new AdView(context);
        this.f76i.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.f76i.setAdUnitId(serverParameters.getString("pubid"));
        this.f76i.setAdListener(new C0574a(this, bannerListener));
        this.f76i.loadAd(m3166a(context, mediationAdRequest, extras, serverParameters));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener interstitialListener, Bundle serverParameters, MediationAdRequest mediationAdRequest, Bundle extras) {
        this.f77j = new InterstitialAd(context);
        this.f77j.setAdUnitId(serverParameters.getString("pubid"));
        this.f77j.setAdListener(new C0575b(this, interstitialListener));
        this.f77j.loadAd(m3166a(context, mediationAdRequest, extras, serverParameters));
    }

    public void showInterstitial() {
        this.f77j.show();
    }
}
