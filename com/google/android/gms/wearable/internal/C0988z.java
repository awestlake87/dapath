package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class C0988z implements SafeParcelable {
    public static final Creator<C0988z> CREATOR = new aa();
    public final ai alQ;
    public final int statusCode;
    public final int versionCode;

    C0988z(int i, int i2, ai aiVar) {
        this.versionCode = i;
        this.statusCode = i2;
        this.alQ = aiVar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        aa.m1807a(this, dest, flags);
    }
}
