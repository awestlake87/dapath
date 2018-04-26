package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0221a implements Creator<BeginCompoundOperationRequest> {
    static void m384a(BeginCompoundOperationRequest beginCompoundOperationRequest, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, beginCompoundOperationRequest.xM);
        C0172b.m250a(parcel, 2, beginCompoundOperationRequest.Lj);
        C0172b.m247a(parcel, 3, beginCompoundOperationRequest.mName, false);
        C0172b.m235G(parcel, C);
    }

    public BeginCompoundOperationRequest aP(Parcel parcel) {
        boolean z = false;
        int B = C0171a.m196B(parcel);
        String str = null;
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
                case 3:
                    str = C0171a.m220o(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new BeginCompoundOperationRequest(i, z, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public BeginCompoundOperationRequest[] bL(int i) {
        return new BeginCompoundOperationRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aP(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bL(x0);
    }
}
