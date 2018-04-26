package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.ik;
import java.util.ArrayList;

public final class TurnBasedMatchEntity implements SafeParcelable, TurnBasedMatch {
    public static final TurnBasedMatchEntityCreator CREATOR = new TurnBasedMatchEntityCreator();
    private final String Mp;
    private final String Oi;
    private final GameEntity Rt;
    private final long SU;
    private final ArrayList<ParticipantEntity> SX;
    private final int SY;
    private final String TA;
    private final long TB;
    private final String TC;
    private final int TD;
    private final int TE;
    private final byte[] TF;
    private final String TG;
    private final byte[] TH;
    private final int TI;
    private final int TJ;
    private final boolean TK;
    private final String TL;
    private final Bundle To;
    private final String Ts;
    private final int xM;

    TurnBasedMatchEntity(int versionCode, GameEntity game, String matchId, String creatorId, long creationTimestamp, String lastUpdaterId, long lastUpdatedTimestamp, String pendingParticipantId, int matchStatus, int variant, int version, byte[] data, ArrayList<ParticipantEntity> participants, String rematchId, byte[] previousData, int matchNumber, Bundle autoMatchCriteria, int turnStatus, boolean isLocallyModified, String description, String descriptionParticipantId) {
        this.xM = versionCode;
        this.Rt = game;
        this.Oi = matchId;
        this.Ts = creatorId;
        this.SU = creationTimestamp;
        this.TA = lastUpdaterId;
        this.TB = lastUpdatedTimestamp;
        this.TC = pendingParticipantId;
        this.TD = matchStatus;
        this.TJ = turnStatus;
        this.SY = variant;
        this.TE = version;
        this.TF = data;
        this.SX = participants;
        this.TG = rematchId;
        this.TH = previousData;
        this.TI = matchNumber;
        this.To = autoMatchCriteria;
        this.TK = isLocallyModified;
        this.Mp = description;
        this.TL = descriptionParticipantId;
    }

