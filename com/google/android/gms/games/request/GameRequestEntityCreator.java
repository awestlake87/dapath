package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;

public class GameRequestEntityCreator implements Creator<GameRequestEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m748a(GameRequestEntity gameRequestEntity, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m243a(parcel, 1, gameRequestEntity.getGame(), i, false);
        C0172b.m259c(parcel, 1000, gameRequestEntity.getVersionCode());
        C0172b.m243a(parcel, 2, gameRequestEntity.getSender(), i, false);
        C0172b.m251a(parcel, 3, gameRequestEntity.getData(), false);
        C0172b.m247a(parcel, 4, gameRequestEntity.getRequestId(), false);
        C0172b.m258b(parcel, 5, gameRequestEntity.getRecipients(), false);
        C0172b.m259c(parcel, 7, gameRequestEntity.getType());
        C0172b.m239a(parcel, 9, gameRequestEntity.getCreationTimestamp());
        C0172b.m239a(parcel, 10, gameRequestEntity.getExpirationTimestamp());
        C0172b.m240a(parcel, 11, gameRequestEntity.iL(), false);
        C0172b.m259c(parcel, 12, gameRequestEntity.getStatus());
        C0172b.m235G(parcel, C);
    }

    public GameRequestEntity createFromParcel(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        byte[] bArr = null;
        String str = null;
        ArrayList arrayList = null;
        int i2 = 0;
        long j = 0;
        long j2 = 0;
        Bundle bundle = null;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    gameEntity = (GameEntity) C0171a.m201a(parcel, A, GameEntity.CREATOR);
                    break;
                case 2:
                    playerEntity = (PlayerEntity) C0171a.m201a(parcel, A, PlayerEntity.CREATOR);
                    break;
                case 3:
                    bArr = C0171a.m223r(parcel, A);
                    break;
                case 4:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 5:
                    arrayList = C0171a.m207c(parcel, A, PlayerEntity.CREATOR);
                    break;
                case 7:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 9:
                    j = C0171a.m214i(parcel, A);
                    break;
                case 10:
                    j2 = C0171a.m214i(parcel, A);
                    break;
                case 11:
                    bundle = C0171a.m222q(parcel, A);
                    break;
                case 12:
                    i3 = C0171a.m212g(parcel, A);
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
            return new GameRequestEntity(i, gameEntity, playerEntity, bArr, str, arrayList, i2, j, j2, bundle, i3);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public GameRequestEntity[] newArray(int size) {
        return new GameRequestEntity[size];
    }
}
