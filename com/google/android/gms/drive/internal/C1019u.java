package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveFolder.DriveFileResult;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.Query.Builder;
import com.google.android.gms.drive.query.SearchableField;

public class C1019u extends C0623v implements DriveFolder {

    private static class C1017d implements DriveFileResult {
        private final DriveFile Jj;
        private final Status yz;

        public C1017d(Status status, DriveFile driveFile) {
            this.yz = status;
            this.Jj = driveFile;
        }

        public DriveFile getDriveFile() {
            return this.Jj;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static class C1018e implements DriveFolderResult {
        private final DriveFolder Jk;
        private final Status yz;

        public C1018e(Status status, DriveFolder driveFolder) {
            this.yz = status;
            this.Jk = driveFolder;
        }

        public DriveFolder getDriveFolder() {
            return this.Jk;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static class C1168a extends C1010c {
        private final C0152d<DriveFileResult> yR;

        public C1168a(C0152d<DriveFileResult> c0152d) {
            this.yR = c0152d;
        }

        public void mo978a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.yR.mo911a(new C1017d(Status.En, new C1016s(onDriveIdResponse.getDriveId())));
        }

        public void mo986o(Status status) throws RemoteException {
            this.yR.mo911a(new C1017d(status, null));
        }
    }

    private static class C1169b extends C1010c {
        private final C0152d<DriveFolderResult> yR;

        public C1169b(C0152d<DriveFolderResult> c0152d) {
            this.yR = c0152d;
        }

        public void mo978a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.yR.mo911a(new C1018e(Status.En, new C1019u(onDriveIdResponse.getDriveId())));
        }

        public void mo986o(Status status) throws RemoteException {
            this.yR.mo911a(new C1018e(status, null));
        }
    }

    private abstract class C1229c extends C1166q<DriveFolderResult> {
        final /* synthetic */ C1019u Ji;

        private C1229c(C1019u c1019u) {
            this.Ji = c1019u;
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4146t(status);
        }

        public DriveFolderResult m4146t(Status status) {
            return new C1018e(status, null);
        }
    }

    public C1019u(DriveId driveId) {
        super(driveId);
    }

    private PendingResult<DriveFileResult> m3223a(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, Contents contents, int i, boolean z, String str) {
        final Contents contents2 = contents;
        final MetadataChangeSet metadataChangeSet2 = metadataChangeSet;
        final int i2 = i;
        final boolean z2 = z;
        final String str2 = str;
        return googleApiClient.mo927b(new C1166q<DriveFileResult>(this) {
            final /* synthetic */ C1019u Ji;

            protected void m4142a(C1015r c1015r) throws RemoteException {
                if (contents2 != null) {
                    contents2.close();
                }
                c1015r.gp().mo955a(new CreateFileRequest(this.Ji.getDriveId(), metadataChangeSet2.gm(), contents2, i2, z2, str2), new C1168a(this));
            }

            public /* synthetic */ Result mo2535c(Status status) {
                return m4144s(status);
            }

            public DriveFileResult m4144s(Status status) {
                return new C1017d(status, null);
            }
        });
    }

    private PendingResult<DriveFileResult> m3224a(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, Contents contents, boolean z, String str) {
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (contents == null) {
            throw new IllegalArgumentException("Contents must be provided.");
        } else if (!DriveFolder.MIME_TYPE.equals(metadataChangeSet.getMimeType())) {
            return m3223a(googleApiClient, metadataChangeSet, contents, 0, z, str);
        } else {
            throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
        }
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, Contents contents) {
        return m3224a(apiClient, changeSet, contents, false, null);
    }

    public PendingResult<DriveFolderResult> createFolder(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (changeSet.getMimeType() == null || changeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return apiClient.mo927b(new C1229c(this) {
                final /* synthetic */ C1019u Ji;

                protected void m4400a(C1015r c1015r) throws RemoteException {
                    c1015r.gp().mo956a(new CreateFolderRequest(this.Ji.getDriveId(), changeSet.gm()), new C1169b(this));
                }
            });
        } else {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        }
    }

    public PendingResult<MetadataBufferResult> listChildren(GoogleApiClient apiClient) {
        return queryChildren(apiClient, null);
    }

    public PendingResult<MetadataBufferResult> queryChildren(GoogleApiClient apiClient, Query query) {
        Builder addFilter = new Builder().addFilter(Filters.in(SearchableField.PARENTS, getDriveId()));
        if (query != null) {
            if (query.getFilter() != null) {
                addFilter.addFilter(query.getFilter());
            }
            addFilter.setPageToken(query.getPageToken());
            addFilter.setSortOrder(query.getSortOrder());
        }
        return new C0621p().query(apiClient, addFilter.build());
    }
}
