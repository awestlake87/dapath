package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Api.C0147a;
import com.google.android.gms.common.api.Api.C0149c;
import com.google.android.gms.common.api.C0607c.C0154a;
import com.google.android.gms.common.api.C0607c.C0156c;
import com.google.android.gms.common.api.PendingResult.C0150a;
import com.google.android.gms.internal.hg;
import com.google.android.gms.internal.hm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class C0153a {

    public static class C0151c<R extends Result> extends Handler {
        public C0151c() {
            this(Looper.getMainLooper());
        }

        public C0151c(Looper looper) {
            super(looper);
        }

        public void m151a(ResultCallback<R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void m152a(C0602a<R> c0602a, long j) {
            sendMessageDelayed(obtainMessage(2, c0602a), j);
        }

        protected void m153b(ResultCallback<R> resultCallback, R r) {
            try {
                resultCallback.onResult(r);
            } catch (RuntimeException e) {
                C0153a.m155a(r);
                throw e;
            }
        }

        public void eH() {
            removeMessages(2);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    m153b((ResultCallback) pair.first, (Result) pair.second);
                    return;
                case 2:
                    ((C0602a) msg.obj).eF();
                    return;
                default:
                    Log.wtf("GoogleApi", "Don't know how to handle this message.");
                    return;
            }
        }
    }

    public interface C0152d<R> {
        void mo911a(R r);
    }

    public static abstract class C0602a<R extends Result> implements PendingResult<R>, C0152d<R> {
        private final Object Dp = new Object();
        private C0151c<R> Dq;
        private final ArrayList<C0150a> Dr = new ArrayList();
        private ResultCallback<R> Ds;
        private volatile R Dt;
        private volatile boolean Du;
        private boolean Dv;
        private boolean Dw;
        private hg Dx;
        private final CountDownLatch kK = new CountDownLatch(1);

        C0602a() {
        }

        public C0602a(Looper looper) {
            this.Dq = new C0151c(looper);
        }

        public C0602a(C0151c<R> c0151c) {
            this.Dq = c0151c;
        }

        private void m1979c(R r) {
            this.Dt = r;
            this.Dx = null;
            this.kK.countDown();
            Status status = this.Dt.getStatus();
            if (this.Ds != null) {
                this.Dq.eH();
                if (!this.Dv) {
                    this.Dq.m151a(this.Ds, eC());
                }
            }
            Iterator it = this.Dr.iterator();
            while (it.hasNext()) {
                ((C0150a) it.next()).mo907n(status);
            }
            this.Dr.clear();
        }

        private R eC() {
            R r;
            synchronized (this.Dp) {
                hm.m1226a(!this.Du, "Result has already been consumed.");
                hm.m1226a(isReady(), "Result is not ready.");
                r = this.Dt;
                eD();
            }
            return r;
        }

        private void eE() {
            synchronized (this.Dp) {
                if (!isReady()) {
                    m1984b(mo2535c(Status.Eo));
                    this.Dw = true;
                }
            }
        }

        private void eF() {
            synchronized (this.Dp) {
                if (!isReady()) {
                    m1984b(mo2535c(Status.Eq));
                    this.Dw = true;
                }
            }
        }

        public final void mo910a(C0150a c0150a) {
            hm.m1226a(!this.Du, "Result has already been consumed.");
            synchronized (this.Dp) {
                if (isReady()) {
                    c0150a.mo907n(this.Dt.getStatus());
                } else {
                    this.Dr.add(c0150a);
                }
            }
        }

        protected void m1981a(C0151c<R> c0151c) {
            this.Dq = c0151c;
        }

        protected final void m1982a(hg hgVar) {
            synchronized (this.Dp) {
                this.Dx = hgVar;
            }
        }

        public /* synthetic */ void mo911a(Object obj) {
            m1984b((Result) obj);
        }

        public final R await() {
            boolean z = true;
            hm.m1226a(Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread");
            if (this.Du) {
                z = false;
            }
            hm.m1226a(z, "Result has already been consumed");
            try {
                this.kK.await();
            } catch (InterruptedException e) {
                eE();
            }
            hm.m1226a(isReady(), "Result is not ready.");
            return eC();
        }

        public final R await(long time, TimeUnit units) {
            boolean z = true;
            boolean z2 = time <= 0 || Looper.myLooper() != Looper.getMainLooper();
            hm.m1226a(z2, "await must not be called on the UI thread when time is greater than zero.");
            if (this.Du) {
                z = false;
            }
            hm.m1226a(z, "Result has already been consumed.");
            try {
                if (!this.kK.await(time, units)) {
                    eF();
                }
            } catch (InterruptedException e) {
                eE();
            }
            hm.m1226a(isReady(), "Result is not ready.");
            return eC();
        }

        public final void m1984b(R r) {
            boolean z = true;
            synchronized (this.Dp) {
                if (this.Dw || this.Dv) {
                    C0153a.m155a(r);
                    return;
                }
                hm.m1226a(!isReady(), "Results have already been set");
                if (this.Du) {
                    z = false;
                }
                hm.m1226a(z, "Result has already been consumed");
                m1979c((Result) r);
            }
        }

        protected abstract R mo2535c(Status status);

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void cancel() {
            /*
            r2 = this;
            r1 = r2.Dp;
            monitor-enter(r1);
            r0 = r2.Dv;	 Catch:{ all -> 0x002c }
            if (r0 != 0) goto L_0x000b;
        L_0x0007:
            r0 = r2.Du;	 Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x000d;
        L_0x000b:
            monitor-exit(r1);	 Catch:{ all -> 0x002c }
        L_0x000c:
            return;
        L_0x000d:
            r0 = r2.Dx;	 Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x0016;
        L_0x0011:
            r0 = r2.Dx;	 Catch:{ RemoteException -> 0x002f }
            r0.cancel();	 Catch:{ RemoteException -> 0x002f }
        L_0x0016:
            r0 = r2.Dt;	 Catch:{ all -> 0x002c }
            com.google.android.gms.common.api.C0153a.m155a(r0);	 Catch:{ all -> 0x002c }
            r0 = 0;
            r2.Ds = r0;	 Catch:{ all -> 0x002c }
            r0 = 1;
            r2.Dv = r0;	 Catch:{ all -> 0x002c }
            r0 = com.google.android.gms.common.api.Status.Er;	 Catch:{ all -> 0x002c }
            r0 = r2.mo2535c(r0);	 Catch:{ all -> 0x002c }
            r2.m1979c(r0);	 Catch:{ all -> 0x002c }
            monitor-exit(r1);	 Catch:{ all -> 0x002c }
            goto L_0x000c;
        L_0x002c:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x002c }
            throw r0;
        L_0x002f:
            r0 = move-exception;
            goto L_0x0016;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.a.a.cancel():void");
        }

        protected void eD() {
            this.Du = true;
            this.Dt = null;
            this.Ds = null;
        }

        public boolean isCanceled() {
            boolean z;
            synchronized (this.Dp) {
                z = this.Dv;
            }
            return z;
        }

        public final boolean isReady() {
            return this.kK.getCount() == 0;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<R> r4) {
            /*
            r3 = this;
            r0 = r3.Du;
            if (r0 != 0) goto L_0x0015;
        L_0x0004:
            r0 = 1;
        L_0x0005:
            r1 = "Result has already been consumed.";
            com.google.android.gms.internal.hm.m1226a(r0, r1);
            r1 = r3.Dp;
            monitor-enter(r1);
            r0 = r3.isCanceled();	 Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0017;
        L_0x0013:
            monitor-exit(r1);	 Catch:{ all -> 0x0028 }
        L_0x0014:
            return;
        L_0x0015:
            r0 = 0;
            goto L_0x0005;
        L_0x0017:
            r0 = r3.isReady();	 Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x002b;
        L_0x001d:
            r0 = r3.Dq;	 Catch:{ all -> 0x0028 }
            r2 = r3.eC();	 Catch:{ all -> 0x0028 }
            r0.m151a(r4, r2);	 Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r1);	 Catch:{ all -> 0x0028 }
            goto L_0x0014;
        L_0x0028:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0028 }
            throw r0;
        L_0x002b:
            r3.Ds = r4;	 Catch:{ all -> 0x0028 }
            goto L_0x0026;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.a.a.setResultCallback(com.google.android.gms.common.api.ResultCallback):void");
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<R> r5, long r6, java.util.concurrent.TimeUnit r8) {
            /*
            r4 = this;
            r0 = r4.Du;
            if (r0 != 0) goto L_0x0015;
        L_0x0004:
            r0 = 1;
        L_0x0005:
            r1 = "Result has already been consumed.";
            com.google.android.gms.internal.hm.m1226a(r0, r1);
            r1 = r4.Dp;
            monitor-enter(r1);
            r0 = r4.isCanceled();	 Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0017;
        L_0x0013:
            monitor-exit(r1);	 Catch:{ all -> 0x0028 }
        L_0x0014:
            return;
        L_0x0015:
            r0 = 0;
            goto L_0x0005;
        L_0x0017:
            r0 = r4.isReady();	 Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x002b;
        L_0x001d:
            r0 = r4.Dq;	 Catch:{ all -> 0x0028 }
            r2 = r4.eC();	 Catch:{ all -> 0x0028 }
            r0.m151a(r5, r2);	 Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r1);	 Catch:{ all -> 0x0028 }
            goto L_0x0014;
        L_0x0028:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0028 }
            throw r0;
        L_0x002b:
            r4.Ds = r5;	 Catch:{ all -> 0x0028 }
            r0 = r4.Dq;	 Catch:{ all -> 0x0028 }
            r2 = r8.toMillis(r6);	 Catch:{ all -> 0x0028 }
            r0.m152a(r4, r2);	 Catch:{ all -> 0x0028 }
            goto L_0x0026;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.a.a.setResultCallback(com.google.android.gms.common.api.ResultCallback, long, java.util.concurrent.TimeUnit):void");
        }
    }

    public static abstract class C1002b<R extends Result, A extends C0147a> extends C0602a<R> implements C0156c<A> {
        private final C0149c<A> Dn;
        private C0154a Dy;

        protected C1002b(C0149c<A> c0149c) {
            this.Dn = (C0149c) hm.m1232f(c0149c);
        }

        private void m3187a(RemoteException remoteException) {
            mo2541m(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        protected abstract void mo3144a(A a) throws RemoteException;

        public void mo2536a(C0154a c0154a) {
            this.Dy = c0154a;
        }

        public final void mo2537b(A a) throws DeadObjectException {
            m1981a(new C0151c(a.getLooper()));
            try {
                mo3144a((C0147a) a);
            } catch (RemoteException e) {
                m3187a(e);
                throw e;
            } catch (RemoteException e2) {
                m3187a(e2);
            }
        }

        public final C0149c<A> eB() {
            return this.Dn;
        }

        protected void eD() {
            super.eD();
            if (this.Dy != null) {
                this.Dy.mo919b(this);
                this.Dy = null;
            }
        }

        public int eG() {
            return 0;
        }

        public final void mo2541m(Status status) {
            hm.m1230b(!status.isSuccess(), (Object) "Failed result must not be success");
            m1984b(mo2535c(status));
        }
    }

    static void m155a(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (Throwable e) {
                Log.w("GoogleApi", "Unable to release " + result, e);
            }
        }
    }
}
