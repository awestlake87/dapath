package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import java.util.ArrayList;

public class C0499b implements Creator<Cart> {
    static void m1751a(Cart cart, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, cart.getVersionCode());
        C0172b.m247a(parcel, 2, cart.aiK, false);
        C0172b.m247a(parcel, 3, cart.aiL, false);
        C0172b.m258b(parcel, 4, cart.aiM, false);
        C0172b.m235G(parcel, C);
    }

    public Cart bR(Parcel parcel) {
        String str = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        ArrayList arrayList = new ArrayList();
        String str2 = null;
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
                    arrayList = C0171a.m207c(parcel, A, LineItem.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new Cart(i, str2, str, arrayList);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bR(x0);
    }

    public Cart[] dx(int i) {
        return new Cart[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dx(x0);
    }
}
