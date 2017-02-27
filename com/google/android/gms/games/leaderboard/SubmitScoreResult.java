package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C0345d;
import com.google.android.gms.internal.dl;
import com.google.android.gms.internal.dl.C0140a;
import com.google.android.gms.internal.dm;
import com.google.android.gms.internal.ev;
import java.util.HashMap;

public final class SubmitScoreResult {
    private static final String[] nI;
    private int iC;
    private String mD;
    private String nJ;
    private HashMap<Integer, Result> nK;

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
            return dl.m387d(this).m386a("RawScore", Long.valueOf(this.rawScore)).m386a("FormattedScore", this.formattedScore).m386a("ScoreTag", this.scoreTag).m386a("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    static {
        nI = new String[]{"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    }

    public SubmitScoreResult(int statusCode, String leaderboardId, String playerId) {
        this(statusCode, leaderboardId, playerId, new HashMap());
    }

    public SubmitScoreResult(int statusCode, String leaderboardId, String playerId, HashMap<Integer, Result> results) {
        this.iC = statusCode;
        this.nJ = leaderboardId;
        this.mD = playerId;
        this.nK = results;
    }

    public SubmitScoreResult(C0345d dataHolder) {
        this.iC = dataHolder.getStatusCode();
        this.nK = new HashMap();
        int count = dataHolder.getCount();
        dm.m394m(count == 3);
        for (int i = 0; i < count; i++) {
            int q = dataHolder.m1102q(i);
            if (i == 0) {
                this.nJ = dataHolder.m1097c("leaderboardId", i, q);
                this.mD = dataHolder.m1097c("playerId", i, q);
            }
            if (dataHolder.m1098d("hasResult", i, q)) {
                m152a(new Result(dataHolder.m1093a("rawScore", i, q), dataHolder.m1097c("formattedScore", i, q), dataHolder.m1097c("scoreTag", i, q), dataHolder.m1098d("newBest", i, q)), dataHolder.m1095b("timeSpan", i, q));
            }
        }
    }

    private void m152a(Result result, int i) {
        this.nK.put(Integer.valueOf(i), result);
    }

    public String getLeaderboardId() {
        return this.nJ;
    }

    public String getPlayerId() {
        return this.mD;
    }

    public Result getScoreResult(int timeSpan) {
        return (Result) this.nK.get(Integer.valueOf(timeSpan));
    }

    public int getStatusCode() {
        return this.iC;
    }

    public String toString() {
        C0140a a = dl.m387d(this).m386a("PlayerId", this.mD).m386a("StatusCode", Integer.valueOf(this.iC));
        for (int i = 0; i < 3; i++) {
            Result result = (Result) this.nK.get(Integer.valueOf(i));
            a.m386a("TimesSpan", ev.m572R(i));
            a.m386a("Result", result == null ? "null" : result.toString());
        }
        return a.toString();
    }
}
