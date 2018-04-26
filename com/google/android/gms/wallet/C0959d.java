package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class C0959d implements SafeParcelable {
    public static final Creator<C0959d> CREATOR = new C0501e();
    LoyaltyWalletObject aiO;
    OfferWalletObject aiP;
    private final int xM;

    C0959d() {
        this.xM = 2;
    }

    C0959d(int i, LoyaltyWalletObject loyaltyWalletObject, OfferWalletObject offerWalletObject) {
        this.xM = i;
        this.aiO = loyaltyWalletObject;
        this.aiP = offerWalletObject;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0501e.m1753a(this, dest, flags);
    }
}
