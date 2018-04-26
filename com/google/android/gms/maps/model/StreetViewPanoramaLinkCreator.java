package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class StreetViewPanoramaLinkCreator implements Creator<StreetViewPanoramaLink> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1521a(StreetViewPanoramaLink streetViewPanoramaLink, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, streetViewPanoramaLink.getVersionCode());
        C0172b.m247a(parcel, 2, streetViewPanoramaLink.panoId, false);
        C0172b.m238a(parcel, 3, streetViewPanoramaLink.bearing);
        C0172b.m235G(parcel, C);
    }

    public StreetViewPanoramaLink createFromParcel(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str = null;
        float f = 0.0f;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    f = C0171a.m217l(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new StreetViewPanoramaLink(i, str, f);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public StreetViewPanoramaLink[] newArray(int size) {
        return new StreetViewPanoramaLink[size];
    }
}
