package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import java.util.List;

public class PolylineOptionsCreator implements Creator<PolylineOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1519a(PolylineOptions polylineOptions, Parcel parcel, int i) {
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

    public PolylineOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int B = C0171a.m196B(parcel);
        List list = null;
        boolean z2 = false;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    list = C0171a.m207c(parcel, A, LatLng.CREATOR);
                    break;
                case 3:
                    f2 = C0171a.m217l(parcel, A);
                    break;
                case 4:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 5:
                    f = C0171a.m217l(parcel, A);
                    break;
                case 6:
                    z2 = C0171a.m208c(parcel, A);
                    break;
                case 7:
                    z = C0171a.m208c(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new PolylineOptions(i2, list, f2, i, f, z2, z);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public PolylineOptions[] newArray(int size) {
        return new PolylineOptions[size];
    }
}
