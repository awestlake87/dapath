package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0178e implements Creator<StorageStats> {
    static void m266a(StorageStats storageStats, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, storageStats.xM);
        C0172b.m239a(parcel, 2, storageStats.Ib);
        C0172b.m239a(parcel, 3, storageStats.Ic);
        C0172b.m239a(parcel, 4, storageStats.Id);
        C0172b.m239a(parcel, 5, storageStats.Ie);
        C0172b.m259c(parcel, 6, storageStats.If);
        C0172b.m235G(parcel, C);
    }

    public StorageStats m267O(Parcel parcel) {
        int i = 0;
        long j = 0;
        int B = C0171a.m196B(parcel);
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    j4 = C0171a.m214i(parcel, A);
                    break;
                case 3:
                    j3 = C0171a.m214i(parcel, A);
                    break;
                case 4:
                    j2 = C0171a.m214i(parcel, A);
                    break;
                case 5:
                    j = C0171a.m214i(parcel, A);
                    break;
                case 6:
                    i = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new StorageStats(i2, j4, j3, j2, j, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public StorageStats[] aI(int i) {
        return new StorageStats[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m267O(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aI(x0);
    }
}
