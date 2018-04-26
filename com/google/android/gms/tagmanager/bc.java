package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.C0268a;
import com.google.android.gms.internal.C0295d.C1082a;
import java.util.Locale;
import java.util.Map;

class bc extends aj {
    private static final String ID = C0268a.LANGUAGE.toString();

    public bc() {
        super(ID, new String[0]);
    }

    public boolean lh() {
        return false;
    }

    public C1082a mo2295w(Map<String, C1082a> map) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return dh.nd();
        }
        String language = locale.getLanguage();
        return language == null ? dh.nd() : dh.m1733r(language.toLowerCase());
    }
}
