package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api.C0147a;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.hc.C0348b;
import com.google.android.gms.internal.hh.C0752a;
import com.google.android.gms.internal.hi.C0754a;
import java.util.ArrayList;

public abstract class hb<T extends IInterface> implements C0147a, C0348b {
    public static final String[] Gh = new String[]{"service_esmobile", "service_googleme"};
    private final Looper DF;
    private final hc DS;
    private T Gb;
    private final ArrayList<C0345b<?>> Gc;
    private C0346f Gd;
    private volatile int Ge;
    private final String[] Gf;
    boolean Gg;
    private final Context mContext;
    final Handler mHandler;

    final class C0344a extends Handler {
        final /* synthetic */ hb Gi;

        public C0344a(hb hbVar, Looper looper) {
            this.Gi = hbVar;
            super(looper);
        }

        public void handleMessage(Message msg) {
            C0345b c0345b;
            if (msg.what == 1 && !this.Gi.isConnecting()) {
                c0345b = (C0345b) msg.obj;
                c0345b.fu();
                c0345b.unregister();
            } else if (msg.what == 3) {
                this.Gi.DS.m1164a(new ConnectionResult(((Integer) msg.obj).intValue(), null));
            } else if (msg.what == 4) {
                this.Gi.am(1);
                this.Gi.Gb = null;
                this.Gi.DS.ao(((Integer) msg.obj).intValue());
            } else if (msg.what == 2 && !this.Gi.isConnected()) {
                c0345b = (C0345b) msg.obj;
                c0345b.fu();
                c0345b.unregister();
            } else if (msg.what == 2 || msg.what == 1) {
                ((C0345b) msg.obj).fv();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle this message.");
            }
        }
    }

    protected abstract class C0345b<TListener> {
        final /* synthetic */ hb Gi;
        private boolean Gj = false;
        private TListener mListener;

        public C0345b(hb hbVar, TListener tListener) {
            this.Gi = hbVar;
            this.mListener = tListener;
        }

        protected abstract void mo1128d(TListener tListener);

        protected abstract void fu();

        public void fv() {
            synchronized (this) {
                Object obj = this.mListener;
                if (this.Gj) {
                    Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
                }
            }
            if (obj != null) {
                try {
                    mo1128d(obj);
                } catch (RuntimeException e) {
                    fu();
                    throw e;
                }
            }
            fu();
            synchronized (this) {
                this.Gj = true;
            }
            unregister();
        }

        public void fw() {
            synchronized (this) {
                this.mListener = null;
            }
        }

        public void unregister() {
            fw();
            synchronized (this.Gi.Gc) {
                this.Gi.Gc.remove(this);
            }
        }
    }

    final class C0346f implements ServiceConnection {
        final /* synthetic */ hb Gi;

        C0346f(hb hbVar) {
            this.Gi = hbVar;
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            this.Gi.m2662I(binder);
        }

        public void onServiceDisconnected(ComponentName component) {
            this.Gi.mHandler.sendMessage(this.Gi.mHandler.obtainMessage(4, Integer.valueOf(1)));
        }
    }

    public static final class C0746c implements ConnectionCallbacks {
        private final GooglePlayServicesClient.ConnectionCallbacks Gk;

        public C0746c(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
            this.Gk = connectionCallbacks;
        }

        public boolean equals(Object other) {
            return other instanceof C0746c ? this.Gk.equals(((C0746c) other).Gk) : this.Gk.equals(other);
        }

        public void onConnected(Bundle connectionHint) {
            this.Gk.onConnected(connectionHint);
        }

        public void onConnectionSuspended(int cause) {
            this.Gk.onDisconnected();
        }
    }

    public abstract class C0747d<TListener> extends C0345b<TListener> {
        private final DataHolder DG;
        final /* synthetic */ hb Gi;

