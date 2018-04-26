package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0518o implements Creator<ProxyCard> {
    static void m1786a(ProxyCard proxyCard, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, proxyCard.getVersionCode());
        C0172b.m247a(parcel, 2, proxyCard.ajV, false);
        C0172b.m247a(parcel, 3, proxyCard.ajW, false);
        C0172b.m259c(parcel, 4, proxyCard.ajX);
        C0172b.m259c(parcel, 5, proxyCard.ajY);
        C0172b.m235G(parcel, C);
    }

    public ProxyCard cd(Parcel parcel) {
        String str = null;
        int i = 0;
        int B = C0171a.m196B(parcel);
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 4:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 5:
                    i = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ProxyCard(i3, str2, str, i2, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cd(x0);
    }

    public ProxyCard[] dJ(int i) {
        return new ProxyCard[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dJ(x0);
    }
}
