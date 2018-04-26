package com.google.android.gms.internal;

import java.io.IOException;

class C0793p implements C0366n {
    private lz kn;
    private byte[] ko;
    private final int kp;

    public C0793p(int i) {
        this.kp = i;
        reset();
    }

    public byte[] mo1911A() throws IOException {
        int nQ = this.kn.nQ();
        if (nQ < 0) {
            throw new IOException();
        } else if (nQ == 0) {
            return this.ko;
        } else {
            Object obj = new byte[(this.ko.length - nQ)];
            System.arraycopy(this.ko, 0, obj, 0, obj.length);
            return obj;
        }
    }

    public void mo1912b(int i, long j) throws IOException {
        this.kn.m1407b(i, j);
    }

    public void mo1913b(int i, String str) throws IOException {
        this.kn.m1408b(i, str);
    }

    public void reset() {
        this.ko = new byte[this.kp];
        this.kn = lz.m1392q(this.ko);
    }
}
