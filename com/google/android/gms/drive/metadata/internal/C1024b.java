package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0625a;

public class C1024b extends C0625a<Boolean> {
    public C1024b(String str, int i) {
        super(str, i);
    }

    protected void m3228a(Bundle bundle, Boolean bool) {
        bundle.putBoolean(getName(), bool.booleanValue());
    }

    protected /* synthetic */ Object mo2567b(DataHolder dataHolder, int i, int i2) {
        return mo3145d(dataHolder, i, i2);
    }

    protected Boolean mo3145d(DataHolder dataHolder, int i, int i2) {
        return Boolean.valueOf(dataHolder.m2013d(getName(), i, i2));
    }

    protected /* synthetic */ Object mo2569f(Bundle bundle) {
        return m3233g(bundle);
    }

    protected Boolean m3233g(Bundle bundle) {
        return Boolean.valueOf(bundle.getBoolean(getName()));
    }
}
