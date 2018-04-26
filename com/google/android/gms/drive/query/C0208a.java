package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.drive.query.internal.LogicalFilter;

public class C0208a implements Creator<Query> {
    static void m371a(Query query, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1000, query.xM);
        C0172b.m243a(parcel, 1, query.KE, i, false);
        C0172b.m247a(parcel, 3, query.KF, false);
        C0172b.m243a(parcel, 4, query.KG, i, false);
        C0172b.m235G(parcel, C);
    }

    public Query aD(Parcel parcel) {
        SortOrder sortOrder = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str = null;
        LogicalFilter logicalFilter = null;
        while (parcel.dataPosition() < B) {
            int i2;
            LogicalFilter logicalFilter2;
            SortOrder sortOrder2;
            String str2;
            int A = C0171a.m194A(parcel);
            SortOrder sortOrder3;
            switch (C0171a.ar(A)) {
                case 1:
                    i2 = i;
                    String str3 = str;
                    logicalFilter2 = (LogicalFilter) C0171a.m201a(parcel, A, LogicalFilter.CREATOR);
                    sortOrder2 = sortOrder;
                    str2 = str3;
                    break;
                case 3:
                    logicalFilter2 = logicalFilter;
                    i2 = i;
                    sortOrder3 = sortOrder;
                    str2 = C0171a.m220o(parcel, A);
                    sortOrder2 = sortOrder3;
                    break;
                case 4:
                    sortOrder2 = (SortOrder) C0171a.m201a(parcel, A, SortOrder.CREATOR);
                    str2 = str;
                    logicalFilter2 = logicalFilter;
                    i2 = i;
                    break;
                case 1000:
                    sortOrder3 = sortOrder;
                    str2 = str;
                    logicalFilter2 = logicalFilter;
                    i2 = C0171a.m212g(parcel, A);
                    sortOrder2 = sortOrder3;
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    sortOrder2 = sortOrder;
                    str2 = str;
                    logicalFilter2 = logicalFilter;
                    i2 = i;
                    break;
            }
            i = i2;
            logicalFilter = logicalFilter2;
            str = str2;
            sortOrder = sortOrder2;
        }
        if (parcel.dataPosition() == B) {
            return new Query(i, logicalFilter, str, sortOrder);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public Query[] bz(int i) {
        return new Query[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aD(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bz(x0);
    }
}
