package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0376w implements Creator<C0799v> {
    static void m1467a(C0799v c0799v, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, c0799v.versionCode);
        C0172b.m250a(parcel, 2, c0799v.lb);
        C0172b.m250a(parcel, 3, c0799v.ld);
        C0172b.m235G(parcel, C);
    }

    public C0799v m1468a(Parcel parcel) {
        boolean z = false;
        int B = C0171a.m196B(parcel);
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    z2 = C0171a.m208c(parcel, A);
                    break;
                case 3:
                    z = C0171a.m208c(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0799v(i, z2, z);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public C0799v[] m1469b(int i) {
        return new C0799v[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1468a(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1469b(x0);
    }
}
