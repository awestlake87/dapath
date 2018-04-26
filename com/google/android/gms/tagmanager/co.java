package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.C0276c.C1081j;
import com.google.android.gms.tagmanager.C1141o.C0949e;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class co implements C0949e {
    private String aeP;
    private final String aet;
    private bg<C1081j> agN;
    private C0484r agO;
    private final ScheduledExecutorService agQ;
    private final C0457a agR;
    private ScheduledFuture<?> agS;
    private boolean mClosed;
    private final Context mContext;

    interface C0457a {
        cn mo2337a(C0484r c0484r);
    }

    interface C0458b {
        ScheduledExecutorService mk();
    }

    class C09281 implements C0458b {
        final /* synthetic */ co agT;

        C09281(co coVar) {
            this.agT = coVar;
        }

        public ScheduledExecutorService mk() {
            return Executors.newSingleThreadScheduledExecutor();
        }
    }

    class C09292 implements C0457a {
        final /* synthetic */ co agT;

        C09292(co coVar) {
            this.agT = coVar;
        }

        public cn mo2337a(C0484r c0484r) {
            return new cn(this.agT.mContext, this.agT.aet, c0484r);
        }
    }

    public co(Context context, String str, C0484r c0484r) {
        this(context, str, c0484r, null, null);
    }

    co(Context context, String str, C0484r c0484r, C0458b c0458b, C0457a c0457a) {
        this.agO = c0484r;
        this.mContext = context;
        this.aet = str;
        if (c0458b == null) {
            c0458b = new C09281(this);
        }
        this.agQ = c0458b.mk();
        if (c0457a == null) {
            this.agR = new C09292(this);
        } else {
            this.agR = c0457a;
        }
    }

    private cn cc(String str) {
        cn a = this.agR.mo2337a(this.agO);
        a.m1667a(this.agN);
        a.bM(this.aeP);
        a.cb(str);
        return a;
    }

    private synchronized void mj() {
        if (this.mClosed) {
            throw new IllegalStateException("called method after closed");
        }
    }

    public synchronized void mo3104a(bg<C1081j> bgVar) {
        mj();
        this.agN = bgVar;
    }

    public synchronized void bM(String str) {
        mj();
        this.aeP = str;
    }

    public synchronized void mo3106e(long j, String str) {
        bh.m1644C("loadAfterDelay: containerId=" + this.aet + " delay=" + j);
        mj();
        if (this.agN == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        if (this.agS != null) {
            this.agS.cancel(false);
        }
        this.agS = this.agQ.schedule(cc(str), j, TimeUnit.MILLISECONDS);
    }

    public synchronized void release() {
        mj();
        if (this.agS != null) {
            this.agS.cancel(false);
        }
        this.agQ.shutdown();
        this.mClosed = true;
    }
}
