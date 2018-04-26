package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.identity.intents.model.UserAddress;

public class C0502f implements Creator<FullWallet> {
    static void m1754a(FullWallet fullWallet, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, fullWallet.getVersionCode());
        C0172b.m247a(parcel, 2, fullWallet.aiQ, false);
        C0172b.m247a(parcel, 3, fullWallet.aiR, false);
        C0172b.m243a(parcel, 4, fullWallet.aiS, i, false);
        C0172b.m247a(parcel, 5, fullWallet.aiT, false);
        C0172b.m243a(parcel, 6, fullWallet.aiU, i, false);
        C0172b.m243a(parcel, 7, fullWallet.aiV, i, false);
        C0172b.m254a(parcel, 8, fullWallet.aiW, false);
        C0172b.m243a(parcel, 9, fullWallet.aiX, i, false);
        C0172b.m243a(parcel, 10, fullWallet.aiY, i, false);
        C0172b.m253a(parcel, 11, fullWallet.aiZ, i, false);
        C0172b.m235G(parcel, C);
    }

    public FullWallet bU(Parcel parcel) {
        InstrumentInfo[] instrumentInfoArr = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        String[] strArr = null;
        Address address = null;
        Address address2 = null;
        String str = null;
        ProxyCard proxyCard = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 4:
                    proxyCard = (ProxyCard) C0171a.m201a(parcel, A, ProxyCard.CREATOR);
                    break;
                case 5:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 6:
                    address2 = (Address) C0171a.m201a(parcel, A, Address.CREATOR);
                    break;
                case 7:
                    address = (Address) C0171a.m201a(parcel, A, Address.CREATOR);
                    break;
                case 8:
                    strArr = C0171a.m195A(parcel, A);
                    break;
                case 9:
                    userAddress2 = (UserAddress) C0171a.m201a(parcel, A, UserAddress.CREATOR);
                    break;
                case 10:
                    userAddress = (UserAddress) C0171a.m201a(parcel, A, UserAddress.CREATOR);
                    break;
                case 11:
                    instrumentInfoArr = (InstrumentInfo[]) C0171a.m206b(parcel, A, InstrumentInfo.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new FullWallet(i, str3, str2, proxyCard, str, address2, address, strArr, userAddress2, userAddress, instrumentInfoArr);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bU(x0);
    }

    public FullWallet[] dA(int i) {
        return new FullWallet[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dA(x0);
    }
}
