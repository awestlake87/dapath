package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0230e implements Creator<TextDeletedDetails> {
    static void m396a(TextDeletedDetails textDeletedDetails, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, textDeletedDetails.xM);
        C0172b.m259c(parcel, 2, textDeletedDetails.mIndex);
        C0172b.m259c(parcel, 3, textDeletedDetails.LL);
        C0172b.m235G(parcel, C);
    }

    public TextDeletedDetails aX(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 3:
                    i = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new TextDeletedDetails(i3, i2, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public TextDeletedDetails[] bU(int i) {
        return new TextDeletedDetails[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aX(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bU(x0);
    }
}
