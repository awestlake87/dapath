package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class LocationRequestCreator implements Creator<LocationRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1477a(LocationRequest locationRequest, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, locationRequest.mPriority);
        C0172b.m259c(parcel, 1000, locationRequest.getVersionCode());
        C0172b.m239a(parcel, 2, locationRequest.Vl);
        C0172b.m239a(parcel, 3, locationRequest.Vm);
        C0172b.m250a(parcel, 4, locationRequest.Vn);
        C0172b.m239a(parcel, 5, locationRequest.Vb);
        C0172b.m259c(parcel, 6, locationRequest.Vo);
        C0172b.m238a(parcel, 7, locationRequest.Vp);
        C0172b.m235G(parcel, C);
    }

    public LocationRequest createFromParcel(Parcel parcel) {
        boolean z = false;
        int B = C0171a.m196B(parcel);
        int i = 102;
        long j = 3600000;
        long j2 = 600000;
        long j3 = Long.MAX_VALUE;
        int i2 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        float f = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    j = C0171a.m214i(parcel, A);
                    break;
                case 3:
                    j2 = C0171a.m214i(parcel, A);
                    break;
                case 4:
                    z = C0171a.m208c(parcel, A);
                    break;
                case 5:
                    j3 = C0171a.m214i(parcel, A);
                    break;
                case 6:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 7:
                    f = C0171a.m217l(parcel, A);
                    break;
                case 1000:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new LocationRequest(i3, i, j, j2, z, j3, i2, f);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public LocationRequest[] newArray(int size) {
        return new LocationRequest[size];
    }
}
