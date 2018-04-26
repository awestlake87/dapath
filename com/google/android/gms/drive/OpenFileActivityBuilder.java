package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.C1015r;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.internal.hm;

public class OpenFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private String HY;
    private String[] HZ;
    private DriveId Ia;

    public IntentSender build(GoogleApiClient apiClient) {
        hm.m1226a(apiClient.isConnected(), "Client must be connected");
        if (this.HZ == null) {
            this.HZ = new String[0];
        }
        try {
            return ((C1015r) apiClient.mo925a(Drive.yH)).gp().mo948a(new OpenFileIntentSenderRequest(this.HY, this.HZ, this.Ia));
        } catch (Throwable e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.Ia = (DriveId) hm.m1232f(folder);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String title) {
        this.HY = (String) hm.m1232f(title);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String[] mimeTypes) {
        hm.m1230b(mimeTypes != null, (Object) "mimeTypes may not be null");
        this.HZ = mimeTypes;
        return this;
    }
}
