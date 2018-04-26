package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.C0480l.C0479a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class cz<K, V> implements C0478k<K, V> {
    private final Map<K, V> ahX = new HashMap();
    private final int ahY;
    private final C0479a<K, V> ahZ;
    private int aia;

    cz(int i, C0479a<K, V> c0479a) {
        this.ahY = i;
        this.ahZ = c0479a;
    }

    public synchronized void mo2300e(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        this.aia += this.ahZ.sizeOf(k, v);
        if (this.aia > this.ahY) {
            Iterator it = this.ahX.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                this.aia -= this.ahZ.sizeOf(entry.getKey(), entry.getValue());
                it.remove();
                if (this.aia <= this.ahY) {
                    break;
                }
            }
        }
        this.ahX.put(k, v);
    }

    public synchronized V get(K key) {
        return this.ahX.get(key);
    }
}
