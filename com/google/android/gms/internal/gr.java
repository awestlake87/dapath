package com.google.android.gms.internal;

import android.os.SystemClock;
import org.json.JSONObject;

public final class gr {
    private static final gn BG = new gn("RequestTracker");
    public static final Object CN = new Object();
    private long CJ;
    private long CK = -1;
    private long CL = 0;
    private gq CM;

    public gr(long j) {
        this.CJ = j;
    }

    private void eu() {
        this.CK = -1;
        this.CM = null;
        this.CL = 0;
    }

    public void m1145a(long j, gq gqVar) {
        synchronized (CN) {
            gq gqVar2 = this.CM;
            long j2 = this.CK;
            this.CK = j;
            this.CM = gqVar;
            this.CL = SystemClock.elapsedRealtime();
        }
        if (gqVar2 != null) {
            gqVar2.mo905n(j2);
        }
    }

    public boolean m1146b(long j, int i, JSONObject jSONObject) {
        boolean z = true;
        gq gqVar = null;
        synchronized (CN) {
            if (this.CK == -1 || this.CK != j) {
                z = false;
            } else {
                BG.m1139b("request %d completed", Long.valueOf(this.CK));
                gqVar = this.CM;
                eu();
            }
        }
        if (gqVar != null) {
            gqVar.mo904a(j, i, jSONObject);
        }
        return z;
    }

    public boolean m1147c(long j, int i) {
        return m1146b(j, i, null);
    }

    public void clear() {
        synchronized (CN) {
            if (this.CK != -1) {
                eu();
            }
        }
    }

    public boolean m1148d(long j, int i) {
        gq gqVar;
        boolean z = true;
        long j2 = 0;
        synchronized (CN) {
            if (this.CK == -1 || j - this.CL < this.CJ) {
                z = false;
                gqVar = null;
            } else {
                BG.m1139b("request %d timed out", Long.valueOf(this.CK));
                j2 = this.CK;
                gqVar = this.CM;
                eu();
            }
        }
        if (gqVar != null) {
            gqVar.mo904a(j2, i, null);
        }
        return z;
    }

    public boolean ev() {
        boolean z;
        synchronized (CN) {
            z = this.CK != -1;
        }
        return z;
    }

    public boolean m1149p(long j) {
        boolean z;
        synchronized (CN) {
            z = this.CK != -1 && this.CK == j;
        }
        return z;
    }
}
