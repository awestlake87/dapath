package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class C0966f implements SafeParcelable {
    public static final Creator<C0966f> CREATOR = new C0525i();
    C0969l ajs;
    C0967g akS;
    String label;
    String type;
    private final int xM;

    C0966f() {
        this.xM = 1;
    }

    C0966f(int i, String str, C0967g c0967g, String str2, C0969l c0969l) {
        this.xM = i;
        this.label = str;
        this.akS = c0967g;
        this.type = str2;
        this.ajs = c0969l;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0525i.m1791a(this, dest, flags);
    }
}
