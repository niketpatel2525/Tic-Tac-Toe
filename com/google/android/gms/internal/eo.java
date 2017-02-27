package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.sxnyodot.uefqvmio207964.C0304k;

public final class eo {
    public static final Intent m452c(Intent intent) {
        intent.setData(Uri.fromParts(C0304k.VERSION, Integer.toString(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE), null));
        return intent;
    }
}
