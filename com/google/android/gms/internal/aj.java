package com.google.android.gms.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import java.util.List;

public class aj implements Creator<ai> {
    static void m780a(ai aiVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, aiVar.versionCode);
        C0172b.m239a(parcel, 2, aiVar.lS);
        C0172b.m240a(parcel, 3, aiVar.extras, false);
        C0172b.m259c(parcel, 4, aiVar.lT);
        C0172b.m248a(parcel, 5, aiVar.lU, false);
        C0172b.m250a(parcel, 6, aiVar.lV);
        C0172b.m259c(parcel, 7, aiVar.lW);
        C0172b.m250a(parcel, 8, aiVar.lX);
        C0172b.m247a(parcel, 9, aiVar.lY, false);
        C0172b.m243a(parcel, 10, aiVar.lZ, i, false);
        C0172b.m243a(parcel, 11, aiVar.ma, i, false);
        C0172b.m247a(parcel, 12, aiVar.mb, false);
        C0172b.m240a(parcel, 13, aiVar.mc, false);
        C0172b.m235G(parcel, C);
    }

    public ai m781b(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        aw awVar = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    j = C0171a.m214i(parcel, A);
                    break;
                case 3:
                    bundle = C0171a.m222q(parcel, A);
                    break;
                case 4:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 5:
                    list = C0171a.m197B(parcel, A);
                    break;
                case 6:
                    z = C0171a.m208c(parcel, A);
                    break;
                case 7:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 8:
                    z2 = C0171a.m208c(parcel, A);
                    break;
                case 9:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 10:
                    awVar = (aw) C0171a.m201a(parcel, A, aw.CREATOR);
                    break;
                case 11:
                    location = (Location) C0171a.m201a(parcel, A, Location.CREATOR);
                    break;
                case 12:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 13:
                    bundle2 = C0171a.m222q(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ai(i, j, bundle, i2, list, z, i3, z2, str, awVar, location, str2, bundle2);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public ai[] m782c(int i) {
        return new ai[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m781b(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m782c(x0);
    }
}
