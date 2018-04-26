package com.google.android.gms.appstate;

import com.google.android.gms.common.data.C0160d;
import com.google.android.gms.common.data.DataHolder;

public final class C0997b extends C0160d implements AppState {
    C0997b(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public AppState dS() {
        return new C0996a(this);
    }

    public boolean equals(Object obj) {
        return C0996a.m3174a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return dS();
    }

    public byte[] getConflictData() {
        return getByteArray("conflict_data");
    }

    public String getConflictVersion() {
        return getString("conflict_version");
    }

    public int getKey() {
        return getInteger("key");
    }

    public byte[] getLocalData() {
        return getByteArray("local_data");
    }

    public String getLocalVersion() {
        return getString("local_version");
    }

    public boolean hasConflict() {
        return !ax("conflict_version");
    }

    public int hashCode() {
        return C0996a.m3173a(this);
    }

    public String toString() {
        return C0996a.m3175b(this);
    }
}
