package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class MarkerOptionsCreator implements Creator<MarkerOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1517a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, markerOptions.getVersionCode());
        C0172b.m243a(parcel, 2, markerOptions.getPosition(), i, false);
        C0172b.m247a(parcel, 3, markerOptions.getTitle(), false);
        C0172b.m247a(parcel, 4, markerOptions.getSnippet(), false);
        C0172b.m241a(parcel, 5, markerOptions.jO(), false);
        C0172b.m238a(parcel, 6, markerOptions.getAnchorU());
        C0172b.m238a(parcel, 7, markerOptions.getAnchorV());
        C0172b.m250a(parcel, 8, markerOptions.isDraggable());
        C0172b.m250a(parcel, 9, markerOptions.isVisible());
        C0172b.m250a(parcel, 10, markerOptions.isFlat());
        C0172b.m238a(parcel, 11, markerOptions.getRotation());
        C0172b.m238a(parcel, 12, markerOptions.getInfoWindowAnchorU());
        C0172b.m238a(parcel, 13, markerOptions.getInfoWindowAnchorV());
        C0172b.m238a(parcel, 14, markerOptions.getAlpha());
        C0172b.m235G(parcel, C);
    }

    public MarkerOptions createFromParcel(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        LatLng latLng = null;
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        float f3 = 0.0f;
        float f4 = 0.5f;
        float f5 = 0.0f;
        float f6 = TextTrackStyle.DEFAULT_FONT_SCALE;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    latLng = (LatLng) C0171a.m201a(parcel, A, LatLng.CREATOR);
                    break;
                case 3:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 4:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 5:
                    iBinder = C0171a.m221p(parcel, A);
                    break;
                case 6:
                    f = C0171a.m217l(parcel, A);
                    break;
                case 7:
                    f2 = C0171a.m217l(parcel, A);
                    break;
                case 8:
                    z = C0171a.m208c(parcel, A);
                    break;
                case 9:
                    z2 = C0171a.m208c(parcel, A);
                    break;
                case 10:
                    z3 = C0171a.m208c(parcel, A);
                    break;
                case 11:
                    f3 = C0171a.m217l(parcel, A);
                    break;
                case 12:
                    f4 = C0171a.m217l(parcel, A);
                    break;
                case 13:
                    f5 = C0171a.m217l(parcel, A);
                    break;
                case 14:
                    f6 = C0171a.m217l(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new MarkerOptions(i, latLng, str, str2, iBinder, f, f2, z, z2, z3, f3, f4, f5, f6);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public MarkerOptions[] newArray(int size) {
        return new MarkerOptions[size];
    }
}
