package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.C0252d;
import com.google.android.gms.dynamic.C1030e;
import com.google.android.gms.internal.hm;
import com.google.android.gms.maps.LocationSource.OnLocationChangedListener;
import com.google.android.gms.maps.internal.C0385b.C0840a;
import com.google.android.gms.maps.internal.C0387d.C0844a;
import com.google.android.gms.maps.internal.C0388e.C0846a;
import com.google.android.gms.maps.internal.C0389f.C0848a;
import com.google.android.gms.maps.internal.C0390g.C0850a;
import com.google.android.gms.maps.internal.C0391h;
import com.google.android.gms.maps.internal.C0392i.C0854a;
import com.google.android.gms.maps.internal.C0393j.C0856a;
import com.google.android.gms.maps.internal.C0394k.C0858a;
import com.google.android.gms.maps.internal.C0395l.C0860a;
import com.google.android.gms.maps.internal.C0396m.C0862a;
import com.google.android.gms.maps.internal.C0397n.C0864a;
import com.google.android.gms.maps.internal.C0398o.C0866a;
import com.google.android.gms.maps.internal.C0402s.C0874a;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.ILocationSourceDelegate.C0824a;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.C0417c;
import com.google.android.gms.maps.model.internal.C0418d;
import com.google.android.gms.maps.model.internal.C0420f;
import com.google.android.gms.maps.model.internal.C0422h;

