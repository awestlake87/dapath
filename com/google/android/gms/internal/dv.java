package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import java.util.List;

public class dv implements Creator<du> {
    static void m912a(du duVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, duVar.versionCode);
        C0172b.m247a(parcel, 2, duVar.oA, false);
        C0172b.m247a(parcel, 3, duVar.qe, false);
        C0172b.m248a(parcel, 4, duVar.nt, false);
        C0172b.m259c(parcel, 5, duVar.errorCode);
        C0172b.m248a(parcel, 6, duVar.nu, false);
        C0172b.m239a(parcel, 7, duVar.qf);
        C0172b.m250a(parcel, 8, duVar.qg);
        C0172b.m239a(parcel, 9, duVar.qh);
        C0172b.m248a(parcel, 10, duVar.qi, false);
        C0172b.m239a(parcel, 11, duVar.nx);
        C0172b.m259c(parcel, 12, duVar.orientation);
        C0172b.m247a(parcel, 13, duVar.qj, false);
        C0172b.m239a(parcel, 14, duVar.qk);
        C0172b.m247a(parcel, 15, duVar.ql, false);
        C0172b.m247a(parcel, 19, duVar.qn, false);
        C0172b.m250a(parcel, 18, duVar.qm);
        C0172b.m247a(parcel, 21, duVar.qo, false);
        C0172b.m235G(parcel, C);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m913i(x0);
    }

    public du m913i(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        int i2 = 0;
        List list2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        List list3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
        String str4 = null;
        boolean z2 = false;
        String str5 = null;
        String str6 = null;
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
                    list = C0171a.m197B(parcel, A);
                    break;
                case 5:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 6:
                    list2 = C0171a.m197B(parcel, A);
                    break;
                case 7:
                    j = C0171a.m214i(parcel, A);
                    break;
                case 8:
                    z = C0171a.m208c(parcel, A);
                    break;
                case 9:
                    j2 = C0171a.m214i(parcel, A);
                    break;
                case 10:
                    list3 = C0171a.m197B(parcel, A);
                    break;
                case 11:
                    j3 = C0171a.m214i(parcel, A);
                    break;
                case 12:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 13:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 14:
                    j4 = C0171a.m214i(parcel, A);
                    break;
                case 15:
                    str4 = C0171a.m220o(parcel, A);
                    break;
                case 18:
                    z2 = C0171a.m208c(parcel, A);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    str5 = C0171a.m220o(parcel, A);
                    break;
                case 21:
                    str6 = C0171a.m220o(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new du(i, str, str2, list, i2, list2, j, z, j2, list3, j3, i3, str3, j4, str4, z2, str5, str6);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public du[] m914n(int i) {
        return new du[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m914n(x0);
    }
}
