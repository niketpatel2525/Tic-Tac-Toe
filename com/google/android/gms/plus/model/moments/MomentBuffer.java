package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.C0345d;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.internal.fu;

public final class MomentBuffer extends DataBuffer<Moment> {
    public MomentBuffer(C0345d dataHolder) {
        super(dataHolder);
    }

    public Moment get(int position) {
        return new fu(this.jf, position);
    }
}
