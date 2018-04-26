package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0173c;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;

public class PlusCommonExtras implements SafeParcelable {
    public static final C0433f CREATOR = new C0433f();
    public static String TAG = "PlusCommonExtras";
    private String abQ;
    private String abR;
    private final int xM;

    public PlusCommonExtras() {
        this.xM = 1;
        this.abQ = "";
        this.abR = "";
    }

    PlusCommonExtras(int versionCode, String gpsrc, String clientCallingPackage) {
        this.xM = versionCode;
        this.abQ = gpsrc;
        this.abR = clientCallingPackage;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlusCommonExtras)) {
            return false;
        }
        PlusCommonExtras plusCommonExtras = (PlusCommonExtras) obj;
        return this.xM == plusCommonExtras.xM && hk.equal(this.abQ, plusCommonExtras.abQ) && hk.equal(this.abR, plusCommonExtras.abR);
    }

    public int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return hk.hashCode(Integer.valueOf(this.xM), this.abQ, this.abR);
    }

    public String jX() {
        return this.abQ;
    }

    public String jY() {
        return this.abR;
    }

    public void m2903n(Bundle bundle) {
        bundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", C0173c.m261a(this));
    }

    public String toString() {
        return hk.m1221e(this).m1220a("versionCode", Integer.valueOf(this.xM)).m1220a("Gpsrc", this.abQ).m1220a("ClientCallingPackage", this.abR).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C0433f.m1579a(this, out, flags);
    }
}
