package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.C0252d.C0661a;
import com.google.android.gms.dynamic.C1030e;

public final class ch implements SafeParcelable {
    public static final cg CREATOR = new cg();
    public final ev kQ;
    public final String oA;
    public final boolean oB;
    public final String oC;
    public final cl oD;
    public final int oE;
    public final bd oF;
    public final String oG;
    public final C0799v oH;
    public final String ob;
    public final int orientation;
    public final ce ov;
    public final C0372t ow;
    public final ci ox;
    public final ex oy;
    public final ba oz;
    public final int versionCode;

    ch(int i, ce ceVar, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i2, int i3, String str3, ev evVar, IBinder iBinder6, String str4, C0799v c0799v) {
        this.versionCode = i;
        this.ov = ceVar;
        this.ow = (C0372t) C1030e.m3259e(C0661a.ag(iBinder));
        this.ox = (ci) C1030e.m3259e(C0661a.ag(iBinder2));
        this.oy = (ex) C1030e.m3259e(C0661a.ag(iBinder3));
        this.oz = (ba) C1030e.m3259e(C0661a.ag(iBinder4));
        this.oA = str;
        this.oB = z;
        this.oC = str2;
        this.oD = (cl) C1030e.m3259e(C0661a.ag(iBinder5));
        this.orientation = i2;
        this.oE = i3;
        this.ob = str3;
        this.kQ = evVar;
        this.oF = (bd) C1030e.m3259e(C0661a.ag(iBinder6));
        this.oG = str4;
        this.oH = c0799v;
    }

    public ch(ce ceVar, C0372t c0372t, ci ciVar, cl clVar, ev evVar) {
        this.versionCode = 4;
        this.ov = ceVar;
        this.ow = c0372t;
        this.ox = ciVar;
        this.oy = null;
        this.oz = null;
        this.oA = null;
        this.oB = false;
        this.oC = null;
        this.oD = clVar;
        this.orientation = -1;
        this.oE = 4;
        this.ob = null;
        this.kQ = evVar;
        this.oF = null;
        this.oG = null;
        this.oH = null;
    }

    public ch(C0372t c0372t, ci ciVar, ba baVar, cl clVar, ex exVar, boolean z, int i, String str, ev evVar, bd bdVar) {
        this.versionCode = 4;
        this.ov = null;
        this.ow = c0372t;
        this.ox = ciVar;
        this.oy = exVar;
        this.oz = baVar;
        this.oA = null;
        this.oB = z;
        this.oC = null;
        this.oD = clVar;
        this.orientation = i;
        this.oE = 3;
        this.ob = str;
        this.kQ = evVar;
        this.oF = bdVar;
        this.oG = null;
        this.oH = null;
    }

    public ch(C0372t c0372t, ci ciVar, ba baVar, cl clVar, ex exVar, boolean z, int i, String str, String str2, ev evVar, bd bdVar) {
        this.versionCode = 4;
        this.ov = null;
        this.ow = c0372t;
        this.ox = ciVar;
        this.oy = exVar;
        this.oz = baVar;
        this.oA = str2;
        this.oB = z;
        this.oC = str;
        this.oD = clVar;
        this.orientation = i;
        this.oE = 3;
        this.ob = null;
        this.kQ = evVar;
        this.oF = bdVar;
        this.oG = null;
        this.oH = null;
    }

    public ch(C0372t c0372t, ci ciVar, cl clVar, ex exVar, int i, ev evVar, String str, C0799v c0799v) {
        this.versionCode = 4;
        this.ov = null;
        this.ow = c0372t;
        this.ox = ciVar;
        this.oy = exVar;
        this.oz = null;
        this.oA = null;
        this.oB = false;
        this.oC = null;
        this.oD = clVar;
        this.orientation = i;
        this.oE = 1;
        this.ob = null;
        this.kQ = evVar;
        this.oF = null;
        this.oG = str;
        this.oH = c0799v;
    }

    public ch(C0372t c0372t, ci ciVar, cl clVar, ex exVar, boolean z, int i, ev evVar) {
        this.versionCode = 4;
        this.ov = null;
        this.ow = c0372t;
        this.ox = ciVar;
        this.oy = exVar;
        this.oz = null;
        this.oA = null;
        this.oB = z;
        this.oC = null;
        this.oD = clVar;
        this.orientation = i;
        this.oE = 2;
        this.ob = null;
        this.kQ = evVar;
        this.oF = null;
        this.oG = null;
        this.oH = null;
    }

    public static ch m2508a(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(ch.class.getClassLoader());
            return (ch) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            return null;
        }
    }

    public static void m2509a(Intent intent, ch chVar) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", chVar);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    IBinder aU() {
        return C1030e.m3260h(this.ow).asBinder();
    }

    IBinder aV() {
        return C1030e.m3260h(this.ox).asBinder();
    }

    IBinder aW() {
        return C1030e.m3260h(this.oy).asBinder();
    }

    IBinder aX() {
        return C1030e.m3260h(this.oz).asBinder();
    }

    IBinder aY() {
        return C1030e.m3260h(this.oF).asBinder();
    }

    IBinder aZ() {
        return C1030e.m3260h(this.oD).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        cg.m851a(this, out, flags);
    }
}
