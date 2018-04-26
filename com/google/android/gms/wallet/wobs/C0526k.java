package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0526k implements Creator<C0968j> {
    static void m1792a(C0968j c0968j, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, c0968j.getVersionCode());
        C0172b.m247a(parcel, 2, c0968j.akZ, false);
        C0172b.m247a(parcel, 3, c0968j.qe, false);
        C0172b.m235G(parcel, C);
    }

    public C0968j co(Parcel parcel) {
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
            return new C0968j(i, str2, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return co(x0);
    }

    public C0968j[] dW(int i) {
        return new C0968j[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dW(x0);
    }
}
