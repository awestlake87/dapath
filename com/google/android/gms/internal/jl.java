package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class jl implements Creator<jk> {
    static void m1307a(jk jkVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, jkVar.jc());
        C0172b.m259c(parcel, 1000, jkVar.getVersionCode());
        C0172b.m259c(parcel, 2, jkVar.je());
        C0172b.m243a(parcel, 3, jkVar.jf(), i, false);
        C0172b.m235G(parcel, C);
    }

    public jk bu(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        int i2 = -1;
        jm jmVar = null;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 3:
                    jmVar = (jm) C0171a.m201a(parcel, A, jm.CREATOR);
                    break;
                case 1000:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new jk(i3, i, i2, jmVar);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public jk[] cP(int i) {
        return new jk[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bu(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cP(x0);
    }
}
