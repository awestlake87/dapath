package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.C1006g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.C1159o;

public class DataItemBuffer extends C1006g<DataItem> implements Result {
    private final Status yz;

    public DataItemBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.yz = new Status(dataHolder.getStatusCode());
    }

    protected /* synthetic */ Object mo3142c(int i, int i2) {
        return m4098n(i, i2);
    }

    protected String eZ() {
        return "path";
    }

    public Status getStatus() {
        return this.yz;
    }

    protected DataItem m4098n(int i, int i2) {
        return new C1159o(this.DG, i, i2);
    }
}
