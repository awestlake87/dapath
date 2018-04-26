package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0411f {
    static void m1532a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, markerOptions.getVersionCode());
        C0172b.m243a(parcel, 2, markerOptions.getPosition(), i, false);
        C0172b.m247a(parcel, 3, markerOptions.getTitle(), false);
        C0172b.m247a(parcel, 4, markerOptions.getSnippet(), false);
        C0172b.m241a(parcel, 5, markerOptions.jO(), false);
        C0172b.m238a(parcel, 6, markerOptions.getAnchorU());
        C0172b.m238a(parcel, 7, markerOptions.getAnchorV());
        C0172b.m250a(parcel, 8, markerOptions.isDraggable());
        C0172b.m250a(parcel, 9, markerOptions.isVisible());
        C0172b.m235G(parcel, C);
    }
}
