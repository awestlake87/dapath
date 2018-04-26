package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0206h implements Creator<MetadataBundle> {
    static void m370a(MetadataBundle metadataBundle, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, metadataBundle.xM);
        C0172b.m240a(parcel, 2, metadataBundle.JS, false);
        C0172b.m235G(parcel, C);
    }

    public MetadataBundle aC(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    bundle = C0171a.m222q(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new MetadataBundle(i, bundle);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public MetadataBundle[] by(int i) {
        return new MetadataBundle[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return by(x0);
    }
}
