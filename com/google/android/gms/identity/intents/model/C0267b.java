package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0267b implements Creator<UserAddress> {
    static void m758a(UserAddress userAddress, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, userAddress.getVersionCode());
        C0172b.m247a(parcel, 2, userAddress.name, false);
        C0172b.m247a(parcel, 3, userAddress.UH, false);
        C0172b.m247a(parcel, 4, userAddress.UI, false);
        C0172b.m247a(parcel, 5, userAddress.UJ, false);
        C0172b.m247a(parcel, 6, userAddress.UK, false);
        C0172b.m247a(parcel, 7, userAddress.UL, false);
        C0172b.m247a(parcel, 8, userAddress.UM, false);
        C0172b.m247a(parcel, 9, userAddress.UN, false);
        C0172b.m247a(parcel, 10, userAddress.rf, false);
        C0172b.m247a(parcel, 11, userAddress.UO, false);
        C0172b.m247a(parcel, 12, userAddress.UP, false);
        C0172b.m247a(parcel, 13, userAddress.UQ, false);
        C0172b.m250a(parcel, 14, userAddress.UR);
        C0172b.m247a(parcel, 15, userAddress.US, false);
        C0172b.m247a(parcel, 16, userAddress.UT, false);
        C0172b.m235G(parcel, C);
    }

    public UserAddress br(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        boolean z = false;
        String str13 = null;
        String str14 = null;
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
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 5:
                    str4 = C0171a.m220o(parcel, A);
                    break;
                case 6:
                    str5 = C0171a.m220o(parcel, A);
                    break;
                case 7:
                    str6 = C0171a.m220o(parcel, A);
                    break;
                case 8:
                    str7 = C0171a.m220o(parcel, A);
                    break;
                case 9:
                    str8 = C0171a.m220o(parcel, A);
                    break;
                case 10:
                    str9 = C0171a.m220o(parcel, A);
                    break;
                case 11:
                    str10 = C0171a.m220o(parcel, A);
                    break;
                case 12:
                    str11 = C0171a.m220o(parcel, A);
                    break;
                case 13:
                    str12 = C0171a.m220o(parcel, A);
                    break;
                case 14:
                    z = C0171a.m208c(parcel, A);
                    break;
                case 15:
                    str13 = C0171a.m220o(parcel, A);
                    break;
                case 16:
                    str14 = C0171a.m220o(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new UserAddress(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, z, str13, str14);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public UserAddress[] cE(int i) {
        return new UserAddress[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return br(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cE(x0);
    }
}
