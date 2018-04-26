package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class RoomEntityCreator implements Creator<RoomEntity> {
    static void m743a(RoomEntity roomEntity, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m247a(parcel, 1, roomEntity.getRoomId(), false);
        C0172b.m259c(parcel, 1000, roomEntity.getVersionCode());
        C0172b.m247a(parcel, 2, roomEntity.getCreatorId(), false);
        C0172b.m239a(parcel, 3, roomEntity.getCreationTimestamp());
        C0172b.m259c(parcel, 4, roomEntity.getStatus());
        C0172b.m247a(parcel, 5, roomEntity.getDescription(), false);
        C0172b.m259c(parcel, 6, roomEntity.getVariant());
        C0172b.m240a(parcel, 7, roomEntity.getAutoMatchCriteria(), false);
        C0172b.m258b(parcel, 8, roomEntity.getParticipants(), false);
        C0172b.m259c(parcel, 9, roomEntity.getAutoMatchWaitEstimateSeconds());
        C0172b.m235G(parcel, C);
    }

    public RoomEntity bo(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int B = C0171a.m196B(parcel);
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        String str2 = null;
        String str3 = null;
        int i4 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 2:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    j = C0171a.m214i(parcel, A);
                    break;
                case 4:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 5:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 6:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 7:
                    bundle = C0171a.m222q(parcel, A);
                    break;
                case 8:
                    arrayList = C0171a.m207c(parcel, A, ParticipantEntity.CREATOR);
                    break;
                case 9:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 1000:
                    i4 = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new RoomEntity(i4, str3, str2, j, i3, str, i2, bundle, arrayList, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public RoomEntity[] cA(int i) {
        return new RoomEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bo(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cA(x0);
    }
}
