package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.gy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Api<O extends ApiOptions> {
    private final C0148b<?, O> Dm;
    private final C0149c<?> Dn;
    private final ArrayList<Scope> Do;

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    public interface C0147a {
        void connect();

        void disconnect();

        Looper getLooper();

        boolean isConnected();
    }

    public interface C0148b<T extends C0147a, O> {
        T mo880a(Context context, Looper looper, gy gyVar, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener);

        int getPriority();
    }

    public static final class C0149c<C extends C0147a> {
    }

    public <C extends C0147a> Api(C0148b<C, O> clientBuilder, C0149c<C> clientKey, Scope... impliedScopes) {
        this.Dm = clientBuilder;
        this.Dn = clientKey;
        this.Do = new ArrayList(Arrays.asList(impliedScopes));
    }

    public List<Scope> eA() {
        return this.Do;
    }

    public C0149c<?> eB() {
        return this.Dn;
    }

    public C0148b<?, O> ez() {
        return this.Dm;
    }
}
