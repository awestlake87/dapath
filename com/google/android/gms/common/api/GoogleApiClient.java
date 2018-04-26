package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NotRequiredOptions;
import com.google.android.gms.common.api.Api.C0147a;
import com.google.android.gms.common.api.Api.C0149c;
import com.google.android.gms.common.api.C0153a.C1002b;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hm;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface GoogleApiClient {

    public static final class Builder {
        private Looper DF;
        private final Set<String> DH;
        private int DI;
        private View DJ;
        private String DK;
        private final Map<Api<?>, ApiOptions> DL;
        private FragmentActivity DM;
        private OnConnectionFailedListener DN;
        private final Set<ConnectionCallbacks> DO;
        private final Set<OnConnectionFailedListener> DP;
        private final Context mContext;
        private String yQ;

        public Builder(Context context) {
            this.DH = new HashSet();
            this.DL = new HashMap();
            this.DO = new HashSet();
            this.DP = new HashSet();
            this.mContext = context;
            this.DF = context.getMainLooper();
            this.DK = context.getPackageName();
        }

        public Builder(Context context, ConnectionCallbacks connectedListener, OnConnectionFailedListener connectionFailedListener) {
            this(context);
            hm.m1228b((Object) connectedListener, (Object) "Must provide a connected listener");
            this.DO.add(connectedListener);
            hm.m1228b((Object) connectionFailedListener, (Object) "Must provide a connection failed listener");
            this.DP.add(connectionFailedListener);
        }

        private C1004d eJ() {
            FragmentManager supportFragmentManager = this.DM.getSupportFragmentManager();
            if (supportFragmentManager.getFragments() != null) {
                for (Fragment fragment : supportFragmentManager.getFragments()) {
                    if ((fragment instanceof C1004d) && fragment.isAdded() && !((C1004d) fragment).isInitialized()) {
                        return (C1004d) fragment;
                    }
                }
            }
            Fragment fragment2 = new C1004d();
            supportFragmentManager.beginTransaction().add(fragment2, null).commit();
            return fragment2;
        }

        public Builder addApi(Api<? extends NotRequiredOptions> api) {
            this.DL.put(api, null);
            List eA = api.eA();
            int size = eA.size();
            for (int i = 0; i < size; i++) {
                this.DH.add(((Scope) eA.get(i)).eP());
            }
            return this;
        }

        public <O extends HasOptions> Builder addApi(Api<O> api, O options) {
            hm.m1228b((Object) options, (Object) "Null options are not permitted for this Api");
            this.DL.put(api, options);
            List eA = api.eA();
            int size = eA.size();
            for (int i = 0; i < size; i++) {
                this.DH.add(((Scope) eA.get(i)).eP());
            }
            return this;
        }

        public Builder addConnectionCallbacks(ConnectionCallbacks listener) {
            this.DO.add(listener);
            return this;
        }

        public Builder addOnConnectionFailedListener(OnConnectionFailedListener listener) {
            this.DP.add(listener);
            return this;
        }

        public Builder addScope(Scope scope) {
            this.DH.add(scope.eP());
            return this;
        }

        public GoogleApiClient build() {
            hm.m1230b(!this.DL.isEmpty(), (Object) "must call addApi() to add at least one API");
            Fragment fragment = null;
            if (this.DM != null) {
                fragment = eJ();
            }
            GoogleApiClient c0607c = new C0607c(this.mContext, this.DF, eI(), this.DL, fragment, this.DO, this.DP);
            if (fragment != null) {
                fragment.m3192a(c0607c, this.DN);
            }
            return c0607c;
        }

        public gy eI() {
            return new gy(this.yQ, this.DH, this.DI, this.DJ, this.DK);
        }

        public Builder enableAutoManage(FragmentActivity fragmentActivity, OnConnectionFailedListener unresolvedConnectionFailedListener) {
            this.DM = (FragmentActivity) hm.m1228b((Object) fragmentActivity, (Object) "Null activity is not permitted.");
            this.DN = unresolvedConnectionFailedListener;
            return this;
        }

        public Builder setAccountName(String accountName) {
            this.yQ = accountName;
            return this;
        }

        public Builder setGravityForPopups(int gravityForPopups) {
            this.DI = gravityForPopups;
            return this;
        }

        public Builder setHandler(Handler handler) {
            hm.m1228b((Object) handler, (Object) "Handler must not be null");
            this.DF = handler.getLooper();
            return this;
        }

        public Builder setViewForPopups(View viewForPopups) {
            this.DJ = viewForPopups;
            return this;
        }

        public Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }
    }

    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    public interface OnConnectionFailedListener extends com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    <C extends C0147a> C mo925a(C0149c<C> c0149c);

    <A extends C0147a, T extends C1002b<? extends Result, A>> T mo926a(T t);

    <A extends C0147a, T extends C1002b<? extends Result, A>> T mo927b(T t);

    ConnectionResult blockingConnect();

    ConnectionResult blockingConnect(long j, TimeUnit timeUnit);

    void connect();

    void disconnect();

    Looper getLooper();

    boolean isConnected();

    boolean isConnecting();

    boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks);

    boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener);

    void reconnect();

    void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    void stopAutoManage();

    void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);
}
