package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0516m implements Creator<NotifyTransactionStatusRequest> {
    static void m1784a(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, notifyTransactionStatusRequest.xM);
        C0172b.m247a(parcel, 2, notifyTransactionStatusRequest.aiQ, false);
        C0172b.m259c(parcel, 3, notifyTransactionStatusRequest.status);
        C0172b.m247a(parcel, 4, notifyTransactionStatusRequest.ajR, false);
        C0172b.m235G(parcel, C);
    }

    public NotifyTransactionStatusRequest cb(Parcel parcel) {
        String str = null;
        int i = 0;
        int B = C0171a.m196B(parcel);
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 4:
                    str = C0171a.m220o(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new NotifyTransactionStatusRequest(i2, str2, i, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cb(x0);
    }

    public NotifyTransactionStatusRequest[] dH(int i) {
        return new NotifyTransactionStatusRequest[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return dH(x0);
    }
}
