package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import java.util.ArrayList;
import java.util.List;

public class C0217h implements Creator<LogicalFilter> {
    static void m380a(LogicalFilter logicalFilter, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1000, logicalFilter.xM);
        C0172b.m243a(parcel, 1, logicalFilter.KL, i, false);
        C0172b.m258b(parcel, 2, logicalFilter.KY, false);
        C0172b.m235G(parcel, C);
    }

    public LogicalFilter aL(Parcel parcel) {
        List list = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        Operator operator = null;
        while (parcel.dataPosition() < B) {
            int i2;
            Operator operator2;
            ArrayList c;
            int A = C0171a.m194A(parcel);
            List list2;
            switch (C0171a.ar(A)) {
                case 1:
                    i2 = i;
                    Operator operator3 = (Operator) C0171a.m201a(parcel, A, Operator.CREATOR);
                    list2 = list;
                    operator2 = operator3;
                    break;
                case 2:
                    c = C0171a.m207c(parcel, A, FilterHolder.CREATOR);
                    operator2 = operator;
                    i2 = i;
                    break;
                case 1000:
                    List list3 = list;
                    operator2 = operator;
                    i2 = C0171a.m212g(parcel, A);
                    list2 = list3;
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    c = list;
                    operator2 = operator;
                    i2 = i;
                    break;
            }
            i = i2;
            operator = operator2;
            Object obj = c;
        }
        if (parcel.dataPosition() == B) {
            return new LogicalFilter(i, operator, list);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public LogicalFilter[] bH(int i) {
        return new LogicalFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aL(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bH(x0);
    }
}
