package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class TileCreator implements Creator<Tile> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m1524a(Tile tile, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, tile.getVersionCode());
        C0172b.m259c(parcel, 2, tile.width);
        C0172b.m259c(parcel, 3, tile.height);
        C0172b.m251a(parcel, 4, tile.data, false);
        C0172b.m235G(parcel, C);
    }

    public Tile createFromParcel(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        byte[] bArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 3:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 4:
                    bArr = C0171a.m223r(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new Tile(i3, i2, i, bArr);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public Tile[] newArray(int size) {
        return new Tile[size];
    }
}
