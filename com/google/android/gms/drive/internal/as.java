package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.drive.DriveId;

public class as implements Creator<OpenFileIntentSenderRequest> {
    static void m332a(OpenFileIntentSenderRequest openFileIntentSenderRequest, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, openFileIntentSenderRequest.xM);
        C0172b.m247a(parcel, 2, openFileIntentSenderRequest.HY, false);
        C0172b.m254a(parcel, 3, openFileIntentSenderRequest.HZ, false);
        C0172b.m243a(parcel, 4, openFileIntentSenderRequest.Ia, i, false);
        C0172b.m235G(parcel, C);
    }

    public OpenFileIntentSenderRequest at(Parcel parcel) {
        DriveId driveId = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        String[] strArr = null;
        String str = null;
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
                    strArr = C0171a.m195A(parcel, A);
                    break;
                case 4:
                    driveId = (DriveId) C0171a.m201a(parcel, A, DriveId.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new OpenFileIntentSenderRequest(i, str, strArr, driveId);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public OpenFileIntentSenderRequest[] bp(int i) {
        return new OpenFileIntentSenderRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return at(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bp(x0);
    }
}
