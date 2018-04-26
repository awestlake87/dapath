package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0413h {
    static void m1534a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, polylineOptions.getVersionCode());
        C0172b.m258b(parcel, 2, polylineOptions.getPoints(), false);
        C0172b.m238a(parcel, 3, polylineOptions.getWidth());
        C0172b.m259c(parcel, 4, polylineOptions.getColor());
        C0172b.m238a(parcel, 5, polylineOptions.getZIndex());
        C0172b.m250a(parcel, 6, polylineOptions.isVisible());
        C0172b.m250a(parcel, 7, polylineOptions.isGeodesic());
        C0172b.m235G(parcel, C);
    }
}
