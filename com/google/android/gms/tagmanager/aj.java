package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0295d.C1082a;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class aj {
    private final Set<String> afC;
    private final String afD;

    public aj(String str, String... strArr) {
        this.afD = str;
        this.afC = new HashSet(strArr.length);
        for (Object add : strArr) {
            this.afC.add(add);
        }
    }

    boolean m1626a(Set<String> set) {
        return set.containsAll(this.afC);
    }

    public String lL() {
        return this.afD;
    }

    public Set<String> lM() {
        return this.afC;
    }

    public abstract boolean lh();

    public abstract C1082a mo2295w(Map<String, C1082a> map);
}
