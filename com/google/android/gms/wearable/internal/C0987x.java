package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class C0987x implements SafeParcelable {
    public static final Creator<C0987x> CREATOR = new C0547y();
    public final ParcelFileDescriptor alP;
    public final int statusCode;
    public final int versionCode;

    C0987x(int i, int i2, ParcelFileDescriptor parcelFileDescriptor) {
        this.versionCode = i;
        this.statusCode = i2;
        this.alP = parcelFileDescriptor;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0547y.m1854a(this, dest, flags | 1);
    }
}
