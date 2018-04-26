package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class lj implements Creator<li> {
    static void m1341a(li liVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, liVar.getVersionCode());
        C0172b.m254a(parcel, 2, liVar.ake, false);
        C0172b.m255a(parcel, 3, liVar.akf, false);
        C0172b.m235G(parcel, C);
    }

    public li cf(Parcel parcel) {
        String[] strArr = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        byte[][] bArr = (byte[][]) null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    strArr = C0171a.m195A(parcel, A);
                    break;
                case 3:
                    bArr = C0171a.m224s(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new li(i, strArr, bArr);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cf(x0);
    }

    public li[] dL(int i) {
        return new li[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dL(x0);
    }
}
