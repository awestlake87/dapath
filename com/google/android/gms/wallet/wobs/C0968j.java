package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class C0968j implements SafeParcelable {
    public static final Creator<C0968j> CREATOR = new C0526k();
    String akZ;
    String qe;
    private final int xM;

    C0968j() {
        this.xM = 1;
    }

    C0968j(int i, String str, String str2) {
        this.xM = i;
        this.akZ = str;
        this.qe = str2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0526k.m1792a(this, dest, flags);
    }
}
