package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class fj implements Creator<fi> {
    static void m1060a(fi fiVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m247a(parcel, 1, fiVar.xQ, false);
        C0172b.m259c(parcel, 1000, fiVar.xM);
        C0172b.m247a(parcel, 2, fiVar.xR, false);
        C0172b.m247a(parcel, 3, fiVar.xS, false);
        C0172b.m235G(parcel, C);
    }

    public fi[] m1061E(int i) {
        return new fi[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1062m(x0);
    }

    public fi m1062m(Parcel parcel) {
        String str = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 2:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 3:
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
            return new fi(i, str3, str2, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1061E(x0);
    }
}
