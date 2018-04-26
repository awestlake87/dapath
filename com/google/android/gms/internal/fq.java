package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class fq implements Creator<fp> {
    static void m1075a(fp fpVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m247a(parcel, 1, fpVar.name, false);
        C0172b.m259c(parcel, 1000, fpVar.xM);
        C0172b.m247a(parcel, 2, fpVar.yb, false);
        C0172b.m250a(parcel, 3, fpVar.yc);
        C0172b.m259c(parcel, 4, fpVar.weight);
        C0172b.m250a(parcel, 5, fpVar.yd);
        C0172b.m247a(parcel, 6, fpVar.ye, false);
        C0172b.m253a(parcel, 7, fpVar.yf, i, false);
        C0172b.m252a(parcel, 8, fpVar.yg, false);
        C0172b.m247a(parcel, 11, fpVar.yh, false);
        C0172b.m235G(parcel, C);
    }

    public fp[] m1076J(int i) {
        return new fp[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1077p(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1076J(x0);
    }

    public fp m1077p(Parcel parcel) {
        boolean z = false;
        String str = null;
        int B = C0171a.m196B(parcel);
        int i = 1;
        int[] iArr = null;
        fm[] fmVarArr = null;
        String str2 = null;
        boolean z2 = false;
        String str3 = null;
        String str4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    str4 = C0171a.m220o(parcel, A);
                    break;
                case 2:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    z2 = C0171a.m208c(parcel, A);
                    break;
                case 4:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 5:
                    z = C0171a.m208c(parcel, A);
                    break;
                case 6:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 7:
                    fmVarArr = (fm[]) C0171a.m206b(parcel, A, fm.CREATOR);
                    break;
                case 8:
                    iArr = C0171a.m226u(parcel, A);
                    break;
                case 11:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 1000:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new fp(i2, str4, str3, z2, i, z, str2, fmVarArr, iArr, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }
}
