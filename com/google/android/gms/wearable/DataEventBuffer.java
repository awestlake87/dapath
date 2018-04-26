package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.C1006g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.C1154h;

public class DataEventBuffer extends C1006g<DataEvent> implements Result {
    private final Status yz;

    public DataEventBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.yz = new Status(dataHolder.getStatusCode());
    }

    protected /* synthetic */ Object mo3142c(int i, int i2) {
        return m4096m(i, i2);
    }

    protected String eZ() {
        return "path";
    }

    public Status getStatus() {
        return this.yz;
    }

    protected DataEvent m4096m(int i, int i2) {
        return new C1154h(this.DG, i, i2);
    }
}
