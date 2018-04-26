package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.DriveResource.MetadataResult;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.DriveEvent.Listener;
import com.google.android.gms.drive.internal.C0621p.C1014e;

public class C0623v implements DriveResource {
    protected final DriveId Hz;

    private static class C1020e implements MetadataResult {
        private final Metadata Jm;
        private final Status yz;

        public C1020e(Status status, Metadata metadata) {
            this.yz = status;
            this.Jm = metadata;
        }

        public Metadata getMetadata() {
            return this.Jm;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    private static class C1170b extends C1010c {
        private final C0152d<MetadataBufferResult> yR;

        public C1170b(C0152d<MetadataBufferResult> c0152d) {
            this.yR = c0152d;
        }

        public void mo980a(OnListParentsResponse onListParentsResponse) throws RemoteException {
            this.yR.mo911a(new C1014e(Status.En, new MetadataBuffer(onListParentsResponse.gA(), null), false));
        }

        public void mo986o(Status status) throws RemoteException {
            this.yR.mo911a(new C1014e(status, null, false));
        }
    }

    private static class C1171d extends C1010c {
        private final C0152d<MetadataResult> yR;

        public C1171d(C0152d<MetadataResult> c0152d) {
            this.yR = c0152d;
        }

        public void mo982a(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.yR.mo911a(new C1020e(Status.En, new C1011l(onMetadataResponse.gB())));
        }

        public void mo986o(Status status) throws RemoteException {
            this.yR.mo911a(new C1020e(status, null));
        }
    }

    private abstract class C1230a extends C1166q<MetadataResult> {
        final /* synthetic */ C0623v Jl;

        private C1230a(C0623v c0623v) {
            this.Jl = c0623v;
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4148u(status);
        }

        public MetadataResult m4148u(Status status) {
            return new C1020e(status, null);
        }
    }

    private abstract class C1231c extends C1166q<MetadataBufferResult> {
        final /* synthetic */ C0623v Jl;

        private C1231c(C0623v c0623v) {
            this.Jl = c0623v;
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4150r(status);
        }

        public MetadataBufferResult m4150r(Status status) {
            return new C1014e(status, null, false);
        }
    }

    private abstract class C1232f extends C1166q<MetadataResult> {
        final /* synthetic */ C0623v Jl;

        private C1232f(C0623v c0623v) {
            this.Jl = c0623v;
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4152u(status);
        }

        public MetadataResult m4152u(Status status) {
            return new C1020e(status, null);
        }
    }

    class C13091 extends C1230a {
        final /* synthetic */ C0623v Jl;

        C13091(C0623v c0623v) {
            this.Jl = c0623v;
            super();
        }

        protected void m4402a(C1015r c1015r) throws RemoteException {
            c1015r.gp().mo961a(new GetMetadataRequest(this.Jl.Hz), new C1171d(this));
        }
    }

    class C13102 extends C1231c {
        final /* synthetic */ C0623v Jl;

        C13102(C0623v c0623v) {
            this.Jl = c0623v;
            super();
        }

        protected void m4404a(C1015r c1015r) throws RemoteException {
            c1015r.gp().mo962a(new ListParentsRequest(this.Jl.Hz), new C1170b(this));
        }
    }

    protected C0623v(DriveId driveId) {
        this.Hz = driveId;
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient apiClient, Listener<ChangeEvent> listener) {
        return ((C1015r) apiClient.mo925a(Drive.yH)).m3218a(apiClient, this.Hz, 1, listener);
    }

    public DriveId getDriveId() {
        return this.Hz;
    }

    public PendingResult<MetadataResult> getMetadata(GoogleApiClient apiClient) {
        return apiClient.mo926a(new C13091(this));
    }

    public PendingResult<MetadataBufferResult> listParents(GoogleApiClient apiClient) {
        return apiClient.mo926a(new C13102(this));
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient apiClient, Listener<ChangeEvent> listener) {
        return ((C1015r) apiClient.mo925a(Drive.yH)).m3221b(apiClient, this.Hz, 1, listener);
    }

    public PendingResult<MetadataResult> updateMetadata(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet != null) {
            return apiClient.mo927b(new C1232f(this) {
                final /* synthetic */ C0623v Jl;

                protected void m4406a(C1015r c1015r) throws RemoteException {
                    c1015r.gp().mo969a(new UpdateMetadataRequest(this.Jl.Hz, changeSet.gm()), new C1171d(this));
                }
            });
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}
