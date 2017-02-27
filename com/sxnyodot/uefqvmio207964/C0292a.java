package com.sxnyodot.uefqvmio207964;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.DetectedActivity;
import java.io.IOException;

/* renamed from: com.sxnyodot.uefqvmio207964.a */
final class C0292a extends AsyncTask<Void, Void, Boolean> {
    private static boolean f366c;
    private final String f367a;
    private final Context f368b;
    private final C0293b<Boolean> f369d;

    protected /* synthetic */ Object doInBackground(Object[] x0) {
        return m1002a((Void[]) x0);
    }

    protected /* synthetic */ void onPostExecute(Object x0) {
        m1003a((Boolean) x0);
    }

    static {
        f366c = false;
    }

    public static boolean m1001a() {
        return f366c;
    }

    public C0292a(Context context, C0293b<Boolean> c0293b) {
        this.f367a = C0301h.TAG;
        this.f368b = context;
        this.f369d = c0293b;
    }

    protected void onPreExecute() {
        f366c = true;
    }

    protected Boolean m1002a(Void... voidArr) {
        boolean z;
        Throwable e;
        Throwable th;
        String str = "";
        Boolean bool = Boolean.FALSE;
        try {
            Object obj;
            Boolean bool2;
            Boolean bool3;
            switch (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.f368b)) {
                case DetectedActivity.IN_VEHICLE /*0*/:
                    Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f368b);
                    str = advertisingIdInfo.getId();
                    bool = Boolean.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled());
                    Util.m938b(str);
                    Util.m931a(bool.booleanValue());
                    bool2 = bool;
                    z = true;
                    bool3 = bool2;
                    break;
                case DetectedActivity.ON_BICYCLE /*1*/:
                    str = "SERVICE_MISSING";
                    bool2 = bool;
                    z = false;
                    bool3 = bool2;
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str = "SERVICE_VERSION_UPDATE_REQUIRED";
                    bool2 = bool;
                    z = false;
                    bool3 = bool2;
                    break;
                case DetectedActivity.STILL /*3*/:
                    str = "SERVICE_DISABLED";
                    bool2 = bool;
                    z = false;
                    bool3 = bool2;
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    str = "SERVICE_INVALID";
                    bool2 = bool;
                    z = false;
                    bool3 = bool2;
                    break;
                default:
                    bool2 = bool;
                    z = false;
                    obj = bool2;
                    break;
            }
            try {
                Util.m929a("Advertisment id: " + str);
                Util.m929a("Ad opt out enabled : " + obj);
            } catch (IOException e2) {
                e = e2;
                Log.w(C0301h.TAG, "IOException", e);
                return Boolean.valueOf(z);
            } catch (GooglePlayServicesNotAvailableException e3) {
                e = e3;
                Log.w(C0301h.TAG, "GooglePlayServicesNotAvailableException", e);
                return Boolean.valueOf(z);
            } catch (IllegalStateException e4) {
                e = e4;
                Log.w(C0301h.TAG, "IllegalStateException", e);
                return Boolean.valueOf(z);
            } catch (GooglePlayServicesRepairableException e5) {
                e = e5;
                Log.w(C0301h.TAG, "GooglePlayServicesRepairableException", e);
                return Boolean.valueOf(z);
            } catch (Exception e6) {
                e = e6;
                Log.w(C0301h.TAG, "Exception occurred while fetching advertiser id", e);
                return Boolean.valueOf(z);
            }
        } catch (Throwable e7) {
            th = e7;
            z = false;
            e = th;
            Log.w(C0301h.TAG, "IOException", e);
            return Boolean.valueOf(z);
        } catch (Throwable e72) {
            th = e72;
            z = false;
            e = th;
            Log.w(C0301h.TAG, "GooglePlayServicesNotAvailableException", e);
            return Boolean.valueOf(z);
        } catch (Throwable e722) {
            th = e722;
            z = false;
            e = th;
            Log.w(C0301h.TAG, "IllegalStateException", e);
            return Boolean.valueOf(z);
        } catch (Throwable e7222) {
            th = e7222;
            z = false;
            e = th;
            Log.w(C0301h.TAG, "GooglePlayServicesRepairableException", e);
            return Boolean.valueOf(z);
        } catch (Throwable e72222) {
            th = e72222;
            z = false;
            e = th;
            Log.w(C0301h.TAG, "Exception occurred while fetching advertiser id", e);
            return Boolean.valueOf(z);
        }
        return Boolean.valueOf(z);
    }

    protected void m1003a(Boolean bool) {
        f366c = false;
        if (this.f369d != null) {
            this.f369d.m1005a(bool);
        }
    }
}
