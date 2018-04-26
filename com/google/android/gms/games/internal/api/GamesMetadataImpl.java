package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesMetadata.LoadExtendedGamesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class GamesMetadataImpl implements GamesMetadata {

    private static abstract class LoadExtendedGamesImpl extends BaseGamesApiMethodImpl<LoadExtendedGamesResult> {
        private LoadExtendedGamesImpl() {
        }

        public LoadExtendedGamesResult m4173B(final Status status) {
            return new LoadExtendedGamesResult(this) {
                final /* synthetic */ LoadExtendedGamesImpl PA;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4173B(status);
        }
    }

    private static abstract class LoadGameInstancesImpl extends BaseGamesApiMethodImpl<LoadGameInstancesResult> {
        private LoadGameInstancesImpl() {
        }

        public LoadGameInstancesResult m4175C(final Status status) {
            return new LoadGameInstancesResult(this) {
                final /* synthetic */ LoadGameInstancesImpl PB;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4175C(status);
        }
    }

    private static abstract class LoadGameSearchSuggestionsImpl extends BaseGamesApiMethodImpl<LoadGameSearchSuggestionsResult> {
        private LoadGameSearchSuggestionsImpl() {
        }

        public LoadGameSearchSuggestionsResult m4177D(final Status status) {
            return new LoadGameSearchSuggestionsResult(this) {
                final /* synthetic */ LoadGameSearchSuggestionsImpl PC;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4177D(status);
        }
    }

    private static abstract class LoadGamesImpl extends BaseGamesApiMethodImpl<LoadGamesResult> {
        private LoadGamesImpl() {
        }

        public LoadGamesResult m4179E(final Status status) {
            return new LoadGamesResult(this) {
                final /* synthetic */ LoadGamesImpl PD;

                public GameBuffer getGames() {
                    return new GameBuffer(DataHolder.af(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4179E(status);
        }
    }

    class AnonymousClass10 extends LoadExtendedGamesImpl {
        final /* synthetic */ String Pu;
        final /* synthetic */ int Pv;
        final /* synthetic */ boolean Pw;

        protected void m4440a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3356a((C0152d) this, this.Pu, this.Pv, false, true, false, this.Pw);
        }
    }

    class AnonymousClass11 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Pg;
        final /* synthetic */ int Pv;

        protected void m4442a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3406c(this, this.Pg, this.Pv, false, this.Pe);
        }
    }

    class AnonymousClass12 extends LoadExtendedGamesImpl {
        final /* synthetic */ String Pg;
        final /* synthetic */ int Pv;

        protected void m4444a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3406c(this, this.Pg, this.Pv, true, false);
        }
    }

    class AnonymousClass13 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Pg;
        final /* synthetic */ int Pv;

        protected void m4446a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3416d(this, this.Pg, this.Pv, false, this.Pe);
        }
    }

    class AnonymousClass14 extends LoadExtendedGamesImpl {
        final /* synthetic */ String Pg;
        final /* synthetic */ int Pv;

        protected void m4448a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3416d(this, this.Pg, this.Pv, true, false);
        }
    }

    class AnonymousClass15 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Pu;
        final /* synthetic */ int Pv;
        final /* synthetic */ boolean Pw;

        protected void m4450a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3356a((C0152d) this, this.Pu, this.Pv, true, false, this.Pe, this.Pw);
        }
    }

    class AnonymousClass16 extends LoadExtendedGamesImpl {
        final /* synthetic */ String Pu;
        final /* synthetic */ int Pv;
        final /* synthetic */ boolean Pw;

        protected void m4452a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3356a((C0152d) this, this.Pu, this.Pv, true, true, false, this.Pw);
        }
    }

    class AnonymousClass17 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;
        final /* synthetic */ String Px;

        protected void m4454a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3423e(this, this.Px, this.Pv, false, this.Pe);
        }
    }

    class AnonymousClass18 extends LoadExtendedGamesImpl {
        final /* synthetic */ int Pv;
        final /* synthetic */ String Px;

        protected void m4456a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3423e(this, this.Px, this.Pv, true, false);
        }
    }

    class AnonymousClass19 extends LoadGameSearchSuggestionsImpl {
        final /* synthetic */ String Px;

        protected void m4458a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3444m((C0152d) this, this.Px);
        }
    }

    class C13271 extends LoadGamesImpl {
        final /* synthetic */ GamesMetadataImpl Pt;

        C13271(GamesMetadataImpl gamesMetadataImpl) {
            this.Pt = gamesMetadataImpl;
            super();
        }

        protected void m4460a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3426f((C0152d) this);
        }
    }

    class C13282 extends LoadExtendedGamesImpl {
        final /* synthetic */ String Ph;

        protected void m4462a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3440k(this, this.Ph);
        }
    }

    class C13293 extends LoadGameInstancesImpl {
        final /* synthetic */ String Ph;

        protected void m4464a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3442l((C0152d) this, this.Ph);
        }
    }

    class C13304 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;

        protected void m4466a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3392b(this, null, this.Pv, false, this.Pe);
        }
    }

    class C13315 extends LoadExtendedGamesImpl {
        final /* synthetic */ int Pv;

        protected void m4468a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3392b(this, null, this.Pv, true, false);
        }
    }

    class C13326 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Pg;
        final /* synthetic */ int Pv;

        protected void m4470a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3392b(this, this.Pg, this.Pv, false, this.Pe);
        }
    }

    class C13337 extends LoadExtendedGamesImpl {
        final /* synthetic */ String Pg;
        final /* synthetic */ int Pv;

        protected void m4472a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3392b(this, this.Pg, this.Pv, true, false);
        }
    }

    class C13348 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ int Pv;
        final /* synthetic */ int Py;
        final /* synthetic */ boolean Pz;

        protected void m4474a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3345a((C0152d) this, this.Pv, this.Py, this.Pz, this.Pe);
        }
    }

    class C13359 extends LoadExtendedGamesImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Pu;
        final /* synthetic */ int Pv;
        final /* synthetic */ boolean Pw;

        protected void m4476a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3356a((C0152d) this, this.Pu, this.Pv, false, false, this.Pe, this.Pw);
        }
    }

    public Game getCurrentGame(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).hc();
    }

    public PendingResult<LoadGamesResult> loadGame(GoogleApiClient apiClient) {
        return apiClient.mo926a(new C13271(this));
    }
}
