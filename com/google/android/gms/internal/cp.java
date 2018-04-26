package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class cp implements Creator<cq> {
    static void m867a(cq cqVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, cqVar.versionCode);
        C0172b.m241a(parcel, 2, cqVar.bd(), false);
        C0172b.m241a(parcel, 3, cqVar.be(), false);
        C0172b.m241a(parcel, 4, cqVar.bf(), false);
        C0172b.m241a(parcel, 5, cqVar.bg(), false);
        C0172b.m235G(parcel, C);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m868g(x0);
    }

    public cq m868g(Parcel parcel) {
        IBinder iBinder = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    iBinder4 = C0171a.m221p(parcel, A);
                    break;
                case 3:
                    iBinder3 = C0171a.m221p(parcel, A);
                    break;
                case 4:
                    iBinder2 = C0171a.m221p(parcel, A);
                    break;
                case 5:
                    iBinder = C0171a.m221p(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new cq(i, iBinder4, iBinder3, iBinder2, iBinder);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public cq[] m869k(int i) {
        return new cq[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m869k(x0);
    }
}
