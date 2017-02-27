package com.sxnyodot.uefqvmio207964;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.C0049R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.wallet.WalletConstants;
import com.sxnyodot.uefqvmio207964.XmlParser.Creative;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

/* renamed from: com.sxnyodot.uefqvmio207964.u */
abstract class C0326u extends Activity {
    private static String f460F = null;
    private static final String TAG = "PrmVast";
    private static Context f461c;
    private boolean f462A;
    private int f463B;
    private int f464C;
    private int f465D;
    private boolean f466E;
    private XmlParser f467a;
    private Creative f468b;
    Set<NameValuePair> f469d;
    int f470e;
    int f471f;
    int f472g;
    int f473h;
    int f474i;
    int f475j;
    int f476k;
    int f477l;
    int f478m;
    int f479n;
    int f480o;
    int f481p;
    int f482q;
    int f483r;
    int f484s;
    int f485t;
    int f486u;
    int f487v;
    private boolean f488w;
    private int f489x;
    private int f490y;
    private boolean f491z;

    /* renamed from: com.sxnyodot.uefqvmio207964.u.1 */
    static class C03221 implements Runnable {
        final /* synthetic */ String f431a;

        C03221(String str) {
            this.f431a = str;
        }

        public void run() {
            try {
                Log.i(C0326u.TAG, "Sending vast event:" + this.f431a);
                Util.m929a("URL: " + this.f431a);
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
                defaultHttpClient.getParams().setParameter("http.useragent", C0326u.f460F);
                HttpResponse execute = defaultHttpClient.execute(new HttpGet(this.f431a));
                int statusCode = execute == null ? 0 : execute.getStatusLine().getStatusCode();
                Log.i(C0326u.TAG, "Status code: " + statusCode);
                if (statusCode == 200) {
                    Log.i(C0326u.TAG, "VAST Data: " + EntityUtils.toString(execute.getEntity()));
                } else {
                    Log.i(C0326u.TAG, "Error reason: " + execute.getStatusLine().getReasonPhrase());
                }
            } catch (Throwable e) {
                Log.e(C0326u.TAG, "Exception: ", e);
            }
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.u.2 */
    class C03232 implements Runnable {
        final /* synthetic */ C0326u f432a;

        C03232(C0326u c0326u) {
            this.f432a = c0326u;
        }

        public void run() {
            try {
                String decodeString = Base64.decodeString(C0301h.URL_VAST_EVENT_API);
                HttpClient defaultHttpClient = new DefaultHttpClient();
                HttpUriRequest httpPost = new HttpPost(decodeString);
                HttpParams basicHttpParams = new BasicHttpParams();
                defaultHttpClient.getParams().setParameter("http.useragent", C0326u.f460F);
                List arrayList = new ArrayList();
                arrayList.addAll(this.f432a.f469d);
                Log.i(C0326u.TAG, "Sending vast event:" + arrayList);
                httpPost.setEntity(new UrlEncodedFormEntity(arrayList));
                httpPost.setParams(basicHttpParams);
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 15000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 15000);
                HttpResponse execute = defaultHttpClient.execute(httpPost);
                int statusCode = execute == null ? 0 : execute.getStatusLine().getStatusCode();
                Log.i(C0326u.TAG, "Status code: " + statusCode);
                if (statusCode == 200) {
                    Log.i(C0326u.TAG, "Vast impression: " + EntityUtils.toString(execute.getEntity()));
                } else {
                    Log.i(C0326u.TAG, "Error reason: " + execute.getStatusLine().getReasonPhrase());
                }
            } catch (Throwable e) {
                Log.e(C0326u.TAG, "Exception: ", e);
            }
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.u.3 */
    static /* synthetic */ class C03243 {
        static final /* synthetic */ int[] f433a;

        static {
            f433a = new int[C0325a.values().length];
            try {
                f433a[C0325a.AdImpression.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f433a[C0325a.AdClickThru.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f433a[C0325a.AdVideoComplete.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f433a[C0325a.AdSkipped.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f433a[C0325a.AdPaused.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f433a[C0325a.AdPlaying.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f433a[C0325a.AdVideoStart.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f433a[C0325a.AdVideoFirstQuartile.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f433a[C0325a.AdVideoMidpoint.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f433a[C0325a.AdVideoThirdQuartile.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f433a[C0325a.AdLoaded.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f433a[C0325a.AdVolumeChange.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f433a[C0325a.AdUserClose.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.u.a */
    enum C0325a {
        AdLoaded,
        AdStarted,
        AdStopped,
        AdSkipped,
        AdSkippableStateChange,
        AdSizeChange,
        AdLinearChange,
        AdDurationChange,
        AdExpandedChange,
        AdRemainingTimeChange,
        AdVolumeChange,
        AdImpression,
        AdVideoStart,
        AdVideoFirstQuartile,
        AdVideoMidpoint,
        AdVideoThirdQuartile,
        AdClickThru,
        AdInteraction,
        AdUserAcceptInvitation,
        AdUserMinimize,
        AdUserClose,
        AdVideoComplete,
        AdPaused,
        AdPlaying,
        AdLog
    }

    abstract void m1056a();

    abstract void m1057a(int i);

    abstract void m1058a(int i, int i2, String str);

    abstract void m1059a(int i, int i2, String str, int i3, String str2, String str3);

    abstract void m1065b();

    abstract void m1068c();

    abstract void m1072d();

    C0326u() {
        this.f470e = 100;
        this.f471f = 101;
        this.f472g = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY;
        this.f473h = 200;
        this.f474i = 201;
        this.f475j = 202;
        this.f476k = 203;
        this.f477l = 300;
        this.f478m = 301;
        this.f479n = 302;
        this.f480o = 303;
        this.f481p = 400;
        this.f482q = 401;
        this.f483r = WalletConstants.ERROR_CODE_SERVICE_UNAVAILABLE;
        this.f484s = 403;
        this.f485t = WalletConstants.ERROR_CODE_MERCHANT_ACCOUNT_ERROR;
        this.f486u = 900;
        this.f487v = 901;
    }

    String m1064b(String str) {
        return "2.0";
    }

    void m1070c(String str) {
        f460F = str;
    }

    boolean m1076e() {
        return this.f488w;
    }

    void m1063a(boolean z) {
        this.f488w = z;
    }

    int m1077f() {
        return this.f489x;
    }

    void m1066b(int i) {
        this.f489x = i;
    }

    int m1079g() {
        return this.f490y;
    }

    void m1069c(int i) {
        this.f490y = i;
    }

    boolean m1081h() {
        return this.f491z;
    }

    void m1067b(boolean z) {
        this.f491z = z;
    }

    boolean m1082i() {
        return this.f462A;
    }

    void m1071c(boolean z) {
        this.f462A = z;
    }

    int m1083j() {
        return this.f463B;
    }

    void m1073d(int i) {
        this.f463B = i;
    }

    int m1084k() {
        return this.f464C;
    }

    void m1075e(int i) {
        this.f464C = i;
    }

    int m1085l() {
        return this.f465D;
    }

    void m1078f(int i) {
        this.f465D = i;
    }

    boolean m1086m() {
        return this.f466E;
    }

    void m1074d(boolean z) {
        this.f466E = z;
    }

    void m1061a(XmlParser xmlParser) {
        this.f467a = xmlParser;
    }

    void m1060a(Creative creative) {
        this.f468b = creative;
    }

    static void m1050a(Context context) {
        f461c = context;
    }

    void m1062a(C0325a c0325a) {
        switch (C03243.f433a[c0325a.ordinal()]) {
            case DetectedActivity.ON_BICYCLE /*1*/:
                this.f469d.add(new BasicNameValuePair("impression", "1"));
                m1054p();
            case DetectedActivity.ON_FOOT /*2*/:
                this.f469d.add(new BasicNameValuePair("click", "1"));
                m1055q();
            case DetectedActivity.STILL /*3*/:
                this.f469d.add(new BasicNameValuePair(C0304k.EVENT_COMPLETE, "1"));
                m1052d(C0304k.EVENT_COMPLETE);
            case DetectedActivity.UNKNOWN /*4*/:
                this.f469d.add(new BasicNameValuePair(C0304k.EVENT_SKIP, "1"));
                m1052d(C0304k.EVENT_SKIP);
            case DetectedActivity.TILTING /*5*/:
                this.f469d.add(new BasicNameValuePair(C0304k.EVENT_PAUSE, "1"));
                m1052d(C0304k.EVENT_PAUSE);
            case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                this.f469d.add(new BasicNameValuePair(C0304k.EVENT_RESUME, "1"));
                m1052d(C0304k.EVENT_RESUME);
            case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                this.f469d.add(new BasicNameValuePair(C0304k.EVENT_START, "1"));
                m1052d(C0304k.EVENT_START);
            case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                this.f469d.add(new BasicNameValuePair(C0304k.EVENT_FIRST_QUARTILE, "1"));
                m1052d(C0304k.EVENT_FIRST_QUARTILE);
            case ConnectionResult.SERVICE_INVALID /*9*/:
                this.f469d.add(new BasicNameValuePair(C0304k.EVENT_MID_POINT, "1"));
                m1052d(C0304k.EVENT_MID_POINT);
            case ConnectionResult.DEVELOPER_ERROR /*10*/:
                this.f469d.add(new BasicNameValuePair(C0304k.EVENT_THIRD_QUARTILE, "1"));
                m1052d(C0304k.EVENT_THIRD_QUARTILE);
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                this.f469d.add(new BasicNameValuePair(C0304k.EVENT_CREATIVE_VIEW, "1"));
                m1052d(C0304k.EVENT_CREATIVE_VIEW);
            case ConnectionResult.DATE_INVALID /*12*/:
                if (this.f465D == 0) {
                    this.f469d.add(new BasicNameValuePair(C0304k.EVENT_MUTE, "1"));
                    m1052d(C0304k.EVENT_MUTE);
                    return;
                }
                this.f469d.add(new BasicNameValuePair(C0304k.EVENT_UNMUTE, "1"));
                m1052d(C0304k.EVENT_UNMUTE);
            case C0049R.styleable.MapAttrs_zOrderOnTop /*13*/:
                this.f469d.add(new BasicNameValuePair(C0304k.EVENT_CLOSE, "1"));
                m1052d(C0304k.EVENT_CLOSE);
            default:
        }
    }

    private static synchronized void m1051a(String str) {
        synchronized (C0326u.class) {
            synchronized (str) {
                if (Util.m977o(f461c)) {
                    new Thread(new C03221(str), "vast_event").start();
                }
            }
        }
    }

    private void m1054p() {
        try {
            if (this.f467a != null) {
                for (HashMap hashMap : this.f467a.m1676f()) {
                    synchronized (hashMap) {
                        String str = (String) hashMap.get(C0304k.IMPRESSION);
                        Log.i(TAG, "Sending impression data: " + ((String) hashMap.get(C0304k.ID)));
                        if (str == null || str.equals("")) {
                            Log.i(TAG, "impression url not present");
                        } else {
                            C0326u.m1051a(str);
                        }
                    }
                }
            }
        } catch (Throwable e) {
            Log.e(TAG, "Error occurred while sending impression data: ", e);
        }
    }

    private void m1055q() {
        try {
            if (this.f468b != null) {
                try {
                    for (HashMap hashMap : this.f468b.getVideoClickTracking()) {
                        String str = (String) hashMap.get(C0304k.CLICK_TRACKING);
                        Log.i(TAG, "Sending click data: " + ((String) hashMap.get(C0304k.ID)));
                        if (str == null || str.equals("")) {
                            Log.i(TAG, "url is null");
                        } else {
                            C0326u.m1051a(str);
                        }
                    }
                } catch (Throwable e) {
                    Log.e(TAG, "Error occurred while sending click tracking data: ", e);
                }
                for (HashMap hashMap2 : this.f468b.getVideoCustomClickTracking()) {
                    Log.i(TAG, "Sending cutom click data: " + ((String) hashMap2.get(C0304k.ID)));
                    String str2 = (String) hashMap2.get(C0304k.CUSTOM_CLICK);
                    if (str2 == null || str2.equals("")) {
                        Log.i(TAG, "url is null");
                    } else {
                        C0326u.m1051a(str2);
                    }
                }
            }
        } catch (Throwable e2) {
            Log.e(TAG, "Error occurred while sending click data: ", e2);
        }
    }

    private synchronized void m1052d(String str) {
        try {
            if (!(this.f468b == null || str == null || str.equalsIgnoreCase("") || this.f468b.getTrackingEventMap() == null)) {
                Set<String> set = (Set) this.f468b.getTrackingEventMap().get(str);
                if (set == null || set.isEmpty()) {
                    Log.i(TAG, "Tracking event key not present in vast xml " + str);
                } else {
                    for (String str2 : set) {
                        Log.i(TAG, "Sending tracking data: " + str + ", url: " + str2);
                        if (str2 == null || str2.equals("")) {
                            Log.i(TAG, "url is null");
                        } else {
                            C0326u.m1051a(str2);
                        }
                    }
                }
            }
        } catch (Throwable e) {
            Log.e(TAG, "Error occurred while sending tracking data: ", e);
        }
    }

    void m1080g(int i) {
        try {
            if (this.f467a != null) {
                this.f469d.add(new BasicNameValuePair(IM.EVENT_ERROR, "1"));
                Log.i(TAG, "Sending error data: ");
                String j = this.f467a.m1680j();
                if (j == null || j.equals("")) {
                    Log.i(TAG, "error url is null");
                    return;
                }
                String adParams = this.f468b.getAdParams();
                if (j.contains("[ERRORCODE]")) {
                    j = j.replace("[ERRORCODE]", "" + i);
                }
                if (adParams != null && (adParams.startsWith("&") || j.endsWith("&"))) {
                    j = j + adParams;
                } else if (!(adParams == null || adParams.equalsIgnoreCase(""))) {
                    j = j + "&" + adParams;
                }
                C0326u.m1051a(j);
            }
        } catch (Throwable e) {
            Log.e(TAG, "Error occurred while sending error data: ", e);
        }
    }

    void m1087n() {
        try {
            if (this.f468b != null) {
                String adParams = this.f468b.getAdParams();
                if (adParams == null || adParams.equals("")) {
                    Log.i(TAG, "Ad param is null");
                } else {
                    for (String split : URLDecoder.decode(adParams, "UTF-8").split("&")) {
                        String[] split2 = split.split("=");
                        this.f469d.add(new BasicNameValuePair(split2[0], split2[1]));
                    }
                }
            }
        } catch (Throwable e) {
            Log.e(TAG, "Error occurred while sending: ", e);
        }
        try {
            this.f469d.add(new BasicNameValuePair("adduration", "" + this.f464C));
            this.f469d.add(new BasicNameValuePair("adRemainingTime", "" + this.f463B));
            synchronized (this.f469d) {
                if (Util.m977o(f461c)) {
                    new Thread(new C03232(this), "vast_report").start();
                    return;
                }
            }
        } catch (Throwable e2) {
            Log.e(TAG, "Error occurred while sending data: ", e2);
        }
    }
}
