package com.google.android.gms.games;

import com.google.android.gms.common.data.C0345d;
import com.google.android.gms.common.data.DataBuffer;

public final class GameBuffer extends DataBuffer<Game> {
    public GameBuffer(C0345d dataHolder) {
        super(dataHolder);
    }

    public Game get(int position) {
        return new C0567b(this.jf, position);
    }
}
