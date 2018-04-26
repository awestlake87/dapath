package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.gl.C0742a;
import com.google.android.gms.internal.gm.C0743a;
import com.google.android.gms.internal.hb.C1092e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class gh extends hb<gl> {
    private static final gn BG = new gn("CastClientImpl");
    private static final Object Ca = new Object();
    private static final Object Cb = new Object();
    private double AP = 0.0d;
    private boolean AQ = false;
    private final Listener Ae;
    private ApplicationMetadata BH = null;
    private final CastDevice BI;
    private final gm BJ;
    private final Map<String, MessageReceivedCallback> BK = new HashMap();
    private final long BL;
    private String BM = null;
    private boolean BN;
    private boolean BO;
    private boolean BP = false;
    private AtomicBoolean BQ = new AtomicBoolean(false);
    private int BR = -1;
    private final AtomicLong BS = new AtomicLong(0);
    private String BT;
    private String BU;
    private Bundle BV;
    private Map<Long, C0152d<Status>> BW = new HashMap();
    private C1091b BX = new C1091b();
    private C0152d<ApplicationConnectionResult> BY;
    private C0152d<Status> BZ;
    private final Handler mHandler;

    class C10891 extends C0743a {
        final /* synthetic */ gh Cc;

        C10891(gh ghVar) {
            this.Cc = ghVar;
        }

        private boolean m3611X(int i) {
            synchronized (gh.Cb) {
                if (this.Cc.BZ != null) {
                    this.Cc.BZ.mo911a(new Status(i));
                    this.Cc.BZ = null;
                    return true;
                }
                return false;
            }
        }

        private void m3612b(long j, int i) {
            synchronized (this.Cc.BW) {
                C0152d c0152d = (C0152d) this.Cc.BW.remove(Long.valueOf(j));
            }
            if (c0152d != null) {
                c0152d.mo911a(new Status(i));
            }
        }

        public void mo2838T(int i) {
            gh.BG.m1139b("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i));
            this.Cc.BP = false;
            this.Cc.BQ.set(false);
            this.Cc.BH = null;
            if (i != 0) {
                this.Cc.an(2);
            }
        }

        public void mo2839U(int i) {
            synchronized (gh.Ca) {
                if (this.Cc.BY != null) {
                    this.Cc.BY.mo911a(new C1090a(new Status(i)));
                    this.Cc.BY = null;
                }
            }
        }

        public void mo2840V(int i) {
            m3611X(i);
        }

        public void mo2841W(int i) {
            m3611X(i);
        }

        public void mo2842a(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.Cc.BH = applicationMetadata;
            this.Cc.BT = applicationMetadata.getApplicationId();
            this.Cc.BU = str2;
            synchronized (gh.Ca) {
                if (this.Cc.BY != null) {
                    this.Cc.BY.mo911a(new C1090a(new Status(0), applicationMetadata, str, str2, z));
                    this.Cc.BY = null;
                }
            }
        }

        public void mo2843a(String str, double d, boolean z) {
            gh.BG.m1139b("Deprecated callback: \"onStatusreceived\"", new Object[0]);
        }

        public void mo2844a(String str, long j) {
            m3612b(j, 0);
        }

        public void mo2845a(String str, long j, int i) {
            m3612b(j, i);
        }

        public void mo2846b(final ge geVar) {
            gh.BG.m1139b("onApplicationStatusChanged", new Object[0]);
            this.Cc.mHandler.post(new Runnable(this) {
                final /* synthetic */ C10891 Ce;

                public void run() {
                    this.Ce.Cc.m3628a(geVar);
                }
            });
        }

        public void mo2847b(final gj gjVar) {
            gh.BG.m1139b("onDeviceStatusChanged", new Object[0]);
            this.Cc.mHandler.post(new Runnable(this) {
                final /* synthetic */ C10891 Ce;

                public void run() {
                    this.Ce.Cc.m3631a(gjVar);
                }
            });
        }

        public void mo2848b(String str, byte[] bArr) {
            gh.BG.m1139b("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
        }

        public void mo2849g(final String str, final String str2) {
            gh.BG.m1139b("Receive (type=text, ns=%s) %s", str, str2);
            this.Cc.mHandler.post(new Runnable(this) {
                final /* synthetic */ C10891 Ce;

                public void run() {
                    synchronized (this.Ce.Cc.BK) {
                        MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) this.Ce.Cc.BK.get(str);
                    }
                    if (messageReceivedCallback != null) {
                        messageReceivedCallback.onMessageReceived(this.Ce.Cc.BI, str, str2);
                        return;
                    }
                    gh.BG.m1139b("Discarded message for unknown namespace '%s'", str);
                }
            });
        }

        public void onApplicationDisconnected(final int statusCode) {
            this.Cc.BT = null;
            this.Cc.BU = null;
            m3611X(statusCode);
            if (this.Cc.Ae != null) {
                this.Cc.mHandler.post(new Runnable(this) {
                    final /* synthetic */ C10891 Ce;

                    public void run() {
                        if (this.Ce.Cc.Ae != null) {
                            this.Ce.Cc.Ae.onApplicationDisconnected(statusCode);
                        }
                    }
                });
            }
        }
    }

    private static final class C1090a implements ApplicationConnectionResult {
        private final ApplicationMetadata Ci;
        private final String Cj;
        private final boolean Ck;
        private final String rR;
        private final Status yz;

        public C1090a(Status status) {
            this(status, null, null, null, false);
        }

        public C1090a(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.yz = status;
            this.Ci = applicationMetadata;
            this.Cj = str;
            this.rR = str2;
            this.Ck = z;
        }

        public ApplicationMetadata getApplicationMetadata() {
            return this.Ci;
        }

        public String getApplicationStatus() {
            return this.Cj;
        }

        public String getSessionId() {
            return this.rR;
        }

        public Status getStatus() {
            return this.yz;
        }

        public boolean getWasLaunched() {
            return this.Ck;
        }
    }

    private class C1091b implements OnConnectionFailedListener {
        final /* synthetic */ gh Cc;

        private C1091b(gh ghVar) {
            this.Cc = ghVar;
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.Cc.ei();
        }
    }

    public gh(Context context, Looper looper, CastDevice castDevice, long j, Listener listener, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, (String[]) null);
        this.BI = castDevice;
        this.Ae = listener;
        this.BL = j;
        this.mHandler = new Handler(looper);
        registerConnectionFailedListener(this.BX);
        this.BJ = new C10891(this);
    }

    private void m3628a(ge geVar) {
        boolean z;
        String ec = geVar.ec();
        if (gi.m1110a(ec, this.BM)) {
            z = false;
        } else {
            this.BM = ec;
            z = true;
        }
        BG.m1139b("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.BN));
        if (this.Ae != null && (z || this.BN)) {
            this.Ae.onApplicationStatusChanged();
        }
        this.BN = false;
    }

    private void m3631a(gj gjVar) {
        boolean z;
        double eh = gjVar.eh();
        if (eh == Double.NaN || eh == this.AP) {
            z = false;
        } else {
            this.AP = eh;
            z = true;
        }
        boolean en = gjVar.en();
        if (en != this.AQ) {
            this.AQ = en;
            z = true;
        }
        BG.m1139b("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.BO));
        if (this.Ae != null && (z || this.BO)) {
            this.Ae.onVolumeChanged();
        }
        int eo = gjVar.eo();
        if (eo != this.BR) {
            this.BR = eo;
            z = true;
        } else {
            z = false;
        }
        BG.m1139b("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.BO));
        if (this.Ae != null && (z || this.BO)) {
            this.Ae.m97O(this.BR);
        }
        this.BO = false;
    }

    private void m3637c(C0152d<ApplicationConnectionResult> c0152d) {
        synchronized (Ca) {
            if (this.BY != null) {
                this.BY.mo911a(new C1090a(new Status(2002)));
            }
            this.BY = c0152d;
        }
    }

    private void m3640e(C0152d<Status> c0152d) {
        synchronized (Cb) {
            if (this.BZ != null) {
                c0152d.mo911a(new Status(2001));
                return;
            }
            this.BZ = c0152d;
        }
    }

    private void ei() {
        BG.m1139b("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.BK) {
            this.BK.clear();
        }
    }

    private void ej() throws IllegalStateException {
        if (!this.BP || this.BQ.get()) {
            throw new IllegalStateException("Not connected to a device");
        }
    }

    protected gl m3646G(IBinder iBinder) {
        return C0742a.m2617H(iBinder);
    }

    public void m3647a(double d) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        ((gl) ft()).mo1724a(d, this.AP, this.AQ);
    }

    protected void mo2551a(int i, IBinder iBinder, Bundle bundle) {
        BG.m1139b("in onPostInitHandler; statusCode=%d", Integer.valueOf(i));
        if (i == 0 || i == 1001) {
            this.BP = true;
            this.BN = true;
            this.BO = true;
        } else {
            this.BP = false;
        }
        if (i == 1001) {
            this.BV = new Bundle();
            this.BV.putBoolean(Cast.EXTRA_APP_NO_LONGER_RUNNING, true);
            i = 0;
        }
        super.mo2551a(i, iBinder, bundle);
    }

    protected void mo2552a(hi hiVar, C1092e c1092e) throws RemoteException {
        Bundle bundle = new Bundle();
        BG.m1139b("getServiceFromBroker(): mLastApplicationId=%s, mLastSessionId=%s", this.BT, this.BU);
        this.BI.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.BL);
        if (this.BT != null) {
            bundle.putString("last_application_id", this.BT);
            if (this.BU != null) {
                bundle.putString("last_session_id", this.BU);
            }
        }
        hiVar.mo1756a((hh) c1092e, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.BJ.asBinder(), bundle);
    }

    public void m3650a(String str, MessageReceivedCallback messageReceivedCallback) throws IllegalArgumentException, IllegalStateException, RemoteException {
        gi.ak(str);
        aj(str);
        if (messageReceivedCallback != null) {
            synchronized (this.BK) {
                this.BK.put(str, messageReceivedCallback);
            }
            ((gl) ft()).an(str);
        }
    }

    public void m3651a(String str, LaunchOptions launchOptions, C0152d<ApplicationConnectionResult> c0152d) throws IllegalStateException, RemoteException {
        m3637c((C0152d) c0152d);
        ((gl) ft()).mo1725a(str, launchOptions);
    }

    public void m3652a(String str, C0152d<Status> c0152d) throws IllegalStateException, RemoteException {
        m3640e((C0152d) c0152d);
        ((gl) ft()).am(str);
    }

    public void m3653a(String str, String str2, C0152d<Status> c0152d) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        } else if (str2.length() > 65536) {
            throw new IllegalArgumentException("Message exceeds maximum size");
        } else {
            gi.ak(str);
            ej();
            long incrementAndGet = this.BS.incrementAndGet();
            ((gl) ft()).mo1726a(str, str2, incrementAndGet);
            this.BW.put(Long.valueOf(incrementAndGet), c0152d);
        }
    }

    public void m3654a(String str, boolean z, C0152d<ApplicationConnectionResult> c0152d) throws IllegalStateException, RemoteException {
        m3637c((C0152d) c0152d);
        ((gl) ft()).mo1733e(str, z);
    }

    public void aj(String str) throws IllegalArgumentException, RemoteException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.BK) {
            MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) this.BK.remove(str);
        }
        if (messageReceivedCallback != null) {
            try {
                ((gl) ft()).ao(str);
            } catch (Throwable e) {
                BG.m1138a(e, "Error unregistering namespace (%s): %s", str, e.getMessage());
            }
        }
    }

    public void m3655b(String str, String str2, C0152d<ApplicationConnectionResult> c0152d) throws IllegalStateException, RemoteException {
        m3637c((C0152d) c0152d);
        ((gl) ft()).mo1736h(str, str2);
    }

    protected String bu() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    protected String bv() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    public void m3656d(C0152d<Status> c0152d) throws IllegalStateException, RemoteException {
        m3640e((C0152d) c0152d);
        ((gl) ft()).ep();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void disconnect() {
        /*
        r6 = this;
        r5 = 1;
        r4 = 0;
        r0 = BG;
        r1 = "disconnect(); mDisconnecting=%b, isConnected=%b";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = r6.BQ;
        r3 = r3.get();
        r3 = java.lang.Boolean.valueOf(r3);
        r2[r4] = r3;
        r3 = r6.isConnected();
        r3 = java.lang.Boolean.valueOf(r3);
        r2[r5] = r3;
        r0.m1139b(r1, r2);
        r0 = r6.BQ;
        r0 = r0.getAndSet(r5);
        if (r0 == 0) goto L_0x0034;
    L_0x002a:
        r0 = BG;
        r1 = "mDisconnecting is set, so short-circuiting";
        r2 = new java.lang.Object[r4];
        r0.m1139b(r1, r2);
    L_0x0033:
        return;
    L_0x0034:
        r6.ei();
        r0 = r6.isConnected();	 Catch:{ RemoteException -> 0x0050 }
        if (r0 != 0) goto L_0x0043;
    L_0x003d:
        r0 = r6.isConnecting();	 Catch:{ RemoteException -> 0x0050 }
        if (r0 == 0) goto L_0x004c;
    L_0x0043:
        r0 = r6.ft();	 Catch:{ RemoteException -> 0x0050 }
        r0 = (com.google.android.gms.internal.gl) r0;	 Catch:{ RemoteException -> 0x0050 }
        r0.disconnect();	 Catch:{ RemoteException -> 0x0050 }
    L_0x004c:
        super.disconnect();
        goto L_0x0033;
    L_0x0050:
        r0 = move-exception;
        r1 = BG;	 Catch:{ all -> 0x0066 }
        r2 = "Error while disconnecting the controller interface: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0066 }
        r4 = 0;
        r5 = r0.getMessage();	 Catch:{ all -> 0x0066 }
        r3[r4] = r5;	 Catch:{ all -> 0x0066 }
        r1.m1138a(r0, r2, r3);	 Catch:{ all -> 0x0066 }
        super.disconnect();
        goto L_0x0033;
    L_0x0066:
        r0 = move-exception;
        super.disconnect();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gh.disconnect():void");
    }

    public Bundle ef() {
        if (this.BV == null) {
            return super.ef();
        }
        Bundle bundle = this.BV;
        this.BV = null;
        return bundle;
    }

    public void eg() throws IllegalStateException, RemoteException {
        ((gl) ft()).eg();
    }

    public double eh() throws IllegalStateException {
        ej();
        return this.AP;
    }

    public ApplicationMetadata getApplicationMetadata() throws IllegalStateException {
        ej();
        return this.BH;
    }

    public String getApplicationStatus() throws IllegalStateException {
        ej();
        return this.BM;
    }

    public boolean isMute() throws IllegalStateException {
        ej();
        return this.AQ;
    }

    protected /* synthetic */ IInterface mo2555x(IBinder iBinder) {
        return m3646G(iBinder);
    }

    public void m3658y(boolean z) throws IllegalStateException, RemoteException {
        ((gl) ft()).mo1728a(z, this.AP, this.AQ);
    }
}
