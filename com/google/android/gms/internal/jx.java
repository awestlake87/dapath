package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class jx implements Creator<jw> {
    static void m1313a(jw jwVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m247a(parcel, 1, jwVar.qX, false);
        C0172b.m259c(parcel, 1000, jwVar.xM);
        C0172b.m259c(parcel, 2, jwVar.YS);
        C0172b.m235G(parcel, C);
    }

    public jw bA(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 2:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 1000:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new jw(i2, str, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public jw[] cV(int i) {
        return new jw[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cV(x0);
    }
}
