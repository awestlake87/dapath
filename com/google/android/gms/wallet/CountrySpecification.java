package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public class CountrySpecification implements SafeParcelable {
    public static final Creator<CountrySpecification> CREATOR = new C0500c();
    String rf;
    private final int xM;

    CountrySpecification(int versionCode, String countryCode) {
        this.xM = versionCode;
        this.rf = countryCode;
    }

    public CountrySpecification(String countryCode) {
        this.xM = 1;
        this.rf = countryCode;
    }

    public int describeContents() {
        return 0;
    }

    public String getCountryCode() {
        return this.rf;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0500c.m1752a(this, dest, flags);
    }
}
