package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0383a {
    static void m1484a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, googleMapOptions.getVersionCode());
        C0172b.m236a(parcel, 2, googleMapOptions.jq());
        C0172b.m236a(parcel, 3, googleMapOptions.jr());
        C0172b.m259c(parcel, 4, googleMapOptions.getMapType());
        C0172b.m243a(parcel, 5, googleMapOptions.getCamera(), i, false);
        C0172b.m236a(parcel, 6, googleMapOptions.js());
        C0172b.m236a(parcel, 7, googleMapOptions.jt());
        C0172b.m236a(parcel, 8, googleMapOptions.ju());
        C0172b.m236a(parcel, 9, googleMapOptions.jv());
        C0172b.m236a(parcel, 10, googleMapOptions.jw());
        C0172b.m236a(parcel, 11, googleMapOptions.jx());
        C0172b.m235G(parcel, C);
    }
}
