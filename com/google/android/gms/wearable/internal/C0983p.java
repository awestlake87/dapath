package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class C0983p implements SafeParcelable {
    public static final Creator<C0983p> CREATOR = new C0543q();
    public final int alL;
    public final int statusCode;
    public final int versionCode;

    C0983p(int i, int i2, int i3) {
        this.versionCode = i;
        this.statusCode = i2;
        this.alL = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0543q.m1850a(this, dest, flags);
    }
}
