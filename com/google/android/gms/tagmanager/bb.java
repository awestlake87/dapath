package com.google.android.gms.tagmanager;

import android.util.LruCache;
import com.google.android.gms.tagmanager.C0480l.C0479a;

class bb<K, V> implements C0478k<K, V> {
    private LruCache<K, V> agc;

    bb(int i, final C0479a<K, V> c0479a) {
        this.agc = new LruCache<K, V>(this, i) {
            final /* synthetic */ bb age;

            protected int sizeOf(K key, V value) {
                return c0479a.sizeOf(key, value);
            }
        };
    }

    public void mo2300e(K k, V v) {
        this.agc.put(k, v);
    }

    public V get(K key) {
        return this.agc.get(key);
    }
}
