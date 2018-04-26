package com.google.android.gms.internal;

import com.google.android.gms.internal.bq.C0275a;
import com.google.android.gms.internal.bv.C0692a;

public final class bo extends C0692a {
    private final Object ls = new Object();
    private C0275a nA;
    private bn nB;

    public void m3489a(bn bnVar) {
        synchronized (this.ls) {
            this.nB = bnVar;
        }
    }

    public void m3490a(C0275a c0275a) {
        synchronized (this.ls) {
            this.nA = c0275a;
        }
    }

    public void onAdClicked() {
        synchronized (this.ls) {
            if (this.nB != null) {
                this.nB.ab();
            }
        }
    }

    public void onAdClosed() {
        synchronized (this.ls) {
            if (this.nB != null) {
                this.nB.ac();
            }
        }
    }

    public void onAdFailedToLoad(int error) {
        synchronized (this.ls) {
            if (this.nA != null) {
                this.nA.mo1610g(error == 3 ? 1 : 2);
                this.nA = null;
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.ls) {
            if (this.nB != null) {
                this.nB.ad();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAdLoaded() {
        /*
        r3 = this;
        r1 = r3.ls;
        monitor-enter(r1);
        r0 = r3.nA;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0012;
    L_0x0007:
        r0 = r3.nA;	 Catch:{ all -> 0x001d }
        r2 = 0;
        r0.mo1610g(r2);	 Catch:{ all -> 0x001d }
        r0 = 0;
        r3.nA = r0;	 Catch:{ all -> 0x001d }
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
    L_0x0011:
        return;
    L_0x0012:
        r0 = r3.nB;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001b;
    L_0x0016:
        r0 = r3.nB;	 Catch:{ all -> 0x001d }
        r0.af();	 Catch:{ all -> 0x001d }
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        goto L_0x0011;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.bo.onAdLoaded():void");
    }

    public void onAdOpened() {
        synchronized (this.ls) {
            if (this.nB != null) {
                this.nB.ae();
            }
        }
    }
}
