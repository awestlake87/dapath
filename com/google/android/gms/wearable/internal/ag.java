package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class ag implements Creator<af> {
    static void m1840a(af afVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, afVar.xM);
        C0172b.m259c(parcel, 2, afVar.getRequestId());
        C0172b.m247a(parcel, 3, afVar.getPath(), false);
        C0172b.m251a(parcel, 4, afVar.getData(), false);
        C0172b.m247a(parcel, 5, afVar.getSourceNodeId(), false);
        C0172b.m235G(parcel, C);
    }

    public af cE(Parcel parcel) {
        int i = 0;
        String str = null;
        int B = C0171a.m196B(parcel);
        byte[] bArr = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 3:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 4:
                    bArr = C0171a.m223r(parcel, A);
                    break;
                case 5:
                    str = C0171a.m220o(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new af(i2, i, str2, bArr, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cE(x0);
    }

    public af[] en(int i) {
        return new af[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return en(x0);
    }
}
