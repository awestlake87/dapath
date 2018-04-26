package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class MilestoneEntityCreator implements Creator<MilestoneEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m746a(MilestoneEntity milestoneEntity, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m247a(parcel, 1, milestoneEntity.getMilestoneId(), false);
        C0172b.m259c(parcel, 1000, milestoneEntity.getVersionCode());
        C0172b.m239a(parcel, 2, milestoneEntity.getCurrentProgress());
        C0172b.m239a(parcel, 3, milestoneEntity.getTargetProgress());
        C0172b.m251a(parcel, 4, milestoneEntity.getCompletionRewardData(), false);
        C0172b.m259c(parcel, 5, milestoneEntity.getState());
        C0172b.m247a(parcel, 6, milestoneEntity.getEventId(), false);
        C0172b.m235G(parcel, C);
    }

    public MilestoneEntity createFromParcel(Parcel parcel) {
        long j = 0;
        int i = 0;
        String str = null;
        int B = C0171a.m196B(parcel);
        byte[] bArr = null;
        long j2 = 0;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 2:
                    j2 = C0171a.m214i(parcel, A);
                    break;
                case 3:
                    j = C0171a.m214i(parcel, A);
                    break;
                case 4:
                    bArr = C0171a.m223r(parcel, A);
                    break;
                case 5:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 6:
                    str = C0171a.m220o(parcel, A);
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
            return new MilestoneEntity(i2, str2, j2, j, bArr, i, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public MilestoneEntity[] newArray(int size) {
        return new MilestoneEntity[size];
    }
}
