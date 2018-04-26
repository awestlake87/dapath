package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public class jv implements Creator<ju> {
    static void m1312a(ju juVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m247a(parcel, 1, juVar.getName(), false);
        C0172b.m259c(parcel, 1000, juVar.xM);
        C0172b.m243a(parcel, 2, juVar.jk(), i, false);
        C0172b.m247a(parcel, 3, juVar.getAddress(), false);
        C0172b.m258b(parcel, 4, juVar.jl(), false);
        C0172b.m247a(parcel, 5, juVar.getPhoneNumber(), false);
        C0172b.m247a(parcel, 6, juVar.jm(), false);
        C0172b.m235G(parcel, C);
    }

    public ju bz(Parcel parcel) {
        String str = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str2 = null;
        List list = null;
        String str3 = null;
        LatLng latLng = null;
        String str4 = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    str4 = C0171a.m220o(parcel, A);
                    break;
                case 2:
                    latLng = (LatLng) C0171a.m201a(parcel, A, LatLng.CREATOR);
                    break;
                case 3:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 4:
                    list = C0171a.m207c(parcel, A, js.CREATOR);
                    break;
                case 5:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 6:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 1000:
                    i = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ju(i, str4, latLng, str3, list, str2, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public ju[] cU(int i) {
        return new ju[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bz(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cU(x0);
    }
}
