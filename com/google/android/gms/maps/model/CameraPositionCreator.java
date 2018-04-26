package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class CameraPositionCreator implements Creator<CameraPosition> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1511a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, cameraPosition.getVersionCode());
        C0172b.m243a(parcel, 2, cameraPosition.target, i, false);
        C0172b.m238a(parcel, 3, cameraPosition.zoom);
        C0172b.m238a(parcel, 4, cameraPosition.tilt);
        C0172b.m238a(parcel, 5, cameraPosition.bearing);
        C0172b.m235G(parcel, C);
    }

    public CameraPosition createFromParcel(Parcel parcel) {
        float f = 0.0f;
        int B = C0171a.m196B(parcel);
        int i = 0;
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
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
                    f3 = C0171a.m217l(parcel, A);
                    break;
                case 4:
                    f2 = C0171a.m217l(parcel, A);
                    break;
                case 5:
                    f = C0171a.m217l(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new CameraPosition(i, latLng, f3, f2, f);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public CameraPosition[] newArray(int size) {
        return new CameraPosition[size];
    }
}
