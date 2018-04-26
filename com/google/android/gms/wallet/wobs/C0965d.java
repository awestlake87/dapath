package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ig;
import java.util.ArrayList;

public final class C0965d implements SafeParcelable {
    public static final Creator<C0965d> CREATOR = new C0523e();
    String akP;
    String akQ;
    ArrayList<C0964b> akR;
    private final int xM;

    C0965d() {
        this.xM = 1;
        this.akR = ig.ga();
    }

    C0965d(int i, String str, String str2, ArrayList<C0964b> arrayList) {
        this.xM = i;
        this.akP = str;
        this.akQ = str2;
        this.akR = arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0523e.m1789a(this, dest, flags);
    }
}
