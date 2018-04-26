package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.dg.C0709a;

public final class dl extends C0709a {
    private final PlayStorePurchaseListener mC;

    public dl(PlayStorePurchaseListener playStorePurchaseListener) {
        this.mC = playStorePurchaseListener;
    }

    public void mo1680a(df dfVar) {
        this.mC.onInAppPurchaseFinished(new dj(dfVar));
    }

    public boolean isValidPurchase(String productId) {
        return this.mC.isValidPurchase(productId);
    }
}
