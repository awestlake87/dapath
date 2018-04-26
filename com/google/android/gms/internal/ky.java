package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.internal.ks.C1109c;
import java.util.HashSet;
import java.util.Set;

public class ky implements Creator<C1109c> {
    static void m1335a(C1109c c1109c, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        Set kk = c1109c.kk();
        if (kk.contains(Integer.valueOf(1))) {
            C0172b.m259c(parcel, 1, c1109c.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            C0172b.m247a(parcel, 2, c1109c.getUrl(), true);
        }
        C0172b.m235G(parcel, C);
    }

    public C1109c bL(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(2));
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C1109c(hashSet, i, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bL(x0);
    }

    public C1109c[] di(int i) {
        return new C1109c[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return di(x0);
    }
}
