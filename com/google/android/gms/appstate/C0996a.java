package com.google.android.gms.appstate;

import com.google.android.gms.internal.hk;

public final class C0996a implements AppState {
    private final int yB;
    private final String yC;
    private final byte[] yD;
    private final boolean yE;
    private final String yF;
    private final byte[] yG;

    public C0996a(AppState appState) {
        this.yB = appState.getKey();
        this.yC = appState.getLocalVersion();
        this.yD = appState.getLocalData();
        this.yE = appState.hasConflict();
        this.yF = appState.getConflictVersion();
        this.yG = appState.getConflictData();
    }

    static int m3173a(AppState appState) {
        return hk.hashCode(Integer.valueOf(appState.getKey()), appState.getLocalVersion(), appState.getLocalData(), Boolean.valueOf(appState.hasConflict()), appState.getConflictVersion(), appState.getConflictData());
    }

    static boolean m3174a(AppState appState, Object obj) {
        if (!(obj instanceof AppState)) {
            return false;
        }
        if (appState == obj) {
            return true;
        }
        AppState appState2 = (AppState) obj;
        return hk.equal(Integer.valueOf(appState2.getKey()), Integer.valueOf(appState.getKey())) && hk.equal(appState2.getLocalVersion(), appState.getLocalVersion()) && hk.equal(appState2.getLocalData(), appState.getLocalData()) && hk.equal(Boolean.valueOf(appState2.hasConflict()), Boolean.valueOf(appState.hasConflict())) && hk.equal(appState2.getConflictVersion(), appState.getConflictVersion()) && hk.equal(appState2.getConflictData(), appState.getConflictData());
    }

    static String m3175b(AppState appState) {
        return hk.m1221e(appState).m1220a("Key", Integer.valueOf(appState.getKey())).m1220a("LocalVersion", appState.getLocalVersion()).m1220a("LocalData", appState.getLocalData()).m1220a("HasConflict", Boolean.valueOf(appState.hasConflict())).m1220a("ConflictVersion", appState.getConflictVersion()).m1220a("ConflictData", appState.getConflictData()).toString();
    }

    public AppState dS() {
        return this;
    }

    public boolean equals(Object obj) {
        return C0996a.m3174a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return dS();
    }

    public byte[] getConflictData() {
        return this.yG;
    }

    public String getConflictVersion() {
        return this.yF;
    }

    public int getKey() {
        return this.yB;
    }

    public byte[] getLocalData() {
        return this.yD;
    }

    public String getLocalVersion() {
        return this.yC;
    }

    public boolean hasConflict() {
        return this.yE;
    }

    public int hashCode() {
        return C0996a.m3173a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return C0996a.m3175b(this);
    }
}
