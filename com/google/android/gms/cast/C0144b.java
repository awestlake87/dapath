package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import java.util.List;

public class C0144b implements Creator<CastDevice> {
    static void m116a(CastDevice castDevice, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, castDevice.getVersionCode());
        C0172b.m247a(parcel, 2, castDevice.getDeviceId(), false);
        C0172b.m247a(parcel, 3, castDevice.Ai, false);
        C0172b.m247a(parcel, 4, castDevice.getFriendlyName(), false);
        C0172b.m247a(parcel, 5, castDevice.getModelName(), false);
        C0172b.m247a(parcel, 6, castDevice.getDeviceVersion(), false);
        C0172b.m259c(parcel, 7, castDevice.getServicePort());
        C0172b.m258b(parcel, 8, castDevice.getIcons(), false);
        C0172b.m259c(parcel, 9, castDevice.getCapabilities());
        C0172b.m235G(parcel, C);
    }

    public CastDevice[] m117P(int i) {
        return new CastDevice[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m118s(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m117P(x0);
    }

    public CastDevice m118s(Parcel parcel) {
        int i = 0;
        List list = null;
        int B = C0171a.m196B(parcel);
        int i2 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i3 = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i3 = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    str5 = C0171a.m220o(parcel, A);
                    break;
                case 3:
                    str4 = C0171a.m220o(parcel, A);
                    break;
                case 4:
                    str3 = C0171a.m220o(parcel, A);
                    break;
                case 5:
                    str2 = C0171a.m220o(parcel, A);
                    break;
                case 6:
                    str = C0171a.m220o(parcel, A);
                    break;
                case 7:
                    i2 = C0171a.m212g(parcel, A);
                    break;
                case 8:
                    list = C0171a.m207c(parcel, A, WebImage.CREATOR);
                    break;
                case 9:
                    i = C0171a.m212g(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new CastDevice(i3, str5, str4, str3, str2, str, i2, list, i);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }
}
