package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions.Builder;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.C0148b;
import com.google.android.gms.common.api.Api.C0149c;
import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.C0153a.C1002b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.gh;
import com.google.android.gms.internal.gy;
import com.google.android.gms.internal.hm;
import java.io.IOException;

public final class Cast {
    public static final Api<CastOptions> API = new Api(yI, yH, new Scope[0]);
    public static final CastApi CastApi = new C0596a();
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    static final C0149c<gh> yH = new C0149c();
    private static final C0148b<gh, CastOptions> yI = new C05951();

    public interface CastApi {

        public static final class C0596a implements CastApi {

            class C12856 extends C1218c {
                final /* synthetic */ C0596a zW;

                C12856(C0596a c0596a) {
                    this.zW = c0596a;
                    super();
                }

                protected void m4350a(gh ghVar) throws RemoteException {
                    try {
                        ghVar.m3655b(null, null, this);
                    } catch (IllegalStateException e) {
                        m3903N(2001);
                    }
                }
            }

            class C12867 extends C1217b {
                final /* synthetic */ C0596a zW;

                C12867(C0596a c0596a) {
                    this.zW = c0596a;
                    super();
                }

                protected void m4352a(gh ghVar) throws RemoteException {
                    try {
                        ghVar.m3656d((C0152d) this);
                    } catch (IllegalStateException e) {
                        m3903N(2001);
                    }
                }
            }

            class C12878 extends C1217b {
                final /* synthetic */ C0596a zW;

                C12878(C0596a c0596a) {
                    this.zW = c0596a;
                    super();
                }

                protected void m4354a(gh ghVar) throws RemoteException {
                    try {
                        ghVar.m3652a("", (C0152d) this);
                    } catch (IllegalStateException e) {
                        m3903N(2001);
                    }
                }
            }

            public ApplicationMetadata getApplicationMetadata(GoogleApiClient client) throws IllegalStateException {
                return ((gh) client.mo925a(Cast.yH)).getApplicationMetadata();
            }

            public String getApplicationStatus(GoogleApiClient client) throws IllegalStateException {
                return ((gh) client.mo925a(Cast.yH)).getApplicationStatus();
            }

            public double getVolume(GoogleApiClient client) throws IllegalStateException {
                return ((gh) client.mo925a(Cast.yH)).eh();
            }

