package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.location.DetectedActivity;
import java.util.Date;
import java.util.HashSet;

public final class bb {

    /* renamed from: com.google.android.gms.internal.bb.1 */
    static /* synthetic */ class C01001 {
        static final /* synthetic */ int[] fw;
        static final /* synthetic */ int[] fx;

        static {
            fx = new int[ErrorCode.values().length];
            try {
                fx[ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                fx[ErrorCode.INVALID_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                fx[ErrorCode.NETWORK_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                fx[ErrorCode.NO_FILL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            fw = new int[Gender.values().length];
            try {
                fw[Gender.FEMALE.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                fw[Gender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                fw[Gender.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public static int m193a(ErrorCode errorCode) {
        switch (C01001.fx[errorCode.ordinal()]) {
            case DetectedActivity.ON_FOOT /*2*/:
                return 1;
            case DetectedActivity.STILL /*3*/:
                return 2;
            case DetectedActivity.UNKNOWN /*4*/:
                return 3;
            default:
                return 0;
        }
    }

    public static int m194a(Gender gender) {
        switch (C01001.fw[gender.ordinal()]) {
            case DetectedActivity.ON_BICYCLE /*1*/:
                return 2;
            case DetectedActivity.ON_FOOT /*2*/:
                return 1;
            default:
                return 0;
        }
    }

    public static AdSize m195a(C0470x c0470x) {
        return new AdSize(new com.google.android.gms.ads.AdSize(c0470x.width, c0470x.height, c0470x.ew));
    }

    public static Gender m196e(int i) {
        switch (i) {
            case DetectedActivity.ON_BICYCLE /*1*/:
                return Gender.MALE;
            case DetectedActivity.ON_FOOT /*2*/:
                return Gender.FEMALE;
            default:
                return Gender.UNKNOWN;
        }
    }

    public static MediationAdRequest m197e(C0469v c0469v) {
        return new MediationAdRequest(new Date(c0469v.es), m196e(c0469v.et), c0469v.eu != null ? new HashSet(c0469v.eu) : null, c0469v.ev);
    }

    public static final ErrorCode m198f(int i) {
        switch (i) {
            case DetectedActivity.ON_BICYCLE /*1*/:
                return ErrorCode.INVALID_REQUEST;
            case DetectedActivity.ON_FOOT /*2*/:
                return ErrorCode.NETWORK_ERROR;
            case DetectedActivity.STILL /*3*/:
                return ErrorCode.NO_FILL;
            default:
                return ErrorCode.INTERNAL_ERROR;
        }
    }
}
