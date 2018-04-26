package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0169b implements Creator<WebImage> {
    static void m192a(WebImage webImage, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, webImage.getVersionCode());
        C0172b.m243a(parcel, 2, webImage.getUrl(), i, false);
        C0172b.m259c(parcel, 3, webImage.getWidth());
        C0172b.m259c(parcel, 4, webImage.getHeight());
        C0172b.m235G(parcel, C);
    }

    public WebImage[] ak(int i) {
        return new WebImage[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m193y(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ak(x0);
    }

    public WebImage m193y(Parcel parcel) {
        int i = 0;
        int B = C0171a.m196B(parcel);
        Uri uri = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            Uri uri2;
            int g;
            int A = C0171a.m194A(parcel);
            int i4;
            switch (C0171a.ar(A)) {
                case 1:
                    i4 = i;
                    i = i2;
                    uri2 = uri;
                    g = C0171a.m212g(parcel, A);
                    A = i4;
                    break;
                case 2:
                    g = i3;
                    i4 = i2;
                    uri2 = (Uri) C0171a.m201a(parcel, A, Uri.CREATOR);
                    A = i;
                    i = i4;
                    break;
                case 3:
                    uri2 = uri;
                    g = i3;
                    i4 = i;
                    i = C0171a.m212g(parcel, A);
                    A = i4;
                    break;
                case 4:
                    A = C0171a.m212g(parcel, A);
                    i = i2;
                    uri2 = uri;
                    g = i3;
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    A = i;
                    i = i2;
                    uri2 = uri;
                    g = i3;
                    break;
            }
            i3 = g;
            uri = uri2;
            i2 = i;
            i = A;
        }
        if (parcel.dataPosition() == B) {
            return new WebImage(i3, uri, i2, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }
}
