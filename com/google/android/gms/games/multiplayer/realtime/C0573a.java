package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.C0345d;
import com.google.android.gms.common.data.C0346f;

/* renamed from: com.google.android.gms.games.multiplayer.realtime.a */
public final class C0573a extends C0346f<Room> {
    public C0573a(C0345d c0345d) {
        super(c0345d);
    }

    protected /* synthetic */ Object m1779a(int i, int i2) {
        return m1780b(i, i2);
    }

    protected Room m1780b(int i, int i2) {
        return new C0574c(this.jf, i, i2);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "external_match_id";
    }
}
