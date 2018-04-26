package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

class C0480l<K, V> {
    final C0479a<K, V> aer = new C09421(this);

    public interface C0479a<K, V> {
        int sizeOf(K k, V v);
    }

    class C09421 implements C0479a<K, V> {
        final /* synthetic */ C0480l aes;

        C09421(C0480l c0480l) {
            this.aes = c0480l;
        }

        public int sizeOf(K k, V v) {
            return 1;
        }
    }

    public C0478k<K, V> m1743a(int i, C0479a<K, V> c0479a) {
        if (i > 0) {
            return lj() < 12 ? new cz(i, c0479a) : new bb(i, c0479a);
        } else {
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    int lj() {
        return VERSION.SDK_INT;
    }
}
