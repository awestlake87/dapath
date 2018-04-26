package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange.Builder;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;

public final class SnapshotsImpl implements Snapshots {

    private static abstract class CommitImpl extends BaseGamesApiMethodImpl<CommitSnapshotResult> {
        private CommitImpl() {
        }

        public CommitSnapshotResult m4231Z(final Status status) {
            return new CommitSnapshotResult(this) {
                final /* synthetic */ CommitImpl QQ;

                public SnapshotMetadata getSnapshotMetadata() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4231Z(status);
        }
    }

    private static abstract class DeleteImpl extends BaseGamesApiMethodImpl<DeleteSnapshotResult> {
        private DeleteImpl() {
        }

        public DeleteSnapshotResult aa(final Status status) {
            return new DeleteSnapshotResult(this) {
                final /* synthetic */ DeleteImpl QR;

                public String getSnapshotId() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return aa(status);
        }
    }

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadSnapshotsResult> {
        private LoadImpl() {
        }

        public LoadSnapshotsResult ab(final Status status) {
            return new LoadSnapshotsResult(this) {
                final /* synthetic */ LoadImpl QS;

                public SnapshotMetadataBuffer getSnapshots() {
                    return new SnapshotMetadataBuffer(DataHolder.af(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return ab(status);
        }
    }

    private static abstract class OpenImpl extends BaseGamesApiMethodImpl<OpenSnapshotResult> {
        private OpenImpl() {
        }

        public OpenSnapshotResult ac(final Status status) {
            return new OpenSnapshotResult(this) {
                final /* synthetic */ OpenImpl QT;

                public String getConflictId() {
                    return null;
                }

                public Snapshot getConflictingSnapshot() {
                    return null;
                }

                public Contents getResolutionContents() {
                    return null;
                }

                public Snapshot getSnapshot() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return ac(status);
        }
    }

    class C13806 extends LoadImpl {
        final /* synthetic */ boolean Pe;
        final /* synthetic */ String Pg;
        final /* synthetic */ String Ph;

        protected void m4604a(GamesClientImpl gamesClientImpl) {
            gamesClientImpl.m3408c((C0152d) this, this.Pg, this.Ph, this.Pe);
        }
    }

    public PendingResult<CommitSnapshotResult> commitAndClose(GoogleApiClient apiClient, final Snapshot snapshot, final SnapshotMetadataChange metadataChange) {
        return apiClient.mo927b(new CommitImpl(this) {
            final /* synthetic */ SnapshotsImpl QI;

            protected void m4598a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3350a((C0152d) this, snapshot, metadataChange);
            }
        });
    }

    public PendingResult<DeleteSnapshotResult> delete(GoogleApiClient apiClient, final SnapshotMetadata metadata) {
        return apiClient.mo927b(new DeleteImpl(this) {
            final /* synthetic */ SnapshotsImpl QI;

            protected void m4600a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3439j(this, metadata.getSnapshotId());
            }
        });
    }

    public void discardAndClose(GoogleApiClient apiClient, Snapshot snapshot) {
        Games.m472c(apiClient).m3384a(snapshot);
    }

    public int getMaxCoverImageSize(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).hu();
    }

    public int getMaxDataSize(GoogleApiClient apiClient) {
        return Games.m472c(apiClient).ht();
    }

    public Intent getSelectSnapshotIntent(GoogleApiClient apiClient, String title, boolean allowAddButton, boolean allowDelete, int maxSnapshots) {
        return Games.m472c(apiClient).m3340a(title, allowAddButton, allowDelete, maxSnapshots);
    }

    public SnapshotMetadata getSnapshotFromBundle(Bundle extras) {
        return (extras == null || !extras.containsKey(Snapshots.EXTRA_SNAPSHOT_METADATA)) ? null : (SnapshotMetadata) extras.getParcelable(Snapshots.EXTRA_SNAPSHOT_METADATA);
    }

    public PendingResult<LoadSnapshotsResult> load(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.mo926a(new LoadImpl(this) {
            final /* synthetic */ SnapshotsImpl QI;

            protected void m4594a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3424e((C0152d) this, forceReload);
            }
        });
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient apiClient, SnapshotMetadata metadata) {
        return open(apiClient, metadata.getUniqueName(), false);
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient apiClient, final String fileName, final boolean createIfNotFound) {
        return apiClient.mo927b(new OpenImpl(this) {
            final /* synthetic */ SnapshotsImpl QI;

            protected void m4596a(GamesClientImpl gamesClientImpl) {
                gamesClientImpl.m3396b((C0152d) this, fileName, createIfNotFound);
            }
        });
    }

    public PendingResult<OpenSnapshotResult> resolveConflict(GoogleApiClient apiClient, String conflictId, Snapshot snapshot) {
        SnapshotMetadata metadata = snapshot.getMetadata();
        SnapshotMetadataChange build = new Builder().fromMetadata(metadata).build();
        return resolveConflict(apiClient, conflictId, metadata.getSnapshotId(), build, snapshot.getContents());
    }

    public PendingResult<OpenSnapshotResult> resolveConflict(GoogleApiClient apiClient, String conflictId, String snapshotId, SnapshotMetadataChange metadataChange, Contents contents) {
        final String str = conflictId;
        final String str2 = snapshotId;
        final SnapshotMetadataChange snapshotMetadataChange = metadataChange;
        final Contents contents2 = contents;
        return apiClient.mo927b(new OpenImpl(this) {
            final /* synthetic */ SnapshotsImpl QI;

            protected void m4602a(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.m3364a((C0152d) this, str, str2, snapshotMetadataChange, contents2);
            }
        });
    }
}
