package com.sxnyodot.uefqvmio207964;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.util.Log;
import android.webkit.WebView;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

/* renamed from: com.sxnyodot.uefqvmio207964.q */
class C0559q implements C0301h {
    static JSONObject f614a;
    static List<NameValuePair> f615b;
    private static Context f616c;
    private static String f617d;
    private static SharedPreferences f618e;

    static {
        f614a = null;
        f617d = "0";
    }

    public C0559q(Context context) {
        f616c = context;
    }

    void m1752a() {
        try {
            Util.m954g(new WebView(f616c).getSettings().getUserAgentString());
            C0320s c0320s = new C0320s(f616c);
            try {
                if (!C0559q.m1751g(f616c)) {
                    Location d = c0320s.m1049d();
                    if (d != null) {
                        String str = "" + d.getLatitude();
                        String str2 = "" + d.getLongitude();
                        Util.m962j(c0320s.m1048c());
                        Util.m926a(d.getAccuracy());
                        Util.m966k(d.getProvider());
                        Util.m929a("Location: lat " + str + ", lon " + str2);
                        Util.m957h(str);
                        Util.m960i(str2);
                    } else {
                        Util.m929a("Location null: ");
                    }
                }
            } catch (Exception e) {
            }
            String c = Util.m940c();
            if (c == null || c.equals("")) {
                c = "NOT FOUND";
            }
            f617d = (C0559q.m1751g(f616c) ? Util.m952g() : Util.m972m(c)) + "" + Util.m961j() + "" + Util.m982r();
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(f617d.getBytes(), 0, f617d.length());
            f617d = new BigInteger(1, instance.digest()).toString(16);
        } catch (Exception e2) {
            Util.m929a("Token conversion Error ");
        }
    }

    static List<NameValuePair> m1744a(Context context) throws NullPointerException, Exception {
        f616c = context;
        f615b = new ArrayList();
        if (C0559q.m1751g(context)) {
            String c = Util.m940c();
            if (c == null || c.equals("")) {
                throw new NullPointerException("Advertising id not avalaible");
            }
            f615b.add(new BasicNameValuePair(C0301h.IMEI, Util.m972m(c)));
            f615b.add(new BasicNameValuePair(C0301h.IMEI_SHA, Util.m975n(c)));
            f615b.add(new BasicNameValuePair(C0301h.DEVICE_UNIQUENESS, "ADV"));
        } else if (Util.m952g() == null || Util.m952g().length() == 0) {
            throw new NullPointerException("IMEI is empty");
        } else {
            f615b.add(new BasicNameValuePair(C0301h.IMEI, Util.m952g()));
            f615b.add(new BasicNameValuePair(C0301h.IMEI_SHA, Util.m956h()));
            f615b.add(new BasicNameValuePair(C0301h.DEVICE_UNIQUENESS, Util.m989w()));
            f615b.add(new BasicNameValuePair(C0301h.ANDROID_ID, Util.m941c(f616c)));
            f615b.add(new BasicNameValuePair(C0301h.ANDROID_ID_SHA, Util.m943d(f616c)));
            f615b.add(new BasicNameValuePair(C0301h.LONGITUDE, Util.m970m()));
            f615b.add(new BasicNameValuePair(C0301h.LATITUDE, Util.m967l()));
            f615b.add(new BasicNameValuePair("locProvider", "" + Util.m980q()));
            f615b.add(new BasicNameValuePair("locType", "" + Util.m976o()));
            f615b.add(new BasicNameValuePair("locAccuracy", "" + Util.m978p()));
            try {
                String[] l = Util.m969l(f616c);
                f615b.add(new BasicNameValuePair(C0301h.COUNTRY, "" + l[0]));
                f615b.add(new BasicNameValuePair(C0301h.ZIP, "" + l[1]));
            } catch (NullPointerException e) {
            } catch (Exception e2) {
            }
        }
        if (Util.m961j() == null || Util.m961j().length() == 0) {
            throw new NullPointerException("Appid is empty");
        }
        f615b.add(new BasicNameValuePair(C0301h.APIKEY, Util.m958i()));
        f615b.add(new BasicNameValuePair(C0301h.APP_ID, Util.m961j()));
        f615b.add(new BasicNameValuePair(C0301h.TOKEN, f617d));
        f615b.add(new BasicNameValuePair(C0301h.REQUEST_TIMESTAMP, Util.m982r()));
        f615b.add(new BasicNameValuePair(C0301h.PACKAGE_NAME, Util.m947e(f616c)));
        f615b.add(new BasicNameValuePair(C0304k.VERSION, Util.m986t()));
        f615b.add(new BasicNameValuePair(C0301h.CARRIER, Util.m950f(f616c)));
        f615b.add(new BasicNameValuePair(C0301h.NETWORK_OPERATOR, Util.m953g(f616c)));
        f615b.add(new BasicNameValuePair(C0301h.PHONE_MODEL, Util.m984s()));
        f615b.add(new BasicNameValuePair(C0301h.MANUFACTURER, Util.m988v()));
        f615b.add(new BasicNameValuePair(C0301h.SDK_VERSION, Util.m925a()));
        f615b.add(new BasicNameValuePair(C0301h.WIFI, "" + Util.m955h(f616c)));
        f615b.add(new BasicNameValuePair(C0301h.USER_AGENT, Util.m964k()));
        f615b.add(new BasicNameValuePair(C0301h.SCREEN_SIZE, Util.m965k(f616c)));
        f615b.add(new BasicNameValuePair(C0301h.NETWORK_SUBTYPE, Util.m959i(f616c)));
        f615b.add(new BasicNameValuePair(C0301h.isTABLET, String.valueOf(Util.m932a(f616c))));
        f615b.add(new BasicNameValuePair(C0301h.SCREEN_DENSITY, Util.m971m(f616c)));
        f615b.add(new BasicNameValuePair(C0301h.isCONNECTION_FAST, "" + Util.m963j(f616c)));
        f615b.add(new BasicNameValuePair(C0301h.UNKNOWN_SOURCE, "" + Util.m981q(f616c)));
        f615b.add(new BasicNameValuePair("appName", Util.m979p(f616c)));
        f615b.add(new BasicNameValuePair("dpi", Util.m974n(f616c)));
        f615b.add(new BasicNameValuePair("src", "premium"));
        f615b.add(new BasicNameValuePair("sessionId", Util.m946e()));
        f615b.add(new BasicNameValuePair(C0301h.LANGUAGE, "" + Util.m990x()));
        f615b.add(new BasicNameValuePair("locale", "" + Locale.getDefault()));
        f615b.add(new BasicNameValuePair("adv_id", "" + Util.m940c()));
        f615b.add(new BasicNameValuePair("adOpt", "" + Util.m939b()));
        return f615b;
    }

