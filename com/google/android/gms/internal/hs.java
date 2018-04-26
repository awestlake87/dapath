package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class hs implements Creator<hr> {
    static void m1240a(hr hrVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, hrVar.xM);
        C0172b.m247a(parcel, 2, hrVar.GT, false);
        C0172b.m259c(parcel, 3, hrVar.GU);
        C0172b.m235G(parcel, C);
    }

    public hr m1241D(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    str = C0171a.m220o(parcel, A);
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
            return new hr(i2, str, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public hr[] as(int i) {
        return new hr[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1241D(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return as(x0);
    }
}
