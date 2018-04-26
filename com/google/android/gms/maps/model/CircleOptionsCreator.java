package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class CircleOptionsCreator implements Creator<CircleOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1512a(CircleOptions circleOptions, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, circleOptions.getVersionCode());
        C0172b.m243a(parcel, 2, circleOptions.getCenter(), i, false);
        C0172b.m237a(parcel, 3, circleOptions.getRadius());
        C0172b.m238a(parcel, 4, circleOptions.getStrokeWidth());
        C0172b.m259c(parcel, 5, circleOptions.getStrokeColor());
        C0172b.m259c(parcel, 6, circleOptions.getFillColor());
        C0172b.m238a(parcel, 7, circleOptions.getZIndex());
        C0172b.m250a(parcel, 8, circleOptions.isVisible());
        C0172b.m235G(parcel, C);
    }

    public CircleOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int B = C0171a.m196B(parcel);
        LatLng latLng = null;
        double d = 0.0d;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    latLng = (LatLng) C0171a.m201a(parcel, A, LatLng.CREATOR);
                    break;
                case 3:
                    d = C0171a.m218m(parcel, A);
                    break;
                case 4:
                    f2 = C0171a.m217l(parcel, A);
                    break;
                case 5:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 6:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 7:
                    f = C0171a.m217l(parcel, A);
                    break;
                case 8:
                    z = C0171a.m208c(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new CircleOptions(i3, latLng, d, f2, i2, i, f, z);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public CircleOptions[] newArray(int size) {
        return new CircleOptions[size];
    }
}
