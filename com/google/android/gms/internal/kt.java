package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.dapath.pathgen.PathGenerator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.internal.ks.C1105a;
import com.google.android.gms.internal.ks.C1108b;
import com.google.android.gms.internal.ks.C1109c;
import com.google.android.gms.internal.ks.C1110d;
import com.google.android.gms.internal.ks.C1111f;
import com.google.android.gms.internal.ks.C1112g;
import com.google.android.gms.internal.ks.C1113h;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class kt implements Creator<ks> {
    static void m1330a(ks ksVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        Set kk = ksVar.kk();
        if (kk.contains(Integer.valueOf(1))) {
            C0172b.m259c(parcel, 1, ksVar.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            C0172b.m247a(parcel, 2, ksVar.getAboutMe(), true);
        }
        if (kk.contains(Integer.valueOf(3))) {
            C0172b.m243a(parcel, 3, ksVar.kF(), i, true);
        }
        if (kk.contains(Integer.valueOf(4))) {
            C0172b.m247a(parcel, 4, ksVar.getBirthday(), true);
        }
        if (kk.contains(Integer.valueOf(5))) {
            C0172b.m247a(parcel, 5, ksVar.getBraggingRights(), true);
        }
        if (kk.contains(Integer.valueOf(6))) {
            C0172b.m259c(parcel, 6, ksVar.getCircledByCount());
        }
        if (kk.contains(Integer.valueOf(7))) {
            C0172b.m243a(parcel, 7, ksVar.kG(), i, true);
        }
        if (kk.contains(Integer.valueOf(8))) {
            C0172b.m247a(parcel, 8, ksVar.getCurrentLocation(), true);
        }
        if (kk.contains(Integer.valueOf(9))) {
            C0172b.m247a(parcel, 9, ksVar.getDisplayName(), true);
        }
        if (kk.contains(Integer.valueOf(12))) {
            C0172b.m259c(parcel, 12, ksVar.getGender());
        }
        if (kk.contains(Integer.valueOf(14))) {
            C0172b.m247a(parcel, 14, ksVar.getId(), true);
        }
        if (kk.contains(Integer.valueOf(15))) {
            C0172b.m243a(parcel, 15, ksVar.kH(), i, true);
        }
        if (kk.contains(Integer.valueOf(16))) {
            C0172b.m250a(parcel, 16, ksVar.isPlusUser());
        }
        if (kk.contains(Integer.valueOf(19))) {
            C0172b.m243a(parcel, 19, ksVar.kI(), i, true);
        }
        if (kk.contains(Integer.valueOf(18))) {
            C0172b.m247a(parcel, 18, ksVar.getLanguage(), true);
        }
        if (kk.contains(Integer.valueOf(21))) {
            C0172b.m259c(parcel, 21, ksVar.getObjectType());
        }
        if (kk.contains(Integer.valueOf(20))) {
            C0172b.m247a(parcel, 20, ksVar.getNickname(), true);
        }
        if (kk.contains(Integer.valueOf(23))) {
            C0172b.m258b(parcel, 23, ksVar.kK(), true);
        }
        if (kk.contains(Integer.valueOf(22))) {
            C0172b.m258b(parcel, 22, ksVar.kJ(), true);
        }
        if (kk.contains(Integer.valueOf(25))) {
            C0172b.m259c(parcel, 25, ksVar.getRelationshipStatus());
        }
        if (kk.contains(Integer.valueOf(24))) {
            C0172b.m259c(parcel, 24, ksVar.getPlusOneCount());
        }
        if (kk.contains(Integer.valueOf(27))) {
            C0172b.m247a(parcel, 27, ksVar.getUrl(), true);
        }
        if (kk.contains(Integer.valueOf(26))) {
            C0172b.m247a(parcel, 26, ksVar.getTagline(), true);
        }
        if (kk.contains(Integer.valueOf(29))) {
            C0172b.m250a(parcel, 29, ksVar.isVerified());
        }
        if (kk.contains(Integer.valueOf(28))) {
            C0172b.m258b(parcel, 28, ksVar.kL(), true);
        }
        C0172b.m235G(parcel, C);
    }

    public ks bG(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        C1105a c1105a = null;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        C1108b c1108b = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        C1109c c1109c = null;
        boolean z = false;
        String str7 = null;
        C1110d c1110d = null;
        String str8 = null;
        int i4 = 0;
        List list = null;
        List list2 = null;
        int i5 = 0;
        int i6 = 0;
        String str9 = null;
        String str10 = null;
        List list3 = null;
        boolean z2 = false;
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
                case 3:
                    C1105a c1105a2 = (C1105a) C0171a.m201a(parcel, A, C1105a.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    c1105a = c1105a2;
                    break;
                case 4:
                    str2 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str3 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    i2 = C0171a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    C1108b c1108b2 = (C1108b) C0171a.m201a(parcel, A, C1108b.CREATOR);
                    hashSet.add(Integer.valueOf(7));
                    c1108b = c1108b2;
                    break;
                case 8:
                    str4 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    str5 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 12:
                    i3 = C0171a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case 14:
                    str6 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case 15:
                    C1109c c1109c2 = (C1109c) C0171a.m201a(parcel, A, C1109c.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    c1109c = c1109c2;
                    break;
                case 16:
                    z = C0171a.m208c(parcel, A);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case 18:
                    str7 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    C1110d c1110d2 = (C1110d) C0171a.m201a(parcel, A, (Creator) C1110d.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    c1110d = c1110d2;
                    break;
                case PathGenerator.SUBDIVISIONS /*20*/:
                    str8 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case 21:
                    i4 = C0171a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case 22:
                    list = C0171a.m207c(parcel, A, C1111f.CREATOR);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case 23:
                    list2 = C0171a.m207c(parcel, A, C1112g.CREATOR);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case 24:
                    i5 = C0171a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case 25:
                    i6 = C0171a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case 26:
                    str9 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case 27:
                    str10 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case 28:
                    list3 = C0171a.m207c(parcel, A, C1113h.CREATOR);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case 29:
                    z2 = C0171a.m208c(parcel, A);
                    hashSet.add(Integer.valueOf(29));
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ks(hashSet, i, str, c1105a, str2, str3, i2, c1108b, str4, str5, i3, str6, c1109c, z, str7, c1110d, str8, i4, list, list2, i5, i6, str9, str10, list3, z2);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bG(x0);
    }

    public ks[] dd(int i) {
        return new ks[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dd(x0);
    }
}
