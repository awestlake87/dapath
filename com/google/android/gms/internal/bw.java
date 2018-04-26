package com.google.android.gms.internal;

import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

public final class bw implements MediationAdRequest {
    private final Date f73d;
    private final Set<String> f74f;
    private final boolean f75g;
    private final int ml;
    private final int nR;

    public bw(Date date, int i, Set<String> set, boolean z, int i2) {
        this.f73d = date;
        this.ml = i;
        this.f74f = set;
        this.f75g = z;
        this.nR = i2;
    }

    public Date getBirthday() {
        return this.f73d;
    }

    public int getGender() {
        return this.ml;
    }

    public Set<String> getKeywords() {
        return this.f74f;
    }

    public boolean isTesting() {
        return this.f75g;
    }

    public int taggedForChildDirectedTreatment() {
        return this.nR;
    }
}
