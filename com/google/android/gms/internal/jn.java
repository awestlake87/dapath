package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import java.util.List;

public class jn implements Creator<jm> {
    static void m1308a(jm jmVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m258b(parcel, 1, jmVar.Wc, false);
        C0172b.m259c(parcel, 1000, jmVar.xM);
        C0172b.m247a(parcel, 2, jmVar.jg(), false);
        C0172b.m250a(parcel, 3, jmVar.jh());
        C0172b.m258b(parcel, 4, jmVar.Wf, false);
        C0172b.m247a(parcel, 5, jmVar.ji(), false);
        C0172b.m248a(parcel, 6, jmVar.Wh, false);
        C0172b.m235G(parcel, C);
    }

    public jm bv(Parcel parcel) {
        boolean z = false;
        List list = null;
        int B = C0171a.m196B(parcel);
        String str = null;
        List list2 = null;
        String str2 = null;
        List list3 = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    list3 = C0171a.m207c(parcel, A, js.CREATOR);
                    break;
                case 2:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    z = C0171a.m208c(parcel, A);
                    break;
                case 4:
                    list2 = C0171a.m207c(parcel, A, jw.CREATOR);
                    break;
                case 5:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 6:
                    list = C0171a.m197B(parcel, A);
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
            return new jm(i, list3, str2, z, list2, str, list);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public jm[] cQ(int i) {
        return new jm[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bv(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cQ(x0);
    }
}