        public C0747d(hb hbVar, TListener tListener, DataHolder dataHolder) {
            this.Gi = hbVar;
            super(hbVar, tListener);
            this.DG = dataHolder;
        }

        protected abstract void mo2625a(TListener tListener, DataHolder dataHolder);

        protected final void mo1128d(TListener tListener) {
            mo2625a(tListener, this.DG);
        }

        protected void fu() {
            if (this.DG != null) {
                this.DG.close();
            }
        }

        public /* bridge */ /* synthetic */ void fv() {
            super.fv();
        }

        public /* bridge */ /* synthetic */ void fw() {
            super.fw();
        }

        public /* bridge */ /* synthetic */ void unregister() {
            super.unregister();
        }
    }

    protected final class C0748h extends C0345b<Boolean> {
        final /* synthetic */ hb Gi;
        public final Bundle Gn;
        public final IBinder Go;
        public final int statusCode;

        public C0748h(hb hbVar, int i, IBinder iBinder, Bundle bundle) {
            this.Gi = hbVar;
            super(hbVar, Boolean.valueOf(true));
            this.statusCode = i;
            this.Go = iBinder;
            this.Gn = bundle;
        }

        protected void m2652b(Boolean bool) {
            if (bool == null) {
                this.Gi.am(1);
                return;
            }
            switch (this.statusCode) {
                case 0:
                    try {
                        if (this.Gi.bv().equals(this.Go.getInterfaceDescriptor())) {
                            this.Gi.Gb = this.Gi.mo2555x(this.Go);
                            if (this.Gi.Gb != null) {
                                this.Gi.am(3);
                                this.Gi.DS.cp();
                                return;
                            }
                        }
                    } catch (RemoteException e) {
                    }
                    hd.m1174E(this.Gi.mContext).m1177b(this.Gi.bu(), this.Gi.Gd);
                    this.Gi.Gd = null;
                    this.Gi.am(1);
                    this.Gi.Gb = null;
                    this.Gi.DS.m1164a(new ConnectionResult(8, null));
                    return;
                case 10:
                    this.Gi.am(1);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    PendingIntent pendingIntent = this.Gn != null ? (PendingIntent) this.Gn.getParcelable("pendingIntent") : null;
                    if (this.Gi.Gd != null) {
                        hd.m1174E(this.Gi.mContext).m1177b(this.Gi.bu(), this.Gi.Gd);
                        this.Gi.Gd = null;
                    }
                    this.Gi.am(1);
                    this.Gi.Gb = null;
                    this.Gi.DS.m1164a(new ConnectionResult(this.statusCode, pendingIntent));
                    return;
            }
        }

        protected /* synthetic */ void mo1128d(Object obj) {
            m2652b((Boolean) obj);
        }

        protected void fu() {
        }
    }

    public static final class C1092e extends C0752a {
        private hb Gl;

        public C1092e(hb hbVar) {
            this.Gl = hbVar;
        }

        public void mo1752b(int i, IBinder iBinder, Bundle bundle) {
            hm.m1228b((Object) "onPostInitComplete can be called only once per call to getServiceFromBroker", this.Gl);
            this.Gl.mo2551a(i, iBinder, bundle);
            this.Gl = null;
        }
    }

    public static final class C1093g implements OnConnectionFailedListener {
        private final GooglePlayServicesClient.OnConnectionFailedListener Gm;

        public C1093g(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.Gm = onConnectionFailedListener;
        }

        public boolean equals(Object other) {
            return other instanceof C1093g ? this.Gm.equals(((C1093g) other).Gm) : this.Gm.equals(other);
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.Gm.onConnectionFailed(result);
        }
    }

    protected hb(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String... strArr) {
        this.Gc = new ArrayList();
        this.Ge = 1;
        this.Gg = false;
        this.mContext = (Context) hm.m1232f(context);
        this.DF = (Looper) hm.m1228b((Object) looper, (Object) "Looper must not be null");
        this.DS = new hc(context, looper, this);
        this.mHandler = new C0344a(this, looper);
        mo2653b(strArr);
        this.Gf = strArr;
        registerConnectionCallbacks((ConnectionCallbacks) hm.m1232f(connectionCallbacks));
        registerConnectionFailedListener((OnConnectionFailedListener) hm.m1232f(onConnectionFailedListener));
    }

