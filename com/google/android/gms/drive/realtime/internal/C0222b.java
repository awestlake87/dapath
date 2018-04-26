package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0222b implements Creator<EndCompoundOperationRequest> {
    static void m385a(EndCompoundOperationRequest endCompoundOperationRequest, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, endCompoundOperationRequest.xM);
        C0172b.m235G(parcel, C);
    }

    public EndCompoundOperationRequest aQ(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new EndCompoundOperationRequest(i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public EndCompoundOperationRequest[] bM(int i) {
        return new EndCompoundOperationRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aQ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bM(x0);
    }
}
