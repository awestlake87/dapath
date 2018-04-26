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
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AchievementsImpl implements Achievements {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadAchievementsResult> {
        private LoadImpl() {
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4162v(status);
        }

        public LoadAchievementsResult m4162v(final Status status) {
            return new LoadAchievementsResult(this) {
                final /* synthetic */ LoadImpl Pk;

                public AchievementBuffer getAchievements() {
                    return new AchievementBuffer(DataHolder.af(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<UpdateAchievementResult> {
        private final String xG;

        public UpdateImpl(String id) {
            this.xG = id;
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4165w(status);
        }

        public UpdateAchievementResult m4165w(final Status status) {
            return new UpdateAchievementResult(this) {
                final /* synthetic */ UpdateImpl Pl;

                public String getAchievementId() {
                    return this.Pl.xG;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    class AnonymousClass10 extends LoadImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Pg;
        final /* synthetic */ String Ph;

        public void m4410a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3395b((C0152d) this, this.Pg, this.Ph, this.Pe);
        }
    }

    public Intent getAchievementsIntent(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).he();
    }

    public void increment(GoogleApiClient apiClient, final String id, final int numSteps) {
        apiClient.mo927b(new UpdateImpl(this, id) {
            final /* synthetic */ AchievementsImpl Pf;

            public void m4422a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3352a(null, id, numSteps);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> incrementImmediate(GoogleApiClient apiClient, final String id, final int numSteps) {
        return apiClient.mo927b(new UpdateImpl(this, id) {
            final /* synthetic */ AchievementsImpl Pf;

            public void m4424a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3352a((C0152d) this, id, numSteps);
            }
        });
    }

    public PendingResult<LoadAchievementsResult> load(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.mo926a(new LoadImpl(this) {
            final /* synthetic */ AchievementsImpl Pf;

            public void m4412a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3410c((C0152d) this, forceReload);
            }
        });
    }

    public void reveal(GoogleApiClient apiClient, final String id) {
        apiClient.mo927b(new UpdateImpl(this, id) {
            final /* synthetic */ AchievementsImpl Pf;

            public void m4414a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3389b(null, id);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> revealImmediate(GoogleApiClient apiClient, final String id) {
        return apiClient.mo927b(new UpdateImpl(this, id) {
            final /* synthetic */ AchievementsImpl Pf;

            public void m4416a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3389b((C0152d) this, id);
            }
        });
    }

    public void setSteps(GoogleApiClient apiClient, final String id, final int numSteps) {
        apiClient.mo927b(new UpdateImpl(this, id) {
            final /* synthetic */ AchievementsImpl Pf;

            public void m4426a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3390b(null, id, numSteps);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> setStepsImmediate(GoogleApiClient apiClient, final String id, final int numSteps) {
        return apiClient.mo927b(new UpdateImpl(this, id) {
            final /* synthetic */ AchievementsImpl Pf;

            public void m4428a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3390b((C0152d) this, id, numSteps);
            }
        });
    }

    public void unlock(GoogleApiClient apiClient, final String id) {
        apiClient.mo927b(new UpdateImpl(this, id) {
            final /* synthetic */ AchievementsImpl Pf;

            public void m4418a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3404c(null, id);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> unlockImmediate(GoogleApiClient apiClient, final String id) {
        return apiClient.mo927b(new UpdateImpl(this, id) {
            final /* synthetic */ AchievementsImpl Pf;

            public void m4420a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3404c((C0152d) this, id);
            }
        });
    }
}
