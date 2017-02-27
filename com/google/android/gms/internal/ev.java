package com.google.android.gms.internal;

import com.google.android.gms.location.DetectedActivity;

public final class ev {
    public static String m572R(int i) {
        switch (i) {
            case DetectedActivity.IN_VEHICLE /*0*/:
                return "DAILY";
            case DetectedActivity.ON_BICYCLE /*1*/:
                return "WEEKLY";
            case DetectedActivity.ON_FOOT /*2*/:
                return "ALL_TIME";
            default:
                throw new IllegalArgumentException("Unknown time span " + i);
        }
    }
}
