package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0524h implements Creator<C0967g> {
    static void m1790a(C0967g c0967g, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, c0967g.getVersionCode());
        C0172b.m259c(parcel, 2, c0967g.akT);
        C0172b.m247a(parcel, 3, c0967g.akU, false);
        C0172b.m237a(parcel, 4, c0967g.akV);
        C0172b.m247a(parcel, 5, c0967g.akW, false);
        C0172b.m239a(parcel, 6, c0967g.akX);
        C0172b.m259c(parcel, 7, c0967g.akY);
        C0172b.m235G(parcel, C);
    }

    public C0967g cm(Parcel parcel) {
        String str = null;
        int i = 0;
        int B = C0171a.m196B(parcel);
        double d = 0.0d;
        long j = 0;
        int i2 = -1;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 3:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 4:
                    d = C0171a.m218m(parcel, A);
                    break;
                case 5:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 6:
                    j = C0171a.m214i(parcel, A);
                    break;
                case 7:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0967g(i3, i, str2, d, str, j, i2);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cm(x0);
    }

    public C0967g[] dU(int i) {
        return new C0967g[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dU(x0);
    }
}
