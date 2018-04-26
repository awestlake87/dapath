package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0246p implements Creator<ParcelableCollaborator> {
    static void m454a(ParcelableCollaborator parcelableCollaborator, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, parcelableCollaborator.xM);
        C0172b.m250a(parcel, 2, parcelableCollaborator.Lk);
        C0172b.m250a(parcel, 3, parcelableCollaborator.Ll);
        C0172b.m247a(parcel, 4, parcelableCollaborator.rR, false);
        C0172b.m247a(parcel, 5, parcelableCollaborator.Lm, false);
        C0172b.m247a(parcel, 6, parcelableCollaborator.Ln, false);
        C0172b.m247a(parcel, 7, parcelableCollaborator.Lo, false);
        C0172b.m247a(parcel, 8, parcelableCollaborator.Lp, false);
        C0172b.m235G(parcel, C);
    }

    public ParcelableCollaborator aR(Parcel parcel) {
        boolean z = false;
        String str = null;
        int B = C0171a.m196B(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    z2 = C0171a.m208c(parcel, A);
                    break;
                case 3:
                    z = C0171a.m208c(parcel, A);
                    break;
                case 4:
                    str5 = C0171a.m220o(parcel, A);
                    break;
                case 5:
                    str4 = C0171a.m220o(parcel, A);
                    break;
                case 6:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 7:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 8:
                    str = C0171a.m220o(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ParcelableCollaborator(i, z2, z, str5, str4, str3, str2, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public ParcelableCollaborator[] bO(int i) {
        return new ParcelableCollaborator[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return aR(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bO(x0);
    }
}
