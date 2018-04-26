package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class ew implements Creator<ev> {
    static void m1020a(ev evVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, evVar.versionCode);
        C0172b.m247a(parcel, 2, evVar.sw, false);
        C0172b.m259c(parcel, 3, evVar.sx);
        C0172b.m259c(parcel, 4, evVar.sy);
        C0172b.m250a(parcel, 5, evVar.sz);
        C0172b.m235G(parcel, C);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1021j(x0);
    }

    public ev m1021j(Parcel parcel) {
        boolean z = false;
        int B = C0171a.m196B(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 4:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 5:
                    z = C0171a.m208c(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ev(i3, str, i2, i, z);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1022q(x0);
    }

    public ev[] m1022q(int i) {
        return new ev[i];
    }
}
