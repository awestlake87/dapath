package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hy.C0758a;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class kp extends hy implements SafeParcelable, Moment {
    public static final kq CREATOR = new kq();
    private static final HashMap<String, C0758a<?, ?>> acr = new HashMap();
    private final Set<Integer> acs;
    private String adf;
    private kn adn;
    private kn ado;
    private String qX;
    private String xG;
    private final int xM;

    static {
        acr.put("id", C0758a.m2725j("id", 2));
        acr.put("result", C0758a.m2719a("result", 4, kn.class));
        acr.put("startDate", C0758a.m2725j("startDate", 5));
        acr.put("target", C0758a.m2719a("target", 6, kn.class));
        acr.put("type", C0758a.m2725j("type", 7));
    }

    public kp() {
        this.xM = 1;
        this.acs = new HashSet();
    }

    kp(Set<Integer> set, int i, String str, kn knVar, String str2, kn knVar2, String str3) {
        this.acs = set;
        this.xM = i;
        this.xG = str;
        this.adn = knVar;
        this.adf = str2;
        this.ado = knVar2;
        this.qX = str3;
    }

    public kp(Set<Integer> set, String str, kn knVar, String str2, kn knVar2, String str3) {
        this.acs = set;
        this.xM = 1;
        this.xG = str;
        this.adn = knVar;
        this.adf = str2;
        this.ado = knVar2;
        this.qX = str3;
    }

    protected boolean mo2859a(C0758a c0758a) {
        return this.acs.contains(Integer.valueOf(c0758a.fN()));
    }

    protected Object aF(String str) {
        return null;
    }

    protected boolean aG(String str) {
        return false;
    }

    protected Object mo2860b(C0758a c0758a) {
        switch (c0758a.fN()) {
            case 2:
                return this.xG;
            case 4:
                return this.adn;
            case 5:
                return this.adf;
            case 6:
                return this.ado;
            case 7:
                return this.qX;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + c0758a.fN());
        }
    }

    public int describeContents() {
        kq kqVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof kp)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        kp kpVar = (kp) obj;
        for (C0758a c0758a : acr.values()) {
            if (mo2859a(c0758a)) {
                if (!kpVar.mo2859a(c0758a)) {
                    return false;
                }
                if (!mo2860b(c0758a).equals(kpVar.mo2860b(c0758a))) {
                    return false;
                }
            } else if (kpVar.mo2859a(c0758a)) {
                return false;
            }
        }
        return true;
    }

    public HashMap<String, C0758a<?, ?>> fG() {
        return acr;
    }

    public /* synthetic */ Object freeze() {
        return kD();
    }

    public String getId() {
        return this.xG;
    }

    public ItemScope getResult() {
        return this.adn;
    }

    public String getStartDate() {
        return this.adf;
    }

    public ItemScope getTarget() {
        return this.ado;
    }

    public String getType() {
        return this.qX;
    }

    int getVersionCode() {
        return this.xM;
    }

    public boolean hasId() {
        return this.acs.contains(Integer.valueOf(2));
    }

    public boolean hasResult() {
        return this.acs.contains(Integer.valueOf(4));
    }

    public boolean hasStartDate() {
        return this.acs.contains(Integer.valueOf(5));
    }

    public boolean hasTarget() {
        return this.acs.contains(Integer.valueOf(6));
    }

    public boolean hasType() {
        return this.acs.contains(Integer.valueOf(7));
    }

    public int hashCode() {
        int i = 0;
        for (C0758a c0758a : acr.values()) {
            int hashCode;
            if (mo2859a(c0758a)) {
                hashCode = mo2860b(c0758a).hashCode() + (i + c0758a.fN());
            } else {
                hashCode = i;
            }
            i = hashCode;
        }
        return i;
    }

    public boolean isDataValid() {
        return true;
    }

    kn kB() {
        return this.adn;
    }

    kn kC() {
        return this.ado;
    }

    public kp kD() {
        return this;
    }

    Set<Integer> kk() {
        return this.acs;
    }

    public void writeToParcel(Parcel out, int flags) {
        kq kqVar = CREATOR;
        kq.m1329a(this, out, flags);
    }
}
