package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.C0405v;

public final class Tile implements SafeParcelable {
    public static final TileCreator CREATOR = new TileCreator();
    public final byte[] data;
    public final int height;
    public final int width;
    private final int xM;

    Tile(int versionCode, int width, int height, byte[] data) {
        this.xM = versionCode;
        this.width = width;
        this.height = height;
        this.data = data;
    }

    public Tile(int width, int height, byte[] data) {
        this(1, width, height, data);
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.xM;
    }

    public void writeToParcel(Parcel out, int flags) {
        if (C0405v.jL()) {
            C0414i.m1535a(this, out, flags);
        } else {
            TileCreator.m1524a(this, out, flags);
        }
    }
}
