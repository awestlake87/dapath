package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.drive.StorageStats;

public class ap implements Creator<OnStorageStatsResponse> {
    static void m329a(OnStorageStatsResponse onStorageStatsResponse, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, onStorageStatsResponse.xM);
        C0172b.m243a(parcel, 2, onStorageStatsResponse.JD, i, false);
        C0172b.m235G(parcel, C);
    }

    public OnStorageStatsResponse aq(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        StorageStats storageStats = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    storageStats = (StorageStats) C0171a.m201a(parcel, A, StorageStats.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new OnStorageStatsResponse(i, storageStats);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public OnStorageStatsResponse[] bm(int i) {
        return new OnStorageStatsResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aq(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bm(x0);
    }
}
