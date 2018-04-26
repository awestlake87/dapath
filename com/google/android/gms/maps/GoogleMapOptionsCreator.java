package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.maps.model.CameraPosition;

public class GoogleMapOptionsCreator implements Creator<GoogleMapOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1481a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, googleMapOptions.getVersionCode());
        C0172b.m236a(parcel, 2, googleMapOptions.jq());
        C0172b.m236a(parcel, 3, googleMapOptions.jr());
        C0172b.m259c(parcel, 4, googleMapOptions.getMapType());
        C0172b.m243a(parcel, 5, googleMapOptions.getCamera(), i, false);
        C0172b.m236a(parcel, 6, googleMapOptions.js());
        C0172b.m236a(parcel, 7, googleMapOptions.jt());
        C0172b.m236a(parcel, 8, googleMapOptions.ju());
        C0172b.m236a(parcel, 9, googleMapOptions.jv());
        C0172b.m236a(parcel, 10, googleMapOptions.jw());
        C0172b.m236a(parcel, 11, googleMapOptions.jx());
        C0172b.m235G(parcel, C);
    }

    public GoogleMapOptions createFromParcel(Parcel parcel) {
        byte b = (byte) 0;
        int B = C0171a.m196B(parcel);
        CameraPosition cameraPosition = null;
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        byte b6 = (byte) 0;
        int i = 0;
        byte b7 = (byte) 0;
        byte b8 = (byte) 0;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    b8 = C0171a.m210e(parcel, A);
                    break;
                case 3:
                    b7 = C0171a.m210e(parcel, A);
                    break;
                case 4:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) C0171a.m201a(parcel, A, CameraPosition.CREATOR);
                    break;
                case 6:
                    b6 = C0171a.m210e(parcel, A);
                    break;
                case 7:
                    b5 = C0171a.m210e(parcel, A);
                    break;
                case 8:
                    b4 = C0171a.m210e(parcel, A);
                    break;
                case 9:
                    b3 = C0171a.m210e(parcel, A);
                    break;
                case 10:
                    b2 = C0171a.m210e(parcel, A);
                    break;
                case 11:
                    b = C0171a.m210e(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new GoogleMapOptions(i2, b8, b7, i, cameraPosition, b6, b5, b4, b3, b2, b);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public GoogleMapOptions[] newArray(int size) {
        return new GoogleMapOptions[size];
    }
}