public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate YZ;
    private UiSettings Za;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface OnIndoorStateChangeListener {
        void onIndoorBuildingFocused();

        void onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    private static final class C1129a extends C0840a {
        private final CancelableCallback Zr;

        C1129a(CancelableCallback cancelableCallback) {
            this.Zr = cancelableCallback;
        }

        public void onCancel() {
            this.Zr.onCancel();
        }

        public void onFinish() {
            this.Zr.onFinish();
        }
    }

    protected GoogleMap(IGoogleMapDelegate map) {
        this.YZ = (IGoogleMapDelegate) hm.m1232f(map);
    }

    public final Circle addCircle(CircleOptions options) {
        try {
            return new Circle(this.YZ.addCircle(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions options) {
        try {
            C0417c addGroundOverlay = this.YZ.addGroundOverlay(options);
            return addGroundOverlay != null ? new GroundOverlay(addGroundOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions options) {
        try {
            C0420f addMarker = this.YZ.addMarker(options);
            return addMarker != null ? new Marker(addMarker) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions options) {
        try {
            return new Polygon(this.YZ.addPolygon(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions options) {
        try {
            return new Polyline(this.YZ.addPolyline(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions options) {
        try {
            C0422h addTileOverlay = this.YZ.addTileOverlay(options);
            return addTileOverlay != null ? new TileOverlay(addTileOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update) {
        try {
            this.YZ.animateCamera(update.jn());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, int durationMs, CancelableCallback callback) {
        try {
            this.YZ.animateCameraWithDurationAndCallback(update.jn(), durationMs, callback == null ? null : new C1129a(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, CancelableCallback callback) {
        try {
            this.YZ.animateCameraWithCallback(update.jn(), callback == null ? null : new C1129a(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.YZ.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.YZ.getCameraPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public IndoorBuilding getFocusedBuilding() {
        try {
            C0418d focusedBuilding = this.YZ.getFocusedBuilding();
            return focusedBuilding != null ? new IndoorBuilding(focusedBuilding) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.YZ.getMapType();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.YZ.getMaxZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.YZ.getMinZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.YZ.getMyLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.YZ.getProjection());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.Za == null) {
                this.Za = new UiSettings(this.YZ.getUiSettings());
            }
            return this.Za;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.YZ.isBuildingsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.YZ.isIndoorEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.YZ.isMyLocationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.YZ.isTrafficEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    IGoogleMapDelegate jp() {
        return this.YZ;
    }

    public final void moveCamera(CameraUpdate update) {
        try {
            this.YZ.moveCamera(update.jn());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setBuildingsEnabled(boolean enabled) {
        try {
            this.YZ.setBuildingsEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean setIndoorEnabled(boolean enabled) {
        try {
            return this.YZ.setIndoorEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(final InfoWindowAdapter adapter) {
        if (adapter == null) {
            try {
                this.YZ.setInfoWindowAdapter(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.YZ.setInfoWindowAdapter(new C0844a(this) {
            final /* synthetic */ GoogleMap Zc;

            public C0252d mo2097f(C0420f c0420f) {
                return C1030e.m3260h(adapter.getInfoWindow(new Marker(c0420f)));
            }

            public C0252d mo2098g(C0420f c0420f) {
                return C1030e.m3260h(adapter.getInfoContents(new Marker(c0420f)));
            }
        });
    }

    public final void setLocationSource(final LocationSource source) {
        if (source == null) {
            try {
                this.YZ.setLocationSource(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.YZ.setLocationSource(new C0824a(this) {
            final /* synthetic */ GoogleMap Zc;

            public void activate(final C0391h listener) {
                source.activate(new OnLocationChangedListener(this) {
                    final /* synthetic */ C11256 Zj;

                    public void onLocationChanged(Location location) {
                        try {
                            listener.mo2103k(C1030e.m3260h(location));
                        } catch (RemoteException e) {
                            throw new RuntimeRemoteException(e);
                        }
                    }
                });
            }

            public void deactivate() {
                source.deactivate();
            }
        });
    }

    public final void setMapType(int type) {
        try {
            this.YZ.setMapType(type);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationEnabled(boolean enabled) {
        try {
            this.YZ.setMyLocationEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnCameraChangeListener(final OnCameraChangeListener listener) {
        if (listener == null) {
            try {
                this.YZ.setOnCameraChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.YZ.setOnCameraChangeListener(new C0846a(this) {
            final /* synthetic */ GoogleMap Zc;

            public void onCameraChange(CameraPosition position) {
                listener.onCameraChange(position);
            }
        });
    }

    public final void setOnIndoorStateChangeListener(final OnIndoorStateChangeListener listener) {
        if (listener == null) {
            try {
                this.YZ.setOnIndoorStateChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.YZ.setOnIndoorStateChangeListener(new C0848a(this) {
            final /* synthetic */ GoogleMap Zc;

            public void mo2100a(C0418d c0418d) {
                listener.onIndoorLevelActivated(new IndoorBuilding(c0418d));
            }

            public void onIndoorBuildingFocused() {
                listener.onIndoorBuildingFocused();
            }
        });
    }

    public final void setOnInfoWindowClickListener(final OnInfoWindowClickListener listener) {
        if (listener == null) {
            try {
                this.YZ.setOnInfoWindowClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.YZ.setOnInfoWindowClickListener(new C0850a(this) {
            final /* synthetic */ GoogleMap Zc;

            public void mo2102e(C0420f c0420f) {
                listener.onInfoWindowClick(new Marker(c0420f));
            }
        });
    }

    public final void setOnMapClickListener(final OnMapClickListener listener) {
        if (listener == null) {
            try {
                this.YZ.setOnMapClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.YZ.setOnMapClickListener(new C0854a(this) {
            final /* synthetic */ GoogleMap Zc;

            public void onMapClick(LatLng point) {
                listener.onMapClick(point);
            }
        });
    }

    public void setOnMapLoadedCallback(final OnMapLoadedCallback callback) {
        if (callback == null) {
            try {
                this.YZ.setOnMapLoadedCallback(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.YZ.setOnMapLoadedCallback(new C0856a(this) {
            final /* synthetic */ GoogleMap Zc;

            public void onMapLoaded() throws RemoteException {
                callback.onMapLoaded();
            }
        });
    }

    public final void setOnMapLongClickListener(final OnMapLongClickListener listener) {
        if (listener == null) {
            try {
                this.YZ.setOnMapLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.YZ.setOnMapLongClickListener(new C0858a(this) {
            final /* synthetic */ GoogleMap Zc;

            public void onMapLongClick(LatLng point) {
                listener.onMapLongClick(point);
            }
        });
    }

    public final void setOnMarkerClickListener(final OnMarkerClickListener listener) {
        if (listener == null) {
            try {
                this.YZ.setOnMarkerClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.YZ.setOnMarkerClickListener(new C0860a(this) {
            final /* synthetic */ GoogleMap Zc;

            public boolean mo2107a(C0420f c0420f) {
                return listener.onMarkerClick(new Marker(c0420f));
            }
        });
    }

    public final void setOnMarkerDragListener(final OnMarkerDragListener listener) {
        if (listener == null) {
            try {
                this.YZ.setOnMarkerDragListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.YZ.setOnMarkerDragListener(new C0862a(this) {
            final /* synthetic */ GoogleMap Zc;

            public void mo2108b(C0420f c0420f) {
                listener.onMarkerDragStart(new Marker(c0420f));
            }

            public void mo2109c(C0420f c0420f) {
                listener.onMarkerDragEnd(new Marker(c0420f));
            }

            public void mo2110d(C0420f c0420f) {
                listener.onMarkerDrag(new Marker(c0420f));
            }
        });
    }

    public final void setOnMyLocationButtonClickListener(final OnMyLocationButtonClickListener listener) {
        if (listener == null) {
            try {
                this.YZ.setOnMyLocationButtonClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.YZ.setOnMyLocationButtonClickListener(new C0864a(this) {
            final /* synthetic */ GoogleMap Zc;

            public boolean onMyLocationButtonClick() throws RemoteException {
                return listener.onMyLocationButtonClick();
            }
        });
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(final OnMyLocationChangeListener listener) {
        if (listener == null) {
            try {
                this.YZ.setOnMyLocationChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.YZ.setOnMyLocationChangeListener(new C0866a(this) {
            final /* synthetic */ GoogleMap Zc;

            public void mo2112f(C0252d c0252d) {
                listener.onMyLocationChange((Location) C1030e.m3259e(c0252d));
            }
        });
    }

    public final void setPadding(int left, int top, int right, int bottom) {
        try {
            this.YZ.setPadding(left, top, right, bottom);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTrafficEnabled(boolean enabled) {
        try {
            this.YZ.setTrafficEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void snapshot(SnapshotReadyCallback callback) {
        snapshot(callback, null);
    }

    public final void snapshot(final SnapshotReadyCallback callback, Bitmap bitmap) {
        try {
            this.YZ.snapshot(new C0874a(this) {
                final /* synthetic */ GoogleMap Zc;

                public void mo2116g(C0252d c0252d) throws RemoteException {
                    callback.onSnapshotReady((Bitmap) C1030e.m3259e(c0252d));
                }

                public void onSnapshotReady(Bitmap snapshot) throws RemoteException {
                    callback.onSnapshotReady(snapshot);
                }
            }, (C1030e) (bitmap != null ? C1030e.m3260h(bitmap) : null));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.YZ.stopAnimation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
