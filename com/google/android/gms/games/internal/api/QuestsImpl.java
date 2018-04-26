package com.google.android.gms.games.internal.api;

import android.content.Intent;
import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;

public final class QuestsImpl implements Quests {

    private static abstract class AcceptImpl extends BaseGamesApiMethodImpl<AcceptQuestResult> {
        private AcceptImpl() {
        }

        public AcceptQuestResult m4217S(final Status status) {
            return new AcceptQuestResult(this) {
                final /* synthetic */ AcceptImpl Qt;

                public Quest getQuest() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4217S(status);
        }
    }

    private static abstract class ClaimImpl extends BaseGamesApiMethodImpl<ClaimMilestoneResult> {
        private ClaimImpl() {
        }

        public ClaimMilestoneResult m4219T(final Status status) {
            return new ClaimMilestoneResult(this) {
                final /* synthetic */ ClaimImpl Qu;

                public Milestone getMilestone() {
                    return null;
                }

                public Quest getQuest() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4219T(status);
        }
    }

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadQuestsResult> {
        private LoadsImpl() {
        }

        public LoadQuestsResult m4221U(final Status status) {
            return new LoadQuestsResult(this) {
                final /* synthetic */ LoadsImpl Qv;

                public QuestBuffer getQuests() {
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
            return m4221U(status);
        }
    }

    class C13655 extends LoadsImpl {
        final /* synthetic */ int PE;
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Ph;
        final /* synthetic */ int[] Qq;
        final /* synthetic */ String Qs;

        protected void m4574a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3367a((C0152d) this, this.Ph, this.Qs, this.Qq, this.PE, this.Pe);
        }
    }

    class C13666 extends LoadsImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Ph;
        final /* synthetic */ String[] Qr;
        final /* synthetic */ String Qs;

        protected void m4576a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3366a((C0152d) this, this.Ph, this.Qs, this.Pe, this.Qr);
        }
    }

    public PendingResult<AcceptQuestResult> accept(GoogleApiClient apiClient, final String questId) {
        return apiClient.mo927b(new AcceptImpl(this) {
            final /* synthetic */ QuestsImpl Qo;

            protected void m4566a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3437i(this, questId);
            }
        });
    }

    public PendingResult<ClaimMilestoneResult> claim(GoogleApiClient apiClient, final String questId, final String milestoneId) {
        return apiClient.mo927b(new ClaimImpl(this) {
            final /* synthetic */ QuestsImpl Qo;

            protected void m4568a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3393b((C0152d) this, questId, milestoneId);
            }
        });
    }

    public Intent getQuestIntent(GoogleApiClient apiClient, String questId) {
        return Games.m472c(apiClient).aU(questId);
    }

    public Intent getQuestsIntent(GoogleApiClient apiClient, int[] questSelectors) {
        return Games.m472c(apiClient).m3341a(questSelectors);
    }

    public PendingResult<LoadQuestsResult> load(GoogleApiClient apiClient, final int[] questSelectors, final int sortOrder, final boolean forceReload) {
        return apiClient.mo926a(new LoadsImpl(this) {
            final /* synthetic */ QuestsImpl Qo;

            protected void m4570a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3376a((C0152d) this, questSelectors, sortOrder, forceReload);
            }
        });
    }

    public PendingResult<LoadQuestsResult> loadByIds(GoogleApiClient apiClient, final boolean forceReload, final String... questIds) {
        return apiClient.mo926a(new LoadsImpl(this) {
            final /* synthetic */ QuestsImpl Qo;

            protected void m4572a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3398b((C0152d) this, forceReload, questIds);
            }
        });
    }

    public void registerQuestUpdateListener(GoogleApiClient apiClient, QuestUpdateListener listener) {
        Games.m472c(apiClient).m3382a(listener);
    }

    public void unregisterQuestUpdateListener(GoogleApiClient apiClient) {
        Games.m472c(apiClient).hj();
    }
}
