package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;

public class HasFilter<T> implements SafeParcelable, Filter {
    public static final C0215f CREATOR = new C0215f();
    final MetadataBundle KM;
    final MetadataField<T> KN;
    final int xM;

    HasFilter(int versionCode, MetadataBundle value) {
        this.xM = versionCode;
        this.KM = value;
        this.KN = C0214e.m377b(value);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0215f.m378a(this, out, flags);
    }
}
