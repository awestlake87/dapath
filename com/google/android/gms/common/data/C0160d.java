package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hm;

public abstract class C0160d {
    protected final DataHolder DG;
    protected int EC;
    private int ED;

    public C0160d(DataHolder dataHolder, int i) {
        this.DG = (DataHolder) hm.m1232f(dataHolder);
        ac(i);
    }

    protected void m164a(String str, CharArrayBuffer charArrayBuffer) {
        this.DG.m2009a(str, this.EC, this.ED, charArrayBuffer);
    }

    protected void ac(int i) {
        boolean z = i >= 0 && i < this.DG.getCount();
        hm.m1224A(z);
        this.EC = i;
        this.ED = this.DG.ae(this.EC);
    }

    public boolean av(String str) {
        return this.DG.av(str);
    }

    protected Uri aw(String str) {
        return this.DG.m2016g(str, this.EC, this.ED);
    }

    protected boolean ax(String str) {
        return this.DG.m2017h(str, this.EC, this.ED);
    }

    protected int eV() {
        return this.EC;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0160d)) {
            return false;
        }
        C0160d c0160d = (C0160d) obj;
        return hk.equal(Integer.valueOf(c0160d.EC), Integer.valueOf(this.EC)) && hk.equal(Integer.valueOf(c0160d.ED), Integer.valueOf(this.ED)) && c0160d.DG == this.DG;
    }

    protected boolean getBoolean(String column) {
        return this.DG.m2013d(column, this.EC, this.ED);
    }

    protected byte[] getByteArray(String column) {
        return this.DG.m2015f(column, this.EC, this.ED);
    }

    protected float getFloat(String column) {
        return this.DG.m2014e(column, this.EC, this.ED);
    }

    protected int getInteger(String column) {
        return this.DG.m2010b(column, this.EC, this.ED);
    }

    protected long getLong(String column) {
        return this.DG.m2008a(column, this.EC, this.ED);
    }

    protected String getString(String column) {
        return this.DG.m2012c(column, this.EC, this.ED);
    }

    public int hashCode() {
        return hk.hashCode(Integer.valueOf(this.EC), Integer.valueOf(this.ED), this.DG);
    }

    public boolean isDataValid() {
        return !this.DG.isClosed();
    }
}
