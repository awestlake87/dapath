package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.internal.hm;

public class C0189h {
    private String HY;
    protected MetadataChangeSet IA;
    private Integer IB;
    private final int IC;
    private DriveId Ia;

    public C0189h(int i) {
        this.IC = i;
    }

    public void m348a(DriveId driveId) {
        this.Ia = (DriveId) hm.m1232f(driveId);
    }

    public void m349a(MetadataChangeSet metadataChangeSet) {
        this.IA = (MetadataChangeSet) hm.m1232f(metadataChangeSet);
    }

    public void aM(String str) {
        this.HY = (String) hm.m1232f(str);
    }

    public void aS(int i) {
        this.IB = Integer.valueOf(i);
    }

    public IntentSender build(GoogleApiClient apiClient) {
        hm.m1228b(this.IA, (Object) "Must provide initial metadata to CreateFileActivityBuilder.");
        hm.m1226a(apiClient.isConnected(), "Client must be connected");
        try {
            return ((C1015r) apiClient.mo925a(Drive.yH)).gp().mo947a(new CreateFileIntentSenderRequest(this.IA.gm(), this.IB == null ? -1 : this.IB.intValue(), this.HY, this.Ia, this.IC));
        } catch (Throwable e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }
}
