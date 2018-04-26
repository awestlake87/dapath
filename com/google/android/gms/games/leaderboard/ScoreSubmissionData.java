package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.internal.hk;
import com.google.android.gms.internal.hk.C0352a;
import com.google.android.gms.internal.hm;
import java.util.HashMap;

public final class ScoreSubmissionData {
    private static final String[] Sn = new String[]{"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    private int CT;
    private String MS;
    private HashMap<Integer, Result> ST = new HashMap();
    private String Sp;

    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public Result(long rawScore, String formattedScore, String scoreTag, boolean newBest) {
            this.rawScore = rawScore;
            this.formattedScore = formattedScore;
            this.scoreTag = scoreTag;
            this.newBest = newBest;
        }

        public String toString() {
            return hk.m1221e(this).m1220a("RawScore", Long.valueOf(this.rawScore)).m1220a("FormattedScore", this.formattedScore).m1220a("ScoreTag", this.scoreTag).m1220a("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    public ScoreSubmissionData(DataHolder dataHolder) {
        this.CT = dataHolder.getStatusCode();
        int count = dataHolder.getCount();
        hm.m1225C(count == 3);
        for (int i = 0; i < count; i++) {
            int ae = dataHolder.ae(i);
            if (i == 0) {
                this.Sp = dataHolder.m2012c("leaderboardId", i, ae);
                this.MS = dataHolder.m2012c("playerId", i, ae);
            }
            if (dataHolder.m2013d("hasResult", i, ae)) {
                m739a(new Result(dataHolder.m2008a("rawScore", i, ae), dataHolder.m2012c("formattedScore", i, ae), dataHolder.m2012c("scoreTag", i, ae), dataHolder.m2013d("newBest", i, ae)), dataHolder.m2010b("timeSpan", i, ae));
            }
        }
    }

    private void m739a(Result result, int i) {
        this.ST.put(Integer.valueOf(i), result);
    }

    public String getLeaderboardId() {
        return this.Sp;
    }

    public String getPlayerId() {
        return this.MS;
    }

    public Result getScoreResult(int timeSpan) {
        return (Result) this.ST.get(Integer.valueOf(timeSpan));
    }

    public String toString() {
        C0352a a = hk.m1221e(this).m1220a("PlayerId", this.MS).m1220a("StatusCode", Integer.valueOf(this.CT));
        for (int i = 0; i < 3; i++) {
            Result result = (Result) this.ST.get(Integer.valueOf(i));
            a.m1220a("TimesSpan", TimeSpan.cm(i));
            a.m1220a("Result", result == null ? "null" : result.toString());
        }
        return a.toString();
    }
}
