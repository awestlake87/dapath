package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class hy {

    public interface C0353b<I, O> {
        int fE();

        int fF();

        I mo1791g(O o);
    }

    public static class C0758a<I, O> implements SafeParcelable {
        public static final hz CREATOR = new hz();
        protected final int Hb;
        protected final boolean Hc;
        protected final int Hd;
        protected final boolean He;
        protected final String Hf;
        protected final int Hg;
        protected final Class<? extends hy> Hh;
        protected final String Hi;
        private ib Hj;
        private C0353b<I, O> Hk;
        private final int xM;

        C0758a(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, ht htVar) {
            this.xM = i;
            this.Hb = i2;
            this.Hc = z;
            this.Hd = i3;
            this.He = z2;
            this.Hf = str;
            this.Hg = i4;
            if (str2 == null) {
                this.Hh = null;
                this.Hi = null;
            } else {
                this.Hh = ie.class;
                this.Hi = str2;
            }
            if (htVar == null) {
                this.Hk = null;
            } else {
                this.Hk = htVar.fC();
            }
        }

        protected C0758a(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends hy> cls, C0353b<I, O> c0353b) {
            this.xM = 1;
            this.Hb = i;
            this.Hc = z;
            this.Hd = i2;
            this.He = z2;
            this.Hf = str;
            this.Hg = i3;
            this.Hh = cls;
            if (cls == null) {
                this.Hi = null;
            } else {
                this.Hi = cls.getCanonicalName();
            }
            this.Hk = c0353b;
        }

        public static C0758a m2718a(String str, int i, C0353b<?, ?> c0353b, boolean z) {
            return new C0758a(c0353b.fE(), z, c0353b.fF(), false, str, i, null, c0353b);
        }

        public static <T extends hy> C0758a<T, T> m2719a(String str, int i, Class<T> cls) {
            return new C0758a(11, false, 11, false, str, i, cls, null);
        }

        public static <T extends hy> C0758a<ArrayList<T>, ArrayList<T>> m2720b(String str, int i, Class<T> cls) {
            return new C0758a(11, true, 11, true, str, i, cls, null);
        }

        public static C0758a<Integer, Integer> m2722g(String str, int i) {
            return new C0758a(0, false, 0, false, str, i, null, null);
        }

        public static C0758a<Double, Double> m2723h(String str, int i) {
            return new C0758a(4, false, 4, false, str, i, null, null);
        }

        public static C0758a<Boolean, Boolean> m2724i(String str, int i) {
            return new C0758a(6, false, 6, false, str, i, null, null);
        }

        public static C0758a<String, String> m2725j(String str, int i) {
            return new C0758a(7, false, 7, false, str, i, null, null);
        }

        public static C0758a<ArrayList<String>, ArrayList<String>> m2726k(String str, int i) {
            return new C0758a(7, true, 7, true, str, i, null, null);
        }

        public void m2727a(ib ibVar) {
            this.Hj = ibVar;
        }

        public int describeContents() {
            hz hzVar = CREATOR;
            return 0;
        }

        public int fE() {
            return this.Hb;
        }

        public int fF() {
            return this.Hd;
        }

        public C0758a<I, O> fJ() {
            return new C0758a(this.xM, this.Hb, this.Hc, this.Hd, this.He, this.Hf, this.Hg, this.Hi, fR());
        }

        public boolean fK() {
            return this.Hc;
        }

        public boolean fL() {
            return this.He;
        }

        public String fM() {
            return this.Hf;
        }

        public int fN() {
            return this.Hg;
        }

        public Class<? extends hy> fO() {
            return this.Hh;
        }

        String fP() {
            return this.Hi == null ? null : this.Hi;
        }

        public boolean fQ() {
            return this.Hk != null;
        }

        ht fR() {
            return this.Hk == null ? null : ht.m2713a(this.Hk);
        }

        public HashMap<String, C0758a<?, ?>> fS() {
            hm.m1232f(this.Hi);
            hm.m1232f(this.Hj);
            return this.Hj.aJ(this.Hi);
        }

        public I m2728g(O o) {
            return this.Hk.mo1791g(o);
        }

        public int getVersionCode() {
            return this.xM;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Field\n");
            stringBuilder.append("            versionCode=").append(this.xM).append('\n');
            stringBuilder.append("                 typeIn=").append(this.Hb).append('\n');
            stringBuilder.append("            typeInArray=").append(this.Hc).append('\n');
            stringBuilder.append("                typeOut=").append(this.Hd).append('\n');
            stringBuilder.append("           typeOutArray=").append(this.He).append('\n');
            stringBuilder.append("        outputFieldName=").append(this.Hf).append('\n');
            stringBuilder.append("      safeParcelFieldId=").append(this.Hg).append('\n');
            stringBuilder.append("       concreteTypeName=").append(fP()).append('\n');
            if (fO() != null) {
                stringBuilder.append("     concreteType.class=").append(fO().getCanonicalName()).append('\n');
            }
            stringBuilder.append("          converterName=").append(this.Hk == null ? "null" : this.Hk.getClass().getCanonicalName()).append('\n');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel out, int flags) {
            hz hzVar = CREATOR;
            hz.m1254a(this, out, flags);
        }
    }

    private void m1249a(StringBuilder stringBuilder, C0758a c0758a, Object obj) {
        if (c0758a.fE() == 11) {
            stringBuilder.append(((hy) c0758a.fO().cast(obj)).toString());
        } else if (c0758a.fE() == 7) {
            stringBuilder.append("\"");
            stringBuilder.append(in.aK((String) obj));
            stringBuilder.append("\"");
        } else {
            stringBuilder.append(obj);
        }
    }

    private void m1250a(StringBuilder stringBuilder, C0758a c0758a, ArrayList<Object> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                m1249a(stringBuilder, c0758a, obj);
            }
        }
        stringBuilder.append("]");
    }

    protected <O, I> I m1251a(C0758a<I, O> c0758a, Object obj) {
        return c0758a.Hk != null ? c0758a.m2728g(obj) : obj;
    }

    protected boolean mo2859a(C0758a c0758a) {
        return c0758a.fF() == 11 ? c0758a.fL() ? aI(c0758a.fM()) : aH(c0758a.fM()) : aG(c0758a.fM());
    }

    protected abstract Object aF(String str);

    protected abstract boolean aG(String str);

    protected boolean aH(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean aI(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    protected Object mo2860b(C0758a c0758a) {
        String fM = c0758a.fM();
        if (c0758a.fO() == null) {
            return aF(c0758a.fM());
        }
        hm.m1227a(aF(c0758a.fM()) == null, "Concrete field shouldn't be value object: %s", c0758a.fM());
        Map fI = c0758a.fL() ? fI() : fH();
        if (fI != null) {
            return fI.get(fM);
        }
        try {
            return getClass().getMethod("get" + Character.toUpperCase(fM.charAt(0)) + fM.substring(1), new Class[0]).invoke(this, new Object[0]);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public abstract HashMap<String, C0758a<?, ?>> fG();

    public HashMap<String, Object> fH() {
        return null;
    }

    public HashMap<String, Object> fI() {
        return null;
    }

    public String toString() {
        HashMap fG = fG();
        StringBuilder stringBuilder = new StringBuilder(100);
        for (String str : fG.keySet()) {
            C0758a c0758a = (C0758a) fG.get(str);
            if (mo2859a(c0758a)) {
                Object a = m1251a(c0758a, mo2860b(c0758a));
                if (stringBuilder.length() == 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append("\"").append(str).append("\":");
                if (a != null) {
                    switch (c0758a.fF()) {
                        case 8:
                            stringBuilder.append("\"").append(ih.m1271d((byte[]) a)).append("\"");
                            break;
                        case 9:
                            stringBuilder.append("\"").append(ih.m1272e((byte[]) a)).append("\"");
                            break;
                        case 10:
                            io.m1277a(stringBuilder, (HashMap) a);
                            break;
                        default:
                            if (!c0758a.fK()) {
                                m1249a(stringBuilder, c0758a, a);
                                break;
                            }
                            m1250a(stringBuilder, c0758a, (ArrayList) a);
                            break;
                    }
                }
                stringBuilder.append("null");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append("}");
        } else {
            stringBuilder.append("{}");
        }
        return stringBuilder.toString();
    }
}
