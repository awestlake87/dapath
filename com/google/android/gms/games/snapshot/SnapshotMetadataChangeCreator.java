package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.C0609a;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class SnapshotMetadataChangeCreator implements Creator<SnapshotMetadataChange> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m750a(SnapshotMetadataChange snapshotMetadataChange, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m247a(parcel, 1, snapshotMetadataChange.getDescription(), false);
        C0172b.m259c(parcel, 1000, snapshotMetadataChange.getVersionCode());
        C0172b.m246a(parcel, 2, snapshotMetadataChange.getPlayedTimeMillis(), false);
        C0172b.m243a(parcel, 4, snapshotMetadataChange.getCoverImageUri(), i, false);
        C0172b.m243a(parcel, 5, snapshotMetadataChange.iN(), i, false);
        C0172b.m235G(parcel, C);
    }

    public SnapshotMetadataChange createFromParcel(Parcel parcel) {
        Uri uri = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        C0609a c0609a = null;
        Long l = null;
        String str = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 2:
                    l = C0171a.m215j(parcel, A);
                    break;
                case 4:
                    uri = (Uri) C0171a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case 5:
                    c0609a = (C0609a) C0171a.m201a(parcel, A, C0609a.CREATOR);
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
            return new SnapshotMetadataChange(i, str, l, c0609a, uri);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public SnapshotMetadataChange[] newArray(int size) {
        return new SnapshotMetadataChange[size];
    }
}
