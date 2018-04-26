package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.drive.DriveId;

public class ad implements Creator<ListParentsRequest> {
    static void m318a(ListParentsRequest listParentsRequest, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, listParentsRequest.xM);
        C0172b.m243a(parcel, 2, listParentsRequest.Jr, i, false);
        C0172b.m235G(parcel, C);
    }

    public ListParentsRequest af(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    driveId = (DriveId) C0171a.m201a(parcel, A, DriveId.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ListParentsRequest(i, driveId);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public ListParentsRequest[] bb(int i) {
        return new ListParentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return af(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bb(x0);
    }
}
