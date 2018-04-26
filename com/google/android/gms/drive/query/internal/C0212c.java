package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0212c implements Creator<FieldWithSortOrder> {
    static void m375a(FieldWithSortOrder fieldWithSortOrder, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1000, fieldWithSortOrder.xM);
        C0172b.m247a(parcel, 1, fieldWithSortOrder.JH, false);
        C0172b.m250a(parcel, 2, fieldWithSortOrder.KO);
        C0172b.m235G(parcel, C);
    }

    public FieldWithSortOrder aH(Parcel parcel) {
        boolean z = false;
        int B = C0171a.m196B(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 2:
                    z = C0171a.m208c(parcel, A);
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
            return new FieldWithSortOrder(i, str, z);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public FieldWithSortOrder[] bD(int i) {
        return new FieldWithSortOrder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aH(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bD(x0);
    }
}
