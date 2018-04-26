package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.internal.ks.C1111f;
import java.util.HashSet;
import java.util.Set;

public class la implements Creator<C1111f> {
    static void m1337a(C1111f c1111f, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        Set kk = c1111f.kk();
        if (kk.contains(Integer.valueOf(1))) {
            C0172b.m259c(parcel, 1, c1111f.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            C0172b.m247a(parcel, 2, c1111f.getDepartment(), true);
        }
        if (kk.contains(Integer.valueOf(3))) {
            C0172b.m247a(parcel, 3, c1111f.getDescription(), true);
        }
        if (kk.contains(Integer.valueOf(4))) {
            C0172b.m247a(parcel, 4, c1111f.getEndDate(), true);
        }
        if (kk.contains(Integer.valueOf(5))) {
            C0172b.m247a(parcel, 5, c1111f.getLocation(), true);
        }
        if (kk.contains(Integer.valueOf(6))) {
            C0172b.m247a(parcel, 6, c1111f.getName(), true);
        }
        if (kk.contains(Integer.valueOf(7))) {
            C0172b.m250a(parcel, 7, c1111f.isPrimary());
        }
        if (kk.contains(Integer.valueOf(8))) {
            C0172b.m247a(parcel, 8, c1111f.getStartDate(), true);
        }
        if (kk.contains(Integer.valueOf(9))) {
            C0172b.m247a(parcel, 9, c1111f.getTitle(), true);
        }
        if (kk.contains(Integer.valueOf(10))) {
            C0172b.m259c(parcel, 10, c1111f.getType());
        }
        C0172b.m235G(parcel, C);
    }

    public C1111f bN(Parcel parcel) {
        int i = 0;
        String str = null;
        int B = C0171a.m196B(parcel);
        Set hashSet = new HashSet();
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i2 = C0171a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str7 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str6 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str5 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str4 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str3 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    z = C0171a.m208c(parcel, A);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    str2 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    i = C0171a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(10));
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C1111f(hashSet, i2, str7, str6, str5, str4, str3, z, str2, str, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bN(x0);
    }

    public C1111f[] dk(int i) {
        return new C1111f[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dk(x0);
    }
}
