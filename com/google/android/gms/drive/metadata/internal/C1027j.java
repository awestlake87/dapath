package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.C0625a;
import java.util.Collection;

public abstract class C1027j<T extends Parcelable> extends C0625a<T> {
    public C1027j(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    protected void m3246a(Bundle bundle, T t) {
        bundle.putParcelable(getName(), t);
    }

    protected /* synthetic */ Object mo2569f(Bundle bundle) {
        return m3249l(bundle);
    }

    protected T m3249l(Bundle bundle) {
        return bundle.getParcelable(getName());
    }
}
