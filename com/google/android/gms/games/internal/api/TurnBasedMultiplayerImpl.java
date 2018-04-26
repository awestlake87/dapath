package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import java.util.List;

public final class TurnBasedMultiplayerImpl implements TurnBasedMultiplayer {

    private static abstract class CancelMatchImpl extends BaseGamesApiMethodImpl<CancelMatchResult> {
        private final String xG;

        public CancelMatchImpl(String id) {
            this.xG = id;
        }

        public CancelMatchResult ad(final Status status) {
            return new CancelMatchResult(this) {
                final /* synthetic */ CancelMatchImpl Rc;

                public String getMatchId() {
                    return this.Rc.xG;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return ad(status);
        }
    }

    private static abstract class InitiateMatchImpl extends BaseGamesApiMethodImpl<InitiateMatchResult> {
        private InitiateMatchImpl() {
        }

        public InitiateMatchResult ae(final Status status) {
            return new InitiateMatchResult(this) {
                final /* synthetic */ InitiateMatchImpl Rd;

                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return ae(status);
        }
    }

    private static abstract class LeaveMatchImpl extends BaseGamesApiMethodImpl<LeaveMatchResult> {
        private LeaveMatchImpl() {
        }

        public LeaveMatchResult af(final Status status) {
            return new LeaveMatchResult(this) {
                final /* synthetic */ LeaveMatchImpl Re;

                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return af(status);
        }
    }

    private static abstract class LoadMatchImpl extends BaseGamesApiMethodImpl<LoadMatchResult> {
        private LoadMatchImpl() {
        }

        public LoadMatchResult ag(final Status status) {
            return new LoadMatchResult(this) {
                final /* synthetic */ LoadMatchImpl Rf;

                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return ag(status);
        }
    }

    private static abstract class LoadMatchesImpl extends BaseGamesApiMethodImpl<LoadMatchesResult> {
        private LoadMatchesImpl() {
        }

        public LoadMatchesResult ah(final Status status) {
            return new LoadMatchesResult(this) {
                final /* synthetic */ LoadMatchesImpl Rg;

                public LoadMatchesResponse getMatches() {
                    return new LoadMatchesResponse(new Bundle());
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return ah(status);
        }
    }

    private static abstract class UpdateMatchImpl extends BaseGamesApiMethodImpl<UpdateMatchResult> {
        private UpdateMatchImpl() {
        }

        public UpdateMatchResult ai(final Status status) {
            return new UpdateMatchResult(this) {
                final /* synthetic */ UpdateMatchImpl Rh;

                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return ai(status);
        }
    }

    class AnonymousClass11 extends InitiateMatchImpl {
        final /* synthetic */ String Ph;
        final /* synthetic */ String QW;

        protected void m4608a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3407c((C0152d) this, this.Ph, this.QW);
        }
    }

    class AnonymousClass12 extends InitiateMatchImpl {
        final /* synthetic */ String Ph;
        final /* synthetic */ String QW;

        protected void m4610a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3417d((C0152d) this, this.Ph, this.QW);
        }
    }

    class AnonymousClass13 extends LoadMatchesImpl {
        final /* synthetic */ String Ph;
        final /* synthetic */ int QX;
        final /* synthetic */ int[] QY;

        protected void m4612a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3357a((C0152d) this, this.Ph, this.QX, this.QY);
        }
    }

    public PendingResult<InitiateMatchResult> acceptInvitation(GoogleApiClient apiClient, final String invitationId) {
        return apiClient.mo927b(new InitiateMatchImpl(this) {
            final /* synthetic */ TurnBasedMultiplayerImpl QV;

            protected void m4618a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3421e((C0152d) this, invitationId);
            }
        });
    }

    public PendingResult<CancelMatchResult> cancelMatch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.mo927b(new CancelMatchImpl(this, matchId) {
            final /* synthetic */ TurnBasedMultiplayerImpl QV;

            protected void m4628a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3432g(this, matchId);
            }
        });
    }

    public PendingResult<InitiateMatchResult> createMatch(GoogleApiClient apiClient, final TurnBasedMatchConfig config) {
        return apiClient.mo927b(new InitiateMatchImpl(this) {
            final /* synthetic */ TurnBasedMultiplayerImpl QV;

            protected void m4614a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3349a((C0152d) this, config);
            }
        });
    }

