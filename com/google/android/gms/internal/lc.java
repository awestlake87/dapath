package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.internal.ks.C1113h;
import java.util.HashSet;
import java.util.Set;

public class lc implements Creator<C1113h> {
    static void m1339a(C1113h c1113h, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        Set kk = c1113h.kk();
        if (kk.contains(Integer.valueOf(1))) {
            C0172b.m259c(parcel, 1, c1113h.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(3))) {
            C0172b.m259c(parcel, 3, c1113h.kX());
        }
        if (kk.contains(Integer.valueOf(4))) {
            C0172b.m247a(parcel, 4, c1113h.getValue(), true);
        }
        if (kk.contains(Integer.valueOf(5))) {
            C0172b.m247a(parcel, 5, c1113h.getLabel(), true);
        }
        if (kk.contains(Integer.valueOf(6))) {
            C0172b.m259c(parcel, 6, c1113h.getType());
        }
        C0172b.m235G(parcel, C);
    }

    public C1113h bP(Parcel parcel) {
        String str = null;
        int i = 0;
        int B = C0171a.m196B(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i3 = C0171a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 3:
                    i = C0171a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str2 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    i2 = C0171a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(6));
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C1113h(hashSet, i3, str2, i2, str, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bP(x0);
    }

    public C1113h[] dm(int i) {
        return new C1113h[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dm(x0);
    }
}
