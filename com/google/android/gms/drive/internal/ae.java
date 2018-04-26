package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.drive.DriveId;

public class ae implements Creator<LoadRealtimeRequest> {
    static void m319a(LoadRealtimeRequest loadRealtimeRequest, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, loadRealtimeRequest.xM);
        C0172b.m243a(parcel, 2, loadRealtimeRequest.Hz, i, false);
        C0172b.m250a(parcel, 3, loadRealtimeRequest.Js);
        C0172b.m235G(parcel, C);
    }

    public LoadRealtimeRequest ag(Parcel parcel) {
        boolean z = false;
        int B = C0171a.m196B(parcel);
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            DriveId driveId2;
            int g;
            boolean z2;
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    boolean z3 = z;
                    driveId2 = driveId;
                    g = C0171a.m212g(parcel, A);
                    z2 = z3;
                    break;
                case 2:
                    g = i;
                    DriveId driveId3 = (DriveId) C0171a.m201a(parcel, A, DriveId.CREATOR);
                    z2 = z;
                    driveId2 = driveId3;
                    break;
                case 3:
                    z2 = C0171a.m208c(parcel, A);
                    driveId2 = driveId;
                    g = i;
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    z2 = z;
                    driveId2 = driveId;
                    g = i;
                    break;
            }
            i = g;
            driveId = driveId2;
            z = z2;
        }
        if (parcel.dataPosition() == B) {
            return new LoadRealtimeRequest(i, driveId, z);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public LoadRealtimeRequest[] bc(int i) {
        return new LoadRealtimeRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ag(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bc(x0);
    }
}
