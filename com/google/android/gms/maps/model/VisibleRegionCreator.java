package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class VisibleRegionCreator implements Creator<VisibleRegion> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1526a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, visibleRegion.getVersionCode());
        C0172b.m243a(parcel, 2, visibleRegion.nearLeft, i, false);
        C0172b.m243a(parcel, 3, visibleRegion.nearRight, i, false);
        C0172b.m243a(parcel, 4, visibleRegion.farLeft, i, false);
        C0172b.m243a(parcel, 5, visibleRegion.farRight, i, false);
        C0172b.m243a(parcel, 6, visibleRegion.latLngBounds, i, false);
        C0172b.m235G(parcel, C);
    }

    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    latLng4 = (LatLng) C0171a.m201a(parcel, A, LatLng.CREATOR);
                    break;
                case 3:
                    latLng3 = (LatLng) C0171a.m201a(parcel, A, LatLng.CREATOR);
                    break;
                case 4:
                    latLng2 = (LatLng) C0171a.m201a(parcel, A, LatLng.CREATOR);
                    break;
                case 5:
                    latLng = (LatLng) C0171a.m201a(parcel, A, LatLng.CREATOR);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) C0171a.m201a(parcel, A, LatLngBounds.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public VisibleRegion[] newArray(int size) {
        return new VisibleRegion[size];
    }
}
