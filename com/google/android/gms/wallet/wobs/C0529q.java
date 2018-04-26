package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0529q implements Creator<C0971p> {
    static void m1795a(C0971p c0971p, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, c0971p.getVersionCode());
        C0172b.m247a(parcel, 2, c0971p.akZ, false);
        C0172b.m247a(parcel, 3, c0971p.qe, false);
        C0172b.m243a(parcel, 4, c0971p.ald, i, false);
        C0172b.m243a(parcel, 5, c0971p.ale, i, false);
        C0172b.m243a(parcel, 6, c0971p.alf, i, false);
        C0172b.m235G(parcel, C);
    }

    public C0971p cr(Parcel parcel) {
        C0970n c0970n = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        C0970n c0970n2 = null;
        C0969l c0969l = null;
        String str = null;
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
                case 4:
                    c0969l = (C0969l) C0171a.m201a(parcel, A, C0969l.CREATOR);
                    break;
                case 5:
                    c0970n2 = (C0970n) C0171a.m201a(parcel, A, C0970n.CREATOR);
                    break;
                case 6:
                    c0970n = (C0970n) C0171a.m201a(parcel, A, C0970n.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0971p(i, str2, str, c0969l, c0970n2, c0970n);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cr(x0);
    }

    public C0971p[] dZ(int i) {
        return new C0971p[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dZ(x0);
    }
}
