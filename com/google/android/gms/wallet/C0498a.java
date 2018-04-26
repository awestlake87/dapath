package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0498a implements Creator<Address> {
    static void m1750a(Address address, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, address.getVersionCode());
        C0172b.m247a(parcel, 2, address.name, false);
        C0172b.m247a(parcel, 3, address.UH, false);
        C0172b.m247a(parcel, 4, address.UI, false);
        C0172b.m247a(parcel, 5, address.UJ, false);
        C0172b.m247a(parcel, 6, address.rf, false);
        C0172b.m247a(parcel, 7, address.aiI, false);
        C0172b.m247a(parcel, 8, address.aiJ, false);
        C0172b.m247a(parcel, 9, address.UO, false);
        C0172b.m247a(parcel, 10, address.UQ, false);
        C0172b.m250a(parcel, 11, address.UR);
        C0172b.m247a(parcel, 12, address.US, false);
        C0172b.m235G(parcel, C);
    }

    public Address bQ(Parcel parcel) {
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
        boolean z = false;
        String str10 = null;
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
                    z = C0171a.m208c(parcel, A);
                    break;
                case 12:
                    str10 = C0171a.m220o(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new Address(i, str, str2, str3, str4, str5, str6, str7, str8, str9, z, str10);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bQ(x0);
    }

    public Address[] dw(int i) {
        return new Address[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dw(x0);
    }
}
