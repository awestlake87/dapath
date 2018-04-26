package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class lh implements Creator<lg> {
    static void m1340a(lg lgVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, lgVar.getVersionCode());
        C0172b.m252a(parcel, 2, lgVar.akd, false);
        C0172b.m235G(parcel, C);
    }

    public lg ce(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        int[] iArr = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    iArr = C0171a.m226u(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new lg(i, iArr);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ce(x0);
    }

    public lg[] dK(int i) {
        return new lg[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dK(x0);
    }
}
