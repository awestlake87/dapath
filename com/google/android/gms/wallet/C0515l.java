package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;

public class C0515l implements Creator<MaskedWalletRequest> {
    static void m1783a(MaskedWalletRequest maskedWalletRequest, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, maskedWalletRequest.getVersionCode());
        C0172b.m247a(parcel, 2, maskedWalletRequest.aiR, false);
        C0172b.m250a(parcel, 3, maskedWalletRequest.ajF);
        C0172b.m250a(parcel, 4, maskedWalletRequest.ajG);
        C0172b.m250a(parcel, 5, maskedWalletRequest.ajH);
        C0172b.m247a(parcel, 6, maskedWalletRequest.ajI, false);
        C0172b.m247a(parcel, 7, maskedWalletRequest.aiL, false);
        C0172b.m247a(parcel, 8, maskedWalletRequest.ajJ, false);
        C0172b.m243a(parcel, 9, maskedWalletRequest.aja, i, false);
        C0172b.m250a(parcel, 10, maskedWalletRequest.ajK);
        C0172b.m250a(parcel, 11, maskedWalletRequest.ajL);
        C0172b.m253a(parcel, 12, maskedWalletRequest.ajM, i, false);
        C0172b.m250a(parcel, 13, maskedWalletRequest.ajN);
        C0172b.m250a(parcel, 14, maskedWalletRequest.ajO);
        C0172b.m258b(parcel, 15, maskedWalletRequest.ajP, false);
        C0172b.m235G(parcel, C);
    }

    public MaskedWalletRequest ca(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Cart cart = null;
        boolean z4 = false;
        boolean z5 = false;
        CountrySpecification[] countrySpecificationArr = null;
        boolean z6 = true;
        boolean z7 = true;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    z = C0171a.m208c(parcel, A);
                    break;
                case 4:
                    z2 = C0171a.m208c(parcel, A);
                    break;
                case 5:
                    z3 = C0171a.m208c(parcel, A);
                    break;
                case 6:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 7:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 8:
                    str4 = C0171a.m220o(parcel, A);
                    break;
                case 9:
                    cart = (Cart) C0171a.m201a(parcel, A, Cart.CREATOR);
                    break;
                case 10:
                    z4 = C0171a.m208c(parcel, A);
                    break;
                case 11:
                    z5 = C0171a.m208c(parcel, A);
                    break;
                case 12:
                    countrySpecificationArr = (CountrySpecification[]) C0171a.m206b(parcel, A, CountrySpecification.CREATOR);
                    break;
                case 13:
                    z6 = C0171a.m208c(parcel, A);
                    break;
                case 14:
                    z7 = C0171a.m208c(parcel, A);
                    break;
                case 15:
                    arrayList = C0171a.m207c(parcel, A, CountrySpecification.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new MaskedWalletRequest(i, str, z, z2, z3, str2, str3, str4, cart, z4, z5, countrySpecificationArr, z6, z7, arrayList);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ca(x0);
    }

    public MaskedWalletRequest[] dG(int i) {
        return new MaskedWalletRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dG(x0);
    }
}
