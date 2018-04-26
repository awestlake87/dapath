package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.ds.C0306a;

public final class dm {

    public interface C0297a {
        void mo3091a(ef efVar);
    }

    public static em m893a(Context context, C0306a c0306a, C0359k c0359k, ex exVar, bt btVar, C0297a c0297a) {
        em dnVar = new dn(context, c0306a, c0359k, exVar, btVar, c0297a);
        dnVar.start();
        return dnVar;
    }
}
