package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.dq.C1083a;
import com.google.android.gms.internal.dq.C1084b;

public final class dp {

    public interface C0305a {
        void mo1690a(du duVar);
    }

    public static em m906a(Context context, ds dsVar, C0305a c0305a) {
        return dsVar.kQ.sz ? m907b(context, dsVar, c0305a) : m908c(context, dsVar, c0305a);
    }

    private static em m907b(Context context, ds dsVar, C0305a c0305a) {
        eu.m1019z("Fetching ad response from local ad request service.");
        em c1083a = new C1083a(context, dsVar, c0305a);
        c1083a.start();
        return c1083a;
    }

    private static em m908c(Context context, ds dsVar, C0305a c0305a) {
        eu.m1019z("Fetching ad response from remote ad request service.");
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            return new C1084b(context, dsVar, c0305a);
        }
        eu.m1014D("Failed to connect to remote ad request service.");
        return null;
    }
}
