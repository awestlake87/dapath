package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.internal.ks.C1105a;
import java.util.HashSet;
import java.util.Set;

public class ku implements Creator<C1105a> {
    static void m1331a(C1105a c1105a, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        Set kk = c1105a.kk();
        if (kk.contains(Integer.valueOf(1))) {
            C0172b.m259c(parcel, 1, c1105a.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            C0172b.m259c(parcel, 2, c1105a.getMax());
        }
        if (kk.contains(Integer.valueOf(3))) {
            C0172b.m259c(parcel, 3, c1105a.getMin());
        }
        C0172b.m235G(parcel, C);
    }

    public C1105a bH(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i3 = C0171a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    i2 = C0171a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    i = C0171a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C1105a(hashSet, i3, i2, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bH(x0);
    }

    public C1105a[] de(int i) {
        return new C1105a[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return de(x0);
    }
}
