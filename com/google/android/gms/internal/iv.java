package com.google.android.gms.internal;

import java.io.IOException;

public interface iv {

    public static final class C1096a extends ma<C1096a> {
        public C1095a[] Uy;

        public static final class C1095a extends ma<C1095a> {
            private static volatile C1095a[] Uz;
            public String UA;
            public String UB;
            public int viewId;

            public C1095a() {
                iS();
            }

            public static C1095a[] iR() {
                if (Uz == null) {
                    synchronized (mc.ana) {
                        if (Uz == null) {
                            Uz = new C1095a[0];
                        }
                    }
                }
                return Uz;
            }

            public void mo1909a(lz lzVar) throws IOException {
                if (!this.UA.equals("")) {
                    lzVar.m1408b(1, this.UA);
                }
                if (!this.UB.equals("")) {
                    lzVar.m1408b(2, this.UB);
                }
                if (this.viewId != 0) {
                    lzVar.m1414p(3, this.viewId);
                }
                super.mo1909a(lzVar);
            }

            public /* synthetic */ me mo2547b(ly lyVar) throws IOException {
                return m3677o(lyVar);
            }

            protected int mo1910c() {
                int c = super.mo1910c();
                if (!this.UA.equals("")) {
                    c += lz.m1391h(1, this.UA);
                }
                if (!this.UB.equals("")) {
                    c += lz.m1391h(2, this.UB);
                }
                return this.viewId != 0 ? c + lz.m1393r(3, this.viewId) : c;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof C1095a)) {
                    return false;
                }
                C1095a c1095a = (C1095a) o;
                if (this.UA == null) {
                    if (c1095a.UA != null) {
                        return false;
                    }
                } else if (!this.UA.equals(c1095a.UA)) {
                    return false;
                }
                if (this.UB == null) {
                    if (c1095a.UB != null) {
                        return false;
                    }
                } else if (!this.UB.equals(c1095a.UB)) {
                    return false;
                }
                if (this.viewId != c1095a.viewId) {
                    return false;
                }
                if (this.amX == null || this.amX.isEmpty()) {
                    return c1095a.amX == null || c1095a.amX.isEmpty();
                } else {
                    return this.amX.equals(c1095a.amX);
                }
            }

            public int hashCode() {
                int i = 0;
                int hashCode = ((((this.UB == null ? 0 : this.UB.hashCode()) + (((this.UA == null ? 0 : this.UA.hashCode()) + 527) * 31)) * 31) + this.viewId) * 31;
                if (!(this.amX == null || this.amX.isEmpty())) {
                    i = this.amX.hashCode();
                }
                return hashCode + i;
            }

            public C1095a iS() {
                this.UA = "";
                this.UB = "";
                this.viewId = 0;
                this.amX = null;
                this.anb = -1;
                return this;
            }

            public C1095a m3677o(ly lyVar) throws IOException {
                while (true) {
                    int nB = lyVar.nB();
                    switch (nB) {
                        case 0:
                            break;
                        case 10:
                            this.UA = lyVar.readString();
                            continue;
                        case 18:
                            this.UB = lyVar.readString();
                            continue;
                        case 24:
                            this.viewId = lyVar.nE();
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

        public C1096a() {
            iQ();
        }

        public void mo1909a(lz lzVar) throws IOException {
            if (this.Uy != null && this.Uy.length > 0) {
                for (me meVar : this.Uy) {
                    if (meVar != null) {
                        lzVar.m1402a(1, meVar);
                    }
                }
            }
            super.mo1909a(lzVar);
        }

        public /* synthetic */ me mo2547b(ly lyVar) throws IOException {
            return m3681n(lyVar);
        }

        protected int mo1910c() {
            int c = super.mo1910c();
            if (this.Uy != null && this.Uy.length > 0) {
                for (me meVar : this.Uy) {
                    if (meVar != null) {
                        c += lz.m1381b(1, meVar);
                    }
                }
            }
            return c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1096a)) {
                return false;
            }
            C1096a c1096a = (C1096a) o;
            if (!mc.equals(this.Uy, c1096a.Uy)) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1096a.amX == null || c1096a.amX.isEmpty();
            } else {
                return this.amX.equals(c1096a.amX);
            }
        }

        public int hashCode() {
            int hashCode = (mc.hashCode(this.Uy) + 527) * 31;
            int hashCode2 = (this.amX == null || this.amX.isEmpty()) ? 0 : this.amX.hashCode();
            return hashCode2 + hashCode;
        }

        public C1096a iQ() {
            this.Uy = C1095a.iR();
            this.amX = null;
            this.anb = -1;
            return this;
        }

        public C1096a m3681n(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                switch (nB) {
                    case 0:
                        break;
                    case 10:
                        int b = mh.m1435b(lyVar, 10);
                        nB = this.Uy == null ? 0 : this.Uy.length;
                        Object obj = new C1095a[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.Uy, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1095a();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1095a();
                        lyVar.m1372a(obj[nB]);
                        this.Uy = obj;
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
