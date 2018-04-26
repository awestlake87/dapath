package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class an implements Creator<am> {
    static void m1843a(am amVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, amVar.versionCode);
        C0172b.m259c(parcel, 2, amVar.statusCode);
        C0172b.m243a(parcel, 3, amVar.alO, i, false);
        C0172b.m235G(parcel, C);
    }

    public am cH(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        C1158m c1158m = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 3:
                    c1158m = (C1158m) C0171a.m201a(parcel, A, C1158m.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new am(i2, i, c1158m);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cH(x0);
    }

    public am[] eq(int i) {
        return new am[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eq(x0);
    }
}
