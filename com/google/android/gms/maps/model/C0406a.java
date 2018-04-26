package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0406a {
    static void m1527a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, cameraPosition.getVersionCode());
        C0172b.m243a(parcel, 2, cameraPosition.target, i, false);
        C0172b.m238a(parcel, 3, cameraPosition.zoom);
        C0172b.m238a(parcel, 4, cameraPosition.tilt);
        C0172b.m238a(parcel, 5, cameraPosition.bearing);
        C0172b.m235G(parcel, C);
    }
}
