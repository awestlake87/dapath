package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class ak implements Creator<OnListEntriesResponse> {
    static void m324a(OnListEntriesResponse onListEntriesResponse, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, onListEntriesResponse.xM);
        C0172b.m243a(parcel, 2, onListEntriesResponse.JA, i, false);
        C0172b.m250a(parcel, 3, onListEntriesResponse.IP);
        C0172b.m235G(parcel, C);
    }

    public OnListEntriesResponse al(Parcel parcel) {
        boolean z = false;
        int B = C0171a.m196B(parcel);
        DataHolder dataHolder = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            DataHolder dataHolder2;
            int g;
            boolean z2;
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    boolean z3 = z;
                    dataHolder2 = dataHolder;
                    g = C0171a.m212g(parcel, A);
                    z2 = z3;
                    break;
                case 2:
                    g = i;
                    DataHolder dataHolder3 = (DataHolder) C0171a.m201a(parcel, A, DataHolder.CREATOR);
                    z2 = z;
                    dataHolder2 = dataHolder3;
                    break;
                case 3:
                    z2 = C0171a.m208c(parcel, A);
                    dataHolder2 = dataHolder;
                    g = i;
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    z2 = z;
                    dataHolder2 = dataHolder;
                    g = i;
                    break;
            }
            i = g;
            dataHolder = dataHolder2;
            z = z2;
        }
        if (parcel.dataPosition() == B) {
            return new OnListEntriesResponse(i, dataHolder, z);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public OnListEntriesResponse[] bh(int i) {
        return new OnListEntriesResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return al(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bh(x0);
    }
}
