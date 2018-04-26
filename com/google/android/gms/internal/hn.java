package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.C0255g;
import com.google.android.gms.dynamic.C0255g.C0254a;
import com.google.android.gms.dynamic.C1030e;
import com.google.android.gms.internal.hj.C0756a;

public final class hn extends C0255g<hj> {
    private static final hn GL = new hn();

    private hn() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View m2709b(Context context, int i, int i2) throws C0254a {
        return GL.m2710c(context, i, i2);
    }

    private View m2710c(Context context, int i, int i2) throws C0254a {
        try {
            return (View) C1030e.m3259e(((hj) m469G(context)).mo1788a(C1030e.m3260h(context), i, i2));
        } catch (Throwable e) {
            throw new C0254a("Could not get button with size " + i + " and color " + i2, e);
        }
    }

    public hj m2711N(IBinder iBinder) {
        return C0756a.m2708M(iBinder);
    }

    public /* synthetic */ Object mo1585d(IBinder iBinder) {
        return m2711N(iBinder);
    }
}
