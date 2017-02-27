package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.C0055b;
import com.google.android.gms.common.data.C0345d;

/* renamed from: com.google.android.gms.games.d */
public final class C0568d extends C0055b implements Player {
    public C0568d(C0345d c0345d, int i) {
        super(c0345d, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return PlayerEntity.m2068a(this, obj);
    }

    public Player freeze() {
        return new PlayerEntity(this);
    }

    public String getDisplayName() {
        return getString("profile_name");
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        m40a("profile_name", dataOut);
    }

    public Uri getHiResImageUri() {
        return m41u("profile_hi_res_image_uri");
    }

    public Uri getIconImageUri() {
        return m41u("profile_icon_image_uri");
    }

    public String getPlayerId() {
        return getString("external_player_id");
    }

    public long getRetrievedTimestamp() {
        return getLong("last_updated");
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return PlayerEntity.m2067a(this);
    }

    public String toString() {
        return PlayerEntity.m2069b((Player) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((PlayerEntity) freeze()).writeToParcel(dest, flags);
    }
}
