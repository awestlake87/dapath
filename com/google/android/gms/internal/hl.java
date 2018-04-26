package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.internal.gy.C0744a;
import java.util.List;

public class hl implements Creator<C0744a> {
    static void m1222a(C0744a c0744a, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m247a(parcel, 1, c0744a.getAccountName(), false);
        C0172b.m259c(parcel, 1000, c0744a.getVersionCode());
        C0172b.m248a(parcel, 2, c0744a.fl(), false);
        C0172b.m259c(parcel, 3, c0744a.fk());
        C0172b.m247a(parcel, 4, c0744a.fn(), false);
        C0172b.m235G(parcel, C);
    }

    public C0744a[] aq(int i) {
        return new C0744a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1223z(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aq(x0);
    }

    public C0744a m1223z(Parcel parcel) {
        int i = 0;
        String str = null;
        int B = C0171a.m196B(parcel);
        List list = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 2:
                    list = C0171a.m197B(parcel, A);
                    break;
                case 3:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 4:
                    str = C0171a.m220o(parcel, A);
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
            return new C0744a(i2, str2, list, i, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }
}
