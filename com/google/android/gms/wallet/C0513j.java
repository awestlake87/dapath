package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.dapath.pathgen.PathGenerator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.internal.ig;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.C0965d;
import com.google.android.gms.wallet.wobs.C0966f;
import com.google.android.gms.wallet.wobs.C0968j;
import com.google.android.gms.wallet.wobs.C0969l;
import com.google.android.gms.wallet.wobs.C0970n;
import com.google.android.gms.wallet.wobs.C0971p;
import java.util.ArrayList;

public class C0513j implements Creator<LoyaltyWalletObject> {
    static void m1781a(LoyaltyWalletObject loyaltyWalletObject, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, loyaltyWalletObject.getVersionCode());
        C0172b.m247a(parcel, 2, loyaltyWalletObject.eC, false);
        C0172b.m247a(parcel, 3, loyaltyWalletObject.aji, false);
        C0172b.m247a(parcel, 4, loyaltyWalletObject.ajj, false);
        C0172b.m247a(parcel, 5, loyaltyWalletObject.ajk, false);
        C0172b.m247a(parcel, 6, loyaltyWalletObject.ajl, false);
        C0172b.m247a(parcel, 7, loyaltyWalletObject.ajm, false);
        C0172b.m247a(parcel, 8, loyaltyWalletObject.ajn, false);
        C0172b.m247a(parcel, 9, loyaltyWalletObject.ajo, false);
        C0172b.m247a(parcel, 10, loyaltyWalletObject.ajp, false);
        C0172b.m247a(parcel, 11, loyaltyWalletObject.ajq, false);
        C0172b.m259c(parcel, 12, loyaltyWalletObject.state);
        C0172b.m258b(parcel, 13, loyaltyWalletObject.ajr, false);
        C0172b.m243a(parcel, 14, loyaltyWalletObject.ajs, i, false);
        C0172b.m258b(parcel, 15, loyaltyWalletObject.ajt, false);
        C0172b.m247a(parcel, 17, loyaltyWalletObject.ajv, false);
        C0172b.m247a(parcel, 16, loyaltyWalletObject.aju, false);
        C0172b.m250a(parcel, 19, loyaltyWalletObject.ajx);
        C0172b.m258b(parcel, 18, loyaltyWalletObject.ajw, false);
        C0172b.m258b(parcel, 21, loyaltyWalletObject.ajz, false);
        C0172b.m258b(parcel, 20, loyaltyWalletObject.ajy, false);
        C0172b.m243a(parcel, 23, loyaltyWalletObject.ajB, i, false);
        C0172b.m258b(parcel, 22, loyaltyWalletObject.ajA, false);
        C0172b.m235G(parcel, C);
    }

    public LoyaltyWalletObject bY(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        int i2 = 0;
        ArrayList ga = ig.ga();
        C0969l c0969l = null;
        ArrayList ga2 = ig.ga();
        String str11 = null;
        String str12 = null;
        ArrayList ga3 = ig.ga();
        boolean z = false;
        ArrayList ga4 = ig.ga();
        ArrayList ga5 = ig.ga();
        ArrayList ga6 = ig.ga();
        C0966f c0966f = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 4:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 5:
                    str4 = C0171a.m220o(parcel, A);
                    break;
                case 6:
                    str5 = C0171a.m220o(parcel, A);
                    break;
                case 7:
                    str6 = C0171a.m220o(parcel, A);
                    break;
                case 8:
                    str7 = C0171a.m220o(parcel, A);
                    break;
                case 9:
                    str8 = C0171a.m220o(parcel, A);
                    break;
                case 10:
                    str9 = C0171a.m220o(parcel, A);
                    break;
                case 11:
                    str10 = C0171a.m220o(parcel, A);
                    break;
                case 12:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 13:
                    ga = C0171a.m207c(parcel, A, C0971p.CREATOR);
                    break;
                case 14:
                    c0969l = (C0969l) C0171a.m201a(parcel, A, C0969l.CREATOR);
                    break;
                case 15:
                    ga2 = C0171a.m207c(parcel, A, LatLng.CREATOR);
                    break;
                case 16:
                    str11 = C0171a.m220o(parcel, A);
                    break;
                case 17:
                    str12 = C0171a.m220o(parcel, A);
                    break;
                case 18:
                    ga3 = C0171a.m207c(parcel, A, C0965d.CREATOR);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    z = C0171a.m208c(parcel, A);
                    break;
                case PathGenerator.SUBDIVISIONS /*20*/:
                    ga4 = C0171a.m207c(parcel, A, C0970n.CREATOR);
                    break;
                case 21:
                    ga5 = C0171a.m207c(parcel, A, C0968j.CREATOR);
                    break;
                case 22:
                    ga6 = C0171a.m207c(parcel, A, C0970n.CREATOR);
                    break;
                case 23:
                    c0966f = (C0966f) C0171a.m201a(parcel, A, C0966f.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new LoyaltyWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, i2, ga, c0969l, ga2, str11, str12, ga3, z, ga4, ga5, ga6, c0966f);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bY(x0);
    }

    public LoyaltyWalletObject[] dE(int i) {
        return new LoyaltyWalletObject[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dE(x0);
    }
}
