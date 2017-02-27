package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.C0053a;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.C0160p;
import com.google.android.gms.internal.C0160p.C0467a;
import com.google.android.gms.internal.dm;
import java.io.IOException;

public final class AdvertisingIdClient {

    public static final class Info {
        private final String dX;
        private final boolean dY;

        Info(String advertisingId, boolean limitAdTrackingEnabled) {
            this.dX = advertisingId;
            this.dY = limitAdTrackingEnabled;
        }

        public String getId() {
            return this.dX;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.dY;
        }
    }

    private static C0053a m15g(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 0);
            try {
                GooglePlayServicesUtil.m32m(context);
                Object c0053a = new C0053a();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_PACKAGE);
                if (context.bindService(intent, c0053a, 1)) {
                    return c0053a;
                }
                throw new IOException("Connection failure");
            } catch (Throwable e) {
                throw new IOException(e);
            }
        } catch (NameNotFoundException e2) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        dm.m396x("Calling this from your main thread can lead to deadlock");
        ServiceConnection g = m15g(context);
        try {
            C0160p b = C0467a.m1521b(g.aG());
            Info info = new Info(b.getId(), b.m689a(true));
            context.unbindService(g);
            return info;
        } catch (Throwable e) {
            Log.i("AdvertisingIdClient", "GMS remote exception ", e);
            throw new IOException("Remote exception");
        } catch (InterruptedException e2) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            context.unbindService(g);
        }
    }
}
