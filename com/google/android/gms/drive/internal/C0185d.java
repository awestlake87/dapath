package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import java.util.List;

public class C0185d implements Creator<CheckResourceIdsExistRequest> {
    static void m340a(CheckResourceIdsExistRequest checkResourceIdsExistRequest, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, checkResourceIdsExistRequest.getVersionCode());
        C0172b.m248a(parcel, 2, checkResourceIdsExistRequest.go(), false);
        C0172b.m235G(parcel, C);
    }

    public CheckResourceIdsExistRequest m341T(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    list = C0171a.m197B(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new CheckResourceIdsExistRequest(i, list);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public CheckResourceIdsExistRequest[] aO(int i) {
        return new CheckResourceIdsExistRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m341T(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aO(x0);
    }
}
