package com.google.android.gms.cast;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import java.util.List;

public class C0143a implements Creator<ApplicationMetadata> {
    static void m113a(ApplicationMetadata applicationMetadata, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, applicationMetadata.getVersionCode());
        C0172b.m247a(parcel, 2, applicationMetadata.getApplicationId(), false);
        C0172b.m247a(parcel, 3, applicationMetadata.getName(), false);
        C0172b.m258b(parcel, 4, applicationMetadata.getImages(), false);
        C0172b.m248a(parcel, 5, applicationMetadata.zR, false);
        C0172b.m247a(parcel, 6, applicationMetadata.getSenderAppIdentifier(), false);
        C0172b.m243a(parcel, 7, applicationMetadata.dX(), i, false);
        C0172b.m235G(parcel, C);
    }

    public ApplicationMetadata[] m114M(int i) {
        return new ApplicationMetadata[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m115r(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m114M(x0);
    }

    public ApplicationMetadata m115r(Parcel parcel) {
        Uri uri = null;
        int B = C0171a.m196B(parcel);
        int i = 0;
        String str = null;
        List list = null;
        List list2 = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 4:
                    list2 = C0171a.m207c(parcel, A, WebImage.CREATOR);
                    break;
                case 5:
                    list = C0171a.m197B(parcel, A);
                    break;
                case 6:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 7:
                    uri = (Uri) C0171a.m201a(parcel, A, Uri.CREATOR);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new ApplicationMetadata(i, str3, str2, list2, list, str, uri);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }
}
