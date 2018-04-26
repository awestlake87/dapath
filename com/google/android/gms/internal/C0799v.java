package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class C0799v implements SafeParcelable {
    public static final C0376w CREATOR = new C0376w();
    public final boolean lb;
    public final boolean ld;
    public final int versionCode;

    C0799v(int i, boolean z, boolean z2) {
        this.versionCode = i;
        this.lb = z;
        this.ld = z2;
    }

    public C0799v(boolean z, boolean z2) {
        this.versionCode = 1;
        this.lb = z;
        this.ld = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0376w.m1467a(this, out, flags);
    }
}
