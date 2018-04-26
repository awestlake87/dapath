package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class hu implements Creator<ht> {
    static void m1242a(ht htVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, htVar.getVersionCode());
        C0172b.m243a(parcel, 2, htVar.fB(), i, false);
        C0172b.m235G(parcel, C);
    }

    public ht m1243E(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        hv hvVar = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    hvVar = (hv) C0171a.m201a(parcel, A, hv.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ht(i, hvVar);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public ht[] at(int i) {
        return new ht[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1243E(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return at(x0);
    }
}
