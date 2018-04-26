package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class C0970n implements SafeParcelable {
    public static final Creator<C0970n> CREATOR = new C0528o();
    String alc;
    String description;
    private final int xM;

    C0970n() {
        this.xM = 1;
    }

    C0970n(int i, String str, String str2) {
        this.xM = i;
        this.alc = str;
        this.description = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0528o.m1794a(this, dest, flags);
    }
}
