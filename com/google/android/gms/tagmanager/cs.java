package com.google.android.gms.tagmanager;

import android.content.Context;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.internal.C0272b;
import com.google.android.gms.internal.C0276c.C1080i;
import com.google.android.gms.internal.C0295d.C1082a;
import com.google.android.gms.tagmanager.C0480l.C0479a;
import com.google.android.gms.tagmanager.C0952s.C0485a;
import com.google.android.gms.tagmanager.cq.C0462a;
import com.google.android.gms.tagmanager.cq.C0464c;
import com.google.android.gms.tagmanager.cq.C0466e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class cs {
    private static final by<C1082a> ahm = new by(dh.nd(), true);
    private final DataLayer aeu;
    private final C0464c ahn;
    private final ag aho;
    private final Map<String, aj> ahp;
    private final Map<String, aj> ahq;
    private final Map<String, aj> ahr;
    private final C0478k<C0462a, by<C1082a>> ahs;
    private final C0478k<String, C0470b> aht;
    private final Set<C0466e> ahu;
    private final Map<String, C0471c> ahv;
    private volatile String ahw;
    private int ahx;

    interface C0469a {
        void mo2339a(C0466e c0466e, Set<C0462a> set, Set<C0462a> set2, cm cmVar);
    }

    private static class C0470b {
        private C1082a agY;
        private by<C1082a> ahD;

        public C0470b(by<C1082a> byVar, C1082a c1082a) {
            this.ahD = byVar;
            this.agY = c1082a;
        }

        public int getSize() {
            return (this.agY == null ? 0 : this.agY.nZ()) + ((C1082a) this.ahD.getObject()).nZ();
        }

        public by<C1082a> mJ() {
            return this.ahD;
        }

        public C1082a mp() {
            return this.agY;
        }
    }

    private static class C0471c {
        private final Map<C0466e, List<C0462a>> ahE = new HashMap();
        private final Map<C0466e, List<C0462a>> ahF = new HashMap();
        private final Map<C0466e, List<String>> ahG = new HashMap();
        private final Map<C0466e, List<String>> ahH = new HashMap();
        private C0462a ahI;
        private final Set<C0466e> ahu = new HashSet();

        public void m1690a(C0466e c0466e, C0462a c0462a) {
            List list = (List) this.ahE.get(c0466e);
            if (list == null) {
                list = new ArrayList();
                this.ahE.put(c0466e, list);
            }
            list.add(c0462a);
        }

        public void m1691a(C0466e c0466e, String str) {
            List list = (List) this.ahG.get(c0466e);
            if (list == null) {
                list = new ArrayList();
                this.ahG.put(c0466e, list);
            }
            list.add(str);
        }

        public void m1692b(C0466e c0466e) {
            this.ahu.add(c0466e);
        }

        public void m1693b(C0466e c0466e, C0462a c0462a) {
            List list = (List) this.ahF.get(c0466e);
            if (list == null) {
                list = new ArrayList();
                this.ahF.put(c0466e, list);
            }
            list.add(c0462a);
        }

        public void m1694b(C0466e c0466e, String str) {
            List list = (List) this.ahH.get(c0466e);
            if (list == null) {
                list = new ArrayList();
                this.ahH.put(c0466e, list);
            }
            list.add(str);
        }

        public void m1695i(C0462a c0462a) {
            this.ahI = c0462a;
        }

        public Set<C0466e> mK() {
            return this.ahu;
        }

        public Map<C0466e, List<C0462a>> mL() {
            return this.ahE;
        }

        public Map<C0466e, List<String>> mM() {
            return this.ahG;
        }

        public Map<C0466e, List<String>> mN() {
            return this.ahH;
        }

        public Map<C0466e, List<C0462a>> mO() {
            return this.ahF;
        }

        public C0462a mP() {
            return this.ahI;
        }
    }

    class C09301 implements C0479a<C0462a, by<C1082a>> {
        final /* synthetic */ cs ahy;

        C09301(cs csVar) {
            this.ahy = csVar;
        }

        public int m2997a(C0462a c0462a, by<C1082a> byVar) {
            return ((C1082a) byVar.getObject()).nZ();
        }

        public /* synthetic */ int sizeOf(Object x0, Object x1) {
            return m2997a((C0462a) x0, (by) x1);
        }
    }

    class C09312 implements C0479a<String, C0470b> {
        final /* synthetic */ cs ahy;

        C09312(cs csVar) {
            this.ahy = csVar;
        }

        public int m2998a(String str, C0470b c0470b) {
            return str.length() + c0470b.getSize();
        }

        public /* synthetic */ int sizeOf(Object x0, Object x1) {
            return m2998a((String) x0, (C0470b) x1);
        }
    }

    class C09334 implements C0469a {
        final /* synthetic */ cs ahy;

        C09334(cs csVar) {
            this.ahy = csVar;
        }

        public void mo2339a(C0466e c0466e, Set<C0462a> set, Set<C0462a> set2, cm cmVar) {
            set.addAll(c0466e.my());
            set2.addAll(c0466e.mz());
            cmVar.lW().mo2316b(c0466e.my(), c0466e.mD());
            cmVar.lX().mo2316b(c0466e.mz(), c0466e.mE());
        }
    }

    public cs(Context context, C0464c c0464c, DataLayer dataLayer, C0485a c0485a, C0485a c0485a2, ag agVar) {
        if (c0464c == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.ahn = c0464c;
        this.ahu = new HashSet(c0464c.ms());
        this.aeu = dataLayer;
        this.aho = agVar;
        this.ahs = new C0480l().m1743a(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new C09301(this));
        this.aht = new C0480l().m1743a(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, new C09312(this));
        this.ahp = new HashMap();
        m1710b(new C1139i(context));
        m1710b(new C0952s(c0485a2));
        m1710b(new C1142w(dataLayer));
        m1710b(new di(context, dataLayer));
        this.ahq = new HashMap();
        m1711c(new C1200q());
        m1711c(new ad());
        m1711c(new ae());
        m1711c(new al());
        m1711c(new am());
        m1711c(new bd());
        m1711c(new be());
        m1711c(new ch());
        m1711c(new db());
        this.ahr = new HashMap();
        m1709a(new C0924b(context));
        m1709a(new C0926c(context));
        m1709a(new C0937e(context));
        m1709a(new C0938f(context));
        m1709a(new C0939g(context));
        m1709a(new C0940h(context));
        m1709a(new C0943m());
        m1709a(new C0951p(this.ahn.getVersion()));
        m1709a(new C0952s(c0485a));
        m1709a(new C0953u(dataLayer));
        m1709a(new C0957z(context));
        m1709a(new aa());
        m1709a(new ac());
        m1709a(new ah(this));
        m1709a(new an());
        m1709a(new ao());
        m1709a(new ax(context));
        m1709a(new az());
        m1709a(new bc());
        m1709a(new bk(context));
        m1709a(new bz());
        m1709a(new cb());
        m1709a(new ce());
        m1709a(new cg());
        m1709a(new ci(context));
        m1709a(new ct());
        m1709a(new cu());
        m1709a(new dd());
        this.ahv = new HashMap();
        for (C0466e c0466e : this.ahu) {
            if (agVar.lK()) {
                m1701a(c0466e.mA(), c0466e.mB(), "add macro");
                m1701a(c0466e.mF(), c0466e.mC(), "remove macro");
                m1701a(c0466e.my(), c0466e.mD(), "add tag");
                m1701a(c0466e.mz(), c0466e.mE(), "remove tag");
            }
            int i = 0;
            while (i < c0466e.mA().size()) {
                C0462a c0462a = (C0462a) c0466e.mA().get(i);
                String str = "Unknown";
                if (agVar.lK() && i < c0466e.mB().size()) {
                    str = (String) c0466e.mB().get(i);
                }
                C0471c d = m1703d(this.ahv, m1704h(c0462a));
                d.m1692b(c0466e);
                d.m1690a(c0466e, c0462a);
                d.m1691a(c0466e, str);
                i++;
            }
            i = 0;
            while (i < c0466e.mF().size()) {
                c0462a = (C0462a) c0466e.mF().get(i);
                str = "Unknown";
                if (agVar.lK() && i < c0466e.mC().size()) {
                    str = (String) c0466e.mC().get(i);
                }
                d = m1703d(this.ahv, m1704h(c0462a));
                d.m1692b(c0466e);
                d.m1693b(c0466e, c0462a);
                d.m1694b(c0466e, str);
                i++;
            }
        }
        for (Entry entry : this.ahn.mt().entrySet()) {
            for (C0462a c0462a2 : (List) entry.getValue()) {
                if (!dh.m1728n((C1082a) c0462a2.mo().get(C0272b.NOT_DEFAULT_MACRO.toString())).booleanValue()) {
                    m1703d(this.ahv, (String) entry.getKey()).m1695i(c0462a2);
                }
            }
        }
    }

    private by<C1082a> m1696a(C1082a c1082a, Set<String> set, dj djVar) {
        if (!c1082a.fX) {
            return new by(c1082a, true);
        }
        C1082a g;
        int i;
        by a;
        switch (c1082a.type) {
            case 2:
                g = cq.m1686g(c1082a);
                g.fO = new C1082a[c1082a.fO.length];
                for (i = 0; i < c1082a.fO.length; i++) {
                    a = m1696a(c1082a.fO[i], (Set) set, djVar.dq(i));
                    if (a == ahm) {
                        return ahm;
                    }
                    g.fO[i] = (C1082a) a.getObject();
                }
                return new by(g, false);
            case 3:
                g = cq.m1686g(c1082a);
                if (c1082a.fP.length != c1082a.fQ.length) {
                    bh.m1642A("Invalid serving value: " + c1082a.toString());
                    return ahm;
                }
                g.fP = new C1082a[c1082a.fP.length];
                g.fQ = new C1082a[c1082a.fP.length];
                for (i = 0; i < c1082a.fP.length; i++) {
                    a = m1696a(c1082a.fP[i], (Set) set, djVar.dr(i));
                    by a2 = m1696a(c1082a.fQ[i], (Set) set, djVar.ds(i));
                    if (a == ahm || a2 == ahm) {
                        return ahm;
                    }
                    g.fP[i] = (C1082a) a.getObject();
                    g.fQ[i] = (C1082a) a2.getObject();
                }
                return new by(g, false);
            case 4:
                if (set.contains(c1082a.fR)) {
                    bh.m1642A("Macro cycle detected.  Current macro reference: " + c1082a.fR + "." + "  Previous macro references: " + set.toString() + ".");
                    return ahm;
                }
                set.add(c1082a.fR);
                by<C1082a> a3 = dk.m1739a(m1697a(c1082a.fR, (Set) set, djVar.lZ()), c1082a.fW);
                set.remove(c1082a.fR);
                return a3;
            case 7:
                g = cq.m1686g(c1082a);
                g.fV = new C1082a[c1082a.fV.length];
                for (i = 0; i < c1082a.fV.length; i++) {
                    a = m1696a(c1082a.fV[i], (Set) set, djVar.dt(i));
                    if (a == ahm) {
                        return ahm;
                    }
                    g.fV[i] = (C1082a) a.getObject();
                }
                return new by(g, false);
            default:
                bh.m1642A("Unknown type: " + c1082a.type);
                return ahm;
        }
    }

    private by<C1082a> m1697a(String str, Set<String> set, bj bjVar) {
        this.ahx++;
        C0470b c0470b = (C0470b) this.aht.get(str);
        if (c0470b == null || this.aho.lK()) {
            C0471c c0471c = (C0471c) this.ahv.get(str);
            if (c0471c == null) {
                bh.m1642A(mI() + "Invalid macro: " + str);
                this.ahx--;
                return ahm;
            }
            C0462a mP;
            by a = m1707a(str, c0471c.mK(), c0471c.mL(), c0471c.mM(), c0471c.mO(), c0471c.mN(), set, bjVar.lB());
            if (((Set) a.getObject()).isEmpty()) {
                mP = c0471c.mP();
            } else {
                if (((Set) a.getObject()).size() > 1) {
                    bh.m1645D(mI() + "Multiple macros active for macroName " + str);
                }
                mP = (C0462a) ((Set) a.getObject()).iterator().next();
            }
            if (mP == null) {
                this.ahx--;
                return ahm;
            }
            by a2 = m1698a(this.ahr, mP, (Set) set, bjVar.lQ());
            boolean z = a.ma() && a2.ma();
            by<C1082a> byVar = a2 == ahm ? ahm : new by(a2.getObject(), z);
            C1082a mp = mP.mp();
            if (byVar.ma()) {
                this.aht.mo2300e(str, new C0470b(byVar, mp));
            }
            m1700a(mp, (Set) set);
            this.ahx--;
            return byVar;
        }
        m1700a(c0470b.mp(), (Set) set);
        this.ahx--;
        return c0470b.mJ();
    }

    private by<C1082a> m1698a(Map<String, aj> map, C0462a c0462a, Set<String> set, cj cjVar) {
        boolean z = true;
        C1082a c1082a = (C1082a) c0462a.mo().get(C0272b.FUNCTION.toString());
        if (c1082a == null) {
            bh.m1642A("No function id in properties");
            return ahm;
        }
        String str = c1082a.fS;
        aj ajVar = (aj) map.get(str);
        if (ajVar == null) {
            bh.m1642A(str + " has no backing implementation.");
            return ahm;
        }
        by<C1082a> byVar = (by) this.ahs.get(c0462a);
        if (byVar != null && !this.aho.lK()) {
            return byVar;
        }
        Map hashMap = new HashMap();
        boolean z2 = true;
        for (Entry entry : c0462a.mo().entrySet()) {
            by a = m1696a((C1082a) entry.getValue(), (Set) set, cjVar.bZ((String) entry.getKey()).mo2315e((C1082a) entry.getValue()));
            if (a == ahm) {
                return ahm;
            }
            boolean z3;
            if (a.ma()) {
                c0462a.m1669a((String) entry.getKey(), (C1082a) a.getObject());
                z3 = z2;
            } else {
                z3 = false;
            }
            hashMap.put(entry.getKey(), a.getObject());
            z2 = z3;
        }
        if (ajVar.m1626a(hashMap.keySet())) {
            if (!(z2 && ajVar.lh())) {
                z = false;
            }
            byVar = new by(ajVar.mo2295w(hashMap), z);
            if (z) {
                this.ahs.mo2300e(c0462a, byVar);
            }
            cjVar.mo2314d((C1082a) byVar.getObject());
            return byVar;
        }
        bh.m1642A("Incorrect keys for function " + str + " required " + ajVar.lM() + " had " + hashMap.keySet());
        return ahm;
    }

    private by<Set<C0462a>> m1699a(Set<C0466e> set, Set<String> set2, C0469a c0469a, cr crVar) {
        Set hashSet = new HashSet();
        Collection hashSet2 = new HashSet();
        boolean z = true;
        for (C0466e c0466e : set) {
            cm lY = crVar.lY();
            by a = m1706a(c0466e, (Set) set2, lY);
            if (((Boolean) a.getObject()).booleanValue()) {
                c0469a.mo2339a(c0466e, hashSet, hashSet2, lY);
            }
            boolean z2 = z && a.ma();
            z = z2;
        }
        hashSet.removeAll(hashSet2);
        crVar.mo2324b(hashSet);
        return new by(hashSet, z);
    }

    private void m1700a(C1082a c1082a, Set<String> set) {
        if (c1082a != null) {
            by a = m1696a(c1082a, (Set) set, new bw());
            if (a != ahm) {
                Object o = dh.m1730o((C1082a) a.getObject());
                if (o instanceof Map) {
                    this.aeu.push((Map) o);
                } else if (o instanceof List) {
                    for (Object o2 : (List) o2) {
                        if (o2 instanceof Map) {
                            this.aeu.push((Map) o2);
                        } else {
                            bh.m1645D("pushAfterEvaluate: value not a Map");
                        }
                    }
                } else {
                    bh.m1645D("pushAfterEvaluate: value not a Map or List");
                }
            }
        }
    }

    private static void m1701a(List<C0462a> list, List<String> list2, String str) {
        if (list.size() != list2.size()) {
            bh.m1643B("Invalid resource: imbalance of rule names of functions for " + str + " operation. Using default rule name instead");
        }
    }

    private static void m1702a(Map<String, aj> map, aj ajVar) {
        if (map.containsKey(ajVar.lL())) {
            throw new IllegalArgumentException("Duplicate function type name: " + ajVar.lL());
        }
        map.put(ajVar.lL(), ajVar);
    }

    private static C0471c m1703d(Map<String, C0471c> map, String str) {
        C0471c c0471c = (C0471c) map.get(str);
        if (c0471c != null) {
            return c0471c;
        }
        c0471c = new C0471c();
        map.put(str, c0471c);
        return c0471c;
    }

    private static String m1704h(C0462a c0462a) {
        return dh.m1722j((C1082a) c0462a.mo().get(C0272b.INSTANCE_NAME.toString()));
    }

    private String mI() {
        if (this.ahx <= 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.ahx));
        for (int i = 2; i < this.ahx; i++) {
            stringBuilder.append(' ');
        }
        stringBuilder.append(": ");
        return stringBuilder.toString();
    }

    by<Boolean> m1705a(C0462a c0462a, Set<String> set, cj cjVar) {
        by a = m1698a(this.ahq, c0462a, (Set) set, cjVar);
        Boolean n = dh.m1728n((C1082a) a.getObject());
        cjVar.mo2314d(dh.m1733r(n));
        return new by(n, a.ma());
    }

    by<Boolean> m1706a(C0466e c0466e, Set<String> set, cm cmVar) {
        boolean z = true;
        for (C0462a a : c0466e.mx()) {
            by a2 = m1705a(a, (Set) set, cmVar.lS());
            if (((Boolean) a2.getObject()).booleanValue()) {
                cmVar.mo2317f(dh.m1733r(Boolean.valueOf(false)));
                return new by(Boolean.valueOf(false), a2.ma());
            }
            boolean z2 = z && a2.ma();
            z = z2;
        }
        for (C0462a a3 : c0466e.mw()) {
            a2 = m1705a(a3, (Set) set, cmVar.lT());
            if (((Boolean) a2.getObject()).booleanValue()) {
                z = z && a2.ma();
            } else {
                cmVar.mo2317f(dh.m1733r(Boolean.valueOf(false)));
                return new by(Boolean.valueOf(false), a2.ma());
            }
        }
        cmVar.mo2317f(dh.m1733r(Boolean.valueOf(true)));
        return new by(Boolean.valueOf(true), z);
    }

    by<Set<C0462a>> m1707a(String str, Set<C0466e> set, Map<C0466e, List<C0462a>> map, Map<C0466e, List<String>> map2, Map<C0466e, List<C0462a>> map3, Map<C0466e, List<String>> map4, Set<String> set2, cr crVar) {
        final Map<C0466e, List<C0462a>> map5 = map;
        final Map<C0466e, List<String>> map6 = map2;
        final Map<C0466e, List<C0462a>> map7 = map3;
        final Map<C0466e, List<String>> map8 = map4;
        return m1699a((Set) set, (Set) set2, new C0469a(this) {
            final /* synthetic */ cs ahy;

            public void mo2339a(C0466e c0466e, Set<C0462a> set, Set<C0462a> set2, cm cmVar) {
                List list = (List) map5.get(c0466e);
                List list2 = (List) map6.get(c0466e);
                if (list != null) {
                    set.addAll(list);
                    cmVar.lU().mo2316b(list, list2);
                }
                list = (List) map7.get(c0466e);
                list2 = (List) map8.get(c0466e);
                if (list != null) {
                    set2.addAll(list);
                    cmVar.lV().mo2316b(list, list2);
                }
            }
        }, crVar);
    }

    by<Set<C0462a>> m1708a(Set<C0466e> set, cr crVar) {
        return m1699a((Set) set, new HashSet(), new C09334(this), crVar);
    }

    void m1709a(aj ajVar) {
        m1702a(this.ahr, ajVar);
    }

    void m1710b(aj ajVar) {
        m1702a(this.ahp, ajVar);
    }

    public synchronized void bH(String str) {
        ck(str);
        af bT = this.aho.bT(str);
        C0486t lI = bT.lI();
        for (C0462a a : (Set) m1708a(this.ahu, lI.lB()).getObject()) {
            m1698a(this.ahp, a, new HashSet(), lI.lA());
        }
        bT.lJ();
        ck(null);
    }

    void m1711c(aj ajVar) {
        m1702a(this.ahq, ajVar);
    }

    public by<C1082a> cj(String str) {
        this.ahx = 0;
        af bS = this.aho.bS(str);
        by<C1082a> a = m1697a(str, new HashSet(), bS.lH());
        bS.lJ();
        return a;
    }

    synchronized void ck(String str) {
        this.ahw = str;
    }

    public synchronized void m1712h(List<C1080i> list) {
        for (C1080i c1080i : list) {
            if (c1080i.name == null || !c1080i.name.startsWith("gaExperiment:")) {
                bh.m1644C("Ignored supplemental: " + c1080i);
            } else {
                ai.m1622a(this.aeu, c1080i);
            }
        }
    }

    synchronized String mH() {
        return this.ahw;
    }
}
