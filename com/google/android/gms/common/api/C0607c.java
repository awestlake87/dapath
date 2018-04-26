package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.C0147a;
import com.google.android.gms.common.api.Api.C0148b;
import com.google.android.gms.common.api.Api.C0149c;
import com.google.android.gms.common.api.C0153a.C1002b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hc;
import com.google.android.gms.internal.hc.C0348b;
import com.google.android.gms.internal.hm;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class C0607c implements GoogleApiClient {
    private final Looper DF;
    private final Lock DQ = new ReentrantLock();
    private final Condition DR = this.DQ.newCondition();
    private final hc DS;
    private final Fragment DT;
    final Queue<C0156c<?>> DU = new LinkedList();
    private ConnectionResult DV;
    private int DW;
    private int DX = 4;
    private int DY = 0;
    private boolean DZ = false;
    private final C0154a Dy = new C06041(this);
    private int Ea;
    private long Eb = 5000;
    final Handler Ec;
    private final Bundle Ed = new Bundle();
    private final Map<C0149c<?>, C0147a> Ee = new HashMap();
    private final List<String> Ef;
    private boolean Eg;
    final Set<C0156c<?>> Eh = Collections.newSetFromMap(new ConcurrentHashMap());
    final ConnectionCallbacks Ei = new C06052(this);
    private final C0348b Ej = new C06063(this);

    interface C0154a {
        void mo919b(C0156c<?> c0156c);
    }

    class C0155b extends Handler {
        final /* synthetic */ C0607c Ek;

        C0155b(C0607c c0607c, Looper looper) {
            this.Ek = c0607c;
            super(looper);
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                this.Ek.DQ.lock();
                try {
                    if (!(this.Ek.isConnected() || this.Ek.isConnecting())) {
                        this.Ek.connect();
                    }
                    this.Ek.DQ.unlock();
                } catch (Throwable th) {
                    this.Ek.DQ.unlock();
                }
            } else {
                Log.wtf("GoogleApiClientImpl", "Don't know how to handle this message.");
            }
        }
    }

    interface C0156c<A extends C0147a> {
        void mo2536a(C0154a c0154a);

        void mo2537b(A a) throws DeadObjectException;

        void cancel();

        C0149c<A> eB();

        int eG();

        void mo2541m(Status status);
    }

    class C06041 implements C0154a {
        final /* synthetic */ C0607c Ek;

        C06041(C0607c c0607c) {
            this.Ek = c0607c;
        }

        public void mo919b(C0156c<?> c0156c) {
            this.Ek.Eh.remove(c0156c);
        }
    }

    class C06052 implements ConnectionCallbacks {
        final /* synthetic */ C0607c Ek;

        C06052(C0607c c0607c) {
            this.Ek = c0607c;
        }

        public void onConnected(Bundle connectionHint) {
            this.Ek.DQ.lock();
            try {
                if (this.Ek.DX == 1) {
                    if (connectionHint != null) {
                        this.Ek.Ed.putAll(connectionHint);
                    }
                    this.Ek.eK();
                }
                this.Ek.DQ.unlock();
            } catch (Throwable th) {
                this.Ek.DQ.unlock();
            }
        }

        public void onConnectionSuspended(int cause) {
            this.Ek.DQ.lock();
            try {
                this.Ek.aa(cause);
                switch (cause) {
                    case 1:
                        if (!this.Ek.eM()) {
                            this.Ek.DY = 2;
                            this.Ek.Ec.sendMessageDelayed(this.Ek.Ec.obtainMessage(1), this.Ek.Eb);
                            break;
                        }
                        this.Ek.DQ.unlock();
                        return;
                    case 2:
                        this.Ek.connect();
                        break;
                }
                this.Ek.DQ.unlock();
            } catch (Throwable th) {
                this.Ek.DQ.unlock();
            }
        }
    }

    class C06063 implements C0348b {
        final /* synthetic */ C0607c Ek;

        C06063(C0607c c0607c) {
            this.Ek = c0607c;
        }

        public boolean eO() {
            return this.Ek.Eg;
        }

        public Bundle ef() {
            return null;
        }

        public boolean isConnected() {
            return this.Ek.isConnected();
        }
    }

    public C0607c(Context context, Looper looper, gy gyVar, Map<Api<?>, ApiOptions> map, Fragment fragment, Set<ConnectionCallbacks> set, Set<OnConnectionFailedListener> set2) {
        this.DS = new hc(context, looper, this.Ej);
        this.DT = fragment;
        this.DF = looper;
        this.Ec = new C0155b(this, looper);
        for (ConnectionCallbacks registerConnectionCallbacks : set) {
            this.DS.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (OnConnectionFailedListener registerConnectionFailedListener : set2) {
            this.DS.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        for (Api api : map.keySet()) {
            final C0148b ez = api.ez();
            Object obj = map.get(api);
            this.Ee.put(api.eB(), C0607c.m1988a(ez, obj, context, looper, gyVar, this.Ei, new OnConnectionFailedListener(this) {
                final /* synthetic */ C0607c Ek;

                public void onConnectionFailed(ConnectionResult result) {
                    this.Ek.DQ.lock();
                    try {
                        if (this.Ek.DV == null || ez.getPriority() < this.Ek.DW) {
                            this.Ek.DV = result;
                            this.Ek.DW = ez.getPriority();
                        }
                        this.Ek.eK();
                    } finally {
                        this.Ek.DQ.unlock();
                    }
                }
            }));
        }
        this.Ef = Collections.unmodifiableList(gyVar.fl());
    }

    private static <C extends C0147a, O> C m1988a(C0148b<C, O> c0148b, Object obj, Context context, Looper looper, gy gyVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return c0148b.mo880a(context, looper, gyVar, obj, connectionCallbacks, onConnectionFailedListener);
    }

    private <A extends C0147a> void m1990a(C0156c<A> c0156c) throws DeadObjectException {
        boolean z = true;
        this.DQ.lock();
        try {
            boolean z2 = isConnected() || eM();
            hm.m1226a(z2, "GoogleApiClient is not connected yet.");
            if (c0156c.eB() == null) {
                z = false;
            }
            hm.m1230b(z, (Object) "This task can not be executed or enqueued (it's probably a Batch or malformed)");
            this.Eh.add(c0156c);
            c0156c.mo2536a(this.Dy);
            if (eM()) {
                c0156c.mo2541m(new Status(8));
                return;
            }
            c0156c.mo2537b(mo925a(c0156c.eB()));
            this.DQ.unlock();
        } finally {
            this.DQ.unlock();
        }
    }

    private void aa(int i) {
        this.DQ.lock();
        try {
            if (this.DX != 3) {
                if (i == -1) {
                    Iterator it;
                    C0156c c0156c;
                    if (isConnecting()) {
                        it = this.DU.iterator();
                        while (it.hasNext()) {
                            c0156c = (C0156c) it.next();
                            if (c0156c.eG() != 1) {
                                c0156c.cancel();
                                it.remove();
                            }
                        }
                    } else {
                        this.DU.clear();
                    }
                    for (C0156c c0156c2 : this.Eh) {
                        c0156c2.cancel();
                    }
                    this.Eh.clear();
                    if (this.DV == null && !this.DU.isEmpty()) {
                        this.DZ = true;
                        return;
                    }
                }
                boolean isConnecting = isConnecting();
                boolean isConnected = isConnected();
                this.DX = 3;
                if (isConnecting) {
                    if (i == -1) {
                        this.DV = null;
                    }
                    this.DR.signalAll();
                }
                this.Eg = false;
                for (C0147a c0147a : this.Ee.values()) {
                    if (c0147a.isConnected()) {
                        c0147a.disconnect();
                    }
                }
                this.Eg = true;
                this.DX = 4;
                if (isConnected) {
                    if (i != -1) {
                        this.DS.ao(i);
                    }
                    this.Eg = false;
                }
            }
            this.DQ.unlock();
        } finally {
            this.DQ.unlock();
        }
    }

    private void eK() {
        this.DQ.lock();
        try {
            this.Ea--;
            if (this.Ea == 0) {
                if (this.DV != null) {
                    this.DZ = false;
                    aa(3);
                    if (eM()) {
                        this.DY--;
                    }
                    if (eM()) {
                        this.Ec.sendMessageDelayed(this.Ec.obtainMessage(1), this.Eb);
                    } else {
                        this.DS.m1164a(this.DV);
                    }
                    this.Eg = false;
                } else {
                    this.DX = 2;
                    eN();
                    this.DR.signalAll();
                    eL();
                    if (this.DZ) {
                        this.DZ = false;
                        aa(-1);
                    } else {
                        this.DS.m1165c(this.Ed.isEmpty() ? null : this.Ed);
                    }
                }
            }
            this.DQ.unlock();
        } catch (Throwable th) {
            this.DQ.unlock();
        }
    }

    private void eL() {
        boolean z = isConnected() || eM();
        hm.m1226a(z, "GoogleApiClient is not connected yet.");
        this.DQ.lock();
        while (!this.DU.isEmpty()) {
            try {
                m1990a((C0156c) this.DU.remove());
            } catch (Throwable e) {
                Log.w("GoogleApiClientImpl", "Service died while flushing queue", e);
            } catch (Throwable th) {
                this.DQ.unlock();
            }
        }
        this.DQ.unlock();
    }

    private boolean eM() {
        this.DQ.lock();
        try {
            boolean z = this.DY != 0;
            this.DQ.unlock();
            return z;
        } catch (Throwable th) {
            this.DQ.unlock();
        }
    }

    private void eN() {
        this.DQ.lock();
        try {
            this.DY = 0;
            this.Ec.removeMessages(1);
        } finally {
            this.DQ.unlock();
        }
    }

    public <C extends C0147a> C mo925a(C0149c<C> c0149c) {
        Object obj = (C0147a) this.Ee.get(c0149c);
        hm.m1228b(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public <A extends C0147a, T extends C1002b<? extends Result, A>> T mo926a(T t) {
        this.DQ.lock();
        try {
            if (isConnected()) {
                mo927b((C1002b) t);
            } else {
                this.DU.add(t);
            }
            this.DQ.unlock();
            return t;
        } catch (Throwable th) {
            this.DQ.unlock();
        }
    }

    public <A extends C0147a, T extends C1002b<? extends Result, A>> T mo927b(T t) {
        boolean z = isConnected() || eM();
        hm.m1226a(z, "GoogleApiClient is not connected yet.");
        eL();
        try {
            m1990a((C0156c) t);
        } catch (DeadObjectException e) {
            aa(1);
        }
        return t;
    }

    public ConnectionResult blockingConnect() {
        ConnectionResult connectionResult;
        hm.m1226a(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.DQ.lock();
        try {
            connect();
            while (isConnecting()) {
                this.DR.await();
            }
            if (isConnected()) {
                connectionResult = ConnectionResult.CS;
            } else if (this.DV != null) {
                connectionResult = this.DV;
                this.DQ.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.DQ.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.DQ.unlock();
        }
        return connectionResult;
    }

    public ConnectionResult blockingConnect(long timeout, TimeUnit unit) {
        ConnectionResult connectionResult;
        hm.m1226a(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.DQ.lock();
        try {
            connect();
            long toNanos = unit.toNanos(timeout);
            while (isConnecting()) {
                toNanos = this.DR.awaitNanos(toNanos);
                if (toNanos <= 0) {
                    connectionResult = new ConnectionResult(14, null);
                    break;
                }
            }
            if (isConnected()) {
                connectionResult = ConnectionResult.CS;
                this.DQ.unlock();
            } else if (this.DV != null) {
                connectionResult = this.DV;
                this.DQ.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.DQ.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.DQ.unlock();
        }
        return connectionResult;
    }

    public void connect() {
        this.DQ.lock();
        try {
            this.DZ = false;
            if (isConnected() || isConnecting()) {
                this.DQ.unlock();
                return;
            }
            this.Eg = true;
            this.DV = null;
            this.DX = 1;
            this.Ed.clear();
            this.Ea = this.Ee.size();
            for (C0147a connect : this.Ee.values()) {
                connect.connect();
            }
            this.DQ.unlock();
        } catch (Throwable th) {
            this.DQ.unlock();
        }
    }

    public void disconnect() {
        eN();
        aa(-1);
    }

    public Looper getLooper() {
        return this.DF;
    }

    public boolean isConnected() {
        this.DQ.lock();
        try {
            boolean z = this.DX == 2;
            this.DQ.unlock();
            return z;
        } catch (Throwable th) {
            this.DQ.unlock();
        }
    }

    public boolean isConnecting() {
        boolean z = true;
        this.DQ.lock();
        try {
            if (this.DX != 1) {
                z = false;
            }
            this.DQ.unlock();
            return z;
        } catch (Throwable th) {
            this.DQ.unlock();
        }
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.DS.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.DS.isConnectionFailedListenerRegistered(listener);
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.DS.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.DS.registerConnectionFailedListener(listener);
    }

    public void stopAutoManage() {
        hm.m1226a(this.DT != null, "Called stopAutoManage but automatic lifecycle management is not enabled.");
        if (this.DT.getActivity() != null) {
            this.DT.getActivity().getSupportFragmentManager().beginTransaction().remove(this.DT).commit();
            disconnect();
        }
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.DS.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.DS.unregisterConnectionFailedListener(listener);
    }
}
