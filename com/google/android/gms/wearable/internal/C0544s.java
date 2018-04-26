package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.wearable.C0973c;

public class C0544s implements Creator<C0984r> {
    static void m1851a(C0984r c0984r, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, c0984r.versionCode);
        C0172b.m259c(parcel, 2, c0984r.statusCode);
        C0172b.m243a(parcel, 3, c0984r.alM, i, false);
        C0172b.m235G(parcel, C);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cz(x0);
    }

    public C0984r cz(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        C0973c c0973c = null;
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
                    c0973c = (C0973c) C0171a.m201a(parcel, A, C0973c.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0984r(i2, i, c0973c);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public C0984r[] ei(int i) {
        return new C0984r[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ei(x0);
    }
}
