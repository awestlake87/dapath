package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0546w implements Creator<C0986v> {
    static void m1853a(C0986v c0986v, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, c0986v.versionCode);
        C0172b.m259c(parcel, 2, c0986v.statusCode);
        C0172b.m243a(parcel, 3, c0986v.alO, i, false);
        C0172b.m235G(parcel, C);
    }

    public C0986v cB(Parcel parcel) {
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
            return new C0986v(i2, i, c1158m);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cB(x0);
    }

    public C0986v[] ek(int i) {
        return new C0986v[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ek(x0);
    }
}
