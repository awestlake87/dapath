package com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.C0147a;
import com.google.android.gms.common.api.Api.C0148b;
import com.google.android.gms.common.api.Api.C0149c;
import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.C0153a.C1002b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ga;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hm;

public final class AppStateManager {
    public static final Api<NoOptions> API = new Api(yI, yH, SCOPE_APP_STATE);
    public static final Scope SCOPE_APP_STATE = new Scope(Scopes.APP_STATE);
    static final C0149c<ga> yH = new C0149c();
    private static final C0148b<ga, NoOptions> yI = new C05941();

    static class C05941 implements C0148b<ga, NoOptions> {
        C05941() {
        }

        public /* synthetic */ C0147a mo880a(Context context, Looper looper, gy gyVar, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return m1964b(context, looper, gyVar, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public ga m1964b(Context context, Looper looper, gy gyVar, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new ga(context, looper, connectionCallbacks, onConnectionFailedListener, gyVar.fj(), (String[]) gyVar.fl().toArray(new String[0]));
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public interface StateConflictResult extends Releasable, Result {
        byte[] getLocalData();

        String getResolvedVersion();

        byte[] getServerData();

        int getStateKey();
    }

    public interface StateDeletedResult extends Result {
        int getStateKey();
    }

    public interface StateListResult extends Result {
        AppStateBuffer getStateBuffer();
    }

    public interface StateLoadedResult extends Releasable, Result {
        byte[] getLocalData();

        int getStateKey();
    }

    public interface StateResult extends Releasable, Result {
        StateConflictResult getConflictResult();

        StateLoadedResult getLoadedResult();
    }

    public static abstract class C1160a<R extends Result> extends C1002b<R, ga> {
        public C1160a() {
            super(AppStateManager.yH);
        }
    }

    private static abstract class C1213b extends C1160a<StateDeletedResult> {
        private C1213b() {
        }
    }

    private static abstract class C1214c extends C1160a<StateListResult> {
        private C1214c() {
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4114h(status);
        }

        public StateListResult m4114h(final Status status) {
            return new StateListResult(this) {
                final /* synthetic */ C1214c yP;

                public AppStateBuffer getStateBuffer() {
                    return new AppStateBuffer(null);
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class C1215d extends C1160a<Status> {
        private C1215d() {
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4116d(status);
        }

        public Status m4116d(Status status) {
            return status;
        }
    }

    private static abstract class C1216e extends C1160a<StateResult> {
        private C1216e() {
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4118i(status);
        }

        public StateResult m4118i(Status status) {
            return AppStateManager.m90e(status);
        }
    }

    static class C12777 extends C1214c {
        C12777() {
            super();
        }

        protected void m4334a(ga gaVar) {
            gaVar.m3602a(this);
        }
    }

    static class C12799 extends C1215d {
        C12799() {
            super();
        }

        protected void m4338a(ga gaVar) {
            gaVar.m3607b((C0152d) this);
        }
    }

    private AppStateManager() {
    }

    public static ga m89a(GoogleApiClient googleApiClient) {
        boolean z = true;
        hm.m1230b(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        hm.m1226a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        ga gaVar = (ga) googleApiClient.mo925a(yH);
        if (gaVar == null) {
            z = false;
        }
        hm.m1226a(z, "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return gaVar;
    }

    public static PendingResult<StateDeletedResult> delete(GoogleApiClient googleApiClient, final int stateKey) {
        return googleApiClient.mo927b(new C1213b() {
            protected void m4328a(ga gaVar) {
                gaVar.m3603a((C0152d) this, stateKey);
            }

            public /* synthetic */ Result mo2535c(Status status) {
                return m4330g(status);
            }

            public StateDeletedResult m4330g(final Status status) {
                return new StateDeletedResult(this) {
                    final /* synthetic */ C12755 yM;

                    public int getStateKey() {
                        return stateKey;
                    }

                    public Status getStatus() {
                        return status;
                    }
                };
            }
        });
    }

    private static StateResult m90e(final Status status) {
        return new StateResult() {
            public StateConflictResult getConflictResult() {
                return null;
            }

            public StateLoadedResult getLoadedResult() {
                return null;
            }

            public Status getStatus() {
                return status;
            }

            public void release() {
            }
        };
    }

    public static int getMaxNumKeys(GoogleApiClient googleApiClient) {
        return m89a(googleApiClient).dV();
    }

    public static int getMaxStateSize(GoogleApiClient googleApiClient) {
        return m89a(googleApiClient).dU();
    }

    public static PendingResult<StateListResult> list(GoogleApiClient googleApiClient) {
        return googleApiClient.mo926a(new C12777());
    }

    public static PendingResult<StateResult> load(GoogleApiClient googleApiClient, final int stateKey) {
        return googleApiClient.mo926a(new C1216e() {
            protected void m4332a(ga gaVar) {
                gaVar.m3608b(this, stateKey);
            }
        });
    }

    public static PendingResult<StateResult> resolve(GoogleApiClient googleApiClient, final int stateKey, final String resolvedVersion, final byte[] resolvedData) {
        return googleApiClient.mo927b(new C1216e() {
            protected void m4336a(ga gaVar) {
                gaVar.m3604a(this, stateKey, resolvedVersion, resolvedData);
            }
        });
    }

    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.mo927b(new C12799());
    }

    public static void update(GoogleApiClient googleApiClient, final int stateKey, final byte[] data) {
        googleApiClient.mo927b(new C1216e() {
            protected void m4324a(ga gaVar) {
                gaVar.m3605a(null, stateKey, data);
            }
        });
    }

    public static PendingResult<StateResult> updateImmediate(GoogleApiClient googleApiClient, final int stateKey, final byte[] data) {
        return googleApiClient.mo927b(new C1216e() {
            protected void m4326a(ga gaVar) {
                gaVar.m3605a(this, stateKey, data);
            }
        });
    }
}
