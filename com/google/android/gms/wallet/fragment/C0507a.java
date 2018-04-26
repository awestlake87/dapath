package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public class C0507a implements Creator<WalletFragmentInitParams> {
    static void m1775a(WalletFragmentInitParams walletFragmentInitParams, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, walletFragmentInitParams.xM);
        C0172b.m247a(parcel, 2, walletFragmentInitParams.getAccountName(), false);
        C0172b.m243a(parcel, 3, walletFragmentInitParams.getMaskedWalletRequest(), i, false);
        C0172b.m259c(parcel, 4, walletFragmentInitParams.getMaskedWalletRequestCode());
        C0172b.m243a(parcel, 5, walletFragmentInitParams.getMaskedWallet(), i, false);
        C0172b.m235G(parcel, C);
    }

    public WalletFragmentInitParams cg(Parcel parcel) {
        MaskedWallet maskedWallet = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        int i2 = -1;
        MaskedWalletRequest maskedWalletRequest = null;
        String str = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    maskedWalletRequest = (MaskedWalletRequest) C0171a.m201a(parcel, A, MaskedWalletRequest.CREATOR);
                    break;
                case 4:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 5:
                    maskedWallet = (MaskedWallet) C0171a.m201a(parcel, A, MaskedWallet.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new WalletFragmentInitParams(i, str, maskedWalletRequest, i2, maskedWallet);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cg(x0);
    }

    public WalletFragmentInitParams[] dN(int i) {
        return new WalletFragmentInitParams[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dN(x0);
    }
}
