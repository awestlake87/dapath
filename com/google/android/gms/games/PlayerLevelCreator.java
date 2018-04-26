package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class PlayerLevelCreator implements Creator<PlayerLevel> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m475a(PlayerLevel playerLevel, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, playerLevel.getLevelNumber());
        C0172b.m259c(parcel, 1000, playerLevel.getVersionCode());
        C0172b.m239a(parcel, 2, playerLevel.getMinXp());
        C0172b.m239a(parcel, 3, playerLevel.getMaxXp());
        C0172b.m235G(parcel, C);
    }

    public PlayerLevel createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        int B = C0171a.m196B(parcel);
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    j2 = C0171a.m214i(parcel, A);
                    break;
                case 3:
                    j = C0171a.m214i(parcel, A);
                    break;
                case 1000:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new PlayerLevel(i2, i, j2, j);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public PlayerLevel[] newArray(int size) {
        return new PlayerLevel[size];
    }
}
