package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hm;
import com.google.android.gms.internal.ik;

public final class LeaderboardScoreEntity implements LeaderboardScore {
    private final Uri SA;
    private final Uri SB;
    private final PlayerEntity SC;
    private final String SD;
    private final String SE;
    private final String SF;
    private final long Su;
    private final String Sv;
    private final String Sw;
    private final long Sx;
    private final long Sy;
    private final String Sz;

    public LeaderboardScoreEntity(LeaderboardScore score) {
        this.Su = score.getRank();
        this.Sv = (String) hm.m1232f(score.getDisplayRank());
        this.Sw = (String) hm.m1232f(score.getDisplayScore());
        this.Sx = score.getRawScore();
        this.Sy = score.getTimestampMillis();
        this.Sz = score.getScoreHolderDisplayName();
        this.SA = score.getScoreHolderIconImageUri();
        this.SB = score.getScoreHolderHiResImageUri();
        Player scoreHolder = score.getScoreHolder();
        this.SC = scoreHolder == null ? null : (PlayerEntity) scoreHolder.freeze();
        this.SD = score.getScoreTag();
        this.SE = score.getScoreHolderIconImageUrl();
        this.SF = score.getScoreHolderHiResImageUrl();
    }

    static int m3459a(LeaderboardScore leaderboardScore) {
        return hk.hashCode(Long.valueOf(leaderboardScore.getRank()), leaderboardScore.getDisplayRank(), Long.valueOf(leaderboardScore.getRawScore()), leaderboardScore.getDisplayScore(), Long.valueOf(leaderboardScore.getTimestampMillis()), leaderboardScore.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolder());
    }

    static boolean m3460a(LeaderboardScore leaderboardScore, Object obj) {
        if (!(obj instanceof LeaderboardScore)) {
            return false;
        }
        if (leaderboardScore == obj) {
            return true;
        }
        LeaderboardScore leaderboardScore2 = (LeaderboardScore) obj;
        return hk.equal(Long.valueOf(leaderboardScore2.getRank()), Long.valueOf(leaderboardScore.getRank())) && hk.equal(leaderboardScore2.getDisplayRank(), leaderboardScore.getDisplayRank()) && hk.equal(Long.valueOf(leaderboardScore2.getRawScore()), Long.valueOf(leaderboardScore.getRawScore())) && hk.equal(leaderboardScore2.getDisplayScore(), leaderboardScore.getDisplayScore()) && hk.equal(Long.valueOf(leaderboardScore2.getTimestampMillis()), Long.valueOf(leaderboardScore.getTimestampMillis())) && hk.equal(leaderboardScore2.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderDisplayName()) && hk.equal(leaderboardScore2.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderIconImageUri()) && hk.equal(leaderboardScore2.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolderHiResImageUri()) && hk.equal(leaderboardScore2.getScoreHolder(), leaderboardScore.getScoreHolder()) && hk.equal(leaderboardScore2.getScoreTag(), leaderboardScore.getScoreTag());
    }

    static String m3461b(LeaderboardScore leaderboardScore) {
        return hk.m1221e(leaderboardScore).m1220a("Rank", Long.valueOf(leaderboardScore.getRank())).m1220a("DisplayRank", leaderboardScore.getDisplayRank()).m1220a("Score", Long.valueOf(leaderboardScore.getRawScore())).m1220a("DisplayScore", leaderboardScore.getDisplayScore()).m1220a("Timestamp", Long.valueOf(leaderboardScore.getTimestampMillis())).m1220a("DisplayName", leaderboardScore.getScoreHolderDisplayName()).m1220a("IconImageUri", leaderboardScore.getScoreHolderIconImageUri()).m1220a("IconImageUrl", leaderboardScore.getScoreHolderIconImageUrl()).m1220a("HiResImageUri", leaderboardScore.getScoreHolderHiResImageUri()).m1220a("HiResImageUrl", leaderboardScore.getScoreHolderHiResImageUrl()).m1220a("Player", leaderboardScore.getScoreHolder() == null ? null : leaderboardScore.getScoreHolder()).m1220a("ScoreTag", leaderboardScore.getScoreTag()).toString();
    }

    public boolean equals(Object obj) {
        return m3460a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return iC();
    }

    public String getDisplayRank() {
        return this.Sv;
    }

    public void getDisplayRank(CharArrayBuffer dataOut) {
        ik.m1275b(this.Sv, dataOut);
    }

    public String getDisplayScore() {
        return this.Sw;
    }

    public void getDisplayScore(CharArrayBuffer dataOut) {
        ik.m1275b(this.Sw, dataOut);
    }

    public long getRank() {
        return this.Su;
    }

    public long getRawScore() {
        return this.Sx;
    }

    public Player getScoreHolder() {
        return this.SC;
    }

    public String getScoreHolderDisplayName() {
        return this.SC == null ? this.Sz : this.SC.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer dataOut) {
        if (this.SC == null) {
            ik.m1275b(this.Sz, dataOut);
        } else {
            this.SC.getDisplayName(dataOut);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return this.SC == null ? this.SB : this.SC.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        return this.SC == null ? this.SF : this.SC.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return this.SC == null ? this.SA : this.SC.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return this.SC == null ? this.SE : this.SC.getIconImageUrl();
    }

    public String getScoreTag() {
        return this.SD;
    }

    public long getTimestampMillis() {
        return this.Sy;
    }

    public int hashCode() {
        return m3459a(this);
    }

    public LeaderboardScore iC() {
        return this;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return m3461b(this);
    }
}
