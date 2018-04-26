package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class eg {
    private final Object ls;
    private boolean qO;
    private final eh rD;
    private final LinkedList<C0308a> rE;
    private final String rF;
    private final String rG;
    private long rH;
    private long rI;
    private long rJ;
    private long rK;
    private long rL;
    private long rM;

    private static final class C0308a {
        private long rN = -1;
        private long rO = -1;

        public long bE() {
            return this.rO;
        }

        public void bF() {
            this.rO = SystemClock.elapsedRealtime();
        }

        public void bG() {
            this.rN = SystemClock.elapsedRealtime();
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong("topen", this.rN);
            bundle.putLong("tclose", this.rO);
            return bundle;
        }
    }

    public eg(eh ehVar, String str, String str2) {
        this.ls = new Object();
        this.rH = -1;
        this.rI = -1;
        this.qO = false;
        this.rJ = -1;
        this.rK = 0;
        this.rL = -1;
        this.rM = -1;
        this.rD = ehVar;
        this.rF = str;
        this.rG = str2;
        this.rE = new LinkedList();
    }

    public eg(String str, String str2) {
        this(eh.bH(), str, str2);
    }

    public void bB() {
        synchronized (this.ls) {
            if (this.rM != -1 && this.rI == -1) {
                this.rI = SystemClock.elapsedRealtime();
                this.rD.m957a(this);
            }
            eh ehVar = this.rD;
            eh.bK().bB();
        }
    }

    public void bC() {
        synchronized (this.ls) {
            if (this.rM != -1) {
                C0308a c0308a = new C0308a();
                c0308a.bG();
                this.rE.add(c0308a);
                this.rK++;
                eh ehVar = this.rD;
                eh.bK().bC();
                this.rD.m957a(this);
            }
        }
    }

    public void bD() {
        synchronized (this.ls) {
            if (!(this.rM == -1 || this.rE.isEmpty())) {
                C0308a c0308a = (C0308a) this.rE.getLast();
                if (c0308a.bE() == -1) {
                    c0308a.bF();
                    this.rD.m957a(this);
                }
            }
        }
    }

    public void m950f(ai aiVar) {
        synchronized (this.ls) {
            this.rL = SystemClock.elapsedRealtime();
            eh ehVar = this.rD;
            eh.bK().m963b(aiVar, this.rL);
        }
    }

    public void m951j(long j) {
        synchronized (this.ls) {
            this.rM = j;
            if (this.rM != -1) {
                this.rD.m957a(this);
            }
        }
    }

    public void m952k(long j) {
        synchronized (this.ls) {
            if (this.rM != -1) {
                this.rH = j;
                this.rD.m957a(this);
            }
        }
    }

    public void m953n(boolean z) {
        synchronized (this.ls) {
            if (this.rM != -1) {
                this.rJ = SystemClock.elapsedRealtime();
                if (!z) {
                    this.rI = this.rJ;
                    this.rD.m957a(this);
                }
            }
        }
    }

    public void m954o(boolean z) {
        synchronized (this.ls) {
            if (this.rM != -1) {
                this.qO = z;
                this.rD.m957a(this);
            }
        }
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.ls) {
            bundle = new Bundle();
            bundle.putString("seqnum", this.rF);
            bundle.putString("slotid", this.rG);
            bundle.putBoolean("ismediation", this.qO);
            bundle.putLong("treq", this.rL);
            bundle.putLong("tresponse", this.rM);
            bundle.putLong("timp", this.rI);
            bundle.putLong("tload", this.rJ);
            bundle.putLong("pcc", this.rK);
            bundle.putLong("tfetch", this.rH);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.rE.iterator();
            while (it.hasNext()) {
                arrayList.add(((C0308a) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }
}
