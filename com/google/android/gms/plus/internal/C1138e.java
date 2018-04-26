package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.hb;
import com.google.android.gms.internal.hb.C0345b;
import com.google.android.gms.internal.hb.C0746c;
import com.google.android.gms.internal.hb.C0747d;
import com.google.android.gms.internal.hb.C1092e;
import com.google.android.gms.internal.hb.C1093g;
import com.google.android.gms.internal.hg;
import com.google.android.gms.internal.hi;
import com.google.android.gms.internal.ie;
import com.google.android.gms.internal.kp;
import com.google.android.gms.internal.ks;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.internal.C0432d.C0913a;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class C1138e extends hb<C0432d> {
    private Person abJ;
    private final C0916h abK;

    final class C0914d extends C0345b<C0152d<Status>> {
        final /* synthetic */ C1138e abM;
        private final Status yz;

        public C0914d(C1138e c1138e, C0152d<Status> c0152d, Status status) {
            this.abM = c1138e;
            super(c1138e, c0152d);
            this.yz = status;
        }

        protected /* synthetic */ void mo1128d(Object obj) {
            m2929n((C0152d) obj);
        }

        protected void fu() {
        }

        protected void m2929n(C0152d<Status> c0152d) {
            if (c0152d != null) {
                c0152d.mo911a(this.yz);
            }
        }
    }

    final class C0915h extends C0345b<C0152d<Status>> {
        final /* synthetic */ C1138e abM;
        private final Status yz;

        public C0915h(C1138e c1138e, C0152d<Status> c0152d, Status status) {
            this.abM = c1138e;
            super(c1138e, c0152d);
            this.yz = status;
        }

        protected /* synthetic */ void mo1128d(Object obj) {
            m2931n((C0152d) obj);
        }

        protected void fu() {
        }

        protected void m2931n(C0152d<Status> c0152d) {
            this.abM.disconnect();
            if (c0152d != null) {
                c0152d.mo911a(this.yz);
            }
        }
    }

    final class C1136c extends C0747d<C0152d<LoadMomentsResult>> implements LoadMomentsResult {
        private final String HS;
        final /* synthetic */ C1138e abM;
        private final String abN;
        private MomentBuffer abO;
        private final Status yz;

        public C1136c(C1138e c1138e, C0152d<LoadMomentsResult> c0152d, Status status, DataHolder dataHolder, String str, String str2) {
            this.abM = c1138e;
            super(c1138e, c0152d, dataHolder);
            this.yz = status;
            this.HS = str;
            this.abN = str2;
        }

        protected void m3795a(C0152d<LoadMomentsResult> c0152d, DataHolder dataHolder) {
            this.abO = dataHolder != null ? new MomentBuffer(dataHolder) : null;
            c0152d.mo911a(this);
        }

        public MomentBuffer getMomentBuffer() {
            return this.abO;
        }

        public String getNextPageToken() {
            return this.HS;
        }

        public Status getStatus() {
            return this.yz;
        }

        public String getUpdated() {
            return this.abN;
        }

        public void release() {
            if (this.abO != null) {
                this.abO.close();
            }
        }
    }

    final class C1137f extends C0747d<C0152d<LoadPeopleResult>> implements LoadPeopleResult {
        private final String HS;
        final /* synthetic */ C1138e abM;
        private PersonBuffer abP;
        private final Status yz;

        public C1137f(C1138e c1138e, C0152d<LoadPeopleResult> c0152d, Status status, DataHolder dataHolder, String str) {
            this.abM = c1138e;
            super(c1138e, c0152d, dataHolder);
            this.yz = status;
            this.HS = str;
        }

        protected void m3797a(C0152d<LoadPeopleResult> c0152d, DataHolder dataHolder) {
            this.abP = dataHolder != null ? new PersonBuffer(dataHolder) : null;
            c0152d.mo911a(this);
        }

        public String getNextPageToken() {
            return this.HS;
        }

        public PersonBuffer getPersonBuffer() {
            return this.abP;
        }

        public Status getStatus() {
            return this.yz;
        }

        public void release() {
            if (this.abP != null) {
                this.abP.close();
            }
        }
    }

    final class C1196a extends C1135a {
        private final C0152d<Status> abL;
        final /* synthetic */ C1138e abM;

        public C1196a(C1138e c1138e, C0152d<Status> c0152d) {
            this.abM = c1138e;
            this.abL = c0152d;
        }

        public void am(Status status) {
            this.abM.m2664a(new C0914d(this.abM, this.abL, status));
        }
    }

    final class C1197b extends C1135a {
        private final C0152d<LoadMomentsResult> abL;
        final /* synthetic */ C1138e abM;

        public C1197b(C1138e c1138e, C0152d<LoadMomentsResult> c0152d) {
            this.abM = c1138e;
            this.abL = c0152d;
        }

        public void mo2258a(DataHolder dataHolder, String str, String str2) {
            DataHolder dataHolder2;
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.eU() != null ? (PendingIntent) dataHolder.eU().getParcelable("pendingIntent") : null);
            if (status.isSuccess() || dataHolder == null) {
                dataHolder2 = dataHolder;
            } else {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder2 = null;
            }
            this.abM.m2664a(new C1136c(this.abM, this.abL, status, dataHolder2, str, str2));
        }
    }

    final class C1198e extends C1135a {
        private final C0152d<LoadPeopleResult> abL;
        final /* synthetic */ C1138e abM;

        public C1198e(C1138e c1138e, C0152d<LoadPeopleResult> c0152d) {
            this.abM = c1138e;
            this.abL = c0152d;
        }

        public void mo2257a(DataHolder dataHolder, String str) {
            DataHolder dataHolder2;
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.eU() != null ? (PendingIntent) dataHolder.eU().getParcelable("pendingIntent") : null);
            if (status.isSuccess() || dataHolder == null) {
                dataHolder2 = dataHolder;
            } else {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder2 = null;
            }
            this.abM.m2664a(new C1137f(this.abM, this.abL, status, dataHolder2, str));
        }
    }

    final class C1199g extends C1135a {
        private final C0152d<Status> abL;
        final /* synthetic */ C1138e abM;

        public C1199g(C1138e c1138e, C0152d<Status> c0152d) {
            this.abM = c1138e;
            this.abL = c0152d;
        }

        public void mo2262h(int i, Bundle bundle) {
            this.abM.m2664a(new C0915h(this.abM, this.abL, new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null)));
        }
    }

    public C1138e(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, C0916h c0916h) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, c0916h.jZ());
        this.abK = c0916h;
    }

    @Deprecated
    public C1138e(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, C0916h c0916h) {
        this(context, context.getMainLooper(), new C0746c(connectionCallbacks), new C1093g(onConnectionFailedListener), c0916h);
    }

    public hg m3799a(C0152d<LoadPeopleResult> c0152d, int i, String str) {
        cn();
        Object c1198e = new C1198e(this, c0152d);
        try {
            return ((C0432d) ft()).mo2265a(c1198e, 1, i, -1, str);
        } catch (RemoteException e) {
            c1198e.mo2257a(DataHolder.af(8), null);
            return null;
        }
    }

    protected void mo2551a(int i, IBinder iBinder, Bundle bundle) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.abJ = ks.m3717i(bundle.getByteArray("loaded_person"));
        }
        super.mo2551a(i, iBinder, bundle);
    }

    public void m3801a(C0152d<LoadMomentsResult> c0152d, int i, String str, Uri uri, String str2, String str3) {
        cn();
        Object c1197b = c0152d != null ? new C1197b(this, c0152d) : null;
        try {
            ((C0432d) ft()).mo2268a(c1197b, i, str, uri, str2, str3);
        } catch (RemoteException e) {
            c1197b.mo2258a(DataHolder.af(8), null, null);
        }
    }

    public void m3802a(C0152d<Status> c0152d, Moment moment) {
        cn();
        C0430b c1196a = c0152d != null ? new C1196a(this, c0152d) : null;
        try {
            ((C0432d) ft()).mo2270a(c1196a, ie.m2733a((kp) moment));
        } catch (Throwable e) {
            if (c1196a == null) {
                throw new IllegalStateException(e);
            }
            c1196a.am(new Status(8, null, null));
        }
    }

    public void m3803a(C0152d<LoadPeopleResult> c0152d, Collection<String> collection) {
        cn();
        C0430b c1198e = new C1198e(this, c0152d);
        try {
            ((C0432d) ft()).mo2273a(c1198e, new ArrayList(collection));
        } catch (RemoteException e) {
            c1198e.mo2257a(DataHolder.af(8), null);
        }
    }

    protected void mo2552a(hi hiVar, C1092e c1092e) throws RemoteException {
        Bundle kh = this.abK.kh();
        kh.putStringArray("request_visible_actions", this.abK.ka());
        hiVar.mo1761a(c1092e, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, this.abK.kd(), this.abK.kc(), fs(), this.abK.getAccountName(), kh);
    }

    protected C0432d bn(IBinder iBinder) {
        return C0913a.bm(iBinder);
    }

    protected String bu() {
        return "com.google.android.gms.plus.service.START";
    }

    protected String bv() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    public boolean by(String str) {
        return Arrays.asList(fs()).contains(str);
    }

    public void clearDefaultAccount() {
        cn();
        try {
            this.abJ = null;
            ((C0432d) ft()).clearDefaultAccount();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public void m3805d(C0152d<LoadPeopleResult> c0152d, String[] strArr) {
        m3803a((C0152d) c0152d, Arrays.asList(strArr));
    }

    public String getAccountName() {
        cn();
        try {
            return ((C0432d) ft()).getAccountName();
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public Person getCurrentPerson() {
        cn();
        return this.abJ;
    }

    public void m3806k(C0152d<LoadMomentsResult> c0152d) {
        m3801a(c0152d, 20, null, null, null, "me");
    }

    public void m3807l(C0152d<LoadPeopleResult> c0152d) {
        cn();
        Object c1198e = new C1198e(this, c0152d);
        try {
            ((C0432d) ft()).mo2265a(c1198e, 2, 1, -1, null);
        } catch (RemoteException e) {
            c1198e.mo2257a(DataHolder.af(8), null);
        }
    }

    public void m3808m(C0152d<Status> c0152d) {
        cn();
        clearDefaultAccount();
        Object c1199g = new C1199g(this, c0152d);
        try {
            ((C0432d) ft()).mo2275b(c1199g);
        } catch (RemoteException e) {
            c1199g.mo2262h(8, null);
        }
    }

    public hg m3809r(C0152d<LoadPeopleResult> c0152d, String str) {
        return m3799a((C0152d) c0152d, 0, str);
    }

    public void removeMoment(String momentId) {
        cn();
        try {
            ((C0432d) ft()).removeMoment(momentId);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    protected /* synthetic */ IInterface mo2555x(IBinder iBinder) {
        return bn(iBinder);
    }
}
