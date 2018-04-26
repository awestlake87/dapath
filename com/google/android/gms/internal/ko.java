package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.dapath.pathgen.PathGenerator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.games.Notifications;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ko implements Creator<kn> {
    static void m1328a(kn knVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        Set kk = knVar.kk();
        if (kk.contains(Integer.valueOf(1))) {
            C0172b.m259c(parcel, 1, knVar.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            C0172b.m243a(parcel, 2, knVar.kl(), i, true);
        }
        if (kk.contains(Integer.valueOf(3))) {
            C0172b.m248a(parcel, 3, knVar.getAdditionalName(), true);
        }
        if (kk.contains(Integer.valueOf(4))) {
            C0172b.m243a(parcel, 4, knVar.km(), i, true);
        }
        if (kk.contains(Integer.valueOf(5))) {
            C0172b.m247a(parcel, 5, knVar.getAddressCountry(), true);
        }
        if (kk.contains(Integer.valueOf(6))) {
            C0172b.m247a(parcel, 6, knVar.getAddressLocality(), true);
        }
        if (kk.contains(Integer.valueOf(7))) {
            C0172b.m247a(parcel, 7, knVar.getAddressRegion(), true);
        }
        if (kk.contains(Integer.valueOf(8))) {
            C0172b.m258b(parcel, 8, knVar.kn(), true);
        }
        if (kk.contains(Integer.valueOf(9))) {
            C0172b.m259c(parcel, 9, knVar.getAttendeeCount());
        }
        if (kk.contains(Integer.valueOf(10))) {
            C0172b.m258b(parcel, 10, knVar.ko(), true);
        }
        if (kk.contains(Integer.valueOf(11))) {
            C0172b.m243a(parcel, 11, knVar.kp(), i, true);
        }
        if (kk.contains(Integer.valueOf(12))) {
            C0172b.m258b(parcel, 12, knVar.kq(), true);
        }
        if (kk.contains(Integer.valueOf(13))) {
            C0172b.m247a(parcel, 13, knVar.getBestRating(), true);
        }
        if (kk.contains(Integer.valueOf(14))) {
            C0172b.m247a(parcel, 14, knVar.getBirthDate(), true);
        }
        if (kk.contains(Integer.valueOf(15))) {
            C0172b.m243a(parcel, 15, knVar.kr(), i, true);
        }
        if (kk.contains(Integer.valueOf(17))) {
            C0172b.m247a(parcel, 17, knVar.getContentSize(), true);
        }
        if (kk.contains(Integer.valueOf(16))) {
            C0172b.m247a(parcel, 16, knVar.getCaption(), true);
        }
        if (kk.contains(Integer.valueOf(19))) {
            C0172b.m258b(parcel, 19, knVar.ks(), true);
        }
        if (kk.contains(Integer.valueOf(18))) {
            C0172b.m247a(parcel, 18, knVar.getContentUrl(), true);
        }
        if (kk.contains(Integer.valueOf(21))) {
            C0172b.m247a(parcel, 21, knVar.getDateModified(), true);
        }
        if (kk.contains(Integer.valueOf(20))) {
            C0172b.m247a(parcel, 20, knVar.getDateCreated(), true);
        }
        if (kk.contains(Integer.valueOf(23))) {
            C0172b.m247a(parcel, 23, knVar.getDescription(), true);
        }
        if (kk.contains(Integer.valueOf(22))) {
            C0172b.m247a(parcel, 22, knVar.getDatePublished(), true);
        }
        if (kk.contains(Integer.valueOf(25))) {
            C0172b.m247a(parcel, 25, knVar.getEmbedUrl(), true);
        }
        if (kk.contains(Integer.valueOf(24))) {
            C0172b.m247a(parcel, 24, knVar.getDuration(), true);
        }
        if (kk.contains(Integer.valueOf(27))) {
            C0172b.m247a(parcel, 27, knVar.getFamilyName(), true);
        }
        if (kk.contains(Integer.valueOf(26))) {
            C0172b.m247a(parcel, 26, knVar.getEndDate(), true);
        }
        if (kk.contains(Integer.valueOf(29))) {
            C0172b.m243a(parcel, 29, knVar.kt(), i, true);
        }
        if (kk.contains(Integer.valueOf(28))) {
            C0172b.m247a(parcel, 28, knVar.getGender(), true);
        }
        if (kk.contains(Integer.valueOf(31))) {
            C0172b.m247a(parcel, 31, knVar.getHeight(), true);
        }
        if (kk.contains(Integer.valueOf(30))) {
            C0172b.m247a(parcel, 30, knVar.getGivenName(), true);
        }
        if (kk.contains(Integer.valueOf(34))) {
            C0172b.m243a(parcel, 34, knVar.ku(), i, true);
        }
        if (kk.contains(Integer.valueOf(32))) {
            C0172b.m247a(parcel, 32, knVar.getId(), true);
        }
        if (kk.contains(Integer.valueOf(33))) {
            C0172b.m247a(parcel, 33, knVar.getImage(), true);
        }
        if (kk.contains(Integer.valueOf(38))) {
            C0172b.m237a(parcel, 38, knVar.getLongitude());
        }
        if (kk.contains(Integer.valueOf(39))) {
            C0172b.m247a(parcel, 39, knVar.getName(), true);
        }
        if (kk.contains(Integer.valueOf(36))) {
            C0172b.m237a(parcel, 36, knVar.getLatitude());
        }
        if (kk.contains(Integer.valueOf(37))) {
            C0172b.m243a(parcel, 37, knVar.kv(), i, true);
        }
        if (kk.contains(Integer.valueOf(42))) {
            C0172b.m247a(parcel, 42, knVar.getPlayerType(), true);
        }
        if (kk.contains(Integer.valueOf(43))) {
            C0172b.m247a(parcel, 43, knVar.getPostOfficeBoxNumber(), true);
        }
        if (kk.contains(Integer.valueOf(40))) {
            C0172b.m243a(parcel, 40, knVar.kw(), i, true);
        }
        if (kk.contains(Integer.valueOf(41))) {
            C0172b.m258b(parcel, 41, knVar.kx(), true);
        }
        if (kk.contains(Integer.valueOf(46))) {
            C0172b.m243a(parcel, 46, knVar.ky(), i, true);
        }
        if (kk.contains(Integer.valueOf(47))) {
            C0172b.m247a(parcel, 47, knVar.getStartDate(), true);
        }
        if (kk.contains(Integer.valueOf(44))) {
            C0172b.m247a(parcel, 44, knVar.getPostalCode(), true);
        }
        if (kk.contains(Integer.valueOf(45))) {
            C0172b.m247a(parcel, 45, knVar.getRatingValue(), true);
        }
        if (kk.contains(Integer.valueOf(51))) {
            C0172b.m247a(parcel, 51, knVar.getThumbnailUrl(), true);
        }
        if (kk.contains(Integer.valueOf(50))) {
            C0172b.m243a(parcel, 50, knVar.kz(), i, true);
        }
        if (kk.contains(Integer.valueOf(49))) {
            C0172b.m247a(parcel, 49, knVar.getText(), true);
        }
        if (kk.contains(Integer.valueOf(48))) {
            C0172b.m247a(parcel, 48, knVar.getStreetAddress(), true);
        }
        if (kk.contains(Integer.valueOf(55))) {
            C0172b.m247a(parcel, 55, knVar.getWidth(), true);
        }
        if (kk.contains(Integer.valueOf(54))) {
            C0172b.m247a(parcel, 54, knVar.getUrl(), true);
        }
        if (kk.contains(Integer.valueOf(53))) {
            C0172b.m247a(parcel, 53, knVar.getType(), true);
        }
        if (kk.contains(Integer.valueOf(52))) {
            C0172b.m247a(parcel, 52, knVar.getTickerSymbol(), true);
        }
        if (kk.contains(Integer.valueOf(56))) {
            C0172b.m247a(parcel, 56, knVar.getWorstRating(), true);
        }
        C0172b.m235G(parcel, C);
    }

    public kn bE(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        kn knVar = null;
        List list = null;
        kn knVar2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        List list2 = null;
        int i2 = 0;
        List list3 = null;
        kn knVar3 = null;
        List list4 = null;
        String str4 = null;
        String str5 = null;
        kn knVar4 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        List list5 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        String str17 = null;
        kn knVar5 = null;
        String str18 = null;
        String str19 = null;
        String str20 = null;
        String str21 = null;
        kn knVar6 = null;
        double d = 0.0d;
        kn knVar7 = null;
        double d2 = 0.0d;
        String str22 = null;
        kn knVar8 = null;
        List list6 = null;
        String str23 = null;
        String str24 = null;
        String str25 = null;
        String str26 = null;
        kn knVar9 = null;
        String str27 = null;
        String str28 = null;
        String str29 = null;
        kn knVar10 = null;
        String str30 = null;
        String str31 = null;
        String str32 = null;
        String str33 = null;
        String str34 = null;
        String str35 = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            kn knVar11;
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    knVar11 = (kn) C0171a.m201a(parcel, A, kn.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    knVar = knVar11;
                    break;
                case 3:
                    list = C0171a.m197B(parcel, A);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    knVar11 = (kn) C0171a.m201a(parcel, A, kn.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    knVar2 = knVar11;
                    break;
                case 5:
                    str = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str2 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case 7:
                    str3 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case 8:
                    list2 = C0171a.m207c(parcel, A, kn.CREATOR);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case 9:
                    i2 = C0171a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case 10:
                    list3 = C0171a.m207c(parcel, A, kn.CREATOR);
                    hashSet.add(Integer.valueOf(10));
                    break;
                case 11:
                    knVar11 = (kn) C0171a.m201a(parcel, A, kn.CREATOR);
                    hashSet.add(Integer.valueOf(11));
                    knVar3 = knVar11;
                    break;
                case 12:
                    list4 = C0171a.m207c(parcel, A, kn.CREATOR);
                    hashSet.add(Integer.valueOf(12));
                    break;
                case 13:
                    str4 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(13));
                    break;
                case 14:
                    str5 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(14));
                    break;
                case 15:
                    knVar11 = (kn) C0171a.m201a(parcel, A, (Creator) kn.CREATOR);
                    hashSet.add(Integer.valueOf(15));
                    knVar4 = knVar11;
                    break;
                case 16:
                    str6 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(16));
                    break;
                case 17:
                    str7 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(17));
                    break;
                case 18:
                    str8 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(18));
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    list5 = C0171a.m207c(parcel, A, kn.CREATOR);
                    hashSet.add(Integer.valueOf(19));
                    break;
                case PathGenerator.SUBDIVISIONS /*20*/:
                    str9 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(20));
                    break;
                case 21:
                    str10 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(21));
                    break;
                case 22:
                    str11 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(22));
                    break;
                case 23:
                    str12 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(23));
                    break;
                case 24:
                    str13 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(24));
                    break;
                case 25:
                    str14 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(25));
                    break;
                case 26:
                    str15 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(26));
                    break;
                case 27:
                    str16 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(27));
                    break;
                case 28:
                    str17 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(28));
                    break;
                case 29:
                    knVar11 = (kn) C0171a.m201a(parcel, A, (Creator) kn.CREATOR);
                    hashSet.add(Integer.valueOf(29));
                    knVar5 = knVar11;
                    break;
                case 30:
                    str18 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(30));
                    break;
                case Notifications.NOTIFICATION_TYPES_ALL /*31*/:
                    str19 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(31));
                    break;
                case 32:
                    str20 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(32));
                    break;
                case 33:
                    str21 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(33));
                    break;
                case 34:
                    knVar11 = (kn) C0171a.m201a(parcel, A, (Creator) kn.CREATOR);
                    hashSet.add(Integer.valueOf(34));
                    knVar6 = knVar11;
                    break;
                case 36:
                    d = C0171a.m218m(parcel, A);
                    hashSet.add(Integer.valueOf(36));
                    break;
                case 37:
                    knVar11 = (kn) C0171a.m201a(parcel, A, (Creator) kn.CREATOR);
                    hashSet.add(Integer.valueOf(37));
                    knVar7 = knVar11;
                    break;
                case 38:
                    d2 = C0171a.m218m(parcel, A);
                    hashSet.add(Integer.valueOf(38));
                    break;
                case 39:
                    str22 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(39));
                    break;
                case 40:
                    knVar11 = (kn) C0171a.m201a(parcel, A, (Creator) kn.CREATOR);
                    hashSet.add(Integer.valueOf(40));
                    knVar8 = knVar11;
                    break;
                case 41:
                    list6 = C0171a.m207c(parcel, A, kn.CREATOR);
                    hashSet.add(Integer.valueOf(41));
                    break;
                case 42:
                    str23 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(42));
                    break;
                case 43:
                    str24 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(43));
                    break;
                case 44:
                    str25 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(44));
                    break;
                case 45:
                    str26 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(45));
                    break;
                case 46:
                    knVar11 = (kn) C0171a.m201a(parcel, A, (Creator) kn.CREATOR);
                    hashSet.add(Integer.valueOf(46));
                    knVar9 = knVar11;
                    break;
                case 47:
                    str27 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(47));
                    break;
                case 48:
                    str28 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(48));
                    break;
                case 49:
                    str29 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(49));
                    break;
                case 50:
                    knVar11 = (kn) C0171a.m201a(parcel, A, (Creator) kn.CREATOR);
                    hashSet.add(Integer.valueOf(50));
                    knVar10 = knVar11;
                    break;
                case 51:
                    str30 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(51));
                    break;
                case 52:
                    str31 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(52));
                    break;
                case 53:
                    str32 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(53));
                    break;
                case 54:
                    str33 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(54));
                    break;
                case 55:
                    str34 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(55));
                    break;
                case 56:
                    str35 = C0171a.m220o(parcel, A);
                    hashSet.add(Integer.valueOf(56));
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new kn(hashSet, i, knVar, list, knVar2, str, str2, str3, list2, i2, list3, knVar3, list4, str4, str5, knVar4, str6, str7, str8, list5, str9, str10, str11, str12, str13, str14, str15, str16, str17, knVar5, str18, str19, str20, str21, knVar6, d, knVar7, d2, str22, knVar8, list6, str23, str24, str25, str26, knVar9, str27, str28, str29, knVar10, str30, str31, str32, str33, str34, str35);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bE(x0);
    }

    public kn[] db(int i) {
        return new kn[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return db(x0);
    }
}