    public void declineInvitation(GoogleApiClient apiClient, String invitationId) {
        Games.m472c(apiClient).m3447n(invitationId, 1);
    }

    public void dismissInvitation(GoogleApiClient apiClient, String invitationId) {
        Games.m472c(apiClient).m3445m(invitationId, 1);
    }

    public void dismissMatch(GoogleApiClient apiClient, String matchId) {
        Games.m472c(apiClient).aS(matchId);
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId) {
        return finishMatch(apiClient, matchId, null, (ParticipantResult[]) null);
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId, byte[] matchData, List<ParticipantResult> results) {
        return finishMatch(apiClient, matchId, matchData, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, final String matchId, final byte[] matchData, final ParticipantResult... results) {
        return apiClient.mo927b(new UpdateMatchImpl(this) {
            final /* synthetic */ TurnBasedMultiplayerImpl QV;

            protected void m4622a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3371a((C0152d) this, matchId, matchData, results);
            }
        });
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).hf();
    }

    public int getMaxMatchDataSize(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).hp();
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers) {
        return Games.m472c(apiClient).m3337a(minPlayers, maxPlayers, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers, boolean allowAutomatch) {
        return Games.m472c(apiClient).m3337a(minPlayers, maxPlayers, allowAutomatch);
    }

    public PendingResult<LeaveMatchResult> leaveMatch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.mo927b(new LeaveMatchImpl(this) {
            final /* synthetic */ TurnBasedMultiplayerImpl QV;

            protected void m4624a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3427f((C0152d) this, matchId);
            }
        });
    }

    public PendingResult<LeaveMatchResult> leaveMatchDuringTurn(GoogleApiClient apiClient, final String matchId, final String pendingParticipantId) {
        return apiClient.mo927b(new LeaveMatchImpl(this) {
            final /* synthetic */ TurnBasedMultiplayerImpl QV;

            protected void m4626a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3359a((C0152d) this, matchId, pendingParticipantId);
            }
        });
    }

    public PendingResult<LoadMatchResult> loadMatch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.mo926a(new LoadMatchImpl(this) {
            final /* synthetic */ TurnBasedMultiplayerImpl QV;

            protected void m4606a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3435h(this, matchId);
            }
        });
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, final int invitationSortOrder, final int[] matchTurnStatuses) {
        return apiClient.mo926a(new LoadMatchesImpl(this) {
            final /* synthetic */ TurnBasedMultiplayerImpl QV;

            protected void m4630a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3347a((C0152d) this, invitationSortOrder, matchTurnStatuses);
            }
        });
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, int[] matchTurnStatuses) {
        return loadMatchesByStatus(apiClient, 0, matchTurnStatuses);
    }

    public void registerMatchUpdateListener(GoogleApiClient apiClient, OnTurnBasedMatchUpdateReceivedListener listener) {
        Games.m472c(apiClient).m3381a(listener);
    }

    public PendingResult<InitiateMatchResult> rematch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.mo927b(new InitiateMatchImpl(this) {
            final /* synthetic */ TurnBasedMultiplayerImpl QV;

            protected void m4616a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3414d((C0152d) this, matchId);
            }
        });
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, (ParticipantResult[]) null);
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, List<ParticipantResult> results) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, ParticipantResult... results) {
        final String str = matchId;
        final byte[] bArr = matchData;
        final String str2 = pendingParticipantId;
        final ParticipantResult[] participantResultArr = results;
        return apiClient.mo927b(new UpdateMatchImpl(this) {
            final /* synthetic */ TurnBasedMultiplayerImpl QV;

            protected void m4620a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3370a((C0152d) this, str, bArr, str2, participantResultArr);
            }
        });
    }

    public void unregisterMatchUpdateListener(GoogleApiClient apiClient) {
        Games.m472c(apiClient).hi();
    }
}
