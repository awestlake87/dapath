package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class EventsImpl implements Events {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadEventsResult> {
        private LoadImpl() {
        }

        public LoadEventsResult m4170A(final Status status) {
            return new LoadEventsResult(this) {
                final /* synthetic */ LoadImpl Pr;

                public EventBuffer getEvents() {
                    return new EventBuffer(DataHolder.af(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4170A(status);
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<Result> {
        private UpdateImpl() {
        }

        public Result mo2535c(final Status status) {
            return new Result(this) {
                final /* synthetic */ UpdateImpl Ps;

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public void increment(GoogleApiClient apiClient, final String eventId, final int incrementAmount) {
        GamesClientImpl d = Games.m473d(apiClient);
        if (d.isConnected()) {
            d.m3443l(eventId, incrementAmount);
        } else {
            apiClient.mo927b(new UpdateImpl(this) {
                final /* synthetic */ EventsImpl Po;

                public void m4438a(GamesClientImpl gamesClientImpl) {
                    gamesClientImpl.m3443l(eventId, incrementAmount);
                }
            });
        }
    }

    public PendingResult<LoadEventsResult> load(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.mo926a(new LoadImpl(this) {
            final /* synthetic */ EventsImpl Po;

            public void m4436a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3419d((C0152d) this, forceReload);
            }
        });
    }

    public PendingResult<LoadEventsResult> loadByIds(GoogleApiClient apiClient, final boolean forceReload, final String... eventIds) {
        return apiClient.mo926a(new LoadImpl(this) {
            final /* synthetic */ EventsImpl Po;

            public void m4434a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3375a((C0152d) this, forceReload, eventIds);
            }
        });
    }
}
