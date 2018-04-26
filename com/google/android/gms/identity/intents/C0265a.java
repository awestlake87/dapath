package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.List;

public class C0265a implements Creator<UserAddressRequest> {
    static void m756a(UserAddressRequest userAddressRequest, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, userAddressRequest.getVersionCode());
        C0172b.m258b(parcel, 2, userAddressRequest.UE, false);
        C0172b.m235G(parcel, C);
    }

    public UserAddressRequest bp(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    list = C0171a.m207c(parcel, A, CountrySpecification.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new UserAddressRequest(i, list);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public UserAddressRequest[] cC(int i) {
        return new UserAddressRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bp(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cC(x0);
    }
}
