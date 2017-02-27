package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0055b;
import com.google.android.gms.common.data.C0345d;
import com.google.android.gms.games.C0568d;
import com.google.android.gms.games.Player;

/* renamed from: com.google.android.gms.games.multiplayer.d */
public final class C0572d extends C0055b implements Participant {
    private final C0568d nZ;

    public C0572d(C0345d c0345d, int i) {
        super(c0345d, i);
        this.nZ = new C0568d(c0345d, i);
    }

    public String ci() {
        return getString("client_address");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return ParticipantEntity.m2078a(this, obj);
    }

    public Participant freeze() {
        return new ParticipantEntity(this);
    }

    public int getCapabilities() {
        return getInteger("capabilities");
    }

    public String getDisplayName() {
        return m42v("external_player_id") ? getString("default_display_name") : this.nZ.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        if (m42v("external_player_id")) {
            m40a("default_display_name", dataOut);
        } else {
            this.nZ.getDisplayName(dataOut);
        }
    }

    public Uri getHiResImageUri() {
        return m42v("external_player_id") ? null : this.nZ.getHiResImageUri();
    }

    public Uri getIconImageUri() {
        return m42v("external_player_id") ? m41u("default_display_image_uri") : this.nZ.getIconImageUri();
    }

    public String getParticipantId() {
        return getString("external_participant_id");
    }

    public Player getPlayer() {
        return m42v("external_player_id") ? null : this.nZ;
    }

    public int getStatus() {
        return getInteger("player_status");
    }

    public int hashCode() {
        return ParticipantEntity.m2077a(this);
    }

    public boolean isConnectedToRoom() {
        return getInteger("connected") > 0;
    }

    public String toString() {
        return ParticipantEntity.m2079b((Participant) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((ParticipantEntity) freeze()).writeToParcel(dest, flags);
    }
}
