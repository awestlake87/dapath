package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;

public class C0145c implements Creator<LaunchOptions> {
    static void m119a(LaunchOptions launchOptions, Parcel parcel, int i) {
        int C = C0172b.m232C(parcel);
        C0172b.m259c(parcel, 1, launchOptions.getVersionCode());
        C0172b.m250a(parcel, 2, launchOptions.getRelaunchIfRunning());
        C0172b.m247a(parcel, 3, launchOptions.getLanguage(), false);
        C0172b.m235G(parcel, C);
    }

    public LaunchOptions[] m120Q(int i) {
        return new LaunchOptions[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m121t(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m120Q(x0);
    }

    public LaunchOptions m121t(Parcel parcel) {
        boolean z = false;
        int B = C0171a.m196B(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            switch (C0171a.ar(A)) {
                case 1:
                    i = C0171a.m212g(parcel, A);
                    break;
                case 2:
                    z = C0171a.m208c(parcel, A);
                    break;
                case 3:
                    str = C0171a.m220o(parcel, A);
                    break;
                default:
                    C0171a.m205b(parcel, A);
                    break;
            }
        }
        if (parcel.dataPosition() == B) {
            return new LaunchOptions(i, z, str);
        }
        throw new C0170a("Overread allowed size end=" + B, parcel);
    }
}
