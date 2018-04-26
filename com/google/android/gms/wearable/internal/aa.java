package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class aa implements Creator<C0988z> {
    static void m1807a(C0988z c0988z, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, c0988z.versionCode);
        C0172b.m259c(parcel, 2, c0988z.statusCode);
        C0172b.m243a(parcel, 3, c0988z.alQ, i, false);
        C0172b.m235G(parcel, C);
    }

    public C0988z cD(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        ai aiVar = null;
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
                    aiVar = (ai) C0171a.m201a(parcel, A, ai.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0988z(i2, i, aiVar);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cD(x0);
    }

    public C0988z[] em(int i) {
        return new C0988z[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return em(x0);
    }
}