    public TurnBasedMatchEntity(TurnBasedMatch match) {
        this.xM = 2;
        this.Rt = new GameEntity(match.getGame());
        this.Oi = match.getMatchId();
        this.Ts = match.getCreatorId();
        this.SU = match.getCreationTimestamp();
        this.TA = match.getLastUpdaterId();
        this.TB = match.getLastUpdatedTimestamp();
        this.TC = match.getPendingParticipantId();
        this.TD = match.getStatus();
        this.TJ = match.getTurnStatus();
        this.SY = match.getVariant();
        this.TE = match.getVersion();
        this.TG = match.getRematchId();
        this.TI = match.getMatchNumber();
        this.To = match.getAutoMatchCriteria();
        this.TK = match.isLocallyModified();
        this.Mp = match.getDescription();
        this.TL = match.getDescriptionParticipantId();
        Object data = match.getData();
        if (data == null) {
            this.TF = null;
        } else {
            this.TF = new byte[data.length];
            System.arraycopy(data, 0, this.TF, 0, data.length);
        }
        data = match.getPreviousMatchData();
        if (data == null) {
            this.TH = null;
        } else {
            this.TH = new byte[data.length];
            System.arraycopy(data, 0, this.TH, 0, data.length);
        }
        ArrayList participants = match.getParticipants();
        int size = participants.size();
        this.SX = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.SX.add((ParticipantEntity) ((Participant) participants.get(i)).freeze());
        }
    }

    static int m3465a(TurnBasedMatch turnBasedMatch) {
        return hk.hashCode(turnBasedMatch.getGame(), turnBasedMatch.getMatchId(), turnBasedMatch.getCreatorId(), Long.valueOf(turnBasedMatch.getCreationTimestamp()), turnBasedMatch.getLastUpdaterId(), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp()), turnBasedMatch.getPendingParticipantId(), Integer.valueOf(turnBasedMatch.getStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus()), turnBasedMatch.getDescription(), Integer.valueOf(turnBasedMatch.getVariant()), Integer.valueOf(turnBasedMatch.getVersion()), turnBasedMatch.getParticipants(), turnBasedMatch.getRematchId(), Integer.valueOf(turnBasedMatch.getMatchNumber()), turnBasedMatch.getAutoMatchCriteria(), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    static int m3466a(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + turnBasedMatch.getMatchId());
    }

    static boolean m3467a(TurnBasedMatch turnBasedMatch, Object obj) {
        if (!(obj instanceof TurnBasedMatch)) {
            return false;
        }
        if (turnBasedMatch == obj) {
            return true;
        }
        TurnBasedMatch turnBasedMatch2 = (TurnBasedMatch) obj;
        return hk.equal(turnBasedMatch2.getGame(), turnBasedMatch.getGame()) && hk.equal(turnBasedMatch2.getMatchId(), turnBasedMatch.getMatchId()) && hk.equal(turnBasedMatch2.getCreatorId(), turnBasedMatch.getCreatorId()) && hk.equal(Long.valueOf(turnBasedMatch2.getCreationTimestamp()), Long.valueOf(turnBasedMatch.getCreationTimestamp())) && hk.equal(turnBasedMatch2.getLastUpdaterId(), turnBasedMatch.getLastUpdaterId()) && hk.equal(Long.valueOf(turnBasedMatch2.getLastUpdatedTimestamp()), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())) && hk.equal(turnBasedMatch2.getPendingParticipantId(), turnBasedMatch.getPendingParticipantId()) && hk.equal(Integer.valueOf(turnBasedMatch2.getStatus()), Integer.valueOf(turnBasedMatch.getStatus())) && hk.equal(Integer.valueOf(turnBasedMatch2.getTurnStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus())) && hk.equal(turnBasedMatch2.getDescription(), turnBasedMatch.getDescription()) && hk.equal(Integer.valueOf(turnBasedMatch2.getVariant()), Integer.valueOf(turnBasedMatch.getVariant())) && hk.equal(Integer.valueOf(turnBasedMatch2.getVersion()), Integer.valueOf(turnBasedMatch.getVersion())) && hk.equal(turnBasedMatch2.getParticipants(), turnBasedMatch.getParticipants()) && hk.equal(turnBasedMatch2.getRematchId(), turnBasedMatch.getRematchId()) && hk.equal(Integer.valueOf(turnBasedMatch2.getMatchNumber()), Integer.valueOf(turnBasedMatch.getMatchNumber())) && hk.equal(turnBasedMatch2.getAutoMatchCriteria(), turnBasedMatch.getAutoMatchCriteria()) && hk.equal(Integer.valueOf(turnBasedMatch2.getAvailableAutoMatchSlots()), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())) && hk.equal(Boolean.valueOf(turnBasedMatch2.isLocallyModified()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    static String m3468b(TurnBasedMatch turnBasedMatch) {
        return hk.m1221e(turnBasedMatch).m1220a("Game", turnBasedMatch.getGame()).m1220a("MatchId", turnBasedMatch.getMatchId()).m1220a("CreatorId", turnBasedMatch.getCreatorId()).m1220a("CreationTimestamp", Long.valueOf(turnBasedMatch.getCreationTimestamp())).m1220a("LastUpdaterId", turnBasedMatch.getLastUpdaterId()).m1220a("LastUpdatedTimestamp", Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())).m1220a("PendingParticipantId", turnBasedMatch.getPendingParticipantId()).m1220a("MatchStatus", Integer.valueOf(turnBasedMatch.getStatus())).m1220a("TurnStatus", Integer.valueOf(turnBasedMatch.getTurnStatus())).m1220a("Description", turnBasedMatch.getDescription()).m1220a("Variant", Integer.valueOf(turnBasedMatch.getVariant())).m1220a("Data", turnBasedMatch.getData()).m1220a("Version", Integer.valueOf(turnBasedMatch.getVersion())).m1220a("Participants", turnBasedMatch.getParticipants()).m1220a("RematchId", turnBasedMatch.getRematchId()).m1220a("PreviousData", turnBasedMatch.getPreviousMatchData()).m1220a("MatchNumber", Integer.valueOf(turnBasedMatch.getMatchNumber())).m1220a("AutoMatchCriteria", turnBasedMatch.getAutoMatchCriteria()).m1220a("AvailableAutoMatchSlots", Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())).m1220a("LocallyModified", Boolean.valueOf(turnBasedMatch.isLocallyModified())).m1220a("DescriptionParticipantId", turnBasedMatch.getDescriptionParticipantId()).toString();
    }

    static String m3469b(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(str)) {
                return participant.getParticipantId();
            }
        }
        return null;
    }

    static Participant m3470c(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + turnBasedMatch.getMatchId());
    }

    static ArrayList<String> m3471c(TurnBasedMatch turnBasedMatch) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((Participant) participants.get(i)).getParticipantId());
        }
        return arrayList;
    }

    public boolean canRematch() {
        return this.TD == 2 && this.TG == null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return m3467a((TurnBasedMatch) this, obj);
    }

    public TurnBasedMatch freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.To;
    }

    public int getAvailableAutoMatchSlots() {
        return this.To == null ? 0 : this.To.getInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS);
    }

    public long getCreationTimestamp() {
        return this.SU;
    }

    public String getCreatorId() {
        return this.Ts;
    }

    public byte[] getData() {
        return this.TF;
    }

    public String getDescription() {
        return this.Mp;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        ik.m1275b(this.Mp, dataOut);
    }

    public Participant getDescriptionParticipant() {
        return getParticipant(getDescriptionParticipantId());
    }

    public String getDescriptionParticipantId() {
        return this.TL;
    }

    public Game getGame() {
        return this.Rt;
    }

    public long getLastUpdatedTimestamp() {
        return this.TB;
    }

    public String getLastUpdaterId() {
        return this.TA;
    }

    public String getMatchId() {
        return this.Oi;
    }

    public int getMatchNumber() {
        return this.TI;
    }

    public Participant getParticipant(String participantId) {
        return m3470c(this, participantId);
    }

    public String getParticipantId(String playerId) {
        return m3469b(this, playerId);
    }

    public ArrayList<String> getParticipantIds() {
        return m3471c(this);
    }

    public int getParticipantStatus(String participantId) {
        return m3466a((TurnBasedMatch) this, participantId);
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.SX);
    }

    public String getPendingParticipantId() {
        return this.TC;
    }

    public byte[] getPreviousMatchData() {
        return this.TH;
    }

    public String getRematchId() {
        return this.TG;
    }

    public int getStatus() {
        return this.TD;
    }

    public int getTurnStatus() {
        return this.TJ;
    }

    public int getVariant() {
        return this.SY;
    }

    public int getVersion() {
        return this.TE;
    }

    public int getVersionCode() {
        return this.xM;
    }

    public int hashCode() {
        return m3465a(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isLocallyModified() {
        return this.TK;
    }

    public String toString() {
        return m3468b(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        TurnBasedMatchEntityCreator.m745a(this, out, flags);
    }
}