            public boolean isMute(GoogleApiClient client) throws IllegalStateException {
                return ((gh) client.mo925a(Cast.yH)).isMute();
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client) {
                return client.mo927b(new C12856(this));
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, final String applicationId) {
                return client.mo927b(new C1218c(this) {
                    final /* synthetic */ C0596a zW;

                    protected void m4348a(gh ghVar) throws RemoteException {
                        try {
                            ghVar.m3655b(applicationId, null, this);
                        } catch (IllegalStateException e) {
                            m3903N(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, final String applicationId, final String sessionId) {
                return client.mo927b(new C1218c(this) {
                    final /* synthetic */ C0596a zW;

                    protected void m4346a(gh ghVar) throws RemoteException {
                        try {
                            ghVar.m3655b(applicationId, sessionId, this);
                        } catch (IllegalStateException e) {
                            m3903N(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, final String applicationId) {
                return client.mo927b(new C1218c(this) {
                    final /* synthetic */ C0596a zW;

                    protected void m4342a(gh ghVar) throws RemoteException {
                        try {
                            ghVar.m3654a(applicationId, false, (C0152d) this);
                        } catch (IllegalStateException e) {
                            m3903N(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, final String applicationId, final LaunchOptions options) {
                return client.mo927b(new C1218c(this) {
                    final /* synthetic */ C0596a zW;

                    protected void m4344a(gh ghVar) throws RemoteException {
                        try {
                            ghVar.m3651a(applicationId, options, (C0152d) this);
                        } catch (IllegalStateException e) {
                            m3903N(2001);
                        }
                    }
                });
            }

            @Deprecated
            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, String applicationId, boolean relaunchIfRunning) {
                return launchApplication(client, applicationId, new Builder().setRelaunchIfRunning(relaunchIfRunning).build());
            }

            public PendingResult<Status> leaveApplication(GoogleApiClient client) {
                return client.mo927b(new C12867(this));
            }

            public void removeMessageReceivedCallbacks(GoogleApiClient client, String namespace) throws IOException, IllegalArgumentException {
                try {
                    ((gh) client.mo925a(Cast.yH)).aj(namespace);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void requestStatus(GoogleApiClient client) throws IOException, IllegalStateException {
                try {
                    ((gh) client.mo925a(Cast.yH)).eg();
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> sendMessage(GoogleApiClient client, final String namespace, final String message) {
                return client.mo927b(new C1217b(this) {
                    final /* synthetic */ C0596a zW;

                    protected void m4340a(gh ghVar) throws RemoteException {
                        try {
                            ghVar.m3653a(namespace, message, (C0152d) this);
                        } catch (IllegalArgumentException e) {
                            m3903N(2001);
                        } catch (IllegalStateException e2) {
                            m3903N(2001);
                        }
                    }
                });
            }

            public void setMessageReceivedCallbacks(GoogleApiClient client, String namespace, MessageReceivedCallback callbacks) throws IOException, IllegalStateException {
                try {
                    ((gh) client.mo925a(Cast.yH)).m3650a(namespace, callbacks);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setMute(GoogleApiClient client, boolean mute) throws IOException, IllegalStateException {
                try {
                    ((gh) client.mo925a(Cast.yH)).m3658y(mute);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setVolume(GoogleApiClient client, double volume) throws IOException, IllegalArgumentException, IllegalStateException {
                try {
                    ((gh) client.mo925a(Cast.yH)).m3647a(volume);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client) {
                return client.mo927b(new C12878(this));
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client, final String sessionId) {
                return client.mo927b(new C1217b(this) {
                    final /* synthetic */ C0596a zW;

                    protected void m4356a(gh ghVar) throws RemoteException {
                        if (TextUtils.isEmpty(sessionId)) {
                            m3904c(2001, "IllegalArgument: sessionId cannot be null or empty");
                            return;
                        }
                        try {
                            ghVar.m3652a(sessionId, (C0152d) this);
                        } catch (IllegalStateException e) {
                            m3903N(2001);
                        }
                    }
                });
            }
        }

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException;

        String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException;

        double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException;

        boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException;

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions);

        @Deprecated
        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z);

        PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException;

        void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException;

        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException;

        void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException;

        void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException;

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public static class Listener {
        public void m97O(int i) {
        }

        public void onApplicationDisconnected(int statusCode) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    static class C05951 implements C0148b<gh, CastOptions> {
        C05951() {
        }

        public gh m1966a(Context context, Looper looper, gy gyVar, CastOptions castOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            hm.m1228b((Object) castOptions, (Object) "Setting the API options is required.");
            return new gh(context, looper, castOptions.Aa, (long) castOptions.Ac, castOptions.Ab, connectionCallbacks, onConnectionFailedListener);
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    public static final class CastOptions implements HasOptions {
        final CastDevice Aa;
        final Listener Ab;
        private final int Ac;

        public static final class Builder {
            CastDevice Ad;
            Listener Ae;
            private int Af;

            private Builder(CastDevice castDevice, Listener castListener) {
                hm.m1228b((Object) castDevice, (Object) "CastDevice parameter cannot be null");
                hm.m1228b((Object) castListener, (Object) "CastListener parameter cannot be null");
                this.Ad = castDevice;
                this.Ae = castListener;
                this.Af = 0;
            }

            public CastOptions build() {
                return new CastOptions();
            }

            public Builder setVerboseLoggingEnabled(boolean enabled) {
                if (enabled) {
                    this.Af |= 1;
                } else {
                    this.Af &= -2;
                }
                return this;
            }
        }

        private CastOptions(Builder builder) {
            this.Aa = builder.Ad;
            this.Ab = builder.Ae;
            this.Ac = builder.Af;
        }

        public static Builder builder(CastDevice castDevice, Listener castListener) {
            return new Builder(castDevice, castListener);
        }
    }

    protected static abstract class C1161a<R extends Result> extends C1002b<R, gh> {
        public C1161a() {
            super(Cast.yH);
        }

        public void m3903N(int i) {
            m1984b(mo2535c(new Status(i)));
        }

        public void m3904c(int i, String str) {
            m1984b(mo2535c(new Status(i, str, null)));
        }
    }

    private static abstract class C1217b extends C1161a<Status> {
        private C1217b() {
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4120d(status);
        }

        public Status m4120d(Status status) {
            return status;
        }
    }

    private static abstract class C1218c extends C1161a<ApplicationConnectionResult> {
        private C1218c() {
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4122j(status);
        }

        public ApplicationConnectionResult m4122j(final Status status) {
            return new ApplicationConnectionResult(this) {
                final /* synthetic */ C1218c Ag;

                public ApplicationMetadata getApplicationMetadata() {
                    return null;
                }

                public String getApplicationStatus() {
                    return null;
                }

                public String getSessionId() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public boolean getWasLaunched() {
                    return false;
                }
            };
        }
    }

    private Cast() {
    }
}
