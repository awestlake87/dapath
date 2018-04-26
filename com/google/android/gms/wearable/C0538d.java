package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0538d implements Creator<C0973c> {
    static void m1805a(C0973c c0973c, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, c0973c.xM);
        C0172b.m247a(parcel, 2, c0973c.getName(), false);
        C0172b.m247a(parcel, 3, c0973c.getAddress(), false);
        C0172b.m259c(parcel, 4, c0973c.getType());
        C0172b.m259c(parcel, 5, c0973c.getRole());
        C0172b.m250a(parcel, 6, c0973c.isEnabled());
        C0172b.m235G(parcel, C);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ct(x0);
    }

    public C0973c ct(Parcel parcel) {
        String str = null;
        boolean z = false;
        int B = C0171a.m196B(parcel);
        int i = 0;
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 4:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 5:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 6:
                    z = C0171a.m208c(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0973c(i3, str2, str, i2, i, z);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public C0973c[] eb(int i) {
        return new C0973c[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eb(x0);
    }
}
