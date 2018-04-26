package com.google.android.gms.internal;

import com.google.ads.AdSize;
import java.io.IOException;

public interface C0295d {

    public static final class C1082a extends ma<C1082a> {
        private static volatile C1082a[] fM;
        public String fN;
        public C1082a[] fO;
        public C1082a[] fP;
        public C1082a[] fQ;
        public String fR;
        public String fS;
        public long fT;
        public boolean fU;
        public C1082a[] fV;
        public int[] fW;
        public boolean fX;
        public int type;

        public C1082a() {
            m3579s();
        }

        public static C1082a[] m3574r() {
            if (fM == null) {
                synchronized (mc.ana) {
                    if (fM == null) {
                        fM = new C1082a[0];
                    }
                }
            }
            return fM;
        }

        public void mo1909a(lz lzVar) throws IOException {
            int i = 0;
            lzVar.m1414p(1, this.type);
            if (!this.fN.equals("")) {
                lzVar.m1408b(2, this.fN);
            }
            if (this.fO != null && this.fO.length > 0) {
                for (me meVar : this.fO) {
                    if (meVar != null) {
                        lzVar.m1402a(3, meVar);
                    }
                }
            }
            if (this.fP != null && this.fP.length > 0) {
                for (me meVar2 : this.fP) {
                    if (meVar2 != null) {
                        lzVar.m1402a(4, meVar2);
                    }
                }
            }
            if (this.fQ != null && this.fQ.length > 0) {
                for (me meVar22 : this.fQ) {
                    if (meVar22 != null) {
                        lzVar.m1402a(5, meVar22);
                    }
                }
            }
            if (!this.fR.equals("")) {
                lzVar.m1408b(6, this.fR);
            }
            if (!this.fS.equals("")) {
                lzVar.m1408b(7, this.fS);
            }
            if (this.fT != 0) {
                lzVar.m1407b(8, this.fT);
            }
            if (this.fX) {
                lzVar.m1403a(9, this.fX);
            }
            if (this.fW != null && this.fW.length > 0) {
                for (int p : this.fW) {
                    lzVar.m1414p(10, p);
                }
            }
            if (this.fV != null && this.fV.length > 0) {
                while (i < this.fV.length) {
                    me meVar3 = this.fV[i];
                    if (meVar3 != null) {
                        lzVar.m1402a(11, meVar3);
                    }
                    i++;
                }
            }
            if (this.fU) {
                lzVar.m1403a(12, this.fU);
            }
            super.mo1909a(lzVar);
        }

        public /* synthetic */ me mo2547b(ly lyVar) throws IOException {
            return m3578l(lyVar);
        }

