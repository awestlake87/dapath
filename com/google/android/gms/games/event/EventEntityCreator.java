package com.google.android.gms.games.event;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;

public class EventEntityCreator implements Creator<EventEntity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m477a(EventEntity eventEntity, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m247a(parcel, 1, eventEntity.getEventId(), false);
        C0172b.m259c(parcel, 1000, eventEntity.getVersionCode());
        C0172b.m247a(parcel, 2, eventEntity.getName(), false);
        C0172b.m247a(parcel, 3, eventEntity.getDescription(), false);
        C0172b.m243a(parcel, 4, eventEntity.getIconImageUri(), i, false);
        C0172b.m247a(parcel, 5, eventEntity.getIconImageUrl(), false);
        C0172b.m243a(parcel, 6, eventEntity.getPlayer(), i, false);
        C0172b.m239a(parcel, 7, eventEntity.getValue());
        C0172b.m247a(parcel, 8, eventEntity.getFormattedValue(), false);
        C0172b.m250a(parcel, 9, eventEntity.isVisible());
        C0172b.m235G(parcel, C);
    }

    public EventEntity createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int B = C0171a.m196B(parcel);
        long j = 0;
        Player player = null;
        String str2 = null;
        Uri uri = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    str5 = C0171a.m220o(parcel, A);
                    break;
                case 2:
                    str4 = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 4:
                    uri = (Uri) C0171a.m201a(parcel, A, Uri.CREATOR);
                    break;
                case 5:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 6:
                    player = (PlayerEntity) C0171a.m201a(parcel, A, PlayerEntity.CREATOR);
                    break;
                case 7:
                    j = C0171a.m214i(parcel, A);
                    break;
                case 8:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 9:
                    z = C0171a.m208c(parcel, A);
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
            return new EventEntity(i, str5, str4, str3, uri, str2, player, j, str, z);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public EventEntity[] newArray(int size) {
        return new EventEntity[size];
    }
}
