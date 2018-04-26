package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0153a.C0151c;
import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveApi.ContentsResult;
import com.google.android.gms.drive.DriveApi.DriveIdResult;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;

public class C0621p implements DriveApi {

    public static class C1012a implements ContentsResult {
        private final Contents HG;
        private final Status yz;

        public C1012a(Status status, Contents contents) {
            this.yz = status;
            this.HG = contents;
        }

        public Contents getContents() {
            return this.HG;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    static class C1013c implements DriveIdResult {
        private final DriveId Hz;
        private final Status yz;

        public C1013c(Status status, DriveId driveId) {
            this.yz = status;
            this.Hz = driveId;
        }

        public DriveId getDriveId() {
            return this.Hz;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    static class C1014e implements MetadataBufferResult {
        private final MetadataBuffer IO;
        private final boolean IP;
        private final Status yz;

        public C1014e(Status status, MetadataBuffer metadataBuffer, boolean z) {
            this.yz = status;
            this.IO = metadataBuffer;
            this.IP = z;
        }

        public MetadataBuffer getMetadataBuffer() {
            return this.IO;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static class C1163b extends C1010c {
        private final C0152d<DriveIdResult> yR;

        public C1163b(C0152d<DriveIdResult> c0152d) {
            this.yR = c0152d;
        }

        public void mo978a(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.yR.mo911a(new C1013c(Status.En, onDriveIdResponse.getDriveId()));
        }

        public void mo982a(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.yR.mo911a(new C1013c(Status.En, new C1011l(onMetadataResponse.gB()).getDriveId()));
        }

        public void mo986o(Status status) throws RemoteException {
            this.yR.mo911a(new C1013c(status, null));
        }
    }

    private static class C1164f extends C1010c {
        private final C0152d<ContentsResult> yR;

        public C1164f(C0152d<ContentsResult> c0152d) {
            this.yR = c0152d;
        }

        public void mo976a(OnContentsResponse onContentsResponse) throws RemoteException {
            this.yR.mo911a(new C1012a(Status.En, onContentsResponse.gt()));
        }

        public void mo986o(Status status) throws RemoteException {
            this.yR.mo911a(new C1012a(status, null));
        }
    }

    static class C1165h extends C1010c {
        private final C0152d<MetadataBufferResult> yR;

        public C1165h(C0152d<MetadataBufferResult> c0152d) {
            this.yR = c0152d;
        }

        public void mo979a(OnListEntriesResponse onListEntriesResponse) throws RemoteException {
            this.yR.mo911a(new C1014e(Status.En, new MetadataBuffer(onListEntriesResponse.gy(), null), onListEntriesResponse.gz()));
        }

        public void mo986o(Status status) throws RemoteException {
            this.yR.mo911a(new C1014e(status, null, false));
        }
    }

    abstract class C1220d extends C1166q<DriveIdResult> {
        final /* synthetic */ C0621p IL;

        C1220d(C0621p c0621p) {
            this.IL = c0621p;
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4126p(status);
        }

        public DriveIdResult m4126p(Status status) {
            return new C1013c(status, null);
        }
    }

    abstract class C1221g extends C1166q<ContentsResult> {
        final /* synthetic */ C0621p IL;

        C1221g(C0621p c0621p) {
            this.IL = c0621p;
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4128q(status);
        }

        public ContentsResult m4128q(Status status) {
            return new C1012a(status, null);
        }
    }

    abstract class C1222i extends C1166q<MetadataBufferResult> {
        final /* synthetic */ C0621p IL;

        C1222i(C0621p c0621p) {
            this.IL = c0621p;
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4130r(status);
        }

        public MetadataBufferResult m4130r(Status status) {
            return new C1014e(status, null, false);
        }
    }

    static abstract class C1223j extends C1166q<Status> {
        C1223j() {
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4132d(status);
        }

        public Status m4132d(Status status) {
            return status;
        }
    }

    abstract class C1224l extends C1166q<Status> {
        final /* synthetic */ C0621p IL;

        C1224l(C0621p c0621p) {
            this.IL = c0621p;
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4134d(status);
        }

        public Status m4134d(Status status) {
            return status;
        }
    }

    class C12982 extends C1221g {
        final /* synthetic */ C0621p IL;

        C12982(C0621p c0621p) {
            this.IL = c0621p;
            super(c0621p);
        }

        protected void m4380a(C1015r c1015r) throws RemoteException {
            c1015r.gp().mo954a(new CreateContentsRequest(), new C1164f(this));
        }
    }

    class C13015 extends C1224l {
        final /* synthetic */ C0621p IL;

        C13015(C0621p c0621p) {
            this.IL = c0621p;
            super(c0621p);
        }

        protected void m4386a(C1015r c1015r) throws RemoteException {
            c1015r.gp().mo970a(new aw(this));
        }
    }

    static class C1302k extends C1223j {
        C1302k(GoogleApiClient googleApiClient, Status status) {
            m1981a(new C0151c(((C1015r) googleApiClient.mo925a(Drive.yH)).getLooper()));
            m1984b(status);
        }

        protected void m4388a(C1015r c1015r) {
        }
    }

    public PendingResult<Status> discardContents(GoogleApiClient apiClient, final Contents contents) {
        return apiClient.mo927b(new C1223j(this) {
            final /* synthetic */ C0621p IL;

            protected void m4382a(C1015r c1015r) throws RemoteException {
                c1015r.gp().mo953a(new CloseContentsRequest(contents, false), new aw(this));
            }
        });
    }

    public PendingResult<DriveIdResult> fetchDriveId(GoogleApiClient apiClient, final String resourceId) {
        return apiClient.mo926a(new C1220d(this) {
            final /* synthetic */ C0621p IL;

            protected void m4384a(C1015r c1015r) throws RemoteException {
                c1015r.gp().mo961a(new GetMetadataRequest(DriveId.aL(resourceId)), new C1163b(this));
            }
        });
    }

    public DriveFolder getAppFolder(GoogleApiClient apiClient) {
        if (apiClient.isConnected()) {
            DriveId gr = ((C1015r) apiClient.mo925a(Drive.yH)).gr();
            return gr != null ? new C1019u(gr) : null;
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFile getFile(GoogleApiClient apiClient, DriveId id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new C1016s(id);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getFolder(GoogleApiClient apiClient, DriveId id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new C1019u(id);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient apiClient) {
        if (apiClient.isConnected()) {
            return new C1019u(((C1015r) apiClient.mo925a(Drive.yH)).gq());
        }
        throw new IllegalStateException("Client must be connected");
    }

    public PendingResult<ContentsResult> newContents(GoogleApiClient apiClient) {
        return apiClient.mo926a(new C12982(this));
    }

    public CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    public OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    public PendingResult<MetadataBufferResult> query(GoogleApiClient apiClient, final Query query) {
        if (query != null) {
            return apiClient.mo926a(new C1222i(this) {
                final /* synthetic */ C0621p IL;

                protected void m4378a(C1015r c1015r) throws RemoteException {
                    c1015r.gp().mo965a(new QueryRequest(query), new C1165h(this));
                }
            });
        }
        throw new IllegalArgumentException("Query must be provided.");
    }

    public PendingResult<Status> requestSync(GoogleApiClient client) {
        return client.mo927b(new C13015(this));
    }
}