    static boolean m1746b(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        try {
            f618e = null;
            f618e = context.getSharedPreferences("next_ad_call", 0);
            Editor edit = f618e.edit();
            long currentTimeMillis = 10000 + System.currentTimeMillis();
            edit.putLong(C0301h.START_TIME, currentTimeMillis);
            z = edit.commit();
            Log.i(C0301h.TAG, "Next Smart Wall ad call time: " + new Date(currentTimeMillis).toString());
            return z;
        } catch (Exception e) {
            return z;
        }
    }

    static long m1747c(Context context) {
        f618e = null;
        if (context == null) {
            return 0;
        }
        f618e = context.getSharedPreferences("next_ad_call", 0);
        if (f618e != null) {
            return f618e.getLong(C0301h.START_TIME, 0);
        }
        return 0;
    }

    static boolean m1748d(Context context) {
        boolean z = false;
        try {
            f618e = null;
            f618e = context.getSharedPreferences("video_ad_call", 0);
            Editor edit = f618e.edit();
            long currentTimeMillis = 30000 + System.currentTimeMillis();
            edit.putLong(C0301h.START_TIME, currentTimeMillis);
            Util.m929a("Next Video ad ad call time: " + new Date(currentTimeMillis).toString());
            z = edit.commit();
        } catch (Exception e) {
        }
        return z;
    }

    static long m1749e(Context context) {
        f618e = null;
        if (context == null) {
            return 0;
        }
        f618e = context.getSharedPreferences("video_ad_call", 0);
        if (f618e != null) {
            return f618e.getLong(C0301h.START_TIME, 0);
        }
        return 0;
    }

    static void m1750f(Context context) {
        try {
            Editor edit = context.getSharedPreferences("firstTime", 0).edit();
            edit.putBoolean("showDialog", false);
            edit.putString("adv_id", Util.m940c());
            edit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static boolean m1751g(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("firstTime", 0);
        String string = sharedPreferences.getString("adv_id", "");
        String c = Util.m940c();
        if (sharedPreferences.getBoolean("showDialog", true)) {
            return true;
        }
        if (string.equals("") || c == null || c.length() <= 0 || string.equalsIgnoreCase(c)) {
            return false;
        }
        return true;
    }

    static void m1745a(Activity activity) {
        try {
            SharedPreferences sharedPreferences = activity.getSharedPreferences(C0301h.ENABLE_AD_PREF, 0);
            Prm prm = new Prm(activity);
            if (sharedPreferences.contains(C0301h.INTERSTITAL_AD_STRING) && sharedPreferences.getBoolean(C0301h.INTERSTITAL_AD_STRING, false)) {
                prm.runSmartWallAd();
            }
            if (sharedPreferences.contains(C0301h.OVERLAY_AD) && sharedPreferences.getBoolean(C0301h.OVERLAY_AD, false)) {
                prm.runOverlayAd();
            }
            if (sharedPreferences.contains(C0301h.APP_WALL_AD) && sharedPreferences.getBoolean(C0301h.APP_WALL_AD, false)) {
                prm.runAppWall();
            }
            if (sharedPreferences.contains(C0301h.VIDEO_AD) && sharedPreferences.getBoolean(C0301h.VIDEO_AD, false)) {
                prm.runVideoAd();
            }
            if (sharedPreferences.contains(C0301h.RICH_MEDIA) && sharedPreferences.getBoolean(C0301h.RICH_MEDIA, false)) {
                prm.runRichMediaInterstitialAd();
            }
        } catch (Throwable e) {
            Util.m930a("Error occured in eap: ", e);
        }
    }
}
