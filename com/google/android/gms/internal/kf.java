package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.C0153a.C1002b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.kd.C0778a;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;
import com.google.android.gms.panorama.PanoramaApi.C1134a;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

public class kf implements PanoramaApi {

    private static final class C1101a extends C0778a {
        private final C0152d<C1134a> yR;

        public C1101a(C0152d<C1134a> c0152d) {
            this.yR = c0152d;
        }

        public void mo1856a(int i, Bundle bundle, int i2, Intent intent) {
            this.yR.mo911a(new kc(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), intent, i2));
        }
    }

    private static final class C1102c extends C0778a {
        private final C0152d<PanoramaResult> yR;

        public C1102c(C0152d<PanoramaResult> c0152d) {
            this.yR = c0152d;
        }

        public void mo1856a(int i, Bundle bundle, int i2, Intent intent) {
            this.yR.mo911a(new kh(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), intent));
        }
    }

    private static abstract class C1191d<R extends Result> extends C1002b<R, kg> {
        protected C1191d() {
            super(Panorama.yH);
        }

        protected abstract void mo3153a(Context context, ke keVar) throws RemoteException;

        protected final void m4078a(kg kgVar) throws RemoteException {
            mo3153a(kgVar.getContext(), (ke) kgVar.ft());
        }
    }

    class C12491 extends C1191d<C1134a> {
        final /* synthetic */ Uri abk;
        final /* synthetic */ Bundle abl;

        protected void mo3153a(Context context, ke keVar) throws RemoteException {
            kf.m2787a(context, keVar, new C1101a(this), this.abk, this.abl);
        }

        protected C1134a aj(Status status) {
            return new kc(status, null, 0);
        }

        protected /* synthetic */ Result mo2535c(Status status) {
            return aj(status);
        }
    }

    private static abstract class C1250b extends C1191d<PanoramaResult> {
        private C1250b() {
        }

        protected PanoramaResult ak(Status status) {
            return new kh(status, null);
        }

        protected /* synthetic */ Result mo2535c(Status status) {
            return ak(status);
        }
    }

    private static void m2786a(Context context, Uri uri) {
        context.revokeUriPermission(uri, 1);
    }

    private static void m2787a(final Context context, ke keVar, final kd kdVar, final Uri uri, Bundle bundle) throws RemoteException {
        context.grantUriPermission(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE, uri, 1);
        try {
            keVar.mo1857a(new C0778a() {
                public void mo1856a(int i, Bundle bundle, int i2, Intent intent) throws RemoteException {
                    kf.m2786a(context, uri);
                    kdVar.mo1856a(i, bundle, i2, intent);
                }
            }, uri, bundle, true);
        } catch (RemoteException e) {
            m2786a(context, uri);
            throw e;
        } catch (RuntimeException e2) {
            m2786a(context, uri);
            throw e2;
        }
    }

    public PendingResult<PanoramaResult> loadPanoramaInfo(GoogleApiClient client, final Uri uri) {
        return client.mo926a(new C1250b(this) {
            final /* synthetic */ kf abm;

            protected void mo3153a(Context context, ke keVar) throws RemoteException {
                keVar.mo1857a(new C1102c(this), uri, null, false);
            }
        });
    }

    public PendingResult<PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient client, final Uri uri) {
        return client.mo926a(new C1250b(this) {
            final /* synthetic */ kf abm;

            protected void mo3153a(Context context, ke keVar) throws RemoteException {
                kf.m2787a(context, keVar, new C1102c(this), uri, null);
            }
        });
    }
}
