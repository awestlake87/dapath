package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.internal.ks.C1112g;
import java.util.HashSet;
import java.util.Set;

public class lb implements Creator<C1112g> {
    static void m1338a(C1112g c1112g, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        Set kk = c1112g.kk();
        if (kk.contains(Integer.valueOf(1))) {
            C0172b.m259c(parcel, 1, c1112g.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            C0172b.m250a(parcel, 2, c1112g.isPrimary());
        }
        if (kk.contains(Integer.valueOf(3))) {
            C0172b.m247a(parcel, 3, c1112g.getValue(), true);
        }
        C0172b.m235G(parcel, C);
    }

    public C1112g bO(Parcel parcel) {
        boolean z = false;
        int B = C0171a.m196B(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    z = C0171a.m208c(parcel, A);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C1112g(hashSet, i, z, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bO(x0);
    }

    public C1112g[] dl(int i) {
        return new C1112g[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dl(x0);
    }
}
