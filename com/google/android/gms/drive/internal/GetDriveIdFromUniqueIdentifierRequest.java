package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetDriveIdFromUniqueIdentifierRequest implements SafeParcelable {
    public static final Creator<GetDriveIdFromUniqueIdentifierRequest> CREATOR = new C0198y();
    final String Jp;
    final boolean Jq;
    final int xM;

    GetDriveIdFromUniqueIdentifierRequest(int versionCode, String uniqueIdentifier, boolean isInAppFolder) {
        this.xM = versionCode;
        this.Jp = uniqueIdentifier;
        this.Jq = isInAppFolder;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0198y.m360a(this, dest, flags);
    }
}
