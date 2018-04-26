package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0355if implements Creator<ie> {
    static void m1262a(ie ieVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, ieVar.getVersionCode());
        C0172b.m242a(parcel, 2, ieVar.fY(), false);
        C0172b.m243a(parcel, 3, ieVar.fZ(), i, false);
        C0172b.m235G(parcel, C);
    }

    public ie m1263L(Parcel parcel) {
        ib ibVar = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    parcel2 = C0171a.m198C(parcel, A);
                    break;
                case 3:
                    ibVar = (ib) C0171a.m201a(parcel, A, ib.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ie(i, parcel2, ibVar);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public ie[] aA(int i) {
        return new ie[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1263L(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aA(x0);
    }
}
