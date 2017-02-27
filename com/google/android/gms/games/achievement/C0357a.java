package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.C0055b;
import com.google.android.gms.common.data.C0345d;
import com.google.android.gms.games.C0568d;
import com.google.android.gms.games.Player;
import com.google.android.gms.internal.db;
import com.google.android.gms.internal.dl;
import com.google.android.gms.internal.dl.C0140a;
import com.google.android.gms.plus.PlusShare;
import com.sxnyodot.uefqvmio207964.C0304k;

/* renamed from: com.google.android.gms.games.achievement.a */
public final class C0357a extends C0055b implements Achievement {
    C0357a(C0345d c0345d, int i) {
        super(c0345d, i);
    }

    public String getAchievementId() {
        return getString("external_achievement_id");
    }

    public int getCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        db.m343k(z);
        return getInteger("current_steps");
    }

    public String getDescription() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
    }

    public void getDescription(CharArrayBuffer dataOut) {
        m40a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, dataOut);
    }

    public String getFormattedCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        db.m343k(z);
        return getString("formatted_current_steps");
    }

    public void getFormattedCurrentSteps(CharArrayBuffer dataOut) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        db.m343k(z);
        m40a("formatted_current_steps", dataOut);
    }

    public String getFormattedTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        db.m343k(z);
        return getString("formatted_total_steps");
    }

    public void getFormattedTotalSteps(CharArrayBuffer dataOut) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        db.m343k(z);
        m40a("formatted_total_steps", dataOut);
    }

    public long getLastUpdatedTimestamp() {
        return getLong("last_updated_timestamp");
    }

    public String getName() {
        return getString("name");
    }

    public void getName(CharArrayBuffer dataOut) {
        m40a("name", dataOut);
    }

    public Player getPlayer() {
        return new C0568d(this.jf, this.ji);
    }

    public Uri getRevealedImageUri() {
        return m41u("revealed_icon_image_uri");
    }

    public int getState() {
        return getInteger("state");
    }

    public int getTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        db.m343k(z);
        return getInteger("total_steps");
    }

    public int getType() {
        return getInteger(C0304k.MEDIA_FILE_TYPE);
    }

    public Uri getUnlockedImageUri() {
        return m41u("unlocked_icon_image_uri");
    }

    public String toString() {
        C0140a a = dl.m387d(this).m386a(C0304k.ID, getAchievementId()).m386a("name", getName()).m386a("state", Integer.valueOf(getState())).m386a(C0304k.MEDIA_FILE_TYPE, Integer.valueOf(getType()));
        if (getType() == 1) {
            a.m386a("steps", getCurrentSteps() + "/" + getTotalSteps());
        }
        return a.toString();
    }
}
