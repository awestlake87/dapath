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
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;

public final class InvitationsImpl implements Invitations {

    private static abstract class LoadInvitationsImpl extends BaseGamesApiMethodImpl<LoadInvitationsResult> {
        private LoadInvitationsImpl() {
        }

        public LoadInvitationsResult m4181F(final Status status) {
            return new LoadInvitationsResult(this) {
                final /* synthetic */ LoadInvitationsImpl PH;

                public InvitationBuffer getInvitations() {
                    return new InvitationBuffer(DataHolder.af(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4181F(status);
        }
    }

    class C13372 extends LoadInvitationsImpl {
        final /* synthetic */ int PE;
        final /* synthetic */ String Ph;

        protected void m4480a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3422e(this, this.Ph, this.PE);
        }
    }

    class C13383 extends LoadInvitationsImpl {
        final /* synthetic */ String PG;

        protected void m4482a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3448o(this, this.PG);
        }
    }

    public Intent getInvitationInboxIntent(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).hg();
    }

    public PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient) {
        return loadInvitations(apiClient, 0);
    }

    public PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient, final int sortOrder) {
        return apiClient.mo926a(new LoadInvitationsImpl(this) {
            final /* synthetic */ InvitationsImpl PF;

            protected void m4478a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3402c((C0152d) this, sortOrder);
            }
        });
    }

    public void registerInvitationListener(GoogleApiClient apiClient, OnInvitationReceivedListener listener) {
        Games.m472c(apiClient).m3378a(listener);
    }

    public void unregisterInvitationListener(GoogleApiClient apiClient) {
        Games.m472c(apiClient).hh();
    }
}
