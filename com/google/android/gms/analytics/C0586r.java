package com.google.android.gms.analytics;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.google.android.gms.analytics.C0138u.C0137a;

class C0586r extends af {
    private static final Object tT = new Object();
    private static C0586r uf;
    private Context mContext;
    private Handler mHandler;
    private C0112d tU;
    private volatile C0114f tV;
    private int tW = 1800;
    private boolean tX = true;
    private boolean tY;
    private String tZ;
    private boolean ua = true;
    private boolean ub = true;
    private C0113e uc = new C05851(this);
    private C0124q ud;
    private boolean ue = false;

    class C01252 implements Callback {
        final /* synthetic */ C0586r ug;

        C01252(C0586r c0586r) {
            this.ug = c0586r;
        }

        public boolean handleMessage(Message msg) {
            if (1 == msg.what && C0586r.tT.equals(msg.obj)) {
                C0138u.cU().m84u(true);
                this.ug.dispatchLocalHits();
                C0138u.cU().m84u(false);
                if (this.ug.tW > 0 && !this.ug.ue) {
                    this.ug.mHandler.sendMessageDelayed(this.ug.mHandler.obtainMessage(1, C0586r.tT), (long) (this.ug.tW * 1000));
                }
            }
            return true;
        }
    }

    class C05851 implements C0113e {
        final /* synthetic */ C0586r ug;

        C05851(C0586r c0586r) {
            this.ug = c0586r;
        }

        public void mo860s(boolean z) {
            this.ug.m1924a(z, this.ug.ua);
        }
    }

    private C0586r() {
    }

    public static C0586r cE() {
        if (uf == null) {
            uf = new C0586r();
        }
        return uf;
    }

    private void cF() {
        this.ud = new C0124q(this);
        this.ud.m82v(this.mContext);
    }

    private void cG() {
        this.mHandler = new Handler(this.mContext.getMainLooper(), new C01252(this));
        if (this.tW > 0) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, tT), (long) (this.tW * 1000));
        }
    }

    synchronized void m1923a(Context context, C0114f c0114f) {
        if (this.mContext == null) {
            this.mContext = context.getApplicationContext();
            if (this.tV == null) {
                this.tV = c0114f;
                if (this.tX) {
                    dispatchLocalHits();
                    this.tX = false;
                }
                if (this.tY) {
                    cs();
                    this.tY = false;
                }
            }
        }
    }

    synchronized void m1924a(boolean z, boolean z2) {
        if (!(this.ue == z && this.ua == z2)) {
            if (z || !z2) {
                if (this.tW > 0) {
                    this.mHandler.removeMessages(1, tT);
                }
            }
            if (!z && z2 && this.tW > 0) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, tT), (long) (this.tW * 1000));
            }
            StringBuilder append = new StringBuilder().append("PowerSaveMode ");
            String str = (z || !z2) ? "initiated." : "terminated.";
            aa.m39C(append.append(str).toString());
            this.ue = z;
            this.ua = z2;
        }
    }

    synchronized C0112d cH() {
        if (this.tU == null) {
            if (this.mContext == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.tU = new ac(this.uc, this.mContext);
            if (this.tZ != null) {
                this.tU.cr().mo841M(this.tZ);
                this.tZ = null;
            }
        }
        if (this.mHandler == null) {
            cG();
        }
        if (this.ud == null && this.ub) {
            cF();
        }
        return this.tU;
    }

    synchronized void cI() {
        if (!this.ue && this.ua && this.tW > 0) {
            this.mHandler.removeMessages(1, tT);
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, tT));
        }
    }

    void cs() {
        if (this.tV == null) {
            aa.m39C("setForceLocalDispatch() queued. It will be called once initialization is complete.");
            this.tY = true;
            return;
        }
        C0138u.cU().m83a(C0137a.SET_FORCE_LOCAL_DISPATCH);
        this.tV.cs();
    }

    synchronized void dispatchLocalHits() {
        if (this.tV == null) {
            aa.m39C("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.tX = true;
        } else {
            C0138u.cU().m83a(C0137a.DISPATCH);
            this.tV.cq();
        }
    }

    synchronized void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        if (this.mHandler == null) {
            aa.m39C("Dispatch period set with null handler. Dispatch will run once initialization is complete.");
            this.tW = dispatchPeriodInSeconds;
        } else {
            C0138u.cU().m83a(C0137a.SET_DISPATCH_PERIOD);
            if (!this.ue && this.ua && this.tW > 0) {
                this.mHandler.removeMessages(1, tT);
            }
            this.tW = dispatchPeriodInSeconds;
            if (dispatchPeriodInSeconds > 0 && !this.ue && this.ua) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, tT), (long) (dispatchPeriodInSeconds * 1000));
            }
        }
    }

    synchronized void mo864t(boolean z) {
        m1924a(this.ue, z);
    }
}
