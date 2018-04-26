package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0433f implements Creator<PlusCommonExtras> {
    static void m1579a(PlusCommonExtras plusCommonExtras, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m247a(parcel, 1, plusCommonExtras.jX(), false);
        C0172b.m259c(parcel, 1000, plusCommonExtras.getVersionCode());
        C0172b.m247a(parcel, 2, plusCommonExtras.jY(), false);
        C0172b.m235G(parcel, C);
    }

    public PlusCommonExtras bC(Parcel parcel) {
        String str = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 2:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 1000:
                    i = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new PlusCommonExtras(i, str2, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public PlusCommonExtras[] cZ(int i) {
        return new PlusCommonExtras[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cZ(x0);
    }
}
