package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.drive.Contents;

public class SnapshotEntityCreator implements Creator<SnapshotEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m749a(SnapshotEntity snapshotEntity, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m243a(parcel, 1, snapshotEntity.getMetadata(), i, false);
        C0172b.m259c(parcel, 1000, snapshotEntity.getVersionCode());
        C0172b.m243a(parcel, 2, snapshotEntity.getContents(), i, false);
        C0172b.m235G(parcel, C);
    }

    public SnapshotEntity createFromParcel(Parcel parcel) {
        Contents contents = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        SnapshotMetadata snapshotMetadata = null;
        while (parcel.dataPosition() < B) {
            int i2;
            Contents contents2;
            SnapshotMetadata snapshotMetadata2;
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i2 = i;
                    SnapshotMetadataEntity snapshotMetadataEntity = (SnapshotMetadataEntity) C0171a.m201a(parcel, A, SnapshotMetadataEntity.CREATOR);
                    contents2 = contents;
                    Object obj = snapshotMetadataEntity;
                    break;
                case 2:
                    contents2 = (Contents) C0171a.m201a(parcel, A, Contents.CREATOR);
                    snapshotMetadata2 = snapshotMetadata;
                    i2 = i;
                    break;
                case 1000:
                    Contents contents3 = contents;
                    snapshotMetadata2 = snapshotMetadata;
                    i2 = C0171a.m212g(parcel, A);
                    contents2 = contents3;
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    contents2 = contents;
                    snapshotMetadata2 = snapshotMetadata;
                    i2 = i;
                    break;
            }
            i = i2;
            snapshotMetadata = snapshotMetadata2;
            contents = contents2;
        }
        if (parcel.dataPosition() == B) {
            return new SnapshotEntity(i, snapshotMetadata, contents);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public SnapshotEntity[] newArray(int size) {
        return new SnapshotEntity[size];
    }
}
