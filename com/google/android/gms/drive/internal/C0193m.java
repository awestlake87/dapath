package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class C0193m implements Creator<DeleteCustomPropertyRequest> {
    static void m356a(DeleteCustomPropertyRequest deleteCustomPropertyRequest, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, deleteCustomPropertyRequest.xM);
        C0172b.m243a(parcel, 2, deleteCustomPropertyRequest.Hz, i, false);
        C0172b.m243a(parcel, 3, deleteCustomPropertyRequest.IJ, i, false);
        C0172b.m235G(parcel, C);
    }

    public DeleteCustomPropertyRequest[] aW(int i) {
        return new DeleteCustomPropertyRequest[i];
    }

    public DeleteCustomPropertyRequest aa(Parcel parcel) {
        CustomPropertyKey customPropertyKey = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < B) {
            DriveId driveId2;
            int g;
            CustomPropertyKey customPropertyKey2;
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    CustomPropertyKey customPropertyKey3 = customPropertyKey;
                    driveId2 = driveId;
                    g = C0171a.m212g(parcel, A);
                    customPropertyKey2 = customPropertyKey3;
                    break;
                case 2:
                    g = i;
                    DriveId driveId3 = (DriveId) C0171a.m201a(parcel, A, DriveId.CREATOR);
                    customPropertyKey2 = customPropertyKey;
                    driveId2 = driveId3;
                    break;
                case 3:
                    customPropertyKey2 = (CustomPropertyKey) C0171a.m201a(parcel, A, CustomPropertyKey.CREATOR);
                    driveId2 = driveId;
                    g = i;
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    customPropertyKey2 = customPropertyKey;
                    driveId2 = driveId;
                    g = i;
                    break;
            }
            i = g;
            driveId = driveId2;
            customPropertyKey = customPropertyKey2;
        }
        if (parcel.dataPosition() == B) {
            return new DeleteCustomPropertyRequest(i, driveId, customPropertyKey);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aa(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aW(x0);
    }
}
