package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.C0252d.C0661a;
import com.google.android.gms.dynamic.C1030e;

public final class cq implements SafeParcelable {
    public static final cp CREATOR = new cp();
    public final dg kX;
    public final cz kZ;
    public final db oT;
    public final Context oU;
    public final int versionCode;

    cq(int i, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4) {
        this.versionCode = i;
        this.kX = (dg) C1030e.m3259e(C0661a.ag(iBinder));
        this.kZ = (cz) C1030e.m3259e(C0661a.ag(iBinder2));
        this.oT = (db) C1030e.m3259e(C0661a.ag(iBinder3));
        this.oU = (Context) C1030e.m3259e(C0661a.ag(iBinder4));
    }

    public cq(db dbVar, dg dgVar, cz czVar, Context context) {
        this.versionCode = 1;
        this.oT = dbVar;
        this.kX = dgVar;
        this.kZ = czVar;
        this.oU = context;
    }

    public static void m2519a(Intent intent, cq cqVar) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", cqVar);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo", bundle);
    }

    public static cq m2520b(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
            bundleExtra.setClassLoader(cq.class.getClassLoader());
            return (cq) bundleExtra.getParcelable("com.google.android.gms.ads.internal.purchase.InAppPurchaseManagerInfo");
        } catch (Exception e) {
            return null;
        }
    }

    IBinder bd() {
        return C1030e.m3260h(this.kX).asBinder();
    }

    IBinder be() {
        return C1030e.m3260h(this.kZ).asBinder();
    }

    IBinder bf() {
        return C1030e.m3260h(this.oT).asBinder();
    }

    IBinder bg() {
        return C1030e.m3260h(this.oU).asBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        cp.m867a(this, out, flags);
    }
}
