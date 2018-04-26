package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.C0160d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.PlatformType;
import com.google.android.gms.internal.hk;

public final class GameInstanceRef extends C0160d implements GameInstance {
    GameInstanceRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public String getApplicationId() {
        return getString("external_game_id");
    }

    public String getDisplayName() {
        return getString("instance_display_name");
    }

    public String getPackageName() {
        return getString("package_name");
    }

    public boolean id() {
        return getInteger("real_time_support") > 0;
    }

    public boolean ie() {
        return getInteger("turn_based_support") > 0;
    }

    public int m2434if() {
        return getInteger("platform_type");
    }

    public boolean ig() {
        return getInteger("piracy_check") > 0;
    }

    public boolean ih() {
        return getInteger("installed") > 0;
    }

    public String toString() {
        return hk.m1221e(this).m1220a("ApplicationId", getApplicationId()).m1220a("DisplayName", getDisplayName()).m1220a("SupportsRealTime", Boolean.valueOf(id())).m1220a("SupportsTurnBased", Boolean.valueOf(ie())).m1220a("PlatformType", PlatformType.cm(m2434if())).m1220a("PackageName", getPackageName()).m1220a("PiracyCheckEnabled", Boolean.valueOf(ig())).m1220a("Installed", Boolean.valueOf(ih())).toString();
    }
}
