package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.C0074e;
import com.google.android.gms.dynamic.C0566c;
import com.google.android.gms.internal.ac.C0367a;
import com.google.android.gms.internal.ad.C0369a;

/* renamed from: com.google.android.gms.internal.u */
public final class C0468u extends C0074e<ad> {
    private static final C0468u er;

    static {
        er = new C0468u();
    }

    private C0468u() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public static ac m1522a(Context context, C0470x c0470x, String str, av avVar) {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(context) == 0) {
            ac b = er.m1523b(context, c0470x, str, avVar);
            if (b != null) {
                return b;
            }
        }
        cn.m295m("Using AdManager from the client jar.");
        return new C0602r(context, c0470x, str, avVar, new co(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE, true));
    }

    private ac m1523b(Context context, C0470x c0470x, String str, av avVar) {
        try {
            return C0367a.m1127f(((ad) m145t(context)).m173a(C0566c.m1773g(context), c0470x, str, avVar, GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE));
        } catch (Throwable e) {
            cn.m293b("Could not create remote AdManager.", e);
            return null;
        } catch (Throwable e2) {
            cn.m293b("Could not create remote AdManager.", e2);
            return null;
        }
    }

    protected ad m1524c(IBinder iBinder) {
        return C0369a.m1129g(iBinder);
    }

    protected /* synthetic */ Object m1525d(IBinder iBinder) {
        return m1524c(iBinder);
    }
}
