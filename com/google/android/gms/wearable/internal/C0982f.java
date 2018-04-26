package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.RemoteException;
import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.io.InputStream;

public final class C0982f implements DataApi {

    public static class C1150a implements DataItemResult {
        private final DataItem alH;
        private final Status yz;

        public C1150a(Status status, DataItem dataItem) {
            this.yz = status;
            this.alH = dataItem;
        }

        public DataItem getDataItem() {
            return this.alH;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    public static class C1151b implements DeleteDataItemsResult {
        private final int alI;
        private final Status yz;

        public C1151b(Status status, int i) {
            this.yz = status;
            this.alI = i;
        }

        public int getNumDeleted() {
            return this.alI;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    public static class C1152c implements GetFdForAssetResult {
        private final ParcelFileDescriptor alJ;
        private final Status yz;

        public C1152c(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            this.yz = status;
            this.alJ = parcelFileDescriptor;
        }

        public ParcelFileDescriptor getFd() {
            return this.alJ;
        }

        public InputStream getInputStream() {
            return new AutoCloseInputStream(this.alJ);
        }

        public Status getStatus() {
            return this.yz;
        }

        public void release() {
            try {
                this.alJ.close();
            } catch (IOException e) {
            }
        }
    }

    class C12663 extends C1212d<DataItemBuffer> {
        final /* synthetic */ C0982f alC;

        C12663(C0982f c0982f) {
            this.alC = c0982f;
        }

        protected void m4301a(au auVar) throws RemoteException {
            auVar.m3891o(this);
        }

        protected DataItemBuffer ar(Status status) {
            return new DataItemBuffer(DataHolder.af(status.getStatusCode()));
        }

        protected /* synthetic */ Result mo2535c(Status status) {
            return ar(status);
        }
    }

    private PendingResult<Status> m3162a(GoogleApiClient googleApiClient, final DataListener dataListener, final IntentFilter[] intentFilterArr) {
        return googleApiClient.mo926a(new C1212d<Status>(this) {
            final /* synthetic */ C0982f alC;

            protected void m4316a(au auVar) throws RemoteException {
                auVar.m3879a((C0152d) this, dataListener, intentFilterArr);
            }

            public /* synthetic */ Result mo2535c(Status status) {
                return m4318d(status);
            }

            public Status m4318d(Status status) {
                return new Status(13);
            }
        });
    }

    private void m3163a(Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        } else if (asset.getDigest() == null) {
            throw new IllegalArgumentException("invalid asset");
        } else if (asset.getData() != null) {
            throw new IllegalArgumentException("invalid asset");
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, DataListener listener) {
        return m3162a(client, listener, null);
    }

    public PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient client, final Uri uri) {
        return client.mo926a(new C1212d<DeleteDataItemsResult>(this) {
            final /* synthetic */ C0982f alC;

            protected void m4307a(au auVar) throws RemoteException {
                auVar.m3890c(this, uri);
            }

            protected DeleteDataItemsResult as(Status status) {
                return new C1151b(status, 0);
            }

            protected /* synthetic */ Result mo2535c(Status status) {
                return as(status);
            }
        });
    }

    public PendingResult<DataItemResult> getDataItem(GoogleApiClient client, final Uri uri) {
        return client.mo926a(new C1212d<DataItemResult>(this) {
            final /* synthetic */ C0982f alC;

            protected void m4298a(au auVar) throws RemoteException {
                auVar.m3876a((C0152d) this, uri);
            }

            protected DataItemResult aq(Status status) {
                return new C1150a(status, null);
            }

            protected /* synthetic */ Result mo2535c(Status status) {
                return aq(status);
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client) {
        return client.mo926a(new C12663(this));
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client, final Uri uri) {
        return client.mo926a(new C1212d<DataItemBuffer>(this) {
            final /* synthetic */ C0982f alC;

            protected void m4304a(au auVar) throws RemoteException {
                auVar.m3888b((C0152d) this, uri);
            }

            protected DataItemBuffer ar(Status status) {
                return new DataItemBuffer(DataHolder.af(status.getStatusCode()));
            }

            protected /* synthetic */ Result mo2535c(Status status) {
                return ar(status);
            }
        });
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient client, final Asset asset) {
        m3163a(asset);
        return client.mo926a(new C1212d<GetFdForAssetResult>(this) {
            final /* synthetic */ C0982f alC;

            protected void m4310a(au auVar) throws RemoteException {
                auVar.m3877a((C0152d) this, asset);
            }

            protected GetFdForAssetResult at(Status status) {
                return new C1152c(status, null);
            }

            protected /* synthetic */ Result mo2535c(Status status) {
                return at(status);
            }
        });
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient client, final DataItemAsset asset) {
        return client.mo926a(new C1212d<GetFdForAssetResult>(this) {
            final /* synthetic */ C0982f alC;

            protected void m4313a(au auVar) throws RemoteException {
                auVar.m3880a((C0152d) this, asset);
            }

            protected GetFdForAssetResult at(Status status) {
                return new C1152c(status, null);
            }

            protected /* synthetic */ Result mo2535c(Status status) {
                return at(status);
            }
        });
    }

    public PendingResult<DataItemResult> putDataItem(GoogleApiClient client, final PutDataRequest request) {
        return client.mo926a(new C1212d<DataItemResult>(this) {
            final /* synthetic */ C0982f alC;

            protected void m4295a(au auVar) throws RemoteException {
                auVar.m3884a((C0152d) this, request);
            }

            public DataItemResult aq(Status status) {
                return new C1150a(status, null);
            }

            public /* synthetic */ Result mo2535c(Status status) {
                return aq(status);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final DataListener listener) {
        return client.mo926a(new C1212d<Status>(this) {
            final /* synthetic */ C0982f alC;

            protected void m4320a(au auVar) throws RemoteException {
                auVar.m3878a((C0152d) this, listener);
            }

            public /* synthetic */ Result mo2535c(Status status) {
                return m4322d(status);
            }

            public Status m4322d(Status status) {
                return new Status(13);
            }
        });
    }
}
