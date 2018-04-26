package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class C0216g implements Creator<InFilter> {
    static void m379a(InFilter inFilter, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1000, inFilter.xM);
        C0172b.m243a(parcel, 1, inFilter.KM, i, false);
        C0172b.m235G(parcel, C);
    }

    public InFilter aK(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    metadataBundle = (MetadataBundle) C0171a.m201a(parcel, A, MetadataBundle.CREATOR);
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
            return new InFilter(i, metadataBundle);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public InFilter[] bG(int i) {
        return new InFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aK(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bG(x0);
    }
}
