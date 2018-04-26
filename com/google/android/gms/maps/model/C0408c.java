package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0408c {
    static void m1529a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, groundOverlayOptions.getVersionCode());
        C0172b.m241a(parcel, 2, groundOverlayOptions.jN(), false);
        C0172b.m243a(parcel, 3, groundOverlayOptions.getLocation(), i, false);
        C0172b.m238a(parcel, 4, groundOverlayOptions.getWidth());
        C0172b.m238a(parcel, 5, groundOverlayOptions.getHeight());
        C0172b.m243a(parcel, 6, groundOverlayOptions.getBounds(), i, false);
        C0172b.m238a(parcel, 7, groundOverlayOptions.getBearing());
        C0172b.m238a(parcel, 8, groundOverlayOptions.getZIndex());
        C0172b.m250a(parcel, 9, groundOverlayOptions.isVisible());
        C0172b.m238a(parcel, 10, groundOverlayOptions.getTransparency());
        C0172b.m238a(parcel, 11, groundOverlayOptions.getAnchorU());
        C0172b.m238a(parcel, 12, groundOverlayOptions.getAnchorV());
        C0172b.m235G(parcel, C);
    }
}
