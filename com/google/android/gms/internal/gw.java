package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;

public final class gw extends hq<C0343a, Drawable> {

    public static final class C0343a {
        public final int FS;
        public final int FT;

        public C0343a(int i, int i2) {
            this.FS = i;
            this.FT = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0343a)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            C0343a c0343a = (C0343a) obj;
            return c0343a.FS == this.FS && c0343a.FT == this.FT;
        }

        public int hashCode() {
            return hk.hashCode(Integer.valueOf(this.FS), Integer.valueOf(this.FT));
        }
    }

    public gw() {
        super(10);
    }
}
