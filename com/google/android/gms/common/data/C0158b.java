package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0158b implements Creator<C0609a> {
    static void m162a(C0609a c0609a, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, c0609a.xM);
        C0172b.m243a(parcel, 2, c0609a.Ew, i, false);
        C0172b.m259c(parcel, 3, c0609a.AT);
        C0172b.m235G(parcel, C);
    }

    public C0609a[] ab(int i) {
        return new C0609a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m163w(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ab(x0);
    }

    public C0609a m163w(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            ParcelFileDescriptor parcelFileDescriptor2;
            int g;
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    int i3 = i;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    g = C0171a.m212g(parcel, A);
                    A = i3;
                    break;
                case 2:
                    g = i2;
                    ParcelFileDescriptor parcelFileDescriptor3 = (ParcelFileDescriptor) C0171a.m201a(parcel, A, ParcelFileDescriptor.CREATOR);
                    A = i;
                    parcelFileDescriptor2 = parcelFileDescriptor3;
                    break;
                case 3:
                    A = C0171a.m212g(parcel, A);
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    g = i2;
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    A = i;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    g = i2;
                    break;
            }
            i2 = g;
            parcelFileDescriptor = parcelFileDescriptor2;
            i = A;
        }
        if (parcel.dataPosition() == B) {
            return new C0609a(i2, parcelFileDescriptor, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }
}
