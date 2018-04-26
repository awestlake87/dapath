package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.hm;
import com.google.android.gms.maps.model.internal.C0418d;
import com.google.android.gms.maps.model.internal.C0419e.C0887a;
import java.util.ArrayList;
import java.util.List;

public final class IndoorBuilding {
    private final C0418d aaI;

    public IndoorBuilding(C0418d delegate) {
        this.aaI = (C0418d) hm.m1232f(delegate);
    }

    public boolean equals(Object other) {
        if (!(other instanceof IndoorBuilding)) {
            return false;
        }
        try {
            return this.aaI.mo2181b(((IndoorBuilding) other).aaI);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getActiveLevelIndex() {
        try {
            return this.aaI.getActiveLevelIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int getDefaultLevelIndex() {
        try {
            return this.aaI.getActiveLevelIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public List<IndoorLevel> getLevels() {
        try {
            List<IBinder> levels = this.aaI.getLevels();
            List<IndoorLevel> arrayList = new ArrayList(levels.size());
            for (IBinder bb : levels) {
                arrayList.add(new IndoorLevel(C0887a.bb(bb)));
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.aaI.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isUnderground() {
        try {
            return this.aaI.isUnderground();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
