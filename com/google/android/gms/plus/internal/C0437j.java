package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0437j implements Creator<C0916h> {
    static void m1584a(C0916h c0916h, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m247a(parcel, 1, c0916h.getAccountName(), false);
        C0172b.m259c(parcel, 1000, c0916h.getVersionCode());
        C0172b.m254a(parcel, 2, c0916h.jZ(), false);
        C0172b.m254a(parcel, 3, c0916h.ka(), false);
        C0172b.m254a(parcel, 4, c0916h.kb(), false);
        C0172b.m247a(parcel, 5, c0916h.kc(), false);
        C0172b.m247a(parcel, 6, c0916h.kd(), false);
        C0172b.m247a(parcel, 7, c0916h.ke(), false);
        C0172b.m247a(parcel, 8, c0916h.kf(), false);
        C0172b.m243a(parcel, 9, c0916h.kg(), i, false);
        C0172b.m235G(parcel, C);
    }

    public C0916h bD(Parcel parcel) {
        PlusCommonExtras plusCommonExtras = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String[] strArr = null;
        String[] strArr2 = null;
        String[] strArr3 = null;
        String str5 = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    str5 = C0171a.m220o(parcel, A);
                    break;
                case 2:
                    strArr3 = C0171a.m195A(parcel, A);
                    break;
                case 3:
                    strArr2 = C0171a.m195A(parcel, A);
                    break;
                case 4:
                    strArr = C0171a.m195A(parcel, A);
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
                case 9:
                    plusCommonExtras = (PlusCommonExtras) C0171a.m201a(parcel, A, PlusCommonExtras.CREATOR);
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
            return new C0916h(i, str5, strArr3, strArr2, strArr, str4, str3, str2, str, plusCommonExtras);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bD(x0);
    }

    public C0916h[] da(int i) {
        return new C0916h[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return da(x0);
    }
}
