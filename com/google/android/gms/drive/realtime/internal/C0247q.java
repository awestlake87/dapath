package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0247q implements Creator<ParcelableIndexReference> {
    static void m455a(ParcelableIndexReference parcelableIndexReference, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, parcelableIndexReference.xM);
        C0172b.m247a(parcel, 2, parcelableIndexReference.Lq, false);
        C0172b.m259c(parcel, 3, parcelableIndexReference.mIndex);
        C0172b.m250a(parcel, 4, parcelableIndexReference.Lr);
        C0172b.m235G(parcel, C);
    }

    public ParcelableIndexReference aS(Parcel parcel) {
        boolean z = false;
        int B = C0171a.m196B(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 4:
                    z = C0171a.m208c(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ParcelableIndexReference(i2, str, i, z);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public ParcelableIndexReference[] bP(int i) {
        return new ParcelableIndexReference[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aS(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bP(x0);
    }
}
