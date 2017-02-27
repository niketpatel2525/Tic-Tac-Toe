package com.google.android.gms.games.achievement;

import com.google.android.gms.common.data.C0345d;
import com.google.android.gms.common.data.DataBuffer;

public final class AchievementBuffer extends DataBuffer<Achievement> {
    public AchievementBuffer(C0345d dataHolder) {
        super(dataHolder);
    }

    public Achievement get(int position) {
        return new C0357a(this.jf, position);
    }
}
