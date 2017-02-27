package com.sxnyodot.uefqvmio207964;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.sxnyodot.uefqvmio207964.AdListener.BannerAdListener;
import com.sxnyodot.uefqvmio207964.JP.ParseBannerAd;
import com.sxnyodot.uefqvmio207964.JP.ParseMraidJson;
import com.sxnyodot.uefqvmio207964.Util.NativeMraid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public final class AdView extends FrameLayout {
    static final String AD_TYPE_BACC = "BACC";
    static final String AD_TYPE_BACM = "BACM";
    static final String AD_TYPE_BAU = "BAU";
    public static final String ANIMATION_TYPE_FADE = "fade";
    public static final String ANIMATION_TYPE_LEFT_TO_RIGHT = "left_to_right";
    public static final String ANIMATION_TYPE_TOP_DOWN = "top_down";
    static final int BACKGROUND_COLOR_DEFAULT = 0;
    static final int BANNER_HEIGHT_MOBILE = 50;
    static final int BANNER_HEIGHT_TABLET = 90;
    static final int BANNER_MEDIUM_RECTANGLE_HEIGHT = 250;
    static final int BANNER_MEDIUM_RECTANGLE_WIDTH = 300;
    static final String BANNER_TYPE_IMAGE = "image";
    public static final String BANNER_TYPE_IN_APP_AD = "inappad";
    public static final String BANNER_TYPE_MEDIUM_RECTANGLE = "medium_rectangle";
    public static final String BANNER_TYPE_RICH_MEDIA = "rich_media";
    static final String BANNER_TYPE_TEXT = "text";
    static final int BANNER_WIDTH_MOBILE = 320;
    static final int BANNER_WIDTH_TABLET = 728;
    public static final String PLACEMENT_TYPE_INLINE = "inline";
    public static final String PLACEMENT_TYPE_INTERSTITIAL = "interstitial";
    static final int REFRESH_AD = 45;
    static final int TEXT_COLOR_DEFAULT = -1;
    static BannerAdListener f128b;
    private C0249a f129A;
    boolean f130a;
    long f131c;
    boolean f132d;
    ParseMraidJson f133e;
    Handler f134f;
    Runnable f135g;
    C0293b<Boolean> f136h;
    private final String f137i;
    private boolean f138j;
    private boolean f139k;
    private int f140l;
    private String f141m;
    private boolean f142n;
    private Timer f143o;
    private Thread f144p;
    private ParseBannerAd f145q;
    private int f146r;
    private int f147s;
    private int f148t;
    private int f149u;
    private List<View> f150v;
    private String f151w;
    private String f152x;
    private Drawable f153y;
    private boolean f154z;

    /* renamed from: com.sxnyodot.uefqvmio207964.AdView.3 */
    class C02423 implements Runnable {
        final /* synthetic */ AdView f120a;

        C02423(AdView adView) {
            this.f120a = adView;
        }

        public void run() {
            if (AdView.f128b != null) {
                AdView.f128b.onErrorListener("Ad request failed. Internet connection not found.");
            }
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AdView.4 */
    class C02434 implements Runnable {
        final /* synthetic */ AdView f121a;

        C02434(AdView adView) {
            this.f121a = adView;
        }

        public void run() {
            this.f121a.m864c();
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AdView.5 */
    class C02445 implements Runnable {
        final /* synthetic */ AdView f122a;

        C02445(AdView adView) {
            this.f122a = adView;
        }

        public void run() {
            this.f122a.m866d();
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AdView.7 */
    class C02467 extends TimerTask {
        final /* synthetic */ AdView f125a;

        C02467(AdView adView) {
            this.f125a = adView;
        }

        public void run() {
            Util.m929a("Getting new ad....");
            this.f125a.getAd();
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AdView.8 */
    class C02478 extends TimerTask {
        final /* synthetic */ AdView f126a;

        C02478(AdView adView) {
            this.f126a = adView;
        }

        public void run() {
            Util.m929a("Getting new ad....");
            this.f126a.getAd();
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AdView.9 */
    class C02489 extends Handler {
        final /* synthetic */ AdView f127a;

        C02489(AdView adView) {
            this.f127a = adView;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case AdView.BACKGROUND_COLOR_DEFAULT /*0*/:
                    this.f127a.setVisibility(AdView.BACKGROUND_COLOR_DEFAULT);
                case DetectedActivity.ON_FOOT /*2*/:
                    this.f127a.m870f();
                case DetectedActivity.UNKNOWN /*4*/:
                    this.f127a.setVisibility(4);
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    this.f127a.setVisibility(8);
                default:
            }
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AdView.a */
    interface C0249a {
        void m844a();
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AdView.10 */
    class AnonymousClass10 implements C0293b<Boolean> {
        final /* synthetic */ Activity f516a;
        final /* synthetic */ AdView f517b;

        AnonymousClass10(AdView adView, Activity activity) {
            this.f517b = adView;
            this.f516a = activity;
        }

        public void m1604a(Boolean bool) {
            this.f517b.f153y = this.f517b.getBackground();
            this.f517b.setClickable(true);
            this.f517b.setFocusable(true);
            this.f517b.setDescendantFocusability(AccessibilityNodeInfoCompat.ACTION_SET_SELECTION);
            this.f517b.m860b();
            if (this.f517b.f144p == null || !this.f517b.f144p.isAlive()) {
                this.f517b.getAd();
            }
            if (C0559q.m1751g(this.f516a) && !MainActivity.m920a() && Prm.isDialogClosed) {
                Prm.isDialogClosed = false;
                new Thread(this.f517b.f135g, "optin").start();
                return;
            }
            Prm prm = new Prm(this.f516a);
        }

        public void m1603a() {
            new C0292a(this.f516a, this).execute(new Void[AdView.BACKGROUND_COLOR_DEFAULT]);
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AdView.11 */
    class AnonymousClass11 implements C0293b<Boolean> {
        final /* synthetic */ Context f518a;
        final /* synthetic */ AdView f519b;

        AnonymousClass11(AdView adView, Context context) {
            this.f519b = adView;
            this.f518a = context;
        }

        public void m1607a(Boolean bool) {
            try {
                if (!Util.m933a(this.f518a, BrowserActivity.class)) {
                    Log.e(IM.TAG, "Required BrowserActivty not found in Manifest please add.");
                    if (AdView.f128b != null) {
                        AdView.f128b.onErrorListener("Required BrowserActivty not found in Manifest please add.");
                    }
                    this.f519b.f138j = true;
                    return;
                }
            } catch (Exception e) {
            }
            if (new C0320s(this.f518a).m1047b()) {
                new C0559q(this.f518a).m1752a();
                this.f519b.f153y = this.f519b.getBackground();
                this.f519b.setClickable(true);
                this.f519b.setFocusable(true);
                this.f519b.setDescendantFocusability(AccessibilityNodeInfoCompat.ACTION_SET_SELECTION);
                this.f519b.m860b();
                if (this.f519b.f144p == null || !this.f519b.f144p.isAlive()) {
                    this.f519b.getAd();
                }
                if (C0559q.m1751g(this.f518a) && !MainActivity.m920a() && Prm.isDialogClosed) {
                    Prm.isDialogClosed = false;
                    new Thread(this.f519b.f135g, "optin").start();
                    return;
                }
                Prm prm = new Prm(this.f518a);
                return;
            }
            if (AdView.f128b != null) {
                AdView.f128b.onErrorListener("Can not serve ad on this device. Device details not found.");
            }
            this.f519b.f138j = true;
        }

        public void m1606a() {
            new C0292a(this.f518a, this).execute(new Void[AdView.BACKGROUND_COLOR_DEFAULT]);
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AdView.1 */
    class C05451 implements C0249a {
        final /* synthetic */ AdView f520a;

        C05451(AdView adView) {
            this.f520a = adView;
        }

        public void m1609a() {
            this.f520a.f134f.sendEmptyMessage(2);
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AdView.2 */
    class C05462 implements C0293b<String> {
        final /* synthetic */ AdView f521a;

        /* renamed from: com.sxnyodot.uefqvmio207964.AdView.2.1 */
        class C02411 implements Runnable {
            final /* synthetic */ int f117a;
            final /* synthetic */ String f118b;
            final /* synthetic */ C05462 f119c;

            C02411(C05462 c05462, int i, String str) {
                this.f119c = c05462;
                this.f117a = i;
                this.f118b = str;
            }

            public void run() {
                this.f119c.f521a.m849a(this.f117a, this.f118b);
            }
        }

        C05462(AdView adView) {
            this.f521a = adView;
        }

        public void m1610a() {
            String str;
            this.f521a.f142n = true;
            String str2 = "";
            if (this.f521a.f152x != null && this.f521a.f152x.equals(AdView.BANNER_TYPE_RICH_MEDIA)) {
                str = C0301h.URL_MRAID_API;
                if (this.f521a.f139k) {
                    str = C0301h.URL_MRAID_TEST_API;
                }
            } else if (this.f521a.f152x == null || !this.f521a.f152x.equals(AdView.BANNER_TYPE_IN_APP_AD)) {
                str = C0301h.URL_BANNER_API;
                if (this.f521a.f139k) {
                    str = C0301h.URL_BANNER_TEST_API;
                }
            } else {
                str = C0301h.URL_IN_APP_AD_API;
                if (this.f521a.f139k) {
                    str = C0301h.URL_MRAID_EVENT_API;
                }
            }
            List arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("banner_type", this.f521a.f152x));
            arrayList.add(new BasicNameValuePair("supports", "" + Util.m985s(this.f521a.getContext())));
            arrayList.add(new BasicNameValuePair("placement_type", "" + this.f521a.f141m));
            arrayList.add(new BasicNameValuePair("canShowMR", String.valueOf(this.f521a.f154z)));
            this.f521a.f144p = new Thread(new C0305m(this.f521a.getContext(), this, arrayList, str, 0, true), "AdView");
            this.f521a.f144p.start();
        }

        public void m1612a(String str) {
            try {
                Log.i(IM.TAG, "Ad json:" + str);
                this.f521a.f131c = System.currentTimeMillis();
                if (!(str == null || str.equals(""))) {
                    JSONObject jSONObject = new JSONObject(str);
                    String string = jSONObject.isNull("banner_type") ? "" : jSONObject.getString("banner_type");
                    if (string == null || string.equals("")) {
                        Log.i(IM.TAG, "No banner type present in response.");
                        this.f521a.post(new C02411(this, jSONObject.isNull("status") ? AdView.BACKGROUND_COLOR_DEFAULT : jSONObject.getInt("status"), jSONObject.isNull(C0301h.TYPE_MESSAGE) ? "" : jSONObject.getString(C0301h.TYPE_MESSAGE)));
                        return;
                    } else if (this.f521a.f152x.equals(AdView.BANNER_TYPE_IN_APP_AD)) {
                        if (string.equals(AdView.BANNER_TYPE_RICH_MEDIA)) {
                            string = jSONObject.getString("adtype");
                            if (string.equals("MIT")) {
                                this.f521a.f141m = AdView.PLACEMENT_TYPE_INTERSTITIAL;
                            } else if (string.equals("MIN")) {
                                this.f521a.f141m = AdView.PLACEMENT_TYPE_INLINE;
                            } else {
                                Log.i(IM.TAG, "Invalid placement type for rich media.");
                                this.f521a.f142n = false;
                                return;
                            }
                            this.f521a.m850a(this.f521a.getContext(), jSONObject);
                        } else if (string.equals(AdView.BANNER_TYPE_IMAGE) || string.equals(AdView.BANNER_TYPE_TEXT)) {
                            this.f521a.m857a(jSONObject);
                        } else if (!string.equals(AdView.BANNER_TYPE_MEDIUM_RECTANGLE)) {
                            Log.i(IM.TAG, "Invalid banner type in inappad json: " + string);
                        } else if (this.f521a.f154z) {
                            this.f521a.m857a(jSONObject);
                        } else {
                            Log.w(IM.TAG, "Can not show this ad.");
                        }
                    } else if (this.f521a.f152x.equals(AdView.BANNER_TYPE_RICH_MEDIA) && string.equals(AdView.BANNER_TYPE_RICH_MEDIA)) {
                        this.f521a.m850a(this.f521a.getContext(), jSONObject);
                    } else if (this.f521a.f152x.equals(AdView.BANNER_TYPE_IMAGE) && (string.equals(AdView.BANNER_TYPE_IMAGE) || string.equals(AdView.BANNER_TYPE_TEXT))) {
                        this.f521a.m857a(jSONObject);
                    } else if (this.f521a.f152x.equals(AdView.BANNER_TYPE_MEDIUM_RECTANGLE) && string.equals(AdView.BANNER_TYPE_MEDIUM_RECTANGLE)) {
                        this.f521a.m857a(jSONObject);
                    } else {
                        Log.i(IM.TAG, "Invalid banner type in json: " + string);
                    }
                }
                this.f521a.f142n = false;
            } catch (Throwable e) {
                Log.w(IM.TAG, "error occurred while parsing banner", e);
            } finally {
                this.f521a.f142n = false;
            }
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AdView.6 */
    class C05476 implements C0293b<Boolean> {
        final /* synthetic */ AdView f522a;

        /* renamed from: com.sxnyodot.uefqvmio207964.AdView.6.1 */
        class C02451 implements Runnable {
            final /* synthetic */ Boolean f123a;
            final /* synthetic */ C05476 f124b;

            C02451(C05476 c05476, Boolean bool) {
                this.f124b = c05476;
                this.f123a = bool;
            }

            public void run() {
                if (this.f123a.booleanValue()) {
                    this.f124b.f522a.m864c();
                } else {
                    Log.e(IM.TAG, "Not able to get mraid.");
                }
            }
        }

        C05476(AdView adView) {
            this.f522a = adView;
        }

        public void m1614a(Boolean bool) {
            try {
                this.f522a.post(new C02451(this, bool));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void m1613a() {
            new Thread(new NativeMraid(this.f522a.getContext(), this), "native_mraid").start();
        }
    }

    public AdView(Activity activity, String banner_type, String placementType, boolean isTestMode, boolean canShowMRInAPP, String animationForBanner) {
        super(activity);
        this.f137i = IM.TAG;
        this.f130a = false;
        this.f138j = false;
        this.f139k = false;
        this.f140l = REFRESH_AD;
        this.f142n = false;
        this.f131c = 0;
        this.f132d = true;
        this.f146r = BANNER_WIDTH_MOBILE;
        this.f147s = BANNER_HEIGHT_MOBILE;
        this.f150v = new ArrayList();
        this.f151w = ANIMATION_TYPE_FADE;
        this.f152x = BANNER_TYPE_IN_APP_AD;
        this.f154z = false;
        this.f129A = new C05451(this);
        this.f134f = new C02489(this);
        this.f135g = new Runnable() {
            final /* synthetic */ AdView f112a;

            {
                this.f112a = r1;
            }

            public void run() {
                Exception exception;
                Throwable th;
                try {
                    if (!MainActivity.m920a()) {
                        String str;
                        Intent intent;
                        String str2 = "";
                        HttpURLConnection httpURLConnection = null;
                        if (Util.m977o(this.f112a.getContext())) {
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
                                            intent = new Intent(this.f112a.getContext(), MainActivity.class);
                                            intent.setFlags(268435456);
                                            intent.addFlags(536870912);
                                            intent.putExtra("data", "" + str);
                                            intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                                            this.f112a.getContext().startActivity(intent);
                                        }
                                        str = str2;
                                        intent = new Intent(this.f112a.getContext(), MainActivity.class);
                                        intent.setFlags(268435456);
                                        intent.addFlags(536870912);
                                        intent.putExtra("data", "" + str);
                                        intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                                        this.f112a.getContext().startActivity(intent);
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
                                    intent = new Intent(this.f112a.getContext(), MainActivity.class);
                                    intent.setFlags(268435456);
                                    intent.addFlags(536870912);
                                    intent.putExtra("data", "" + str);
                                    intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                                    this.f112a.getContext().startActivity(intent);
                                }
                                str = str2;
                                intent = new Intent(this.f112a.getContext(), MainActivity.class);
                                intent.setFlags(268435456);
                                intent.addFlags(536870912);
                                intent.putExtra("data", "" + str);
                                intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                                this.f112a.getContext().startActivity(intent);
                            }
                            intent = new Intent(this.f112a.getContext(), MainActivity.class);
                            intent.setFlags(268435456);
                            intent.addFlags(536870912);
                            intent.putExtra("data", "" + str);
                            intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                            this.f112a.getContext().startActivity(intent);
                        }
                        str = str2;
                        intent = new Intent(this.f112a.getContext(), MainActivity.class);
                        intent.setFlags(268435456);
                        intent.addFlags(536870912);
                        intent.putExtra("data", "" + str);
                        intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                        this.f112a.getContext().startActivity(intent);
                    }
                } catch (ActivityNotFoundException e3) {
                    Log.e(IM.TAG, "Required AdActivity not declared in Manifest, Please add.");
                    if (AdView.f128b != null) {
                        AdView.f128b.onErrorListener("Required AdActivity not declared in Manifest, Please add.");
                    }
                } catch (Exception exception3) {
                    Log.e(IM.TAG, "Error in Optin runnable: " + exception3.getMessage());
                }
            }
        };
        this.f136h = new C05476(this);
        Log.i(IM.TAG, "Initializing AdView: " + Util.m925a());
        this.f139k = isTestMode;
        Log.i(IM.TAG, "isTestMode: " + isTestMode);
        if (banner_type == null || !(banner_type.equals(BANNER_TYPE_RICH_MEDIA) || banner_type.equals(BANNER_TYPE_MEDIUM_RECTANGLE) || banner_type.equals(BANNER_TYPE_IN_APP_AD))) {
            this.f152x = BANNER_TYPE_IN_APP_AD;
            Log.e(IM.TAG, "Invalid banner type. Setting to default: inappad");
        } else {
            this.f152x = banner_type;
            Log.i(IM.TAG, "Banner Type: " + banner_type);
        }
        if (this.f152x != null && this.f152x.equals(BANNER_TYPE_RICH_MEDIA)) {
            if (placementType == null || !(placementType.equals(PLACEMENT_TYPE_INLINE) || placementType.equals(PLACEMENT_TYPE_INTERSTITIAL))) {
                this.f141m = PLACEMENT_TYPE_INLINE;
                Log.e(IM.TAG, "Invalid placement type. Setting to default: inline");
            } else {
                this.f141m = placementType;
            }
        }
        this.f140l = REFRESH_AD;
        this.f154z = canShowMRInAPP;
        if (animationForBanner != null) {
            this.f151w = animationForBanner;
        } else {
            this.f151w = ANIMATION_TYPE_FADE;
        }
        if (C0558p.getDataFromManifest(activity) && C0558p.checkRequiredPermission(activity)) {
            try {
                if (!Util.m933a((Context) activity, BrowserActivity.class)) {
                    Log.e(IM.TAG, "Required BrowserActivty not found in Manifest please add.");
                    if (f128b != null) {
                        f128b.onErrorListener("Required BrowserActivty not found in Manifest please add.");
                    }
                    this.f138j = true;
                    return;
                }
            } catch (Exception e) {
            }
            setVisibility(8);
            if (new C0320s(activity).m1047b()) {
                new C0559q(activity).m1752a();
                if (C0558p.validate(activity)) {
                    C0293b anonymousClass10 = new AnonymousClass10(this, activity);
                    if (C0292a.m1001a()) {
                        anonymousClass10.m1005a(Boolean.valueOf(false));
                        return;
                    } else {
                        anonymousClass10.m1004a();
                        return;
                    }
                }
                this.f138j = true;
                Log.e(IM.TAG, "com.google.android.gms.version not delclared in manifest.");
                if (f128b != null) {
                    f128b.onErrorListener("com.google.android.gms.version not delclared in manifest.");
                    return;
                }
                return;
            }
            if (f128b != null) {
                f128b.onErrorListener("Can not serve ad on this device. Device details not found.");
            }
            this.f138j = true;
            return;
        }
        this.f138j = true;
    }

    public AdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f137i = IM.TAG;
        this.f130a = false;
        this.f138j = false;
        this.f139k = false;
        this.f140l = REFRESH_AD;
        this.f142n = false;
        this.f131c = 0;
        this.f132d = true;
        this.f146r = BANNER_WIDTH_MOBILE;
        this.f147s = BANNER_HEIGHT_MOBILE;
        this.f150v = new ArrayList();
        this.f151w = ANIMATION_TYPE_FADE;
        this.f152x = BANNER_TYPE_IN_APP_AD;
        this.f154z = false;
        this.f129A = new C05451(this);
        this.f134f = new C02489(this);
        this.f135g = new Runnable() {
            final /* synthetic */ AdView f112a;

            {
                this.f112a = r1;
            }

            public void run() {
                Exception exception3;
                Throwable th;
                try {
                    if (!MainActivity.m920a()) {
                        String str;
                        Intent intent;
                        String str2 = "";
                        HttpURLConnection httpURLConnection = null;
                        if (Util.m977o(this.f112a.getContext())) {
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
                                    exception3 = exception2;
                                    try {
                                        exception3.printStackTrace();
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                            str = str2;
                                            intent = new Intent(this.f112a.getContext(), MainActivity.class);
                                            intent.setFlags(268435456);
                                            intent.addFlags(536870912);
                                            intent.putExtra("data", "" + str);
                                            intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                                            this.f112a.getContext().startActivity(intent);
                                        }
                                        str = str2;
                                        intent = new Intent(this.f112a.getContext(), MainActivity.class);
                                        intent.setFlags(268435456);
                                        intent.addFlags(536870912);
                                        intent.putExtra("data", "" + str);
                                        intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                                        this.f112a.getContext().startActivity(intent);
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
                                exception3 = e2;
                                exception3.printStackTrace();
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                    str = str2;
                                    intent = new Intent(this.f112a.getContext(), MainActivity.class);
                                    intent.setFlags(268435456);
                                    intent.addFlags(536870912);
                                    intent.putExtra("data", "" + str);
                                    intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                                    this.f112a.getContext().startActivity(intent);
                                }
                                str = str2;
                                intent = new Intent(this.f112a.getContext(), MainActivity.class);
                                intent.setFlags(268435456);
                                intent.addFlags(536870912);
                                intent.putExtra("data", "" + str);
                                intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                                this.f112a.getContext().startActivity(intent);
                            }
                            intent = new Intent(this.f112a.getContext(), MainActivity.class);
                            intent.setFlags(268435456);
                            intent.addFlags(536870912);
                            intent.putExtra("data", "" + str);
                            intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                            this.f112a.getContext().startActivity(intent);
                        }
                        str = str2;
                        intent = new Intent(this.f112a.getContext(), MainActivity.class);
                        intent.setFlags(268435456);
                        intent.addFlags(536870912);
                        intent.putExtra("data", "" + str);
                        intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                        this.f112a.getContext().startActivity(intent);
                    }
                } catch (ActivityNotFoundException e3) {
                    Log.e(IM.TAG, "Required AdActivity not declared in Manifest, Please add.");
                    if (AdView.f128b != null) {
                        AdView.f128b.onErrorListener("Required AdActivity not declared in Manifest, Please add.");
                    }
                } catch (Exception exception32) {
                    Log.e(IM.TAG, "Error in Optin runnable: " + exception32.getMessage());
                }
            }
        };
        this.f136h = new C05476(this);
        Log.i(IM.TAG, "Initializing AdView from xml: " + Util.m925a());
        if (attributeSet == null) {
            if (f128b != null) {
                f128b.onErrorListener("AttributeSet can not be null. If you are creating layout from dynamic code then use the other consturctor.");
            }
            Log.e(IM.TAG, "AttributeSet can not be null. If you are creating layout from dynamic code then use the other consturctor.");
            this.f138j = true;
        } else if (!C0558p.getDataFromManifest(context) || !C0558p.checkRequiredPermission(context)) {
            this.f138j = true;
        } else if (C0558p.validate(context)) {
            m851a(attributeSet);
            setVisibility(8);
            C0293b anonymousClass11 = new AnonymousClass11(this, context);
            if (C0292a.m1001a()) {
                anonymousClass11.m1005a(Boolean.valueOf(false));
            } else {
                anonymousClass11.m1004a();
            }
        } else {
            Log.e(IM.TAG, "com.google.android.gms.version not delclared in manifest.");
            this.f138j = true;
            if (f128b != null) {
                f128b.onErrorListener("com.google.android.gms.version not delclared in manifest.");
            }
        }
    }

    private void m860b() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(C0301h.SDK_PREFERENCE, BACKGROUND_COLOR_DEFAULT);
        if (sharedPreferences == null || !sharedPreferences.contains(C0301h.SDK_ENABLED)) {
            C0558p.enableSDK(getContext(), true);
        }
    }

    private void m851a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            try {
                String str = "http://schemas.android.com/apk/res-auto";
                this.f139k = attributeSet.getAttributeBooleanValue(str, "test_mode", false);
                Log.i(IM.TAG, "isTestMode: " + this.f139k);
                this.f140l = REFRESH_AD;
                String attributeValue = attributeSet.getAttributeValue(str, "banner_type");
                if (attributeValue == null || !(attributeValue.equals(BANNER_TYPE_RICH_MEDIA) || attributeValue.equals(BANNER_TYPE_MEDIUM_RECTANGLE) || attributeValue.equals(BANNER_TYPE_IN_APP_AD))) {
                    this.f152x = BANNER_TYPE_IN_APP_AD;
                    Log.w(IM.TAG, "Invalid banner type. Setting to default: inappad");
                } else {
                    Log.i(IM.TAG, "Banner Type: " + attributeValue);
                    this.f152x = attributeValue;
                }
                if (attributeValue != null && attributeValue.equals(BANNER_TYPE_RICH_MEDIA)) {
                    if (attributeSet.getAttributeValue(str, IM.PLACEMENT_TYPE) != null) {
                        this.f141m = attributeSet.getAttributeValue(str, IM.PLACEMENT_TYPE);
                    } else {
                        Log.w(IM.TAG, "Invalid placement type. Setting to default placementType: inline.");
                        this.f141m = PLACEMENT_TYPE_INLINE;
                    }
                }
                if (attributeSet.getAttributeValue(str, "animation") != null) {
                    this.f151w = attributeSet.getAttributeValue(str, "animation");
                } else {
                    this.f151w = ANIMATION_TYPE_FADE;
                }
                this.f154z = attributeSet.getAttributeBooleanValue(str, "canShowMR", false);
                return;
            } catch (Throwable e) {
                Log.e(IM.TAG, "Error occurred: ", e);
                return;
            }
        }
        Util.m929a("AttributeSet is null. Using default parameters");
        this.f152x = BANNER_TYPE_IN_APP_AD;
        this.f154z = false;
        this.f151w = ANIMATION_TYPE_FADE;
        this.f140l = REFRESH_AD;
        this.f141m = PLACEMENT_TYPE_INLINE;
        this.f139k = false;
    }

    private void m864c() {
        try {
            m871g();
            if (this.f133e != null) {
                if (this.f133e.isHtmlAd() || this.f133e.isInlineScript() || this.f133e.isJsAd()) {
                    if (this.f133e.getTag() == null || this.f133e.equals("")) {
                        Log.i(IM.TAG, "Tag data is null");
                        return;
                    }
                } else if (this.f133e.getAd_url() == null || this.f133e.equals("")) {
                    Log.i(IM.TAG, "Ad url is null");
                    return;
                }
                Log.i(IM.TAG, "Loading Mraid ad..");
                View mv = new MV(getContext(), this, f128b, this.f134f, this.f129A);
                int childCount = getChildCount();
                if (childCount > 0) {
                    for (int i = BACKGROUND_COLOR_DEFAULT; i < childCount; i++) {
                        if (getChildAt(i) != null) {
                            this.f150v.add(getChildAt(i));
                        }
                    }
                }
                addView(mv);
                return;
            }
            removeAllViews();
            setVisibility(8);
            Log.i(IM.TAG, "Ad not loaded. Mraid data is null.");
            post(new Runnable() {
                final /* synthetic */ AdView f113a;

                {
                    this.f113a = r1;
                }

                public void run() {
                    if (AdView.f128b != null) {
                        AdView.f128b.onErrorListener("Ad not loaded. Url is null.");
                    }
                }
            });
        } catch (Throwable e) {
            Log.w(IM.TAG, "Error occurred while loading rich media banner ad", e);
        }
    }

    private void m866d() {
        try {
            m871g();
            if (this.f145q != null) {
                if (this.f145q.isHtmlAd() || this.f145q.m896a() || this.f145q.isJsAd() || this.f145q.m898b()) {
                    if (this.f145q.getTag().equals("")) {
                        Log.i(IM.TAG, "Tag data is null");
                        return;
                    }
                } else if (this.f145q.getAdimage() == null || this.f145q.getAdimage().equals("")) {
                    Log.i(IM.TAG, "image url is null");
                    return;
                }
                Log.i(IM.TAG, "Loading banner ad");
                View ib = new IB(getContext(), this.f148t, this.f149u, this.f134f, this.f145q, this.f129A, this.f139k, this);
                m867e();
                addView(ib);
                Animation a = m846a(false);
                if (a != null) {
                    ib.startAnimation(a);
                }
                Log.i(IM.TAG, "Ad loaded successfully");
                if (f128b != null) {
                    f128b.onAdLoadedListener();
                    return;
                }
                return;
            }
            removeAllViews();
            Log.w(IM.TAG, "Ad not loaded. Banner data is null.");
            setVisibility(8);
        } catch (Throwable e) {
            Log.w(IM.TAG, "Error occurred while loading banner ad", e);
        }
    }

    synchronized void getAd() {
        if (!this.f132d || this.f130a) {
            Util.m929a("Ad request is disabled.");
        } else if (C0558p.isSDKEnabled(getContext())) {
            if (this.f142n) {
                Log.i(IM.TAG, "Ad request is already in progress.");
                if (f128b != null) {
                    post(new Runnable() {
                        final /* synthetic */ AdView f115a;

                        {
                            this.f115a = r1;
                        }

                        public void run() {
                            AdView.f128b.onErrorListener("Another ad request is already in progress. Please wait...");
                        }
                    });
                }
            } else if (System.currentTimeMillis() - this.f131c < ((long) this.f140l)) {
                Log.i(IM.TAG, "Ad requested beforing refresh time. Aborting request... ");
                if (f128b != null) {
                    post(new Runnable() {
                        final /* synthetic */ AdView f116a;

                        {
                            this.f116a = r1;
                        }

                        public void run() {
                            AdView.f128b.onErrorListener("Ad requested beforing refresh time. Aborting request... ");
                        }
                    });
                }
            } else {
                synchronized (this) {
                    C0293b c05462 = new C05462(this);
                    if (Util.m977o(getContext())) {
                        c05462.m1004a();
                    } else {
                        post(new C02423(this));
                    }
                }
            }
        } else if (f128b != null) {
            post(new Runnable() {
                final /* synthetic */ AdView f114a;

                {
                    this.f114a = r1;
                }

                public void run() {
                    AdView.f128b.onErrorListener("SDK is diabled please enable to received ad.");
                }
            });
        }
    }

    private void m850a(Context context, JSONObject jSONObject) {
        try {
            this.f133e = new ParseMraidJson(getContext(), jSONObject);
            m856a(BANNER_TYPE_RICH_MEDIA, this.f133e.getWidth(), this.f133e.getHeight());
            int refreshTime = this.f133e.getRefreshTime();
            if (refreshTime > 0 && this.f140l != refreshTime) {
                this.f140l = refreshTime;
                m858a(true, true);
            }
            String r = Util.m983r(context);
            if (r != null && !r.equals("")) {
                this.f134f.post(new C02434(this));
            } else if (Util.m977o(getContext())) {
                this.f136h.m1004a();
            }
        } catch (JSONException e) {
            Log.e(IM.TAG, "JSONExection occured while parsing MRAID json: " + e.getMessage());
        } catch (IOException e2) {
            Log.w(IM.TAG, "" + e2.getMessage());
        } catch (Throwable e3) {
            Log.w(IM.TAG, "Error occurred while parsing rich media json", e3);
        }
    }

    private void m857a(JSONObject jSONObject) {
        try {
            this.f145q = new ParseBannerAd();
            if (this.f145q.m897a(getContext(), jSONObject, this.f152x)) {
                m856a(this.f145q.m902f(), this.f145q.getWidth(), this.f145q.getHeight());
                this.f134f.post(new C02445(this));
                int refreshTime = this.f145q.getRefreshTime();
                if (refreshTime > 0 && this.f140l != refreshTime) {
                    this.f140l = refreshTime;
                    m858a(true, true);
                }
            }
        } catch (JSONException e) {
            Log.e(IM.TAG, "JSONExection occured while parsing Banner ad json: " + e.getMessage());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setVisibility(int visibility) {
        if (super.getVisibility() != visibility) {
            synchronized (this) {
                int childCount = getChildCount();
                for (int i = BACKGROUND_COLOR_DEFAULT; i < childCount; i++) {
                    getChildAt(i).setVisibility(visibility);
                }
                super.setVisibility(visibility);
            }
        }
    }

    public void onWindowFocusChanged(boolean hasWindowFocus) {
        m858a(hasWindowFocus, false);
        super.onWindowFocusChanged(hasWindowFocus);
        getParent();
    }

    protected void onAttachedToWindow() {
        m858a(false, false);
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        m858a(false, false);
        super.onDetachedFromWindow();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m858a(boolean r9, boolean r10) {
        /*
        r8 = this;
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        monitor-enter(r8);
        r0 = r8.f138j;	 Catch:{ Exception -> 0x0076 }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r8);	 Catch:{ all -> 0x002c }
    L_0x0008:
        return;
    L_0x0009:
        if (r9 == 0) goto L_0x002f;
    L_0x000b:
        if (r10 != 0) goto L_0x002f;
    L_0x000d:
        r0 = r8.f143o;	 Catch:{ Exception -> 0x0076 }
        if (r0 != 0) goto L_0x002a;
    L_0x0011:
        r0 = new java.util.Timer;	 Catch:{ Exception -> 0x0076 }
        r0.<init>();	 Catch:{ Exception -> 0x0076 }
        r8.f143o = r0;	 Catch:{ Exception -> 0x0076 }
        r1 = new com.sxnyodot.uefqvmio207964.AdView$7;	 Catch:{ Exception -> 0x0076 }
        r1.<init>(r8);	 Catch:{ Exception -> 0x0076 }
        r0 = r8.f143o;	 Catch:{ Exception -> 0x0076 }
        r2 = r8.f140l;	 Catch:{ Exception -> 0x0076 }
        r2 = (long) r2;	 Catch:{ Exception -> 0x0076 }
        r2 = r2 * r6;
        r4 = r8.f140l;	 Catch:{ Exception -> 0x0076 }
        r4 = (long) r4;	 Catch:{ Exception -> 0x0076 }
        r4 = r4 * r6;
        r0.scheduleAtFixedRate(r1, r2, r4);	 Catch:{ Exception -> 0x0076 }
    L_0x002a:
        monitor-exit(r8);	 Catch:{ all -> 0x002c }
        goto L_0x0008;
    L_0x002c:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x002c }
        throw r0;
    L_0x002f:
        if (r9 == 0) goto L_0x007f;
    L_0x0031:
        if (r10 == 0) goto L_0x007f;
    L_0x0033:
        r0 = r8.f143o;	 Catch:{ Exception -> 0x0076 }
        if (r0 == 0) goto L_0x002a;
    L_0x0037:
        r0 = r8.f143o;	 Catch:{ Exception -> 0x0076 }
        r0.cancel();	 Catch:{ Exception -> 0x0076 }
        r0 = 0;
        r8.f143o = r0;	 Catch:{ Exception -> 0x0076 }
        r0 = 1;
        r8.f132d = r0;	 Catch:{ Exception -> 0x0076 }
        r0 = new java.util.Timer;	 Catch:{ Exception -> 0x0076 }
        r0.<init>();	 Catch:{ Exception -> 0x0076 }
        r8.f143o = r0;	 Catch:{ Exception -> 0x0076 }
        r1 = new com.sxnyodot.uefqvmio207964.AdView$8;	 Catch:{ Exception -> 0x0076 }
        r1.<init>(r8);	 Catch:{ Exception -> 0x0076 }
        r0 = r8.f143o;	 Catch:{ Exception -> 0x0076 }
        r2 = r8.f140l;	 Catch:{ Exception -> 0x0076 }
        r2 = (long) r2;	 Catch:{ Exception -> 0x0076 }
        r2 = r2 * r6;
        r4 = r8.f140l;	 Catch:{ Exception -> 0x0076 }
        r4 = (long) r4;	 Catch:{ Exception -> 0x0076 }
        r4 = r4 * r6;
        r0.scheduleAtFixedRate(r1, r2, r4);	 Catch:{ Exception -> 0x0076 }
        r0 = "PrmMraid";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0076 }
        r1.<init>();	 Catch:{ Exception -> 0x0076 }
        r2 = "Refresh time changed.> ";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0076 }
        r2 = r8.f140l;	 Catch:{ Exception -> 0x0076 }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0076 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0076 }
        android.util.Log.i(r0, r1);	 Catch:{ Exception -> 0x0076 }
        goto L_0x002a;
    L_0x0076:
        r0 = move-exception;
        r1 = "PrmMraid";
        r2 = "Error in refresh timer";
        android.util.Log.e(r1, r2, r0);	 Catch:{ all -> 0x002c }
        goto L_0x002a;
    L_0x007f:
        r0 = r8.f143o;	 Catch:{ Exception -> 0x0076 }
        if (r0 == 0) goto L_0x002a;
    L_0x0083:
        r0 = r8.f143o;	 Catch:{ Exception -> 0x0076 }
        r0.cancel();	 Catch:{ Exception -> 0x0076 }
        r0 = 0;
        r8.f143o = r0;	 Catch:{ Exception -> 0x0076 }
        r0 = "PrmMraid";
        r1 = "Lost foucus. Removing thread>>>";
        android.util.Log.i(r0, r1);	 Catch:{ Exception -> 0x0076 }
        r0 = 1;
        r8.f132d = r0;	 Catch:{ Exception -> 0x0076 }
        r0 = r8.f144p;	 Catch:{ Exception -> 0x0076 }
        if (r0 == 0) goto L_0x002a;
    L_0x0099:
        r0 = r8.f144p;	 Catch:{ Exception -> 0x0076 }
        r0 = r0.isAlive();	 Catch:{ Exception -> 0x0076 }
        if (r0 == 0) goto L_0x002a;
    L_0x00a1:
        r0 = r8.f144p;	 Catch:{ Exception -> 0x0076 }
        r0.interrupt();	 Catch:{ Exception -> 0x0076 }
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sxnyodot.uefqvmio207964.AdView.a(boolean, boolean):void");
    }

    private void m867e() {
        int childCount = getChildCount();
        if (childCount > 0) {
            Animation a = m846a(true);
            int i = BACKGROUND_COLOR_DEFAULT;
            while (i < childCount) {
                if (!(a == null || getChildAt(i) == null)) {
                    getChildAt(i).setAnimation(a);
                    this.f150v.add(getChildAt(i));
                }
                i++;
            }
        }
    }

    private Animation m846a(boolean z) {
        Animation alphaAnimation;
        if (z) {
            if (this.f151w != null && this.f151w.equals(ANIMATION_TYPE_FADE)) {
                alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(700);
                return alphaAnimation;
            } else if (this.f151w != null && this.f151w.equals(ANIMATION_TYPE_LEFT_TO_RIGHT)) {
                alphaAnimation = new TranslateAnimation(2, 0.0f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
                alphaAnimation.setDuration(900);
                alphaAnimation.setInterpolator(new AccelerateInterpolator());
                return alphaAnimation;
            } else if (this.f151w == null || !this.f151w.equals(ANIMATION_TYPE_TOP_DOWN)) {
                return null;
            } else {
                alphaAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 1.0f);
                alphaAnimation.setDuration(900);
                alphaAnimation.setInterpolator(new AccelerateInterpolator());
                return alphaAnimation;
            }
        } else if (this.f151w != null && this.f151w.equals(ANIMATION_TYPE_FADE)) {
            alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(1200);
            return alphaAnimation;
        } else if (this.f151w != null && this.f151w.equals(ANIMATION_TYPE_LEFT_TO_RIGHT)) {
            alphaAnimation = new TranslateAnimation(2, GroundOverlayOptions.NO_DIMENSION, 2, 0.0f, 2, 0.0f, 2, 0.0f);
            alphaAnimation.setDuration(900);
            alphaAnimation.setInterpolator(new AccelerateInterpolator());
            return alphaAnimation;
        } else if (this.f151w == null || !this.f151w.equals(ANIMATION_TYPE_TOP_DOWN)) {
            return null;
        } else {
            alphaAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, GroundOverlayOptions.NO_DIMENSION, 2, 0.0f);
            alphaAnimation.setDuration(900);
            alphaAnimation.setInterpolator(new AccelerateInterpolator());
            return alphaAnimation;
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(this.f146r, 1073741824), MeasureSpec.makeMeasureSpec(this.f147s, 1073741824));
        setMeasuredDimension(this.f146r, this.f147s);
    }

    private void m856a(String str, int i, int i2) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        float f = displayMetrics.density;
        if (i < BANNER_WIDTH_MOBILE) {
            i = BANNER_WIDTH_MOBILE;
        }
        if (i2 < BANNER_HEIGHT_MOBILE) {
            i2 = BANNER_HEIGHT_MOBILE;
        }
        this.f147s = (int) ((((float) i2) * f) + 0.5f);
        this.f149u = i2;
        this.f146r = (int) ((((float) i) * f) + 0.5f);
        this.f148t = i;
        int i3 = this.f147s;
        int i4 = this.f146r;
        if (displayMetrics.heightPixels < this.f147s) {
            i3 = displayMetrics.heightPixels;
        }
        if (displayMetrics.widthPixels < this.f146r) {
            i4 = displayMetrics.widthPixels;
        }
        float f2 = ((float) this.f147s) / ((float) i3);
        float f3 = ((float) this.f146r) / ((float) i4);
        if (f2 > f3) {
            this.f146r = (int) (((float) this.f146r) / f2);
            this.f147s = i3;
            this.f148t = (int) (((float) this.f146r) / f);
            this.f149u = (int) (((float) i3) / f);
            Util.m929a("if: " + f2 + " " + f3 + " " + this.f146r + " " + this.f147s + " " + this.f148t + " " + this.f149u);
            return;
        }
        this.f146r = i4;
        this.f147s = (int) (((float) this.f147s) / f3);
        this.f148t = (int) (((float) i4) / f);
        this.f149u = (int) (((float) this.f147s) / f);
        Util.m929a("else: " + f2 + " " + f3 + " " + this.f146r + " " + this.f147s + " " + this.f148t + " " + this.f149u);
    }

    private void m870f() {
        for (View removeView : this.f150v) {
            removeView(removeView);
        }
    }

    protected void onConfigurationChanged(Configuration newConfig) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(newConfig);
        }
    }

    private void m871g() {
        try {
            if (VERSION.SDK_INT >= 16) {
                setBackground(this.f153y);
            } else {
                setBackgroundDrawable(this.f153y);
            }
        } catch (Exception e) {
        }
    }

    public void setAdListener(BannerAdListener adListener) {
        f128b = adListener;
    }

    public BannerAdListener getAdListener() {
        return f128b;
    }

    String getBanner_type() {
        return this.f152x;
    }

    boolean m875a() {
        return this.f139k;
    }

    int getAdRefreshTime() {
        return this.f140l;
    }

    String getPlacementType() {
        return this.f141m;
    }

    int getadWidth() {
        return this.f146r;
    }

    int getadHeight() {
        return this.f147s;
    }

    private void m849a(int i, String str) {
        if (str != null && !str.equals("")) {
            switch (i) {
                case LocationRequest.PRIORITY_HIGH_ACCURACY /*100*/:
                    if (f128b != null) {
                        f128b.onErrorListener(str);
                    } else {
                        Log.e(IM.TAG, str);
                    }
                case 120:
                    if (f128b != null) {
                        f128b.onErrorListener(str);
                    } else {
                        Log.e(IM.TAG, str);
                    }
                case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                    if (f128b != null) {
                        f128b.onErrorListener(str);
                    } else {
                        Log.e(IM.TAG, str);
                    }
                case 204:
                    if (f128b != null) {
                        f128b.noAdAvailableListener();
                    }
                default:
            }
        }
    }
}
