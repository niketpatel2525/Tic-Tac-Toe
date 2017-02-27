package com.google.android.gms.internal;

import com.google.android.gms.location.DetectedActivity;

public final class eu {
    public static String m571R(int i) {
        switch (i) {
            case DetectedActivity.IN_VEHICLE /*0*/:
                return "PUBLIC";
            case DetectedActivity.ON_BICYCLE /*1*/:
                return "SOCIAL";
            default:
                throw new IllegalArgumentException("Unknown leaderboard collection: " + i);
        }
    }
}
