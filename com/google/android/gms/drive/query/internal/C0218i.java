package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0218i implements Creator<MatchAllFilter> {
    static void m381a(MatchAllFilter matchAllFilter, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1000, matchAllFilter.xM);
        C0172b.m235G(parcel, C);
    }

    public MatchAllFilter aM(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1000:
                    i = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new MatchAllFilter(i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public MatchAllFilter[] bI(int i) {
        return new MatchAllFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aM(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bI(x0);
    }
}
