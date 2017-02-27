package com.sxnyodot.uefqvmio207964;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;
import com.sxnyodot.uefqvmio207964.AdListener.BannerAdListener;
import com.sxnyodot.uefqvmio207964.AdView.C0249a;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

final class AbstractAdView extends FrameLayout {
    static final int BACKGROUND_COLOR_DEFAULT = 0;
    static final int BANNER_HEIGHT_ABSTRACT_LARGE = 300;
    static final int BANNER_HEIGHT_ABSTRACT_SMALL = 100;
    static final int BANNER_HEIGHT_MOBILE = 50;
    static final int BANNER_HEIGHT_TABLET = 90;
    static final int BANNER_MEDIUM_RECTANGLE_HEIGHT = 250;
    static final int BANNER_MEDIUM_RECTANGLE_WIDTH = 300;
    static final int BANNER_WIDTH_ABSTARCT_SMALL = 100;
    static final int BANNER_WIDTH_ABSTRACT_LARGE = 100;
    static final int BANNER_WIDTH_MOBILE = 320;
    static final int BANNER_WIDTH_TABLET = 728;
    static final int REFRESH_AD = 45;
    static final int TEXT_COLOR_DEFAULT = -1;
    static BannerAdListener f59b;
    private static boolean f60x;
    private static JSONObject f61z;
    boolean f62a;
    long f63c;
    boolean f64d;
    protected String f65e;
    C0249a f66f;
    Handler f67g;
    private final Activity f68h;
    private boolean f69i;
    private boolean f70j;
    private int f71k;
    private String f72l;
    private boolean f73m;
    private Timer f74n;
    private Thread f75o;
    private C0555c f76p;
    private int f77q;
    private int f78r;
    private int f79s;
    private int f80t;
    private List<View> f81u;
    private final String f82v;
    private Drawable f83w;
    private AbstractWebView f84y;

    /* renamed from: com.sxnyodot.uefqvmio207964.AbstractAdView.2 */
    class C02242 extends Handler {
        final /* synthetic */ AbstractAdView f49a;

        C02242(AbstractAdView abstractAdView) {
            this.f49a = abstractAdView;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case AbstractAdView.BACKGROUND_COLOR_DEFAULT /*0*/:
                    this.f49a.setVisibility(AbstractAdView.BACKGROUND_COLOR_DEFAULT);
                case DetectedActivity.ON_FOOT /*2*/:
                    this.f49a.m810d();
                case DetectedActivity.UNKNOWN /*4*/:
                    this.f49a.setVisibility(4);
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    this.f49a.setVisibility(8);
                default:
            }
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AbstractAdView.3 */
    class C02253 implements Runnable {
        final /* synthetic */ AbstractAdView f50a;

        C02253(AbstractAdView abstractAdView) {
            this.f50a = abstractAdView;
        }

