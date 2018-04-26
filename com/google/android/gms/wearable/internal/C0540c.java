package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0540c implements Creator<C0980b> {
    static void m1847a(C0980b c0980b, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, c0980b.xM);
        C0172b.m241a(parcel, 2, c0980b.no(), false);
        C0172b.m253a(parcel, 3, c0980b.alA, i, false);
        C0172b.m235G(parcel, C);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cv(x0);
    }

    public C0980b cv(Parcel parcel) {
        IntentFilter[] intentFilterArr = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    iBinder = C0171a.m221p(parcel, A);
                    break;
                case 3:
                    intentFilterArr = (IntentFilter[]) C0171a.m206b(parcel, A, IntentFilter.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new C0980b(i, iBinder, intentFilterArr);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public C0980b[] ee(int i) {
        return new C0980b[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ee(x0);
    }
}
