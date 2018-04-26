package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0171a;
import com.google.android.gms.common.internal.safeparcel.C0171a.C0170a;
import com.google.android.gms.common.internal.safeparcel.C0172b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hy.C0758a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class ie extends hy implements SafeParcelable {
    public static final C0355if CREATOR = new C0355if();
    private final ib Hj;
    private final Parcel Hq;
    private final int Hr;
    private int Hs;
    private int Ht;
    private final String mClassName;
    private final int xM;

    ie(int i, Parcel parcel, ib ibVar) {
        this.xM = i;
        this.Hq = (Parcel) hm.m1232f(parcel);
        this.Hr = 2;
        this.Hj = ibVar;
        if (this.Hj == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.Hj.fW();
        }
        this.Hs = 2;
    }

    private ie(SafeParcelable safeParcelable, ib ibVar, String str) {
        this.xM = 1;
        this.Hq = Parcel.obtain();
        safeParcelable.writeToParcel(this.Hq, 0);
        this.Hr = 1;
        this.Hj = (ib) hm.m1232f(ibVar);
        this.mClassName = (String) hm.m1232f(str);
        this.Hs = 2;
    }

    public static <T extends hy & SafeParcelable> ie m2733a(T t) {
        String canonicalName = t.getClass().getCanonicalName();
        return new ie((SafeParcelable) t, m2739b((hy) t), canonicalName);
    }

    private static void m2734a(ib ibVar, hy hyVar) {
        Class cls = hyVar.getClass();
        if (!ibVar.m2732b(cls)) {
            HashMap fG = hyVar.fG();
            ibVar.m2731a(cls, hyVar.fG());
            for (String str : fG.keySet()) {
                C0758a c0758a = (C0758a) fG.get(str);
                Class fO = c0758a.fO();
                if (fO != null) {
                    try {
                        m2734a(ibVar, (hy) fO.newInstance());
                    } catch (Throwable e) {
                        throw new IllegalStateException("Could not instantiate an object of type " + c0758a.fO().getCanonicalName(), e);
                    } catch (Throwable e2) {
                        throw new IllegalStateException("Could not access object of type " + c0758a.fO().getCanonicalName(), e2);
                    }
                }
            }
        }
    }

    private void m2735a(StringBuilder stringBuilder, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                stringBuilder.append(obj);
                return;
            case 7:
                stringBuilder.append("\"").append(in.aK(obj.toString())).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(ih.m1271d((byte[]) obj)).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(ih.m1272e((byte[]) obj));
                stringBuilder.append("\"");
                return;
            case 10:
                io.m1277a(stringBuilder, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown type = " + i);
        }
    }

    private void m2736a(StringBuilder stringBuilder, C0758a<?, ?> c0758a, Parcel parcel, int i) {
        switch (c0758a.fF()) {
            case 0:
                m2742b(stringBuilder, (C0758a) c0758a, m1251a(c0758a, Integer.valueOf(C0171a.m212g(parcel, i))));
                return;
            case 1:
                m2742b(stringBuilder, (C0758a) c0758a, m1251a(c0758a, C0171a.m216k(parcel, i)));
                return;
            case 2:
                m2742b(stringBuilder, (C0758a) c0758a, m1251a(c0758a, Long.valueOf(C0171a.m214i(parcel, i))));
                return;
            case 3:
                m2742b(stringBuilder, (C0758a) c0758a, m1251a(c0758a, Float.valueOf(C0171a.m217l(parcel, i))));
                return;
            case 4:
                m2742b(stringBuilder, (C0758a) c0758a, m1251a(c0758a, Double.valueOf(C0171a.m218m(parcel, i))));
                return;
            case 5:
                m2742b(stringBuilder, (C0758a) c0758a, m1251a(c0758a, C0171a.m219n(parcel, i)));
                return;
            case 6:
                m2742b(stringBuilder, (C0758a) c0758a, m1251a(c0758a, Boolean.valueOf(C0171a.m208c(parcel, i))));
                return;
            case 7:
                m2742b(stringBuilder, (C0758a) c0758a, m1251a(c0758a, C0171a.m220o(parcel, i)));
                return;
            case 8:
            case 9:
                m2742b(stringBuilder, (C0758a) c0758a, m1251a(c0758a, C0171a.m223r(parcel, i)));
                return;
            case 10:
                m2742b(stringBuilder, (C0758a) c0758a, m1251a(c0758a, m2744d(C0171a.m222q(parcel, i))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException("Unknown field out type = " + c0758a.fF());
        }
    }

    private void m2737a(StringBuilder stringBuilder, String str, C0758a<?, ?> c0758a, Parcel parcel, int i) {
        stringBuilder.append("\"").append(str).append("\":");
        if (c0758a.fQ()) {
            m2736a(stringBuilder, c0758a, parcel, i);
        } else {
            m2741b(stringBuilder, c0758a, parcel, i);
        }
    }

    private void m2738a(StringBuilder stringBuilder, HashMap<String, C0758a<?, ?>> hashMap, Parcel parcel) {
        HashMap b = m2740b((HashMap) hashMap);
        stringBuilder.append('{');
        int B = C0171a.m196B(parcel);
        Object obj = null;
        while (parcel.dataPosition() < B) {
            int A = C0171a.m194A(parcel);
            Entry entry = (Entry) b.get(Integer.valueOf(C0171a.ar(A)));
            if (entry != null) {
                if (obj != null) {
                    stringBuilder.append(",");
                }
                m2737a(stringBuilder, (String) entry.getKey(), (C0758a) entry.getValue(), parcel, A);
                obj = 1;
            }
        }
        if (parcel.dataPosition() != B) {
            throw new C0170a("Overread allowed size end=" + B, parcel);
        }
        stringBuilder.append('}');
    }

    private static ib m2739b(hy hyVar) {
        ib ibVar = new ib(hyVar.getClass());
        m2734a(ibVar, hyVar);
        ibVar.fU();
        ibVar.fT();
        return ibVar;
    }

    private static HashMap<Integer, Entry<String, C0758a<?, ?>>> m2740b(HashMap<String, C0758a<?, ?>> hashMap) {
        HashMap<Integer, Entry<String, C0758a<?, ?>>> hashMap2 = new HashMap();
        for (Entry entry : hashMap.entrySet()) {
            hashMap2.put(Integer.valueOf(((C0758a) entry.getValue()).fN()), entry);
        }
        return hashMap2;
    }

    private void m2741b(StringBuilder stringBuilder, C0758a<?, ?> c0758a, Parcel parcel, int i) {
        if (c0758a.fL()) {
            stringBuilder.append("[");
            switch (c0758a.fF()) {
                case 0:
                    ig.m1266a(stringBuilder, C0171a.m226u(parcel, i));
                    break;
                case 1:
                    ig.m1268a(stringBuilder, C0171a.m228w(parcel, i));
                    break;
                case 2:
                    ig.m1267a(stringBuilder, C0171a.m227v(parcel, i));
                    break;
                case 3:
                    ig.m1265a(stringBuilder, C0171a.m229x(parcel, i));
                    break;
                case 4:
                    ig.m1264a(stringBuilder, C0171a.m230y(parcel, i));
                    break;
                case 5:
                    ig.m1268a(stringBuilder, C0171a.m231z(parcel, i));
                    break;
                case 6:
                    ig.m1270a(stringBuilder, C0171a.m225t(parcel, i));
                    break;
                case 7:
                    ig.m1269a(stringBuilder, C0171a.m195A(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] D = C0171a.m199D(parcel, i);
                    int length = D.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            stringBuilder.append(",");
                        }
                        D[i2].setDataPosition(0);
                        m2738a(stringBuilder, c0758a.fS(), D[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            stringBuilder.append("]");
            return;
        }
        switch (c0758a.fF()) {
            case 0:
                stringBuilder.append(C0171a.m212g(parcel, i));
                return;
            case 1:
                stringBuilder.append(C0171a.m216k(parcel, i));
                return;
            case 2:
                stringBuilder.append(C0171a.m214i(parcel, i));
                return;
            case 3:
                stringBuilder.append(C0171a.m217l(parcel, i));
                return;
            case 4:
                stringBuilder.append(C0171a.m218m(parcel, i));
                return;
            case 5:
                stringBuilder.append(C0171a.m219n(parcel, i));
                return;
            case 6:
                stringBuilder.append(C0171a.m208c(parcel, i));
                return;
            case 7:
                stringBuilder.append("\"").append(in.aK(C0171a.m220o(parcel, i))).append("\"");
                return;
            case 8:
                stringBuilder.append("\"").append(ih.m1271d(C0171a.m223r(parcel, i))).append("\"");
                return;
            case 9:
                stringBuilder.append("\"").append(ih.m1272e(C0171a.m223r(parcel, i)));
                stringBuilder.append("\"");
                return;
            case 10:
                Bundle q = C0171a.m222q(parcel, i);
                Set<String> keySet = q.keySet();
                keySet.size();
                stringBuilder.append("{");
                int i3 = 1;
                for (String str : keySet) {
                    if (i3 == 0) {
                        stringBuilder.append(",");
                    }
                    stringBuilder.append("\"").append(str).append("\"");
                    stringBuilder.append(":");
                    stringBuilder.append("\"").append(in.aK(q.getString(str))).append("\"");
                    i3 = 0;
                }
                stringBuilder.append("}");
                return;
            case 11:
                Parcel C = C0171a.m198C(parcel, i);
                C.setDataPosition(0);
                m2738a(stringBuilder, c0758a.fS(), C);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    private void m2742b(StringBuilder stringBuilder, C0758a<?, ?> c0758a, Object obj) {
        if (c0758a.fK()) {
            m2743b(stringBuilder, (C0758a) c0758a, (ArrayList) obj);
        } else {
            m2735a(stringBuilder, c0758a.fE(), obj);
        }
    }

    private void m2743b(StringBuilder stringBuilder, C0758a<?, ?> c0758a, ArrayList<?> arrayList) {
        stringBuilder.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            m2735a(stringBuilder, c0758a.fE(), arrayList.get(i));
        }
        stringBuilder.append("]");
    }

    public static HashMap<String, String> m2744d(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    protected Object aF(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    protected boolean aG(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public int describeContents() {
        C0355if c0355if = CREATOR;
        return 0;
    }

    public HashMap<String, C0758a<?, ?>> fG() {
        return this.Hj == null ? null : this.Hj.aJ(this.mClassName);
    }

    public Parcel fY() {
        switch (this.Hs) {
            case 0:
                this.Ht = C0172b.m232C(this.Hq);
                C0172b.m235G(this.Hq, this.Ht);
                this.Hs = 2;
                break;
            case 1:
                C0172b.m235G(this.Hq, this.Ht);
                this.Hs = 2;
                break;
        }
        return this.Hq;
    }

    ib fZ() {
        switch (this.Hr) {
            case 0:
                return null;
            case 1:
                return this.Hj;
            case 2:
                return this.Hj;
            default:
                throw new IllegalStateException("Invalid creation type: " + this.Hr);
        }
    }

    public int getVersionCode() {
        return this.xM;
    }

    public String toString() {
        hm.m1228b(this.Hj, (Object) "Cannot convert to JSON on client side.");
        Parcel fY = fY();
        fY.setDataPosition(0);
        StringBuilder stringBuilder = new StringBuilder(100);
        m2738a(stringBuilder, this.Hj.aJ(this.mClassName), fY);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        C0355if c0355if = CREATOR;
        C0355if.m1262a(this, out, flags);
    }
}
