package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class ah implements Creator<OnDownloadProgressResponse> {
    static void m321a(OnDownloadProgressResponse onDownloadProgressResponse, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, onDownloadProgressResponse.xM);
        C0172b.m239a(parcel, 2, onDownloadProgressResponse.Jw);
        C0172b.m239a(parcel, 3, onDownloadProgressResponse.Jx);
        C0172b.m235G(parcel, C);
    }

    public OnDownloadProgressResponse ai(Parcel parcel) {
        long j = 0;
        int B = C0171a.m196B(parcel);
        int i = 0;
        long j2 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    j2 = C0171a.m214i(parcel, A);
                    break;
                case 3:
                    j = C0171a.m214i(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new OnDownloadProgressResponse(i, j2, j);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public OnDownloadProgressResponse[] be(int i) {
        return new OnDownloadProgressResponse[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return ai(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return be(x0);
    }
}
