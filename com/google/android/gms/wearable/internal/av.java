package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.internal.ac.C0977a;

public class av extends C0977a {
    private final DataListener aml;
    private final MessageListener amm;
    private final NodeListener amn;
    private final IntentFilter[] amo;

    public av(DataListener dataListener, MessageListener messageListener, NodeListener nodeListener, IntentFilter[] intentFilterArr) {
        this.aml = dataListener;
        this.amm = messageListener;
        this.amn = nodeListener;
        this.amo = intentFilterArr;
    }

    public static av m3895a(DataListener dataListener, IntentFilter[] intentFilterArr) {
        return new av(dataListener, null, null, intentFilterArr);
    }

    public static av m3896a(MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return new av(null, messageListener, null, intentFilterArr);
    }

    public static av m3897a(NodeListener nodeListener) {
        return new av(null, null, nodeListener, null);
    }

    public void mo2379Y(DataHolder dataHolder) {
        if (this.aml != null) {
            try {
                this.aml.onDataChanged(new DataEventBuffer(dataHolder));
            } finally {
                dataHolder.close();
            }
        } else {
            dataHolder.close();
        }
    }

    public void mo2380a(af afVar) {
        if (this.amm != null) {
            this.amm.onMessageReceived(afVar);
        }
    }

    public void mo2381a(ai aiVar) {
        if (this.amn != null) {
            this.amn.onPeerConnected(aiVar);
        }
    }

    public void mo2382b(ai aiVar) {
        if (this.amn != null) {
            this.amn.onPeerDisconnected(aiVar);
        }
    }

    public IntentFilter[] nu() {
        return this.amo;
    }
}
