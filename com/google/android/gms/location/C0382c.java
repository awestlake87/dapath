package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0382c implements Creator<C0805b> {
    static void m1479a(C0805b c0805b, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, c0805b.Vq);
        C0172b.m259c(parcel, 1000, c0805b.getVersionCode());
        C0172b.m259c(parcel, 2, c0805b.Vr);
        C0172b.m239a(parcel, 3, c0805b.Vs);
        C0172b.m235G(parcel, C);
    }

    public C0805b bs(Parcel parcel) {
        int i = 1;
        int B = C0171a.m196B(parcel);
        int i2 = 0;
        long j = 0;
        int i3 = 1;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 3:
                    j = C0171a.m214i(parcel, A);
                    break;
                case 1000:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0805b(i2, i3, i, j);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public C0805b[] cL(int i) {
        return new C0805b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bs(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cL(x0);
    }
}
