package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public class C0517n implements Creator<OfferWalletObject> {
    static void m1785a(OfferWalletObject offerWalletObject, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, offerWalletObject.getVersionCode());
        C0172b.m247a(parcel, 2, offerWalletObject.eC, false);
        C0172b.m247a(parcel, 3, offerWalletObject.ajT, false);
        C0172b.m243a(parcel, 4, offerWalletObject.ajU, i, false);
        C0172b.m235G(parcel, C);
    }

    public OfferWalletObject cc(Parcel parcel) {
        CommonWalletObject commonWalletObject = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 4:
                    commonWalletObject = (CommonWalletObject) C0171a.m201a(parcel, A, CommonWalletObject.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new OfferWalletObject(i, str2, str, commonWalletObject);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cc(x0);
    }

    public OfferWalletObject[] dI(int i) {
        return new OfferWalletObject[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dI(x0);
    }
}
