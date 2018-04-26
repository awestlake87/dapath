package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C0153a.C0152d;
import com.google.android.gms.common.api.Status;

public class aw extends C1010c {
    private final C0152d<Status> yR;

    public aw(C0152d<Status> c0152d) {
        this.yR = c0152d;
    }

    public void mo986o(Status status) throws RemoteException {
        this.yR.mo911a(status);
    }

    public void onSuccess() throws RemoteException {
        this.yR.mo911a(Status.En);
    }
}
