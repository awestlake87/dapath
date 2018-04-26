package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.internal.dc.C0701a;

public final class dh extends C0701a {
    private final InAppPurchaseListener mB;

    public dh(InAppPurchaseListener inAppPurchaseListener) {
        this.mB = inAppPurchaseListener;
    }

    public void mo1670a(db dbVar) {
        this.mB.onInAppPurchaseRequested(new dk(dbVar));
    }
}
