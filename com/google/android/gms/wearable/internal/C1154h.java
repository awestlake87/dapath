package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.C0160d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public final class C1154h extends C0160d implements DataEvent {
    private final int RG;

    public C1154h(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.RG = i2;
    }

    public /* synthetic */ Object freeze() {
        return np();
    }

    public DataItem getDataItem() {
        return new C1159o(this.DG, this.EC, this.RG);
    }

    public int getType() {
        return getInteger("event_type");
    }

    public DataEvent np() {
        return new C1153g(this);
    }
}
