package com.sxnyodot.uefqvmio207964;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.GravityCompat;
import android.util.Log;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.plus.PlusShare;
import com.sxnyodot.uefqvmio207964.AdListener.AdType;
import com.sxnyodot.uefqvmio207964.AdListener.BannerAdListener;
import com.sxnyodot.uefqvmio207964.AdListener.OptinListener;
import com.sxnyodot.uefqvmio207964.JP.ParseMraidJson;
import com.sxnyodot.uefqvmio207964.Util.NativeMraid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class Prm extends C0558p {
    static final String TAG = "PrmSDK";
    private static Activity activity;
    static AdListener adListener;
    private static C0295d cA;
    static String cache;
    static boolean enableCaching;
    static Handler handler;
    static boolean isDialogClosed;
    private static boolean isIntegrationIssue;
    private static boolean isShowOptinDialog;
    private static OptinListener optinListener;
    static ParseMraidJson parseMraidJson;
    private static long time;
    C0293b<Boolean> asyncTaskCompleteListener;
    Runnable optinRunnable;

    /* renamed from: com.sxnyodot.uefqvmio207964.Prm.11 */
    class AnonymousClass11 implements Runnable {
        final /* synthetic */ String f309a;
        final /* synthetic */ Prm f310b;

        AnonymousClass11(Prm prm, String str) {
            this.f310b = prm;
            this.f309a = str;
        }

        public void run() {
            Intent intent = new Intent(Prm.activity, MainActivity.class);
            intent.setFlags(268435456);
            intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
            intent.setAction("overlayad");
            intent.putExtra("adtype", this.f309a);
            Prm.activity.startActivity(intent);
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.Prm.2 */
    static class C02812 implements Runnable {
        C02812() {
        }

        public void run() {
            C0559q.m1745a(Prm.activity);
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.Prm.3 */
    static /* synthetic */ class C02823 {
        static final /* synthetic */ int[] f311a;

        static {
            f311a = new int[AdType.values().length];
            try {
                f311a[AdType.smartwall.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f311a[AdType.appwall.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f311a[AdType.interstitial.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f311a[AdType.video.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f311a[AdType.overlay.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.Prm.4 */
    class C02834 implements Runnable {
        final /* synthetic */ Prm f312a;

        C02834(Prm prm) {
            this.f312a = prm;
        }

        public void run() {
            String str;
            Exception exception;
            Intent intent;
            Throwable th;
            try {
                if (!MainActivity.m920a()) {
                    String str2 = "";
                    HttpURLConnection httpURLConnection = null;
                    if (Util.m977o(Prm.activity)) {
                        try {
                            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(Base64.decodeString("aHR0cDovL2FwcG9ydGFsLmFpcnB1c2guY29tL3N0YW5kYXJkZXVsYTZfOS5odG1s")).openConnection();
                            try {
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection2.getInputStream()));
                                StringBuilder stringBuilder = new StringBuilder();
                                while (true) {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    stringBuilder.append(readLine);
                                }
                                String stringBuilder2 = stringBuilder.toString();
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                    str = stringBuilder2;
                                } else {
                                    str = stringBuilder2;
                                }
                            } catch (Exception e) {
                                Exception exception2 = e;
                                httpURLConnection = httpURLConnection2;
                                exception = exception2;
                                try {
                                    exception.printStackTrace();
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                        str = str2;
                                        intent = new Intent(Prm.activity, MainActivity.class);
                                        intent.setFlags(268435456);
                                        intent.addFlags(536870912);
                                        intent.putExtra("data", "" + str);
                                        intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                                        Prm.activity.startActivity(intent);
                                    }
                                    str = str2;
                                    intent = new Intent(Prm.activity, MainActivity.class);
                                    intent.setFlags(268435456);
                                    intent.addFlags(536870912);
                                    intent.putExtra("data", "" + str);
                                    intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                                    Prm.activity.startActivity(intent);
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                Throwable th4 = th3;
                                httpURLConnection = httpURLConnection2;
                                th = th4;
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                throw th;
                            }
                        } catch (Exception e2) {
                            exception = e2;
                            exception.printStackTrace();
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                                str = str2;
                                intent = new Intent(Prm.activity, MainActivity.class);
                                intent.setFlags(268435456);
                                intent.addFlags(536870912);
                                intent.putExtra("data", "" + str);
                                intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                                Prm.activity.startActivity(intent);
                            }
                            str = str2;
                            intent = new Intent(Prm.activity, MainActivity.class);
                            intent.setFlags(268435456);
                            intent.addFlags(536870912);
                            intent.putExtra("data", "" + str);
                            intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                            Prm.activity.startActivity(intent);
                        }
                        intent = new Intent(Prm.activity, MainActivity.class);
                        intent.setFlags(268435456);
                        intent.addFlags(536870912);
                        intent.putExtra("data", "" + str);
                        intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                        Prm.activity.startActivity(intent);
                    }
                    str = str2;
                    intent = new Intent(Prm.activity, MainActivity.class);
                    intent.setFlags(268435456);
                    intent.addFlags(536870912);
                    intent.putExtra("data", "" + str);
                    intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                    Prm.activity.startActivity(intent);
                }
            } catch (ActivityNotFoundException e3) {
                Log.e(Prm.TAG, "Required AdActivity not declared in Manifest, Please add.");
                C0558p.sendIntegrationError("Required AdActivity not declared in Manifest, Please add.");
            } catch (Exception exception3) {
                Log.e(Prm.TAG, "Error in Optin runnable: " + exception3.getMessage());
            }
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.Prm.1 */
    class C05481 implements C0293b<Boolean> {
        final /* synthetic */ Prm f524a;

        C05481(Prm prm) {
            this.f524a = prm;
        }

        public void m1629a(Boolean bool) {
            if (Prm.checkRequiredDetails(Prm.activity) && this.f524a.checkSmartWallintegration()) {
                Prm.isIntegrationIssue = false;
                Util.m944d();
                Prm.cA = new C0295d(Prm.activity);
                SharedPreferences sharedPreferences = Prm.activity.getSharedPreferences(C0301h.SDK_PREFERENCE, 0);
                if (sharedPreferences == null || !sharedPreferences.contains(C0301h.SDK_ENABLED)) {
                    C0558p.enableSDK(Prm.activity, true);
                }
                Prm.handler = new Handler();
                if (Prm.enableCaching) {
                    Prm.cache = "1";
                } else {
                    Prm.cache = "0";
                }
                Prm.isShowOptinDialog = C0559q.m1751g(Prm.activity);
                if (Prm.isShowOptinDialog && !MainActivity.m920a() && Prm.isDialogClosed) {
                    Prm.isDialogClosed = false;
                    new Thread(this.f524a.optinRunnable, "optin").start();
                    return;
                } else if (!Prm.isShowOptinDialog) {
                    this.f524a.info(Prm.activity);
                    return;
                } else {
                    return;
                }
            }
            Prm.isIntegrationIssue = true;
        }

        public void m1628a() {
            new C0292a(Prm.activity, this).execute(new Void[0]);
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.Prm.5 */
    class C05495 implements C0293b<String> {
        final /* synthetic */ Context f525a;
        final /* synthetic */ Prm f526b;

        C05495(Prm prm, Context context) {
            this.f526b = prm;
            this.f525a = context;
        }

        public void m1631a() {
            Prm.time = System.currentTimeMillis() + 1200000;
            List arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair(C0304k.PRICING_MODEL, C0301h.MODEL_USER));
            arrayList.add(new BasicNameValuePair(C0301h.ACTION, C0301h.ACTION_SET_USER_INFO));
            arrayList.add(new BasicNameValuePair(C0304k.MEDIA_FILE_TYPE, C0301h.TYPE_APP));
            new Thread(new C0305m(this.f525a, this, arrayList, C0301h.URL_API_MESSAGE, 20000, true), "sn").start();
        }

        public void m1633a(String str) {
            Log.i(Prm.TAG, "Info sent: " + str);
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.Prm.6 */
    class C05506 implements C0293b<String> {
        final /* synthetic */ Prm f527a;

        C05506(Prm prm) {
            this.f527a = prm;
        }

        public void m1636a(String str) {
            Log.i(Prm.TAG, "SmartWall JSON: " + str);
            if (str != null) {
                try {
                    if (!str.contains("<VAST") || VERSION.SDK_INT <= 7) {
                        JSONObject jSONObject = new JSONObject(str);
                        int i = jSONObject.isNull("status") ? 0 : jSONObject.getInt("status");
                        String string = jSONObject.isNull(C0301h.TYPE_MESSAGE) ? "" : jSONObject.getString(C0301h.TYPE_MESSAGE);
                        String string2 = jSONObject.isNull("adtype") ? "" : jSONObject.getString("adtype");
                        if (i != 200 || !string.equalsIgnoreCase("Success") || string2.equals("")) {
                            Prm.validateStatusCode(i, string);
                        } else if (Prm.enableCaching) {
                            Prm.cA.m1009a(AdType.smartwall, str);
                            C0558p.sendAdCached(AdType.smartwall);
                            Prm.cA.m1007a(true);
                        } else {
                            this.f527a.parseSmartwallJson(str);
                        }
                    } else if (Prm.enableCaching) {
                        new C0561t(Prm.activity).m1764a(str, true);
                    } else {
                        this.f527a.parseSmartwallJson(str);
                    }
                } catch (Throwable e) {
                    Log.e(Prm.TAG, "Error: ", e);
                }
            }
        }

        public void m1634a() {
            try {
                List arrayList = new ArrayList();
                arrayList.add(new BasicNameValuePair("banner_type", C0301h.RICH_MEDIA));
                arrayList.add(new BasicNameValuePair("supports", "" + Util.m985s(Prm.activity)));
                arrayList.add(new BasicNameValuePair("placement_type", "fullpage"));
                arrayList.add(new BasicNameValuePair("cache", Prm.cache));
                new Thread(new C0305m(Prm.activity, this, arrayList, C0301h.URL_INTERSTITIAL, 0, true), "SmartWall").start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.Prm.7 */
    class C05517 implements C0293b<String> {
        final /* synthetic */ Prm f528a;

        C05517(Prm prm) {
            this.f528a = prm;
        }

        public void m1639a(String str) {
            Log.i(Prm.TAG, "AppWall Json: " + str);
            if (str != null) {
                try {
                    if (Prm.enableCaching) {
                        JSONObject jSONObject = new JSONObject(str);
                        int i = jSONObject.isNull("status") ? 0 : jSONObject.getInt("status");
                        String string = jSONObject.isNull(C0301h.TYPE_MESSAGE) ? C0301h.INVALID : jSONObject.getString(C0301h.TYPE_MESSAGE);
                        if (i == 200 && string.equalsIgnoreCase("Success")) {
                            Prm.cA.m1009a(AdType.appwall, str);
                            C0558p.sendAdCached(AdType.appwall);
                            return;
                        }
                        Prm.validateStatusCode(i, string);
                        return;
                    }
                    this.f528a.parseAppWallJson(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void m1637a() {
            try {
                List arrayList = new ArrayList();
                arrayList.add(new BasicNameValuePair("cache", Prm.cache));
                new Thread(new C0305m(Prm.activity, this, arrayList, C0301h.URL_APP_WALL, 0, true), "AppWall").start();
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.Prm.8 */
    class C05528 implements C0293b<String> {
        final /* synthetic */ Prm f529a;

        C05528(Prm prm) {
            this.f529a = prm;
        }

        public void m1642a(String str) {
            Log.i(Prm.TAG, "Rich Media Ad Json: " + str);
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int i = jSONObject.isNull("status") ? 0 : jSONObject.getInt("status");
                    String string = jSONObject.isNull(C0301h.TYPE_MESSAGE) ? C0301h.INVALID : jSONObject.getString(C0301h.TYPE_MESSAGE);
                    String string2 = jSONObject.isNull("adtype") ? null : jSONObject.getString("adtype");
                    if (i != 200 || !string.equalsIgnoreCase("Success")) {
                        Prm.validateStatusCode(i, string);
                    } else if (string2 == null || !string2.equals(C0301h.AD_TYPE_MFP)) {
                        Log.w(Prm.TAG, "Invalid adtype: " + string2);
                    } else if (Prm.enableCaching) {
                        Prm.cA.m1009a(AdType.interstitial, str);
                        C0558p.sendAdCached(AdType.interstitial);
                    } else {
                        this.f529a.parseRichMediaInterstitialJson(jSONObject);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public void m1640a() {
            try {
                List arrayList = new ArrayList();
                arrayList.add(new BasicNameValuePair("banner_type", C0301h.RICH_MEDIA));
                arrayList.add(new BasicNameValuePair("supports", "" + Util.m985s(Prm.activity)));
                arrayList.add(new BasicNameValuePair("placement_type", "fullpage"));
                arrayList.add(new BasicNameValuePair("cache", Prm.cache));
                new Thread(new C0305m(Prm.activity, this, arrayList, C0301h.URL_MRAID_API, 0, true), "AdView").start();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.Prm.9 */
    class C05539 implements C0293b<Boolean> {
        final /* synthetic */ Prm f530a;

        C05539(Prm prm) {
            this.f530a = prm;
        }

        public void m1644a(Boolean bool) {
            if (bool.booleanValue()) {
                C0559q.m1746b(Prm.activity);
                Intent intent = new Intent(Prm.activity, MainActivity.class);
                intent.setAction("mfpad");
                intent.setFlags(268435456);
                intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                intent.addFlags(536870912);
                intent.putExtra("adtype", C0301h.AD_TYPE_MFP);
                Prm.activity.startActivity(intent);
                return;
            }
            Log.e(Prm.TAG, "Not able to get doc.");
        }

        public void m1643a() {
            new Thread(new NativeMraid(Prm.activity, this), "native").start();
        }
    }

    static {
        isDialogClosed = true;
        isShowOptinDialog = true;
        isIntegrationIssue = false;
        enableCaching = true;
        time = 0;
        cache = "0";
    }

    public Prm(Activity activity, AdListener adListener, boolean enableCaching) {
        this.asyncTaskCompleteListener = new C05481(this);
        this.optinRunnable = new C02834(this);
        adListener = adListener;
        enableCaching = enableCaching;
        Log.i(TAG, "Starting standard SDK " + Util.m925a());
        Log.i(TAG, "Caching enabled: " + enableCaching);
        if (activity == null) {
            Log.e(TAG, "Activity reference must not be null.");
            C0558p.sendIntegrationError("Activty reference must not be null.");
        } else if (activity instanceof Activity) {
            activity = activity;
            Util.m937b((Context) activity);
            if (!C0558p.validate(activity)) {
                Log.e(TAG, "com.google.android.gms.version not delclared in manifest.");
                C0558p.sendIntegrationError("com.google.android.gms.version not delclared in manifest.");
            } else if (C0292a.m1001a()) {
                this.asyncTaskCompleteListener.m1005a(Boolean.valueOf(false));
            } else {
                this.asyncTaskCompleteListener.m1004a();
            }
        } else {
            Log.e(TAG, "Invalid activty reference.");
            C0558p.sendIntegrationError("Invalid Activity reference.");
            isIntegrationIssue = true;
        }
    }

    Prm(Context context) {
        this.asyncTaskCompleteListener = new C05481(this);
        this.optinRunnable = new C02834(this);
        try {
            isDialogClosed = true;
            isShowOptinDialog = C0559q.m1751g(context);
            if (checkRequiredDetails(context)) {
                isIntegrationIssue = false;
                if (C0558p.isSDKEnabled(context) && !isShowOptinDialog && isDialogClosed) {
                    info(context);
                    return;
                }
                return;
            }
            isIntegrationIssue = true;
        } catch (Exception e) {
            Util.m929a("error in MA() " + e.getMessage());
        }
    }

    private synchronized void info(Context activity) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < time) {
            Util.m929a("Data sending ignored: " + new Date(currentTimeMillis) + ", diff: " + new Date(currentTimeMillis - time));
        } else if (C0558p.isSDKEnabled(activity)) {
            try {
                Log.i(TAG, "info>>>>");
                C0293b c05495 = new C05495(this, activity);
                if (Util.m977o(activity)) {
                    c05495.m1004a();
                }
            } catch (Exception e) {
                Log.i("Activitymanager", e.toString());
            }
        }
    }

    public void runSmartWallAd() {
        try {
            if (isDialogClosed || !isShowOptinDialog) {
                Log.i(TAG, "Initialising SmartWall.....");
                if (!checkRequiredDetails(activity) || !checkSmartWallintegration() || !C0561t.m1758a(activity)) {
                    return;
                }
                if (!Util.m933a(activity, VDActivity.class)) {
                    String str = "Required VDActivity not found in Manifest. Please add";
                    Log.e(TAG, str);
                    C0558p.sendIntegrationError(str);
                    C0312o c0312o = new C0312o(activity, LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
                    return;
                } else if (activity == null || !C0558p.isSDKEnabled(activity)) {
                    Log.i(TAG, "Prm is disabled Please enable to recive ads.");
                    C0558p.sendAdError("Prm is disabled Please enable to recive ads.");
                    return;
                } else if (C0559q.m1747c(activity) > System.currentTimeMillis()) {
                    Log.i(TAG, "SmartWall Ad called within 10 secs. Ignoring request.");
                    C0558p.sendAdError("SmartWall Ad called within 10 secs. Ignoring request.");
                    return;
                } else if (MainActivity.m920a()) {
                    Log.i(TAG, "Another ad is showing on screen.");
                    C0558p.sendAdError("Another ad is showing on screen.");
                    return;
                } else {
                    if (cA == null) {
                        cA = new C0295d(activity);
                    }
                    if (cA.m1014e(AdType.smartwall)) {
                        Log.i(TAG, "SmartWall Ad already available in cache. Request ignored.");
                        C0558p.sendAdError("SmartWall Ad already available in cache. Request Ignored.");
                        return;
                    }
                    C0559q.m1746b(activity);
                    C0293b c05506 = new C05506(this);
                    if (Util.m977o(activity)) {
                        c05506.m1004a();
                        return;
                    }
                    return;
                }
            }
            Editor edit = activity.getSharedPreferences(C0301h.ENABLE_AD_PREF, 0).edit();
            edit.putBoolean(C0301h.INTERSTITAL_AD_STRING, true);
            edit.commit();
        } catch (Throwable e) {
            Log.e(TAG, "Error occurred in startSmartWall method: ", e);
        }
    }

    void parseSmartwallJson(String result) {
        try {
            if (!result.contains("<VAST") || VERSION.SDK_INT <= 7) {
                JSONObject jSONObject = new JSONObject(result);
                int i = jSONObject.isNull("status") ? 0 : jSONObject.getInt("status");
                String string = jSONObject.isNull(C0301h.TYPE_MESSAGE) ? "" : jSONObject.getString(C0301h.TYPE_MESSAGE);
                String string2 = jSONObject.isNull("adtype") ? "" : jSONObject.getString("adtype");
                if (i != 200 || string2.equals("")) {
                    validateStatusCode(i, string);
                    return;
                } else if (string2.equalsIgnoreCase(C0301h.AD_TYPE_AW)) {
                    parseAppWallJson(result);
                    return;
                } else if (string2.equals("OLAU") || string2.equals(C0301h.AD_TYPE_DAU) || string2.equals(C0301h.AD_TYPE_DCC) || string2.equals(C0301h.AD_TYPE_DCM)) {
                    showOverlayAd(result);
                    return;
                } else if (!string2.equals("") && string2.equalsIgnoreCase(C0301h.AD_TYPE_FP)) {
                    Log.w(TAG, "Landing page ad not supported in this version");
                    if (cA != null) {
                        cA.m1012c(AdType.smartwall);
                        return;
                    }
                    return;
                } else if (string2.equals("") || !string2.equalsIgnoreCase(C0301h.AD_TYPE_MFP)) {
                    Log.i(TAG, "Invalid ad type delivered in SmartWall: " + string2);
                    return;
                } else {
                    parseRichMediaInterstitialJson(jSONObject);
                    return;
                }
            }
            new C0561t(activity).m1764a(result, true);
        } catch (Throwable e) {
            Log.e(TAG, "Error in Smart Wall json: ", e);
        } catch (Throwable e2) {
            Log.e(TAG, "Error in Smart Wall response: ", e2);
        }
    }

    public void runAppWall() {
        try {
            if (isDialogClosed || !isShowOptinDialog) {
                Log.i(TAG, "Initialising AppWall.....");
                if (!isIntegrationIssue && checkSmartWallActivity()) {
                    if (activity == null || !C0558p.isSDKEnabled(activity)) {
                        Log.i(TAG, "Prm is disabled Please enable to recive ads.");
                        C0558p.sendAdError("Prm is disabled Please enable to recive ads.");
                        return;
                    } else if (C0559q.m1747c(activity) > System.currentTimeMillis()) {
                        Log.i(TAG, "AppWall called within 10 secs. Ignoring request");
                        C0558p.sendAdError("AppWall called within 10 secs. Ignoring request.");
                        return;
                    } else if (MainActivity.m920a()) {
                        Log.i(TAG, "Another ad is showing on screen.");
                        C0558p.sendAdError("Another ad is showing on screen.");
                        return;
                    } else {
                        if (cA == null) {
                            cA = new C0295d(activity);
                        }
                        if (cA.m1014e(AdType.appwall)) {
                            Log.i(TAG, "AppWall Ad already available in cache. Request ignored.");
                            C0558p.sendAdError("AppWall Ad already available in cache. Request Ignored.");
                            return;
                        }
                        C0559q.m1746b(activity);
                        C0293b c05517 = new C05517(this);
                        if (Util.m977o(activity)) {
                            c05517.m1004a();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            Editor edit = activity.getSharedPreferences(C0301h.ENABLE_AD_PREF, 0).edit();
            edit.putBoolean(C0301h.APP_WALL_AD, true);
            edit.commit();
        } catch (Throwable e) {
            Log.e(TAG, "Error occurred in appwall ", e);
        }
    }

    void parseAppWallJson(String json) {
        try {
            String str;
            JSONObject jSONObject = new JSONObject(json);
            int i = jSONObject.isNull("status") ? 0 : jSONObject.getInt("status");
            if (jSONObject.isNull(C0301h.TYPE_MESSAGE)) {
                str = "";
            } else {
                str = jSONObject.getString(C0301h.TYPE_MESSAGE);
            }
            if (i == 200 && str.equals("Success")) {
                str = jSONObject.getString(PlusShare.KEY_CALL_TO_ACTION_URL);
                if (str != null && !str.equals("")) {
                    C0559q.m1746b(activity);
                    Intent intent = new Intent(activity, MainActivity.class);
                    intent.setFlags(268435456);
                    intent.addFlags(536870912);
                    intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                    intent.setAction("appwallad");
                    intent.putExtra("adtype", C0301h.AD_TYPE_AW);
                    intent.putExtra(PlusShare.KEY_CALL_TO_ACTION_URL, str);
                    try {
                        activity.startActivity(intent);
                        return;
                    } catch (ActivityNotFoundException e) {
                        Log.e(TAG, "Required SmartWallActivity not found in Manifest. Please add.");
                        return;
                    }
                }
                return;
            }
            validateStatusCode(i, str);
        } catch (Throwable e2) {
            Log.e(TAG, "Error in AppWall json: ", e2);
        } catch (Throwable e22) {
            Log.e(TAG, "Error in AppWall response: ", e22);
        }
    }

    public void runRichMediaInterstitialAd() {
        try {
            if (isDialogClosed || !isShowOptinDialog) {
                Log.i(TAG, "Initialising Rich Media Interstitial Ad.....");
                if (!isIntegrationIssue && checkSmartWallintegration()) {
                    if (activity == null || !C0558p.isSDKEnabled(activity)) {
                        Log.i(TAG, "Prm is disabled Please enable to recive ads.");
                        C0558p.sendAdError("Prm is disabled Please enable to recive ads.");
                        return;
                    } else if (C0559q.m1747c(activity) > System.currentTimeMillis()) {
                        String str = "Rich Media Interstitial Ad called within 10 secs. Ignoring request";
                        Log.i(TAG, str);
                        C0558p.sendAdError(str);
                        return;
                    } else if (MainActivity.m920a()) {
                        Log.i(TAG, "Another ad is showing on screen.");
                        C0558p.sendAdError("Another ad is showing on screen.");
                        return;
                    } else {
                        if (cA == null) {
                            cA = new C0295d(activity);
                        }
                        if (cA.m1014e(AdType.interstitial)) {
                            Log.i(TAG, "Rich media interstitial Ad already available in cache. Request ignored.");
                            C0558p.sendAdError("Rich media interstitial Ad already available in cache. Request Ignored.");
                            return;
                        }
                        C0559q.m1746b(activity);
                        C0293b c05528 = new C05528(this);
                        if (Util.m977o(activity)) {
                            c05528.m1004a();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            Editor edit = activity.getSharedPreferences(C0301h.ENABLE_AD_PREF, 0).edit();
            edit.putBoolean(C0301h.RICH_MEDIA, true);
            edit.commit();
        } catch (Throwable e) {
            Log.e(TAG, "Error occurred in Rich Media interstital ad: ", e);
        }
    }

    void parseRichMediaInterstitialJson(JSONObject jsonObject) {
        try {
            parseMraidJson = new ParseMraidJson(activity, jsonObject);
            String r = Util.m983r(activity);
            if (r == null || r.equals("")) {
                C0293b c05539 = new C05539(this);
                if (Util.m977o(activity)) {
                    c05539.m1004a();
                    return;
                }
                return;
            }
            C0559q.m1746b(activity);
            Intent intent = new Intent(activity, MainActivity.class);
            intent.setAction("mfpad");
            intent.setFlags(268435456);
            intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
            intent.addFlags(536870912);
            intent.putExtra("adtype", C0301h.AD_TYPE_MFP);
            activity.startActivity(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            Log.i(TAG, "Rich Media Full Page: " + e2.getMessage());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    static final void validateStatusCode(int status, String message) {
        if (message != null && !message.equals("")) {
            switch (status) {
                case LocationRequest.PRIORITY_HIGH_ACCURACY /*100*/:
                    C0558p.sendIntegrationError(message);
                case 120:
                    C0558p.sendIntegrationError(message);
                case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                    C0558p.sendIntegrationError(message);
                case 150:
                    C0558p.sendNoAdMessage();
                case 204:
                    C0558p.sendNoAdMessage();
                default:
            }
        }
    }

    static boolean checkRequiredDetails(Context mContext) {
        boolean z = true;
        if (mContext == null) {
            try {
                Log.e(TAG, "Context is null.");
                C0558p.sendIntegrationError("Context is null");
                z = false;
            } catch (Throwable e) {
                Log.e(TAG, "Error occurred while checking required details: ", e);
                return false;
            }
        }
        if (!C0558p.getDataFromManifest(mContext)) {
            z = false;
        }
        if (!C0558p.checkRequiredPermission(mContext)) {
            z = false;
        }
        if (!new C0320s(mContext).m1047b()) {
            z = false;
        }
        new C0559q(mContext).m1752a();
        return z;
    }

    private boolean checkSmartWallintegration() {
        try {
            boolean checkSmartWallActivity = checkSmartWallActivity();
            if (Util.m933a(activity, BrowserActivity.class)) {
                return checkSmartWallActivity;
            }
            String str = "Required BrowserActivity not found in Manifest. Please add.";
            Log.e(TAG, str);
            C0558p.sendIntegrationError(str);
            C0312o c0312o = new C0312o(activity, LocationRequest.PRIORITY_LOW_POWER);
            return false;
        } catch (Throwable e) {
            Log.e(TAG, "Error occurred while validating SmartWall: ", e);
            return false;
        }
    }

    private boolean checkSmartWallActivity() throws NullPointerException, Exception {
        if (Util.m933a(activity, MainActivity.class)) {
            return true;
        }
        String str = "Required MainActivity not found in Manifest. Please add.";
        Log.e(TAG, str);
        C0558p.sendIntegrationError(str);
        C0312o c0312o = new C0312o(activity, 103);
        return false;
    }

    public void runVideoAd() {
        try {
            String str;
            if (VERSION.SDK_INT < 8) {
                str = "Video ad supported on Android 2.2 and later devices.";
                Log.e(TAG, str);
                C0558p.sendAdError(str);
            } else if (isDialogClosed || !isShowOptinDialog) {
                Log.i(TAG, "Initialising video ad.....");
                if (!isIntegrationIssue && C0561t.m1758a(activity)) {
                    if (!Util.m933a(activity, VDActivity.class)) {
                        str = "Required VDActivity not found in Manifest. Please add";
                        Log.e(TAG, str);
                        C0558p.sendIntegrationError(str);
                        C0312o c0312o = new C0312o(activity, LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
                    } else if (C0558p.isSDKEnabled(activity)) {
                        str = Environment.getExternalStorageState();
                        if (str == null || !str.equalsIgnoreCase("mounted")) {
                            str = "Can't call video ad at this time. SD card not mounted.";
                            Log.w(TAG, str);
                            C0558p.sendAdError(str);
                        } else if (MainActivity.m920a()) {
                            str = "Another ad is already showing on screen.";
                            Log.w(TAG, str);
                            C0558p.sendAdError(str);
                        } else if (System.currentTimeMillis() < C0559q.m1749e(activity)) {
                            str = "Video ad is called before 30 secs. Ignoring request.";
                            Log.w(TAG, str);
                            C0558p.sendAdError(str);
                        } else {
                            if (cA == null) {
                                cA = new C0295d(activity);
                            }
                            if (cA.m1014e(AdType.video)) {
                                Log.i(TAG, "Video Ad already available in cache. Request ignored.");
                                C0558p.sendAdError("Video Ad already available in cache. Request Ignored.");
                                return;
                            }
                            C0561t c0561t = new C0561t(activity);
                            if (Util.m977o(activity)) {
                                c0561t.m1760a();
                            }
                        }
                    } else {
                        Log.e(TAG, "Prm is disabled please enable to receive ads.");
                    }
                }
            } else {
                Editor edit = activity.getSharedPreferences(C0301h.ENABLE_AD_PREF, 0).edit();
                edit.putBoolean(C0301h.VIDEO_AD, true);
                edit.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void runOverlayAd() {
        try {
            if (isDialogClosed || !isShowOptinDialog) {
                Log.i(TAG, "Initialising Overlay AD.....");
                if (!isIntegrationIssue && checkSmartWallActivity()) {
                    if (!C0558p.isSDKEnabled(activity)) {
                        Log.i(TAG, "Prm SDK is disabled Please enable to recive ads.");
                        C0558p.sendAdError("Prm SDK is disabled Please enable to recive ads.");
                        return;
                    } else if (C0559q.m1747c(activity) > System.currentTimeMillis()) {
                        Log.i(TAG, "Overlay Ad called within 10 secs. Ignoring request");
                        C0558p.sendAdError("Overlay Ad called within 10 secs. Ignoring request");
                        return;
                    } else if (MainActivity.m920a()) {
                        Log.i(TAG, "Another ad is showing on screen.");
                        C0558p.sendAdError("Another ad is showing on screen.");
                        return;
                    } else {
                        if (cA == null) {
                            cA = new C0295d(activity);
                        }
                        if (cA.m1014e(AdType.overlay)) {
                            Log.i(TAG, "Overlay Ad already available in cache. Request ignored.");
                            C0558p.sendAdError("Overlay Ad already available in cache. Request Ignored.");
                            return;
                        }
                        C0559q.m1746b(activity);
                        C0293b anonymousClass10 = new C0293b<String>() {
                            final /* synthetic */ Prm f523a;

                            {
                                this.f523a = r1;
                            }

                            public void m1627a(String str) {
                                Log.i(Prm.TAG, "Overlay Json: " + str);
                                if (str != null) {
                                    try {
                                        if (Prm.enableCaching) {
                                            JSONObject jSONObject = new JSONObject(str);
                                            int i = jSONObject.isNull("status") ? 0 : jSONObject.getInt("status");
                                            String string = jSONObject.isNull(C0301h.TYPE_MESSAGE) ? C0301h.INVALID : jSONObject.getString(C0301h.TYPE_MESSAGE);
                                            if (i == 200 && string.equalsIgnoreCase("Success")) {
                                                Prm.cA.m1009a(AdType.overlay, str);
                                                C0558p.sendAdCached(AdType.overlay);
                                                return;
                                            }
                                            Prm.validateStatusCode(i, string);
                                            return;
                                        }
                                        this.f523a.showOverlayAd(str);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }

                            public void m1625a() {
                                try {
                                    List arrayList = new ArrayList();
                                    arrayList.add(new BasicNameValuePair("cache", Prm.cache));
                                    new Thread(new C0305m(Prm.activity, this, arrayList, C0301h.OVERLAY_AD_URL, 0, true), "overlay").start();
                                } catch (Throwable e) {
                                    Log.e(Prm.TAG, "Error occurred in while requesting: ", e);
                                }
                            }
                        };
                        if (Util.m977o(activity)) {
                            anonymousClass10.m1004a();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            Editor edit = activity.getSharedPreferences(C0301h.ENABLE_AD_PREF, 0).edit();
            edit.putBoolean(C0301h.OVERLAY_AD, true);
            edit.commit();
        } catch (Throwable e) {
            Log.e(TAG, "Error occurred in Overlay ad: ", e);
        }
    }

    private void showOverlayAd(String result) {
        try {
            JSONObject jSONObject = new JSONObject(result);
            int i = jSONObject.isNull("status") ? 0 : jSONObject.getInt("status");
            String string = jSONObject.isNull(C0301h.TYPE_MESSAGE) ? C0301h.INVALID : jSONObject.getString(C0301h.TYPE_MESSAGE);
            String string2 = jSONObject.isNull("adtype") ? "" : jSONObject.getString("adtype");
            boolean z = jSONObject.isNull(IM.EVENT_ERROR) ? false : jSONObject.getBoolean(IM.EVENT_ERROR);
            if (i == 200 && string.equalsIgnoreCase("Success")) {
                String string3 = jSONObject.isNull("data") ? "nodata" : jSONObject.getString("data");
                if (!string3.equals("nodata")) {
                    JSONObject jSONObject2 = new JSONObject(string3);
                    string3 = jSONObject2.getString("tag");
                    i = jSONObject2.getInt(IM.HEIGHT);
                    int i2 = jSONObject2.getInt(IM.WIDTH);
                    string = jSONObject2.getString("api_url");
                    C0310n.m1034d(string2);
                    C0310n.m1032c(string);
                    C0310n.m1024a(z);
                    C0310n.m1028b(i2);
                    C0310n.m1022a(i);
                    C0310n.m1029b(string3);
                    if (string2.equals("OLAU") || string2.equals(C0301h.AD_TYPE_DAU) || string2.equals(C0301h.AD_TYPE_DCC) || string2.equals(C0301h.AD_TYPE_DCM)) {
                        new Thread(new AnonymousClass11(this, string2), "overlay_showing").start();
                        return;
                    } else {
                        Log.w(TAG, "Invalid adtype delivered in overylay ad " + string2);
                        return;
                    }
                }
                return;
            }
            validateStatusCode(i, string);
        } catch (Throwable e) {
            Log.e(TAG, "Error occurred in overlay ad", e);
        }
    }

    public void runCachedAd(Activity activity, AdType adType) throws Exception {
        if (activity == null || adType == null) {
            try {
                String str = "Activity or Adtype is null.";
                Log.e(TAG, str);
                throw new IllegalStateException(str);
            } catch (Exception e) {
                Log.e(TAG, "Error occurred while showing Cached ad: " + e.getMessage());
                throw new Exception(e.getMessage());
            }
        }
        activity = activity;
        if (!C0558p.isSDKEnabled(activity)) {
            throw new IllegalStateException("Standard SDK is disabled can not show ad.");
        } else if (MainActivity.m920a()) {
            throw new IllegalStateException("Another ad is showing on screen.");
        } else if (Util.m977o(activity)) {
            if (cA == null) {
                cA = new C0295d(activity);
            }
            String[] b;
            String str2;
            switch (C02823.f311a[adType.ordinal()]) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    str = cA.m1006a(AdType.smartwall);
                    if (str == null || str.equals("")) {
                        throw new IOException("SmartWall ad is not available in cache");
                    } else if (!str.contains("<VAST") || VERSION.SDK_INT <= 7) {
                        parseSmartwallJson(str);
                    } else {
                        b = cA.m1011b(AdType.video);
                        str2 = b[0];
                        str = b[1];
                        if (str2 == null || str2.equals("") || str == null || str.equals("")) {
                            cA.m1012c(adType);
                            Log.e(TAG, "SmartWall video was not cached");
                            throw new IOException("SmartWall ad is not available in cache");
                        }
                        new C0561t(activity).m1763a(str2, str);
                    }
                case DetectedActivity.ON_FOOT /*2*/:
                    str = cA.m1006a(AdType.appwall);
                    if (str == null || str.equals("")) {
                        cA.m1012c(adType);
                        throw new IOException("Appwall ad is not available in cache");
                    } else {
                        parseAppWallJson(str);
                    }
                case DetectedActivity.STILL /*3*/:
                    str = cA.m1006a(AdType.interstitial);
                    if (str == null || str.equals("")) {
                        cA.m1012c(adType);
                        throw new IOException("Interstitial ad is not available in cache");
                    } else {
                        parseRichMediaInterstitialJson(new JSONObject(str));
                    }
                case DetectedActivity.UNKNOWN /*4*/:
                    b = cA.m1011b(AdType.video);
                    str2 = b[0];
                    str = b[1];
                    if (str2 == null || str2.equals("") || str == null || str.equals("")) {
                        cA.m1012c(adType);
                        throw new IOException("Video ad is not available in cache");
                    } else {
                        new C0561t(activity).m1763a(str2, str);
                    }
                case DetectedActivity.TILTING /*5*/:
                    str = cA.m1006a(AdType.overlay);
                    if (str == null || str.equals("")) {
                        cA.m1012c(adType);
                        throw new IOException("Overlay ad is not available in cache");
                    } else {
                        showOverlayAd(str);
                    }
                default:
                    throw new IOException("Invalid AdType.");
            }
        } else {
            throw new IllegalStateException("Internet connection not available.");
        }
    }

    public static void setOptinListener(OptinListener optinListener) {
        optinListener = optinListener;
    }

    static OptinListener getOptinListener() {
        return optinListener;
    }

    static void startNewAdThread() {
        try {
            handler.postDelayed(new C02812(), 3000);
        } catch (Exception e) {
            C0559q.m1745a(activity);
        }
    }

    public synchronized void run360Ad(Activity activity, int placement_id, boolean testMode, BannerAdListener listener) {
        try {
            Log.i(TAG, "Initialising 360 AD.....");
            if (checkRequiredDetails(activity) && checkSmartWallintegration()) {
                isIntegrationIssue = false;
            } else {
                isIntegrationIssue = true;
            }
            if (!isIntegrationIssue) {
                if (AbstractAdView.m806b()) {
                    Log.w(TAG, "Another ad is showing on screen.");
                    C0558p.sendAdError("Another ad is showing on screen.");
                } else if (!C0558p.isSDKEnabled(activity)) {
                    Log.i(TAG, "SDK is disabled, please enabled to receive ad.");
                    C0558p.sendAdError("SDK is disabled, please enabled to receive ad.");
                } else if (C0555c.m1693b((Context) activity) > System.currentTimeMillis()) {
                    Log.i(TAG, "Banner 360 Ad called within 10 secs. Ignoring request");
                    C0558p.sendAdError("Banner 360 Ad called within 10 secs. Ignoring request");
                } else {
                    C0555c.m1691a((Context) activity);
                    C0555c c0555c = new C0555c(activity, "360", placement_id, testMode, listener);
                    if (Util.m977o(activity)) {
                        c0555c.m1706a();
                    }
                }
            }
        } catch (Throwable e) {
            Util.m930a("Error in 360", e);
        }
    }
}
