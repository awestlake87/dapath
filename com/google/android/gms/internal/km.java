package com.google.android.gms.internal;

import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.Plus.C1195a;
import com.google.android.gms.plus.internal.C1138e;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public final class km implements People {

    private static abstract class C1255a extends C1195a<LoadPeopleResult> {
        private C1255a() {
        }

        public LoadPeopleResult ao(final Status status) {
            return new LoadPeopleResult(this) {
                final /* synthetic */ C1255a acq;

                public String getNextPageToken() {
                    return null;
                }

                public PersonBuffer getPersonBuffer() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return ao(status);
        }
    }

    class C14123 extends C1255a {
        final /* synthetic */ km acn;

        C14123(km kmVar) {
            this.acn = kmVar;
            super();
        }

        protected void m4673a(C1138e c1138e) {
            c1138e.m3807l(this);
        }
    }

    public Person getCurrentPerson(GoogleApiClient googleApiClient) {
        return Plus.m1550a(googleApiClient, Plus.yH).getCurrentPerson();
    }

    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, final Collection<String> personIds) {
        return googleApiClient.mo926a(new C1255a(this) {
            final /* synthetic */ km acn;

            protected void m4675a(C1138e c1138e) {
                c1138e.m3803a((C0152d) this, personIds);
            }
        });
    }

    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, final String... personIds) {
        return googleApiClient.mo926a(new C1255a(this) {
            final /* synthetic */ km acn;

            protected void m4677a(C1138e c1138e) {
                c1138e.m3805d(this, personIds);
            }
        });
    }

    public PendingResult<LoadPeopleResult> loadConnected(GoogleApiClient googleApiClient) {
        return googleApiClient.mo926a(new C14123(this));
    }

    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, final int orderBy, final String pageToken) {
        return googleApiClient.mo926a(new C1255a(this) {
            final /* synthetic */ km acn;

            protected void m4669a(C1138e c1138e) {
                m1982a(c1138e.m3799a((C0152d) this, orderBy, pageToken));
            }
        });
    }

    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, final String pageToken) {
        return googleApiClient.mo926a(new C1255a(this) {
            final /* synthetic */ km acn;

            protected void m4671a(C1138e c1138e) {
                m1982a(c1138e.m3809r(this, pageToken));
            }
        });
    }
}
