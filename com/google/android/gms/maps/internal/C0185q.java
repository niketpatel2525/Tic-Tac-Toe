package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0566c;
import com.google.android.gms.internal.dm;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.maps.internal.C0171c.C0497a;
import com.google.android.gms.maps.model.RuntimeRemoteException;

/* renamed from: com.google.android.gms.maps.internal.q */
public class C0185q {
    private static Context pW;
    private static C0171c pX;

    private static <T> T m727a(ClassLoader classLoader, String str) {
        try {
            return C0185q.m728c(((ClassLoader) dm.m392e(classLoader)).loadClass(str));
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Unable to find dynamic class " + str);
        }
    }

    private static <T> T m728c(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException("Unable to instantiate the dynamic class " + cls.getName());
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unable to call the default constructor of " + cls.getName());
        }
    }

    private static boolean cI() {
        return C0185q.cJ() != null;
    }

    private static Class<?> cJ() {
        try {
            return Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    private static Context getRemoteContext(Context context) {
        if (pW == null) {
            if (C0185q.cI()) {
                pW = context;
            } else {
                pW = GooglePlayServicesUtil.getRemoteContext(context);
            }
        }
        return pW;
    }

    public static C0171c m729u(Context context) throws GooglePlayServicesNotAvailableException {
        dm.m392e(context);
        if (pX != null) {
            return pX;
        }
        C0185q.m730v(context);
        pX = C0185q.m731w(context);
        try {
            pX.m713a(C0566c.m1773g(C0185q.getRemoteContext(context).getResources()), (int) GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            return pX;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    private static void m730v(Context context) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        switch (isGooglePlayServicesAvailable) {
            case DetectedActivity.IN_VEHICLE /*0*/:
            default:
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
    }

    private static C0171c m731w(Context context) {
        if (!C0185q.cI()) {
            return C0497a.m1551J((IBinder) C0185q.m727a(C0185q.getRemoteContext(context).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
        }
        Log.i(C0185q.class.getSimpleName(), "Making Creator statically");
        return (C0171c) C0185q.m728c(C0185q.cJ());
    }
}
