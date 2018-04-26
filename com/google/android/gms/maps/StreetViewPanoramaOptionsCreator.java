package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public class StreetViewPanoramaOptionsCreator implements Creator<StreetViewPanoramaOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1483a(StreetViewPanoramaOptions streetViewPanoramaOptions, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, streetViewPanoramaOptions.getVersionCode());
        C0172b.m243a(parcel, 2, streetViewPanoramaOptions.getStreetViewPanoramaCamera(), i, false);
        C0172b.m247a(parcel, 3, streetViewPanoramaOptions.getPanoramaId(), false);
        C0172b.m243a(parcel, 4, streetViewPanoramaOptions.getPosition(), i, false);
        C0172b.m245a(parcel, 5, streetViewPanoramaOptions.getRadius(), false);
        C0172b.m236a(parcel, 6, streetViewPanoramaOptions.jD());
        C0172b.m236a(parcel, 7, streetViewPanoramaOptions.jv());
        C0172b.m236a(parcel, 8, streetViewPanoramaOptions.jE());
        C0172b.m236a(parcel, 9, streetViewPanoramaOptions.jF());
        C0172b.m236a(parcel, 10, streetViewPanoramaOptions.jr());
        C0172b.m235G(parcel, C);
    }

    public StreetViewPanoramaOptions createFromParcel(Parcel parcel) {
        Integer num = null;
        byte b = (byte) 0;
        int B = C0171a.m196B(parcel);
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        LatLng latLng = null;
        String str = null;
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) C0171a.m201a(parcel, A, StreetViewPanoramaCamera.CREATOR);
                    break;
                case 3:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 4:
                    latLng = (LatLng) C0171a.m201a(parcel, A, LatLng.CREATOR);
                    break;
                case 5:
                    num = C0171a.m213h(parcel, A);
                    break;
                case 6:
                    b5 = C0171a.m210e(parcel, A);
                    break;
                case 7:
                    b4 = C0171a.m210e(parcel, A);
                    break;
                case 8:
                    b3 = C0171a.m210e(parcel, A);
                    break;
                case 9:
                    b2 = C0171a.m210e(parcel, A);
                    break;
                case 10:
                    b = C0171a.m210e(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new StreetViewPanoramaOptions(i, streetViewPanoramaCamera, str, latLng, num, b5, b4, b3, b2, b);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public StreetViewPanoramaOptions[] newArray(int size) {
        return new StreetViewPanoramaOptions[size];
    }
}
