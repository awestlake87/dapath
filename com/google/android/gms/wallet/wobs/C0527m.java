package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0527m implements Creator<C0969l> {
    static void m1793a(C0969l c0969l, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, c0969l.getVersionCode());
        C0172b.m239a(parcel, 2, c0969l.ala);
        C0172b.m239a(parcel, 3, c0969l.alb);
        C0172b.m235G(parcel, C);
    }

    public C0969l cp(Parcel parcel) {
        long j = 0;
        int B = C0171a.m196B(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    j2 = C0171a.m214i(parcel, A);
                    break;
                case 3:
                    j = C0171a.m214i(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0969l(i, j2, j);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cp(x0);
    }

    public C0969l[] dX(int i) {
        return new C0969l[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dX(x0);
    }
}
