package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class ar implements Creator<aq> {
    static void m1845a(aq aqVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, aqVar.versionCode);
        C0172b.m259c(parcel, 2, aqVar.statusCode);
        C0172b.m259c(parcel, 3, aqVar.amc);
        C0172b.m235G(parcel, C);
    }

    public aq cJ(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 3:
                    i = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new aq(i3, i2, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cJ(x0);
    }

    public aq[] es(int i) {
        return new aq[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return es(x0);
    }
}
