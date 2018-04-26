package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C0625a;

public class C1025f extends C0625a<Integer> {
    public C1025f(String str, int i) {
        super(str, i);
    }

    protected void m3234a(Bundle bundle, Integer num) {
        bundle.putInt(getName(), num.intValue());
    }

    protected /* synthetic */ Object mo2567b(DataHolder dataHolder, int i, int i2) {
        return m3237f(dataHolder, i, i2);
    }

    protected Integer m3237f(DataHolder dataHolder, int i, int i2) {
        return Integer.valueOf(dataHolder.m2010b(getName(), i, i2));
    }

    protected /* synthetic */ Object mo2569f(Bundle bundle) {
        return m3239i(bundle);
    }

    protected Integer m3239i(Bundle bundle) {
        return Integer.valueOf(bundle.getInt(getName()));
    }
}
