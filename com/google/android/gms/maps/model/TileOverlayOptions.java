package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C0405v;
import com.google.android.gms.maps.model.internal.C0423i;
import com.google.android.gms.maps.model.internal.C0423i.C0895a;

public final class TileOverlayOptions implements SafeParcelable {
    public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();
    private float aax;
    private boolean aay;
    private C0423i abd;
    private TileProvider abe;
    private boolean abf;
    private final int xM;

    class C08751 implements TileProvider {
        private final C0423i abg = this.abh.abd;
        final /* synthetic */ TileOverlayOptions abh;

        C08751(TileOverlayOptions tileOverlayOptions) {
            this.abh = tileOverlayOptions;
        }

        public Tile getTile(int x, int y, int zoom) {
            try {
                return this.abg.getTile(x, y, zoom);
            } catch (RemoteException e) {
                return null;
            }
        }
    }

    public TileOverlayOptions() {
        this.aay = true;
        this.abf = true;
        this.xM = 1;
    }

    TileOverlayOptions(int versionCode, IBinder delegate, boolean visible, float zIndex, boolean fadeIn) {
        this.aay = true;
        this.abf = true;
        this.xM = versionCode;
        this.abd = C0895a.bg(delegate);
        this.abe = this.abd == null ? null : new C08751(this);
        this.aay = visible;
        this.aax = zIndex;
        this.abf = fadeIn;
    }

    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean fadeIn) {
        this.abf = fadeIn;
        return this;
    }

    public boolean getFadeIn() {
        return this.abf;
    }

    public TileProvider getTileProvider() {
        return this.abe;
    }

    int getVersionCode() {
        return this.xM;
    }

    public float getZIndex() {
        return this.aax;
    }

    public boolean isVisible() {
        return this.aay;
    }

    IBinder jQ() {
        return this.abd.asBinder();
    }

    public TileOverlayOptions tileProvider(final TileProvider tileProvider) {
        this.abe = tileProvider;
        this.abd = this.abe == null ? null : new C0895a(this) {
            final /* synthetic */ TileOverlayOptions abh;

            public Tile getTile(int x, int y, int zoom) {
                return tileProvider.getTile(x, y, zoom);
            }
        };
        return this;
    }

    public TileOverlayOptions visible(boolean visible) {
        this.aay = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0405v.jL()) {
            C0424j.m1548a(this, out, flags);
        } else {
            TileOverlayOptionsCreator.m1525a(this, out, flags);
        }
    }

    public TileOverlayOptions zIndex(float zIndex) {
        this.aax = zIndex;
        return this;
    }
}
