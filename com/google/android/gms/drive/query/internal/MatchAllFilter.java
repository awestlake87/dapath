package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

public class MatchAllFilter implements SafeParcelable, Filter {
    public static final C0218i CREATOR = new C0218i();
    final int xM;

    public MatchAllFilter() {
        this(1);
    }

    MatchAllFilter(int versionCode) {
        this.xM = versionCode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0218i.m381a(this, out, flags);
    }
}
