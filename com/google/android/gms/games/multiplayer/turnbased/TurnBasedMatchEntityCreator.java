package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.TimeUtils;
import com.dapath.pathgen.PathGenerator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class TurnBasedMatchEntityCreator implements Creator<TurnBasedMatchEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m745a(TurnBasedMatchEntity turnBasedMatchEntity, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m243a(parcel, 1, turnBasedMatchEntity.getGame(), i, false);
        C0172b.m247a(parcel, 2, turnBasedMatchEntity.getMatchId(), false);
        C0172b.m247a(parcel, 3, turnBasedMatchEntity.getCreatorId(), false);
        C0172b.m239a(parcel, 4, turnBasedMatchEntity.getCreationTimestamp());
        C0172b.m247a(parcel, 5, turnBasedMatchEntity.getLastUpdaterId(), false);
        C0172b.m239a(parcel, 6, turnBasedMatchEntity.getLastUpdatedTimestamp());
        C0172b.m247a(parcel, 7, turnBasedMatchEntity.getPendingParticipantId(), false);
        C0172b.m259c(parcel, 8, turnBasedMatchEntity.getStatus());
        C0172b.m259c(parcel, 10, turnBasedMatchEntity.getVariant());
        C0172b.m259c(parcel, 11, turnBasedMatchEntity.getVersion());
        C0172b.m251a(parcel, 12, turnBasedMatchEntity.getData(), false);
        C0172b.m258b(parcel, 13, turnBasedMatchEntity.getParticipants(), false);
        C0172b.m247a(parcel, 14, turnBasedMatchEntity.getRematchId(), false);
        C0172b.m251a(parcel, 15, turnBasedMatchEntity.getPreviousMatchData(), false);
        C0172b.m240a(parcel, 17, turnBasedMatchEntity.getAutoMatchCriteria(), false);
        C0172b.m259c(parcel, 16, turnBasedMatchEntity.getMatchNumber());
        C0172b.m259c(parcel, 1000, turnBasedMatchEntity.getVersionCode());
        C0172b.m250a(parcel, 19, turnBasedMatchEntity.isLocallyModified());
        C0172b.m259c(parcel, 18, turnBasedMatchEntity.getTurnStatus());
        C0172b.m247a(parcel, 21, turnBasedMatchEntity.getDescriptionParticipantId(), false);
        C0172b.m247a(parcel, 20, turnBasedMatchEntity.getDescription(), false);
        C0172b.m235G(parcel, C);
    }

    public TurnBasedMatchEntity createFromParcel(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        String str2 = null;
        long j = 0;
        String str3 = null;
        long j2 = 0;
        String str4 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        byte[] bArr = null;
        ArrayList arrayList = null;
        String str5 = null;
        byte[] bArr2 = null;
        int i5 = 0;
        Bundle bundle = null;
        int i6 = 0;
        boolean z = false;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    gameEntity = (GameEntity) C0171a.m201a(parcel, A, GameEntity.CREATOR);
                    break;
                case 2:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 4:
                    j = C0171a.m214i(parcel, A);
                    break;
                case 5:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 6:
                    j2 = C0171a.m214i(parcel, A);
                    break;
                case 7:
                    str4 = C0171a.m220o(parcel, A);
                    break;
                case 8:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 10:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 11:
                    i4 = C0171a.m212g(parcel, A);
                    break;
                case 12:
                    bArr = C0171a.m223r(parcel, A);
                    break;
                case 13:
                    arrayList = C0171a.m207c(parcel, A, ParticipantEntity.CREATOR);
                    break;
                case 14:
                    str5 = C0171a.m220o(parcel, A);
                    break;
                case 15:
                    bArr2 = C0171a.m223r(parcel, A);
                    break;
                case 16:
                    i5 = C0171a.m212g(parcel, A);
                    break;
                case 17:
                    bundle = C0171a.m222q(parcel, A);
                    break;
                case 18:
                    i6 = C0171a.m212g(parcel, A);
                    break;
                case TimeUtils.HUNDRED_DAY_FIELD_LEN /*19*/:
                    z = C0171a.m208c(parcel, A);
                    break;
                case PathGenerator.SUBDIVISIONS /*20*/:
                    str6 = C0171a.m220o(parcel, A);
                    break;
                case 21:
                    str7 = C0171a.m220o(parcel, A);
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
            return new TurnBasedMatchEntity(i, gameEntity, str, str2, j, str3, j2, str4, i2, i3, i4, bArr, arrayList, str5, bArr2, i5, bundle, i6, z, str6, str7);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public TurnBasedMatchEntity[] newArray(int size) {
        return new TurnBasedMatchEntity[size];
    }
}
