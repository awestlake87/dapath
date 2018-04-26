package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class aq implements Creator<OnSyncMoreResponse> {
    static void m330a(OnSyncMoreResponse onSyncMoreResponse, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, onSyncMoreResponse.xM);
        C0172b.m250a(parcel, 2, onSyncMoreResponse.IP);
        C0172b.m235G(parcel, C);
    }

    public OnSyncMoreResponse ar(Parcel parcel) {
        boolean z = false;
        int B = C0171a.m196B(parcel);
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    z = C0171a.m208c(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new OnSyncMoreResponse(i, z);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public OnSyncMoreResponse[] bn(int i) {
        return new OnSyncMoreResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ar(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bn(x0);
    }
}
