package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.internal.ks.C1108b.C1107b;
import java.util.HashSet;
import java.util.Set;

public class kx implements Creator<C1107b> {
    static void m1334a(C1107b c1107b, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        Set kk = c1107b.kk();
        if (kk.contains(Integer.valueOf(1))) {
            C0172b.m259c(parcel, 1, c1107b.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            C0172b.m259c(parcel, 2, c1107b.getHeight());
        }
        if (kk.contains(Integer.valueOf(3))) {
            C0172b.m247a(parcel, 3, c1107b.getUrl(), true);
        }
        if (kk.contains(Integer.valueOf(4))) {
            C0172b.m259c(parcel, 4, c1107b.getWidth());
        }
        C0172b.m235G(parcel, C);
    }

    public C1107b bK(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        Set hashSet = new HashSet();
        String str = null;
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
                    str = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    i = C0171a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C1107b(hashSet, i3, i2, str, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bK(x0);
    }

    public C1107b[] dh(int i) {
        return new C1107b[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dh(x0);
    }
}
