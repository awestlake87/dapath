package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.ContentsResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.C0621p.C1012a;

public class C1016s extends C0623v implements DriveFile {

    private static class C1167c extends C1010c {
        private final DownloadProgressListener Je;
        private final C0152d<ContentsResult> yR;

        public C1167c(C0152d<ContentsResult> c0152d, DownloadProgressListener downloadProgressListener) {
            this.yR = c0152d;
            this.Je = downloadProgressListener;
        }

        public void mo976a(OnContentsResponse onContentsResponse) throws RemoteException {
            this.yR.mo911a(new C1012a(Status.En, onContentsResponse.gt()));
        }

        public void mo977a(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
            if (this.Je != null) {
                this.Je.onProgress(onDownloadProgressResponse.gu(), onDownloadProgressResponse.gv());
            }
        }

        public void mo986o(Status status) throws RemoteException {
            this.yR.mo911a(new C1012a(status, null));
        }
    }

    private abstract class C1225a extends C1166q<Status> {
        final /* synthetic */ C1016s Jc;

        private C1225a(C1016s c1016s) {
            this.Jc = c1016s;
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4136d(status);
        }

        public Status m4136d(Status status) {
            return status;
        }
    }

    private abstract class C1226b extends C1166q<Status> {
        final /* synthetic */ C1016s Jc;

        private C1226b(C1016s c1016s) {
            this.Jc = c1016s;
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4138d(status);
        }

        public Status m4138d(Status status) {
            return status;
        }
    }

    private abstract class C1227d extends C1166q<ContentsResult> {
        final /* synthetic */ C1016s Jc;

        private C1227d(C1016s c1016s) {
            this.Jc = c1016s;
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4140q(status);
        }

        public ContentsResult m4140q(Status status) {
            return new C1012a(status, null);
        }
    }

    public C1016s(DriveId driveId) {
        super(driveId);
    }

    public PendingResult<Status> commitAndCloseContents(GoogleApiClient apiClient, final Contents contents) {
        if (contents != null) {
            return apiClient.mo927b(new C1226b(this) {
                final /* synthetic */ C1016s Jc;

                protected void m4396a(C1015r c1015r) throws RemoteException {
                    contents.close();
                    c1015r.gp().mo953a(new CloseContentsRequest(contents, true), new aw(this));
                }
            });
        }
        throw new IllegalArgumentException("Contents must be provided.");
    }

    public PendingResult<Status> commitAndCloseContents(GoogleApiClient apiClient, final Contents contents, final MetadataChangeSet changeSet) {
        if (contents != null) {
            return apiClient.mo927b(new C1225a(this) {
                final /* synthetic */ C1016s Jc;

                protected void m4398a(C1015r c1015r) throws RemoteException {
                    contents.close();
                    c1015r.gp().mo952a(new CloseContentsAndUpdateMetadataRequest(this.Jc.Hz, changeSet.gm(), contents, false, null), new aw(this));
                }
            });
        }
        throw new IllegalArgumentException("Contents must be provided.");
    }

    public PendingResult<Status> discardContents(GoogleApiClient apiClient, Contents contents) {
        return Drive.DriveApi.discardContents(apiClient, contents);
    }

    public PendingResult<ContentsResult> openContents(GoogleApiClient apiClient, final int mode, final DownloadProgressListener listener) {
        if (mode == DriveFile.MODE_READ_ONLY || mode == DriveFile.MODE_WRITE_ONLY || mode == DriveFile.MODE_READ_WRITE) {
            return apiClient.mo926a(new C1227d(this) {
                final /* synthetic */ C1016s Jc;

                protected void m4394a(C1015r c1015r) throws RemoteException {
                    c1015r.gp().mo964a(new OpenContentsRequest(this.Jc.getDriveId(), mode), new C1167c(this, listener));
                }
            });
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}
