package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C0055b;
import com.google.android.gms.common.data.C0345d;
import com.google.android.gms.internal.dl;
import com.google.android.gms.internal.eu;
import com.google.android.gms.internal.ev;

/* renamed from: com.google.android.gms.games.leaderboard.e */
public final class C0359e extends C0055b implements LeaderboardVariant {
    C0359e(C0345d c0345d, int i) {
        super(c0345d, i);
    }

    public String ce() {
        return getString("top_page_token_next");
    }

    public String cf() {
        return getString("window_page_token_prev");
    }

    public String cg() {
        return getString("window_page_token_next");
    }

    public int getCollection() {
        return getInteger("collection");
    }

    public String getDisplayPlayerRank() {
        return getString("player_display_rank");
    }

    public String getDisplayPlayerScore() {
        return getString("player_display_score");
    }

    public long getNumScores() {
        return m42v("total_scores") ? -1 : getLong("total_scores");
    }

    public long getPlayerRank() {
        return m42v("player_rank") ? -1 : getLong("player_rank");
    }

    public String getPlayerScoreTag() {
        return getString("player_score_tag");
    }

    public long getRawPlayerScore() {
        return m42v("player_raw_score") ? -1 : getLong("player_raw_score");
    }

    public int getTimeSpan() {
        return getInteger("timespan");
    }

    public boolean hasPlayerInfo() {
        return !m42v("player_raw_score");
    }

    public String toString() {
        return dl.m387d(this).m386a("TimeSpan", ev.m572R(getTimeSpan())).m386a("Collection", eu.m571R(getCollection())).m386a("RawPlayerScore", hasPlayerInfo() ? Long.valueOf(getRawPlayerScore()) : IM.ORIENTATION_NONE).m386a("DisplayPlayerScore", hasPlayerInfo() ? getDisplayPlayerScore() : IM.ORIENTATION_NONE).m386a("PlayerRank", hasPlayerInfo() ? Long.valueOf(getPlayerRank()) : IM.ORIENTATION_NONE).m386a("DisplayPlayerRank", hasPlayerInfo() ? getDisplayPlayerRank() : IM.ORIENTATION_NONE).m386a("NumScores", Long.valueOf(getNumScores())).m386a("TopPageNextToken", ce()).m386a("WindowPageNextToken", cg()).m386a("WindowPagePrevToken", cf()).toString();
    }
}
