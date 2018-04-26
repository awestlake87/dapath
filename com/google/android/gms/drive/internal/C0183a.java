package com.google.android.gms.drive.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.drive.DriveId;

public class C0183a implements Creator<AddEventListenerRequest> {
    static void m275a(AddEventListenerRequest addEventListenerRequest, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, addEventListenerRequest.xM);
        C0172b.m243a(parcel, 2, addEventListenerRequest.Hz, i, false);
        C0172b.m259c(parcel, 3, addEventListenerRequest.Iq);
        C0172b.m243a(parcel, 4, addEventListenerRequest.Ir, i, false);
        C0172b.m235G(parcel, C);
    }

    public AddEventListenerRequest m276R(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int i = 0;
        int B = C0171a.m196B(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int i3;
            DriveId driveId2;
            int g;
            PendingIntent pendingIntent2;
            int A = C0171a.m194A(parcel);
            PendingIntent pendingIntent3;
            switch (C0171a.ar(A)) {
                case 1:
                    pendingIntent3 = pendingIntent;
                    i3 = i;
                    driveId2 = driveId;
                    g = C0171a.m212g(parcel, A);
                    pendingIntent2 = pendingIntent3;
                    break;
                case 2:
                    g = i2;
                    int i4 = i;
                    driveId2 = (DriveId) C0171a.m201a(parcel, A, DriveId.CREATOR);
                    pendingIntent2 = pendingIntent;
                    i3 = i4;
                    break;
                case 3:
                    driveId2 = driveId;
                    g = i2;
                    pendingIntent3 = pendingIntent;
                    i3 = C0171a.m212g(parcel, A);
                    pendingIntent2 = pendingIntent3;
                    break;
                case 4:
                    pendingIntent2 = (PendingIntent) C0171a.m201a(parcel, A, PendingIntent.CREATOR);
                    i3 = i;
                    driveId2 = driveId;
                    g = i2;
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    driveId2 = driveId;
                    g = i2;
                    break;
            }
            i2 = g;
            driveId = driveId2;
            i = i3;
            pendingIntent = pendingIntent2;
        }
        if (parcel.dataPosition() == B) {
            return new AddEventListenerRequest(i2, driveId, i, pendingIntent);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public AddEventListenerRequest[] aM(int i) {
        return new AddEventListenerRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m276R(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aM(x0);
    }
}
