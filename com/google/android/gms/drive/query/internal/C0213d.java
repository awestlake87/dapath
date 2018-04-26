package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0213d implements Creator<FilterHolder> {
    static void m376a(FilterHolder filterHolder, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m243a(parcel, 1, filterHolder.KP, i, false);
        C0172b.m259c(parcel, 1000, filterHolder.xM);
        C0172b.m243a(parcel, 2, filterHolder.KQ, i, false);
        C0172b.m243a(parcel, 3, filterHolder.KR, i, false);
        C0172b.m243a(parcel, 4, filterHolder.KS, i, false);
        C0172b.m243a(parcel, 5, filterHolder.KT, i, false);
        C0172b.m243a(parcel, 6, filterHolder.KU, i, false);
        C0172b.m243a(parcel, 7, filterHolder.KV, i, false);
        C0172b.m235G(parcel, C);
    }

    public FilterHolder aI(Parcel parcel) {
        HasFilter hasFilter = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        MatchAllFilter matchAllFilter = null;
        InFilter inFilter = null;
        NotFilter notFilter = null;
        LogicalFilter logicalFilter = null;
        FieldOnlyFilter fieldOnlyFilter = null;
        ComparisonFilter comparisonFilter = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    comparisonFilter = (ComparisonFilter) C0171a.m201a(parcel, A, ComparisonFilter.CREATOR);
                    break;
                case 2:
                    fieldOnlyFilter = (FieldOnlyFilter) C0171a.m201a(parcel, A, FieldOnlyFilter.CREATOR);
                    break;
                case 3:
                    logicalFilter = (LogicalFilter) C0171a.m201a(parcel, A, LogicalFilter.CREATOR);
                    break;
                case 4:
                    notFilter = (NotFilter) C0171a.m201a(parcel, A, NotFilter.CREATOR);
                    break;
                case 5:
                    inFilter = (InFilter) C0171a.m201a(parcel, A, InFilter.CREATOR);
                    break;
                case 6:
                    matchAllFilter = (MatchAllFilter) C0171a.m201a(parcel, A, MatchAllFilter.CREATOR);
                    break;
                case 7:
                    hasFilter = (HasFilter) C0171a.m201a(parcel, A, HasFilter.CREATOR);
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
            return new FilterHolder(i, comparisonFilter, fieldOnlyFilter, logicalFilter, notFilter, inFilter, matchAllFilter, hasFilter);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public FilterHolder[] bE(int i) {
        return new FilterHolder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aI(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bE(x0);
    }
}
