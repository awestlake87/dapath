package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0509c implements Creator<WalletFragmentStyle> {
    static void m1777a(WalletFragmentStyle walletFragmentStyle, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, walletFragmentStyle.xM);
        C0172b.m240a(parcel, 2, walletFragmentStyle.akE, false);
        C0172b.m259c(parcel, 3, walletFragmentStyle.akF);
        C0172b.m235G(parcel, C);
    }

    public WalletFragmentStyle ci(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    bundle = C0171a.m222q(parcel, A);
                    break;
                case 3:
                    i = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new WalletFragmentStyle(i2, bundle, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ci(x0);
    }

    public WalletFragmentStyle[] dP(int i) {
        return new WalletFragmentStyle[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dP(x0);
    }
}
