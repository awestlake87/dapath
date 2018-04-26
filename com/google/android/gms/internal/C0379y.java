package com.google.android.gms.internal;

import android.os.Handler;
import java.lang.ref.WeakReference;

public final class C0379y {
    private final C0378a lf;
    private final Runnable lg;
    private ai lh;
    private boolean li;
    private boolean lj;
    private long lk;

    public static class C0378a {
        private final Handler mHandler;

        public C0378a(Handler handler) {
            this.mHandler = handler;
        }

        public boolean postDelayed(Runnable runnable, long timeFromNowInMillis) {
            return this.mHandler.postDelayed(runnable, timeFromNowInMillis);
        }

        public void removeCallbacks(Runnable runnable) {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    public C0379y(C1119u c1119u) {
        this(c1119u, new C0378a(et.sv));
    }

    C0379y(final C1119u c1119u, C0378a c0378a) {
        this.li = false;
        this.lj = false;
        this.lk = 0;
        this.lf = c0378a;
        this.lg = new Runnable(this) {
            private final WeakReference<C1119u> ll = new WeakReference(c1119u);
            final /* synthetic */ C0379y ln;

            public void run() {
                this.ln.li = false;
                C1119u c1119u = (C1119u) this.ll.get();
                if (c1119u != null) {
                    c1119u.m3776b(this.ln.lh);
                }
            }
        };
    }

    public void m1472a(ai aiVar, long j) {
        if (this.li) {
            eu.m1014D("An ad refresh is already scheduled.");
            return;
        }
        this.lh = aiVar;
        this.li = true;
        this.lk = j;
        if (!this.lj) {
            eu.m1012B("Scheduling ad refresh " + j + " milliseconds from now.");
            this.lf.postDelayed(this.lg, j);
        }
    }

    public void cancel() {
        this.li = false;
        this.lf.removeCallbacks(this.lg);
    }

    public void m1473d(ai aiVar) {
        m1472a(aiVar, 60000);
    }

    public void pause() {
        this.lj = true;
        if (this.li) {
            this.lf.removeCallbacks(this.lg);
        }
    }

    public void resume() {
        this.lj = false;
        if (this.li) {
            this.li = false;
            m1472a(this.lh, this.lk);
        }
    }
}
