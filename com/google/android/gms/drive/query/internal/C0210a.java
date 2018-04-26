package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class C0210a implements Creator<ComparisonFilter> {
    static void m373a(ComparisonFilter comparisonFilter, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1000, comparisonFilter.xM);
        C0172b.m243a(parcel, 1, comparisonFilter.KL, i, false);
        C0172b.m243a(parcel, 2, comparisonFilter.KM, i, false);
        C0172b.m235G(parcel, C);
    }

    public ComparisonFilter aF(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        Operator operator = null;
        while (parcel.dataPosition() < B) {
            int i2;
            MetadataBundle metadataBundle2;
            Operator operator2;
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i2 = i;
                    Operator operator3 = (Operator) C0171a.m201a(parcel, A, Operator.CREATOR);
                    metadataBundle2 = metadataBundle;
                    operator2 = operator3;
                    break;
                case 2:
                    metadataBundle2 = (MetadataBundle) C0171a.m201a(parcel, A, MetadataBundle.CREATOR);
                    operator2 = operator;
                    i2 = i;
                    break;
                case 1000:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    operator2 = operator;
                    i2 = C0171a.m212g(parcel, A);
                    metadataBundle2 = metadataBundle3;
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    metadataBundle2 = metadataBundle;
                    operator2 = operator;
                    i2 = i;
                    break;
            }
            i = i2;
            operator = operator2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == B) {
            return new ComparisonFilter(i, operator, metadataBundle);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public ComparisonFilter[] bB(int i) {
        return new ComparisonFilter[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bB(x0);
    }
}
