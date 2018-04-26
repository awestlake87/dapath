package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import java.util.List;

public class at implements Creator<as> {
    static void m1846a(as asVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, asVar.versionCode);
        C0172b.m259c(parcel, 2, asVar.statusCode);
        C0172b.m239a(parcel, 3, asVar.amb);
        C0172b.m258b(parcel, 4, asVar.amd, false);
        C0172b.m235G(parcel, C);
    }

    public as cK(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        long j = 0;
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
                    j = C0171a.m214i(parcel, A);
                    break;
                case 4:
                    list = C0171a.m207c(parcel, A, ak.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new as(i2, i, j, list);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cK(x0);
    }

    public as[] et(int i) {
        return new as[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return et(x0);
    }
}
