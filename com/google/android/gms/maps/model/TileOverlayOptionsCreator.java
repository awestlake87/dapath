package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class TileOverlayOptionsCreator implements Creator<TileOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1525a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, tileOverlayOptions.getVersionCode());
        C0172b.m241a(parcel, 2, tileOverlayOptions.jQ(), false);
        C0172b.m250a(parcel, 3, tileOverlayOptions.isVisible());
        C0172b.m238a(parcel, 4, tileOverlayOptions.getZIndex());
        C0172b.m250a(parcel, 5, tileOverlayOptions.getFadeIn());
        C0172b.m235G(parcel, C);
    }

    public TileOverlayOptions createFromParcel(Parcel parcel) {
        boolean z = false;
        int B = C0171a.m196B(parcel);
        IBinder iBinder = null;
        float f = 0.0f;
        boolean z2 = true;
        int i = 0;
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
                    z = C0171a.m208c(parcel, A);
                    break;
                case 4:
                    f = C0171a.m217l(parcel, A);
                    break;
                case 5:
                    z2 = C0171a.m208c(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new TileOverlayOptions(i, iBinder, z, f, z2);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public TileOverlayOptions[] newArray(int size) {
        return new TileOverlayOptions[size];
    }
}
