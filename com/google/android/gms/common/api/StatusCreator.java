package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class StatusCreator implements Creator<Status> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m150a(Status status, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, status.getStatusCode());
        C0172b.m259c(parcel, 1000, status.getVersionCode());
        C0172b.m247a(parcel, 2, status.getStatusMessage(), false);
        C0172b.m243a(parcel, 3, status.eQ(), i, false);
        C0172b.m235G(parcel, C);
    }

    public Status createFromParcel(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int i = 0;
        int B = C0171a.m196B(parcel);
        String str = null;
        int i2 = 0;
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
                    pendingIntent = (PendingIntent) C0171a.m201a(parcel, A, PendingIntent.CREATOR);
                    break;
                case 1000:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new Status(i2, i, str, pendingIntent);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public Status[] newArray(int size) {
        return new Status[size];
    }
}
