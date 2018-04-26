package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class LatLngBoundsCreator implements Creator<LatLngBounds> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1515a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, latLngBounds.getVersionCode());
        C0172b.m243a(parcel, 2, latLngBounds.southwest, i, false);
        C0172b.m243a(parcel, 3, latLngBounds.northeast, i, false);
        C0172b.m235G(parcel, C);
    }

    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < B) {
            int g;
            LatLng latLng3;
            int A = C0171a.m194A(parcel);
            LatLng latLng4;
            switch (C0171a.ar(A)) {
                case 1:
                    latLng4 = latLng;
                    latLng = latLng2;
                    g = C0171a.m212g(parcel, A);
                    latLng3 = latLng4;
                    break;
                case 2:
                    g = i;
                    latLng4 = (LatLng) C0171a.m201a(parcel, A, LatLng.CREATOR);
                    latLng3 = latLng;
                    latLng = latLng4;
                    break;
                case 3:
                    latLng3 = (LatLng) C0171a.m201a(parcel, A, LatLng.CREATOR);
                    latLng = latLng2;
                    g = i;
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    latLng3 = latLng;
                    latLng = latLng2;
                    g = i;
                    break;
            }
            i = g;
            latLng2 = latLng;
            latLng = latLng3;
        }
        if (parcel.dataPosition() == B) {
            return new LatLngBounds(i, latLng2, latLng);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public LatLngBounds[] newArray(int size) {
        return new LatLngBounds[size];
    }
}
