package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class ConnectionInfoCreator implements Creator<ConnectionInfo> {
    static void m478a(ConnectionInfo connectionInfo, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m247a(parcel, 1, connectionInfo.gW(), false);
        C0172b.m259c(parcel, 1000, connectionInfo.getVersionCode());
        C0172b.m259c(parcel, 2, connectionInfo.gX());
        C0172b.m235G(parcel, C);
    }

    public ConnectionInfo bf(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 2:
                    i = C0171a.m212g(parcel, A);
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
            return new ConnectionInfo(i2, str, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public ConnectionInfo[] cf(int i) {
        return new ConnectionInfo[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bf(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cf(x0);
    }
}
