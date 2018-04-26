package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0232g implements Creator<ValueChangedDetails> {
    static void m398a(ValueChangedDetails valueChangedDetails, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, valueChangedDetails.xM);
        C0172b.m259c(parcel, 2, valueChangedDetails.LM);
        C0172b.m235G(parcel, C);
    }

    public ValueChangedDetails aZ(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    i = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ValueChangedDetails(i2, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public ValueChangedDetails[] bW(int i) {
        return new ValueChangedDetails[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aZ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bW(x0);
    }
}
