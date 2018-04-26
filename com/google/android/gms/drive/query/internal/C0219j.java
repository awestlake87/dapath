package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0219j implements Creator<NotFilter> {
    static void m382a(NotFilter notFilter, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1000, notFilter.xM);
        C0172b.m243a(parcel, 1, notFilter.KZ, i, false);
        C0172b.m235G(parcel, C);
    }

    public NotFilter aN(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        FilterHolder filterHolder = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    filterHolder = (FilterHolder) C0171a.m201a(parcel, A, FilterHolder.CREATOR);
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
            return new NotFilter(i, filterHolder);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public NotFilter[] bJ(int i) {
        return new NotFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aN(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bJ(x0);
    }
}
