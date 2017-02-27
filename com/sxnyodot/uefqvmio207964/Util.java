package com.sxnyodot.uefqvmio207964;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Point;
import android.location.Address;
import android.location.Geocoder;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Global;
import android.provider.Settings.Secure;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

class Util {
    private static final int NETWORK_TYPE_EHRPD = 14;
    private static final int NETWORK_TYPE_EVDO_B = 12;
    private static final int NETWORK_TYPE_HSDPA = 8;
    private static final int NETWORK_TYPE_HSPA = 10;
    private static final int NETWORK_TYPE_HSPAP = 15;
    private static final int NETWORK_TYPE_HSUPA = 9;
    private static final int NETWORK_TYPE_IDEN = 11;
    private static final int NETWORK_TYPE_LTE = 13;
    private static final String TAG = "PrmSDK";
    private static String f315a;
    private static boolean f316b;
    private static String f317c;
    private static String f318d;
    private static String f319e;
    private static String f320f;
    private static String f321g;
    private static String f322h;
    private static String f323i;
    private static String f324j;
    private static float f325k;
    private static int f326l;
    private static Context f327m;
    private static String f328n;
    private static String f329o;
    private static long f330p;
    private static String f331q;

    public static final class NativeMraid implements Runnable {
        C0293b<Boolean> f313a;
        private Context f314b;

        public NativeMraid(Context context, C0293b<Boolean> asyncTaskCompleteListener) {
            this.f314b = context;
            this.f313a = asyncTaskCompleteListener;
        }

        public void run() {
            Exception exception;
            Throwable th;
            HttpURLConnection httpURLConnection = null;
            try {
                HttpURLConnection httpURLConnection2;
                if (Util.m977o(this.f314b)) {
                    Log.i(IM.TAG, "Getting mraid>>>>");
                    httpURLConnection2 = (HttpURLConnection) new URL(Base64.decodeString(C0301h.MRAID_URL)).openConnection();
                    try {
                        httpURLConnection2.setRequestMethod("GET");
                        httpURLConnection2.setConnectTimeout(15000);
                        httpURLConnection2.setReadTimeout(15000);
                        httpURLConnection2.setUseCaches(true);
                        httpURLConnection2.setDefaultUseCaches(true);
                        httpURLConnection2.connect();
                        if (httpURLConnection2.getResponseCode() == 200) {
                            InputStream inputStream = httpURLConnection2.getInputStream();
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                            StringBuilder stringBuilder = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuilder.append(readLine);
                                stringBuilder.append("\n");
                            }
                            bufferedReader.close();
                            inputStream.close();
                            String stringBuilder2 = stringBuilder.toString();
                            if (stringBuilder2 == null || stringBuilder2.equals("") || !stringBuilder2.contains("mraid")) {
                                Log.w(Util.TAG, "Invalid js file.");
                            } else {
                                Editor edit = this.f314b.getSharedPreferences("mraid", 0).edit();
                                edit.putString("mr", stringBuilder.toString());
                                this.f313a.m1005a(Boolean.valueOf(edit.commit()));
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                    return;
                                }
                                return;
                            }
                        }
                        Log.i(IM.TAG, "Status Code: " + httpURLConnection2.getResponseCode());
                        Log.i(IM.TAG, "HTTP Reason: " + httpURLConnection2.getResponseMessage());
                    } catch (Exception e) {
                        Exception exception2 = e;
                        httpURLConnection = httpURLConnection2;
                        exception = exception2;
                        try {
                            Log.w(IM.TAG, "Error in native mraid: " + exception.getMessage());
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            this.f313a.m1005a(Boolean.valueOf(false));
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
                }
                httpURLConnection2 = null;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
            } catch (Exception e2) {
                exception = e2;
                Log.w(IM.TAG, "Error in native mraid: " + exception.getMessage());
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                this.f313a.m1005a(Boolean.valueOf(false));
            }
            this.f313a.m1005a(Boolean.valueOf(false));
        }
    }

    static {
        f319e = "airplay";
        f321g = "0";
        f322h = "0";
        f330p = 0;
        f331q = "0";
    }

    Util(Context context) {
        f327m = context;
    }

    static String m925a() {
        return C0301h.SDK_VERSION_CODE;
    }

    static void m929a(String str) {
    }

    static void m930a(String str, Throwable th) {
    }

    static boolean m939b() {
        return f316b;
    }

    static String m940c() {
        return f315a;
    }

    static void m938b(String str) {
        f315a = str;
    }

    static void m931a(boolean z) {
        f316b = z;
    }

    static void m944d() {
        try {
            f331q = m972m(f320f + m982r());
        } catch (Exception e) {
            Log.e(TAG, "Error occured while generating session id.");
        }
    }

    static String m946e() {
        return f331q;
    }

    static boolean m932a(Context context) {
        DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        float f = displayMetrics.density;
        if (((float) width) / f < 600.0f || ((float) height) / f < 600.0f) {
            return false;
        }
        return true;
    }

    static Context m949f() {
        return f327m;
    }

    static void m937b(Context context) {
        f327m = context;
    }

