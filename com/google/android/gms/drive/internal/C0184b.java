package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.drive.DriveId;

public class C0184b implements Creator<AuthorizeAccessRequest> {
    static void m338a(AuthorizeAccessRequest authorizeAccessRequest, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, authorizeAccessRequest.xM);
        C0172b.m239a(parcel, 2, authorizeAccessRequest.Is);
        C0172b.m243a(parcel, 3, authorizeAccessRequest.Hz, i, false);
        C0172b.m235G(parcel, C);
    }

    public AuthorizeAccessRequest m339S(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        long j = 0;
        DriveId driveId = null;
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
                    driveId = (DriveId) C0171a.m201a(parcel, A, DriveId.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new AuthorizeAccessRequest(i, j, driveId);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public AuthorizeAccessRequest[] aN(int i) {
        return new AuthorizeAccessRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m339S(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aN(x0);
    }
}
