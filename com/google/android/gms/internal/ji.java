package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class ji implements Creator<jh> {
    static void m1306a(jh jhVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m247a(parcel, 1, jhVar.getRequestId(), false);
        C0172b.m259c(parcel, 1000, jhVar.getVersionCode());
        C0172b.m239a(parcel, 2, jhVar.getExpirationTime());
        C0172b.m249a(parcel, 3, jhVar.ja());
        C0172b.m237a(parcel, 4, jhVar.getLatitude());
        C0172b.m237a(parcel, 5, jhVar.getLongitude());
        C0172b.m238a(parcel, 6, jhVar.jb());
        C0172b.m259c(parcel, 7, jhVar.jc());
        C0172b.m259c(parcel, 8, jhVar.getNotificationResponsiveness());
        C0172b.m259c(parcel, 9, jhVar.jd());
        C0172b.m235G(parcel, C);
    }

    public jh bt(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = (short) 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 2:
                    j = C0171a.m214i(parcel, A);
                    break;
                case 3:
                    s = C0171a.m211f(parcel, A);
                    break;
                case 4:
                    d = C0171a.m218m(parcel, A);
                    break;
                case 5:
                    d2 = C0171a.m218m(parcel, A);
                    break;
                case 6:
                    f = C0171a.m217l(parcel, A);
                    break;
                case 7:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 8:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 9:
                    i4 = C0171a.m212g(parcel, A);
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
            return new jh(i, str, i2, s, d, d2, f, j, i3, i4);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public jh[] cO(int i) {
        return new jh[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bt(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cO(x0);
    }
}
