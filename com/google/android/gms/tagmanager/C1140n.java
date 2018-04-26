package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.ContainerHolder.ContainerAvailableListener;

class C1140n implements ContainerHolder {
    private final Looper DF;
    private boolean Ip;
    private Container aeB;
    private Container aeC;
    private C0482b aeD;
    private C0481a aeE;
    private TagManager aeF;
    private Status yz;

    public interface C0481a {
        void bJ(String str);

        String lo();

        void lq();
    }

    private class C0482b extends Handler {
        private final ContainerAvailableListener aeG;
        final /* synthetic */ C1140n aeH;

        public C0482b(C1140n c1140n, ContainerAvailableListener containerAvailableListener, Looper looper) {
            this.aeH = c1140n;
            super(looper);
            this.aeG = containerAvailableListener;
        }

        public void bK(String str) {
            sendMessage(obtainMessage(1, str));
        }

        protected void bL(String str) {
            this.aeG.onContainerAvailable(this.aeH, str);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    bL((String) msg.obj);
                    return;
                default:
                    bh.m1642A("Don't know how to handle this message.");
                    return;
            }
        }
    }

    public C1140n(Status status) {
        this.yz = status;
        this.DF = null;
    }

    public C1140n(TagManager tagManager, Looper looper, Container container, C0481a c0481a) {
        this.aeF = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.DF = looper;
        this.aeB = container;
        this.aeE = c0481a;
        this.yz = Status.En;
        tagManager.m1614a(this);
    }

    private void lp() {
        if (this.aeD != null) {
            this.aeD.bK(this.aeC.lm());
        }
    }

    public synchronized void m3833a(Container container) {
        if (!this.Ip) {
            if (container == null) {
                bh.m1642A("Unexpected null container.");
            } else {
                this.aeC = container;
                lp();
            }
        }
    }

    public synchronized void bH(String str) {
        if (!this.Ip) {
            this.aeB.bH(str);
        }
    }

    void bJ(String str) {
        if (this.Ip) {
            bh.m1642A("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.aeE.bJ(str);
        }
    }

    public synchronized Container getContainer() {
        Container container = null;
        synchronized (this) {
            if (this.Ip) {
                bh.m1642A("ContainerHolder is released.");
            } else {
                if (this.aeC != null) {
                    this.aeB = this.aeC;
                    this.aeC = null;
                }
                container = this.aeB;
            }
        }
        return container;
    }

    String getContainerId() {
        if (!this.Ip) {
            return this.aeB.getContainerId();
        }
        bh.m1642A("getContainerId called on a released ContainerHolder.");
        return "";
    }

    public Status getStatus() {
        return this.yz;
    }

    String lo() {
        if (!this.Ip) {
            return this.aeE.lo();
        }
        bh.m1642A("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return "";
    }

    public synchronized void refresh() {
        if (this.Ip) {
            bh.m1642A("Refreshing a released ContainerHolder.");
        } else {
            this.aeE.lq();
        }
    }

    public synchronized void release() {
        if (this.Ip) {
            bh.m1642A("Releasing a released ContainerHolder.");
        } else {
            this.Ip = true;
            this.aeF.m1615b(this);
            this.aeB.release();
            this.aeB = null;
            this.aeC = null;
            this.aeE = null;
            this.aeD = null;
        }
    }

    public synchronized void setContainerAvailableListener(ContainerAvailableListener listener) {
        if (this.Ip) {
            bh.m1642A("ContainerHolder is released.");
        } else if (listener == null) {
            this.aeD = null;
        } else {
            this.aeD = new C0482b(this, listener, this.DF);
            if (this.aeC != null) {
                lp();
            }
        }
    }
}
