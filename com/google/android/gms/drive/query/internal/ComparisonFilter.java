package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;

public class ComparisonFilter<T> implements SafeParcelable, Filter {
    public static final C0210a CREATOR = new C0210a();
    final Operator KL;
    final MetadataBundle KM;
    final MetadataField<T> KN;
    final int xM;

    ComparisonFilter(int versionCode, Operator operator, MetadataBundle value) {
        this.xM = versionCode;
        this.KL = operator;
        this.KM = value;
        this.KN = C0214e.m377b(value);
    }

    public ComparisonFilter(Operator operator, SearchableMetadataField<T> field, T value) {
        this(1, operator, MetadataBundle.m2083a(field, value));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0210a.m373a(this, out, flags);
    }
}
