package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0409d {
    static void m1530a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, latLngBounds.getVersionCode());
        C0172b.m243a(parcel, 2, latLngBounds.southwest, i, false);
        C0172b.m243a(parcel, 3, latLngBounds.northeast, i, false);
        C0172b.m235G(parcel, C);
    }
}
