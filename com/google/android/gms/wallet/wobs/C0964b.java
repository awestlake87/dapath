package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class C0964b implements SafeParcelable {
    public static final Creator<C0964b> CREATOR = new C0522c();
    String label;
    String value;
    private final int xM;

    C0964b() {
        this.xM = 1;
    }

    C0964b(int i, String str, String str2) {
        this.xM = i;
        this.label = str;
        this.value = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0522c.m1788a(this, dest, flags);
    }
}
