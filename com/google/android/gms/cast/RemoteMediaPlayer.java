package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast.C1161a;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.gh;
import com.google.android.gms.internal.go;
import com.google.android.gms.internal.gp;
import com.google.android.gms.internal.gq;
import java.io.IOException;
import org.json.JSONObject;

public class RemoteMediaPlayer implements MessageReceivedCallback {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2;
    public static final int STATUS_FAILED = 1;
    public static final int STATUS_REPLACED = 4;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 3;
    private final go AW = new C09991(this);
    private final C0598a AX = new C0598a(this);
    private OnMetadataUpdatedListener AY;
    private OnStatusUpdatedListener AZ;
    private final Object ls = new Object();

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();
    }

    private class C0598a implements gp {
        final /* synthetic */ RemoteMediaPlayer Ba;
        private GoogleApiClient Bm;
        private long Bn = 0;

        private final class C0597a implements ResultCallback<Status> {
            private final long Bo;
            final /* synthetic */ C0598a Bp;

            C0597a(C0598a c0598a, long j) {
                this.Bp = c0598a;
                this.Bo = j;
            }

            public void m1967k(Status status) {
                if (!status.isSuccess()) {
                    this.Bp.Ba.AW.mo1737a(this.Bo, status.getStatusCode());
                }
            }

            public /* synthetic */ void onResult(Result x0) {
                m1967k((Status) x0);
            }
        }

        public C0598a(RemoteMediaPlayer remoteMediaPlayer) {
            this.Ba = remoteMediaPlayer;
        }

        public void mo902a(String str, String str2, long j, String str3) throws IOException {
            if (this.Bm == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.Bm, str, str2).setResultCallback(new C0597a(this, j));
        }

        public void m1969b(GoogleApiClient googleApiClient) {
            this.Bm = googleApiClient;
        }

        public long eb() {
            long j = this.Bn + 1;
            this.Bn = j;
            return j;
        }
    }

    class C09991 extends go {
        final /* synthetic */ RemoteMediaPlayer Ba;

        C09991(RemoteMediaPlayer remoteMediaPlayer) {
            this.Ba = remoteMediaPlayer;
        }

        protected void onMetadataUpdated() {
            this.Ba.onMetadataUpdated();
        }

        protected void onStatusUpdated() {
            this.Ba.onStatusUpdated();
        }
    }

    private static final class C1001c implements MediaChannelResult {
        private final JSONObject AA;
        private final Status yz;

        C1001c(Status status, JSONObject jSONObject) {
            this.yz = status;
            this.AA = jSONObject;
        }

        public JSONObject getCustomData() {
            return this.AA;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static abstract class C1219b extends C1161a<MediaChannelResult> {
        gq Bq = new C05991(this);

        class C05991 implements gq {
            final /* synthetic */ C1219b Br;

            C05991(C1219b c1219b) {
                this.Br = c1219b;
            }

            public void mo904a(long j, int i, JSONObject jSONObject) {
                this.Br.m1984b(new C1001c(new Status(i), jSONObject));
            }

            public void mo905n(long j) {
                this.Br.m1984b(this.Br.m4124l(new Status(4)));
            }
        }

        C1219b() {
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4124l(status);
        }

        public MediaChannelResult m4124l(final Status status) {
            return new MediaChannelResult(this) {
                final /* synthetic */ C1219b Br;

                public JSONObject getCustomData() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public RemoteMediaPlayer() {
        this.AW.m1108a(this.AX);
    }

    private void onMetadataUpdated() {
        if (this.AY != null) {
            this.AY.onMetadataUpdated();
        }
    }

    private void onStatusUpdated() {
        if (this.AZ != null) {
            this.AZ.onStatusUpdated();
        }
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.ls) {
            approximateStreamPosition = this.AW.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.ls) {
            mediaInfo = this.AW.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.ls) {
            mediaStatus = this.AW.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.AW.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.ls) {
            streamDuration = this.AW.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo) {
        return load(apiClient, mediaInfo, true, 0, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay) {
        return load(apiClient, mediaInfo, autoplay, 0, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaInfo mediaInfo2 = mediaInfo;
        final boolean z = autoplay;
        final long j = playPosition;
        final JSONObject jSONObject = customData;
        return apiClient.mo927b(new C1219b(this) {
            final /* synthetic */ RemoteMediaPlayer Ba;

            protected void m4366a(gh ghVar) {
                synchronized (this.Ba.ls) {
                    this.Ba.AX.m1969b(googleApiClient);
                    try {
                        this.Ba.AW.m2626a(this.Bq, mediaInfo2, z, j, jSONObject);
                        this.Ba.AX.m1969b(null);
                    } catch (IOException e) {
                        m1984b(m4124l(new Status(1)));
                        this.Ba.AX.m1969b(null);
                    } catch (Throwable th) {
                        this.Ba.AX.m1969b(null);
                    }
                }
            }
        });
    }

    public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
        this.AW.ai(message);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient apiClient) {
        return pause(apiClient, null);
    }

    public PendingResult<MediaChannelResult> pause(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.mo927b(new C1219b(this) {
            final /* synthetic */ RemoteMediaPlayer Ba;

            protected void m4368a(gh ghVar) {
                synchronized (this.Ba.ls) {
                    this.Ba.AX.m1969b(apiClient);
                    try {
                        this.Ba.AW.m2628a(this.Bq, customData);
                        this.Ba.AX.m1969b(null);
                    } catch (IOException e) {
                        m1984b(m4124l(new Status(1)));
                        this.Ba.AX.m1969b(null);
                    } catch (Throwable th) {
                        this.Ba.AX.m1969b(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient apiClient) {
        return play(apiClient, null);
    }

    public PendingResult<MediaChannelResult> play(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.mo927b(new C1219b(this) {
            final /* synthetic */ RemoteMediaPlayer Ba;

            protected void m4372a(gh ghVar) {
                synchronized (this.Ba.ls) {
                    this.Ba.AX.m1969b(apiClient);
                    try {
                        this.Ba.AW.m2633c(this.Bq, customData);
                        this.Ba.AX.m1969b(null);
                    } catch (IOException e) {
                        m1984b(m4124l(new Status(1)));
                        this.Ba.AX.m1969b(null);
                    } catch (Throwable th) {
                        this.Ba.AX.m1969b(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> requestStatus(final GoogleApiClient apiClient) {
        return apiClient.mo927b(new C1219b(this) {
            final /* synthetic */ RemoteMediaPlayer Ba;

            protected void m4360a(gh ghVar) {
                synchronized (this.Ba.ls) {
                    this.Ba.AX.m1969b(apiClient);
                    try {
                        this.Ba.AW.m2623a(this.Bq);
                        this.Ba.AX.m1969b(null);
                    } catch (IOException e) {
                        m1984b(m4124l(new Status(1)));
                        this.Ba.AX.m1969b(null);
                    } catch (Throwable th) {
                        this.Ba.AX.m1969b(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position) {
        return seek(apiClient, position, 0, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState) {
        return seek(apiClient, position, resumeState, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final long j = position;
        final int i = resumeState;
        final JSONObject jSONObject = customData;
        return apiClient.mo927b(new C1219b(this) {
            final /* synthetic */ RemoteMediaPlayer Ba;

            protected void m4374a(gh ghVar) {
                synchronized (this.Ba.ls) {
                    this.Ba.AX.m1969b(googleApiClient);
                    try {
                        this.Ba.AW.m2625a(this.Bq, j, i, jSONObject);
                        this.Ba.AX.m1969b(null);
                    } catch (IOException e) {
                        m1984b(m4124l(new Status(1)));
                        this.Ba.AX.m1969b(null);
                    } catch (Throwable th) {
                        this.Ba.AX.m1969b(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setActiveMediaTracks(final GoogleApiClient apiClient, final long[] trackIds) {
        return apiClient.mo927b(new C1219b(this) {
            final /* synthetic */ RemoteMediaPlayer Ba;

            protected void m4362a(gh ghVar) {
                synchronized (this.Ba.ls) {
                    this.Ba.AX.m1969b(apiClient);
                    try {
                        this.Ba.AW.m2630a(this.Bq, trackIds);
                        this.Ba.AX.m1969b(null);
                    } catch (IOException e) {
                        m1984b(m4124l(new Status(1)));
                        this.Ba.AX.m1969b(null);
                    } catch (Throwable th) {
                        this.Ba.AX.m1969b(null);
                    }
                }
            }
        });
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener listener) {
        this.AY = listener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener listener) {
        this.AZ = listener;
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState) {
        return setStreamMute(apiClient, muteState, null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(final GoogleApiClient apiClient, final boolean muteState, final JSONObject customData) {
        return apiClient.mo927b(new C1219b(this) {
            final /* synthetic */ RemoteMediaPlayer Ba;

            protected void m4358a(gh ghVar) {
                synchronized (this.Ba.ls) {
                    this.Ba.AX.m1969b(apiClient);
                    try {
                        this.Ba.AW.m2629a(this.Bq, muteState, customData);
                        this.Ba.AX.m1969b(null);
                    } catch (IllegalStateException e) {
                        m1984b(m4124l(new Status(1)));
                        this.Ba.AX.m1969b(null);
                    } catch (IOException e2) {
                        m1984b(m4124l(new Status(1)));
                        this.Ba.AX.m1969b(null);
                    } catch (Throwable th) {
                        this.Ba.AX.m1969b(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume) throws IllegalArgumentException {
        return setStreamVolume(apiClient, volume, null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume, JSONObject customData) throws IllegalArgumentException {
        if (Double.isInfinite(volume) || Double.isNaN(volume)) {
            throw new IllegalArgumentException("Volume cannot be " + volume);
        }
        final GoogleApiClient googleApiClient = apiClient;
        final double d = volume;
        final JSONObject jSONObject = customData;
        return apiClient.mo927b(new C1219b(this) {
            final /* synthetic */ RemoteMediaPlayer Ba;

            protected void m4376a(gh ghVar) {
                synchronized (this.Ba.ls) {
                    this.Ba.AX.m1969b(googleApiClient);
                    try {
                        this.Ba.AW.m2624a(this.Bq, d, jSONObject);
                        this.Ba.AX.m1969b(null);
                    } catch (IllegalStateException e) {
                        m1984b(m4124l(new Status(1)));
                        this.Ba.AX.m1969b(null);
                    } catch (IllegalArgumentException e2) {
                        m1984b(m4124l(new Status(1)));
                        this.Ba.AX.m1969b(null);
                    } catch (IOException e3) {
                        m1984b(m4124l(new Status(1)));
                        this.Ba.AX.m1969b(null);
                    } catch (Throwable th) {
                        this.Ba.AX.m1969b(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setTextTrackStyle(final GoogleApiClient apiClient, final TextTrackStyle trackStyle) {
        return apiClient.mo927b(new C1219b(this) {
            final /* synthetic */ RemoteMediaPlayer Ba;

            protected void m4364a(gh ghVar) {
                synchronized (this.Ba.ls) {
                    this.Ba.AX.m1969b(apiClient);
                    try {
                        this.Ba.AW.m2627a(this.Bq, trackStyle);
                        this.Ba.AX.m1969b(null);
                    } catch (IOException e) {
                        m1984b(m4124l(new Status(1)));
                        this.Ba.AX.m1969b(null);
                    } catch (Throwable th) {
                        this.Ba.AX.m1969b(null);
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient apiClient) {
        return stop(apiClient, null);
    }

    public PendingResult<MediaChannelResult> stop(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.mo927b(new C1219b(this) {
            final /* synthetic */ RemoteMediaPlayer Ba;

            protected void m4370a(gh ghVar) {
                synchronized (this.Ba.ls) {
                    this.Ba.AX.m1969b(apiClient);
                    try {
                        this.Ba.AW.m2632b(this.Bq, customData);
                        this.Ba.AX.m1969b(null);
                    } catch (IOException e) {
                        m1984b(m4124l(new Status(1)));
                        this.Ba.AX.m1969b(null);
                    } catch (Throwable th) {
                        this.Ba.AX.m1969b(null);
                    }
                }
            }
        });
    }
}
