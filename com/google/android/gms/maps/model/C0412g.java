package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0412g {
    static void m1533a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, polygonOptions.getVersionCode());
        C0172b.m258b(parcel, 2, polygonOptions.getPoints(), false);
        C0172b.m260c(parcel, 3, polygonOptions.jP(), false);
        C0172b.m238a(parcel, 4, polygonOptions.getStrokeWidth());
        C0172b.m259c(parcel, 5, polygonOptions.getStrokeColor());
        C0172b.m259c(parcel, 6, polygonOptions.getFillColor());
        C0172b.m238a(parcel, 7, polygonOptions.getZIndex());
        C0172b.m250a(parcel, 8, polygonOptions.isVisible());
        C0172b.m250a(parcel, 9, polygonOptions.isGeodesic());
        C0172b.m235G(parcel, C);
    }
}
