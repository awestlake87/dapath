package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0547y implements Creator<C0987x> {
    static void m1854a(C0987x c0987x, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, c0987x.versionCode);
        C0172b.m259c(parcel, 2, c0987x.statusCode);
        C0172b.m243a(parcel, 3, c0987x.alP, i, false);
        C0172b.m235G(parcel, C);
    }

    public C0987x cC(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
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
                    parcelFileDescriptor = (ParcelFileDescriptor) C0171a.m201a(parcel, A, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0987x(i2, i, parcelFileDescriptor);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cC(x0);
    }

    public C0987x[] el(int i) {
        return new C0987x[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return el(x0);
    }
}
