package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public class GameRequestClusterCreator implements Creator<GameRequestCluster> {
    static void m736a(GameRequestCluster gameRequestCluster, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m258b(parcel, 1, gameRequestCluster.iw(), false);
        C0172b.m259c(parcel, 1000, gameRequestCluster.getVersionCode());
        C0172b.m235G(parcel, C);
    }

    public GameRequestCluster bk(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    arrayList = C0171a.m207c(parcel, A, GameRequestEntity.CREATOR);
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
            return new GameRequestCluster(i, arrayList);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bk(x0);
    }

    public GameRequestCluster[] cv(int i) {
        return new GameRequestCluster[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cv(x0);
    }
}
