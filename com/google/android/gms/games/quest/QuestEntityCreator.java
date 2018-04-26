package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

public class QuestEntityCreator implements Creator<QuestEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m747a(QuestEntity questEntity, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m243a(parcel, 1, questEntity.getGame(), i, false);
        C0172b.m247a(parcel, 2, questEntity.getQuestId(), false);
        C0172b.m239a(parcel, 3, questEntity.getAcceptedTimestamp());
        C0172b.m243a(parcel, 4, questEntity.getBannerImageUri(), i, false);
        C0172b.m247a(parcel, 5, questEntity.getBannerImageUrl(), false);
        C0172b.m247a(parcel, 6, questEntity.getDescription(), false);
        C0172b.m239a(parcel, 7, questEntity.getEndTimestamp());
        C0172b.m239a(parcel, 8, questEntity.getLastUpdatedTimestamp());
        C0172b.m243a(parcel, 9, questEntity.getIconImageUri(), i, false);
        C0172b.m247a(parcel, 10, questEntity.getIconImageUrl(), false);
        C0172b.m247a(parcel, 12, questEntity.getName(), false);
        C0172b.m239a(parcel, 13, questEntity.iK());
        C0172b.m239a(parcel, 14, questEntity.getStartTimestamp());
        C0172b.m259c(parcel, 15, questEntity.getState());
        C0172b.m258b(parcel, 17, questEntity.iJ(), false);
        C0172b.m259c(parcel, 16, questEntity.getType());
        C0172b.m259c(parcel, 1000, questEntity.getVersionCode());
        C0172b.m235G(parcel, C);
    }

    public QuestEntity createFromParcel(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        long j = 0;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        long j2 = 0;
        long j3 = 0;
        Uri uri2 = null;
        String str4 = null;
        String str5 = null;
        long j4 = 0;
        long j5 = 0;
        int i2 = 0;
        int i3 = 0;
        ArrayList arrayList = null;
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
                    uri = (Uri) C0171a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case 5:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 6:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 7:
                    j2 = C0171a.m214i(parcel, A);
                    break;
                case 8:
                    j3 = C0171a.m214i(parcel, A);
                    break;
                case 9:
                    uri2 = (Uri) C0171a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case 10:
                    str4 = C0171a.m220o(parcel, A);
                    break;
                case 12:
                    str5 = C0171a.m220o(parcel, A);
                    break;
                case 13:
                    j4 = C0171a.m214i(parcel, A);
                    break;
                case 14:
                    j5 = C0171a.m214i(parcel, A);
                    break;
                case 15:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 16:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 17:
                    arrayList = C0171a.m207c(parcel, A, MilestoneEntity.CREATOR);
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
            return new QuestEntity(i, gameEntity, str, j, uri, str2, str3, j2, j3, uri2, str4, str5, j4, j5, i2, i3, arrayList);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public QuestEntity[] newArray(int size) {
        return new QuestEntity[size];
    }
}
