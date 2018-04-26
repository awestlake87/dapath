package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0512i implements Creator<LineItem> {
    static void m1780a(LineItem lineItem, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, lineItem.getVersionCode());
        C0172b.m247a(parcel, 2, lineItem.description, false);
        C0172b.m247a(parcel, 3, lineItem.aje, false);
        C0172b.m247a(parcel, 4, lineItem.ajf, false);
        C0172b.m247a(parcel, 5, lineItem.aiK, false);
        C0172b.m259c(parcel, 6, lineItem.ajg);
        C0172b.m247a(parcel, 7, lineItem.aiL, false);
        C0172b.m235G(parcel, C);
    }

    public LineItem bX(Parcel parcel) {
        int i = 0;
        String str = null;
        int B = C0171a.m196B(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    str5 = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    str4 = C0171a.m220o(parcel, A);
                    break;
                case 4:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 5:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 6:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 7:
                    str = C0171a.m220o(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new LineItem(i2, str5, str4, str3, str2, i, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bX(x0);
    }

    public LineItem[] dD(int i) {
        return new LineItem[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dD(x0);
    }
}
