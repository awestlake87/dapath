package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0176c implements Creator<DriveId> {
    static void m264a(DriveId driveId, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, driveId.xM);
        C0172b.m247a(parcel, 2, driveId.HN, false);
        C0172b.m239a(parcel, 3, driveId.HO);
        C0172b.m239a(parcel, 4, driveId.HP);
        C0172b.m235G(parcel, C);
    }

    public DriveId m265N(Parcel parcel) {
        long j = 0;
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str = null;
        long j2 = 0;
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
                    j2 = C0171a.m214i(parcel, A);
                    break;
                case 4:
                    j = C0171a.m214i(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new DriveId(i, str, j2, j);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public DriveId[] aH(int i) {
        return new DriveId[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m265N(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aH(x0);
    }
}
