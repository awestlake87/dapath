package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

class C0800x implements C0380z {
    private ex le;

    public C0800x(ex exVar) {
        this.le = exVar;
    }

    public void mo1921a(ac acVar, boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        this.le.m1029a("onAdVisibilityChanged", hashMap);
    }
}