    static String m952g() {
        return f317c;
    }

    static void m942c(String str) {
        f317c = str;
    }

    public static String m956h() {
        return f318d;
    }

    public static void m945d(String str) {
        f318d = str;
    }

    static String m958i() {
        return f319e;
    }

    static void m948e(String str) {
        f319e = str;
    }

    static String m961j() {
        return f320f;
    }

    static void m951f(String str) {
        f320f = str;
    }

    static void m954g(String str) {
        f328n = str;
    }

    static String m964k() {
        return f328n;
    }

    static String m967l() {
        return f322h;
    }

    static void m957h(String str) {
        f322h = str;
    }

    static String m970m() {
        return f321g;
    }

    static void m960i(String str) {
        f321g = str;
    }

    static void m928a(long j) {
        f330p = j;
    }

    static long m973n() {
        return f330p;
    }

    public static String m976o() {
        return f323i;
    }

    public static void m962j(String str) {
        f323i = str;
    }

    public static float m978p() {
        return f325k;
    }

    public static void m926a(float f) {
        f325k = f;
    }

    public static void m966k(String str) {
        f324j = str;
    }

    public static String m980q() {
        return f324j;
    }

    static String m982r() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return "" + simpleDateFormat.format(new Date()) + "_" + simpleDateFormat.getTimeZone().getDisplayName() + "_" + simpleDateFormat.getTimeZone().getID() + "_" + simpleDateFormat.getTimeZone().getDisplayName(false, 0);
        } catch (Exception e) {
            return "00";
        }
    }

    static String m936b(long j) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return "" + simpleDateFormat.format(new Date(j)) + "_" + simpleDateFormat.getTimeZone().getDisplayName() + "_" + simpleDateFormat.getTimeZone().getID() + "_" + simpleDateFormat.getTimeZone().getDisplayName(false, 0);
        } catch (Exception e) {
            return "00";
        }
    }

    static String m984s() {
        return Build.MODEL;
    }

    static String m986t() {
        return "" + VERSION.SDK_INT;
    }

    static String m941c(Context context) {
        if (context == null) {
            return "";
        }
        try {
            String string = Secure.getString(context.getApplicationContext().getContentResolver(), C0301h.ANDROID_ID);
            m929a("Android ID: " + string);
            MessageDigest.getInstance("MD5").update(string.getBytes(), 0, string.length());
            return String.format("%032x", new Object[]{new BigInteger(1, r1.digest())});
        } catch (NullPointerException e) {
            Log.e(TAG, "Android Id not found.");
            return "NOT FOUND";
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "NOT FOUND";
        } catch (Exception e3) {
            e3.printStackTrace();
            return "NOT FOUND";
        }
    }

    static String m943d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            String string = Secure.getString(context.getApplicationContext().getContentResolver(), C0301h.ANDROID_ID);
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(string.getBytes(), 0, string.length());
            return new BigInteger(1, instance.digest()).toString(16);
        } catch (NullPointerException e) {
            Log.e(TAG, "Android Id not found.");
            return "NOT FOUND";
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "NOT FOUND";
        } catch (Exception e3) {
            e3.printStackTrace();
            return "NOT FOUND";
        }
    }

    static void m927a(int i) {
        f326l = i;
    }

    static int m987u() {
        return f326l;
    }

    static String m947e(Context context) {
        try {
            return context.getPackageName();
        } catch (Exception e) {
            return "";
        }
    }

    static String m950f(Context context) {
        if (context == null) {
            return "";
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null || telephonyManager.getSimState() != 5) {
            return "";
        }
        return telephonyManager.getSimOperatorName();
    }

    static String m953g(Context context) {
        if (context == null) {
            return "";
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null || telephonyManager.getPhoneType() != 1) {
            return "";
        }
        return telephonyManager.getNetworkOperatorName();
    }

    static String m988v() {
        return Build.MANUFACTURER;
    }

    static int m955h(Context context) {
        if (context == null) {
            return 0;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getTypeName().equals("WIFI")) ? 1 : 0;
    }

    static String m959i(Context context) {
        if (context != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (!(activeNetworkInfo == null || !activeNetworkInfo.isConnected() || activeNetworkInfo.getTypeName().equals("WIFI"))) {
                return activeNetworkInfo.getSubtypeName();
            }
        }
        return "";
    }

    static boolean m963j(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                System.out.println("CONNECTED VIA WIFI");
                return true;
            }
            if (type == 0) {
                switch (activeNetworkInfo.getSubtype()) {
                    case DetectedActivity.IN_VEHICLE /*0*/:
                        return false;
                    case DetectedActivity.ON_BICYCLE /*1*/:
                        return false;
                    case DetectedActivity.ON_FOOT /*2*/:
                        return false;
                    case DetectedActivity.STILL /*3*/:
                        return true;
                    case DetectedActivity.UNKNOWN /*4*/:
                        return false;
                    case DetectedActivity.TILTING /*5*/:
                        return true;
                    case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                        return true;
                    case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                        return false;
                    case NETWORK_TYPE_HSDPA /*8*/:
                        return true;
                    case NETWORK_TYPE_HSUPA /*9*/:
                        return true;
                    case NETWORK_TYPE_HSPA /*10*/:
                        return true;
                    case NETWORK_TYPE_IDEN /*11*/:
                        return false;
                    case NETWORK_TYPE_EVDO_B /*12*/:
                        return true;
                    case NETWORK_TYPE_LTE /*13*/:
                        return true;
                    case NETWORK_TYPE_EHRPD /*14*/:
                        return true;
                    case NETWORK_TYPE_HSPAP /*15*/:
                        return true;
                    default:
                        return false;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static String m989w() {
        return f329o;
    }

    static void m968l(String str) {
        f329o = str;
    }

    static String m965k(Context context) {
        String str = "";
        if (context == null) {
            return str;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (VERSION.SDK_INT < NETWORK_TYPE_LTE) {
            return "" + defaultDisplay.getWidth() + "_" + defaultDisplay.getHeight();
        }
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x + "_" + point.y;
    }

    static String[] m969l(Context context) {
        String[] strArr = new String[]{"", ""};
        try {
            Geocoder geocoder = new Geocoder(context);
            if (f322h == null || f322h.equals(C0301h.INVALID) || f321g == null || f321g.equals(C0301h.INVALID)) {
                return strArr;
            }
            List fromLocation = geocoder.getFromLocation(Double.parseDouble(f322h), Double.parseDouble(f321g), 1);
            if (!fromLocation.isEmpty()) {
                strArr[0] = ((Address) fromLocation.get(0)).getCountryName();
                strArr[1] = ((Address) fromLocation.get(0)).getPostalCode();
                m929a("Postal Code: " + strArr[1] + " Country Code: " + ((Address) fromLocation.get(0)).getCountryCode());
            }
            return strArr;
        } catch (IOException e) {
        } catch (Exception e2) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    static String m990x() {
        return Locale.getDefault().getDisplayLanguage();
    }

    static String m971m(Context context) {
        return "" + context.getResources().getDisplayMetrics().density;
    }

    static String m974n(Context context) {
        return "" + context.getResources().getDisplayMetrics().densityDpi;
    }

    static boolean m977o(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return true;
            }
            Log.e(TAG, "Internet connection not found.");
            C0558p.sendAdError("Internet connection not found.");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    static String m979p(Context context) {
        try {
            ApplicationInfo applicationInfo;
            PackageManager packageManager = context.getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            } catch (NameNotFoundException e) {
                applicationInfo = null;
            }
            return (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "(unknown)");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @SuppressLint({"InlinedApi"})
    static String m981q(Context context) {
        try {
            if (VERSION.SDK_INT >= 17) {
                return Global.getString(context.getContentResolver(), "install_non_market_apps");
            }
            return Secure.getString(context.getContentResolver(), "install_non_market_apps");
        } catch (Exception e) {
            return "0";
        }
    }

    static final String m972m(String str) {
        String str2 = "";
        try {
            MessageDigest.getInstance("MD5").update(str.getBytes(), 0, str.length());
            str2 = String.format("%032x", new Object[]{new BigInteger(1, r1.digest())});
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str2;
    }

    static final String m975n(String str) {
        String str2 = "";
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes(), 0, str.length());
            str2 = new BigInteger(1, instance.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str2;
    }

    static boolean m934a(Context context, String str) throws NullPointerException, Exception {
        return context.getPackageManager().queryIntentActivities(new Intent(str), AccessibilityNodeInfoCompat.ACTION_CUT).size() > 0;
    }

    static boolean m933a(Context context, Class<?> cls) throws NullPointerException, Exception {
        return context.getPackageManager().queryIntentActivities(new Intent(context, cls), AccessibilityNodeInfoCompat.ACTION_CUT).size() > 0;
    }

    public static String m983r(Context context) {
        String str = null;
        try {
            str = context.getSharedPreferences("mraid", 0).getString("mr", null);
        } catch (Exception e) {
        }
        return str;
    }

    public static JSONObject m985s(Context context) {
        boolean z = true;
        try {
            boolean z2;
            boolean z3;
            boolean a;
            boolean z4;
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null || telephonyManager.getSimState() != 5) {
                z2 = false;
                z3 = false;
            } else {
                z2 = true;
                z3 = true;
            }
            if (VERSION.SDK_INT > 7) {
                a = m934a(context, "android.intent.action.EDIT");
            } else {
                a = false;
            }
            boolean z5 = context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
            String externalStorageState = Environment.getExternalStorageState();
            if (z5 && externalStorageState.equals("mounted")) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (VERSION.SDK_INT <= NETWORK_TYPE_HSPA) {
                z = false;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sms", z3);
            jSONObject.put("tel", z2);
            jSONObject.put("calendar", a);
            jSONObject.put("storePictures", z4);
            jSONObject.put("inlineVideo", z);
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static float m924a(float f, Context context) throws Exception {
        return (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f) * f;
    }

    public static float m935b(float f, Context context) throws Exception {
        return f / (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f);
    }
}
