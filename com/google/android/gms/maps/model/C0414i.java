package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0414i {
    static void m1535a(Tile tile, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, tile.getVersionCode());
        C0172b.m259c(parcel, 2, tile.width);
        C0172b.m259c(parcel, 3, tile.height);
        C0172b.m251a(parcel, 4, tile.data, false);
        C0172b.m235G(parcel, C);
    }
}
