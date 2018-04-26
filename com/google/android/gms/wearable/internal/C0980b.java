package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.ac.C0977a;

public class C0980b implements SafeParcelable {
    public static final Creator<C0980b> CREATOR = new C0540c();
    public final IntentFilter[] alA;
    public final ac alz;
    final int xM;

    C0980b(int i, IBinder iBinder, IntentFilter[] intentFilterArr) {
        this.xM = i;
        if (iBinder != null) {
            this.alz = C0977a.bx(iBinder);
        } else {
            this.alz = null;
        }
        this.alA = intentFilterArr;
    }

    public C0980b(av avVar) {
        this.xM = 1;
        this.alz = avVar;
        this.alA = avVar.nu();
    }

    public int describeContents() {
        return 0;
    }

    IBinder no() {
        return this.alz == null ? null : this.alz.asBinder();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0540c.m1847a(this, dest, flags);
    }
}
