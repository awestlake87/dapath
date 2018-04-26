package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class fs implements Creator<fr> {
    static void m1078a(fr frVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m243a(parcel, 1, frVar.yq, i, false);
        C0172b.m259c(parcel, 1000, frVar.xM);
        C0172b.m239a(parcel, 2, frVar.yr);
        C0172b.m259c(parcel, 3, frVar.ys);
        C0172b.m247a(parcel, 4, frVar.mP, false);
        C0172b.m243a(parcel, 5, frVar.yt, i, false);
        C0172b.m235G(parcel, C);
    }

    public fr[] m1079K(int i) {
        return new fr[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1080q(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1079K(x0);
    }

    public fr m1080q(Parcel parcel) {
        int i = 0;
        fg fgVar = null;
        int B = C0171a.m196B(parcel);
        long j = 0;
        String str = null;
        fi fiVar = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    fiVar = (fi) C0171a.m201a(parcel, A, fi.CREATOR);
                    break;
                case 2:
                    j = C0171a.m214i(parcel, A);
                    break;
                case 3:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 4:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 5:
                    fgVar = (fg) C0171a.m201a(parcel, A, fg.CREATOR);
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
            return new fr(i2, fiVar, j, i, str, fgVar);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }
}
