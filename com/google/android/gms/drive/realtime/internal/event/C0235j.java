package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0235j implements Creator<ValuesSetDetails> {
    static void m401a(ValuesSetDetails valuesSetDetails, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, valuesSetDetails.xM);
        C0172b.m259c(parcel, 2, valuesSetDetails.mIndex);
        C0172b.m259c(parcel, 3, valuesSetDetails.LF);
        C0172b.m259c(parcel, 4, valuesSetDetails.LG);
        C0172b.m235G(parcel, C);
    }

    public ValuesSetDetails[] bZ(int i) {
        return new ValuesSetDetails[i];
    }

    public ValuesSetDetails bc(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i4 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 3:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 4:
                    i = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ValuesSetDetails(i4, i3, i2, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bc(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bZ(x0);
    }
}
