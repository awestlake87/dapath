package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.C0160d;
import com.google.android.gms.common.data.DataHolder;

public final class ExperienceEventRef extends C0160d implements ExperienceEvent {
    public ExperienceEventRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public String getIconImageUrl() {
        return getString("icon_url");
    }
}
