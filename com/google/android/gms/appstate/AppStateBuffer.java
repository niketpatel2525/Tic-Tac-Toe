package com.google.android.gms.appstate;

import com.google.android.gms.common.data.C0345d;
import com.google.android.gms.common.data.DataBuffer;

public final class AppStateBuffer extends DataBuffer<AppState> {
    public AppStateBuffer(C0345d dataHolder) {
        super(dataHolder);
    }

    public AppState get(int position) {
        return new C0565b(this.jf, position);
    }
}
