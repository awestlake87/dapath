package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.internal.dp.C0305a;

public abstract class dq extends em {
    private final ds ne;
    private final C0305a pT;

    public static final class C1083a extends dq {
        private final Context mContext;

        public C1083a(Context context, ds dsVar, C0305a c0305a) {
            super(dsVar, c0305a);
            this.mContext = context;
        }

        public void bs() {
        }

        public dw bt() {
            return dx.m3587a(this.mContext, new ay(), new bj(), new ee());
        }
    }

    public static final class C1084b extends dq implements ConnectionCallbacks, OnConnectionFailedListener {
        private final Object ls = new Object();
        private final C0305a pT;
        private final dr pU;

        public C1084b(Context context, ds dsVar, C0305a c0305a) {
            super(dsVar, c0305a);
            this.pT = c0305a;
            this.pU = new dr(context, this, this, dsVar.kQ.sy);
            this.pU.connect();
        }

        public void bs() {
            synchronized (this.ls) {
                if (this.pU.isConnected() || this.pU.isConnecting()) {
                    this.pU.disconnect();
                }
            }
        }

        public dw bt() {
            dw bw;
            synchronized (this.ls) {
                try {
                    bw = this.pU.bw();
                } catch (IllegalStateException e) {
                    bw = null;
                }
            }
            return bw;
        }

        public void onConnected(Bundle connectionHint) {
            start();
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.pT.mo1690a(new du(0));
        }

        public void onDisconnected() {
            eu.m1019z("Disconnected from remote ad request service.");
        }
    }

    public dq(ds dsVar, C0305a c0305a) {
        this.ne = dsVar;
        this.pT = c0305a;
    }

    private static du m2554a(dw dwVar, ds dsVar) {
        du duVar = null;
        try {
            duVar = dwVar.mo1691b(dsVar);
        } catch (Throwable e) {
            eu.m1017c("Could not fetch ad response from ad request service.", e);
        } catch (Throwable e2) {
            eu.m1017c("Could not fetch ad response from ad request service due to an Exception.", e2);
        } catch (Throwable e22) {
            eu.m1017c("Could not fetch ad response from ad request service due to an Exception.", e22);
        }
        return duVar;
    }

    public final void bh() {
        try {
            du duVar;
            dw bt = bt();
            if (bt == null) {
                duVar = new du(0);
            } else {
                duVar = m2554a(bt, this.ne);
                if (duVar == null) {
                    duVar = new du(0);
                }
            }
            bs();
            this.pT.mo1690a(duVar);
        } catch (Throwable th) {
            bs();
        }
    }

    public abstract void bs();

    public abstract dw bt();

    public final void onStop() {
        bs();
    }
}
