package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadOwnerCoverPhotoUrisResult;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpForGamesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class PlayersImpl implements Players {

    private static abstract class LoadOwnerCoverPhotoUrisImpl extends BaseGamesApiMethodImpl<LoadOwnerCoverPhotoUrisResult> {
        private LoadOwnerCoverPhotoUrisImpl() {
        }

        public LoadOwnerCoverPhotoUrisResult m4209O(final Status status) {
            return new LoadOwnerCoverPhotoUrisResult(this) {
                final /* synthetic */ LoadOwnerCoverPhotoUrisImpl Qj;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4209O(status);
        }
    }

    private static abstract class LoadPlayersImpl extends BaseGamesApiMethodImpl<LoadPlayersResult> {
        private LoadPlayersImpl() {
        }

        public LoadPlayersResult m4211P(final Status status) {
            return new LoadPlayersResult(this) {
                final /* synthetic */ LoadPlayersImpl Qk;

                public PlayerBuffer getPlayers() {
                    return new PlayerBuffer(DataHolder.af(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4211P(status);
        }
    }

    private static abstract class LoadXpForGameCategoriesResultImpl extends BaseGamesApiMethodImpl<LoadXpForGameCategoriesResult> {
        private LoadXpForGameCategoriesResultImpl() {
        }

        public LoadXpForGameCategoriesResult m4213Q(final Status status) {
            return new LoadXpForGameCategoriesResult(this) {
                final /* synthetic */ LoadXpForGameCategoriesResultImpl Ql;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4213Q(status);
        }
    }

    private static abstract class LoadXpForGameResultImpl extends BaseGamesApiMethodImpl<LoadXpForGamesResult> {

        class C10531 implements LoadXpForGamesResult {
            final /* synthetic */ Status yJ;

            public Status getStatus() {
                return this.yJ;
            }
        }

        private LoadXpForGameResultImpl() {
        }
    }

    private static abstract class LoadXpStreamResultImpl extends BaseGamesApiMethodImpl<LoadXpStreamResult> {
        private LoadXpStreamResultImpl() {
        }

        public LoadXpStreamResult m4215R(final Status status) {
            return new LoadXpStreamResult(this) {
                final /* synthetic */ LoadXpStreamResultImpl Qm;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4215R(status);
        }
    }

    class AnonymousClass10 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;

        protected void m4514a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3388b((C0152d) this, this.Pv, false, this.Pe);
        }
    }

    class AnonymousClass11 extends LoadPlayersImpl {
        final /* synthetic */ int Pv;

        protected void m4516a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3388b((C0152d) this, this.Pv, true, false);
        }
    }

    class AnonymousClass12 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;

        protected void m4518a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3403c((C0152d) this, this.Pv, false, this.Pe);
        }
    }

    class AnonymousClass13 extends LoadPlayersImpl {
        final /* synthetic */ int Pv;

        protected void m4520a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3403c((C0152d) this, this.Pv, true, false);
        }
    }

    class AnonymousClass14 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;

        protected void m4522a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3413d(this, this.Pv, false, this.Pe);
        }
    }

    class AnonymousClass15 extends LoadPlayersImpl {
        final /* synthetic */ int Pv;

        protected void m4524a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3413d(this, this.Pv, true, false);
        }
    }

    class AnonymousClass16 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;
        final /* synthetic */ String Px;

        protected void m4526a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3429f(this, this.Px, this.Pv, false, this.Pe);
        }
    }

    class AnonymousClass17 extends LoadPlayersImpl {
        final /* synthetic */ int Pv;
        final /* synthetic */ String Px;

        protected void m4528a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3429f(this, this.Px, this.Pv, true, false);
        }
    }

    class AnonymousClass18 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Ph;
        final /* synthetic */ int Qe;

        protected void m4530a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3354a((C0152d) this, this.Ph, this.Qe, this.Pe);
        }
    }

    class AnonymousClass19 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;

        protected void m4532a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3420e(this, this.Pv, false, this.Pe);
        }
    }

    class AnonymousClass20 extends LoadPlayersImpl {
        final /* synthetic */ int Pv;

        protected void m4536a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3420e(this, this.Pv, true, false);
        }
    }

    class AnonymousClass21 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;
        final /* synthetic */ String Qg;

        protected void m4538a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3433g(this, this.Qg, this.Pv, false, this.Pe);
        }
    }

    class AnonymousClass22 extends LoadPlayersImpl {
        final /* synthetic */ int Pv;
        final /* synthetic */ String Qg;

        protected void m4540a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3433g(this, this.Qg, this.Pv, true, false);
        }
    }

    class AnonymousClass23 extends LoadOwnerCoverPhotoUrisImpl {
        protected void m4542a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3431g(this);
        }
    }

    class AnonymousClass24 extends LoadXpForGameCategoriesResultImpl {
        final /* synthetic */ String Qh;

        protected void m4544a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3446n((C0152d) this, this.Qh);
        }
    }

    class AnonymousClass25 extends LoadXpStreamResultImpl {
        final /* synthetic */ String Qh;
        final /* synthetic */ int Qi;

        protected void m4546a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3405c((C0152d) this, this.Qh, this.Qi);
        }
    }

    class AnonymousClass26 extends LoadXpStreamResultImpl {
        final /* synthetic */ String Qh;
        final /* synthetic */ int Qi;

        protected void m4548a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3415d((C0152d) this, this.Qh, this.Qi);
        }
    }

    class C13532 extends LoadPlayersImpl {
        final /* synthetic */ String[] Qf;

        protected void m4550a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3377a((C0152d) this, this.Qf);
        }
    }

    class C13587 extends LoadPlayersImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Ph;
        final /* synthetic */ int Pv;

        protected void m4560a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3363a((C0152d) this, "played_with", this.Ph, this.Pv, false, this.Pe);
        }
    }

    class C13598 extends LoadPlayersImpl {
        final /* synthetic */ String Ph;
        final /* synthetic */ int Pv;

        protected void m4562a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3363a((C0152d) this, "played_with", this.Ph, this.Pv, true, false);
        }
    }

    public Player getCurrentPlayer(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).hb();
    }

    public String getCurrentPlayerId(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).ha();
    }

    public Intent getPlayerSearchIntent(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).hl();
    }

    public PendingResult<LoadPlayersResult> loadConnectedPlayers(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.mo926a(new LoadPlayersImpl(this) {
            final /* synthetic */ PlayersImpl Qd;

            protected void m4564a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3373a((C0152d) this, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadInvitablePlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.mo926a(new LoadPlayersImpl(this) {
            final /* synthetic */ PlayersImpl Qd;

            protected void m4552a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3346a((C0152d) this, pageSize, false, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.mo926a(new LoadPlayersImpl(this) {
            final /* synthetic */ PlayersImpl Qd;

            protected void m4554a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3346a((C0152d) this, pageSize, true, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.mo926a(new LoadPlayersImpl(this) {
            final /* synthetic */ PlayersImpl Qd;

            protected void m4558a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3355a((C0152d) this, "played_with", pageSize, true, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, final String playerId) {
        return apiClient.mo926a(new LoadPlayersImpl(this) {
            final /* synthetic */ PlayersImpl Qd;

            protected void m4534a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3351a((C0152d) this, playerId);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.mo926a(new LoadPlayersImpl(this) {
            final /* synthetic */ PlayersImpl Qd;

            protected void m4556a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3355a((C0152d) this, "played_with", pageSize, false, forceReload);
            }
        });
    }
}
