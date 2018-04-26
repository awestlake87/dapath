package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.drive.DriveId;

public class au implements Creator<RemoveEventListenerRequest> {
    static void m334a(RemoveEventListenerRequest removeEventListenerRequest, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, removeEventListenerRequest.xM);
        C0172b.m243a(parcel, 2, removeEventListenerRequest.Hz, i, false);
        C0172b.m259c(parcel, 3, removeEventListenerRequest.Iq);
        C0172b.m235G(parcel, C);
    }

    public RemoveEventListenerRequest av(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            DriveId driveId2;
            int g;
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    int i3 = i;
                    driveId2 = driveId;
                    g = C0171a.m212g(parcel, A);
                    A = i3;
                    break;
                case 2:
                    g = i2;
                    DriveId driveId3 = (DriveId) C0171a.m201a(parcel, A, DriveId.CREATOR);
                    A = i;
                    driveId2 = driveId3;
                    break;
                case 3:
                    A = C0171a.m212g(parcel, A);
                    driveId2 = driveId;
                    g = i2;
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    A = i;
                    driveId2 = driveId;
                    g = i2;
                    break;
            }
            i2 = g;
            driveId = driveId2;
            i = A;
        }
        if (parcel.dataPosition() == B) {
            return new RemoveEventListenerRequest(i2, driveId, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public RemoveEventListenerRequest[] br(int i) {
        return new RemoveEventListenerRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return av(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return br(x0);
    }
}
