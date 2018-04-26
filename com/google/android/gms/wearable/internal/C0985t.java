package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class C0985t implements SafeParcelable {
    public static final Creator<C0985t> CREATOR = new C0545u();
    public final List<ai> alN;
    public final int statusCode;
    public final int versionCode;

    C0985t(int i, int i2, List<ai> list) {
        this.versionCode = i;
        this.statusCode = i2;
        this.alN = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0545u.m1852a(this, dest, flags);
    }
}
