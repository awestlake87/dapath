package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0510g implements Creator<FullWalletRequest> {
    static void m1778a(FullWalletRequest fullWalletRequest, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, fullWalletRequest.getVersionCode());
        C0172b.m247a(parcel, 2, fullWalletRequest.aiQ, false);
        C0172b.m247a(parcel, 3, fullWalletRequest.aiR, false);
        C0172b.m243a(parcel, 4, fullWalletRequest.aja, i, false);
        C0172b.m235G(parcel, C);
    }

    public FullWalletRequest bV(Parcel parcel) {
        Cart cart = null;
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
                    cart = (Cart) C0171a.m201a(parcel, A, Cart.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new FullWalletRequest(i, str2, str, cart);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bV(x0);
    }

    public FullWalletRequest[] dB(int i) {
        return new FullWalletRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dB(x0);
    }
}
