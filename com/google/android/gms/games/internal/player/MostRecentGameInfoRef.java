package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0160d;
import com.google.android.gms.common.data.DataHolder;

public final class MostRecentGameInfoRef extends C0160d implements MostRecentGameInfo {
    private final PlayerColumnNames Ng;

    public MostRecentGameInfoRef(DataHolder holder, int dataRow, PlayerColumnNames columnNames) {
        super(holder, dataRow);
        this.Ng = columnNames;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return MostRecentGameInfoEntity.m3454a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return iv();
    }

    public int hashCode() {
        return MostRecentGameInfoEntity.m3453a(this);
    }

    public String ip() {
        return getString(this.Ng.Sg);
    }

    public String iq() {
        return getString(this.Ng.Sh);
    }

    public long ir() {
        return getLong(this.Ng.Si);
    }

    public Uri is() {
        return aw(this.Ng.Sj);
    }

    public Uri it() {
        return aw(this.Ng.Sk);
    }

    public Uri iu() {
        return aw(this.Ng.Sl);
    }

    public MostRecentGameInfo iv() {
        return new MostRecentGameInfoEntity(this);
    }

    public String toString() {
        return MostRecentGameInfoEntity.m3455b(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((MostRecentGameInfoEntity) iv()).writeToParcel(dest, flags);
    }
}
