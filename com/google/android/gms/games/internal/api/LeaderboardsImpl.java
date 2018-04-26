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
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

public final class LeaderboardsImpl implements Leaderboards {

    private static abstract class LoadMetadataImpl extends BaseGamesApiMethodImpl<LeaderboardMetadataResult> {
        private LoadMetadataImpl() {
        }

        public LeaderboardMetadataResult m4183G(final Status status) {
            return new LeaderboardMetadataResult(this) {
                final /* synthetic */ LoadMetadataImpl PR;

                public LeaderboardBuffer getLeaderboards() {
                    return new LeaderboardBuffer(DataHolder.af(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4183G(status);
        }
    }

    private static abstract class LoadPlayerScoreImpl extends BaseGamesApiMethodImpl<LoadPlayerScoreResult> {
        private LoadPlayerScoreImpl() {
        }

        public LoadPlayerScoreResult m4185H(final Status status) {
            return new LoadPlayerScoreResult(this) {
                final /* synthetic */ LoadPlayerScoreImpl PS;

                public LeaderboardScore getScore() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4185H(status);
        }
    }

    private static abstract class LoadScoresImpl extends BaseGamesApiMethodImpl<LoadScoresResult> {
        private LoadScoresImpl() {
        }

        public LoadScoresResult m4187I(final Status status) {
            return new LoadScoresResult(this) {
                final /* synthetic */ LoadScoresImpl PT;

                public Leaderboard getLeaderboard() {
                    return null;
                }

                public LeaderboardScoreBuffer getScores() {
                    return new LeaderboardScoreBuffer(DataHolder.af(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4187I(status);
        }
    }

    protected static abstract class SubmitScoreImpl extends BaseGamesApiMethodImpl<SubmitScoreResult> {
        protected SubmitScoreImpl() {
        }

        public SubmitScoreResult m4189J(final Status status) {
            return new SubmitScoreResult(this) {
                final /* synthetic */ SubmitScoreImpl PU;

                public ScoreSubmissionData getScoreData() {
                    return new ScoreSubmissionData(DataHolder.af(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4189J(status);
        }
    }

    class AnonymousClass10 extends LoadScoresImpl {
        final /* synthetic */ String PJ;
        final /* synthetic */ int PK;
        final /* synthetic */ int PL;
        final /* synthetic */ int PM;
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Ph;

        protected void m4484a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3362a((C0152d) this, this.Ph, this.PJ, this.PK, this.PL, this.PM, this.Pe);
        }
    }

    class AnonymousClass11 extends LoadScoresImpl {
        final /* synthetic */ String PJ;
        final /* synthetic */ int PK;
        final /* synthetic */ int PL;
        final /* synthetic */ int PM;
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Ph;

        protected void m4486a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3394b(this, this.Ph, this.PJ, this.PK, this.PL, this.PM, this.Pe);
        }
    }

    class C13468 extends LoadMetadataImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Ph;

        protected void m4502a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3409c((C0152d) this, this.Ph, this.Pe);
        }
    }

    class C13479 extends LoadMetadataImpl {
        final /* synthetic */ String PJ;
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Ph;

        protected void m4504a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3365a((C0152d) this, this.Ph, this.PJ, this.Pe);
        }
    }

    public Intent getAllLeaderboardsIntent(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).hd();
    }

    public Intent getLeaderboardIntent(GoogleApiClient apiClient, String leaderboardId) {
        return Games.m472c(apiClient).aR(leaderboardId);
    }

    public PendingResult<LoadPlayerScoreResult> loadCurrentPlayerLeaderboardScore(GoogleApiClient apiClient, final String leaderboardId, final int span, final int leaderboardCollection) {
        return apiClient.mo926a(new LoadPlayerScoreImpl(this) {
            final /* synthetic */ LeaderboardsImpl PI;

            protected void m4492a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3360a((C0152d) this, null, leaderboardId, span, leaderboardCollection);
            }
        });
    }

    public PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient apiClient, final String leaderboardId, final boolean forceReload) {
        return apiClient.mo926a(new LoadMetadataImpl(this) {
            final /* synthetic */ LeaderboardsImpl PI;

            protected void m4490a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3369a((C0152d) this, leaderboardId, forceReload);
            }
        });
    }

    public PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.mo926a(new LoadMetadataImpl(this) {
            final /* synthetic */ LeaderboardsImpl PI;

            protected void m4488a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3397b((C0152d) this, forceReload);
            }
        });
    }

    public PendingResult<LoadScoresResult> loadMoreScores(GoogleApiClient apiClient, final LeaderboardScoreBuffer buffer, final int maxResults, final int pageDirection) {
        return apiClient.mo926a(new LoadScoresImpl(this) {
            final /* synthetic */ LeaderboardsImpl PI;

            protected void m4498a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3348a((C0152d) this, buffer, maxResults, pageDirection);
            }
        });
    }

    public PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadPlayerCenteredScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        final String str = leaderboardId;
        final int i = span;
        final int i2 = leaderboardCollection;
        final int i3 = maxResults;
        final boolean z = forceReload;
        return apiClient.mo926a(new LoadScoresImpl(this) {
            final /* synthetic */ LeaderboardsImpl PI;

            protected void m4496a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3391b(this, str, i, i2, i3, z);
            }
        });
    }

    public PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadTopScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        final String str = leaderboardId;
        final int i = span;
        final int i2 = leaderboardCollection;
        final int i3 = maxResults;
        final boolean z = forceReload;
        return apiClient.mo926a(new LoadScoresImpl(this) {
            final /* synthetic */ LeaderboardsImpl PI;

            protected void m4494a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3353a((C0152d) this, str, i, i2, i3, z);
            }
        });
    }

    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score) {
        submitScore(apiClient, leaderboardId, score, null);
    }

    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        Games.m472c(apiClient).m3358a(null, leaderboardId, score, scoreTag);
    }

    public PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score) {
        return submitScoreImmediate(apiClient, leaderboardId, score, null);
    }

    public PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        final String str = leaderboardId;
        final long j = score;
        final String str2 = scoreTag;
        return apiClient.mo927b(new SubmitScoreImpl(this) {
            final /* synthetic */ LeaderboardsImpl PI;

            protected void m4500a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3358a((C0152d) this, str, j, str2);
            }
        });
    }
}
