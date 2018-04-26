package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0272b;
import com.google.android.gms.internal.C0276c.C1073b;
import com.google.android.gms.internal.C0276c.C1076e;
import com.google.android.gms.internal.C0276c.C1077f;
import com.google.android.gms.internal.C0276c.C1078g;
import com.google.android.gms.internal.C0276c.C1079h;
import com.google.android.gms.internal.C0295d.C1082a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class cq {

    public static class C0462a {
        private final Map<String, C1082a> agX;
        private final C1082a agY;

        private C0462a(Map<String, C1082a> map, C1082a c1082a) {
            this.agX = map;
            this.agY = c1082a;
        }

        public static C0463b mn() {
            return new C0463b();
        }

        public void m1669a(String str, C1082a c1082a) {
            this.agX.put(str, c1082a);
        }

        public Map<String, C1082a> mo() {
            return Collections.unmodifiableMap(this.agX);
        }

        public C1082a mp() {
            return this.agY;
        }

        public String toString() {
            return "Properties: " + mo() + " pushAfterEvaluate: " + this.agY;
        }
    }

    public static class C0463b {
        private final Map<String, C1082a> agX;
        private C1082a agY;

        private C0463b() {
            this.agX = new HashMap();
        }

        public C0463b m1670b(String str, C1082a c1082a) {
            this.agX.put(str, c1082a);
            return this;
        }

        public C0463b m1671i(C1082a c1082a) {
            this.agY = c1082a;
            return this;
        }

        public C0462a mq() {
            return new C0462a(this.agX, this.agY);
        }
    }

    public static class C0464c {
        private final String aeU;
        private final List<C0466e> agZ;
        private final Map<String, List<C0462a>> aha;
        private final int ahb;

        private C0464c(List<C0466e> list, Map<String, List<C0462a>> map, String str, int i) {
            this.agZ = Collections.unmodifiableList(list);
            this.aha = Collections.unmodifiableMap(map);
            this.aeU = str;
            this.ahb = i;
        }

        public static C0465d mr() {
            return new C0465d();
        }

        public String getVersion() {
            return this.aeU;
        }

        public List<C0466e> ms() {
            return this.agZ;
        }

        public Map<String, List<C0462a>> mt() {
            return this.aha;
        }

        public String toString() {
            return "Rules: " + ms() + "  Macros: " + this.aha;
        }
    }

    public static class C0465d {
        private String aeU;
        private final List<C0466e> agZ;
        private final Map<String, List<C0462a>> aha;
        private int ahb;

        private C0465d() {
            this.agZ = new ArrayList();
            this.aha = new HashMap();
            this.aeU = "";
            this.ahb = 0;
        }

        public C0465d m1672a(C0462a c0462a) {
            String j = dh.m1722j((C1082a) c0462a.mo().get(C0272b.INSTANCE_NAME.toString()));
            List list = (List) this.aha.get(j);
            if (list == null) {
                list = new ArrayList();
                this.aha.put(j, list);
            }
            list.add(c0462a);
            return this;
        }

        public C0465d m1673a(C0466e c0466e) {
            this.agZ.add(c0466e);
            return this;
        }

        public C0465d ce(String str) {
            this.aeU = str;
            return this;
        }

        public C0465d du(int i) {
            this.ahb = i;
            return this;
        }

        public C0464c mu() {
            return new C0464c(this.agZ, this.aha, this.aeU, this.ahb);
        }
    }

    public static class C0466e {
        private final List<C0462a> ahc;
        private final List<C0462a> ahd;
        private final List<C0462a> ahe;
        private final List<C0462a> ahf;
        private final List<C0462a> ahg;
        private final List<C0462a> ahh;
        private final List<String> ahi;
        private final List<String> ahj;
        private final List<String> ahk;
        private final List<String> ahl;

        private C0466e(List<C0462a> list, List<C0462a> list2, List<C0462a> list3, List<C0462a> list4, List<C0462a> list5, List<C0462a> list6, List<String> list7, List<String> list8, List<String> list9, List<String> list10) {
            this.ahc = Collections.unmodifiableList(list);
            this.ahd = Collections.unmodifiableList(list2);
            this.ahe = Collections.unmodifiableList(list3);
            this.ahf = Collections.unmodifiableList(list4);
            this.ahg = Collections.unmodifiableList(list5);
            this.ahh = Collections.unmodifiableList(list6);
            this.ahi = Collections.unmodifiableList(list7);
            this.ahj = Collections.unmodifiableList(list8);
            this.ahk = Collections.unmodifiableList(list9);
            this.ahl = Collections.unmodifiableList(list10);
        }

        public static C0467f mv() {
            return new C0467f();
        }

        public List<C0462a> mA() {
            return this.ahg;
        }

        public List<String> mB() {
            return this.ahi;
        }

        public List<String> mC() {
            return this.ahj;
        }

        public List<String> mD() {
            return this.ahk;
        }

        public List<String> mE() {
            return this.ahl;
        }

        public List<C0462a> mF() {
            return this.ahh;
        }

        public List<C0462a> mw() {
            return this.ahc;
        }

        public List<C0462a> mx() {
            return this.ahd;
        }

        public List<C0462a> my() {
            return this.ahe;
        }

        public List<C0462a> mz() {
            return this.ahf;
        }

        public String toString() {
            return "Positive predicates: " + mw() + "  Negative predicates: " + mx() + "  Add tags: " + my() + "  Remove tags: " + mz() + "  Add macros: " + mA() + "  Remove macros: " + mF();
        }
    }

    public static class C0467f {
        private final List<C0462a> ahc;
        private final List<C0462a> ahd;
        private final List<C0462a> ahe;
        private final List<C0462a> ahf;
        private final List<C0462a> ahg;
        private final List<C0462a> ahh;
        private final List<String> ahi;
        private final List<String> ahj;
        private final List<String> ahk;
        private final List<String> ahl;

        private C0467f() {
            this.ahc = new ArrayList();
            this.ahd = new ArrayList();
            this.ahe = new ArrayList();
            this.ahf = new ArrayList();
            this.ahg = new ArrayList();
            this.ahh = new ArrayList();
            this.ahi = new ArrayList();
            this.ahj = new ArrayList();
            this.ahk = new ArrayList();
            this.ahl = new ArrayList();
        }

        public C0467f m1674b(C0462a c0462a) {
            this.ahc.add(c0462a);
            return this;
        }

        public C0467f m1675c(C0462a c0462a) {
            this.ahd.add(c0462a);
            return this;
        }

        public C0467f cf(String str) {
            this.ahk.add(str);
            return this;
        }

        public C0467f cg(String str) {
            this.ahl.add(str);
            return this;
        }

        public C0467f ch(String str) {
            this.ahi.add(str);
            return this;
        }

        public C0467f ci(String str) {
            this.ahj.add(str);
            return this;
        }

        public C0467f m1676d(C0462a c0462a) {
            this.ahe.add(c0462a);
            return this;
        }

        public C0467f m1677e(C0462a c0462a) {
            this.ahf.add(c0462a);
            return this;
        }

        public C0467f m1678f(C0462a c0462a) {
            this.ahg.add(c0462a);
            return this;
        }

        public C0467f m1679g(C0462a c0462a) {
            this.ahh.add(c0462a);
            return this;
        }

        public C0466e mG() {
            return new C0466e(this.ahc, this.ahd, this.ahe, this.ahf, this.ahg, this.ahh, this.ahi, this.ahj, this.ahk, this.ahl);
        }
    }

    public static class C0468g extends Exception {
        public C0468g(String str) {
            super(str);
        }
    }

    private static C1082a m1680a(int i, C1077f c1077f, C1082a[] c1082aArr, Set<Integer> set) throws C0468g {
        int i2 = 0;
        if (set.contains(Integer.valueOf(i))) {
            cd("Value cycle detected.  Current value reference: " + i + "." + "  Previous value references: " + set + ".");
        }
        C1082a c1082a = (C1082a) m1683a(c1077f.eX, i, "values");
        if (c1082aArr[i] != null) {
            return c1082aArr[i];
        }
        C1082a c1082a2 = null;
        set.add(Integer.valueOf(i));
        C1079h h;
        int[] iArr;
        int length;
        int i3;
        int i4;
        switch (c1082a.type) {
            case 1:
            case 5:
            case 6:
            case 8:
                c1082a2 = c1082a;
                break;
            case 2:
                h = m1687h(c1082a);
                c1082a2 = m1686g(c1082a);
                c1082a2.fO = new C1082a[h.fz.length];
                iArr = h.fz;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    c1082a2.fO[i3] = m1680a(iArr[i2], c1077f, c1082aArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case 3:
                c1082a2 = m1686g(c1082a);
                C1079h h2 = m1687h(c1082a);
                if (h2.fA.length != h2.fB.length) {
                    cd("Uneven map keys (" + h2.fA.length + ") and map values (" + h2.fB.length + ")");
                }
                c1082a2.fP = new C1082a[h2.fA.length];
                c1082a2.fQ = new C1082a[h2.fA.length];
                int[] iArr2 = h2.fA;
                int length2 = iArr2.length;
                i3 = 0;
                i4 = 0;
                while (i3 < length2) {
                    int i5 = i4 + 1;
                    c1082a2.fP[i4] = m1680a(iArr2[i3], c1077f, c1082aArr, (Set) set);
                    i3++;
                    i4 = i5;
                }
                iArr = h2.fB;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    c1082a2.fQ[i3] = m1680a(iArr[i2], c1077f, c1082aArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
            case 4:
                c1082a2 = m1686g(c1082a);
                c1082a2.fR = dh.m1722j(m1680a(m1687h(c1082a).fE, c1077f, c1082aArr, (Set) set));
                break;
            case 7:
                c1082a2 = m1686g(c1082a);
                h = m1687h(c1082a);
                c1082a2.fV = new C1082a[h.fD.length];
                iArr = h.fD;
                length = iArr.length;
                i3 = 0;
                while (i2 < length) {
                    i4 = i3 + 1;
                    c1082a2.fV[i3] = m1680a(iArr[i2], c1077f, c1082aArr, (Set) set);
                    i2++;
                    i3 = i4;
                }
                break;
        }
        if (c1082a2 == null) {
            cd("Invalid value: " + c1082a);
        }
        c1082aArr[i] = c1082a2;
        set.remove(Integer.valueOf(i));
        return c1082a2;
    }

    private static C0462a m1681a(C1073b c1073b, C1077f c1077f, C1082a[] c1082aArr, int i) throws C0468g {
        C0463b mn = C0462a.mn();
        for (int valueOf : c1073b.eH) {
            C1076e c1076e = (C1076e) m1683a(c1077f.eY, Integer.valueOf(valueOf).intValue(), "properties");
            String str = (String) m1683a(c1077f.eW, c1076e.key, "keys");
            C1082a c1082a = (C1082a) m1683a(c1082aArr, c1076e.value, "values");
            if (C0272b.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                mn.m1671i(c1082a);
            } else {
                mn.m1670b(str, c1082a);
            }
        }
        return mn.mq();
    }

    private static C0466e m1682a(C1078g c1078g, List<C0462a> list, List<C0462a> list2, List<C0462a> list3, C1077f c1077f) {
        C0467f mv = C0466e.mv();
        for (int valueOf : c1078g.fn) {
            mv.m1674b((C0462a) list3.get(Integer.valueOf(valueOf).intValue()));
        }
        for (int valueOf2 : c1078g.fo) {
            mv.m1675c((C0462a) list3.get(Integer.valueOf(valueOf2).intValue()));
        }
        for (int valueOf22 : c1078g.fp) {
            mv.m1676d((C0462a) list.get(Integer.valueOf(valueOf22).intValue()));
        }
        for (int valueOf3 : c1078g.fr) {
            mv.cf(c1077f.eX[Integer.valueOf(valueOf3).intValue()].fN);
        }
        for (int valueOf222 : c1078g.fq) {
            mv.m1677e((C0462a) list.get(Integer.valueOf(valueOf222).intValue()));
        }
        for (int valueOf32 : c1078g.fs) {
            mv.cg(c1077f.eX[Integer.valueOf(valueOf32).intValue()].fN);
        }
        for (int valueOf2222 : c1078g.ft) {
            mv.m1678f((C0462a) list2.get(Integer.valueOf(valueOf2222).intValue()));
        }
        for (int valueOf322 : c1078g.fv) {
            mv.ch(c1077f.eX[Integer.valueOf(valueOf322).intValue()].fN);
        }
        for (int valueOf22222 : c1078g.fu) {
            mv.m1679g((C0462a) list2.get(Integer.valueOf(valueOf22222).intValue()));
        }
        for (int valueOf4 : c1078g.fw) {
            mv.ci(c1077f.eX[Integer.valueOf(valueOf4).intValue()].fN);
        }
        return mv.mG();
    }

    private static <T> T m1683a(T[] tArr, int i, String str) throws C0468g {
        if (i < 0 || i >= tArr.length) {
            cd("Index out of bounds detected: " + i + " in " + str);
        }
        return tArr[i];
    }

    public static C0464c m1684b(C1077f c1077f) throws C0468g {
        int i;
        int i2 = 0;
        C1082a[] c1082aArr = new C1082a[c1077f.eX.length];
        for (i = 0; i < c1077f.eX.length; i++) {
            m1680a(i, c1077f, c1082aArr, new HashSet(0));
        }
        C0465d mr = C0464c.mr();
        List arrayList = new ArrayList();
        for (i = 0; i < c1077f.fa.length; i++) {
            arrayList.add(m1681a(c1077f.fa[i], c1077f, c1082aArr, i));
        }
        List arrayList2 = new ArrayList();
        for (i = 0; i < c1077f.fb.length; i++) {
            arrayList2.add(m1681a(c1077f.fb[i], c1077f, c1082aArr, i));
        }
        List arrayList3 = new ArrayList();
        for (i = 0; i < c1077f.eZ.length; i++) {
            C0462a a = m1681a(c1077f.eZ[i], c1077f, c1082aArr, i);
            mr.m1672a(a);
            arrayList3.add(a);
        }
        C1078g[] c1078gArr = c1077f.fc;
        int length = c1078gArr.length;
        while (i2 < length) {
            mr.m1673a(m1682a(c1078gArr[i2], arrayList, arrayList3, arrayList2, c1077f));
            i2++;
        }
        mr.ce(c1077f.fg);
        mr.du(c1077f.fl);
        return mr.mu();
    }

    public static void m1685b(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static void cd(String str) throws C0468g {
        bh.m1642A(str);
        throw new C0468g(str);
    }

    public static C1082a m1686g(C1082a c1082a) {
        C1082a c1082a2 = new C1082a();
        c1082a2.type = c1082a.type;
        c1082a2.fW = (int[]) c1082a.fW.clone();
        if (c1082a.fX) {
            c1082a2.fX = c1082a.fX;
        }
        return c1082a2;
    }

    private static C1079h m1687h(C1082a c1082a) throws C0468g {
        if (((C1079h) c1082a.m2811a(C1079h.fx)) == null) {
            cd("Expected a ServingValue and didn't get one. Value is: " + c1082a);
        }
        return (C1079h) c1082a.m2811a(C1079h.fx);
    }
}