        protected int mo1910c() {
            int i;
            int i2 = 0;
            int c = super.mo1910c() + lz.m1393r(1, this.type);
            if (!this.fN.equals("")) {
                c += lz.m1391h(2, this.fN);
            }
            if (this.fO != null && this.fO.length > 0) {
                i = c;
                for (me meVar : this.fO) {
                    if (meVar != null) {
                        i += lz.m1381b(3, meVar);
                    }
                }
                c = i;
            }
            if (this.fP != null && this.fP.length > 0) {
                i = c;
                for (me meVar2 : this.fP) {
                    if (meVar2 != null) {
                        i += lz.m1381b(4, meVar2);
                    }
                }
                c = i;
            }
            if (this.fQ != null && this.fQ.length > 0) {
                i = c;
                for (me meVar22 : this.fQ) {
                    if (meVar22 != null) {
                        i += lz.m1381b(5, meVar22);
                    }
                }
                c = i;
            }
            if (!this.fR.equals("")) {
                c += lz.m1391h(6, this.fR);
            }
            if (!this.fS.equals("")) {
                c += lz.m1391h(7, this.fS);
            }
            if (this.fT != 0) {
                c += lz.m1387d(8, this.fT);
            }
            if (this.fX) {
                c += lz.m1382b(9, this.fX);
            }
            if (this.fW != null && this.fW.length > 0) {
                int i3 = 0;
                for (int eE : this.fW) {
                    i3 += lz.eE(eE);
                }
                c = (c + i3) + (this.fW.length * 1);
            }
            if (this.fV != null && this.fV.length > 0) {
                while (i2 < this.fV.length) {
                    me meVar3 = this.fV[i2];
                    if (meVar3 != null) {
                        c += lz.m1381b(11, meVar3);
                    }
                    i2++;
                }
            }
            return this.fU ? c + lz.m1382b(12, this.fU) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1082a)) {
                return false;
            }
            C1082a c1082a = (C1082a) o;
            if (this.type != c1082a.type) {
                return false;
            }
            if (this.fN == null) {
                if (c1082a.fN != null) {
                    return false;
                }
            } else if (!this.fN.equals(c1082a.fN)) {
                return false;
            }
            if (!mc.equals(this.fO, c1082a.fO) || !mc.equals(this.fP, c1082a.fP) || !mc.equals(this.fQ, c1082a.fQ)) {
                return false;
            }
            if (this.fR == null) {
                if (c1082a.fR != null) {
                    return false;
                }
            } else if (!this.fR.equals(c1082a.fR)) {
                return false;
            }
            if (this.fS == null) {
                if (c1082a.fS != null) {
                    return false;
                }
            } else if (!this.fS.equals(c1082a.fS)) {
                return false;
            }
            if (this.fT != c1082a.fT || this.fU != c1082a.fU || !mc.equals(this.fV, c1082a.fV) || !mc.equals(this.fW, c1082a.fW) || this.fX != c1082a.fX) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1082a.amX == null || c1082a.amX.isEmpty();
            } else {
                return this.amX.equals(c1082a.amX);
            }
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((((((this.fU ? 1231 : 1237) + (((((this.fS == null ? 0 : this.fS.hashCode()) + (((this.fR == null ? 0 : this.fR.hashCode()) + (((((((((this.fN == null ? 0 : this.fN.hashCode()) + ((this.type + 527) * 31)) * 31) + mc.hashCode(this.fO)) * 31) + mc.hashCode(this.fP)) * 31) + mc.hashCode(this.fQ)) * 31)) * 31)) * 31) + ((int) (this.fT ^ (this.fT >>> 32)))) * 31)) * 31) + mc.hashCode(this.fV)) * 31) + mc.hashCode(this.fW)) * 31;
            if (!this.fX) {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (!(this.amX == null || this.amX.isEmpty())) {
                i2 = this.amX.hashCode();
            }
            return hashCode + i2;
        }

        public C1082a m3578l(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                int b;
                Object obj;
                int i;
                switch (nB) {
                    case 0:
                        break;
                    case 8:
                        nB = lyVar.nE();
                        switch (nB) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                this.type = nB;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.fN = lyVar.readString();
                        continue;
                    case 26:
                        b = mh.m1435b(lyVar, 26);
                        nB = this.fO == null ? 0 : this.fO.length;
                        obj = new C1082a[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fO, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1082a();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1082a();
                        lyVar.m1372a(obj[nB]);
                        this.fO = obj;
                        continue;
                    case 34:
                        b = mh.m1435b(lyVar, 34);
                        nB = this.fP == null ? 0 : this.fP.length;
                        obj = new C1082a[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fP, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1082a();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1082a();
                        lyVar.m1372a(obj[nB]);
                        this.fP = obj;
                        continue;
                    case 42:
                        b = mh.m1435b(lyVar, 42);
                        nB = this.fQ == null ? 0 : this.fQ.length;
                        obj = new C1082a[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fQ, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1082a();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1082a();
                        lyVar.m1372a(obj[nB]);
                        this.fQ = obj;
                        continue;
                    case 50:
                        this.fR = lyVar.readString();
                        continue;
                    case 58:
                        this.fS = lyVar.readString();
                        continue;
                    case 64:
                        this.fT = lyVar.nD();
                        continue;
                    case 72:
                        this.fX = lyVar.nF();
                        continue;
                    case 80:
                        int b2 = mh.m1435b(lyVar, 80);
                        Object obj2 = new int[b2];
                        i = 0;
                        b = 0;
                        while (i < b2) {
                            if (i != 0) {
                                lyVar.nB();
                            }
                            int nE = lyVar.nE();
                            switch (nE) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    nB = b + 1;
                                    obj2[b] = nE;
                                    break;
                                default:
                                    nB = b;
                                    break;
                            }
                            i++;
                            b = nB;
                        }
                        if (b != 0) {
                            nB = this.fW == null ? 0 : this.fW.length;
                            if (nB != 0 || b != obj2.length) {
                                Object obj3 = new int[(nB + b)];
                                if (nB != 0) {
                                    System.arraycopy(this.fW, 0, obj3, 0, nB);
                                }
                                System.arraycopy(obj2, 0, obj3, nB, b);
                                this.fW = obj3;
                                break;
                            }
                            this.fW = obj2;
                            break;
                        }
                        continue;
                    case 82:
                        i = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            switch (lyVar.nE()) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    nB++;
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (nB != 0) {
                            lyVar.ez(b);
                            b = this.fW == null ? 0 : this.fW.length;
                            Object obj4 = new int[(nB + b)];
                            if (b != 0) {
                                System.arraycopy(this.fW, 0, obj4, 0, b);
                            }
                            while (lyVar.nN() > 0) {
                                int nE2 = lyVar.nE();
                                switch (nE2) {
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 16:
                                    case 17:
                                        nB = b + 1;
                                        obj4[b] = nE2;
                                        b = nB;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            this.fW = obj4;
                        }
                        lyVar.ey(i);
                        continue;
                    case AdSize.LARGE_AD_HEIGHT /*90*/:
                        b = mh.m1435b(lyVar, 90);
                        nB = this.fV == null ? 0 : this.fV.length;
                        obj = new C1082a[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fV, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1082a();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1082a();
                        lyVar.m1372a(obj[nB]);
                        this.fV = obj;
                        continue;
                    case 96:
                        this.fU = lyVar.nF();
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

        public C1082a m3579s() {
            this.type = 1;
            this.fN = "";
            this.fO = C1082a.m3574r();
            this.fP = C1082a.m3574r();
            this.fQ = C1082a.m3574r();
            this.fR = "";
            this.fS = "";
            this.fT = 0;
            this.fU = false;
            this.fV = C1082a.m3574r();
            this.fW = mh.and;
            this.fX = false;
            this.amX = null;
            this.anb = -1;
            return this;
        }
    }
}
