package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class jm implements SafeParcelable {
    public static final jn CREATOR = new jn();
    final List<js> Wc;
    private final String Wd;
    private final boolean We;
    final List<jw> Wf;
    private final String Wg;
    final List<String> Wh;
    private final Set<js> Wi;
    private final Set<jw> Wj;
    private final Set<String> Wk;
    final int xM;

    jm(int i, List<js> list, String str, boolean z, List<jw> list2, String str2, List<String> list3) {
        this.xM = i;
        this.Wc = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        if (str == null) {
            str = "";
        }
        this.Wd = str;
        this.We = z;
        this.Wf = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        if (str2 == null) {
            str2 = "";
        }
        this.Wg = str2;
        this.Wh = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.Wi = m2779c(this.Wc);
        this.Wj = m2779c(this.Wf);
        this.Wk = m2779c(this.Wh);
    }

    private static <E> Set<E> m2779c(List<E> list) {
        return list.isEmpty() ? Collections.emptySet() : Collections.unmodifiableSet(new HashSet(list));
    }

    public int describeContents() {
        jn jnVar = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof jm)) {
            return false;
        }
        jm jmVar = (jm) object;
        return this.Wi.equals(jmVar.Wi) && this.We == jmVar.We && this.Wg.equals(jmVar.Wg) && this.Wj.equals(jmVar.Wj) && this.Wk.equals(jmVar.Wk);
    }

    public int hashCode() {
        return hk.hashCode(this.Wi, Boolean.valueOf(this.We), this.Wj, this.Wg, this.Wk);
    }

    @Deprecated
    public String jg() {
        return this.Wd;
    }

    public boolean jh() {
        return this.We;
    }

    public String ji() {
        return this.Wg;
    }

    public String toString() {
        return hk.m1221e(this).m1220a("types", this.Wi).m1220a("placeIds", this.Wk).m1220a("requireOpenNow", Boolean.valueOf(this.We)).m1220a("userAccountName", this.Wg).m1220a("requestedUserDataTypes", this.Wj).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        jn jnVar = CREATOR;
        jn.m1308a(this, parcel, flags);
    }
}
