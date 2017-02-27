package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.C0055b;
import com.google.android.gms.common.data.C0345d;
import com.google.android.gms.games.C0568d;
import com.google.android.gms.games.Player;

/* renamed from: com.google.android.gms.games.leaderboard.d */
public final class C0570d extends C0055b implements LeaderboardScore {
    private final C0568d nH;

    C0570d(C0345d c0345d, int i) {
        super(c0345d, i);
        this.nH = new C0568d(c0345d, i);
    }

    public LeaderboardScore cd() {
        return new C0569c(this);
    }

    public boolean equals(Object obj) {
        return C0569c.m1776a(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return cd();
    }

    public String getDisplayRank() {
        return getString("display_rank");
    }

    public void getDisplayRank(CharArrayBuffer dataOut) {
        m40a("display_rank", dataOut);
    }

    public String getDisplayScore() {
        return getString("display_score");
    }

    public void getDisplayScore(CharArrayBuffer dataOut) {
        m40a("display_score", dataOut);
    }

    public long getRank() {
        return getLong("rank");
    }

    public long getRawScore() {
        return getLong("raw_score");
    }

    public Player getScoreHolder() {
        return m42v("external_player_id") ? null : this.nH;
    }

    public String getScoreHolderDisplayName() {
        return m42v("external_player_id") ? getString("default_display_name") : this.nH.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer dataOut) {
        if (m42v("external_player_id")) {
            m40a("default_display_name", dataOut);
        } else {
            this.nH.getDisplayName(dataOut);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return m42v("external_player_id") ? null : this.nH.getHiResImageUri();
    }

    public Uri getScoreHolderIconImageUri() {
        return m42v("external_player_id") ? m41u("default_display_image_uri") : this.nH.getIconImageUri();
    }

    public String getScoreTag() {
        return getString("score_tag");
    }

    public long getTimestampMillis() {
        return getLong("achieved_timestamp");
    }

    public int hashCode() {
        return C0569c.m1775a(this);
    }

    public String toString() {
        return C0569c.m1777b(this);
    }
}
