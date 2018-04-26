package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class fn implements Creator<fm> {
    static void m1066a(fm fmVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, fmVar.id);
        C0172b.m259c(parcel, 1000, fmVar.xM);
        C0172b.m240a(parcel, 2, fmVar.xY, false);
        C0172b.m235G(parcel, C);
    }

    public fm[] m1067G(int i) {
        return new fm[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1068o(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1067G(x0);
    }

    public fm m1068o(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    bundle = C0171a.m222q(parcel, A);
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
            return new fm(i2, i, bundle);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }
}
