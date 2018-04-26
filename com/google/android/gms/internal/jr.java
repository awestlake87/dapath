package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class jr implements Creator<jq> {
    static void m1310a(jq jqVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1000, jqVar.xM);
        C0172b.m243a(parcel, 2, jqVar.jf(), i, false);
        C0172b.m239a(parcel, 3, jqVar.getInterval());
        C0172b.m259c(parcel, 4, jqVar.getPriority());
        C0172b.m235G(parcel, C);
    }

    public jq bx(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        jm jmVar = null;
        long j = jq.Wm;
        int i2 = 102;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 2:
                    jmVar = (jm) C0171a.m201a(parcel, A, jm.CREATOR);
                    break;
                case 3:
                    j = C0171a.m214i(parcel, A);
                    break;
                case 4:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 1000:
                    i = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new jq(i, jmVar, j, i2);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public jq[] cS(int i) {
        return new jq[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bx(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cS(x0);
    }
}
