package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class am implements SafeParcelable {
    public static final Creator<am> CREATOR = new an();
    public final C1158m alO;
    public final int statusCode;
    public final int versionCode;

    am(int i, int i2, C1158m c1158m) {
        this.versionCode = i;
        this.statusCode = i2;
        this.alO = c1158m;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        an.m1843a(this, dest, flags);
    }
}
