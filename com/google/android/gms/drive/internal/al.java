package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class al implements Creator<OnListParentsResponse> {
    static void m325a(OnListParentsResponse onListParentsResponse, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, onListParentsResponse.xM);
        C0172b.m243a(parcel, 2, onListParentsResponse.JB, i, false);
        C0172b.m235G(parcel, C);
    }

    public OnListParentsResponse am(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    dataHolder = (DataHolder) C0171a.m201a(parcel, A, DataHolder.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new OnListParentsResponse(i, dataHolder);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public OnListParentsResponse[] bi(int i) {
        return new OnListParentsResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return am(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bi(x0);
    }
}
