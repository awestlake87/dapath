package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0410e {
    static void m1531a(LatLng latLng, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, latLng.getVersionCode());
        C0172b.m237a(parcel, 2, latLng.latitude);
        C0172b.m237a(parcel, 3, latLng.longitude);
        C0172b.m235G(parcel, C);
    }
}
