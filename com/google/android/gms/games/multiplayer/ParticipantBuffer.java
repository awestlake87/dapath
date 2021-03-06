package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataBuffer;

public final class ParticipantBuffer extends DataBuffer<Participant> {
    public Participant get(int position) {
        return new ParticipantRef(this.DG, position);
    }
}
