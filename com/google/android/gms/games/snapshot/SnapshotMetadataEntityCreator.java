package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;

public class SnapshotMetadataEntityCreator implements Creator<SnapshotMetadataEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m751a(SnapshotMetadataEntity snapshotMetadataEntity, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m243a(parcel, 1, snapshotMetadataEntity.getGame(), i, false);
        C0172b.m259c(parcel, 1000, snapshotMetadataEntity.getVersionCode());
        C0172b.m243a(parcel, 2, snapshotMetadataEntity.getOwner(), i, false);
        C0172b.m247a(parcel, 3, snapshotMetadataEntity.getSnapshotId(), false);
        C0172b.m243a(parcel, 5, snapshotMetadataEntity.getCoverImageUri(), i, false);
        C0172b.m247a(parcel, 6, snapshotMetadataEntity.getCoverImageUrl(), false);
        C0172b.m247a(parcel, 7, snapshotMetadataEntity.getTitle(), false);
        C0172b.m247a(parcel, 8, snapshotMetadataEntity.getDescription(), false);
        C0172b.m239a(parcel, 9, snapshotMetadataEntity.getLastModifiedTimestamp());
        C0172b.m239a(parcel, 10, snapshotMetadataEntity.getPlayedTime());
        C0172b.m238a(parcel, 11, snapshotMetadataEntity.getCoverImageAspectRatio());
        C0172b.m247a(parcel, 12, snapshotMetadataEntity.getUniqueName(), false);
        C0172b.m235G(parcel, C);
    }

    public SnapshotMetadataEntity createFromParcel(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        String str = null;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        float f = 0.0f;
        String str5 = null;
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
                    str = C0171a.m220o(parcel, A);
                    break;
                case 5:
                    uri = (Uri) C0171a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case 6:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 7:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 8:
                    str4 = C0171a.m220o(parcel, A);
                    break;
                case 9:
                    j = C0171a.m214i(parcel, A);
                    break;
                case 10:
                    j2 = C0171a.m214i(parcel, A);
                    break;
                case 11:
                    f = C0171a.m217l(parcel, A);
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
            return new SnapshotMetadataEntity(i, gameEntity, playerEntity, str, uri, str2, str3, str4, j, j2, f, str5);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public SnapshotMetadataEntity[] newArray(int size) {
        return new SnapshotMetadataEntity[size];
    }
}
