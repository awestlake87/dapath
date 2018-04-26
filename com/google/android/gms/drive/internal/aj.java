package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.FileConflictEvent;

public class aj implements Creator<OnEventResponse> {
    static void m323a(OnEventResponse onEventResponse, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, onEventResponse.xM);
        C0172b.m259c(parcel, 2, onEventResponse.Iq);
        C0172b.m243a(parcel, 3, onEventResponse.Jy, i, false);
        C0172b.m243a(parcel, 4, onEventResponse.Jz, i, false);
        C0172b.m235G(parcel, C);
    }

    public OnEventResponse ak(Parcel parcel) {
        FileConflictEvent fileConflictEvent = null;
        int i = 0;
        int B = C0171a.m196B(parcel);
        ChangeEvent changeEvent = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            ChangeEvent changeEvent2;
            int i3;
            FileConflictEvent fileConflictEvent2;
            int A = C0171a.m194A(parcel);
            FileConflictEvent fileConflictEvent3;
            switch (C0171a.ar(A)) {
                case 1:
                    fileConflictEvent3 = fileConflictEvent;
                    changeEvent2 = changeEvent;
                    i3 = i;
                    i = C0171a.m212g(parcel, A);
                    fileConflictEvent2 = fileConflictEvent3;
                    break;
                case 2:
                    i = i2;
                    ChangeEvent changeEvent3 = changeEvent;
                    i3 = C0171a.m212g(parcel, A);
                    fileConflictEvent2 = fileConflictEvent;
                    changeEvent2 = changeEvent3;
                    break;
                case 3:
                    i3 = i;
                    i = i2;
                    fileConflictEvent3 = fileConflictEvent;
                    changeEvent2 = (ChangeEvent) C0171a.m201a(parcel, A, ChangeEvent.CREATOR);
                    fileConflictEvent2 = fileConflictEvent3;
                    break;
                case 4:
                    fileConflictEvent2 = (FileConflictEvent) C0171a.m201a(parcel, A, FileConflictEvent.CREATOR);
                    changeEvent2 = changeEvent;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    fileConflictEvent2 = fileConflictEvent;
                    changeEvent2 = changeEvent;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            changeEvent = changeEvent2;
            fileConflictEvent = fileConflictEvent2;
        }
        if (parcel.dataPosition() == B) {
            return new OnEventResponse(i2, i, changeEvent, fileConflictEvent);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public OnEventResponse[] bg(int i) {
        return new OnEventResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ak(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bg(x0);
    }
}
