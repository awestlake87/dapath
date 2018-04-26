package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0424j {
    static void m1548a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, tileOverlayOptions.getVersionCode());
        C0172b.m241a(parcel, 2, tileOverlayOptions.jQ(), false);
        C0172b.m250a(parcel, 3, tileOverlayOptions.isVisible());
        C0172b.m238a(parcel, 4, tileOverlayOptions.getZIndex());
        C0172b.m235G(parcel, C);
    }
}
