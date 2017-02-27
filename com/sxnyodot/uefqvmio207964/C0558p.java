package com.sxnyodot.uefqvmio207964;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.media.TransportMediator;
import android.util.Log;
import com.sxnyodot.uefqvmio207964.AdListener.AdType;
import org.json.JSONObject;

/* renamed from: com.sxnyodot.uefqvmio207964.p */
abstract class C0558p implements C0300g {
    private static final String TAG = "PrmSDK";
    private static boolean isSent;

    /* renamed from: com.sxnyodot.uefqvmio207964.p.1 */
    static class C03131 implements Runnable {
        final /* synthetic */ String f416a;

        C03131(String str) {
            this.f416a = str;
        }

        public void run() {
            Prm.adListener.onSDKIntegrationError(this.f416a);
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.p.2 */
    static class C03142 implements Runnable {
        final /* synthetic */ String f417a;

        C03142(String str) {
            this.f417a = str;
        }

        public void run() {
            Prm.adListener.onAdError(this.f417a);
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.p.3 */
    static class C03153 implements Runnable {
        C03153() {
        }

        public void run() {
            Prm.adListener.noAdAvailableListener();
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.p.4 */
    static class C03164 implements Runnable {
        final /* synthetic */ AdType f418a;

        C03164(AdType adType) {
            this.f418a = adType;
        }

        public void run() {
            Prm.adListener.onAdCached(this.f418a);
            Log.i(C0558p.TAG, "Ad cached: " + this.f418a);
        }
    }

    abstract void parseAppWallJson(String str);

    abstract void parseRichMediaInterstitialJson(JSONObject jSONObject);

    C0558p() {
    }

    static {
        isSent = false;
    }

    public static boolean isSDKEnabled(Context context) {
        boolean z = false;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(C0301h.SDK_PREFERENCE, 0);
            if (!(sharedPreferences == null || sharedPreferences.equals(null) || !sharedPreferences.contains(C0301h.SDK_ENABLED))) {
                z = sharedPreferences.getBoolean(C0301h.SDK_ENABLED, false);
            }
        } catch (Exception e) {
            Log.i(TAG, "" + e.getMessage());
        }
        return z;
    }

    public static void enableSDK(Context context, boolean enable) {
        try {
            Editor edit = context.getSharedPreferences(C0301h.SDK_PREFERENCE, 0).edit();
            edit.putBoolean(C0301h.SDK_ENABLED, enable);
            edit.commit();
            Log.i(TAG, "SDK enabled: " + enable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean getDataFromManifest(android.content.Context r6) {
        /*
        r0 = r6.getPackageManager();	 Catch:{ NameNotFoundException -> 0x00a4, Exception -> 0x00b3 }
        r1 = r6.getPackageName();	 Catch:{ NameNotFoundException -> 0x00a4, Exception -> 0x00b3 }
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r0 = r0.getApplicationInfo(r1, r2);	 Catch:{ NameNotFoundException -> 0x00a4, Exception -> 0x00b3 }
        r0 = r0.metaData;	 Catch:{ NameNotFoundException -> 0x00a4, Exception -> 0x00b3 }
        r1 = "com.sxnyodot.uefqvmio207964.APPID";
        r1 = r0.get(r1);	 Catch:{ NameNotFoundException -> 0x00a4, Exception -> 0x00b3 }
        r2 = r1.toString();	 Catch:{ NameNotFoundException -> 0x00a4, Exception -> 0x00b3 }
        if (r2 == 0) goto L_0x002f;
    L_0x001c:
        r1 = "";
        r1 = r2.equals(r1);	 Catch:{ NameNotFoundException -> 0x00a4, Exception -> 0x00b3 }
        if (r1 != 0) goto L_0x002f;
    L_0x0024:
        r1 = "0";
        r1 = r2.equals(r1);	 Catch:{ NameNotFoundException -> 0x00a4, Exception -> 0x00b3 }
        if (r1 != 0) goto L_0x002f;
    L_0x002c:
        com.sxnyodot.uefqvmio207964.Util.m951f(r2);	 Catch:{ NameNotFoundException -> 0x00a4, Exception -> 0x00b3 }
    L_0x002f:
        r1 = "";
        r3 = "com.sxnyodot.uefqvmio207964.APIKEY";
        r0 = r0.get(r3);	 Catch:{ Exception -> 0x00c1, NameNotFoundException -> 0x00a4 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00c1, NameNotFoundException -> 0x00a4 }
        if (r0 == 0) goto L_0x0080;
    L_0x003d:
        r1 = "";
        r1 = r0.equals(r1);	 Catch:{ Exception -> 0x0086, NameNotFoundException -> 0x00a4 }
        if (r1 != 0) goto L_0x0080;
    L_0x0045:
        r1 = "0";
        r1 = r0.equals(r1);	 Catch:{ Exception -> 0x0086, NameNotFoundException -> 0x00a4 }
        if (r1 != 0) goto L_0x0080;
    L_0x004d:
        r1 = new java.util.StringTokenizer;	 Catch:{ Exception -> 0x0086, NameNotFoundException -> 0x00a4 }
        r3 = "*";
        r1.<init>(r0, r3);	 Catch:{ Exception -> 0x0086, NameNotFoundException -> 0x00a4 }
        r1.nextToken();	 Catch:{ Exception -> 0x0086, NameNotFoundException -> 0x00a4 }
        r0 = r1.nextToken();	 Catch:{ Exception -> 0x0086, NameNotFoundException -> 0x00a4 }
        com.sxnyodot.uefqvmio207964.Util.m948e(r0);	 Catch:{ Exception -> 0x0086, NameNotFoundException -> 0x00a4 }
    L_0x005e:
        r1 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x00a4, Exception -> 0x00b3 }
        r1.<init>();	 Catch:{ NameNotFoundException -> 0x00a4, Exception -> 0x00b3 }
        r3 = "AppId: ";
        r1 = r1.append(r3);	 Catch:{ NameNotFoundException -> 0x00a4, Exception -> 0x00b3 }
        r1 = r1.append(r2);	 Catch:{ NameNotFoundException -> 0x00a4, Exception -> 0x00b3 }
        r2 = " ApiKey=";
        r1 = r1.append(r2);	 Catch:{ NameNotFoundException -> 0x00a4, Exception -> 0x00b3 }
        r0 = r1.append(r0);	 Catch:{ NameNotFoundException -> 0x00a4, Exception -> 0x00b3 }
        r0 = r0.toString();	 Catch:{ NameNotFoundException -> 0x00a4, Exception -> 0x00b3 }
        com.sxnyodot.uefqvmio207964.Util.m929a(r0);	 Catch:{ NameNotFoundException -> 0x00a4, Exception -> 0x00b3 }
        r0 = 1;
    L_0x007f:
        return r0;
    L_0x0080:
        r1 = "airplay";
        com.sxnyodot.uefqvmio207964.Util.m948e(r1);	 Catch:{ Exception -> 0x0086, NameNotFoundException -> 0x00a4 }
        goto L_0x005e;
    L_0x0086:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r5;
    L_0x008a:
        r3 = "PrmSDK";
        r4 = "Problem with fetching apiKey. Please chcek your APIKEY declaration in Manifest. It should be same as given in SDK doc.";
        android.util.Log.e(r3, r4, r0);	 Catch:{ NameNotFoundException -> 0x00a4, Exception -> 0x00b3 }
        r0 = new com.sxnyodot.uefqvmio207964.o;	 Catch:{ NameNotFoundException -> 0x00a4, Exception -> 0x00b3 }
        r3 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r0.<init>(r6, r3);	 Catch:{ NameNotFoundException -> 0x00a4, Exception -> 0x00b3 }
        r0 = "airplay";
        com.sxnyodot.uefqvmio207964.Util.m948e(r0);	 Catch:{ NameNotFoundException -> 0x00a4, Exception -> 0x00b3 }
        r0 = "Please check your APIKEY declaration in Manifest. It must be same as given in doc.";
        com.sxnyodot.uefqvmio207964.C0558p.sendIntegrationError(r0);	 Catch:{ NameNotFoundException -> 0x00a4, Exception -> 0x00b3 }
        r0 = r1;
        goto L_0x005e;
    L_0x00a4:
        r0 = move-exception;
        r1 = "PrmSDK";
        r2 = "AppId or ApiKey not found in Manifest. Please add.";
        android.util.Log.e(r1, r2, r0);
        r0 = "AppId or ApiKey not found in Manifest. Please add.";
        com.sxnyodot.uefqvmio207964.C0558p.sendIntegrationError(r0);
    L_0x00b1:
        r0 = 0;
        goto L_0x007f;
    L_0x00b3:
        r0 = move-exception;
        r1 = "PrmSDK";
        r2 = "Please check your SDK declarations in Manifest. This errors comes when SDK unable to fetch APPID or APIKEY from Manifest. SDK Package Name: ";
        android.util.Log.e(r1, r2, r0);
        r0 = "Please check your SDK declarations in Manifest. This error comes when SDK unable to fetch APPID or APIKEY from Manifest.";
        com.sxnyodot.uefqvmio207964.C0558p.sendIntegrationError(r0);
        goto L_0x00b1;
    L_0x00c1:
        r0 = move-exception;
        goto L_0x008a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sxnyodot.uefqvmio207964.p.getDataFromManifest(android.content.Context):boolean");
    }

    static boolean checkRequiredPermission(Context mContext) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        boolean z4 = mContext.checkCallingOrSelfPermission("android.permission.INTERNET") == 0;
        if (mContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
            z = true;
        } else {
            z = false;
        }
        if (mContext.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z4) {
            z4 = true;
        } else {
            Log.e(TAG, "Required INTERNET permission not found in manifest.");
            C0558p.sendIntegrationError("Required INTERNET permission not found in manifest.");
            z4 = false;
        }
        if (!z) {
            Log.e(TAG, "Required ACCESS_NETWORK_STATE permission not found in manifest.");
            C0558p.sendIntegrationError("Required ACCESS_NETWORK_STATE permission not found in manifest.");
            z4 = false;
        }
        if (z2) {
            z3 = z4;
        } else {
            Log.e(TAG, "Required READ_PHONE_STATE permission not found in manifest.");
            C0558p.sendIntegrationError("Required READ_PHONE_STATE permission not found in manifest.");
        }
        if (!(z3 || isSent)) {
            C0312o c0312o = new C0312o(mContext, 100);
            isSent = true;
        }
        return z3;
    }

    static void sendIntegrationError(String message) {
        try {
            if (Prm.adListener != null) {
                Prm.handler.post(new C03131(message));
            }
        } catch (Exception e) {
            try {
                Prm.adListener.onSDKIntegrationError(message);
            } catch (Exception e2) {
            }
        }
    }

    static void sendAdError(String message) {
        try {
            if (Prm.adListener != null) {
                Prm.handler.post(new C03142(message));
            }
        } catch (Exception e) {
            try {
                Prm.adListener.onAdError(message);
            } catch (Exception e2) {
            }
        }
    }

    static void sendNoAdMessage() {
        try {
            if (Prm.adListener != null) {
                Prm.handler.post(new C03153());
            }
        } catch (Exception e) {
            try {
                Prm.adListener.noAdAvailableListener();
            } catch (Exception e2) {
            }
        }
    }

    static void sendAdCached(AdType adType) {
        try {
            if (Prm.adListener != null) {
                Prm.handler.post(new C03164(adType));
            }
        } catch (Exception e) {
            try {
                Prm.adListener.onAdCached(adType);
            } catch (Exception e2) {
            }
        }
    }

    static boolean validate(Context context) {
        try {
            String obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), TransportMediator.FLAG_KEY_MEDIA_NEXT).metaData.get("com.google.android.gms.version").toString();
            if (!(obj == null || obj.equals("") || obj.equals("0"))) {
                return true;
            }
        } catch (Throwable e) {
            Log.e(TAG, "com.google.android.gms.version is not added in Manifest, Please add", e);
            C0558p.sendIntegrationError("com.google.android.gms.version is not added in Manifest, Please add.");
        } catch (Throwable e2) {
            Log.e(TAG, "com.google.android.gms.version is not added in Manifest, Please add", e2);
            C0558p.sendIntegrationError("com.google.android.gms.version is not added in Manifest, Please add");
        }
        return false;
    }
}
