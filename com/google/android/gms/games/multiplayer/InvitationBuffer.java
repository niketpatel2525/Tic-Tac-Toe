package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.C0345d;
import com.google.android.gms.common.data.C0346f;

public final class InvitationBuffer extends C0346f<Invitation> {
    public InvitationBuffer(C0345d dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object m1778a(int i, int i2) {
        return getEntry(i, i2);
    }

    protected Invitation getEntry(int rowIndex, int numChildren) {
        return new C0571b(this.jf, rowIndex, numChildren);
    }

    protected String getPrimaryDataMarkerColumn() {
        return "external_invitation_id";
    }
}
