package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0625a;

public class C1028l extends C0625a<String> {
    public C1028l(String str, int i) {
        super(str, i);
    }

    protected void m3251a(Bundle bundle, String str) {
        bundle.putString(getName(), str);
    }

    protected /* synthetic */ Object mo2567b(DataHolder dataHolder, int i, int i2) {
        return m3254h(dataHolder, i, i2);
    }

    protected /* synthetic */ Object mo2569f(Bundle bundle) {
        return m3255m(bundle);
    }

    protected String m3254h(DataHolder dataHolder, int i, int i2) {
        return dataHolder.m2012c(getName(), i, i2);
    }

    protected String m3255m(Bundle bundle) {
        return bundle.getString(getName());
    }
}
