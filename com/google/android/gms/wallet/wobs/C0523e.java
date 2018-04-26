package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.internal.ig;
import java.util.ArrayList;

public class C0523e implements Creator<C0965d> {
    static void m1789a(C0965d c0965d, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, c0965d.getVersionCode());
        C0172b.m247a(parcel, 2, c0965d.akP, false);
        C0172b.m247a(parcel, 3, c0965d.akQ, false);
        C0172b.m258b(parcel, 4, c0965d.akR, false);
        C0172b.m235G(parcel, C);
    }

    public C0965d cl(Parcel parcel) {
        String str = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        ArrayList ga = ig.ga();
        String str2 = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 4:
                    ga = C0171a.m207c(parcel, A, C0964b.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0965d(i, str2, str, ga);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cl(x0);
    }

    public C0965d[] dT(int i) {
        return new C0965d[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dT(x0);
    }
}
