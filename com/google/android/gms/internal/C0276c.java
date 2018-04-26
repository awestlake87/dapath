package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.google.android.gms.internal.C0295d.C1082a;
import java.io.IOException;

public interface C0276c {

    public static final class C1072a extends ma<C1072a> {
        public int eE;
        public int eF;
        public int level;

        public C1072a() {
            m3506b();
        }

        public C1072a m3504a(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                switch (nB) {
                    case 0:
                        break;
                    case 8:
                        nB = lyVar.nE();
                        switch (nB) {
                            case 1:
                            case 2:
                            case 3:
                                this.level = nB;
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.eE = lyVar.nE();
                        continue;
                    case 24:
                        this.eF = lyVar.nE();
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

        public void mo1909a(lz lzVar) throws IOException {
            if (this.level != 1) {
                lzVar.m1414p(1, this.level);
            }
            if (this.eE != 0) {
                lzVar.m1414p(2, this.eE);
            }
            if (this.eF != 0) {
                lzVar.m1414p(3, this.eF);
            }
            super.mo1909a(lzVar);
        }

        public C1072a m3506b() {
            this.level = 1;
            this.eE = 0;
            this.eF = 0;
            this.amX = null;
            this.anb = -1;
            return this;
        }

        public /* synthetic */ me mo2547b(ly lyVar) throws IOException {
            return m3504a(lyVar);
        }

        protected int mo1910c() {
            int c = super.mo1910c();
            if (this.level != 1) {
                c += lz.m1393r(1, this.level);
            }
            if (this.eE != 0) {
                c += lz.m1393r(2, this.eE);
            }
            return this.eF != 0 ? c + lz.m1393r(3, this.eF) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1072a)) {
                return false;
            }
            C1072a c1072a = (C1072a) o;
            if (this.level != c1072a.level || this.eE != c1072a.eE || this.eF != c1072a.eF) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1072a.amX == null || c1072a.amX.isEmpty();
            } else {
                return this.amX.equals(c1072a.amX);
            }
        }

        public int hashCode() {
            int i = (((((this.level + 527) * 31) + this.eE) * 31) + this.eF) * 31;
            int hashCode = (this.amX == null || this.amX.isEmpty()) ? 0 : this.amX.hashCode();
            return hashCode + i;
        }
    }

    public static final class C1073b extends ma<C1073b> {
        private static volatile C1073b[] eG;
        public int[] eH;
        public int eI;
        public boolean eJ;
        public boolean eK;
        public int name;

        public C1073b() {
            m3514e();
        }

        public static C1073b[] m3509d() {
            if (eG == null) {
                synchronized (mc.ana) {
                    if (eG == null) {
                        eG = new C1073b[0];
                    }
                }
            }
            return eG;
        }

        public void mo1909a(lz lzVar) throws IOException {
            if (this.eK) {
                lzVar.m1403a(1, this.eK);
            }
            lzVar.m1414p(2, this.eI);
            if (this.eH != null && this.eH.length > 0) {
                for (int p : this.eH) {
                    lzVar.m1414p(3, p);
                }
            }
            if (this.name != 0) {
                lzVar.m1414p(4, this.name);
            }
            if (this.eJ) {
                lzVar.m1403a(6, this.eJ);
            }
            super.mo1909a(lzVar);
        }

        public /* synthetic */ me mo2547b(ly lyVar) throws IOException {
            return m3513c(lyVar);
        }

        protected int mo1910c() {
            int i = 0;
            int c = super.mo1910c();
            if (this.eK) {
                c += lz.m1382b(1, this.eK);
            }
            int r = lz.m1393r(2, this.eI) + c;
            if (this.eH == null || this.eH.length <= 0) {
                c = r;
            } else {
                for (int eE : this.eH) {
                    i += lz.eE(eE);
                }
                c = (r + i) + (this.eH.length * 1);
            }
            if (this.name != 0) {
                c += lz.m1393r(4, this.name);
            }
            return this.eJ ? c + lz.m1382b(6, this.eJ) : c;
        }

