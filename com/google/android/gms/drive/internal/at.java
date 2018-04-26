package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.drive.query.Query;

public class at implements Creator<QueryRequest> {
    static void m333a(QueryRequest queryRequest, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, queryRequest.xM);
        C0172b.m243a(parcel, 2, queryRequest.JE, i, false);
        C0172b.m235G(parcel, C);
    }

    public QueryRequest au(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        Query query = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    query = (Query) C0171a.m201a(parcel, A, Query.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new QueryRequest(i, query);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public QueryRequest[] bq(int i) {
        return new QueryRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return au(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bq(x0);
    }
}
