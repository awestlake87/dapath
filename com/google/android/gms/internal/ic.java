package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.internal.ib.C0759a;
import java.util.ArrayList;

public class ic implements Creator<ib> {
    static void m1258a(ib ibVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, ibVar.getVersionCode());
        C0172b.m258b(parcel, 2, ibVar.fV(), false);
        C0172b.m247a(parcel, 3, ibVar.fW(), false);
        C0172b.m235G(parcel, C);
    }

    public ib m1259J(Parcel parcel) {
        String str = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    arrayList = C0171a.m207c(parcel, A, C0759a.CREATOR);
                    break;
                case 3:
                    str = C0171a.m220o(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ib(i, arrayList, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public ib[] ay(int i) {
        return new ib[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1259J(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ay(x0);
    }
}
