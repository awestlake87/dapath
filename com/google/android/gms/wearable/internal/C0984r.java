package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.C0973c;

public class C0984r implements SafeParcelable {
    public static final Creator<C0984r> CREATOR = new C0544s();
    public final C0973c alM;
    public final int statusCode;
    public final int versionCode;

    C0984r(int i, int i2, C0973c c0973c) {
        this.versionCode = i;
        this.statusCode = i2;
        this.alM = c0973c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0544s.m1851a(this, dest, flags);
    }
}
