package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.internal.hy.C0758a;

public class hz implements Creator<C0758a> {
    static void m1254a(C0758a c0758a, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, c0758a.getVersionCode());
        C0172b.m259c(parcel, 2, c0758a.fE());
        C0172b.m250a(parcel, 3, c0758a.fK());
        C0172b.m259c(parcel, 4, c0758a.fF());
        C0172b.m250a(parcel, 5, c0758a.fL());
        C0172b.m247a(parcel, 6, c0758a.fM(), false);
        C0172b.m259c(parcel, 7, c0758a.fN());
        C0172b.m247a(parcel, 8, c0758a.fP(), false);
        C0172b.m243a(parcel, 9, c0758a.fR(), i, false);
        C0172b.m235G(parcel, C);
    }

    public C0758a m1255H(Parcel parcel) {
        ht htVar = null;
        int i = 0;
        int B = C0171a.m196B(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i4 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 3:
                    z2 = C0171a.m208c(parcel, A);
                    break;
                case 4:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 5:
                    z = C0171a.m208c(parcel, A);
                    break;
                case 6:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 7:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 8:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 9:
                    htVar = (ht) C0171a.m201a(parcel, A, ht.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0758a(i4, i3, z2, i2, z, str2, i, str, htVar);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public C0758a[] aw(int i) {
        return new C0758a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1255H(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aw(x0);
    }
}
