package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0161f implements Creator<DataHolder> {
    static void m165a(DataHolder dataHolder, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m254a(parcel, 1, dataHolder.eX(), false);
        C0172b.m259c(parcel, 1000, dataHolder.getVersionCode());
        C0172b.m253a(parcel, 2, dataHolder.eY(), i, false);
        C0172b.m259c(parcel, 3, dataHolder.getStatusCode());
        C0172b.m240a(parcel, 4, dataHolder.eU(), false);
        C0172b.m235G(parcel, C);
    }

    public DataHolder[] ag(int i) {
        return new DataHolder[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m166x(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ag(x0);
    }

    public DataHolder m166x(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int B = C0171a.m196B(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    strArr = C0171a.m195A(parcel, A);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) C0171a.m206b(parcel, A, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 4:
                    bundle = C0171a.m222q(parcel, A);
                    break;
                case 1000:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() != B) {
            throw new C0170a("Overread allowed size end=" + B, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.eW();
        return dataHolder;
    }
}
