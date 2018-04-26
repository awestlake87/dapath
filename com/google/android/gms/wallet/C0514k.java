package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.identity.intents.model.UserAddress;

public class C0514k implements Creator<MaskedWallet> {
    static void m1782a(MaskedWallet maskedWallet, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, maskedWallet.getVersionCode());
        C0172b.m247a(parcel, 2, maskedWallet.aiQ, false);
        C0172b.m247a(parcel, 3, maskedWallet.aiR, false);
        C0172b.m254a(parcel, 4, maskedWallet.aiW, false);
        C0172b.m247a(parcel, 5, maskedWallet.aiT, false);
        C0172b.m243a(parcel, 6, maskedWallet.aiU, i, false);
        C0172b.m243a(parcel, 7, maskedWallet.aiV, i, false);
        C0172b.m253a(parcel, 8, maskedWallet.ajC, i, false);
        C0172b.m253a(parcel, 9, maskedWallet.ajD, i, false);
        C0172b.m243a(parcel, 10, maskedWallet.aiX, i, false);
        C0172b.m243a(parcel, 11, maskedWallet.aiY, i, false);
        C0172b.m253a(parcel, 12, maskedWallet.aiZ, i, false);
        C0172b.m235G(parcel, C);
    }

    public MaskedWallet bZ(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String[] strArr = null;
        String str3 = null;
        Address address = null;
        Address address2 = null;
        LoyaltyWalletObject[] loyaltyWalletObjectArr = null;
        OfferWalletObject[] offerWalletObjectArr = null;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        InstrumentInfo[] instrumentInfoArr = null;
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
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 4:
                    strArr = C0171a.m195A(parcel, A);
                    break;
                case 5:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 6:
                    address = (Address) C0171a.m201a(parcel, A, Address.CREATOR);
                    break;
                case 7:
                    address2 = (Address) C0171a.m201a(parcel, A, Address.CREATOR);
                    break;
                case 8:
                    loyaltyWalletObjectArr = (LoyaltyWalletObject[]) C0171a.m206b(parcel, A, LoyaltyWalletObject.CREATOR);
                    break;
                case 9:
                    offerWalletObjectArr = (OfferWalletObject[]) C0171a.m206b(parcel, A, OfferWalletObject.CREATOR);
                    break;
                case 10:
                    userAddress = (UserAddress) C0171a.m201a(parcel, A, UserAddress.CREATOR);
                    break;
                case 11:
                    userAddress2 = (UserAddress) C0171a.m201a(parcel, A, UserAddress.CREATOR);
                    break;
                case 12:
                    instrumentInfoArr = (InstrumentInfo[]) C0171a.m206b(parcel, A, InstrumentInfo.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new MaskedWallet(i, str, str2, strArr, str3, address, address2, loyaltyWalletObjectArr, offerWalletObjectArr, userAddress, userAddress2, instrumentInfoArr);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bZ(x0);
    }

    public MaskedWallet[] dF(int i) {
        return new MaskedWallet[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dF(x0);
    }
}
