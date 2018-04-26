package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0266a implements Creator<CountrySpecification> {
    static void m757a(CountrySpecification countrySpecification, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, countrySpecification.getVersionCode());
        C0172b.m247a(parcel, 2, countrySpecification.rf, false);
        C0172b.m235G(parcel, C);
    }

    public CountrySpecification bq(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    str = C0171a.m220o(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new CountrySpecification(i, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public CountrySpecification[] cD(int i) {
        return new CountrySpecification[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bq(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return cD(x0);
    }
}
