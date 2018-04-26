package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class GameBadgeEntityCreator implements Creator<GameBadgeEntity> {
    static void m733a(GameBadgeEntity gameBadgeEntity, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, gameBadgeEntity.getType());
        C0172b.m259c(parcel, 1000, gameBadgeEntity.getVersionCode());
        C0172b.m247a(parcel, 2, gameBadgeEntity.getTitle(), false);
        C0172b.m247a(parcel, 3, gameBadgeEntity.getDescription(), false);
        C0172b.m243a(parcel, 4, gameBadgeEntity.getIconImageUri(), i, false);
        C0172b.m235G(parcel, C);
    }

    public GameBadgeEntity bh(Parcel parcel) {
        int i = 0;
        Uri uri = null;
        int B = C0171a.m196B(parcel);
        String str = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 4:
                    uri = (Uri) C0171a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case 1000:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new GameBadgeEntity(i2, i, str2, str, uri);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public GameBadgeEntity[] cq(int i) {
        return new GameBadgeEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bh(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cq(x0);
    }
}
