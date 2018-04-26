package com.google.android.gms.plus;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.internal.C0436i;
import com.google.android.gms.plus.internal.C1138e;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

@Deprecated
public class PlusClient implements GooglePlayServicesClient {
    final C1138e abt;

    @Deprecated
    public static class Builder {
        private final C0436i abA = new C0436i(this.mContext);
        private final ConnectionCallbacks aby;
        private final OnConnectionFailedListener abz;
        private final Context mContext;

        public Builder(Context context, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener connectionFailedListener) {
            this.mContext = context;
            this.aby = connectionCallbacks;
            this.abz = connectionFailedListener;
        }

        public PlusClient build() {
            return new PlusClient(new C1138e(this.mContext, this.aby, this.abz, this.abA.kj()));
        }

        public Builder clearScopes() {
            this.abA.ki();
            return this;
        }

        public Builder setAccountName(String accountName) {
            this.abA.bz(accountName);
            return this;
        }

        public Builder setActions(String... actions) {
            this.abA.m1583f(actions);
            return this;
        }

        public Builder setScopes(String... scopes) {
            this.abA.m1582e(scopes);
            return this;
        }
    }

    @Deprecated
    public interface OnAccessRevokedListener {
        void onAccessRevoked(ConnectionResult connectionResult);
    }

    @Deprecated
    public interface OnMomentsLoadedListener {
        @Deprecated
        void onMomentsLoaded(ConnectionResult connectionResult, MomentBuffer momentBuffer, String str, String str2);
    }

    @Deprecated
    public interface OnPeopleLoadedListener {
        void onPeopleLoaded(ConnectionResult connectionResult, PersonBuffer personBuffer, String str);
    }

    @Deprecated
    public interface OrderBy {
        @Deprecated
        public static final int ALPHABETICAL = 0;
        @Deprecated
        public static final int BEST = 1;
    }

    PlusClient(C1138e plusClientImpl) {
        this.abt = plusClientImpl;
    }

    @Deprecated
    public void clearDefaultAccount() {
        this.abt.clearDefaultAccount();
    }

    @Deprecated
    public void connect() {
        this.abt.connect();
    }

    @Deprecated
    public void disconnect() {
        this.abt.disconnect();
    }

    @Deprecated
    public String getAccountName() {
        return this.abt.getAccountName();
    }

    @Deprecated
    public Person getCurrentPerson() {
        return this.abt.getCurrentPerson();
    }

    @Deprecated
    public boolean isConnected() {
        return this.abt.isConnected();
    }

    @Deprecated
    public boolean isConnecting() {
        return this.abt.isConnecting();
    }

    @Deprecated
    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.abt.isConnectionCallbacksRegistered(listener);
    }

    @Deprecated
    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.abt.isConnectionFailedListenerRegistered(listener);
    }

    C1138e jS() {
        return this.abt;
    }

    @Deprecated
    public void loadMoments(final OnMomentsLoadedListener listener) {
        this.abt.m3806k(new C0152d<LoadMomentsResult>(this) {
            final /* synthetic */ PlusClient abv;

            public void m2890a(LoadMomentsResult loadMomentsResult) {
                listener.onMomentsLoaded(loadMomentsResult.getStatus().eR(), loadMomentsResult.getMomentBuffer(), loadMomentsResult.getNextPageToken(), loadMomentsResult.getUpdated());
            }
        });
    }

    @Deprecated
    public void loadMoments(final OnMomentsLoadedListener listener, int maxResults, String pageToken, Uri targetUrl, String type, String userId) {
        this.abt.m3801a(new C0152d<LoadMomentsResult>(this) {
            final /* synthetic */ PlusClient abv;

            public void m2892a(LoadMomentsResult loadMomentsResult) {
                listener.onMomentsLoaded(loadMomentsResult.getStatus().eR(), loadMomentsResult.getMomentBuffer(), loadMomentsResult.getNextPageToken(), loadMomentsResult.getUpdated());
            }
        }, maxResults, pageToken, targetUrl, type, userId);
    }

    @Deprecated
    public void loadPeople(final OnPeopleLoadedListener listener, Collection<String> personIds) {
        this.abt.m3803a(new C0152d<LoadPeopleResult>(this) {
            final /* synthetic */ PlusClient abv;

            public void m2898a(LoadPeopleResult loadPeopleResult) {
                listener.onPeopleLoaded(loadPeopleResult.getStatus().eR(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
            }
        }, (Collection) personIds);
    }

    @Deprecated
    public void loadPeople(final OnPeopleLoadedListener listener, String... personIds) {
        this.abt.m3805d(new C0152d<LoadPeopleResult>(this) {
            final /* synthetic */ PlusClient abv;

            public void m2900a(LoadPeopleResult loadPeopleResult) {
                listener.onPeopleLoaded(loadPeopleResult.getStatus().eR(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
            }
        }, personIds);
    }

    @Deprecated
    public void loadVisiblePeople(final OnPeopleLoadedListener listener, int orderBy, String pageToken) {
        this.abt.m3799a(new C0152d<LoadPeopleResult>(this) {
            final /* synthetic */ PlusClient abv;

            public void m2894a(LoadPeopleResult loadPeopleResult) {
                listener.onPeopleLoaded(loadPeopleResult.getStatus().eR(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
            }
        }, orderBy, pageToken);
    }

    @Deprecated
    public void loadVisiblePeople(final OnPeopleLoadedListener listener, String pageToken) {
        this.abt.m3809r(new C0152d<LoadPeopleResult>(this) {
            final /* synthetic */ PlusClient abv;

            public void m2896a(LoadPeopleResult loadPeopleResult) {
                listener.onPeopleLoaded(loadPeopleResult.getStatus().eR(), loadPeopleResult.getPersonBuffer(), loadPeopleResult.getNextPageToken());
            }
        }, pageToken);
    }

    @Deprecated
    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.abt.registerConnectionCallbacks(listener);
    }

    @Deprecated
    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.abt.registerConnectionFailedListener(listener);
    }

    @Deprecated
    public void removeMoment(String momentId) {
        this.abt.removeMoment(momentId);
    }

    @Deprecated
    public void revokeAccessAndDisconnect(final OnAccessRevokedListener listener) {
        this.abt.m3808m(new C0152d<Status>(this) {
            final /* synthetic */ PlusClient abv;

            public /* synthetic */ void mo911a(Object obj) {
                al((Status) obj);
            }

            public void al(Status status) {
                listener.onAccessRevoked(status.getStatus().eR());
            }
        });
    }

    @Deprecated
    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.abt.unregisterConnectionCallbacks(listener);
    }

    @Deprecated
    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.abt.unregisterConnectionFailedListener(listener);
    }

    @Deprecated
    public void writeMoment(Moment moment) {
        this.abt.m3802a(null, moment);
    }
}
