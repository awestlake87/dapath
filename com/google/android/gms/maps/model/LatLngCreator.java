package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class LatLngCreator implements Creator<LatLng> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1516a(LatLng latLng, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, latLng.getVersionCode());
        C0172b.m237a(parcel, 2, latLng.latitude);
        C0172b.m237a(parcel, 3, latLng.longitude);
        C0172b.m235G(parcel, C);
    }

    public LatLng createFromParcel(Parcel parcel) {
        double d = 0.0d;
        int B = C0171a.m196B(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    d2 = C0171a.m218m(parcel, A);
                    break;
                case 3:
                    d = C0171a.m218m(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new LatLng(i, d2, d);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public LatLng[] newArray(int size) {
        return new LatLng[size];
    }
}
