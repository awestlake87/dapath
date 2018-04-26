package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import java.util.ArrayList;
import java.util.Iterator;

public final class hc {
    private final C0348b Gp;
    private final ArrayList<ConnectionCallbacks> Gq = new ArrayList();
    final ArrayList<ConnectionCallbacks> Gr = new ArrayList();
    private boolean Gs = false;
    private final ArrayList<OnConnectionFailedListener> Gt = new ArrayList();
    private final Handler mHandler;

    final class C0347a extends Handler {
        final /* synthetic */ hc Gu;

        public C0347a(hc hcVar, Looper looper) {
            this.Gu = hcVar;
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                synchronized (this.Gu.Gq) {
                    if (this.Gu.Gp.eO() && this.Gu.Gp.isConnected() && this.Gu.Gq.contains(msg.obj)) {
                        ((ConnectionCallbacks) msg.obj).onConnected(this.Gu.Gp.ef());
                    }
                }
                return;
            }
            Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
        }
    }

    public interface C0348b {
        boolean eO();

        Bundle ef();

        boolean isConnected();
    }

    public hc(Context context, Looper looper, C0348b c0348b) {
        this.Gp = c0348b;
        this.mHandler = new C0347a(this, looper);
    }

    public void m1164a(ConnectionResult connectionResult) {
        this.mHandler.removeMessages(1);
        synchronized (this.Gt) {
            Iterator it = new ArrayList(this.Gt).iterator();
            while (it.hasNext()) {
                OnConnectionFailedListener onConnectionFailedListener = (OnConnectionFailedListener) it.next();
                if (!this.Gp.eO()) {
                    return;
                } else if (this.Gt.contains(onConnectionFailedListener)) {
                    onConnectionFailedListener.onConnectionFailed(connectionResult);
                }
            }
        }
    }

    public void ao(int i) {
        this.mHandler.removeMessages(1);
        synchronized (this.Gq) {
            this.Gs = true;
            Iterator it = new ArrayList(this.Gq).iterator();
            while (it.hasNext()) {
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                if (!this.Gp.eO()) {
                    break;
                } else if (this.Gq.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.Gs = false;
        }
    }

    public void m1165c(Bundle bundle) {
        boolean z = true;
        synchronized (this.Gq) {
            hm.m1224A(!this.Gs);
            this.mHandler.removeMessages(1);
            this.Gs = true;
            if (this.Gr.size() != 0) {
                z = false;
            }
            hm.m1224A(z);
            Iterator it = new ArrayList(this.Gq).iterator();
            while (it.hasNext()) {
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                if (!this.Gp.eO() || !this.Gp.isConnected()) {
                    break;
                } else if (!this.Gr.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.Gr.clear();
            this.Gs = false;
        }
    }

    protected void cp() {
        synchronized (this.Gq) {
            m1165c(this.Gp.ef());
        }
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        boolean contains;
        hm.m1232f(listener);
        synchronized (this.Gq) {
            contains = this.Gq.contains(listener);
        }
        return contains;
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        boolean contains;
        hm.m1232f(listener);
        synchronized (this.Gt) {
            contains = this.Gt.contains(listener);
        }
        return contains;
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        hm.m1232f(listener);
        synchronized (this.Gq) {
            if (this.Gq.contains(listener)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + listener + " is already registered");
            } else {
                this.Gq.add(listener);
            }
        }
        if (this.Gp.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, listener));
        }
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        hm.m1232f(listener);
        synchronized (this.Gt) {
            if (this.Gt.contains(listener)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + listener + " is already registered");
            } else {
                this.Gt.add(listener);
            }
        }
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        hm.m1232f(listener);
        synchronized (this.Gq) {
            if (this.Gq != null) {
                if (!this.Gq.remove(listener)) {
                    Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + listener + " not found");
                } else if (this.Gs) {
                    this.Gr.add(listener);
                }
            }
        }
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        hm.m1232f(listener);
        synchronized (this.Gt) {
            if (!(this.Gt == null || this.Gt.remove(listener))) {
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + listener + " not found");
            }
        }
    }
}
