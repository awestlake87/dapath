package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.games.PlayerEntity;

public class ParticipantEntityCreator implements Creator<ParticipantEntity> {
    static void m741a(ParticipantEntity participantEntity, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m247a(parcel, 1, participantEntity.getParticipantId(), false);
        C0172b.m259c(parcel, 1000, participantEntity.getVersionCode());
        C0172b.m247a(parcel, 2, participantEntity.getDisplayName(), false);
        C0172b.m243a(parcel, 3, participantEntity.getIconImageUri(), i, false);
        C0172b.m243a(parcel, 4, participantEntity.getHiResImageUri(), i, false);
        C0172b.m259c(parcel, 5, participantEntity.getStatus());
        C0172b.m247a(parcel, 6, participantEntity.gW(), false);
        C0172b.m250a(parcel, 7, participantEntity.isConnectedToRoom());
        C0172b.m243a(parcel, 8, participantEntity.getPlayer(), i, false);
        C0172b.m259c(parcel, 9, participantEntity.getCapabilities());
        C0172b.m243a(parcel, 10, participantEntity.getResult(), i, false);
        C0172b.m247a(parcel, 11, participantEntity.getIconImageUrl(), false);
        C0172b.m247a(parcel, 12, participantEntity.getHiResImageUrl(), false);
        C0172b.m235G(parcel, C);
    }

    public ParticipantEntity bm(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        int i2 = 0;
        String str3 = null;
        boolean z = false;
        PlayerEntity playerEntity = null;
        int i3 = 0;
        ParticipantResult participantResult = null;
        String str4 = null;
        String str5 = null;
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
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 6:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 7:
                    z = C0171a.m208c(parcel, A);
                    break;
                case 8:
                    playerEntity = (PlayerEntity) C0171a.m201a(parcel, A, PlayerEntity.CREATOR);
                    break;
                case 9:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 10:
                    participantResult = (ParticipantResult) C0171a.m201a(parcel, A, ParticipantResult.CREATOR);
                    break;
                case 11:
                    str4 = C0171a.m220o(parcel, A);
                    break;
                case 12:
                    str5 = C0171a.m220o(parcel, A);
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
            return new ParticipantEntity(i, str, str2, uri, uri2, i2, str3, z, playerEntity, i3, participantResult, str4, str5);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bm(x0);
    }

    public ParticipantEntity[] cy(int i) {
        return new ParticipantEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cy(x0);
    }
}
