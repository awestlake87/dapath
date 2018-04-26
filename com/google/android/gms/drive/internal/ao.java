package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import java.util.List;

public class ao implements Creator<OnResourceIdSetResponse> {
    static void m328a(OnResourceIdSetResponse onResourceIdSetResponse, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, onResourceIdSetResponse.getVersionCode());
        C0172b.m248a(parcel, 2, onResourceIdSetResponse.go(), false);
        C0172b.m235G(parcel, C);
    }

    public OnResourceIdSetResponse ap(Parcel parcel) {
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
            return new OnResourceIdSetResponse(i, list);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public OnResourceIdSetResponse[] bl(int i) {
        return new OnResourceIdSetResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ap(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bl(x0);
    }
}
