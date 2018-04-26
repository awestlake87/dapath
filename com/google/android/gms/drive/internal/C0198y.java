package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0198y implements Creator<GetDriveIdFromUniqueIdentifierRequest> {
    static void m360a(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, getDriveIdFromUniqueIdentifierRequest.xM);
        C0172b.m247a(parcel, 2, getDriveIdFromUniqueIdentifierRequest.Jp, false);
        C0172b.m250a(parcel, 3, getDriveIdFromUniqueIdentifierRequest.Jq);
        C0172b.m235G(parcel, C);
    }

    public GetDriveIdFromUniqueIdentifierRequest[] aZ(int i) {
        return new GetDriveIdFromUniqueIdentifierRequest[i];
    }

    public GetDriveIdFromUniqueIdentifierRequest ad(Parcel parcel) {
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
                    str = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    z = C0171a.m208c(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new GetDriveIdFromUniqueIdentifierRequest(i, str, z);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ad(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aZ(x0);
    }
}
