package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.C1006g;
import com.google.android.gms.common.data.DataHolder;

public final class QuestBuffer extends C1006g<Quest> {
    public QuestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object mo3142c(int i, int i2) {
        return m4051j(i, i2);
    }

    protected String eZ() {
        return "external_quest_id";
    }

    protected Quest m4051j(int i, int i2) {
        return new QuestRef(this.DG, i, i2);
    }
}
