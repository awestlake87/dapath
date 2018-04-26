package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

public class InvitationEntityCreator implements Creator<InvitationEntity> {
    static void m740a(InvitationEntity invitationEntity, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m243a(parcel, 1, invitationEntity.getGame(), i, false);
        C0172b.m259c(parcel, 1000, invitationEntity.getVersionCode());
        C0172b.m247a(parcel, 2, invitationEntity.getInvitationId(), false);
        C0172b.m239a(parcel, 3, invitationEntity.getCreationTimestamp());
        C0172b.m259c(parcel, 4, invitationEntity.getInvitationType());
        C0172b.m243a(parcel, 5, invitationEntity.getInviter(), i, false);
        C0172b.m258b(parcel, 6, invitationEntity.getParticipants(), false);
        C0172b.m259c(parcel, 7, invitationEntity.getVariant());
        C0172b.m259c(parcel, 8, invitationEntity.getAvailableAutoMatchSlots());
        C0172b.m235G(parcel, C);
    }

    public InvitationEntity bl(Parcel parcel) {
        ArrayList arrayList = null;
        int i = 0;
        int B = C0171a.m196B(parcel);
        long j = 0;
        int i2 = 0;
        ParticipantEntity participantEntity = null;
        int i3 = 0;
        String str = null;
        GameEntity gameEntity = null;
        int i4 = 0;
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
                    j = C0171a.m214i(parcel, A);
                    break;
                case 4:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 5:
                    participantEntity = (ParticipantEntity) C0171a.m201a(parcel, A, ParticipantEntity.CREATOR);
                    break;
                case 6:
                    arrayList = C0171a.m207c(parcel, A, ParticipantEntity.CREATOR);
                    break;
                case 7:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 8:
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
            return new InvitationEntity(i4, gameEntity, str, j, i3, participantEntity, arrayList, i2, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bl(x0);
    }

    public InvitationEntity[] cx(int i) {
        return new InvitationEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cx(x0);
    }
}
