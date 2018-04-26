package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class C0190i implements Creator<CreateFileIntentSenderRequest> {
    static void m350a(CreateFileIntentSenderRequest createFileIntentSenderRequest, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, createFileIntentSenderRequest.xM);
        C0172b.m243a(parcel, 2, createFileIntentSenderRequest.IE, i, false);
        C0172b.m259c(parcel, 3, createFileIntentSenderRequest.ra);
        C0172b.m247a(parcel, 4, createFileIntentSenderRequest.HY, false);
        C0172b.m243a(parcel, 5, createFileIntentSenderRequest.Ia, i, false);
        C0172b.m245a(parcel, 6, createFileIntentSenderRequest.IF, false);
        C0172b.m235G(parcel, C);
    }

    public CreateFileIntentSenderRequest m351X(Parcel parcel) {
        int i = 0;
        Integer num = null;
        int B = C0171a.m196B(parcel);
        DriveId driveId = null;
        String str = null;
        MetadataBundle metadataBundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) C0171a.m201a(parcel, A, MetadataBundle.CREATOR);
                    break;
                case 3:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 4:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 5:
                    driveId = (DriveId) C0171a.m201a(parcel, A, DriveId.CREATOR);
                    break;
                case 6:
                    num = C0171a.m213h(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new CreateFileIntentSenderRequest(i2, metadataBundle, i, str, driveId, num);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public CreateFileIntentSenderRequest[] aT(int i) {
        return new CreateFileIntentSenderRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m351X(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aT(x0);
    }
}
