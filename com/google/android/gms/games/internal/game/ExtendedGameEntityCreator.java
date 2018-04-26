package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import java.util.ArrayList;

public class ExtendedGameEntityCreator implements Creator<ExtendedGameEntity> {
    static void m732a(ExtendedGameEntity extendedGameEntity, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m243a(parcel, 1, extendedGameEntity.ia(), i, false);
        C0172b.m259c(parcel, 1000, extendedGameEntity.getVersionCode());
        C0172b.m259c(parcel, 2, extendedGameEntity.hR());
        C0172b.m250a(parcel, 3, extendedGameEntity.hS());
        C0172b.m259c(parcel, 4, extendedGameEntity.hT());
        C0172b.m239a(parcel, 5, extendedGameEntity.hU());
        C0172b.m239a(parcel, 6, extendedGameEntity.hV());
        C0172b.m247a(parcel, 7, extendedGameEntity.hW(), false);
        C0172b.m239a(parcel, 8, extendedGameEntity.hX());
        C0172b.m247a(parcel, 9, extendedGameEntity.hY(), false);
        C0172b.m258b(parcel, 10, extendedGameEntity.hQ(), false);
        C0172b.m243a(parcel, 11, extendedGameEntity.hZ(), i, false);
        C0172b.m235G(parcel, C);
    }

    public ExtendedGameEntity bg(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        long j = 0;
        long j2 = 0;
        String str = null;
        long j3 = 0;
        String str2 = null;
        ArrayList arrayList = null;
        SnapshotMetadataEntity snapshotMetadataEntity = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    gameEntity = (GameEntity) C0171a.m201a(parcel, A, GameEntity.CREATOR);
                    break;
                case 2:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 3:
                    z = C0171a.m208c(parcel, A);
                    break;
                case 4:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 5:
                    j = C0171a.m214i(parcel, A);
                    break;
                case 6:
                    j2 = C0171a.m214i(parcel, A);
                    break;
                case 7:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 8:
                    j3 = C0171a.m214i(parcel, A);
                    break;
                case 9:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 10:
                    arrayList = C0171a.m207c(parcel, A, GameBadgeEntity.CREATOR);
                    break;
                case 11:
                    snapshotMetadataEntity = (SnapshotMetadataEntity) C0171a.m201a(parcel, A, (Creator) SnapshotMetadataEntity.CREATOR);
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
            return new ExtendedGameEntity(i, gameEntity, i2, z, i3, j, j2, str, j3, str2, arrayList, snapshotMetadataEntity);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public ExtendedGameEntity[] co(int i) {
        return new ExtendedGameEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bg(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return co(x0);
    }
}
