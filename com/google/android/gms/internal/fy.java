package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.C0153a.C1002b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.ft.C0731a;
import java.util.List;

public final class fy implements AppIndexApi, ft {

    private static abstract class C0736a<T> implements Result {
        protected final T yA;
        private final Status yz;

        public C0736a(Status status, T t) {
            this.yz = status;
            this.yA = t;
        }

        public Status getStatus() {
            return this.yz;
        }
    }

    static class C1085b extends C0736a<ParcelFileDescriptor> implements C0731a {
        public C1085b(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            super(status, parcelFileDescriptor);
        }
    }

    private static abstract class C1177c<T extends Result> extends C1002b<T, fx> {
        public C1177c() {
            super(ff.xI);
        }

        protected abstract void mo3152a(fu fuVar) throws RemoteException;

        protected final void m4059a(fx fxVar) throws RemoteException {
            mo3152a(fxVar.dR());
        }
    }

    private static final class C1178e extends fw<Status> {
        public C1178e(C0152d<Status> c0152d) {
            super(c0152d);
        }

        public void mo1703a(Status status) {
            this.yu.mo911a(status);
        }
    }

    class C12371 extends C1177c<C0731a> {
        protected void mo3152a(fu fuVar) throws RemoteException {
            fuVar.mo1699a(new fw<C0731a>(this, this) {
                final /* synthetic */ C12371 yv;

                public void mo1704a(Status status, ParcelFileDescriptor parcelFileDescriptor) {
                    this.yu.mo911a(new C1085b(status, parcelFileDescriptor));
                }
            });
        }

        public C0731a m4246b(Status status) {
            return new C1085b(status, null);
        }

        public /* synthetic */ Result mo2535c(Status status) {
            return m4246b(status);
        }
    }

    private static abstract class C1238d<T extends Result> extends C1177c<Status> {
        private C1238d() {
        }

        protected /* synthetic */ Result mo2535c(Status status) {
            return m4249d(status);
        }

        protected Status m4249d(Status status) {
            return status;
        }
    }

    static Uri m2595a(String str, Uri uri) {
        if (!"android-app".equals(uri.getScheme())) {
            throw new IllegalArgumentException("Uri scheme must be android-app: " + uri);
        } else if (str.equals(uri.getHost())) {
            List pathSegments = uri.getPathSegments();
            if (pathSegments.isEmpty() || ((String) pathSegments.get(0)).isEmpty()) {
                throw new IllegalArgumentException("Uri path must exist: " + uri);
            }
            String str2 = (String) pathSegments.get(0);
            Builder builder = new Builder();
            builder.scheme(str2);
            if (pathSegments.size() > 1) {
                builder.authority((String) pathSegments.get(1));
                for (int i = 2; i < pathSegments.size(); i++) {
                    builder.appendPath((String) pathSegments.get(i));
                }
            }
            builder.encodedQuery(uri.getEncodedQuery());
            builder.encodedFragment(uri.getEncodedFragment());
            return builder.build();
        } else {
            throw new IllegalArgumentException("Uri host must match package name: " + uri);
        }
    }

    public PendingResult<Status> m2596a(GoogleApiClient googleApiClient, final fr... frVarArr) {
        final String packageName = ((fx) googleApiClient.mo925a(ff.xI)).getContext().getPackageName();
        return googleApiClient.mo926a(new C1238d<Status>(this) {
            final /* synthetic */ fy yy;

            protected void mo3152a(fu fuVar) throws RemoteException {
                fuVar.mo1700a(new C1178e(this), packageName, frVarArr);
            }
        });
    }

    public PendingResult<Status> view(GoogleApiClient apiClient, Activity activity, Intent viewIntent, String title, Uri webUrl, List<AppIndexingLink> outLinks) {
        return m2596a(apiClient, new fr(((fx) apiClient.mo925a(ff.xI)).getContext().getPackageName(), viewIntent, title, webUrl, null, (List) outLinks));
    }

    public PendingResult<Status> view(GoogleApiClient apiClient, Activity activity, Uri appIndexingUrl, String title, Uri webUrl, List<AppIndexingLink> outLinks) {
        return view(apiClient, activity, new Intent("android.intent.action.VIEW", m2595a(((fx) apiClient.mo925a(ff.xI)).getContext().getPackageName(), appIndexingUrl)), title, webUrl, (List) outLinks);
    }

    public PendingResult<Status> viewEnd(GoogleApiClient apiClient, Activity activity, Intent viewIntent) {
        fr frVar = new fr(fr.m2581a(((fx) apiClient.mo925a(ff.xI)).getContext().getPackageName(), viewIntent), System.currentTimeMillis(), 3);
        return m2596a(apiClient, frVar);
    }

    public PendingResult<Status> viewEnd(GoogleApiClient apiClient, Activity activity, Uri appIndexingUrl) {
        return viewEnd(apiClient, activity, new Intent("android.intent.action.VIEW", m2595a(((fx) apiClient.mo925a(ff.xI)).getContext().getPackageName(), appIndexingUrl)));
    }
}
