package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C0345d;
import com.google.android.gms.common.data.DataBuffer;

public final class LeaderboardScoreBuffer extends DataBuffer<LeaderboardScore> {
    private final C0078b nv;

    public LeaderboardScoreBuffer(C0345d dataHolder) {
        super(dataHolder);
        this.nv = new C0078b(dataHolder.aM());
    }

    public C0078b cb() {
        return this.nv;
    }

    public LeaderboardScore get(int position) {
        return new C0570d(this.jf, position);
    }
}