        public C1073b m3513c(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                int b;
                switch (nB) {
                    case 0:
                        break;
                    case 8:
                        this.eK = lyVar.nF();
                        continue;
                    case 16:
                        this.eI = lyVar.nE();
                        continue;
                    case 24:
                        b = mh.m1435b(lyVar, 24);
                        nB = this.eH == null ? 0 : this.eH.length;
                        Object obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eH, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.eH = obj;
                        continue;
                    case 26:
                        int ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.eH == null ? 0 : this.eH.length;
                        Object obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.eH, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.eH = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 32:
                        this.name = lyVar.nE();
                        continue;
                    case 48:
                        this.eJ = lyVar.nF();
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

        public C1073b m3514e() {
            this.eH = mh.and;
            this.eI = 0;
            this.name = 0;
            this.eJ = false;
            this.eK = false;
            this.amX = null;
            this.anb = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1073b)) {
                return false;
            }
            C1073b c1073b = (C1073b) o;
            if (!mc.equals(this.eH, c1073b.eH) || this.eI != c1073b.eI || this.name != c1073b.name || this.eJ != c1073b.eJ || this.eK != c1073b.eK) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1073b.amX == null || c1073b.amX.isEmpty();
            } else {
                return this.amX.equals(c1073b.amX);
            }
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = ((this.eJ ? 1231 : 1237) + ((((((mc.hashCode(this.eH) + 527) * 31) + this.eI) * 31) + this.name) * 31)) * 31;
            if (!this.eK) {
                i = 1237;
            }
            i = (hashCode + i) * 31;
            hashCode = (this.amX == null || this.amX.isEmpty()) ? 0 : this.amX.hashCode();
            return hashCode + i;
        }
    }

    public static final class C1074c extends ma<C1074c> {
        private static volatile C1074c[] eL;
        public String eM;
        public long eN;
        public long eO;
        public boolean eP;
        public long eQ;

        public C1074c() {
            m3520g();
        }

        public static C1074c[] m3515f() {
            if (eL == null) {
                synchronized (mc.ana) {
                    if (eL == null) {
                        eL = new C1074c[0];
                    }
                }
            }
            return eL;
        }

        public void mo1909a(lz lzVar) throws IOException {
            if (!this.eM.equals("")) {
                lzVar.m1408b(1, this.eM);
            }
            if (this.eN != 0) {
                lzVar.m1407b(2, this.eN);
            }
            if (this.eO != 2147483647L) {
                lzVar.m1407b(3, this.eO);
            }
            if (this.eP) {
                lzVar.m1403a(4, this.eP);
            }
            if (this.eQ != 0) {
                lzVar.m1407b(5, this.eQ);
            }
            super.mo1909a(lzVar);
        }

        public /* synthetic */ me mo2547b(ly lyVar) throws IOException {
            return m3519d(lyVar);
        }

        protected int mo1910c() {
            int c = super.mo1910c();
            if (!this.eM.equals("")) {
                c += lz.m1391h(1, this.eM);
            }
            if (this.eN != 0) {
                c += lz.m1387d(2, this.eN);
            }
            if (this.eO != 2147483647L) {
                c += lz.m1387d(3, this.eO);
            }
            if (this.eP) {
                c += lz.m1382b(4, this.eP);
            }
            return this.eQ != 0 ? c + lz.m1387d(5, this.eQ) : c;
        }

        public C1074c m3519d(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                switch (nB) {
                    case 0:
                        break;
                    case 10:
                        this.eM = lyVar.readString();
                        continue;
                    case 16:
                        this.eN = lyVar.nD();
                        continue;
                    case 24:
                        this.eO = lyVar.nD();
                        continue;
                    case 32:
                        this.eP = lyVar.nF();
                        continue;
                    case 40:
                        this.eQ = lyVar.nD();
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

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1074c)) {
                return false;
            }
            C1074c c1074c = (C1074c) o;
            if (this.eM == null) {
                if (c1074c.eM != null) {
                    return false;
                }
            } else if (!this.eM.equals(c1074c.eM)) {
                return false;
            }
            if (this.eN != c1074c.eN || this.eO != c1074c.eO || this.eP != c1074c.eP || this.eQ != c1074c.eQ) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1074c.amX == null || c1074c.amX.isEmpty();
            } else {
                return this.amX.equals(c1074c.amX);
            }
        }

        public C1074c m3520g() {
            this.eM = "";
            this.eN = 0;
            this.eO = 2147483647L;
            this.eP = false;
            this.eQ = 0;
            this.amX = null;
            this.anb = -1;
            return this;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.eP ? 1231 : 1237) + (((((((this.eM == null ? 0 : this.eM.hashCode()) + 527) * 31) + ((int) (this.eN ^ (this.eN >>> 32)))) * 31) + ((int) (this.eO ^ (this.eO >>> 32)))) * 31)) * 31) + ((int) (this.eQ ^ (this.eQ >>> 32)))) * 31;
            if (!(this.amX == null || this.amX.isEmpty())) {
                i = this.amX.hashCode();
            }
            return hashCode + i;
        }
    }

    public static final class C1075d extends ma<C1075d> {
        public C1082a[] eR;
        public C1082a[] eS;
        public C1074c[] eT;

        public C1075d() {
            m3525h();
        }

        public void mo1909a(lz lzVar) throws IOException {
            int i = 0;
            if (this.eR != null && this.eR.length > 0) {
                for (me meVar : this.eR) {
                    if (meVar != null) {
                        lzVar.m1402a(1, meVar);
                    }
                }
            }
            if (this.eS != null && this.eS.length > 0) {
                for (me meVar2 : this.eS) {
                    if (meVar2 != null) {
                        lzVar.m1402a(2, meVar2);
                    }
                }
            }
            if (this.eT != null && this.eT.length > 0) {
                while (i < this.eT.length) {
                    me meVar3 = this.eT[i];
                    if (meVar3 != null) {
                        lzVar.m1402a(3, meVar3);
                    }
                    i++;
                }
            }
            super.mo1909a(lzVar);
        }

        public /* synthetic */ me mo2547b(ly lyVar) throws IOException {
            return m3524e(lyVar);
        }

        protected int mo1910c() {
            int i;
            int i2 = 0;
            int c = super.mo1910c();
            if (this.eR != null && this.eR.length > 0) {
                i = c;
                for (me meVar : this.eR) {
                    if (meVar != null) {
                        i += lz.m1381b(1, meVar);
                    }
                }
                c = i;
            }
            if (this.eS != null && this.eS.length > 0) {
                i = c;
                for (me meVar2 : this.eS) {
                    if (meVar2 != null) {
                        i += lz.m1381b(2, meVar2);
                    }
                }
                c = i;
            }
            if (this.eT != null && this.eT.length > 0) {
                while (i2 < this.eT.length) {
                    me meVar3 = this.eT[i2];
                    if (meVar3 != null) {
                        c += lz.m1381b(3, meVar3);
                    }
                    i2++;
                }
            }
            return c;
        }

        public C1075d m3524e(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                int b;
                Object obj;
                switch (nB) {
                    case 0:
                        break;
                    case 10:
                        b = mh.m1435b(lyVar, 10);
                        nB = this.eR == null ? 0 : this.eR.length;
                        obj = new C1082a[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eR, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1082a();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1082a();
                        lyVar.m1372a(obj[nB]);
                        this.eR = obj;
                        continue;
                    case 18:
                        b = mh.m1435b(lyVar, 18);
                        nB = this.eS == null ? 0 : this.eS.length;
                        obj = new C1082a[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eS, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1082a();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1082a();
                        lyVar.m1372a(obj[nB]);
                        this.eS = obj;
                        continue;
                    case 26:
                        b = mh.m1435b(lyVar, 26);
                        nB = this.eT == null ? 0 : this.eT.length;
                        obj = new C1074c[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eT, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1074c();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1074c();
                        lyVar.m1372a(obj[nB]);
                        this.eT = obj;
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

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1075d)) {
                return false;
            }
            C1075d c1075d = (C1075d) o;
            if (!mc.equals(this.eR, c1075d.eR) || !mc.equals(this.eS, c1075d.eS) || !mc.equals(this.eT, c1075d.eT)) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1075d.amX == null || c1075d.amX.isEmpty();
            } else {
                return this.amX.equals(c1075d.amX);
            }
        }

        public C1075d m3525h() {
            this.eR = C1082a.m3574r();
            this.eS = C1082a.m3574r();
            this.eT = C1074c.m3515f();
            this.amX = null;
            this.anb = -1;
            return this;
        }

        public int hashCode() {
            int hashCode = (((((mc.hashCode(this.eR) + 527) * 31) + mc.hashCode(this.eS)) * 31) + mc.hashCode(this.eT)) * 31;
            int hashCode2 = (this.amX == null || this.amX.isEmpty()) ? 0 : this.amX.hashCode();
            return hashCode2 + hashCode;
        }
    }

    public static final class C1076e extends ma<C1076e> {
        private static volatile C1076e[] eU;
        public int key;
        public int value;

        public C1076e() {
            m3531j();
        }

        public static C1076e[] m3526i() {
            if (eU == null) {
                synchronized (mc.ana) {
                    if (eU == null) {
                        eU = new C1076e[0];
                    }
                }
            }
            return eU;
        }

        public void mo1909a(lz lzVar) throws IOException {
            lzVar.m1414p(1, this.key);
            lzVar.m1414p(2, this.value);
            super.mo1909a(lzVar);
        }

        public /* synthetic */ me mo2547b(ly lyVar) throws IOException {
            return m3530f(lyVar);
        }

        protected int mo1910c() {
            return (super.mo1910c() + lz.m1393r(1, this.key)) + lz.m1393r(2, this.value);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1076e)) {
                return false;
            }
            C1076e c1076e = (C1076e) o;
            if (this.key != c1076e.key || this.value != c1076e.value) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1076e.amX == null || c1076e.amX.isEmpty();
            } else {
                return this.amX.equals(c1076e.amX);
            }
        }

        public C1076e m3530f(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                switch (nB) {
                    case 0:
                        break;
                    case 8:
                        this.key = lyVar.nE();
                        continue;
                    case 16:
                        this.value = lyVar.nE();
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

        public int hashCode() {
            int i = (((this.key + 527) * 31) + this.value) * 31;
            int hashCode = (this.amX == null || this.amX.isEmpty()) ? 0 : this.amX.hashCode();
            return hashCode + i;
        }

        public C1076e m3531j() {
            this.key = 0;
            this.value = 0;
            this.amX = null;
            this.anb = -1;
            return this;
        }
    }

    public static final class C1077f extends ma<C1077f> {
        public String[] eV;
        public String[] eW;
        public C1082a[] eX;
        public C1076e[] eY;
        public C1073b[] eZ;
        public C1073b[] fa;
        public C1073b[] fb;
        public C1078g[] fc;
        public String fd;
        public String fe;
        public String ff;
        public String fg;
        public C1072a fh;
        public float fi;
        public boolean fj;
        public String[] fk;
        public int fl;

        public C1077f() {
            m3537k();
        }

        public static C1077f m3532a(byte[] bArr) throws md {
            return (C1077f) me.m1425a(new C1077f(), bArr);
        }

        public void mo1909a(lz lzVar) throws IOException {
            int i = 0;
            if (this.eW != null && this.eW.length > 0) {
                for (String str : this.eW) {
                    if (str != null) {
                        lzVar.m1408b(1, str);
                    }
                }
            }
            if (this.eX != null && this.eX.length > 0) {
                for (me meVar : this.eX) {
                    if (meVar != null) {
                        lzVar.m1402a(2, meVar);
                    }
                }
            }
            if (this.eY != null && this.eY.length > 0) {
                for (me meVar2 : this.eY) {
                    if (meVar2 != null) {
                        lzVar.m1402a(3, meVar2);
                    }
                }
            }
            if (this.eZ != null && this.eZ.length > 0) {
                for (me meVar22 : this.eZ) {
                    if (meVar22 != null) {
                        lzVar.m1402a(4, meVar22);
                    }
                }
            }
            if (this.fa != null && this.fa.length > 0) {
                for (me meVar222 : this.fa) {
                    if (meVar222 != null) {
                        lzVar.m1402a(5, meVar222);
                    }
                }
            }
            if (this.fb != null && this.fb.length > 0) {
                for (me meVar2222 : this.fb) {
                    if (meVar2222 != null) {
                        lzVar.m1402a(6, meVar2222);
                    }
                }
            }
            if (this.fc != null && this.fc.length > 0) {
                for (me meVar22222 : this.fc) {
                    if (meVar22222 != null) {
                        lzVar.m1402a(7, meVar22222);
                    }
                }
            }
            if (!this.fd.equals("")) {
                lzVar.m1408b(9, this.fd);
            }
            if (!this.fe.equals("")) {
                lzVar.m1408b(10, this.fe);
            }
            if (!this.ff.equals("0")) {
                lzVar.m1408b(12, this.ff);
            }
            if (!this.fg.equals("")) {
                lzVar.m1408b(13, this.fg);
            }
            if (this.fh != null) {
                lzVar.m1402a(14, this.fh);
            }
            if (Float.floatToIntBits(this.fi) != Float.floatToIntBits(0.0f)) {
                lzVar.m1406b(15, this.fi);
            }
            if (this.fk != null && this.fk.length > 0) {
                for (String str2 : this.fk) {
                    if (str2 != null) {
                        lzVar.m1408b(16, str2);
                    }
                }
            }
            if (this.fl != 0) {
                lzVar.m1414p(17, this.fl);
            }
            if (this.fj) {
                lzVar.m1403a(18, this.fj);
            }
            if (this.eV != null && this.eV.length > 0) {
                while (i < this.eV.length) {
                    String str3 = this.eV[i];
                    if (str3 != null) {
                        lzVar.m1408b(19, str3);
                    }
                    i++;
                }
            }
            super.mo1909a(lzVar);
        }

        public /* synthetic */ me mo2547b(ly lyVar) throws IOException {
            return m3536g(lyVar);
        }

        protected int mo1910c() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int c = super.mo1910c();
            if (this.eW == null || this.eW.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.eW) {
                    if (str != null) {
                        i3++;
                        i2 += lz.cz(str);
                    }
                }
                i = (c + i2) + (i3 * 1);
            }
            if (this.eX != null && this.eX.length > 0) {
                i2 = i;
                for (me meVar : this.eX) {
                    if (meVar != null) {
                        i2 += lz.m1381b(2, meVar);
                    }
                }
                i = i2;
            }
            if (this.eY != null && this.eY.length > 0) {
                i2 = i;
                for (me meVar2 : this.eY) {
                    if (meVar2 != null) {
                        i2 += lz.m1381b(3, meVar2);
                    }
                }
                i = i2;
            }
            if (this.eZ != null && this.eZ.length > 0) {
                i2 = i;
                for (me meVar22 : this.eZ) {
                    if (meVar22 != null) {
                        i2 += lz.m1381b(4, meVar22);
                    }
                }
                i = i2;
            }
            if (this.fa != null && this.fa.length > 0) {
                i2 = i;
                for (me meVar222 : this.fa) {
                    if (meVar222 != null) {
                        i2 += lz.m1381b(5, meVar222);
                    }
                }
                i = i2;
            }
            if (this.fb != null && this.fb.length > 0) {
                i2 = i;
                for (me meVar2222 : this.fb) {
                    if (meVar2222 != null) {
                        i2 += lz.m1381b(6, meVar2222);
                    }
                }
                i = i2;
            }
            if (this.fc != null && this.fc.length > 0) {
                i2 = i;
                for (me meVar22222 : this.fc) {
                    if (meVar22222 != null) {
                        i2 += lz.m1381b(7, meVar22222);
                    }
                }
                i = i2;
            }
            if (!this.fd.equals("")) {
                i += lz.m1391h(9, this.fd);
            }
            if (!this.fe.equals("")) {
                i += lz.m1391h(10, this.fe);
            }
            if (!this.ff.equals("0")) {
                i += lz.m1391h(12, this.ff);
            }
            if (!this.fg.equals("")) {
                i += lz.m1391h(13, this.fg);
            }
            if (this.fh != null) {
                i += lz.m1381b(14, this.fh);
            }
            if (Float.floatToIntBits(this.fi) != Float.floatToIntBits(0.0f)) {
                i += lz.m1385c(15, this.fi);
            }
            if (this.fk != null && this.fk.length > 0) {
                i3 = 0;
                c = 0;
                for (String str2 : this.fk) {
                    if (str2 != null) {
                        c++;
                        i3 += lz.cz(str2);
                    }
                }
                i = (i + i3) + (c * 2);
            }
            if (this.fl != 0) {
                i += lz.m1393r(17, this.fl);
            }
            if (this.fj) {
                i += lz.m1382b(18, this.fj);
            }
            if (this.eV == null || this.eV.length <= 0) {
                return i;
            }
            i2 = 0;
            i3 = 0;
            while (i4 < this.eV.length) {
                String str3 = this.eV[i4];
                if (str3 != null) {
                    i3++;
                    i2 += lz.cz(str3);
                }
                i4++;
            }
            return (i + i2) + (i3 * 2);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1077f)) {
                return false;
            }
            C1077f c1077f = (C1077f) o;
            if (!mc.equals(this.eV, c1077f.eV) || !mc.equals(this.eW, c1077f.eW) || !mc.equals(this.eX, c1077f.eX) || !mc.equals(this.eY, c1077f.eY) || !mc.equals(this.eZ, c1077f.eZ) || !mc.equals(this.fa, c1077f.fa) || !mc.equals(this.fb, c1077f.fb) || !mc.equals(this.fc, c1077f.fc)) {
                return false;
            }
            if (this.fd == null) {
                if (c1077f.fd != null) {
                    return false;
                }
            } else if (!this.fd.equals(c1077f.fd)) {
                return false;
            }
            if (this.fe == null) {
                if (c1077f.fe != null) {
                    return false;
                }
            } else if (!this.fe.equals(c1077f.fe)) {
                return false;
            }
            if (this.ff == null) {
                if (c1077f.ff != null) {
                    return false;
                }
            } else if (!this.ff.equals(c1077f.ff)) {
                return false;
            }
            if (this.fg == null) {
                if (c1077f.fg != null) {
                    return false;
                }
            } else if (!this.fg.equals(c1077f.fg)) {
                return false;
            }
            if (this.fh == null) {
                if (c1077f.fh != null) {
                    return false;
                }
            } else if (!this.fh.equals(c1077f.fh)) {
                return false;
            }
            if (Float.floatToIntBits(this.fi) != Float.floatToIntBits(c1077f.fi) || this.fj != c1077f.fj || !mc.equals(this.fk, c1077f.fk) || this.fl != c1077f.fl) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1077f.amX == null || c1077f.amX.isEmpty();
            } else {
                return this.amX.equals(c1077f.amX);
            }
        }

        public C1077f m3536g(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                int b;
                Object obj;
                switch (nB) {
                    case 0:
                        break;
                    case 10:
                        b = mh.m1435b(lyVar, 10);
                        nB = this.eW == null ? 0 : this.eW.length;
                        obj = new String[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eW, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.readString();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.readString();
                        this.eW = obj;
                        continue;
                    case 18:
                        b = mh.m1435b(lyVar, 18);
                        nB = this.eX == null ? 0 : this.eX.length;
                        obj = new C1082a[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eX, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1082a();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1082a();
                        lyVar.m1372a(obj[nB]);
                        this.eX = obj;
                        continue;
                    case 26:
                        b = mh.m1435b(lyVar, 26);
                        nB = this.eY == null ? 0 : this.eY.length;
                        obj = new C1076e[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eY, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1076e();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1076e();
                        lyVar.m1372a(obj[nB]);
                        this.eY = obj;
                        continue;
                    case 34:
                        b = mh.m1435b(lyVar, 34);
                        nB = this.eZ == null ? 0 : this.eZ.length;
                        obj = new C1073b[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eZ, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1073b();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1073b();
                        lyVar.m1372a(obj[nB]);
                        this.eZ = obj;
                        continue;
                    case 42:
                        b = mh.m1435b(lyVar, 42);
                        nB = this.fa == null ? 0 : this.fa.length;
                        obj = new C1073b[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fa, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1073b();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1073b();
                        lyVar.m1372a(obj[nB]);
                        this.fa = obj;
                        continue;
                    case 50:
                        b = mh.m1435b(lyVar, 50);
                        nB = this.fb == null ? 0 : this.fb.length;
                        obj = new C1073b[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fb, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1073b();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1073b();
                        lyVar.m1372a(obj[nB]);
                        this.fb = obj;
                        continue;
                    case 58:
                        b = mh.m1435b(lyVar, 58);
                        nB = this.fc == null ? 0 : this.fc.length;
                        obj = new C1078g[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fc, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1078g();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1078g();
                        lyVar.m1372a(obj[nB]);
                        this.fc = obj;
                        continue;
                    case 74:
                        this.fd = lyVar.readString();
                        continue;
                    case 82:
                        this.fe = lyVar.readString();
                        continue;
                    case 98:
                        this.ff = lyVar.readString();
                        continue;
                    case 106:
                        this.fg = lyVar.readString();
                        continue;
                    case 114:
                        if (this.fh == null) {
                            this.fh = new C1072a();
                        }
                        lyVar.m1372a(this.fh);
                        continue;
                    case 125:
                        this.fi = lyVar.readFloat();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        b = mh.m1435b(lyVar, TransportMediator.KEYCODE_MEDIA_RECORD);
                        nB = this.fk == null ? 0 : this.fk.length;
                        obj = new String[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fk, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.readString();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.readString();
                        this.fk = obj;
                        continue;
                    case 136:
                        this.fl = lyVar.nE();
                        continue;
                    case 144:
                        this.fj = lyVar.nF();
                        continue;
                    case 154:
                        b = mh.m1435b(lyVar, 154);
                        nB = this.eV == null ? 0 : this.eV.length;
                        obj = new String[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.eV, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.readString();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.readString();
                        this.eV = obj;
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

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((this.fj ? 1231 : 1237) + (((((this.fh == null ? 0 : this.fh.hashCode()) + (((this.fg == null ? 0 : this.fg.hashCode()) + (((this.ff == null ? 0 : this.ff.hashCode()) + (((this.fe == null ? 0 : this.fe.hashCode()) + (((this.fd == null ? 0 : this.fd.hashCode()) + ((((((((((((((((mc.hashCode(this.eV) + 527) * 31) + mc.hashCode(this.eW)) * 31) + mc.hashCode(this.eX)) * 31) + mc.hashCode(this.eY)) * 31) + mc.hashCode(this.eZ)) * 31) + mc.hashCode(this.fa)) * 31) + mc.hashCode(this.fb)) * 31) + mc.hashCode(this.fc)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + Float.floatToIntBits(this.fi)) * 31)) * 31) + mc.hashCode(this.fk)) * 31) + this.fl) * 31;
            if (!(this.amX == null || this.amX.isEmpty())) {
                i = this.amX.hashCode();
            }
            return hashCode + i;
        }

        public C1077f m3537k() {
            this.eV = mh.ani;
            this.eW = mh.ani;
            this.eX = C1082a.m3574r();
            this.eY = C1076e.m3526i();
            this.eZ = C1073b.m3509d();
            this.fa = C1073b.m3509d();
            this.fb = C1073b.m3509d();
            this.fc = C1078g.m3538l();
            this.fd = "";
            this.fe = "";
            this.ff = "0";
            this.fg = "";
            this.fh = null;
            this.fi = 0.0f;
            this.fj = false;
            this.fk = mh.ani;
            this.fl = 0;
            this.amX = null;
            this.anb = -1;
            return this;
        }
    }

    public static final class C1078g extends ma<C1078g> {
        private static volatile C1078g[] fm;
        public int[] fn;
        public int[] fo;
        public int[] fp;
        public int[] fq;
        public int[] fr;
        public int[] fs;
        public int[] ft;
        public int[] fu;
        public int[] fv;
        public int[] fw;

        public C1078g() {
            m3543m();
        }

        public static C1078g[] m3538l() {
            if (fm == null) {
                synchronized (mc.ana) {
                    if (fm == null) {
                        fm = new C1078g[0];
                    }
                }
            }
            return fm;
        }

        public void mo1909a(lz lzVar) throws IOException {
            int i = 0;
            if (this.fn != null && this.fn.length > 0) {
                for (int p : this.fn) {
                    lzVar.m1414p(1, p);
                }
            }
            if (this.fo != null && this.fo.length > 0) {
                for (int p2 : this.fo) {
                    lzVar.m1414p(2, p2);
                }
            }
            if (this.fp != null && this.fp.length > 0) {
                for (int p22 : this.fp) {
                    lzVar.m1414p(3, p22);
                }
            }
            if (this.fq != null && this.fq.length > 0) {
                for (int p222 : this.fq) {
                    lzVar.m1414p(4, p222);
                }
            }
            if (this.fr != null && this.fr.length > 0) {
                for (int p2222 : this.fr) {
                    lzVar.m1414p(5, p2222);
                }
            }
            if (this.fs != null && this.fs.length > 0) {
                for (int p22222 : this.fs) {
                    lzVar.m1414p(6, p22222);
                }
            }
            if (this.ft != null && this.ft.length > 0) {
                for (int p222222 : this.ft) {
                    lzVar.m1414p(7, p222222);
                }
            }
            if (this.fu != null && this.fu.length > 0) {
                for (int p2222222 : this.fu) {
                    lzVar.m1414p(8, p2222222);
                }
            }
            if (this.fv != null && this.fv.length > 0) {
                for (int p22222222 : this.fv) {
                    lzVar.m1414p(9, p22222222);
                }
            }
            if (this.fw != null && this.fw.length > 0) {
                while (i < this.fw.length) {
                    lzVar.m1414p(10, this.fw[i]);
                    i++;
                }
            }
            super.mo1909a(lzVar);
        }

        public /* synthetic */ me mo2547b(ly lyVar) throws IOException {
            return m3542h(lyVar);
        }

        protected int mo1910c() {
            int i;
            int i2;
            int i3 = 0;
            int c = super.mo1910c();
            if (this.fn == null || this.fn.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                for (int eE : this.fn) {
                    i2 += lz.eE(eE);
                }
                i = (c + i2) + (this.fn.length * 1);
            }
            if (this.fo != null && this.fo.length > 0) {
                c = 0;
                for (int eE2 : this.fo) {
                    c += lz.eE(eE2);
                }
                i = (i + c) + (this.fo.length * 1);
            }
            if (this.fp != null && this.fp.length > 0) {
                c = 0;
                for (int eE22 : this.fp) {
                    c += lz.eE(eE22);
                }
                i = (i + c) + (this.fp.length * 1);
            }
            if (this.fq != null && this.fq.length > 0) {
                c = 0;
                for (int eE222 : this.fq) {
                    c += lz.eE(eE222);
                }
                i = (i + c) + (this.fq.length * 1);
            }
            if (this.fr != null && this.fr.length > 0) {
                c = 0;
                for (int eE2222 : this.fr) {
                    c += lz.eE(eE2222);
                }
                i = (i + c) + (this.fr.length * 1);
            }
            if (this.fs != null && this.fs.length > 0) {
                c = 0;
                for (int eE22222 : this.fs) {
                    c += lz.eE(eE22222);
                }
                i = (i + c) + (this.fs.length * 1);
            }
            if (this.ft != null && this.ft.length > 0) {
                c = 0;
                for (int eE222222 : this.ft) {
                    c += lz.eE(eE222222);
                }
                i = (i + c) + (this.ft.length * 1);
            }
            if (this.fu != null && this.fu.length > 0) {
                c = 0;
                for (int eE2222222 : this.fu) {
                    c += lz.eE(eE2222222);
                }
                i = (i + c) + (this.fu.length * 1);
            }
            if (this.fv != null && this.fv.length > 0) {
                c = 0;
                for (int eE22222222 : this.fv) {
                    c += lz.eE(eE22222222);
                }
                i = (i + c) + (this.fv.length * 1);
            }
            if (this.fw == null || this.fw.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i3 < this.fw.length) {
                i2 += lz.eE(this.fw[i3]);
                i3++;
            }
            return (i + i2) + (this.fw.length * 1);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1078g)) {
                return false;
            }
            C1078g c1078g = (C1078g) o;
            if (!mc.equals(this.fn, c1078g.fn) || !mc.equals(this.fo, c1078g.fo) || !mc.equals(this.fp, c1078g.fp) || !mc.equals(this.fq, c1078g.fq) || !mc.equals(this.fr, c1078g.fr) || !mc.equals(this.fs, c1078g.fs) || !mc.equals(this.ft, c1078g.ft) || !mc.equals(this.fu, c1078g.fu) || !mc.equals(this.fv, c1078g.fv) || !mc.equals(this.fw, c1078g.fw)) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1078g.amX == null || c1078g.amX.isEmpty();
            } else {
                return this.amX.equals(c1078g.amX);
            }
        }

        public C1078g m3542h(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                int b;
                Object obj;
                int ex;
                Object obj2;
                switch (nB) {
                    case 0:
                        break;
                    case 8:
                        b = mh.m1435b(lyVar, 8);
                        nB = this.fn == null ? 0 : this.fn.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fn, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fn = obj;
                        continue;
                    case 10:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fn == null ? 0 : this.fn.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fn, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fn = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 16:
                        b = mh.m1435b(lyVar, 16);
                        nB = this.fo == null ? 0 : this.fo.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fo, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fo = obj;
                        continue;
                    case 18:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fo == null ? 0 : this.fo.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fo, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fo = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 24:
                        b = mh.m1435b(lyVar, 24);
                        nB = this.fp == null ? 0 : this.fp.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fp, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fp = obj;
                        continue;
                    case 26:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fp == null ? 0 : this.fp.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fp, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fp = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 32:
                        b = mh.m1435b(lyVar, 32);
                        nB = this.fq == null ? 0 : this.fq.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fq, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fq = obj;
                        continue;
                    case 34:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fq == null ? 0 : this.fq.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fq, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fq = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 40:
                        b = mh.m1435b(lyVar, 40);
                        nB = this.fr == null ? 0 : this.fr.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fr, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fr = obj;
                        continue;
                    case 42:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fr == null ? 0 : this.fr.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fr, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fr = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 48:
                        b = mh.m1435b(lyVar, 48);
                        nB = this.fs == null ? 0 : this.fs.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fs, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fs = obj;
                        continue;
                    case 50:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fs == null ? 0 : this.fs.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fs, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fs = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 56:
                        b = mh.m1435b(lyVar, 56);
                        nB = this.ft == null ? 0 : this.ft.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.ft, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.ft = obj;
                        continue;
                    case 58:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.ft == null ? 0 : this.ft.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.ft, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.ft = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 64:
                        b = mh.m1435b(lyVar, 64);
                        nB = this.fu == null ? 0 : this.fu.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fu, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fu = obj;
                        continue;
                    case 66:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fu == null ? 0 : this.fu.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fu, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fu = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 72:
                        b = mh.m1435b(lyVar, 72);
                        nB = this.fv == null ? 0 : this.fv.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fv, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fv = obj;
                        continue;
                    case 74:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fv == null ? 0 : this.fv.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fv, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fv = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 80:
                        b = mh.m1435b(lyVar, 80);
                        nB = this.fw == null ? 0 : this.fw.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fw, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fw = obj;
                        continue;
                    case 82:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fw == null ? 0 : this.fw.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fw, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fw = obj2;
                        lyVar.ey(ex);
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

        public int hashCode() {
            int hashCode = (((((((((((((((((((mc.hashCode(this.fn) + 527) * 31) + mc.hashCode(this.fo)) * 31) + mc.hashCode(this.fp)) * 31) + mc.hashCode(this.fq)) * 31) + mc.hashCode(this.fr)) * 31) + mc.hashCode(this.fs)) * 31) + mc.hashCode(this.ft)) * 31) + mc.hashCode(this.fu)) * 31) + mc.hashCode(this.fv)) * 31) + mc.hashCode(this.fw)) * 31;
            int hashCode2 = (this.amX == null || this.amX.isEmpty()) ? 0 : this.amX.hashCode();
            return hashCode2 + hashCode;
        }

        public C1078g m3543m() {
            this.fn = mh.and;
            this.fo = mh.and;
            this.fp = mh.and;
            this.fq = mh.and;
            this.fr = mh.and;
            this.fs = mh.and;
            this.ft = mh.and;
            this.fu = mh.and;
            this.fv = mh.and;
            this.fw = mh.and;
            this.amX = null;
            this.anb = -1;
            return this;
        }
    }

    public static final class C1079h extends ma<C1079h> {
        public static final mb<C1082a, C1079h> fx = mb.m1421a(11, C1079h.class, 810);
        private static final C1079h[] fy = new C1079h[0];
        public int[] fA;
        public int[] fB;
        public int fC;
        public int[] fD;
        public int fE;
        public int fF;
        public int[] fz;

        public C1079h() {
            m3548n();
        }

        public void mo1909a(lz lzVar) throws IOException {
            int i = 0;
            if (this.fz != null && this.fz.length > 0) {
                for (int p : this.fz) {
                    lzVar.m1414p(1, p);
                }
            }
            if (this.fA != null && this.fA.length > 0) {
                for (int p2 : this.fA) {
                    lzVar.m1414p(2, p2);
                }
            }
            if (this.fB != null && this.fB.length > 0) {
                for (int p22 : this.fB) {
                    lzVar.m1414p(3, p22);
                }
            }
            if (this.fC != 0) {
                lzVar.m1414p(4, this.fC);
            }
            if (this.fD != null && this.fD.length > 0) {
                while (i < this.fD.length) {
                    lzVar.m1414p(5, this.fD[i]);
                    i++;
                }
            }
            if (this.fE != 0) {
                lzVar.m1414p(6, this.fE);
            }
            if (this.fF != 0) {
                lzVar.m1414p(7, this.fF);
            }
            super.mo1909a(lzVar);
        }

        public /* synthetic */ me mo2547b(ly lyVar) throws IOException {
            return m3547i(lyVar);
        }

        protected int mo1910c() {
            int i;
            int i2;
            int i3 = 0;
            int c = super.mo1910c();
            if (this.fz == null || this.fz.length <= 0) {
                i = c;
            } else {
                i2 = 0;
                for (int eE : this.fz) {
                    i2 += lz.eE(eE);
                }
                i = (c + i2) + (this.fz.length * 1);
            }
            if (this.fA != null && this.fA.length > 0) {
                c = 0;
                for (int eE2 : this.fA) {
                    c += lz.eE(eE2);
                }
                i = (i + c) + (this.fA.length * 1);
            }
            if (this.fB != null && this.fB.length > 0) {
                c = 0;
                for (int eE22 : this.fB) {
                    c += lz.eE(eE22);
                }
                i = (i + c) + (this.fB.length * 1);
            }
            if (this.fC != 0) {
                i += lz.m1393r(4, this.fC);
            }
            if (this.fD != null && this.fD.length > 0) {
                i2 = 0;
                while (i3 < this.fD.length) {
                    i2 += lz.eE(this.fD[i3]);
                    i3++;
                }
                i = (i + i2) + (this.fD.length * 1);
            }
            if (this.fE != 0) {
                i += lz.m1393r(6, this.fE);
            }
            return this.fF != 0 ? i + lz.m1393r(7, this.fF) : i;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1079h)) {
                return false;
            }
            C1079h c1079h = (C1079h) o;
            if (!mc.equals(this.fz, c1079h.fz) || !mc.equals(this.fA, c1079h.fA) || !mc.equals(this.fB, c1079h.fB) || this.fC != c1079h.fC || !mc.equals(this.fD, c1079h.fD) || this.fE != c1079h.fE || this.fF != c1079h.fF) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1079h.amX == null || c1079h.amX.isEmpty();
            } else {
                return this.amX.equals(c1079h.amX);
            }
        }

        public int hashCode() {
            int hashCode = (((((((((((((mc.hashCode(this.fz) + 527) * 31) + mc.hashCode(this.fA)) * 31) + mc.hashCode(this.fB)) * 31) + this.fC) * 31) + mc.hashCode(this.fD)) * 31) + this.fE) * 31) + this.fF) * 31;
            int hashCode2 = (this.amX == null || this.amX.isEmpty()) ? 0 : this.amX.hashCode();
            return hashCode2 + hashCode;
        }

        public C1079h m3547i(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                int b;
                Object obj;
                int ex;
                Object obj2;
                switch (nB) {
                    case 0:
                        break;
                    case 8:
                        b = mh.m1435b(lyVar, 8);
                        nB = this.fz == null ? 0 : this.fz.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fz, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fz = obj;
                        continue;
                    case 10:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fz == null ? 0 : this.fz.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fz, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fz = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 16:
                        b = mh.m1435b(lyVar, 16);
                        nB = this.fA == null ? 0 : this.fA.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fA, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fA = obj;
                        continue;
                    case 18:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fA == null ? 0 : this.fA.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fA, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fA = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 24:
                        b = mh.m1435b(lyVar, 24);
                        nB = this.fB == null ? 0 : this.fB.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fB, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fB = obj;
                        continue;
                    case 26:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fB == null ? 0 : this.fB.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fB, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fB = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 32:
                        this.fC = lyVar.nE();
                        continue;
                    case 40:
                        b = mh.m1435b(lyVar, 40);
                        nB = this.fD == null ? 0 : this.fD.length;
                        obj = new int[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fD, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = lyVar.nE();
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = lyVar.nE();
                        this.fD = obj;
                        continue;
                    case 42:
                        ex = lyVar.ex(lyVar.nI());
                        b = lyVar.getPosition();
                        nB = 0;
                        while (lyVar.nN() > 0) {
                            lyVar.nE();
                            nB++;
                        }
                        lyVar.ez(b);
                        b = this.fD == null ? 0 : this.fD.length;
                        obj2 = new int[(nB + b)];
                        if (b != 0) {
                            System.arraycopy(this.fD, 0, obj2, 0, b);
                        }
                        while (b < obj2.length) {
                            obj2[b] = lyVar.nE();
                            b++;
                        }
                        this.fD = obj2;
                        lyVar.ey(ex);
                        continue;
                    case 48:
                        this.fE = lyVar.nE();
                        continue;
                    case 56:
                        this.fF = lyVar.nE();
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

        public C1079h m3548n() {
            this.fz = mh.and;
            this.fA = mh.and;
            this.fB = mh.and;
            this.fC = 0;
            this.fD = mh.and;
            this.fE = 0;
            this.fF = 0;
            this.amX = null;
            this.anb = -1;
            return this;
        }
    }

    public static final class C1080i extends ma<C1080i> {
        private static volatile C1080i[] fG;
        public C1082a fH;
        public C1075d fI;
        public String name;

        public C1080i() {
            m3554p();
        }

        public static C1080i[] m3549o() {
            if (fG == null) {
                synchronized (mc.ana) {
                    if (fG == null) {
                        fG = new C1080i[0];
                    }
                }
            }
            return fG;
        }

        public void mo1909a(lz lzVar) throws IOException {
            if (!this.name.equals("")) {
                lzVar.m1408b(1, this.name);
            }
            if (this.fH != null) {
                lzVar.m1402a(2, this.fH);
            }
            if (this.fI != null) {
                lzVar.m1402a(3, this.fI);
            }
            super.mo1909a(lzVar);
        }

        public /* synthetic */ me mo2547b(ly lyVar) throws IOException {
            return m3553j(lyVar);
        }

        protected int mo1910c() {
            int c = super.mo1910c();
            if (!this.name.equals("")) {
                c += lz.m1391h(1, this.name);
            }
            if (this.fH != null) {
                c += lz.m1381b(2, this.fH);
            }
            return this.fI != null ? c + lz.m1381b(3, this.fI) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1080i)) {
                return false;
            }
            C1080i c1080i = (C1080i) o;
            if (this.name == null) {
                if (c1080i.name != null) {
                    return false;
                }
            } else if (!this.name.equals(c1080i.name)) {
                return false;
            }
            if (this.fH == null) {
                if (c1080i.fH != null) {
                    return false;
                }
            } else if (!this.fH.equals(c1080i.fH)) {
                return false;
            }
            if (this.fI == null) {
                if (c1080i.fI != null) {
                    return false;
                }
            } else if (!this.fI.equals(c1080i.fI)) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1080i.amX == null || c1080i.amX.isEmpty();
            } else {
                return this.amX.equals(c1080i.amX);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.fI == null ? 0 : this.fI.hashCode()) + (((this.fH == null ? 0 : this.fH.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + 527) * 31)) * 31)) * 31;
            if (!(this.amX == null || this.amX.isEmpty())) {
                i = this.amX.hashCode();
            }
            return hashCode + i;
        }

        public C1080i m3553j(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                switch (nB) {
                    case 0:
                        break;
                    case 10:
                        this.name = lyVar.readString();
                        continue;
                    case 18:
                        if (this.fH == null) {
                            this.fH = new C1082a();
                        }
                        lyVar.m1372a(this.fH);
                        continue;
                    case 26:
                        if (this.fI == null) {
                            this.fI = new C1075d();
                        }
                        lyVar.m1372a(this.fI);
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

        public C1080i m3554p() {
            this.name = "";
            this.fH = null;
            this.fI = null;
            this.amX = null;
            this.anb = -1;
            return this;
        }
    }

    public static final class C1081j extends ma<C1081j> {
        public C1080i[] fJ;
        public C1077f fK;
        public String fL;

        public C1081j() {
            m3560q();
        }

        public static C1081j m3555b(byte[] bArr) throws md {
            return (C1081j) me.m1425a(new C1081j(), bArr);
        }

        public void mo1909a(lz lzVar) throws IOException {
            if (this.fJ != null && this.fJ.length > 0) {
                for (me meVar : this.fJ) {
                    if (meVar != null) {
                        lzVar.m1402a(1, meVar);
                    }
                }
            }
            if (this.fK != null) {
                lzVar.m1402a(2, this.fK);
            }
            if (!this.fL.equals("")) {
                lzVar.m1408b(3, this.fL);
            }
            super.mo1909a(lzVar);
        }

        public /* synthetic */ me mo2547b(ly lyVar) throws IOException {
            return m3559k(lyVar);
        }

        protected int mo1910c() {
            int c = super.mo1910c();
            if (this.fJ != null && this.fJ.length > 0) {
                for (me meVar : this.fJ) {
                    if (meVar != null) {
                        c += lz.m1381b(1, meVar);
                    }
                }
            }
            if (this.fK != null) {
                c += lz.m1381b(2, this.fK);
            }
            return !this.fL.equals("") ? c + lz.m1391h(3, this.fL) : c;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof C1081j)) {
                return false;
            }
            C1081j c1081j = (C1081j) o;
            if (!mc.equals(this.fJ, c1081j.fJ)) {
                return false;
            }
            if (this.fK == null) {
                if (c1081j.fK != null) {
                    return false;
                }
            } else if (!this.fK.equals(c1081j.fK)) {
                return false;
            }
            if (this.fL == null) {
                if (c1081j.fL != null) {
                    return false;
                }
            } else if (!this.fL.equals(c1081j.fL)) {
                return false;
            }
            if (this.amX == null || this.amX.isEmpty()) {
                return c1081j.amX == null || c1081j.amX.isEmpty();
            } else {
                return this.amX.equals(c1081j.amX);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.fL == null ? 0 : this.fL.hashCode()) + (((this.fK == null ? 0 : this.fK.hashCode()) + ((mc.hashCode(this.fJ) + 527) * 31)) * 31)) * 31;
            if (!(this.amX == null || this.amX.isEmpty())) {
                i = this.amX.hashCode();
            }
            return hashCode + i;
        }

        public C1081j m3559k(ly lyVar) throws IOException {
            while (true) {
                int nB = lyVar.nB();
                switch (nB) {
                    case 0:
                        break;
                    case 10:
                        int b = mh.m1435b(lyVar, 10);
                        nB = this.fJ == null ? 0 : this.fJ.length;
                        Object obj = new C1080i[(b + nB)];
                        if (nB != 0) {
                            System.arraycopy(this.fJ, 0, obj, 0, nB);
                        }
                        while (nB < obj.length - 1) {
                            obj[nB] = new C1080i();
                            lyVar.m1372a(obj[nB]);
                            lyVar.nB();
                            nB++;
                        }
                        obj[nB] = new C1080i();
                        lyVar.m1372a(obj[nB]);
                        this.fJ = obj;
                        continue;
                    case 18:
                        if (this.fK == null) {
                            this.fK = new C1077f();
                        }
                        lyVar.m1372a(this.fK);
                        continue;
                    case 26:
                        this.fL = lyVar.readString();
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

        public C1081j m3560q() {
            this.fJ = C1080i.m3549o();
            this.fK = null;
            this.fL = "";
            this.amX = null;
            this.anb = -1;
            return this;
        }
    }
}
