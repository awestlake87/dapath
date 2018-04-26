package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.at;
import com.google.android.gms.internal.at.C0271a;
import com.google.android.gms.internal.hm;
import java.util.Date;
import java.util.Set;

public final class AdRequest {
    public static final String DEVICE_ID_EMULATOR = at.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    public static final int MAX_CONTENT_URL_LENGTH = 512;
    private final at ks;

    public static final class Builder {
        private final C0271a kt = new C0271a();

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> adapterClass, Bundle customEventExtras) {
            this.kt.m813b(adapterClass, customEventExtras);
            return this;
        }

        public Builder addKeyword(String keyword) {
            this.kt.m815g(keyword);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.kt.m810a(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> adapterClass, Bundle networkExtras) {
            this.kt.m811a(adapterClass, networkExtras);
            return this;
        }

        public Builder addTestDevice(String deviceId) {
            this.kt.m817h(deviceId);
            return this;
        }

        public AdRequest build() {
            return new AdRequest();
        }

        public Builder setBirthday(Date birthday) {
            this.kt.m812a(birthday);
            return this;
        }

        public Builder setContentUrl(String contentUrl) {
            hm.m1228b((Object) contentUrl, (Object) "Content URL must be non-null.");
            hm.m1229b(contentUrl, (Object) "Content URL must be non-empty.");
            hm.m1231b(contentUrl.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", Integer.valueOf(512), Integer.valueOf(contentUrl.length()));
            this.kt.m819i(contentUrl);
            return this;
        }

        public Builder setGender(int gender) {
            this.kt.m814e(gender);
            return this;
        }

        public Builder setLocation(Location location) {
            this.kt.m809a(location);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean tagForChildDirectedTreatment) {
            this.kt.m818h(tagForChildDirectedTreatment);
            return this;
        }
    }

    private AdRequest(Builder builder) {
        this.ks = new at(builder.kt);
    }

    at m9T() {
        return this.ks;
    }

    public Date getBirthday() {
        return this.ks.getBirthday();
    }

    public String getContentUrl() {
        return this.ks.getContentUrl();
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> adapterClass) {
        return this.ks.getCustomEventExtrasBundle(adapterClass);
    }

    public int getGender() {
        return this.ks.getGender();
    }

    public Set<String> getKeywords() {
        return this.ks.getKeywords();
    }

    public Location getLocation() {
        return this.ks.getLocation();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> networkExtrasClass) {
        return this.ks.getNetworkExtras(networkExtrasClass);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> adapterClass) {
        return this.ks.getNetworkExtrasBundle(adapterClass);
    }

    public boolean isTestDevice(Context context) {
        return this.ks.isTestDevice(context);
    }
}
