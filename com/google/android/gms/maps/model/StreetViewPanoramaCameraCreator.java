package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class StreetViewPanoramaCameraCreator implements Creator<StreetViewPanoramaCamera> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1520a(StreetViewPanoramaCamera streetViewPanoramaCamera, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, streetViewPanoramaCamera.getVersionCode());
        C0172b.m238a(parcel, 2, streetViewPanoramaCamera.zoom);
        C0172b.m238a(parcel, 3, streetViewPanoramaCamera.tilt);
        C0172b.m238a(parcel, 4, streetViewPanoramaCamera.bearing);
        C0172b.m235G(parcel, C);
    }

    public StreetViewPanoramaCamera createFromParcel(Parcel parcel) {
        float f = 0.0f;
        int B = C0171a.m196B(parcel);
        float f2 = 0.0f;
        int i = 0;
        float f3 = 0.0f;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    f2 = C0171a.m217l(parcel, A);
                    break;
                case 3:
                    f3 = C0171a.m217l(parcel, A);
                    break;
                case 4:
                    f = C0171a.m217l(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new StreetViewPanoramaCamera(i, f2, f3, f);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public StreetViewPanoramaCamera[] newArray(int size) {
        return new StreetViewPanoramaCamera[size];
    }
}
