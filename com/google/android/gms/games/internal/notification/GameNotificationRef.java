package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.C0160d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.hk;
import com.google.android.gms.plus.PlusShare;

public final class GameNotificationRef extends C0160d implements GameNotification {
    GameNotificationRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public long getId() {
        return getLong("_id");
    }

    public String getText() {
        return getString("text");
    }

    public String getTitle() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
    }

    public int getType() {
        return getInteger("type");
    }

    public String ik() {
        return getString("notification_id");
    }

    public String il() {
        return getString("ticker");
    }

    public String im() {
        return getString("coalesced_text");
    }

    public boolean in() {
        return getInteger("acknowledged") > 0;
    }

    public boolean io() {
        return getInteger("alert_level") == 0;
    }

    public String toString() {
        return hk.m1221e(this).m1220a("Id", Long.valueOf(getId())).m1220a("NotificationId", ik()).m1220a("Type", Integer.valueOf(getType())).m1220a("Title", getTitle()).m1220a("Ticker", il()).m1220a("Text", getText()).m1220a("CoalescedText", im()).m1220a("isAcknowledged", Boolean.valueOf(in())).m1220a("isSilent", Boolean.valueOf(io())).toString();
    }
}
