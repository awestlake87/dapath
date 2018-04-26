package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0501e implements Creator<C0959d> {
    static void m1753a(C0959d c0959d, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, c0959d.getVersionCode());
        C0172b.m243a(parcel, 2, c0959d.aiO, i, false);
        C0172b.m243a(parcel, 3, c0959d.aiP, i, false);
        C0172b.m235G(parcel, C);
    }

    public C0959d bT(Parcel parcel) {
        OfferWalletObject offerWalletObject = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        LoyaltyWalletObject loyaltyWalletObject = null;
        while (parcel.dataPosition() < B) {
            LoyaltyWalletObject loyaltyWalletObject2;
            int g;
            OfferWalletObject offerWalletObject2;
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    OfferWalletObject offerWalletObject3 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    g = C0171a.m212g(parcel, A);
                    offerWalletObject2 = offerWalletObject3;
                    break;
                case 2:
                    g = i;
                    LoyaltyWalletObject loyaltyWalletObject3 = (LoyaltyWalletObject) C0171a.m201a(parcel, A, LoyaltyWalletObject.CREATOR);
                    offerWalletObject2 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject3;
                    break;
                case 3:
                    offerWalletObject2 = (OfferWalletObject) C0171a.m201a(parcel, A, OfferWalletObject.CREATOR);
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    g = i;
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    offerWalletObject2 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    g = i;
                    break;
            }
            i = g;
            loyaltyWalletObject = loyaltyWalletObject2;
            offerWalletObject = offerWalletObject2;
        }
        if (parcel.dataPosition() == B) {
            return new C0959d(i, loyaltyWalletObject, offerWalletObject);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bT(x0);
    }

    public C0959d[] dz(int i) {
        return new C0959d[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dz(x0);
    }
}
