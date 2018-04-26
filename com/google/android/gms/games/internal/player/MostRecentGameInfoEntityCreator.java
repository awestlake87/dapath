package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class MostRecentGameInfoEntityCreator implements Creator<MostRecentGameInfoEntity> {
    static void m735a(MostRecentGameInfoEntity mostRecentGameInfoEntity, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m247a(parcel, 1, mostRecentGameInfoEntity.ip(), false);
        C0172b.m259c(parcel, 1000, mostRecentGameInfoEntity.getVersionCode());
        C0172b.m247a(parcel, 2, mostRecentGameInfoEntity.iq(), false);
        C0172b.m239a(parcel, 3, mostRecentGameInfoEntity.ir());
        C0172b.m243a(parcel, 4, mostRecentGameInfoEntity.is(), i, false);
        C0172b.m243a(parcel, 5, mostRecentGameInfoEntity.it(), i, false);
        C0172b.m243a(parcel, 6, mostRecentGameInfoEntity.iu(), i, false);
        C0172b.m235G(parcel, C);
    }

    public MostRecentGameInfoEntity bj(Parcel parcel) {
        Uri uri = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        long j = 0;
        Uri uri2 = null;
        Uri uri3 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 2:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    j = C0171a.m214i(parcel, A);
                    break;
                case 4:
                    uri3 = (Uri) C0171a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case 5:
                    uri2 = (Uri) C0171a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case 6:
                    uri = (Uri) C0171a.m201a(parcel, A, Uri.CREATOR);
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
            return new MostRecentGameInfoEntity(i, str2, str, j, uri3, uri2, uri);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bj(x0);
    }

    public MostRecentGameInfoEntity[] cu(int i) {
        return new MostRecentGameInfoEntity[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cu(x0);
    }
}
