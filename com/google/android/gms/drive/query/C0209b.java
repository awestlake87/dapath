package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.List;

public class C0209b implements Creator<SortOrder> {
    static void m372a(SortOrder sortOrder, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1000, sortOrder.xM);
        C0172b.m258b(parcel, 1, sortOrder.KK, false);
        C0172b.m235G(parcel, C);
    }

    public SortOrder aE(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    list = C0171a.m207c(parcel, A, FieldWithSortOrder.CREATOR);
                    break;
                case 1000:
                    i = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new SortOrder(i, list);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public SortOrder[] bA(int i) {
        return new SortOrder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aE(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bA(x0);
    }
}
