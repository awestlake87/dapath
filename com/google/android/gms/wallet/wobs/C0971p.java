package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class C0971p implements SafeParcelable {
    public static final Creator<C0971p> CREATOR = new C0529q();
    String akZ;
    C0969l ald;
    C0970n ale;
    C0970n alf;
    String qe;
    private final int xM;

    C0971p() {
        this.xM = 1;
    }

    C0971p(int i, String str, String str2, C0969l c0969l, C0970n c0970n, C0970n c0970n2) {
        this.xM = i;
        this.akZ = str;
        this.qe = str2;
        this.ald = c0969l;
        this.ale = c0970n;
        this.alf = c0970n2;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0529q.m1795a(this, dest, flags);
    }
}
