package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.data.C0160d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;

public final class C1159o extends C0160d implements DataItem {
    private final int RG;

    public C1159o(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.RG = i2;
    }

    public /* synthetic */ Object freeze() {
        return nr();
    }

    public Map<String, DataItemAsset> getAssets() {
        Map<String, DataItemAsset> hashMap = new HashMap(this.RG);
        for (int i = 0; i < this.RG; i++) {
            C1156k c1156k = new C1156k(this.DG, this.EC + i);
            if (c1156k.getDataItemKey() != null) {
                hashMap.put(c1156k.getDataItemKey(), c1156k);
            }
        }
        return hashMap;
    }

    public byte[] getData() {
        return getByteArray("data");
    }

    public Uri getUri() {
        return Uri.parse(getString("path"));
    }

    public DataItem nr() {
        return new C1157l(this);
    }

    public DataItem setData(byte[] data) {
        throw new UnsupportedOperationException();
    }
}
