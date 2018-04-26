package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hy.C0758a;
import java.util.ArrayList;
import java.util.HashMap;

public class ib implements SafeParcelable {
    public static final ic CREATOR = new ic();
    private final HashMap<String, HashMap<String, C0758a<?, ?>>> Hl;
    private final ArrayList<C0759a> Hm;
    private final String Hn;
    private final int xM;

    public static class C0759a implements SafeParcelable {
        public static final id CREATOR = new id();
        final ArrayList<C0760b> Ho;
        final String className;
        final int versionCode;

        C0759a(int i, String str, ArrayList<C0760b> arrayList) {
            this.versionCode = i;
            this.className = str;
            this.Ho = arrayList;
        }

        C0759a(String str, HashMap<String, C0758a<?, ?>> hashMap) {
            this.versionCode = 1;
            this.className = str;
            this.Ho = C0759a.m2729a(hashMap);
        }

        private static ArrayList<C0760b> m2729a(HashMap<String, C0758a<?, ?>> hashMap) {
            if (hashMap == null) {
                return null;
            }
            ArrayList<C0760b> arrayList = new ArrayList();
            for (String str : hashMap.keySet()) {
                arrayList.add(new C0760b(str, (C0758a) hashMap.get(str)));
            }
            return arrayList;
        }

        public int describeContents() {
            id idVar = CREATOR;
            return 0;
        }

        HashMap<String, C0758a<?, ?>> fX() {
            HashMap<String, C0758a<?, ?>> hashMap = new HashMap();
            int size = this.Ho.size();
            for (int i = 0; i < size; i++) {
                C0760b c0760b = (C0760b) this.Ho.get(i);
                hashMap.put(c0760b.eM, c0760b.Hp);
            }
            return hashMap;
        }

        public void writeToParcel(Parcel out, int flags) {
            id idVar = CREATOR;
            id.m1260a(this, out, flags);
        }
    }

    public static class C0760b implements SafeParcelable {
        public static final ia CREATOR = new ia();
        final C0758a<?, ?> Hp;
        final String eM;
        final int versionCode;

        C0760b(int i, String str, C0758a<?, ?> c0758a) {
            this.versionCode = i;
            this.eM = str;
            this.Hp = c0758a;
        }

        C0760b(String str, C0758a<?, ?> c0758a) {
            this.versionCode = 1;
            this.eM = str;
            this.Hp = c0758a;
        }

        public int describeContents() {
            ia iaVar = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            ia iaVar = CREATOR;
            ia.m1256a(this, out, flags);
        }
    }

    ib(int i, ArrayList<C0759a> arrayList, String str) {
        this.xM = i;
        this.Hm = null;
        this.Hl = m2730b((ArrayList) arrayList);
        this.Hn = (String) hm.m1232f(str);
        fT();
    }

    public ib(Class<? extends hy> cls) {
        this.xM = 1;
        this.Hm = null;
        this.Hl = new HashMap();
        this.Hn = cls.getCanonicalName();
    }

    private static HashMap<String, HashMap<String, C0758a<?, ?>>> m2730b(ArrayList<C0759a> arrayList) {
        HashMap<String, HashMap<String, C0758a<?, ?>>> hashMap = new HashMap();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C0759a c0759a = (C0759a) arrayList.get(i);
            hashMap.put(c0759a.className, c0759a.fX());
        }
        return hashMap;
    }

    public void m2731a(Class<? extends hy> cls, HashMap<String, C0758a<?, ?>> hashMap) {
        this.Hl.put(cls.getCanonicalName(), hashMap);
    }

    public HashMap<String, C0758a<?, ?>> aJ(String str) {
        return (HashMap) this.Hl.get(str);
    }

    public boolean m2732b(Class<? extends hy> cls) {
        return this.Hl.containsKey(cls.getCanonicalName());
    }

    public int describeContents() {
        ic icVar = CREATOR;
        return 0;
    }

    public void fT() {
        for (String str : this.Hl.keySet()) {
            HashMap hashMap = (HashMap) this.Hl.get(str);
            for (String str2 : hashMap.keySet()) {
                ((C0758a) hashMap.get(str2)).m2727a(this);
            }
        }
    }

    public void fU() {
        for (String str : this.Hl.keySet()) {
            HashMap hashMap = (HashMap) this.Hl.get(str);
            HashMap hashMap2 = new HashMap();
            for (String str2 : hashMap.keySet()) {
                hashMap2.put(str2, ((C0758a) hashMap.get(str2)).fJ());
            }
            this.Hl.put(str, hashMap2);
        }
    }

    ArrayList<C0759a> fV() {
        ArrayList<C0759a> arrayList = new ArrayList();
        for (String str : this.Hl.keySet()) {
            arrayList.add(new C0759a(str, (HashMap) this.Hl.get(str)));
        }
        return arrayList;
    }

    public String fW() {
        return this.Hn;
    }

    int getVersionCode() {
        return this.xM;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.Hl.keySet()) {
            stringBuilder.append(str).append(":\n");
            HashMap hashMap = (HashMap) this.Hl.get(str);
            for (String str2 : hashMap.keySet()) {
                stringBuilder.append("  ").append(str2).append(": ");
                stringBuilder.append(hashMap.get(str2));
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        ic icVar = CREATOR;
        ic.m1258a(this, out, flags);
    }
}
