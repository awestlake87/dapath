package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.Plus.C1195a;
import com.google.android.gms.plus.internal.C1138e;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

public final class kl implements Moments {

    private static abstract class C1252a extends C1195a<LoadMomentsResult> {
        private C1252a() {
        }

        public LoadMomentsResult an(final Status status) {
            return new LoadMomentsResult(this) {
                final /* synthetic */ C1252a acl;

                public MomentBuffer getMomentBuffer() {
                    return null;
                }

                public String getNextPageToken() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public String getUpdated() {
                    return null;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return an(status);
        }
    }

    private static abstract class C1253b extends C1195a<Status> {
        private C1253b() {
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4263d(status);
        }

        public Status m4263d(Status status) {
            return status;
        }
    }

    private static abstract class C1254c extends C1195a<Status> {
        private C1254c() {
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4265d(status);
        }

        public Status m4265d(Status status) {
            return status;
        }
    }

    class C14061 extends C1252a {
        final /* synthetic */ kl ace;

        C14061(kl klVar) {
            this.ace = klVar;
            super();
        }

        protected void m4661a(C1138e c1138e) {
            c1138e.m3806k(this);
        }
    }

    public PendingResult<LoadMomentsResult> load(GoogleApiClient googleApiClient) {
        return googleApiClient.mo926a(new C14061(this));
    }

    public PendingResult<LoadMomentsResult> load(GoogleApiClient googleApiClient, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        final int i = maxResults;
        final String str = pageToken;
        final Uri uri = targetUrl;
        final String str2 = type;
        final String str3 = userId;
        return googleApiClient.mo926a(new C1252a(this) {
            final /* synthetic */ kl ace;

            protected void m4663a(C1138e c1138e) {
                c1138e.m3801a(this, i, str, uri, str2, str3);
            }
        });
    }

    public PendingResult<Status> remove(GoogleApiClient googleApiClient, final String momentId) {
        return googleApiClient.mo927b(new C1253b(this) {
            final /* synthetic */ kl ace;

            protected void m4667a(C1138e c1138e) {
                c1138e.removeMoment(momentId);
                m1984b(Status.En);
            }
        });
    }

    public PendingResult<Status> write(GoogleApiClient googleApiClient, final Moment moment) {
        return googleApiClient.mo927b(new C1254c(this) {
            final /* synthetic */ kl ace;

            protected void m4665a(C1138e c1138e) {
                c1138e.m3802a((C0152d) this, moment);
            }
        });
    }
}
