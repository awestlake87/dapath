package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class am implements Creator<al> {
    static void m784a(al alVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, alVar.versionCode);
        C0172b.m247a(parcel, 2, alVar.me, false);
        C0172b.m259c(parcel, 3, alVar.height);
        C0172b.m259c(parcel, 4, alVar.heightPixels);
        C0172b.m250a(parcel, 5, alVar.mf);
        C0172b.m259c(parcel, 6, alVar.width);
        C0172b.m259c(parcel, 7, alVar.widthPixels);
        C0172b.m253a(parcel, 8, alVar.mg, i, false);
        C0172b.m235G(parcel, C);
    }

    public al m785c(Parcel parcel) {
        al[] alVarArr = null;
        int i = 0;
        int B = C0171a.m196B(parcel);
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i5 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    i4 = C0171a.m212g(parcel, A);
                    break;
                case 4:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 5:
                    z = C0171a.m208c(parcel, A);
                    break;
                case 6:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 7:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 8:
                    alVarArr = (al[]) C0171a.m206b(parcel, A, al.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new al(i5, str, i4, i3, z, i2, i, alVarArr);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m785c(x0);
    }

    public al[] m786d(int i) {
        return new al[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m786d(x0);
    }
}
