package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class ParticipantResultCreator implements Creator<ParticipantResult> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m742a(ParticipantResult participantResult, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m247a(parcel, 1, participantResult.getParticipantId(), false);
        C0172b.m259c(parcel, 1000, participantResult.getVersionCode());
        C0172b.m259c(parcel, 2, participantResult.getResult());
        C0172b.m259c(parcel, 3, participantResult.getPlacing());
        C0172b.m235G(parcel, C);
    }

    public ParticipantResult createFromParcel(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 2:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 3:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 1000:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ParticipantResult(i3, str, i2, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public ParticipantResult[] newArray(int size) {
        return new ParticipantResult[size];
    }
}
