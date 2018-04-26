package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0425k {
    static void m1549a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, visibleRegion.getVersionCode());
        C0172b.m243a(parcel, 2, visibleRegion.nearLeft, i, false);
        C0172b.m243a(parcel, 3, visibleRegion.nearRight, i, false);
        C0172b.m243a(parcel, 4, visibleRegion.farLeft, i, false);
        C0172b.m243a(parcel, 5, visibleRegion.farRight, i, false);
        C0172b.m243a(parcel, 6, visibleRegion.latLngBounds, i, false);
        C0172b.m235G(parcel, C);
    }
}
