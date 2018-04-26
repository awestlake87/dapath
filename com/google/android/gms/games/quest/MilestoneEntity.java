package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.hk;

public final class MilestoneEntity implements SafeParcelable, Milestone {
    public static final MilestoneEntityCreator CREATOR = new MilestoneEntityCreator();
    private final String Ni;
    private final String Ot;
    private final long TM;
    private final long TN;
    private final byte[] TO;
    private final int mState;
    private final int xM;

    MilestoneEntity(int versionCode, String milestoneId, long currentProgress, long targetProgress, byte[] completionBlob, int state, String eventId) {
        this.xM = versionCode;
        this.Ot = milestoneId;
        this.TM = currentProgress;
        this.TN = targetProgress;
        this.TO = completionBlob;
        this.mState = state;
        this.Ni = eventId;
    }

    public MilestoneEntity(Milestone milestone) {
        this.xM = 4;
        this.Ot = milestone.getMilestoneId();
        this.TM = milestone.getCurrentProgress();
        this.TN = milestone.getTargetProgress();
        this.mState = milestone.getState();
        this.Ni = milestone.getEventId();
        Object completionRewardData = milestone.getCompletionRewardData();
        if (completionRewardData == null) {
            this.TO = null;
            return;
        }
        this.TO = new byte[completionRewardData.length];
        System.arraycopy(completionRewardData, 0, this.TO, 0, completionRewardData.length);
    }

    static int m3472a(Milestone milestone) {
        return hk.hashCode(milestone.getMilestoneId(), Long.valueOf(milestone.getCurrentProgress()), Long.valueOf(milestone.getTargetProgress()), Integer.valueOf(milestone.getState()), milestone.getEventId());
    }

    static boolean m3473a(Milestone milestone, Object obj) {
        if (!(obj instanceof Milestone)) {
            return false;
        }
        if (milestone == obj) {
            return true;
        }
        Milestone milestone2 = (Milestone) obj;
        return hk.equal(milestone2.getMilestoneId(), milestone.getMilestoneId()) && hk.equal(Long.valueOf(milestone2.getCurrentProgress()), Long.valueOf(milestone.getCurrentProgress())) && hk.equal(Long.valueOf(milestone2.getTargetProgress()), Long.valueOf(milestone.getTargetProgress())) && hk.equal(Integer.valueOf(milestone2.getState()), Integer.valueOf(milestone.getState())) && hk.equal(milestone2.getEventId(), milestone.getEventId());
    }

    static String m3474b(Milestone milestone) {
        return hk.m1221e(milestone).m1220a("MilestoneId", milestone.getMilestoneId()).m1220a("CurrentProgress", Long.valueOf(milestone.getCurrentProgress())).m1220a("TargetProgress", Long.valueOf(milestone.getTargetProgress())).m1220a("State", Integer.valueOf(milestone.getState())).m1220a("CompletionRewardData", milestone.getCompletionRewardData()).m1220a("EventId", milestone.getEventId()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m3473a(this, obj);
    }

    public Milestone freeze() {
        return this;
    }

    public byte[] getCompletionRewardData() {
        return this.TO;
    }

    public long getCurrentProgress() {
        return this.TM;
    }

    public String getEventId() {
        return this.Ni;
    }

    public String getMilestoneId() {
        return this.Ot;
    }

    public int getState() {
        return this.mState;
    }

    public long getTargetProgress() {
        return this.TN;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return m3472a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m3474b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        MilestoneEntityCreator.m746a(this, out, flags);
    }
}
