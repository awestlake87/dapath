package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class fl implements Creator<fk> {
    static void m1063a(fk fkVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m247a(parcel, 1, fkVar.xU, false);
        C0172b.m259c(parcel, 1000, fkVar.xM);
        C0172b.m243a(parcel, 3, fkVar.xV, i, false);
        C0172b.m259c(parcel, 4, fkVar.xW);
        C0172b.m251a(parcel, 5, fkVar.xX, false);
        C0172b.m235G(parcel, C);
    }

    public fk[] m1064F(int i) {
        return new fk[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m1065n(x0);
    }

    public fk m1065n(Parcel parcel) {
        byte[] bArr = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        int i2 = -1;
        fp fpVar = null;
        String str = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    fpVar = (fp) C0171a.m201a(parcel, A, fp.CREATOR);
                    break;
                case 4:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 5:
                    bArr = C0171a.m223r(parcel, A);
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
            return new fk(i, str, fpVar, i2, bArr);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m1064F(x0);
    }
}