    @Deprecated
    protected hb(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String... strArr) {
        this(context, context.getMainLooper(), new C0746c(connectionCallbacks), new C1093g(onConnectionFailedListener), strArr);
    }

    private void am(int i) {
        int i2 = this.Ge;
        this.Ge = i;
        if (i2 == i) {
            return;
        }
        if (i == 3) {
            onConnected();
        } else if (i2 == 3 && i == 1) {
            onDisconnected();
        }
    }

    protected final void m2662I(IBinder iBinder) {
        try {
            mo2552a(C0754a.m2706L(iBinder), new C1092e(this));
        } catch (RemoteException e) {
            Log.w("GmsClient", "service died");
        }
    }

    protected void mo2551a(int i, IBinder iBinder, Bundle bundle) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, new C0748h(this, i, iBinder, bundle)));
    }

    @Deprecated
    public final void m2664a(C0345b<?> c0345b) {
        synchronized (this.Gc) {
            this.Gc.add(c0345b);
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, c0345b));
    }

    protected abstract void mo2552a(hi hiVar, C1092e c1092e) throws RemoteException;

    public void an(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, Integer.valueOf(i)));
    }

    protected void mo2653b(String... strArr) {
    }

    protected abstract String bu();

    protected abstract String bv();

    protected final void cn() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect() {
        this.Gg = true;
        am(2);
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            am(1);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(isGooglePlayServicesAvailable)));
            return;
        }
        if (this.Gd != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect().");
            this.Gb = null;
            hd.m1174E(this.mContext).m1177b(bu(), this.Gd);
        }
        this.Gd = new C0346f(this);
        if (!hd.m1174E(this.mContext).m1176a(bu(), this.Gd)) {
            Log.e("GmsClient", "unable to connect to service: " + bu());
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, Integer.valueOf(9)));
        }
    }

    public void disconnect() {
        this.Gg = false;
        synchronized (this.Gc) {
            int size = this.Gc.size();
            for (int i = 0; i < size; i++) {
                ((C0345b) this.Gc.get(i)).fw();
            }
            this.Gc.clear();
        }
        am(1);
        this.Gb = null;
        if (this.Gd != null) {
            hd.m1174E(this.mContext).m1177b(bu(), this.Gd);
            this.Gd = null;
        }
    }

    public boolean eO() {
        return this.Gg;
    }

    public Bundle ef() {
        return null;
    }

    public final String[] fs() {
        return this.Gf;
    }

    public final T ft() {
        cn();
        return this.Gb;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.DF;
    }

    public boolean isConnected() {
        return this.Ge == 3;
    }

    public boolean isConnecting() {
        return this.Ge == 2;
    }

    @Deprecated
    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks listener) {
        return this.DS.isConnectionCallbacksRegistered(new C0746c(listener));
    }

    @Deprecated
    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        return this.DS.isConnectionFailedListenerRegistered(listener);
    }

    protected void onConnected() {
    }

    protected void onDisconnected() {
    }

    @Deprecated
    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.DS.registerConnectionCallbacks(new C0746c(listener));
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.DS.registerConnectionCallbacks(listener);
    }

    @Deprecated
    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.DS.registerConnectionFailedListener(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.DS.registerConnectionFailedListener(listener);
    }

    @Deprecated
    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks listener) {
        this.DS.unregisterConnectionCallbacks(new C0746c(listener));
    }

    @Deprecated
    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener listener) {
        this.DS.unregisterConnectionFailedListener(listener);
    }

    protected abstract T mo2555x(IBinder iBinder);
}
