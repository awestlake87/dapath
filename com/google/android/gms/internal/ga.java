package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateDeletedResult;
import com.google.android.gms.appstate.AppStateManager.StateListResult;
import com.google.android.gms.appstate.AppStateManager.StateLoadedResult;
import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.C0603b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.gc.C0740a;
import com.google.android.gms.internal.hb.C1092e;

public final class ga extends hb<gc> {
    private final String yQ;

    private static final class C1086b implements StateDeletedResult {
        private final int yS;
        private final Status yz;

        public C1086b(Status status, int i) {
            this.yz = status;
            this.yS = i;
        }

        public int getStateKey() {
            return this.yS;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static final class C1087d extends C0603b implements StateListResult {
        private final AppStateBuffer yT;

        public C1087d(DataHolder dataHolder) {
            super(dataHolder);
            this.yT = new AppStateBuffer(dataHolder);
        }

        public AppStateBuffer getStateBuffer() {
            return this.yT;
        }
    }

    private static final class C1088f extends C0603b implements StateConflictResult, StateLoadedResult, StateResult {
        private final int yS;
        private final AppStateBuffer yT;

        public C1088f(int i, DataHolder dataHolder) {
            super(dataHolder);
            this.yS = i;
            this.yT = new AppStateBuffer(dataHolder);
        }

        private boolean dW() {
            return this.yz.getStatusCode() == 2000;
        }

        public StateConflictResult getConflictResult() {
            return dW() ? this : null;
        }

        public StateLoadedResult getLoadedResult() {
            return dW() ? null : this;
        }

        public byte[] getLocalData() {
            return this.yT.getCount() == 0 ? null : this.yT.get(0).getLocalData();
        }

        public String getResolvedVersion() {
            return this.yT.getCount() == 0 ? null : this.yT.get(0).getConflictVersion();
        }

        public byte[] getServerData() {
            return this.yT.getCount() == 0 ? null : this.yT.get(0).getConflictData();
        }

        public int getStateKey() {
            return this.yS;
        }

        public void release() {
            this.yT.close();
        }
    }

    private static final class C1179a extends fz {
        private final C0152d<StateDeletedResult> yR;

        public C1179a(C0152d<StateDeletedResult> c0152d) {
            this.yR = (C0152d) hm.m1228b((Object) c0152d, (Object) "Result holder must not be null");
        }

        public void mo1713b(int i, int i2) {
            this.yR.mo911a(new C1086b(new Status(i), i2));
        }
    }

    private static final class C1180c extends fz {
        private final C0152d<StateListResult> yR;

        public C1180c(C0152d<StateListResult> c0152d) {
            this.yR = (C0152d) hm.m1228b((Object) c0152d, (Object) "Result holder must not be null");
        }

        public void mo1712a(DataHolder dataHolder) {
            this.yR.mo911a(new C1087d(dataHolder));
        }
    }

    private static final class C1181e extends fz {
        private final C0152d<StateResult> yR;

        public C1181e(C0152d<StateResult> c0152d) {
            this.yR = (C0152d) hm.m1228b((Object) c0152d, (Object) "Result holder must not be null");
        }

        public void mo1711a(int i, DataHolder dataHolder) {
            this.yR.mo911a(new C1088f(i, dataHolder));
        }
    }

    private static final class C1182g extends fz {
        private final C0152d<Status> yR;

        public C1182g(C0152d<Status> c0152d) {
            this.yR = (C0152d) hm.m1228b((Object) c0152d, (Object) "Holder must not be null");
        }

        public void dT() {
            this.yR.mo911a(new Status(0));
        }
    }

    public ga(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, String[] strArr) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, strArr);
        this.yQ = (String) hm.m1232f(str);
    }

    protected gc m3601D(IBinder iBinder) {
        return C0740a.m2609F(iBinder);
    }

    public void m3602a(C0152d<StateListResult> c0152d) {
        try {
            ((gc) ft()).mo1715a(new C1180c(c0152d));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void m3603a(C0152d<StateDeletedResult> c0152d, int i) {
        try {
            ((gc) ft()).mo1720b(new C1179a(c0152d), i);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void m3604a(C0152d<StateResult> c0152d, int i, String str, byte[] bArr) {
        try {
            ((gc) ft()).mo1717a(new C1181e(c0152d), i, str, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void m3605a(C0152d<StateResult> c0152d, int i, byte[] bArr) {
        if (c0152d == null) {
            gb gbVar = null;
        } else {
            Object c1181e = new C1181e(c0152d);
        }
        try {
            ((gc) ft()).mo1718a(gbVar, i, bArr);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    protected void mo2552a(hi hiVar, C1092e c1092e) throws RemoteException {
        hiVar.mo1759a((hh) c1092e, (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, getContext().getPackageName(), this.yQ, fs());
    }

    public void m3607b(C0152d<Status> c0152d) {
        try {
            ((gc) ft()).mo1719b(new C1182g(c0152d));
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    public void m3608b(C0152d<StateResult> c0152d, int i) {
        try {
            ((gc) ft()).mo1716a(new C1181e(c0152d), i);
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
        }
    }

    protected void mo2653b(String... strArr) {
        boolean z = false;
        for (String equals : strArr) {
            if (equals.equals(Scopes.APP_STATE)) {
                z = true;
            }
        }
        hm.m1226a(z, String.format("App State APIs requires %s to function.", new Object[]{Scopes.APP_STATE}));
    }

    protected String bu() {
        return "com.google.android.gms.appstate.service.START";
    }

    protected String bv() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    public int dU() {
        try {
            return ((gc) ft()).dU();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    public int dV() {
        try {
            return ((gc) ft()).dV();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    protected /* synthetic */ IInterface mo2555x(IBinder iBinder) {
        return m3601D(iBinder);
    }
}
