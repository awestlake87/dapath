package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.hm;

public abstract class C0255g<T> {
    private final String Ml;
    private T Mm;

    public static class C0254a extends Exception {
        public C0254a(String str) {
            super(str);
        }

        public C0254a(String str, Throwable th) {
            super(str, th);
        }
    }

    protected C0255g(String str) {
        this.Ml = str;
    }

    protected final T m469G(Context context) throws C0254a {
        if (this.Mm == null) {
            hm.m1232f(context);
            Context remoteContext = GooglePlayServicesUtil.getRemoteContext(context);
            if (remoteContext == null) {
                throw new C0254a("Could not get remote context.");
            }
            try {
                this.Mm = mo1585d((IBinder) remoteContext.getClassLoader().loadClass(this.Ml).newInstance());
            } catch (ClassNotFoundException e) {
                throw new C0254a("Could not load creator class.");
            } catch (InstantiationException e2) {
                throw new C0254a("Could not instantiate creator.");
            } catch (IllegalAccessException e3) {
                throw new C0254a("Could not access creator.");
            }
        }
        return this.Mm;
    }

    protected abstract T mo1585d(IBinder iBinder);
}
