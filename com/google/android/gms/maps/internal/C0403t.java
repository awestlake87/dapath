package com.google.android.gms.maps.internal;

import android.os.Bundle;
import android.os.Parcelable;

public final class C0403t {
    private C0403t() {
    }

    public static void m1504a(Bundle bundle, String str, Parcelable parcelable) {
        bundle.setClassLoader(C0403t.class.getClassLoader());
        Bundle bundle2 = bundle.getBundle("map_state");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        bundle2.setClassLoader(C0403t.class.getClassLoader());
        bundle2.putParcelable(str, parcelable);
        bundle.putBundle("map_state", bundle2);
    }
}
