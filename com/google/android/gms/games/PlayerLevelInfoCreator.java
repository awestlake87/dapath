package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class PlayerLevelInfoCreator implements Creator<PlayerLevelInfo> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m476a(PlayerLevelInfo playerLevelInfo, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m239a(parcel, 1, playerLevelInfo.getCurrentXpTotal());
        C0172b.m259c(parcel, 1000, playerLevelInfo.getVersionCode());
        C0172b.m239a(parcel, 2, playerLevelInfo.getLastLevelUpTimestamp());
        C0172b.m243a(parcel, 3, playerLevelInfo.getCurrentLevel(), i, false);
        C0172b.m243a(parcel, 4, playerLevelInfo.getNextLevel(), i, false);
        C0172b.m235G(parcel, C);
    }

    public PlayerLevelInfo createFromParcel(Parcel parcel) {
        long j = 0;
        PlayerLevel playerLevel = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        PlayerLevel playerLevel2 = null;
        long j2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    j2 = C0171a.m214i(parcel, A);
                    break;
                case 2:
                    j = C0171a.m214i(parcel, A);
                    break;
                case 3:
                    playerLevel2 = (PlayerLevel) C0171a.m201a(parcel, A, PlayerLevel.CREATOR);
                    break;
                case 4:
                    playerLevel = (PlayerLevel) C0171a.m201a(parcel, A, PlayerLevel.CREATOR);
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
            return new PlayerLevelInfo(i, j2, j, playerLevel2, playerLevel);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public PlayerLevelInfo[] newArray(int size) {
        return new PlayerLevelInfo[size];
    }
}
