package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.internal.hv.C0757a;
import java.util.ArrayList;

public class hw implements Creator<hv> {
    static void m1244a(hv hvVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, hvVar.getVersionCode());
        C0172b.m258b(parcel, 2, hvVar.fD(), false);
        C0172b.m235G(parcel, C);
    }

    public hv m1245F(Parcel parcel) {
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
                    arrayList = C0171a.m207c(parcel, A, C0757a.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new hv(i, arrayList);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public hv[] au(int i) {
        return new hv[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1245F(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return au(x0);
    }
}
