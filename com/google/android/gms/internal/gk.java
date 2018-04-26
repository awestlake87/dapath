package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class gk implements Creator<gj> {
    static void m1114a(gj gjVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, gjVar.getVersionCode());
        C0172b.m237a(parcel, 2, gjVar.eh());
        C0172b.m250a(parcel, 3, gjVar.en());
        C0172b.m259c(parcel, 4, gjVar.eo());
        C0172b.m235G(parcel, C);
    }

    public gj[] m1115Y(int i) {
        return new gj[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1116v(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1115Y(x0);
    }

    public gj m1116v(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        double d = 0.0d;
        boolean z = false;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    d = C0171a.m218m(parcel, A);
                    break;
                case 3:
                    z = C0171a.m208c(parcel, A);
                    break;
                case 4:
                    i = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new gj(i2, d, z, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }
}
