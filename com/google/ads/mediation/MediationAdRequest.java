package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest.Gender;
import java.util.Date;
import java.util.Set;

@Deprecated
public final class MediationAdRequest {
    private final Date f6d;
    private final Gender f7e;
    private final Set<String> f8f;
    private final boolean f9g;
    private final Location f10h;

    public MediationAdRequest(Date birthday, Gender gender, Set<String> keywords, boolean isTesting, Location location) {
        this.f6d = birthday;
        this.f7e = gender;
        this.f8f = keywords;
        this.f9g = isTesting;
        this.f10h = location;
    }

    public Integer getAgeInYears() {
        return null;
    }

    public Date getBirthday() {
        return this.f6d;
    }

    public Gender getGender() {
        return this.f7e;
    }

    public Set<String> getKeywords() {
        return this.f8f;
    }

    public Location getLocation() {
        return this.f10h;
    }

    public boolean isTesting() {
        return this.f9g;
    }
}
