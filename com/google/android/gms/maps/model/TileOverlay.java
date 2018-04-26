package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.hm;
import com.google.android.gms.maps.model.internal.C0422h;

public final class TileOverlay {
    private final C0422h abc;

    public TileOverlay(C0422h delegate) {
        this.abc = (C0422h) hm.m1232f(delegate);
    }

    public void clearTileCache() {
        try {
            this.abc.clearTileCache();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean equals(Object other) {
        if (!(other instanceof TileOverlay)) {
            return false;
        }
        try {
            return this.abc.mo2238a(((TileOverlay) other).abc);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean getFadeIn() {
        try {
            return this.abc.getFadeIn();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getId() {
        try {
            return this.abc.getId();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public float getZIndex() {
        try {
            return this.abc.getZIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.abc.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isVisible() {
        try {
            return this.abc.isVisible();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void remove() {
        try {
            this.abc.remove();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setFadeIn(boolean fadeIn) {
        try {
            this.abc.setFadeIn(fadeIn);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setVisible(boolean visible) {
        try {
            this.abc.setVisible(visible);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZIndex(float zIndex) {
        try {
            this.abc.setZIndex(zIndex);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
