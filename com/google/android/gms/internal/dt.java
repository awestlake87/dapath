package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class dt implements Creator<ds> {
    static void m909a(ds dsVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, dsVar.versionCode);
        C0172b.m240a(parcel, 2, dsVar.pW, false);
        C0172b.m243a(parcel, 3, dsVar.pX, i, false);
        C0172b.m243a(parcel, 4, dsVar.kT, i, false);
        C0172b.m247a(parcel, 5, dsVar.kN, false);
        C0172b.m243a(parcel, 6, dsVar.applicationInfo, i, false);
        C0172b.m243a(parcel, 7, dsVar.pY, i, false);
        C0172b.m247a(parcel, 8, dsVar.pZ, false);
        C0172b.m247a(parcel, 9, dsVar.qa, false);
        C0172b.m247a(parcel, 10, dsVar.qb, false);
        C0172b.m243a(parcel, 11, dsVar.kQ, i, false);
        C0172b.m240a(parcel, 12, dsVar.qc, false);
        C0172b.m247a(parcel, 13, dsVar.qd, false);
        C0172b.m235G(parcel, C);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m910h(x0);
    }

    public ds m910h(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        Bundle bundle = null;
        ai aiVar = null;
        al alVar = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        ev evVar = null;
        Bundle bundle2 = null;
        String str5 = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    bundle = C0171a.m222q(parcel, A);
                    break;
                case 3:
                    aiVar = (ai) C0171a.m201a(parcel, A, ai.CREATOR);
                    break;
                case 4:
                    alVar = (al) C0171a.m201a(parcel, A, al.CREATOR);
                    break;
                case 5:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) C0171a.m201a(parcel, A, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) C0171a.m201a(parcel, A, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 9:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 10:
                    str4 = C0171a.m220o(parcel, A);
                    break;
                case 11:
                    evVar = (ev) C0171a.m201a(parcel, A, ev.CREATOR);
                    break;
                case 12:
                    bundle2 = C0171a.m222q(parcel, A);
                    break;
                case 13:
                    str5 = C0171a.m220o(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ds(i, bundle, aiVar, alVar, str, applicationInfo, packageInfo, str2, str3, str4, evVar, bundle2, str5);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public ds[] m911m(int i) {
        return new ds[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m911m(x0);
    }
}
