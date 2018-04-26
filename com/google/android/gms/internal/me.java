package com.google.android.gms.internal;

import java.io.IOException;

public abstract class me {
    protected volatile int anb = -1;

    public static final <T extends me> T m1425a(T t, byte[] bArr) throws md {
        return m1427b(t, bArr, 0, bArr.length);
    }

    public static final void m1426a(me meVar, byte[] bArr, int i, int i2) {
        try {
            lz b = lz.m1384b(bArr, i, i2);
            meVar.mo1909a(b);
            b.nR();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final <T extends me> T m1427b(T t, byte[] bArr, int i, int i2) throws md {
        try {
            ly a = ly.m1370a(bArr, i, i2);
            t.mo2547b(a);
            a.eu(0);
            return t;
        } catch (md e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final byte[] m1428d(me meVar) {
        byte[] bArr = new byte[meVar.oa()];
        m1426a(meVar, bArr, 0, bArr.length);
        return bArr;
    }

    public void mo1909a(lz lzVar) throws IOException {
    }

    public abstract me mo2547b(ly lyVar) throws IOException;

    protected int mo1910c() {
        return 0;
    }

    public int nZ() {
        if (this.anb < 0) {
            oa();
        }
        return this.anb;
    }

    public int oa() {
        int c = mo1910c();
        this.anb = c;
        return c;
    }

    public String toString() {
        return mf.m1434e(this);
    }
}
