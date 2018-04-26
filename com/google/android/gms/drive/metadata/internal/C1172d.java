package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.C1023d;
import java.util.Date;

public class C1172d extends C1023d<Date> {
    public C1172d(String str, int i) {
        super(str, i);
    }

    protected void m3925a(Bundle bundle, Date date) {
        bundle.putLong(getName(), date.getTime());
    }

    protected /* synthetic */ Object mo2567b(DataHolder dataHolder, int i, int i2) {
        return m3927e(dataHolder, i, i2);
    }

    protected Date m3927e(DataHolder dataHolder, int i, int i2) {
        return new Date(dataHolder.m2008a(getName(), i, i2));
    }

    protected /* synthetic */ Object mo2569f(Bundle bundle) {
        return m3929h(bundle);
    }

    protected Date m3929h(Bundle bundle) {
        return new Date(bundle.getLong(getName()));
    }
}
