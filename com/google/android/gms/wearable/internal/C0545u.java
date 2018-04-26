package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import java.util.List;

public class C0545u implements Creator<C0985t> {
    static void m1852a(C0985t c0985t, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, c0985t.versionCode);
        C0172b.m259c(parcel, 2, c0985t.statusCode);
        C0172b.m258b(parcel, 3, c0985t.alN, false);
        C0172b.m235G(parcel, C);
    }

    public C0985t cA(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 3:
                    list = C0171a.m207c(parcel, A, ai.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0985t(i2, i, list);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cA(x0);
    }

    public C0985t[] ej(int i) {
        return new C0985t[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ej(x0);
    }
}
