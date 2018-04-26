package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0407b {
    static void m1528a(CircleOptions circleOptions, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, circleOptions.getVersionCode());
        C0172b.m243a(parcel, 2, circleOptions.getCenter(), i, false);
        C0172b.m237a(parcel, 3, circleOptions.getRadius());
        C0172b.m238a(parcel, 4, circleOptions.getStrokeWidth());
        C0172b.m259c(parcel, 5, circleOptions.getStrokeColor());
        C0172b.m259c(parcel, 6, circleOptions.getFillColor());
        C0172b.m238a(parcel, 7, circleOptions.getZIndex());
        C0172b.m250a(parcel, 8, circleOptions.isVisible());
        C0172b.m235G(parcel, C);
    }
}
