package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcel;

public final class C0173c {
    public static <T extends SafeParcelable> byte[] m261a(T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
