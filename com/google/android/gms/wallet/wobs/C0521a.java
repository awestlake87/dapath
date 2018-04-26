package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.dapath.pathgen.PathGenerator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.internal.ig;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class C0521a implements Creator<CommonWalletObject> {
    static void m1787a(CommonWalletObject commonWalletObject, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, commonWalletObject.getVersionCode());
        C0172b.m247a(parcel, 2, commonWalletObject.eC, false);
        C0172b.m247a(parcel, 3, commonWalletObject.ajq, false);
        C0172b.m247a(parcel, 4, commonWalletObject.name, false);
        C0172b.m247a(parcel, 5, commonWalletObject.ajj, false);
        C0172b.m247a(parcel, 6, commonWalletObject.ajm, false);
        C0172b.m247a(parcel, 7, commonWalletObject.ajn, false);
        C0172b.m247a(parcel, 8, commonWalletObject.ajo, false);
        C0172b.m247a(parcel, 9, commonWalletObject.ajp, false);
        C0172b.m259c(parcel, 10, commonWalletObject.state);
        C0172b.m258b(parcel, 11, commonWalletObject.ajr, false);
        C0172b.m243a(parcel, 12, commonWalletObject.ajs, i, false);
        C0172b.m258b(parcel, 13, commonWalletObject.ajt, false);
        C0172b.m247a(parcel, 14, commonWalletObject.aju, false);
        C0172b.m247a(parcel, 15, commonWalletObject.ajv, false);
        C0172b.m250a(parcel, 17, commonWalletObject.ajx);
        C0172b.m258b(parcel, 16, commonWalletObject.ajw, false);
        C0172b.m258b(parcel, 19, commonWalletObject.ajz, false);
        C0172b.m258b(parcel, 18, commonWalletObject.ajy, false);
        C0172b.m258b(parcel, 20, commonWalletObject.ajA, false);
        C0172b.m235G(parcel, C);
    }

    public CommonWalletObject cj(Parcel parcel) {
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
        int i2 = 0;
        ArrayList ga = ig.ga();
        C0969l c0969l = null;
        ArrayList ga2 = ig.ga();
        String str9 = null;
        String str10 = null;
        ArrayList ga3 = ig.ga();
        boolean z = false;
        ArrayList ga4 = ig.ga();
        ArrayList ga5 = ig.ga();
        ArrayList ga6 = ig.ga();
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
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 11:
                    ga = C0171a.m207c(parcel, A, C0971p.CREATOR);
                    break;
                case 12:
                    c0969l = (C0969l) C0171a.m201a(parcel, A, C0969l.CREATOR);
                    break;
                case 13:
                    ga2 = C0171a.m207c(parcel, A, LatLng.CREATOR);
                    break;
                case 14:
                    str9 = C0171a.m220o(parcel, A);
                    break;
                case 15:
                    str10 = C0171a.m220o(parcel, A);
                    break;
                case 16:
                    ga3 = C0171a.m207c(parcel, A, C0965d.CREATOR);
                    break;
                case 17:
                    z = C0171a.m208c(parcel, A);
                    break;
                case 18:
                    ga4 = C0171a.m207c(parcel, A, C0970n.CREATOR);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    ga5 = C0171a.m207c(parcel, A, C0968j.CREATOR);
                    break;
                case PathGenerator.SUBDIVISIONS /*20*/:
                    ga6 = C0171a.m207c(parcel, A, C0970n.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new CommonWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, i2, ga, c0969l, ga2, str9, str10, ga3, z, ga4, ga5, ga6);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cj(x0);
    }

    public CommonWalletObject[] dR(int i) {
        return new CommonWalletObject[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dR(x0);
    }
}
