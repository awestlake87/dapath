package com.google.android.gms.internal;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ds implements SafeParcelable {
    public static final dt CREATOR = new dt();
    public final ApplicationInfo applicationInfo;
    public final String kN;
    public final ev kQ;
    public final al kT;
    public final Bundle pW;
    public final ai pX;
    public final PackageInfo pY;
    public final String pZ;
    public final String qa;
    public final String qb;
    public final Bundle qc;
    public final String qd;
    public final int versionCode;

    public static final class C0306a {
        public final ApplicationInfo applicationInfo;
        public final String kN;
        public final ev kQ;
        public final al kT;
        public final Bundle pW;
        public final ai pX;
        public final PackageInfo pY;
        public final String qa;
        public final String qb;
        public final Bundle qc;

        public C0306a(Bundle bundle, ai aiVar, al alVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, ev evVar, Bundle bundle2) {
            this.pW = bundle;
            this.pX = aiVar;
            this.kT = alVar;
            this.kN = str;
            this.applicationInfo = applicationInfo;
            this.pY = packageInfo;
            this.qa = str2;
            this.qb = str3;
            this.kQ = evVar;
            this.qc = bundle2;
        }
    }

    ds(int i, Bundle bundle, ai aiVar, al alVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, ev evVar, Bundle bundle2, String str5) {
        this.versionCode = i;
        this.pW = bundle;
        this.pX = aiVar;
        this.kT = alVar;
        this.kN = str;
        this.applicationInfo = applicationInfo;
        this.pY = packageInfo;
        this.pZ = str2;
        this.qa = str3;
        this.qb = str4;
        this.kQ = evVar;
        this.qc = bundle2;
        this.qd = str5;
    }

    public ds(Bundle bundle, ai aiVar, al alVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, ev evVar, Bundle bundle2, String str5) {
        this(3, bundle, aiVar, alVar, str, applicationInfo, packageInfo, str2, str3, str4, evVar, bundle2, str5);
    }

    public ds(C0306a c0306a, String str, String str2) {
        this(c0306a.pW, c0306a.pX, c0306a.kT, c0306a.kN, c0306a.applicationInfo, c0306a.pY, str, c0306a.qa, c0306a.qb, c0306a.kQ, c0306a.qc, str2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        dt.m909a(this, out, flags);
    }
}
