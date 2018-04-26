package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0233h implements Creator<ValuesAddedDetails> {
    static void m399a(ValuesAddedDetails valuesAddedDetails, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, valuesAddedDetails.xM);
        C0172b.m259c(parcel, 2, valuesAddedDetails.mIndex);
        C0172b.m259c(parcel, 3, valuesAddedDetails.LF);
        C0172b.m259c(parcel, 4, valuesAddedDetails.LG);
        C0172b.m247a(parcel, 5, valuesAddedDetails.LN, false);
        C0172b.m259c(parcel, 6, valuesAddedDetails.LO);
        C0172b.m235G(parcel, C);
    }

    public ValuesAddedDetails[] bX(int i) {
        return new ValuesAddedDetails[i];
    }

    public ValuesAddedDetails ba(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i5 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    i4 = C0171a.m212g(parcel, A);
                    break;
                case 3:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 4:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 5:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 6:
                    i = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ValuesAddedDetails(i5, i4, i3, i2, str, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ba(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bX(x0);
    }
}
