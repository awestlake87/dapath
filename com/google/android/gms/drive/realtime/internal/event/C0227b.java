package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0227b implements Creator<ParcelableEventList> {
    static void m393a(ParcelableEventList parcelableEventList, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, parcelableEventList.xM);
        C0172b.m253a(parcel, 2, parcelableEventList.LB, i, false);
        C0172b.m243a(parcel, 3, parcelableEventList.LC, i, false);
        C0172b.m250a(parcel, 4, parcelableEventList.LD);
        C0172b.m253a(parcel, 5, parcelableEventList.LE, i, false);
        C0172b.m235G(parcel, C);
    }

    public ParcelableEventList aU(Parcel parcel) {
        boolean z = false;
        ParcelableObjectChangedEvent[] parcelableObjectChangedEventArr = null;
        int B = C0171a.m196B(parcel);
        DataHolder dataHolder = null;
        ParcelableEvent[] parcelableEventArr = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    parcelableEventArr = (ParcelableEvent[]) C0171a.m206b(parcel, A, ParcelableEvent.CREATOR);
                    break;
                case 3:
                    dataHolder = (DataHolder) C0171a.m201a(parcel, A, DataHolder.CREATOR);
                    break;
                case 4:
                    z = C0171a.m208c(parcel, A);
                    break;
                case 5:
                    parcelableObjectChangedEventArr = (ParcelableObjectChangedEvent[]) C0171a.m206b(parcel, A, ParcelableObjectChangedEvent.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ParcelableEventList(i, parcelableEventArr, dataHolder, z, parcelableObjectChangedEventArr);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public ParcelableEventList[] bR(int i) {
        return new ParcelableEventList[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aU(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bR(x0);
    }
}
