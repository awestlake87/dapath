package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0508b implements Creator<WalletFragmentOptions> {
    static void m1776a(WalletFragmentOptions walletFragmentOptions, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, walletFragmentOptions.xM);
        C0172b.m259c(parcel, 2, walletFragmentOptions.getEnvironment());
        C0172b.m259c(parcel, 3, walletFragmentOptions.getTheme());
        C0172b.m243a(parcel, 4, walletFragmentOptions.getFragmentStyle(), i, false);
        C0172b.m259c(parcel, 5, walletFragmentOptions.getMode());
        C0172b.m235G(parcel, C);
    }

    public WalletFragmentOptions ch(Parcel parcel) {
        int i = 1;
        int i2 = 0;
        int B = C0171a.m196B(parcel);
        WalletFragmentStyle walletFragmentStyle = null;
        int i3 = 1;
        int i4 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i4 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 3:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 4:
                    walletFragmentStyle = (WalletFragmentStyle) C0171a.m201a(parcel, A, WalletFragmentStyle.CREATOR);
                    break;
                case 5:
                    i = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new WalletFragmentOptions(i4, i3, i2, walletFragmentStyle, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ch(x0);
    }

    public WalletFragmentOptions[] dO(int i) {
        return new WalletFragmentOptions[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dO(x0);
    }
}
