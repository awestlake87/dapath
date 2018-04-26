package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class cd implements Creator<ce> {
    static void m848a(ce ceVar, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, ceVar.versionCode);
        C0172b.m247a(parcel, 2, ceVar.oa, false);
        C0172b.m247a(parcel, 3, ceVar.ob, false);
        C0172b.m247a(parcel, 4, ceVar.mimeType, false);
        C0172b.m247a(parcel, 5, ceVar.packageName, false);
        C0172b.m247a(parcel, 6, ceVar.oc, false);
        C0172b.m247a(parcel, 7, ceVar.od, false);
        C0172b.m247a(parcel, 8, ceVar.oe, false);
        C0172b.m235G(parcel, C);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m849e(x0);
    }

    public ce m849e(Parcel parcel) {
        String str = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    str7 = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    str6 = C0171a.m220o(parcel, A);
                    break;
                case 4:
                    str5 = C0171a.m220o(parcel, A);
                    break;
                case 5:
                    str4 = C0171a.m220o(parcel, A);
                    break;
                case 6:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 7:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 8:
                    str = C0171a.m220o(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ce(i, str7, str6, str5, str4, str3, str2, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public ce[] m850i(int i) {
        return new ce[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m850i(x0);
    }
}
