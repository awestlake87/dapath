package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class ax implements Creator<aw> {
    static void m826a(aw awVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, awVar.versionCode);
        C0172b.m259c(parcel, 2, awVar.mD);
        C0172b.m259c(parcel, 3, awVar.backgroundColor);
        C0172b.m259c(parcel, 4, awVar.mE);
        C0172b.m259c(parcel, 5, awVar.mF);
        C0172b.m259c(parcel, 6, awVar.mG);
        C0172b.m259c(parcel, 7, awVar.mH);
        C0172b.m259c(parcel, 8, awVar.mI);
        C0172b.m259c(parcel, 9, awVar.mJ);
        C0172b.m247a(parcel, 10, awVar.mK, false);
        C0172b.m259c(parcel, 11, awVar.mL);
        C0172b.m247a(parcel, 12, awVar.mM, false);
        C0172b.m259c(parcel, 13, awVar.mN);
        C0172b.m259c(parcel, 14, awVar.mO);
        C0172b.m247a(parcel, 15, awVar.mP, false);
        C0172b.m235G(parcel, C);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m827d(x0);
    }

    public aw m827d(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 3:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 4:
                    i4 = C0171a.m212g(parcel, A);
                    break;
                case 5:
                    i5 = C0171a.m212g(parcel, A);
                    break;
                case 6:
                    i6 = C0171a.m212g(parcel, A);
                    break;
                case 7:
                    i7 = C0171a.m212g(parcel, A);
                    break;
                case 8:
                    i8 = C0171a.m212g(parcel, A);
                    break;
                case 9:
                    i9 = C0171a.m212g(parcel, A);
                    break;
                case 10:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 11:
                    i10 = C0171a.m212g(parcel, A);
                    break;
                case 12:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 13:
                    i11 = C0171a.m212g(parcel, A);
                    break;
                case 14:
                    i12 = C0171a.m212g(parcel, A);
                    break;
                case 15:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new aw(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public aw[] m828f(int i) {
        return new aw[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m828f(x0);
    }
}
