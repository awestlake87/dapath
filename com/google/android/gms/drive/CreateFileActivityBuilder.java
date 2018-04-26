package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.C0189h;
import com.google.android.gms.internal.hm;
import java.io.IOException;

public class CreateFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private final C0189h HF = new C0189h(0);
    private Contents HG;

    public IntentSender build(GoogleApiClient apiClient) {
        hm.m1228b(this.HG, (Object) "Must provide initial contents to CreateFileActivityBuilder.");
        try {
            this.HG.getParcelFileDescriptor().close();
        } catch (IOException e) {
        }
        this.HG.close();
        return this.HF.build(apiClient);
    }

    public CreateFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.HF.m348a(folder);
        return this;
    }

    public CreateFileActivityBuilder setActivityTitle(String title) {
        this.HF.aM(title);
        return this;
    }

    public CreateFileActivityBuilder setInitialContents(Contents contents) {
        this.HG = (Contents) hm.m1232f(contents);
        this.HF.aS(this.HG.getRequestId());
        return this;
    }

    public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet metadataChangeSet) {
        this.HF.m349a(metadataChangeSet);
        return this;
    }
}
