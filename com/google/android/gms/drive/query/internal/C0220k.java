package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0220k implements Creator<Operator> {
    static void m383a(Operator operator, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1000, operator.xM);
        C0172b.m247a(parcel, 1, operator.mTag, false);
        C0172b.m235G(parcel, C);
    }

    public Operator aO(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
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
            return new Operator(i, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public Operator[] bK(int i) {
        return new Operator[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bK(x0);
    }
}
