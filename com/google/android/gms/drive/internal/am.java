package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class am implements Creator<OnMetadataResponse> {
    static void m326a(OnMetadataResponse onMetadataResponse, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, onMetadataResponse.xM);
        C0172b.m243a(parcel, 2, onMetadataResponse.IE, i, false);
        C0172b.m235G(parcel, C);
    }

    public OnMetadataResponse an(Parcel parcel) {
        int B = C0171a.m196B(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) C0171a.m201a(parcel, A, MetadataBundle.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new OnMetadataResponse(i, metadataBundle);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public OnMetadataResponse[] bj(int i) {
        return new OnMetadataResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return an(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return bj(x0);
    }
}
