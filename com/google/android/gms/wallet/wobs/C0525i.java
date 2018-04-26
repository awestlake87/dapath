package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0525i implements Creator<C0966f> {
    static void m1791a(C0966f c0966f, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, c0966f.getVersionCode());
        C0172b.m247a(parcel, 2, c0966f.label, false);
        C0172b.m243a(parcel, 3, c0966f.akS, i, false);
        C0172b.m247a(parcel, 4, c0966f.type, false);
        C0172b.m243a(parcel, 5, c0966f.ajs, i, false);
        C0172b.m235G(parcel, C);
    }

    public C0966f cn(Parcel parcel) {
        C0969l c0969l = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str = null;
        C0967g c0967g = null;
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
                    c0967g = (C0967g) C0171a.m201a(parcel, A, C0967g.CREATOR);
                    break;
                case 4:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 5:
                    c0969l = (C0969l) C0171a.m201a(parcel, A, C0969l.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0966f(i, str2, c0967g, str, c0969l);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cn(x0);
    }

    public C0966f[] dV(int i) {
        return new C0966f[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dV(x0);
    }
}
