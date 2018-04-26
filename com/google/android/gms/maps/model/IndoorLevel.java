package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.hm;
import com.google.android.gms.maps.model.internal.C0419e;

public final class IndoorLevel {
    private final C0419e aaJ;

    public IndoorLevel(C0419e delegate) {
        this.aaJ = (C0419e) hm.m1232f(delegate);
    }

    public void activate() {
        try {
            this.aaJ.activate();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(Object other) {
        if (!(other instanceof IndoorLevel)) {
            return false;
        }
        try {
            return this.aaJ.mo2187a(((IndoorLevel) other).aaJ);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getName() {
        try {
            return this.aaJ.getName();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getShortName() {
        try {
            return this.aaJ.getShortName();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.aaJ.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
