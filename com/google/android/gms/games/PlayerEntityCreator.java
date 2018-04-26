package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public class PlayerEntityCreator implements Creator<PlayerEntity> {
    static void m474a(PlayerEntity playerEntity, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m247a(parcel, 1, playerEntity.getPlayerId(), false);
        C0172b.m247a(parcel, 2, playerEntity.getDisplayName(), false);
        C0172b.m243a(parcel, 3, playerEntity.getIconImageUri(), i, false);
        C0172b.m243a(parcel, 4, playerEntity.getHiResImageUri(), i, false);
        C0172b.m239a(parcel, 5, playerEntity.getRetrievedTimestamp());
        C0172b.m259c(parcel, 6, playerEntity.gS());
        C0172b.m239a(parcel, 7, playerEntity.getLastPlayedWithTimestamp());
        C0172b.m247a(parcel, 8, playerEntity.getIconImageUrl(), false);
        C0172b.m247a(parcel, 9, playerEntity.getHiResImageUrl(), false);
        C0172b.m247a(parcel, 14, playerEntity.getTitle(), false);
        C0172b.m243a(parcel, 15, playerEntity.gU(), i, false);
        C0172b.m250a(parcel, 17, playerEntity.gT());
        C0172b.m243a(parcel, 16, playerEntity.getLevelInfo(), i, false);
        C0172b.m259c(parcel, 1000, playerEntity.getVersionCode());
        C0172b.m235G(parcel, C);
    }

    public PlayerEntity be(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        MostRecentGameInfoEntity mostRecentGameInfoEntity = null;
        PlayerLevelInfo playerLevelInfo = null;
        boolean z = false;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 2:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    uri = (Uri) C0171a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case 4:
                    uri2 = (Uri) C0171a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case 5:
                    j = C0171a.m214i(parcel, A);
                    break;
                case 6:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 7:
                    j2 = C0171a.m214i(parcel, A);
                    break;
                case 8:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 9:
                    str4 = C0171a.m220o(parcel, A);
                    break;
                case 14:
                    str5 = C0171a.m220o(parcel, A);
                    break;
                case 15:
                    mostRecentGameInfoEntity = (MostRecentGameInfoEntity) C0171a.m201a(parcel, A, (Creator) MostRecentGameInfoEntity.CREATOR);
                    break;
                case 16:
                    playerLevelInfo = (PlayerLevelInfo) C0171a.m201a(parcel, A, (Creator) PlayerLevelInfo.CREATOR);
                    break;
                case 17:
                    z = C0171a.m208c(parcel, A);
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
            return new PlayerEntity(i, str, str2, uri, uri2, j, i2, j2, str3, str4, str5, mostRecentGameInfoEntity, playerLevelInfo, z);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public PlayerEntity[] cc(int i) {
        return new PlayerEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return be(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cc(x0);
    }
}
