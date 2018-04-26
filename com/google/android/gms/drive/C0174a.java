package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0174a implements Creator<Contents> {
    static void m262a(Contents contents, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, contents.xM);
        C0172b.m243a(parcel, 2, contents.Fj, i, false);
        C0172b.m259c(parcel, 3, contents.ra);
        C0172b.m259c(parcel, 4, contents.Hy);
        C0172b.m243a(parcel, 5, contents.Hz, i, false);
        C0172b.m247a(parcel, 6, contents.HA, false);
        C0172b.m250a(parcel, 7, contents.HB);
        C0172b.m235G(parcel, C);
    }

    public Contents m263M(Parcel parcel) {
        String str = null;
        boolean z = false;
        int B = C0171a.m196B(parcel);
        DriveId driveId = null;
        int i = 0;
        int i2 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) C0171a.m201a(parcel, A, ParcelFileDescriptor.CREATOR);
                    break;
                case 3:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 4:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 5:
                    driveId = (DriveId) C0171a.m201a(parcel, A, DriveId.CREATOR);
                    break;
                case 6:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 7:
                    z = C0171a.m208c(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new Contents(i3, parcelFileDescriptor, i2, i, driveId, str, z);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public Contents[] aG(int i) {
        return new Contents[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m263M(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aG(x0);
    }
}
