package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0228c implements Creator<ParcelableObjectChangedEvent> {
    static void m394a(ParcelableObjectChangedEvent parcelableObjectChangedEvent, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, parcelableObjectChangedEvent.xM);
        C0172b.m247a(parcel, 2, parcelableObjectChangedEvent.rR, false);
        C0172b.m247a(parcel, 3, parcelableObjectChangedEvent.Lm, false);
        C0172b.m250a(parcel, 4, parcelableObjectChangedEvent.Ls);
        C0172b.m247a(parcel, 5, parcelableObjectChangedEvent.Lq, false);
        C0172b.m247a(parcel, 6, parcelableObjectChangedEvent.Lt, false);
        C0172b.m259c(parcel, 7, parcelableObjectChangedEvent.LF);
        C0172b.m259c(parcel, 8, parcelableObjectChangedEvent.LG);
        C0172b.m235G(parcel, C);
    }

    public ParcelableObjectChangedEvent aV(Parcel parcel) {
        String str = null;
        int i = 0;
        int B = C0171a.m196B(parcel);
        int i2 = 0;
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    str4 = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 4:
                    z = C0171a.m208c(parcel, A);
                    break;
                case 5:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 6:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 7:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 8:
                    i = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ParcelableObjectChangedEvent(i3, str4, str3, z, str2, str, i2, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public ParcelableObjectChangedEvent[] bS(int i) {
        return new ParcelableObjectChangedEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aV(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bS(x0);
    }
}
