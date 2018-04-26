package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0536a implements Creator<Asset> {
    static void m1804a(Asset asset, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, asset.xM);
        C0172b.m251a(parcel, 2, asset.getData(), false);
        C0172b.m247a(parcel, 3, asset.getDigest(), false);
        C0172b.m243a(parcel, 4, asset.alh, i, false);
        C0172b.m243a(parcel, 5, asset.uri, i, false);
        C0172b.m235G(parcel, C);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return cs(x0);
    }

    public Asset cs(Parcel parcel) {
        Uri uri = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        String str = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    bArr = C0171a.m223r(parcel, A);
                    break;
                case 3:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 4:
                    parcelFileDescriptor = (ParcelFileDescriptor) C0171a.m201a(parcel, A, ParcelFileDescriptor.CREATOR);
                    break;
                case 5:
                    uri = (Uri) C0171a.m201a(parcel, A, Uri.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new Asset(i, bArr, str, parcelFileDescriptor, uri);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }

    public Asset[] ea(int i) {
        return new Asset[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ea(x0);
    }
}
