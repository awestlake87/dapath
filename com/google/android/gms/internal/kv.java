package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.internal.ks.C1108b;
import com.google.android.gms.internal.ks.C1108b.C1106a;
import com.google.android.gms.internal.ks.C1108b.C1107b;
import java.util.HashSet;
import java.util.Set;

public class kv implements Creator<C1108b> {
    static void m1332a(C1108b c1108b, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        Set kk = c1108b.kk();
        if (kk.contains(Integer.valueOf(1))) {
            C0172b.m259c(parcel, 1, c1108b.getVersionCode());
        }
        if (kk.contains(Integer.valueOf(2))) {
            C0172b.m243a(parcel, 2, c1108b.kO(), i, true);
        }
        if (kk.contains(Integer.valueOf(3))) {
            C0172b.m243a(parcel, 3, c1108b.kP(), i, true);
        }
        if (kk.contains(Integer.valueOf(4))) {
            C0172b.m259c(parcel, 4, c1108b.getLayout());
        }
        C0172b.m235G(parcel, C);
    }

    public C1108b bI(Parcel parcel) {
        C1107b c1107b = null;
        int i = 0;
        int B = C0171a.m196B(parcel);
        Set hashSet = new HashSet();
        C1106a c1106a = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i2 = C0171a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    C1106a c1106a2 = (C1106a) C0171a.m201a(parcel, A, C1106a.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    c1106a = c1106a2;
                    break;
                case 3:
                    C1107b c1107b2 = (C1107b) C0171a.m201a(parcel, A, C1107b.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    c1107b = c1107b2;
                    break;
                case 4:
                    i = C0171a.m212g(parcel, A);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C1108b(hashSet, i2, c1106a, c1107b, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return bI(x0);
    }

    public C1108b[] df(int i) {
        return new C1108b[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return df(x0);
    }
}
