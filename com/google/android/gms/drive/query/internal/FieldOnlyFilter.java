package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filter;

public class FieldOnlyFilter implements SafeParcelable, Filter {
    public static final Creator<FieldOnlyFilter> CREATOR = new C0211b();
    final MetadataBundle KM;
    private final MetadataField<?> KN;
    final int xM;

    FieldOnlyFilter(int versionCode, MetadataBundle value) {
        this.xM = versionCode;
        this.KM = value;
        this.KN = C0214e.m377b(value);
    }

    public FieldOnlyFilter(SearchableMetadataField<?> field) {
        this(1, MetadataBundle.m2083a(field, null));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        C0211b.m374a(this, out, flags);
    }
}
