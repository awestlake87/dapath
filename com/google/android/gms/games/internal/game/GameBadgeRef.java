package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0160d;
import com.google.android.gms.common.data.DataHolder;

public final class GameBadgeRef extends C0160d implements GameBadge {
    GameBadgeRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return GameBadgeEntity.m4023a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return ic();
    }

    public String getDescription() {
        return getString("badge_description");
    }

    public Uri getIconImageUri() {
        return aw("badge_icon_image_uri");
    }

    public String getTitle() {
        return getString("badge_title");
    }

    public int getType() {
        return getInteger("badge_type");
    }

    public int hashCode() {
        return GameBadgeEntity.m4022a(this);
    }

    public GameBadge ic() {
        return new GameBadgeEntity(this);
    }

    public String toString() {
        return GameBadgeEntity.m4024b((GameBadge) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((GameBadgeEntity) ic()).writeToParcel(dest, flags);
    }
}
