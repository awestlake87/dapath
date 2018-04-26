package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class StreetViewPanoramaLocationCreator implements Creator<StreetViewPanoramaLocation> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1522a(StreetViewPanoramaLocation streetViewPanoramaLocation, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, streetViewPanoramaLocation.getVersionCode());
        C0172b.m253a(parcel, 2, streetViewPanoramaLocation.links, i, false);
        C0172b.m243a(parcel, 3, streetViewPanoramaLocation.position, i, false);
        C0172b.m247a(parcel, 4, streetViewPanoramaLocation.panoId, false);
        C0172b.m235G(parcel, C);
    }

    public StreetViewPanoramaLocation createFromParcel(Parcel parcel) {
        String str = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        LatLng latLng = null;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr = null;
        while (parcel.dataPosition() < B) {
            LatLng latLng2;
            StreetViewPanoramaLink[] streetViewPanoramaLinkArr2;
            int g;
            String str2;
            int A = C0171a.m194A(parcel);
            String str3;
            switch (C0171a.ar(A)) {
                case 1:
                    str3 = str;
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    g = C0171a.m212g(parcel, A);
                    str2 = str3;
                    break;
                case 2:
                    g = i;
                    LatLng latLng3 = latLng;
                    streetViewPanoramaLinkArr2 = (StreetViewPanoramaLink[]) C0171a.m206b(parcel, A, StreetViewPanoramaLink.CREATOR);
                    str2 = str;
                    latLng2 = latLng3;
                    break;
                case 3:
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    g = i;
                    str3 = str;
                    latLng2 = (LatLng) C0171a.m201a(parcel, A, LatLng.CREATOR);
                    str2 = str3;
                    break;
                case 4:
                    str2 = C0171a.m220o(parcel, A);
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    g = i;
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    str2 = str;
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    g = i;
                    break;
            }
            i = g;
            streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
            latLng = latLng2;
            str = str2;
        }
        if (parcel.dataPosition() == B) {
            return new StreetViewPanoramaLocation(i, streetViewPanoramaLinkArr, latLng, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public StreetViewPanoramaLocation[] newArray(int size) {
        return new StreetViewPanoramaLocation[size];
    }
}
