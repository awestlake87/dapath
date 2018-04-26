package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class C0969l implements SafeParcelable {
    public static final Creator<C0969l> CREATOR = new C0527m();
    long ala;
    long alb;
    private final int xM;

    C0969l() {
        this.xM = 1;
    }

    C0969l(int i, long j, long j2) {
        this.xM = i;
        this.ala = j;
        this.alb = j2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0527m.m1793a(this, dest, flags);
    }
}
