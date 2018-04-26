package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import java.util.ArrayList;
import java.util.List;

public class PolygonOptionsCreator implements Creator<PolygonOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1518a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, polygonOptions.getVersionCode());
        C0172b.m258b(parcel, 2, polygonOptions.getPoints(), false);
        C0172b.m260c(parcel, 3, polygonOptions.jP(), false);
        C0172b.m238a(parcel, 4, polygonOptions.getStrokeWidth());
        C0172b.m259c(parcel, 5, polygonOptions.getStrokeColor());
        C0172b.m259c(parcel, 6, polygonOptions.getFillColor());
        C0172b.m238a(parcel, 7, polygonOptions.getZIndex());
        C0172b.m250a(parcel, 8, polygonOptions.isVisible());
        C0172b.m250a(parcel, 9, polygonOptions.isGeodesic());
        C0172b.m235G(parcel, C);
    }

    public PolygonOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int B = C0171a.m196B(parcel);
        List list = null;
        List arrayList = new ArrayList();
        boolean z2 = false;
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
                    list = C0171a.m207c(parcel, A, LatLng.CREATOR);
                    break;
                case 3:
                    C0171a.m204a(parcel, A, arrayList, getClass().getClassLoader());
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
                    z2 = C0171a.m208c(parcel, A);
                    break;
                case 9:
                    z = C0171a.m208c(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new PolygonOptions(i3, list, arrayList, f2, i2, i, f, z2, z);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public PolygonOptions[] newArray(int size) {
        return new PolygonOptions[size];
    }
}
