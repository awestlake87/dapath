package com.google.android.gms.internal;

import com.google.android.gms.internal.C0276c.C1077f;
import com.google.android.gms.internal.C0276c.C1081j;
import java.io.IOException;

public interface le {

    public static final class C1114a extends ma<C1114a> {
        public long aiG;
        public C1081j aiH;
        public C1077f fK;

        public C1114a() {
            nf();
        }

        public static C1114a m3720l(byte[] bArr) throws md {
            return (C1114a) me.m1425a(new C1114a(), bArr);
        }

        public void mo1909a(lz lzVar) throws IOException {
            lzVar.m1407b(1, this.aiG);
            if (this.fK != null) {
                lzVar.m1402a(2, this.fK);
            }
            if (this.aiH != null) {
                lzVar.m1402a(3, this.aiH);
            }
            super.mo1909a(lzVar);
        }

        public /* synthetic */ me mo2547b(ly lyVar) throws IOException {
            return m3724p(lyVar);
        }

        protected int mo1910c() {
            int c = super.mo1910c() + lz.m1387d(1, this.aiG);
            if (this.fK != null) {
                c += lz.m1381b(2, this.fK);
            }
            return this.aiH != null ? c + lz.m1381b(3, this.aiH) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1114a)) {
                return false;
            }
            C1114a c1114a = (C1114a) o;
            if (this.aiG != c1114a.aiG) {
                return false;
            }
            if (this.fK == null) {
                if (c1114a.fK != null) {
                    return false;
                }
            } else if (!this.fK.equals(c1114a.fK)) {
                return false;
            }
            if (this.aiH == null) {
                if (c1114a.aiH != null) {
                    return false;
                }
            } else if (!this.aiH.equals(c1114a.aiH)) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1114a.amX == null || c1114a.amX.isEmpty();
            } else {
                return this.amX.equals(c1114a.amX);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.aiH == null ? 0 : this.aiH.hashCode()) + (((this.fK == null ? 0 : this.fK.hashCode()) + ((((int) (this.aiG ^ (this.aiG >>> 32))) + 527) * 31)) * 31)) * 31;
            if (!(this.amX == null || this.amX.isEmpty())) {
                i = this.amX.hashCode();
            }
            return hashCode + i;
        }

        public C1114a nf() {
            this.aiG = 0;
            this.fK = null;
            this.aiH = null;
            this.amX = null;
            this.anb = -1;
            return this;
        }

        public C1114a m3724p(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                switch (nB) {
                    case 0:
                        break;
                    case 8:
                        this.aiG = lyVar.nD();
                        continue;
                    case 18:
                        if (this.fK == null) {
                            this.fK = new C1077f();
                        }
                        lyVar.m1372a(this.fK);
                        continue;
                    case 26:
                        if (this.aiH == null) {
                            this.aiH = new C1081j();
                        }
                        lyVar.m1372a(this.aiH);
                        continue;
                    default:
                        if (!m2813a(lyVar, nB)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }
    }
}
