package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0226a implements Creator<ParcelableEvent> {
    static void m392a(ParcelableEvent parcelableEvent, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, parcelableEvent.xM);
        C0172b.m247a(parcel, 2, parcelableEvent.rR, false);
        C0172b.m247a(parcel, 3, parcelableEvent.Lm, false);
        C0172b.m250a(parcel, 4, parcelableEvent.Ls);
        C0172b.m247a(parcel, 5, parcelableEvent.Lq, false);
        C0172b.m247a(parcel, 6, parcelableEvent.Lt, false);
        C0172b.m243a(parcel, 7, parcelableEvent.Lu, i, false);
        C0172b.m243a(parcel, 8, parcelableEvent.Lv, i, false);
        C0172b.m243a(parcel, 9, parcelableEvent.Lw, i, false);
        C0172b.m243a(parcel, 10, parcelableEvent.Lx, i, false);
        C0172b.m243a(parcel, 11, parcelableEvent.Ly, i, false);
        C0172b.m243a(parcel, 12, parcelableEvent.Lz, i, false);
        C0172b.m243a(parcel, 13, parcelableEvent.LA, i, false);
        C0172b.m235G(parcel, C);
    }

    public ParcelableEvent aT(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        TextInsertedDetails textInsertedDetails = null;
        TextDeletedDetails textDeletedDetails = null;
        ValuesAddedDetails valuesAddedDetails = null;
        ValuesRemovedDetails valuesRemovedDetails = null;
        ValuesSetDetails valuesSetDetails = null;
        ValueChangedDetails valueChangedDetails = null;
        ReferenceShiftedDetails referenceShiftedDetails = null;
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
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 4:
                    z = C0171a.m208c(parcel, A);
                    break;
                case 5:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 6:
                    str4 = C0171a.m220o(parcel, A);
                    break;
                case 7:
                    textInsertedDetails = (TextInsertedDetails) C0171a.m201a(parcel, A, TextInsertedDetails.CREATOR);
                    break;
                case 8:
                    textDeletedDetails = (TextDeletedDetails) C0171a.m201a(parcel, A, TextDeletedDetails.CREATOR);
                    break;
                case 9:
                    valuesAddedDetails = (ValuesAddedDetails) C0171a.m201a(parcel, A, ValuesAddedDetails.CREATOR);
                    break;
                case 10:
                    valuesRemovedDetails = (ValuesRemovedDetails) C0171a.m201a(parcel, A, ValuesRemovedDetails.CREATOR);
                    break;
                case 11:
                    valuesSetDetails = (ValuesSetDetails) C0171a.m201a(parcel, A, ValuesSetDetails.CREATOR);
                    break;
                case 12:
                    valueChangedDetails = (ValueChangedDetails) C0171a.m201a(parcel, A, ValueChangedDetails.CREATOR);
                    break;
                case 13:
                    referenceShiftedDetails = (ReferenceShiftedDetails) C0171a.m201a(parcel, A, ReferenceShiftedDetails.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ParcelableEvent(i, str, str2, z, str3, str4, textInsertedDetails, textDeletedDetails, valuesAddedDetails, valuesRemovedDetails, valuesSetDetails, valueChangedDetails, referenceShiftedDetails);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public ParcelableEvent[] bQ(int i) {
        return new ParcelableEvent[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aT(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bQ(x0);
    }
}
