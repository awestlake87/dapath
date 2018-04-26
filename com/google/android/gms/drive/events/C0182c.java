package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.ArrayList;

public class C0182c implements Creator<FileConflictEvent> {
    static void m273a(FileConflictEvent fileConflictEvent, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, fileConflictEvent.xM);
        C0172b.m243a(parcel, 2, fileConflictEvent.Hz, i, false);
        C0172b.m247a(parcel, 3, fileConflictEvent.yQ, false);
        C0172b.m243a(parcel, 4, fileConflictEvent.Ij, i, false);
        C0172b.m243a(parcel, 5, fileConflictEvent.Ik, i, false);
        C0172b.m243a(parcel, 6, fileConflictEvent.Il, i, false);
        C0172b.m248a(parcel, 7, fileConflictEvent.Im, false);
        C0172b.m235G(parcel, C);
    }

    public FileConflictEvent m274Q(Parcel parcel) {
        ArrayList arrayList = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        ParcelFileDescriptor parcelFileDescriptor2 = null;
        String str = null;
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
                case 3:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 4:
                    parcelFileDescriptor2 = (ParcelFileDescriptor) C0171a.m201a(parcel, A, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    parcelFileDescriptor = (ParcelFileDescriptor) C0171a.m201a(parcel, A, ParcelFileDescriptor.CREATOR);
                    break;
                case 6:
                    metadataBundle = (MetadataBundle) C0171a.m201a(parcel, A, MetadataBundle.CREATOR);
                    break;
                case 7:
                    arrayList = C0171a.m197B(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new FileConflictEvent(i, driveId, str, parcelFileDescriptor2, parcelFileDescriptor, metadataBundle, arrayList);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public FileConflictEvent[] aL(int i) {
        return new FileConflictEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m274Q(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aL(x0);
    }
}
