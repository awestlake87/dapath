package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.C0148b;
import com.google.android.gms.common.api.Api.C0149c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.internal.C0621p;
import com.google.android.gms.drive.internal.C0622t;
import com.google.android.gms.drive.internal.C0624w;
import com.google.android.gms.drive.internal.C1015r;
import com.google.android.gms.internal.gy;
import java.util.List;

public final class Drive {
    public static final Api<NoOptions> API = new Api(new C10071(), yH, new Scope[0]);
    public static final DriveApi DriveApi = new C0621p();
    public static final Scope HH = new Scope("https://www.googleapis.com/auth/drive");
    public static final Scope HI = new Scope("https://www.googleapis.com/auth/drive.apps");
    public static final Api<C1162b> HJ = new Api(new C10082(), yH, new Scope[0]);
    public static final C0175b HK = new C0622t();
    public static final C0177d HL = new C0624w();
    public static final Scope SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
    public static final Scope SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);
    public static final C0149c<C1015r> yH = new C0149c();

    public static abstract class C0614a<O extends ApiOptions> implements C0148b<C1015r, O> {
        protected abstract Bundle mo2543a(O o);

        public C1015r m2029a(Context context, Looper looper, gy gyVar, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            List fl = gyVar.fl();
            return new C1015r(context, looper, gyVar, connectionCallbacks, onConnectionFailedListener, (String[]) fl.toArray(new String[fl.size()]), mo2543a(o));
        }

        public int getPriority() {
            return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    static class C10071 extends C0614a<NoOptions> {
        C10071() {
        }

        protected Bundle m3194a(NoOptions noOptions) {
            return new Bundle();
        }
    }

    static class C10082 extends C0614a<C1162b> {
        C10082() {
        }

        protected Bundle m3197a(C1162b c1162b) {
            return c1162b == null ? new Bundle() : c1162b.gj();
        }
    }

    public static class C1162b implements Optional {
        private final Bundle HM;

        private C1162b() {
            this(new Bundle());
        }

        private C1162b(Bundle bundle) {
            this.HM = bundle;
        }

        public Bundle gj() {
            return this.HM;
        }
    }

    private Drive() {
    }
}
