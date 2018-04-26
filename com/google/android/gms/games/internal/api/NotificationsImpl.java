package com.google.android.gms.games.internal.api;

import android.os.Bundle;
import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class NotificationsImpl implements Notifications {

    class C12331 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String PV;

        public GameMuteStatusChangeResult m4191K(final Status status) {
            return new GameMuteStatusChangeResult(this) {
                final /* synthetic */ C12331 PW;

                public Status getStatus() {
                    return status;
                }
            };
        }

        protected void m4193a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3418d((C0152d) this, this.PV, true);
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4191K(status);
        }
    }

    class C12342 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String PV;

        public GameMuteStatusChangeResult m4195K(final Status status) {
            return new GameMuteStatusChangeResult(this) {
                final /* synthetic */ C12342 PX;

                public Status getStatus() {
                    return status;
                }
            };
        }

        protected void m4197a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3418d((C0152d) this, this.PV, false);
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4195K(status);
        }
    }

    class C12353 extends BaseGamesApiMethodImpl<GameMuteStatusLoadResult> {
        final /* synthetic */ String PV;

        public GameMuteStatusLoadResult m4199L(final Status status) {
            return new GameMuteStatusLoadResult(this) {
                final /* synthetic */ C12353 PY;

                public Status getStatus() {
                    return status;
                }
            };
        }

        protected void m4201a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3450q(this, this.PV);
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4199L(status);
        }
    }

    private static abstract class ContactSettingLoadImpl extends BaseGamesApiMethodImpl<ContactSettingLoadResult> {
        private ContactSettingLoadImpl() {
        }

        public ContactSettingLoadResult m4203M(final Status status) {
            return new ContactSettingLoadResult(this) {
                final /* synthetic */ ContactSettingLoadImpl Qb;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4203M(status);
        }
    }

    private static abstract class ContactSettingUpdateImpl extends BaseGamesApiMethodImpl<Status> {
        private ContactSettingUpdateImpl() {
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4206d(status);
        }

        public Status m4206d(Status status) {
            return status;
        }
    }

    private static abstract class InboxCountImpl extends BaseGamesApiMethodImpl<InboxCountResult> {
        private InboxCountImpl() {
        }

        public InboxCountResult m4207N(final Status status) {
            return new InboxCountResult(this) {
                final /* synthetic */ InboxCountImpl Qc;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4207N(status);
        }
    }

    class C13484 extends ContactSettingLoadImpl {
        protected void m4506a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3436i(this);
        }
    }

    class C13495 extends ContactSettingLoadImpl {
        final /* synthetic */ boolean Pe;

        protected void m4508a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3430f((C0152d) this, this.Pe);
        }
    }

    class C13506 extends ContactSettingUpdateImpl {
        final /* synthetic */ boolean PZ;
        final /* synthetic */ Bundle Qa;

        protected void m4510a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3374a((C0152d) this, this.PZ, this.Qa);
        }
    }

    class C13517 extends InboxCountImpl {
        protected void m4512a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3438j(this);
        }
    }

    public void clear(GoogleApiClient apiClient, int notificationTypes) {
        Games.m472c(apiClient).ch(notificationTypes);
    }

    public void clearAll(GoogleApiClient apiClient) {
        clear(apiClient, 31);
    }
}
