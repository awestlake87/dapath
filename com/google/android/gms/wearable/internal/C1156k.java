package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.C0160d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItemAsset;

public class C1156k extends C0160d implements DataItemAsset {
    public C1156k(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public /* synthetic */ Object freeze() {
        return nq();
    }

    public String getDataItemKey() {
        return getString("asset_key");
    }

    public String getId() {
        return getString("asset_id");
    }

    public DataItemAsset nq() {
        return new C1155i(this);
    }
}
