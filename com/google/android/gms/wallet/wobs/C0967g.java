package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class C0967g implements SafeParcelable {
    public static final Creator<C0967g> CREATOR = new C0524h();
    int akT;
    String akU;
    double akV;
    String akW;
    long akX;
    int akY;
    private final int xM;

    C0967g() {
        this.xM = 1;
        this.akY = -1;
        this.akT = -1;
        this.akV = -1.0d;
    }

    C0967g(int i, int i2, String str, double d, String str2, long j, int i3) {
        this.xM = i;
        this.akT = i2;
        this.akU = str;
        this.akV = d;
        this.akW = str2;
        this.akX = j;
        this.akY = i3;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0524h.m1790a(this, dest, flags);
    }
}
