package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class C0191j implements Creator<CreateFileRequest> {
    static void m352a(CreateFileRequest createFileRequest, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, createFileRequest.xM);
        C0172b.m243a(parcel, 2, createFileRequest.IG, i, false);
        C0172b.m243a(parcel, 3, createFileRequest.IE, i, false);
        C0172b.m243a(parcel, 4, createFileRequest.Iw, i, false);
        C0172b.m245a(parcel, 5, createFileRequest.IF, false);
        C0172b.m250a(parcel, 6, createFileRequest.IH);
        C0172b.m247a(parcel, 7, createFileRequest.Iy, false);
        C0172b.m235G(parcel, C);
    }

    public CreateFileRequest m353Y(Parcel parcel) {
        boolean z = false;
        String str = null;
        int B = C0171a.m196B(parcel);
        Integer num = null;
        Contents contents = null;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    driveId = (DriveId) C0171a.m201a(parcel, A, DriveId.CREATOR);
                    break;
                case 3:
                    metadataBundle = (MetadataBundle) C0171a.m201a(parcel, A, MetadataBundle.CREATOR);
                    break;
                case 4:
                    contents = (Contents) C0171a.m201a(parcel, A, Contents.CREATOR);
                    break;
                case 5:
                    num = C0171a.m213h(parcel, A);
                    break;
                case 6:
                    z = C0171a.m208c(parcel, A);
                    break;
                case 7:
                    str = C0171a.m220o(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new CreateFileRequest(i, driveId, metadataBundle, contents, num, z, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public CreateFileRequest[] aU(int i) {
        return new CreateFileRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m353Y(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aU(x0);
    }
}
