package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.C0345d;
import com.google.android.gms.common.data.C0346f;

public final class LeaderboardBuffer extends C0346f<Leaderboard> {
    public LeaderboardBuffer(C0345d dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object m1774a(int i, int i2) {
        return getEntry(i, i2);
    }

    protected Leaderboard getEntry(int rowIndex, int numChildren) {
        return new C0358a(this.jf, rowIndex, numChildren);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "external_leaderboard_id";
    }
}
