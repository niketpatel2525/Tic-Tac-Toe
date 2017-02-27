package com.google.android.gms.maps.internal;

import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.maps.internal.a */
public final class C0169a {
    public static Boolean m710a(byte b) {
        switch (b) {
            case DetectedActivity.IN_VEHICLE /*0*/:
                return Boolean.FALSE;
            case DetectedActivity.ON_BICYCLE /*1*/:
                return Boolean.TRUE;
            default:
                return null;
        }
    }

    public static byte m711b(Boolean bool) {
        return bool != null ? bool.booleanValue() ? (byte) 1 : (byte) 0 : (byte) -1;
    }
}
