package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class C0192k implements Creator<CreateFolderRequest> {
    static void m354a(CreateFolderRequest createFolderRequest, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, createFolderRequest.xM);
        C0172b.m243a(parcel, 2, createFolderRequest.IG, i, false);
        C0172b.m243a(parcel, 3, createFolderRequest.IE, i, false);
        C0172b.m235G(parcel, C);
    }

    public CreateFolderRequest m355Z(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < B) {
            DriveId driveId2;
            int g;
            MetadataBundle metadataBundle2;
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    driveId2 = driveId;
                    g = C0171a.m212g(parcel, A);
                    metadataBundle2 = metadataBundle3;
                    break;
                case 2:
                    g = i;
                    DriveId driveId3 = (DriveId) C0171a.m201a(parcel, A, DriveId.CREATOR);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId3;
                    break;
                case 3:
                    metadataBundle2 = (MetadataBundle) C0171a.m201a(parcel, A, MetadataBundle.CREATOR);
                    driveId2 = driveId;
                    g = i;
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    g = i;
                    break;
            }
            i = g;
            driveId = driveId2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == B) {
            return new CreateFolderRequest(i, driveId, metadataBundle);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public CreateFolderRequest[] aV(int i) {
        return new CreateFolderRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m355Z(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aV(x0);
    }
}
