package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.drive.Contents;

public class C0187f implements Creator<CloseContentsRequest> {
    static void m344a(CloseContentsRequest closeContentsRequest, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, closeContentsRequest.xM);
        C0172b.m243a(parcel, 2, closeContentsRequest.Iw, i, false);
        C0172b.m244a(parcel, 3, closeContentsRequest.Iz, false);
        C0172b.m235G(parcel, C);
    }

    public CloseContentsRequest m345V(Parcel parcel) {
        Boolean bool = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < B) {
            Contents contents2;
            int g;
            Boolean bool2;
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    Boolean bool3 = bool;
                    contents2 = contents;
                    g = C0171a.m212g(parcel, A);
                    bool2 = bool3;
                    break;
                case 2:
                    g = i;
                    Contents contents3 = (Contents) C0171a.m201a(parcel, A, Contents.CREATOR);
                    bool2 = bool;
                    contents2 = contents3;
                    break;
                case 3:
                    bool2 = C0171a.m209d(parcel, A);
                    contents2 = contents;
                    g = i;
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    bool2 = bool;
                    contents2 = contents;
                    g = i;
                    break;
            }
            i = g;
            contents = contents2;
            bool = bool2;
        }
        if (parcel.dataPosition() == B) {
            return new CloseContentsRequest(i, contents, bool);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public CloseContentsRequest[] aQ(int i) {
        return new CloseContentsRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m345V(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aQ(x0);
    }
}
