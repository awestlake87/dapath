package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class RequestsImpl implements Requests {

    private static abstract class LoadRequestSummariesImpl extends BaseGamesApiMethodImpl<LoadRequestSummariesResult> {
        private LoadRequestSummariesImpl() {
        }

        public LoadRequestSummariesResult m4223V(final Status status) {
            return new LoadRequestSummariesResult(this) {
                final /* synthetic */ LoadRequestSummariesImpl QE;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4223V(status);
        }
    }

    private static abstract class LoadRequestsImpl extends BaseGamesApiMethodImpl<LoadRequestsResult> {
        private LoadRequestsImpl() {
        }

        public LoadRequestsResult m4225W(final Status status) {
            return new LoadRequestsResult(this) {
                final /* synthetic */ LoadRequestsImpl QF;

                public GameRequestBuffer getRequests(int type) {
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
            return m4225W(status);
        }
    }

    private static abstract class SendRequestImpl extends BaseGamesApiMethodImpl<SendRequestResult> {
        private SendRequestImpl() {
        }

        public SendRequestResult m4227X(final Status status) {
            return new SendRequestResult(this) {
                final /* synthetic */ SendRequestImpl QG;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4227X(status);
        }
    }

    private static abstract class UpdateRequestsImpl extends BaseGamesApiMethodImpl<UpdateRequestsResult> {
        private UpdateRequestsImpl() {
        }

        public UpdateRequestsResult m4229Y(final Status status) {
            return new UpdateRequestsResult(this) {
                final /* synthetic */ UpdateRequestsImpl QH;

                public Set<String> getRequestIds() {
                    return null;
                }

                public int getRequestOutcome(String requestId) {
                    throw new IllegalArgumentException("Unknown request ID " + requestId);
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4229Y(status);
        }
    }

    class C13704 extends SendRequestImpl {
        final /* synthetic */ String Ph;
        final /* synthetic */ String[] QA;
        final /* synthetic */ int QB;
        final /* synthetic */ byte[] QC;
        final /* synthetic */ int QD;

        protected void m4584a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3372a((C0152d) this, this.Ph, this.QA, this.QB, this.QC, this.QD);
        }
    }

    class C13715 extends SendRequestImpl {
        final /* synthetic */ String Ph;
        final /* synthetic */ String[] QA;
        final /* synthetic */ int QB;
        final /* synthetic */ byte[] QC;
        final /* synthetic */ int QD;

        protected void m4586a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3372a((C0152d) this, this.Ph, this.QA, this.QB, this.QC, this.QD);
        }
    }

    class C13726 extends UpdateRequestsImpl {
        final /* synthetic */ String Ph;
        final /* synthetic */ String Qs;
        final /* synthetic */ String[] Qw;

        protected void m4588a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3368a((C0152d) this, this.Ph, this.Qs, this.Qw);
        }
    }

    class C13737 extends LoadRequestsImpl {
        final /* synthetic */ int PE;
        final /* synthetic */ String Ph;
        final /* synthetic */ String Qs;
        final /* synthetic */ int Qy;
        final /* synthetic */ int Qz;

        protected void m4590a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3361a((C0152d) this, this.Ph, this.Qs, this.Qy, this.Qz, this.PE);
        }
    }

    class C13748 extends LoadRequestSummariesImpl {
        final /* synthetic */ String Qs;
        final /* synthetic */ int Qz;

        protected void m4592a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3428f(this, this.Qs, this.Qz);
        }
    }

    public PendingResult<UpdateRequestsResult> acceptRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return acceptRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> acceptRequests(GoogleApiClient apiClient, List<String> requestIds) {
        final String[] strArr = requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()]);
        return apiClient.mo927b(new UpdateRequestsImpl(this) {
            final /* synthetic */ RequestsImpl Qx;

            protected void m4578a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3399b((C0152d) this, strArr);
            }
        });
    }

    public PendingResult<UpdateRequestsResult> dismissRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return dismissRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> dismissRequests(GoogleApiClient apiClient, List<String> requestIds) {
        final String[] strArr = requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()]);
        return apiClient.mo927b(new UpdateRequestsImpl(this) {
            final /* synthetic */ RequestsImpl Qx;

            protected void m4580a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3411c((C0152d) this, strArr);
            }
        });
    }

    public ArrayList<GameRequest> getGameRequestsFromBundle(Bundle extras) {
        if (extras == null || !extras.containsKey(Requests.EXTRA_REQUESTS)) {
            return new ArrayList();
        }
        ArrayList arrayList = (ArrayList) extras.get(Requests.EXTRA_REQUESTS);
        ArrayList<GameRequest> arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add((GameRequest) arrayList.get(i));
        }
        return arrayList2;
    }

    public ArrayList<GameRequest> getGameRequestsFromInboxResponse(Intent response) {
        return response == null ? new ArrayList() : getGameRequestsFromBundle(response.getExtras());
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).hq();
    }

    public int getMaxLifetimeDays(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).hs();
    }

    public int getMaxPayloadSize(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).hr();
    }

    public Intent getSendIntent(GoogleApiClient apiClient, int type, byte[] payload, int requestLifetimeDays, Bitmap icon, String description) {
        return Games.m472c(apiClient).m3338a(type, payload, requestLifetimeDays, icon, description);
    }

    public PendingResult<LoadRequestsResult> loadRequests(GoogleApiClient apiClient, final int requestDirection, final int types, final int sortOrder) {
        return apiClient.mo926a(new LoadRequestsImpl(this) {
            final /* synthetic */ RequestsImpl Qx;

            protected void m4582a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3344a((C0152d) this, requestDirection, types, sortOrder);
            }
        });
    }

    public void registerRequestListener(GoogleApiClient apiClient, OnRequestReceivedListener listener) {
        Games.m472c(apiClient).m3383a(listener);
    }

    public void unregisterRequestListener(GoogleApiClient apiClient) {
        Games.m472c(apiClient).hk();
    }
}
