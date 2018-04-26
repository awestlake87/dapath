package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class GroundOverlayOptionsCreator implements Creator<GroundOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1513a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
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

    public GroundOverlayOptions createFromParcel(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        IBinder iBinder = null;
        LatLng latLng = null;
        float f = 0.0f;
        float f2 = 0.0f;
        LatLngBounds latLngBounds = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z = false;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    iBinder = C0171a.m221p(parcel, A);
                    break;
                case 3:
                    latLng = (LatLng) C0171a.m201a(parcel, A, LatLng.CREATOR);
                    break;
                case 4:
                    f = C0171a.m217l(parcel, A);
                    break;
                case 5:
                    f2 = C0171a.m217l(parcel, A);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) C0171a.m201a(parcel, A, LatLngBounds.CREATOR);
                    break;
                case 7:
                    f3 = C0171a.m217l(parcel, A);
                    break;
                case 8:
                    f4 = C0171a.m217l(parcel, A);
                    break;
                case 9:
                    z = C0171a.m208c(parcel, A);
                    break;
                case 10:
                    f5 = C0171a.m217l(parcel, A);
                    break;
                case 11:
                    f6 = C0171a.m217l(parcel, A);
                    break;
                case 12:
                    f7 = C0171a.m217l(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new GroundOverlayOptions(i, iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public GroundOverlayOptions[] newArray(int size) {
        return new GroundOverlayOptions[size];
    }
}
