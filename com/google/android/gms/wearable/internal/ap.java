package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class ap implements Creator<ao> {
    static void m1844a(ao aoVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, aoVar.xM);
        C0172b.m241a(parcel, 2, aoVar.no(), false);
        C0172b.m235G(parcel, C);
    }

    public ao cI(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    iBinder = C0171a.m221p(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ao(i, iBinder);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cI(x0);
    }

    public ao[] er(int i) {
        return new ao[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return er(x0);
    }
}
