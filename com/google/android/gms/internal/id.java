package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.internal.ib.C0759a;
import com.google.android.gms.internal.ib.C0760b;
import java.util.ArrayList;

public class id implements Creator<C0759a> {
    static void m1260a(C0759a c0759a, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, c0759a.versionCode);
        C0172b.m247a(parcel, 2, c0759a.className, false);
        C0172b.m258b(parcel, 3, c0759a.Ho, false);
        C0172b.m235G(parcel, C);
    }

    public C0759a m1261K(Parcel parcel) {
        ArrayList arrayList = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    arrayList = C0171a.m207c(parcel, A, C0760b.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0759a(i, str, arrayList);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public C0759a[] az(int i) {
        return new C0759a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1261K(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return az(x0);
    }
}
