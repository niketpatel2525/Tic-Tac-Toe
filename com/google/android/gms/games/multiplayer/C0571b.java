package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.C0055b;
import com.google.android.gms.common.data.C0345d;
import com.google.android.gms.games.C0567b;
import com.google.android.gms.games.Game;
import com.google.android.gms.internal.dm;
import com.sxnyodot.uefqvmio207964.C0304k;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.games.multiplayer.b */
public final class C0571b extends C0055b implements Invitation {
    private final ArrayList<Participant> nQ;
    private final Game nS;
    private final C0572d nT;

    C0571b(C0345d c0345d, int i, int i2) {
        super(c0345d, i);
        this.nS = new C0567b(c0345d, i);
        this.nQ = new ArrayList(i2);
        String string = getString("external_inviter_id");
        Object obj = null;
        for (int i3 = 0; i3 < i2; i3++) {
            C0572d c0572d = new C0572d(this.jf, this.ji + i3);
            if (c0572d.getParticipantId().equals(string)) {
                obj = c0572d;
            }
            this.nQ.add(c0572d);
        }
        this.nT = (C0572d) dm.m388a(obj, (Object) "Must have a valid inviter!");
    }

    public int ch() {
        return getInteger(C0304k.MEDIA_FILE_TYPE);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return InvitationEntity.m2073a(this, obj);
    }

    public Invitation freeze() {
        return new InvitationEntity(this);
    }

    public long getCreationTimestamp() {
        return getLong("creation_timestamp");
    }

    public Game getGame() {
        return this.nS;
    }

    public String getInvitationId() {
        return getString("external_invitation_id");
    }

    public Participant getInviter() {
        return this.nT;
    }

    public ArrayList<Participant> getParticipants() {
        return this.nQ;
    }

    public int getVariant() {
        return getInteger("variant");
    }

    public int hashCode() {
        return InvitationEntity.m2072a(this);
    }

    public String toString() {
        return InvitationEntity.m2074b((Invitation) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((InvitationEntity) freeze()).writeToParcel(dest, flags);
    }
}
