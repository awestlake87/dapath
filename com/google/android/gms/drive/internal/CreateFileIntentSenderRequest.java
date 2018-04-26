package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileIntentSenderRequest implements SafeParcelable {
    public static final Creator<CreateFileIntentSenderRequest> CREATOR = new C0190i();
    final String HY;
    final MetadataBundle IE;
    final Integer IF;
    final DriveId Ia;
    final int ra;
    final int xM;

    CreateFileIntentSenderRequest(int versionCode, MetadataBundle metadata, int requestId, String title, DriveId startFolder, Integer fileType) {
        this.xM = versionCode;
        this.IE = metadata;
        this.ra = requestId;
        this.HY = title;
        this.Ia = startFolder;
        this.IF = fileType;
    }

    public CreateFileIntentSenderRequest(MetadataBundle metadata, int requestId, String title, DriveId startFolder, int fileType) {
        this(1, metadata, requestId, title, startFolder, Integer.valueOf(fileType));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        C0190i.m350a(this, dest, flags);
    }
}
