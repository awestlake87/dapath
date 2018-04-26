package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.dapath.pathgen.PathGenerator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class GameEntityCreator implements Creator<GameEntity> {
    static void m471a(GameEntity gameEntity, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m247a(parcel, 1, gameEntity.getApplicationId(), false);
        C0172b.m247a(parcel, 2, gameEntity.getDisplayName(), false);
        C0172b.m247a(parcel, 3, gameEntity.getPrimaryCategory(), false);
        C0172b.m247a(parcel, 4, gameEntity.getSecondaryCategory(), false);
        C0172b.m247a(parcel, 5, gameEntity.getDescription(), false);
        C0172b.m247a(parcel, 6, gameEntity.getDeveloperName(), false);
        C0172b.m243a(parcel, 7, gameEntity.getIconImageUri(), i, false);
        C0172b.m243a(parcel, 8, gameEntity.getHiResImageUri(), i, false);
        C0172b.m243a(parcel, 9, gameEntity.getFeaturedImageUri(), i, false);
        C0172b.m250a(parcel, 10, gameEntity.gM());
        C0172b.m250a(parcel, 11, gameEntity.gO());
        C0172b.m247a(parcel, 12, gameEntity.gP(), false);
        C0172b.m259c(parcel, 13, gameEntity.gQ());
        C0172b.m259c(parcel, 14, gameEntity.getAchievementTotalCount());
        C0172b.m259c(parcel, 15, gameEntity.getLeaderboardCount());
        C0172b.m250a(parcel, 17, gameEntity.isTurnBasedMultiplayerEnabled());
        C0172b.m250a(parcel, 16, gameEntity.isRealTimeMultiplayerEnabled());
        C0172b.m259c(parcel, 1000, gameEntity.getVersionCode());
        C0172b.m247a(parcel, 19, gameEntity.getHiResImageUrl(), false);
        C0172b.m247a(parcel, 18, gameEntity.getIconImageUrl(), false);
        C0172b.m250a(parcel, 21, gameEntity.isMuted());
        C0172b.m247a(parcel, 20, gameEntity.getFeaturedImageUrl(), false);
        C0172b.m250a(parcel, 23, gameEntity.areSnapshotsEnabled());
        C0172b.m250a(parcel, 22, gameEntity.gN());
        C0172b.m235G(parcel, C);
    }

    public GameEntity bd(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        boolean z = false;
        boolean z2 = false;
        String str7 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
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
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 4:
                    str4 = C0171a.m220o(parcel, A);
                    break;
                case 5:
                    str5 = C0171a.m220o(parcel, A);
                    break;
                case 6:
                    str6 = C0171a.m220o(parcel, A);
                    break;
                case 7:
                    uri = (Uri) C0171a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case 8:
                    uri2 = (Uri) C0171a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case 9:
                    uri3 = (Uri) C0171a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case 10:
                    z = C0171a.m208c(parcel, A);
                    break;
                case 11:
                    z2 = C0171a.m208c(parcel, A);
                    break;
                case 12:
                    str7 = C0171a.m220o(parcel, A);
                    break;
                case 13:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 14:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 15:
                    i4 = C0171a.m212g(parcel, A);
                    break;
                case 16:
                    z3 = C0171a.m208c(parcel, A);
                    break;
                case 17:
                    z4 = C0171a.m208c(parcel, A);
                    break;
                case 18:
                    str8 = C0171a.m220o(parcel, A);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    str9 = C0171a.m220o(parcel, A);
                    break;
                case PathGenerator.SUBDIVISIONS /*20*/:
                    str10 = C0171a.m220o(parcel, A);
                    break;
                case 21:
                    z5 = C0171a.m208c(parcel, A);
                    break;
                case 22:
                    z6 = C0171a.m208c(parcel, A);
                    break;
                case 23:
                    z7 = C0171a.m208c(parcel, A);
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
            return new GameEntity(i, str, str2, str3, str4, str5, str6, uri, uri2, uri3, z, z2, str7, i2, i3, i4, z3, z4, str8, str9, str10, z5, z6, z7);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public GameEntity[] cb(int i) {
        return new GameEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bd(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cb(x0);
    }
}
