package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import java.util.Collection;

public class C0203a implements Creator<AppVisibleCustomProperties> {
    static void m367a(AppVisibleCustomProperties appVisibleCustomProperties, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, appVisibleCustomProperties.xM);
        C0172b.m258b(parcel, 2, appVisibleCustomProperties.JO, false);
        C0172b.m235G(parcel, C);
    }

    public AppVisibleCustomProperties aA(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        Collection collection = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    collection = C0171a.m207c(parcel, A, CustomProperty.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new AppVisibleCustomProperties(i, collection);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public AppVisibleCustomProperties[] bw(int i) {
        return new AppVisibleCustomProperties[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bw(x0);
    }
}
