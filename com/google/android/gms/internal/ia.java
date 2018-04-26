package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.internal.hy.C0758a;
import com.google.android.gms.internal.ib.C0760b;

public class ia implements Creator<C0760b> {
    static void m1256a(C0760b c0760b, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, c0760b.versionCode);
        C0172b.m247a(parcel, 2, c0760b.eM, false);
        C0172b.m243a(parcel, 3, c0760b.Hp, i, false);
        C0172b.m235G(parcel, C);
    }

    public C0760b m1257I(Parcel parcel) {
        C0758a c0758a = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str = null;
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
                    c0758a = (C0758a) C0171a.m201a(parcel, A, C0758a.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0760b(i, str, c0758a);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public C0760b[] ax(int i) {
        return new C0760b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1257I(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ax(x0);
    }
}
