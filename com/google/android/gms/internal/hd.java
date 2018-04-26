package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.hb.C0346f;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class hd implements Callback {
    private static final Object Gv = new Object();
    private static hd Gw;
    private final HashMap<String, C0350a> Gx = new HashMap();
    private final Context lz;
    private final Handler mHandler;

    final class C0350a {
        private final HashSet<C0346f> GA = new HashSet();
        private boolean GB;
        private IBinder GC;
        private ComponentName GD;
        final /* synthetic */ hd GE;
        private final String Gy;
        private final C0349a Gz = new C0349a(this);
        private int mState = 0;

        public class C0349a implements ServiceConnection {
            final /* synthetic */ C0350a GF;

            public C0349a(C0350a c0350a) {
                this.GF = c0350a;
            }

            public void onServiceConnected(ComponentName component, IBinder binder) {
                synchronized (this.GF.GE.Gx) {
                    this.GF.GC = binder;
                    this.GF.GD = component;
                    Iterator it = this.GF.GA.iterator();
                    while (it.hasNext()) {
                        ((C0346f) it.next()).onServiceConnected(component, binder);
                    }
                    this.GF.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName component) {
                synchronized (this.GF.GE.Gx) {
                    this.GF.GC = null;
                    this.GF.GD = component;
                    Iterator it = this.GF.GA.iterator();
                    while (it.hasNext()) {
                        ((C0346f) it.next()).onServiceDisconnected(component);
                    }
                    this.GF.mState = 2;
                }
            }
        }

        public C0350a(hd hdVar, String str) {
            this.GE = hdVar;
            this.Gy = str;
        }

        public void m1170B(boolean z) {
            this.GB = z;
        }

        public void m1171a(C0346f c0346f) {
            this.GA.add(c0346f);
        }

        public void m1172b(C0346f c0346f) {
            this.GA.remove(c0346f);
        }

        public boolean m1173c(C0346f c0346f) {
            return this.GA.contains(c0346f);
        }

        public C0349a fx() {
            return this.Gz;
        }

        public String fy() {
            return this.Gy;
        }

        public boolean fz() {
            return this.GA.isEmpty();
        }

        public IBinder getBinder() {
            return this.GC;
        }

        public ComponentName getComponentName() {
            return this.GD;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.GB;
        }
    }

    private hd(Context context) {
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.lz = context.getApplicationContext();
    }

    public static hd m1174E(Context context) {
        synchronized (Gv) {
            if (Gw == null) {
                Gw = new hd(context.getApplicationContext());
            }
        }
        return Gw;
    }

    public boolean m1176a(String str, C0346f c0346f) {
        boolean isBound;
        synchronized (this.Gx) {
            C0350a c0350a = (C0350a) this.Gx.get(str);
            if (c0350a != null) {
                this.mHandler.removeMessages(0, c0350a);
                if (!c0350a.m1173c(c0346f)) {
                    c0350a.m1171a((C0346f) c0346f);
                    switch (c0350a.getState()) {
                        case 1:
                            c0346f.onServiceConnected(c0350a.getComponentName(), c0350a.getBinder());
                            break;
                        case 2:
                            c0350a.m1170B(this.lz.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), c0350a.fx(), 129));
                            break;
                        default:
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  startServiceAction=" + str);
            }
            c0350a = new C0350a(this, str);
            c0350a.m1171a((C0346f) c0346f);
            c0350a.m1170B(this.lz.bindService(new Intent(str).setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE), c0350a.fx(), 129));
            this.Gx.put(str, c0350a);
            isBound = c0350a.isBound();
        }
        return isBound;
    }

    public void m1177b(String str, C0346f c0346f) {
        synchronized (this.Gx) {
            C0350a c0350a = (C0350a) this.Gx.get(str);
            if (c0350a == null) {
                throw new IllegalStateException("Nonexistent connection status for service action: " + str);
            } else if (c0350a.m1173c(c0346f)) {
                c0350a.m1172b(c0346f);
                if (c0350a.fz()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, c0350a), 5000);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  startServiceAction=" + str);
            }
        }
    }

    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 0:
                C0350a c0350a = (C0350a) msg.obj;
                synchronized (this.Gx) {
                    if (c0350a.fz()) {
                        this.lz.unbindService(c0350a.fx());
                        this.Gx.remove(c0350a.fy());
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
