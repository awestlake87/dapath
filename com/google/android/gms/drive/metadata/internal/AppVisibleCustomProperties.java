package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.internal.hm;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppVisibleCustomProperties implements SafeParcelable, Iterable<CustomProperty> {
    public static final Creator<AppVisibleCustomProperties> CREATOR = new C0203a();
    public static final AppVisibleCustomProperties JN = new C0202a().gD();
    final List<CustomProperty> JO;
    final int xM;

    public static class C0202a {
        private final Map<CustomPropertyKey, CustomProperty> JP = new HashMap();

        public AppVisibleCustomProperties gD() {
            return new AppVisibleCustomProperties(this.JP.values());
        }
    }

    AppVisibleCustomProperties(int versionCode, Collection<CustomProperty> properties) {
        this.xM = versionCode;
        hm.m1232f(properties);
        this.JO = new ArrayList(properties);
    }

    private AppVisibleCustomProperties(Collection<CustomProperty> properties) {
        this(1, (Collection) properties);
    }

    public int describeContents() {
        return 0;
    }

    public Iterator<CustomProperty> iterator() {
        return this.JO.iterator();
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0203a.m367a(this, dest, flags);
    }
}
