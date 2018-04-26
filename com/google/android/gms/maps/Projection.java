package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.dynamic.C1030e;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.VisibleRegion;

public final class Projection {
    private final IProjectionDelegate ZM;

    Projection(IProjectionDelegate delegate) {
        this.ZM = delegate;
    }

    public LatLng fromScreenLocation(Point point) {
        try {
            return this.ZM.fromScreenLocation(C1030e.m3260h(point));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public VisibleRegion getVisibleRegion() {
        try {
            return this.ZM.getVisibleRegion();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public Point toScreenLocation(LatLng location) {
        try {
            return (Point) C1030e.m3259e(this.ZM.toScreenLocation(location));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
