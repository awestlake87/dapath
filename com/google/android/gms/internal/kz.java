package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.internal.ks.C1110d;
import java.util.HashSet;
import java.util.Set;

public class kz implements Creator<C1110d> {
    static void m1336a(C1110d c1110d, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        Set kk = c1110d.kk();
        if (kk.contains(Integer.valueOf(1))) {
            C0172b.m259c(parcel, 1, c1110d.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            C0172b.m247a(parcel, 2, c1110d.getFamilyName(), true);
        }
        if (kk.contains(Integer.valueOf(3))) {
            C0172b.m247a(parcel, 3, c1110d.getFormatted(), true);
        }
        if (kk.contains(Integer.valueOf(4))) {
            C0172b.m247a(parcel, 4, c1110d.getGivenName(), true);
        }
        if (kk.contains(Integer.valueOf(5))) {
            C0172b.m247a(parcel, 5, c1110d.getHonorificPrefix(), true);
        }
        if (kk.contains(Integer.valueOf(6))) {
            C0172b.m247a(parcel, 6, c1110d.getHonorificSuffix(), true);
        }
        if (kk.contains(Integer.valueOf(7))) {
            C0172b.m247a(parcel, 7, c1110d.getMiddleName(), true);
        }
        C0172b.m235G(parcel, C);
    }

    public C1110d bM(Parcel parcel) {
        String str = null;
        int B = C0171a.m196B(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str6 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str5 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str4 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str3 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str2 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    str = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C1110d(hashSet, i, str6, str5, str4, str3, str2, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bM(x0);
    }

    public C1110d[] dj(int i) {
        return new C1110d[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dj(x0);
    }
}
