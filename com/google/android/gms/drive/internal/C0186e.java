package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class C0186e implements Creator<CloseContentsAndUpdateMetadataRequest> {
    static void m342a(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, closeContentsAndUpdateMetadataRequest.xM);
        C0172b.m243a(parcel, 2, closeContentsAndUpdateMetadataRequest.Iu, i, false);
        C0172b.m243a(parcel, 3, closeContentsAndUpdateMetadataRequest.Iv, i, false);
        C0172b.m243a(parcel, 4, closeContentsAndUpdateMetadataRequest.Iw, i, false);
        C0172b.m250a(parcel, 5, closeContentsAndUpdateMetadataRequest.Ix);
        C0172b.m247a(parcel, 6, closeContentsAndUpdateMetadataRequest.Iy, false);
        C0172b.m235G(parcel, C);
    }

    public CloseContentsAndUpdateMetadataRequest m343U(Parcel parcel) {
        boolean z = false;
        String str = null;
        int B = C0171a.m196B(parcel);
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
                    z = C0171a.m208c(parcel, A);
                    break;
                case 6:
                    str = C0171a.m220o(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new CloseContentsAndUpdateMetadataRequest(i, driveId, metadataBundle, contents, z, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public CloseContentsAndUpdateMetadataRequest[] aP(int i) {
        return new CloseContentsAndUpdateMetadataRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m343U(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aP(x0);
    }
}
