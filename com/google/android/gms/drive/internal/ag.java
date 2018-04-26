package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.drive.Contents;

public class ag implements Creator<OnContentsResponse> {
    static void m320a(OnContentsResponse onContentsResponse, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, onContentsResponse.xM);
        C0172b.m243a(parcel, 2, onContentsResponse.HG, i, false);
        C0172b.m235G(parcel, C);
    }

    public OnContentsResponse ah(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        Contents contents = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    contents = (Contents) C0171a.m201a(parcel, A, Contents.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new OnContentsResponse(i, contents);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public OnContentsResponse[] bd(int i) {
        return new OnContentsResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ah(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bd(x0);
    }
}
