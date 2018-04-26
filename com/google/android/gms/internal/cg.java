package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class cg implements Creator<ch> {
    static void m851a(ch chVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, chVar.versionCode);
        C0172b.m243a(parcel, 2, chVar.ov, i, false);
        C0172b.m241a(parcel, 3, chVar.aU(), false);
        C0172b.m241a(parcel, 4, chVar.aV(), false);
        C0172b.m241a(parcel, 5, chVar.aW(), false);
        C0172b.m241a(parcel, 6, chVar.aX(), false);
        C0172b.m247a(parcel, 7, chVar.oA, false);
        C0172b.m250a(parcel, 8, chVar.oB);
        C0172b.m247a(parcel, 9, chVar.oC, false);
        C0172b.m241a(parcel, 10, chVar.aZ(), false);
        C0172b.m259c(parcel, 11, chVar.orientation);
        C0172b.m259c(parcel, 12, chVar.oE);
        C0172b.m247a(parcel, 13, chVar.ob, false);
        C0172b.m243a(parcel, 14, chVar.kQ, i, false);
        C0172b.m241a(parcel, 15, chVar.aY(), false);
        C0172b.m243a(parcel, 17, chVar.oH, i, false);
        C0172b.m247a(parcel, 16, chVar.oG, false);
        C0172b.m235G(parcel, C);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m852f(x0);
    }

    public ch m852f(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        ce ceVar = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        ev evVar = null;
        IBinder iBinder6 = null;
        String str4 = null;
        C0799v c0799v = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    ceVar = (ce) C0171a.m201a(parcel, A, ce.CREATOR);
                    break;
                case 3:
                    iBinder = C0171a.m221p(parcel, A);
                    break;
                case 4:
                    iBinder2 = C0171a.m221p(parcel, A);
                    break;
                case 5:
                    iBinder3 = C0171a.m221p(parcel, A);
                    break;
                case 6:
                    iBinder4 = C0171a.m221p(parcel, A);
                    break;
                case 7:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 8:
                    z = C0171a.m208c(parcel, A);
                    break;
                case 9:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 10:
                    iBinder5 = C0171a.m221p(parcel, A);
                    break;
                case 11:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 12:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 13:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 14:
                    evVar = (ev) C0171a.m201a(parcel, A, (Creator) ev.CREATOR);
                    break;
                case 15:
                    iBinder6 = C0171a.m221p(parcel, A);
                    break;
                case 16:
                    str4 = C0171a.m220o(parcel, A);
                    break;
                case 17:
                    c0799v = (C0799v) C0171a.m201a(parcel, A, (Creator) C0799v.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ch(i, ceVar, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, evVar, iBinder6, str4, c0799v);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public ch[] m853j(int i) {
        return new ch[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m853j(x0);
    }
}
