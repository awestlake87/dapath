package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0522c implements Creator<C0964b> {
    static void m1788a(C0964b c0964b, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, c0964b.getVersionCode());
        C0172b.m247a(parcel, 2, c0964b.label, false);
        C0172b.m247a(parcel, 3, c0964b.value, false);
        C0172b.m235G(parcel, C);
    }

    public C0964b ck(Parcel parcel) {
        String str = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    str = C0171a.m220o(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0964b(i, str2, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ck(x0);
    }

    public C0964b[] dS(int i) {
        return new C0964b[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dS(x0);
    }
}