        public void run() {
            AbstractAdView.f59b.onErrorListener("SDK is diabled please enable to received ad.");
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AbstractAdView.5 */
    class C02285 implements Runnable {
        final /* synthetic */ AbstractAdView f55a;

        C02285(AbstractAdView abstractAdView) {
            this.f55a = abstractAdView;
        }

        public void run() {
            if (AbstractAdView.f59b != null) {
                AbstractAdView.f59b.onErrorListener("Ad request failed. Internet connection not found.");
            }
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AbstractAdView.6 */
    class C02296 implements Runnable {
        final /* synthetic */ AbstractAdView f56a;

        C02296(AbstractAdView abstractAdView) {
            this.f56a = abstractAdView;
        }

        public void run() {
            this.f56a.m807c();
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AbstractAdView.7 */
    class C02307 extends TimerTask {
        final /* synthetic */ AbstractAdView f57a;

        C02307(AbstractAdView abstractAdView) {
            this.f57a = abstractAdView;
        }

        public void run() {
            Util.m929a("Getting new ad....");
            this.f57a.getAd();
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AbstractAdView.8 */
    class C02318 extends TimerTask {
        final /* synthetic */ AbstractAdView f58a;

        C02318(AbstractAdView abstractAdView) {
            this.f58a = abstractAdView;
        }

        public void run() {
            Util.m929a("Getting new ad....");
            this.f58a.getAd();
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AbstractAdView.1 */
    class C05421 implements C0249a {
        final /* synthetic */ AbstractAdView f511a;

        C05421(AbstractAdView abstractAdView) {
            this.f511a = abstractAdView;
        }

        public void m1596a() {
            this.f511a.f67g.sendEmptyMessage(2);
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AbstractAdView.4 */
    class C05434 implements C0293b<String> {
        final /* synthetic */ AbstractAdView f512a;

        /* renamed from: com.sxnyodot.uefqvmio207964.AbstractAdView.4.1 */
        class C02261 implements Runnable {
            final /* synthetic */ int f51a;
            final /* synthetic */ String f52b;
            final /* synthetic */ C05434 f53c;

            C02261(C05434 c05434, int i, String str) {
                this.f53c = c05434;
                this.f51a = i;
                this.f52b = str;
            }

            public void run() {
                AbstractAdView.m801a(this.f51a, this.f52b);
            }
        }

        /* renamed from: com.sxnyodot.uefqvmio207964.AbstractAdView.4.2 */
        class C02272 implements Runnable {
            final /* synthetic */ C05434 f54a;

            C02272(C05434 c05434) {
                this.f54a = c05434;
            }

            public void run() {
                if (AbstractAdView.f59b != null) {
                    AbstractAdView.f59b.onErrorListener("Error occurred while retriving ad.");
                }
            }
        }

        C05434(AbstractAdView abstractAdView) {
            this.f512a = abstractAdView;
        }

        public void m1597a() {
            this.f512a.f73m = true;
            List arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("banner_type", this.f512a.f82v));
            arrayList.add(new BasicNameValuePair("supports", "" + Util.m985s(this.f512a.getContext())));
            if (this.f512a.f70j) {
                arrayList.add(new BasicNameValuePair("sdk_test", "1"));
            }
            arrayList.add(new BasicNameValuePair("placement_id", "" + this.f512a.f76p.m1699A()));
            try {
                this.f512a.f75o = new Thread(new C0305m(this.f512a.f68h, this, arrayList, C0301h.URL_IN_APP_AD_API, 0, true), "banner360");
                this.f512a.f75o.setPriority(10);
                this.f512a.f75o.start();
            } catch (Throwable e) {
                Log.e(C0301h.TAG, C0304k.ERROR, e);
            }
        }

        public void m1599a(String str) {
            try {
                Log.i(C0301h.TAG, "B360 json:" + str);
                this.f512a.f63c = System.currentTimeMillis();
                if (str == null || str.equals("")) {
                    this.f512a.post(new C02272(this));
                } else {
                    JSONObject jSONObject = new JSONObject(str);
                    String string = jSONObject.isNull("banner_type") ? "" : jSONObject.getString("banner_type");
                    if (string == null || string.equals("")) {
                        Log.i(C0301h.TAG, "No banner type present in response.");
                        int i = jSONObject.isNull("status") ? AbstractAdView.BACKGROUND_COLOR_DEFAULT : jSONObject.getInt("status");
                        if (jSONObject.isNull(C0301h.TYPE_MESSAGE)) {
                            string = "";
                        } else {
                            string = jSONObject.getString(C0301h.TYPE_MESSAGE);
                        }
                        this.f512a.post(new C02261(this, i, string));
                        return;
                    } else if (string.equals("ABL") || string.equals("ABS") || string.equals("VB") || string.equals("image") || string.equals("VB") || string.equals("text")) {
                        this.f512a.m818a(jSONObject);
                    } else {
                        Log.i(C0301h.TAG, "Invalid banner type in 360 json: " + string);
                    }
                }
                this.f512a.f73m = false;
            } catch (Throwable e) {
                Log.w(C0301h.TAG, "error occurred while parsing banner", e);
            } finally {
                this.f512a.f73m = false;
            }
        }
    }

    public AbstractAdView(Activity activity, C0555c banner360) {
        super(activity);
        this.f62a = false;
        this.f69i = false;
        this.f70j = false;
        this.f71k = REFRESH_AD;
        this.f73m = false;
        this.f63c = 0;
        this.f64d = true;
        this.f77q = BANNER_WIDTH_MOBILE;
        this.f78r = BANNER_HEIGHT_MOBILE;
        this.f81u = new ArrayList();
        this.f65e = IM.ANIMATION_TYPE_FADE;
        this.f66f = new C05421(this);
        this.f67g = new C02242(this);
        this.f68h = activity;
        this.f76p = banner360;
        this.f70j = C0555c.m1698z();
        this.f82v = banner360.m1735y();
        f59b = C0555c.m1697x();
        this.f71k = REFRESH_AD;
        setVisibility(8);
        this.f83w = getBackground();
        setClickable(true);
        setFocusable(true);
        setDescendantFocusability(AccessibilityNodeInfoCompat.ACTION_SET_SELECTION);
        if (this.f75o == null || !this.f75o.isAlive()) {
            getAd();
        }
    }

    private void m807c() {
        try {
            m812e();
            if (this.f76p == null) {
                removeAllViews();
                Log.i(C0301h.TAG, "Ad not loaded. Banner data is null.");
                setVisibility(8);
            } else if (this.f76p.m1714c().length() == 0 && this.f76p.m1717f().length() == 0) {
                Log.w(C0301h.TAG, "Tag data is null");
            } else {
                Log.i(C0301h.TAG, "Loading banner ad");
                this.f84y = new AbstractWebView(getContext(), this.f79s, this.f80t, this.f67g, this.f76p, this.f70j, this);
                m814f();
                Animation a = m816a(false);
                if (a != null) {
                    this.f84y.startAnimation(a);
                }
                addView(this.f84y);
                if (f59b != null) {
                    f59b.onAdLoadingListener();
                }
                Log.i(C0301h.TAG, "Ad loaded successfully");
            }
        } catch (Throwable e) {
            Log.w(C0301h.TAG, "Error occurred while loading banner ad", e);
        }
    }

    public static void setJsonObject(JSONObject jsonObject) {
        f61z = jsonObject;
    }

    synchronized void getAd() {
        if (f61z != null) {
            this.f63c = System.currentTimeMillis();
            m818a(f61z);
        } else if (!this.f64d || this.f62a) {
            Util.m929a("Ad request is disabled.");
        } else if (C0558p.isSDKEnabled(getContext())) {
            if (this.f73m) {
                Log.i(C0301h.TAG, "Ad request is already in progress.");
            } else if ((System.currentTimeMillis() - this.f63c) / 1000 < ((long) this.f71k)) {
                Log.i(C0301h.TAG, "Ad requested beforing refresh time. Aborting request... ");
            } else {
                synchronized (this) {
                    C0293b c05434 = new C05434(this);
                    if (Util.m977o(getContext())) {
                        c05434.m1004a();
                    } else {
                        post(new C02285(this));
                    }
                }
            }
        } else if (f59b != null) {
            post(new C02253(this));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m818a(org.json.JSONObject r6) {
        /*
        r5 = this;
        r4 = 0;
        r0 = r5.f76p;	 Catch:{ JSONException -> 0x0038, Exception -> 0x0058 }
        r0 = r0.m1710a(r6);	 Catch:{ JSONException -> 0x0038, Exception -> 0x0058 }
        if (r0 == 0) goto L_0x0035;
    L_0x0009:
        r0 = r5.f76p;	 Catch:{ JSONException -> 0x0038, Exception -> 0x0058 }
        r0 = r0.m1723l();	 Catch:{ JSONException -> 0x0038, Exception -> 0x0058 }
        r1 = r5.f76p;	 Catch:{ JSONException -> 0x0038, Exception -> 0x0058 }
        r1 = r1.m1724m();	 Catch:{ JSONException -> 0x0038, Exception -> 0x0058 }
        r5.m800a(r0, r1);	 Catch:{ JSONException -> 0x0038, Exception -> 0x0058 }
        r0 = r5.f67g;	 Catch:{ JSONException -> 0x0038, Exception -> 0x0058 }
        r1 = new com.sxnyodot.uefqvmio207964.AbstractAdView$6;	 Catch:{ JSONException -> 0x0038, Exception -> 0x0058 }
        r1.<init>(r5);	 Catch:{ JSONException -> 0x0038, Exception -> 0x0058 }
        r0.post(r1);	 Catch:{ JSONException -> 0x0038, Exception -> 0x0058 }
        r0 = r5.f76p;	 Catch:{ JSONException -> 0x0038, Exception -> 0x0058 }
        r0 = r0.m1718g();	 Catch:{ JSONException -> 0x0038, Exception -> 0x0058 }
        if (r0 <= 0) goto L_0x0035;
    L_0x002a:
        r1 = r5.f71k;	 Catch:{ JSONException -> 0x0038, Exception -> 0x0058 }
        if (r1 == r0) goto L_0x0035;
    L_0x002e:
        r5.f71k = r0;	 Catch:{ JSONException -> 0x0038, Exception -> 0x0058 }
        r0 = 1;
        r1 = 1;
        r5.m803a(r0, r1);	 Catch:{ JSONException -> 0x0038, Exception -> 0x0058 }
    L_0x0035:
        f61z = r4;
    L_0x0037:
        return;
    L_0x0038:
        r0 = move-exception;
        r1 = "PrmSDK";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005f }
        r2.<init>();	 Catch:{ all -> 0x005f }
        r3 = "JSONExection occured while parsing Banner ad json: ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x005f }
        r0 = r0.getMessage();	 Catch:{ all -> 0x005f }
        r0 = r2.append(r0);	 Catch:{ all -> 0x005f }
        r0 = r0.toString();	 Catch:{ all -> 0x005f }
        android.util.Log.e(r1, r0);	 Catch:{ all -> 0x005f }
        f61z = r4;
        goto L_0x0037;
    L_0x0058:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x005f }
        f61z = r4;
        goto L_0x0037;
    L_0x005f:
        r0 = move-exception;
        f61z = r4;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sxnyodot.uefqvmio207964.AbstractAdView.a(org.json.JSONObject):void");
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
        f60x = hasWindowFocus;
        m803a(hasWindowFocus, false);
        super.onWindowFocusChanged(hasWindowFocus);
        getParent();
    }

    protected void onAttachedToWindow() {
        f60x = true;
        m803a(true, false);
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        f60x = false;
        m803a(false, false);
        super.onDetachedFromWindow();
        if (this.f84y != null) {
            removeView(this.f84y);
            this.f84y.removeAllViews();
            this.f84y.destroy();
            Util.m929a("Ad destroyed");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m803a(boolean r9, boolean r10) {
        /*
        r8 = this;
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        monitor-enter(r8);
        r0 = r8.f69i;	 Catch:{ Exception -> 0x0076 }
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
        r0 = r8.f74n;	 Catch:{ Exception -> 0x0076 }
        if (r0 != 0) goto L_0x002a;
    L_0x0011:
        r0 = new java.util.Timer;	 Catch:{ Exception -> 0x0076 }
        r0.<init>();	 Catch:{ Exception -> 0x0076 }
        r8.f74n = r0;	 Catch:{ Exception -> 0x0076 }
        r1 = new com.sxnyodot.uefqvmio207964.AbstractAdView$7;	 Catch:{ Exception -> 0x0076 }
        r1.<init>(r8);	 Catch:{ Exception -> 0x0076 }
        r0 = r8.f74n;	 Catch:{ Exception -> 0x0076 }
        r2 = r8.f71k;	 Catch:{ Exception -> 0x0076 }
        r2 = (long) r2;	 Catch:{ Exception -> 0x0076 }
        r2 = r2 * r6;
        r4 = r8.f71k;	 Catch:{ Exception -> 0x0076 }
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
        r0 = r8.f74n;	 Catch:{ Exception -> 0x0076 }
        if (r0 == 0) goto L_0x002a;
    L_0x0037:
        r0 = r8.f74n;	 Catch:{ Exception -> 0x0076 }
        r0.cancel();	 Catch:{ Exception -> 0x0076 }
        r0 = 0;
        r8.f74n = r0;	 Catch:{ Exception -> 0x0076 }
        r0 = 1;
        r8.f64d = r0;	 Catch:{ Exception -> 0x0076 }
        r0 = new java.util.Timer;	 Catch:{ Exception -> 0x0076 }
        r0.<init>();	 Catch:{ Exception -> 0x0076 }
        r8.f74n = r0;	 Catch:{ Exception -> 0x0076 }
        r1 = new com.sxnyodot.uefqvmio207964.AbstractAdView$8;	 Catch:{ Exception -> 0x0076 }
        r1.<init>(r8);	 Catch:{ Exception -> 0x0076 }
        r0 = r8.f74n;	 Catch:{ Exception -> 0x0076 }
        r2 = r8.f71k;	 Catch:{ Exception -> 0x0076 }
        r2 = (long) r2;	 Catch:{ Exception -> 0x0076 }
        r2 = r2 * r6;
        r4 = r8.f71k;	 Catch:{ Exception -> 0x0076 }
        r4 = (long) r4;	 Catch:{ Exception -> 0x0076 }
        r4 = r4 * r6;
        r0.scheduleAtFixedRate(r1, r2, r4);	 Catch:{ Exception -> 0x0076 }
        r0 = "PrmSDK";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0076 }
        r1.<init>();	 Catch:{ Exception -> 0x0076 }
        r2 = "Refresh time changed.> ";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0076 }
        r2 = r8.f71k;	 Catch:{ Exception -> 0x0076 }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x0076 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0076 }
        android.util.Log.i(r0, r1);	 Catch:{ Exception -> 0x0076 }
        goto L_0x002a;
    L_0x0076:
        r0 = move-exception;
        r1 = "PrmSDK";
        r2 = "Error in refresh timer";
        android.util.Log.e(r1, r2, r0);	 Catch:{ all -> 0x002c }
        goto L_0x002a;
    L_0x007f:
        r0 = r8.f74n;	 Catch:{ Exception -> 0x0076 }
        if (r0 == 0) goto L_0x00a6;
    L_0x0083:
        r0 = r8.f74n;	 Catch:{ Exception -> 0x0076 }
        r0.cancel();	 Catch:{ Exception -> 0x0076 }
        r0 = 0;
        r8.f74n = r0;	 Catch:{ Exception -> 0x0076 }
        r0 = "PrmSDK";
        r1 = "Lost foucus. Removing thread>>>";
        android.util.Log.i(r0, r1);	 Catch:{ Exception -> 0x0076 }
        r0 = 1;
        r8.f64d = r0;	 Catch:{ Exception -> 0x0076 }
        r0 = r8.f75o;	 Catch:{ Exception -> 0x0076 }
        if (r0 == 0) goto L_0x00a6;
    L_0x0099:
        r0 = r8.f75o;	 Catch:{ Exception -> 0x0076 }
        r0 = r0.isAlive();	 Catch:{ Exception -> 0x0076 }
        if (r0 == 0) goto L_0x00a6;
    L_0x00a1:
        r0 = r8.f75o;	 Catch:{ Exception -> 0x0076 }
        r0.interrupt();	 Catch:{ Exception -> 0x0076 }
    L_0x00a6:
        r8.destroyDrawingCache();	 Catch:{ Exception -> 0x0076 }
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sxnyodot.uefqvmio207964.AbstractAdView.a(boolean, boolean):void");
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.f76p.m1711b().equals("ABL") || this.f76p.m1711b().equals("ABS")) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(this.f77q, 1073741824), MeasureSpec.makeMeasureSpec(this.f78r, 1073741824));
        setMeasuredDimension(this.f77q, this.f78r);
    }

    private void m800a(int i, int i2) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        float f = displayMetrics.density;
        if (i < BANNER_WIDTH_MOBILE) {
            i = BANNER_WIDTH_MOBILE;
        }
        if (i2 < BANNER_HEIGHT_MOBILE) {
            i2 = BANNER_HEIGHT_MOBILE;
        }
        this.f78r = (int) ((((float) i2) * f) + 0.5f);
        this.f80t = i2;
        this.f77q = (int) ((((float) i) * f) + 0.5f);
        this.f79s = i;
        int i3 = this.f78r;
        int i4 = this.f77q;
        if (displayMetrics.heightPixels < this.f78r) {
            i3 = displayMetrics.heightPixels;
        }
        if (displayMetrics.widthPixels < this.f77q) {
            i4 = displayMetrics.widthPixels;
        }
        float f2 = ((float) this.f78r) / ((float) i3);
        float f3 = ((float) this.f77q) / ((float) i4);
        if (f2 > f3) {
            this.f77q = (int) (((float) this.f77q) / f2);
            this.f78r = i3;
            this.f79s = (int) (((float) this.f77q) / f);
            this.f80t = (int) (((float) i3) / f);
            Util.m929a("if: " + f2 + " " + f3 + " " + this.f77q + " " + this.f78r + " " + this.f79s + " " + this.f80t);
            return;
        }
        this.f77q = i4;
        this.f78r = (int) (((float) this.f78r) / f3);
        this.f79s = (int) (((float) i4) / f);
        this.f80t = (int) (((float) this.f78r) / f);
        Util.m929a("else: " + f2 + " " + f3 + " " + this.f77q + " " + this.f78r + " " + this.f79s + " " + this.f80t);
    }

    private void m810d() {
        for (View removeView : this.f81u) {
            removeView(removeView);
        }
    }

    protected void onConfigurationChanged(Configuration newConfig) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(newConfig);
        }
    }

    private void m812e() {
        try {
            if (VERSION.SDK_INT >= 16) {
                setBackground(this.f83w);
            } else {
                setBackgroundDrawable(this.f83w);
            }
        } catch (Exception e) {
        }
    }

    static void setAdListener(BannerAdListener adListener) {
        f59b = adListener;
    }

    BannerAdListener getAdListener() {
        return f59b;
    }

    String getBanner_type() {
        return this.f82v;
    }

    boolean m819a() {
        return this.f70j;
    }

    int getAdRefreshTime() {
        return this.f71k;
    }

    String getPlacementType() {
        return this.f72l;
    }

    int getadWidth() {
        return this.f77q;
    }

    int getadHeight() {
        return this.f78r;
    }

    static void m801a(int i, String str) {
        if (str != null && !str.equals("")) {
            BannerAdListener x = C0555c.m1697x();
            switch (i) {
                case BANNER_WIDTH_ABSTRACT_LARGE /*100*/:
                    if (x != null) {
                        x.onErrorListener(str);
                    } else {
                        Log.e(C0301h.TAG, str);
                    }
                case 120:
                    if (x != null) {
                        x.onErrorListener(str);
                    } else {
                        Log.e(C0301h.TAG, str);
                    }
                case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                    if (x != null) {
                        x.onErrorListener(str);
                    } else {
                        Log.e(C0301h.TAG, str);
                    }
                case 204:
                    if (x != null) {
                        x.noAdAvailableListener();
                    }
                default:
                    if (x != null) {
                        x.noAdAvailableListener();
                    }
            }
        }
    }

    void m817a(View view) {
        if (view != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                    this.f67g.sendEmptyMessage(8);
                    int i = this.f76p.m1720i();
                    if (i > 0) {
                        this.f71k = i;
                        Util.m929a("Changing click time: " + i);
                        m803a(true, true);
                    }
                }
                if (f59b != null) {
                    f59b.onAdClickListener();
                }
            } catch (Exception e) {
                Log.e(C0301h.TAG, "Error in stopping Abstract Ad");
            }
        }
    }

    protected void m820b(View view) {
        if (view != null) {
            try {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                    this.f67g.sendEmptyMessage(8);
                    int h = this.f76p.m1719h();
                    if (h > 0) {
                        this.f71k = h;
                        Util.m929a("Changing close time: " + h);
                        m803a(true, true);
                    }
                }
                if (f59b != null) {
                    f59b.onCloseListener();
                }
            } catch (Exception e) {
                Log.e(C0301h.TAG, "Error in stopping Abstract Ad");
            }
        }
    }

    public static int m798a(int i) {
        return (int) (((float) i) * Resources.getSystem().getDisplayMetrics().density);
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        try {
            if (event.getAction() == 0 && (this.f76p.m1711b().equals("ABL") || this.f76p.m1711b().equals("ABS"))) {
                int c = C0555c.m1695c(this.f68h);
                int rawY = (int) event.getRawY();
                int a = m798a(this.f80t);
                Util.m929a("Screen Height: " + c + " Clicked y: " + rawY + ", clickable height: " + a);
                Util.m929a("Clicked area: " + (c - rawY));
                if (c - rawY > a) {
                    return false;
                }
                Util.m929a("Clicked y: " + rawY + ", cl, " + a);
                return super.dispatchTouchEvent(event);
            }
        } catch (Exception e) {
        }
        return super.dispatchTouchEvent(event);
    }

    protected static boolean m806b() {
        return f60x;
    }

    private void m814f() {
        int childCount = getChildCount();
        if (childCount > 0) {
            Animation a = m816a(true);
            int i = BACKGROUND_COLOR_DEFAULT;
            while (i < childCount) {
                if (!(a == null || getChildAt(i) == null)) {
                    this.f81u.add(getChildAt(i));
                }
                i++;
            }
        }
    }

    protected Animation m816a(boolean z) {
        Animation alphaAnimation;
        if (z) {
            if (this.f65e == null || !this.f65e.equals(IM.ANIMATION_TYPE_FADE)) {
                return null;
            }
            alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(700);
            return alphaAnimation;
        } else if (this.f65e == null || !this.f65e.equals(IM.ANIMATION_TYPE_FADE)) {
            return null;
        } else {
            alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(1200);
            return alphaAnimation;
        }
    }
}
