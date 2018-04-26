package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DisconnectRequest implements SafeParcelable {
    public static final Creator<DisconnectRequest> CREATOR = new C0195o();
    final int xM;

    public DisconnectRequest() {
        this(1);
    }

    DisconnectRequest(int versionCode) {
        this.xM = versionCode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0195o.m358a(this, dest, flags);
    }
}
