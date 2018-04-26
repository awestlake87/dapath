package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import java.util.ArrayList;

public class InvitationClusterCreator implements Creator<ZInvitationCluster> {
    static void m734a(ZInvitationCluster zInvitationCluster, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m258b(parcel, 1, zInvitationCluster.ij(), false);
        C0172b.m259c(parcel, 1000, zInvitationCluster.getVersionCode());
        C0172b.m235G(parcel, C);
    }

    public ZInvitationCluster bi(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    arrayList = C0171a.m207c(parcel, A, InvitationEntity.CREATOR);
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
            return new ZInvitationCluster(i, arrayList);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bi(x0);
    }

    public ZInvitationCluster[] cs(int i) {
        return new ZInvitationCluster[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cs(x0);
    }
}
