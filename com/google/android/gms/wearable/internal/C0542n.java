package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0542n implements Creator<C1158m> {
    static void m1849a(C1158m c1158m, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, c1158m.xM);
        C0172b.m243a(parcel, 2, c1158m.getUri(), i, false);
        C0172b.m240a(parcel, 4, c1158m.nm(), false);
        C0172b.m251a(parcel, 5, c1158m.getData(), false);
        C0172b.m235G(parcel, C);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cx(x0);
    }

    public C1158m cx(Parcel parcel) {
        byte[] bArr = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        Bundle bundle = null;
        Uri uri = null;
        while (parcel.dataPosition() < B) {
            Bundle bundle2;
            Uri uri2;
            int g;
            byte[] bArr2;
            int A = C0171a.m194A(parcel);
            byte[] bArr3;
            switch (C0171a.ar(A)) {
                case 1:
                    bArr3 = bArr;
                    bundle2 = bundle;
                    uri2 = uri;
                    g = C0171a.m212g(parcel, A);
                    bArr2 = bArr3;
                    break;
                case 2:
                    g = i;
                    Bundle bundle3 = bundle;
                    uri2 = (Uri) C0171a.m201a(parcel, A, Uri.CREATOR);
                    bArr2 = bArr;
                    bundle2 = bundle3;
                    break;
                case 4:
                    uri2 = uri;
                    g = i;
                    bArr3 = bArr;
                    bundle2 = C0171a.m222q(parcel, A);
                    bArr2 = bArr3;
                    break;
                case 5:
                    bArr2 = C0171a.m223r(parcel, A);
                    bundle2 = bundle;
                    uri2 = uri;
                    g = i;
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    bArr2 = bArr;
                    bundle2 = bundle;
                    uri2 = uri;
                    g = i;
                    break;
            }
            i = g;
            uri = uri2;
            bundle = bundle2;
            bArr = bArr2;
        }
        if (parcel.dataPosition() == B) {
            return new C1158m(i, uri, bundle, bArr);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public C1158m[] eg(int i) {
        return new C1158m[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return eg(x0);
    }
}
