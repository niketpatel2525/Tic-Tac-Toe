package com.sxnyodot.uefqvmio207964;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.util.Base64;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.sxnyodot.uefqvmio207964.AdListener.BannerAdListener;
import java.net.URLEncoder;

final class AbstractWebView extends WebView {
    static final String close_icon = "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";
    private static boolean f98l;
    Object f99a;
    Runnable f100b;
    private final String f101c;
    private final int f102d;
    private final int f103e;
    private final int f104f;
    private final Handler f105g;
    private C0555c f106h;
    private boolean f107i;
    private AbstractAdView f108j;
    private boolean f109k;
    private final int f110m;
    private BannerAdListener f111n;

    /* renamed from: com.sxnyodot.uefqvmio207964.AbstractWebView.1 */
    class C02331 extends WebViewClient {
        final /* synthetic */ Handler f87a;
        final /* synthetic */ AbstractWebView f88b;

        C02331(AbstractWebView abstractWebView, Handler handler) {
            this.f88b = abstractWebView;
            this.f87a = handler;
        }

        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Util.m929a("CLicked: " + url);
            if (!this.f88b.f109k || url.equals(this.f88b.f106h.m1714c())) {
                view.loadUrl(url);
            } else {
                this.f88b.m822a(0, url);
            }
            return true;
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            AbstractWebView.m830b(89, this.f88b.getContext(), this.f88b.f106h);
            if (this.f87a != null) {
                this.f87a.sendEmptyMessage(8);
                Util.m929a("Error in ad loading.");
            }
            if (this.f88b.f111n != null) {
                this.f88b.f111n.onErrorListener(description);
            }
        }

        public void onPageFinished(WebView view, String url) {
            if (this.f87a != null) {
                this.f87a.sendEmptyMessage(0);
            }
            this.f88b.m829b();
            Util.m929a("Ad loading complete");
            if (this.f88b.f111n != null) {
                this.f88b.f111n.onAdLoadedListener();
            }
            this.f88b.f105g.postDelayed(this.f88b.f100b, this.f88b.f106h.m1703E());
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AbstractWebView.2 */
    class C02342 implements Runnable {
        final /* synthetic */ AbstractWebView f89a;

        C02342(AbstractWebView abstractWebView) {
            this.f89a = abstractWebView;
        }

        public void run() {
            AbstractWebView.f98l = true;
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AbstractWebView.3 */
    class C02353 implements Runnable {
        final /* synthetic */ AbstractWebView f90a;

        C02353(AbstractWebView abstractWebView) {
            this.f90a = abstractWebView;
        }

        public void run() {
            this.f90a.f108j.m817a(this.f90a);
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AbstractWebView.4 */
    class C02364 implements Runnable {
        final /* synthetic */ AbstractWebView f91a;

        C02364(AbstractWebView abstractWebView) {
            this.f91a = abstractWebView;
        }

        public void run() {
            this.f91a.f108j.m817a(this.f91a);
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AbstractWebView.5 */
    class C02375 implements Runnable {
        final /* synthetic */ AbstractWebView f92a;

        C02375(AbstractWebView abstractWebView) {
            this.f92a = abstractWebView;
        }

        public void run() {
            this.f92a.f108j.m817a(this.f92a);
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AbstractWebView.6 */
    class C02386 implements OnClickListener {
        final /* synthetic */ int f93a;
        final /* synthetic */ String f94b;
        final /* synthetic */ AbstractWebView f95c;

        C02386(AbstractWebView abstractWebView, int i, String str) {
            this.f95c = abstractWebView;
            this.f93a = i;
            this.f94b = str;
        }

        public void onClick(View v) {
            this.f95c.m831b(this.f93a, this.f94b);
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AbstractWebView.8 */
    class C02398 implements OnClickListener {
        final /* synthetic */ AbstractWebView f96a;

        C02398(AbstractWebView abstractWebView) {
            this.f96a = abstractWebView;
        }

        public void onClick(View v) {
            this.f96a.m837d();
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AbstractWebView.9 */
    class C02409 implements Runnable {
        final /* synthetic */ AbstractWebView f97a;

        C02409(AbstractWebView abstractWebView) {
            this.f97a = abstractWebView;
        }

        public void run() {
            this.f97a.stopLoading();
            this.f97a.f108j.m820b(this.f97a);
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.AbstractWebView.7 */
    static class C05447 implements C0293b<String> {
        final /* synthetic */ C0555c f513a;
        final /* synthetic */ int f514b;
        final /* synthetic */ String f515c;

        C05447(C0555c c0555c, int i, String str) {
            this.f513a = c0555c;
            this.f514b = i;
            this.f515c = str;
        }

        public void m1602a(String str) {
            Log.i(C0301h.TAG, "Banner Data: " + str);
            this.f513a.m1712b(this.f514b);
        }

        public void m1600a() {
            new Thread(new C0317r(Util.m964k(), this.f515c, this), "absimp").start();
        }
    }

    static {
        f98l = false;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public AbstractWebView(Context context, int newWidth, int newHeight, Handler loadingListener, C0555c ad, boolean isTestMode, AbstractAdView adView) {
        super(context);
        this.f101c = IM.TAG;
        this.f102d = 0;
        this.f103e = 1;
        this.f104f = 2;
        this.f99a = new Object() {
            final /* synthetic */ AbstractWebView f86a;

            /* renamed from: com.sxnyodot.uefqvmio207964.AbstractWebView.10.1 */
            class C02321 implements Runnable {
                final /* synthetic */ AnonymousClass10 f85a;

                C02321(AnonymousClass10 anonymousClass10) {
                    this.f85a = anonymousClass10;
                }

                public void run() {
                    this.f85a.f86a.m842a();
                }
            }

            {
                this.f86a = r1;
            }

            @JavascriptInterface
            public void close() {
                this.f86a.m837d();
            }

            @JavascriptInterface
            public void closeAd() {
                this.f86a.m837d();
            }

            @JavascriptInterface
            public void open(String url) {
                this.f86a.m822a(0, url);
            }

            @JavascriptInterface
            public void sendSms(String number, String message) {
                this.f86a.m822a(1, null);
            }

            @JavascriptInterface
            public void showDialer(String number) {
                this.f86a.m822a(2, null);
            }

            @JavascriptInterface
            public void addCloseButton() {
                this.f86a.post(new C02321(this));
            }
        };
        this.f100b = new C02342(this);
        f98l = false;
        this.f110m = newHeight;
        this.f105g = loadingListener;
        try {
            this.f107i = isTestMode;
            this.f108j = adView;
            this.f106h = ad;
            this.f111n = C0555c.m1697x();
            setVerticalScrollBarEnabled(false);
            setHorizontalScrollBarEnabled(false);
            addJavascriptInterface(this.f99a, "mraid");
            setScrollBarStyle(33554432);
            WebSettings settings = getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setLoadWithOverviewMode(true);
            settings.setLoadsImagesAutomatically(true);
            settings.setUseWideViewPort(false);
            settings.setJavaScriptCanOpenWindowsAutomatically(false);
            settings.setCacheMode(2);
            m843a(settings);
            setBackgroundColor(0);
            setWebViewClient(new C02331(this, loadingListener));
            LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f108j.getadWidth(), this.f108j.getadHeight());
            if (this.f106h.m1711b().equals("ABL") || this.f106h.m1711b().equals("ABS")) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            setLayoutParams(layoutParams);
            if (this.f106h.m1714c() == null || this.f106h.m1714c().length() <= 0) {
                StringBuilder stringBuilder;
                if (this.f106h.m1711b().equals("text")) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("<html><head><style>* {margin:0;}</style></head><body>");
                    stringBuilder.append("<div style='background-color: " + this.f106h.m1732u() + "; width: " + newWidth + "; height: " + newHeight + ";'><table><tr>");
                    stringBuilder.append("<td rowspan='2' align='center'><img alt='icon' style='padding: 2' src='" + this.f106h.m1728q() + "'></td>");
                    stringBuilder.append("<td><font color='" + this.f106h.m1731t() + "'><b>" + this.f106h.m1730s() + "</b><br></font>");
                    stringBuilder.append("</td><tr><td><font size=2 color='" + this.f106h.m1731t() + "'>" + this.f106h.m1729r() + "</font></td></tr>");
                    stringBuilder.append("</table></div>");
                    stringBuilder.append("</body></html>");
                    loadDataWithBaseURL(null, stringBuilder.toString(), "text/html", "UTF-8", null);
                } else if (this.f106h.m1711b().equals("image")) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("<html><head><style>* {margin:0;padding:0;}</style></head><body>").append("<img src=\"" + this.f106h.m1728q() + "\" height=\"" + newHeight + "\" width=\"" + newWidth + "\"/>");
                    stringBuilder.append("</body></html>");
                    loadDataWithBaseURL(null, stringBuilder.toString(), "text/html", "UTF-8", null);
                } else {
                    loadUrl(this.f106h.m1717f());
                }
            } else if (this.f106h.m1711b().equals("image") && this.f106h.m1715d() == 4) {
                loadUrl(this.f106h.m1714c());
            } else {
                loadDataWithBaseURL(null, this.f106h.m1714c(), "text/html", "UTF-8", null);
            }
        } catch (Throwable e) {
            Log.w(IM.TAG, "Error occurred while laoding banner: ", e);
            m830b(89, getContext(), this.f106h);
        }
    }

    protected void onAnimationEnd() {
        super.onAnimationEnd();
        this.f108j.f66f.m844a();
    }

    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        m824a(data);
        super.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
    }

    private void m824a(String str) {
    }

    private synchronized void m833b(String str) {
        this.f109k = false;
        if (str != null) {
            try {
                if (!str.equals("")) {
                    Log.i(IM.TAG, "Redirecting>> ");
                    if (this.f107i) {
                        Util.m929a("360 Ad in test mode.");
                        C0299f.m1015a(getContext(), str);
                        this.f105g.post(new C02353(this));
                    } else if (this.f106h.m1702D()) {
                        Util.m929a("Redirect url: " + str);
                        C0299f.m1015a(getContext(), str);
                        m835c();
                    } else {
                        int i;
                        String encode = URLEncoder.encode(str, "UTF-8");
                        if (this.f106h.m1711b().equals("ABL")) {
                            i = 29;
                        } else if (this.f106h.m1711b().equals("ABS")) {
                            i = 26;
                        } else if (this.f106h.m1711b().equals("VB")) {
                            i = 56;
                        } else {
                            i = 13;
                        }
                        String a = this.f106h.m1705a(i);
                        String str2 = a + "&rurl=" + encode;
                        if (!(a == null || a.length() == 0)) {
                            str = str2;
                        }
                        Util.m929a("Redirect url: " + str);
                        C0299f.m1015a(getContext(), str);
                        this.f106h.m1712b(i);
                        this.f105g.post(new C02364(this));
                        if (this.f106h.m1701C() != null && this.f106h.m1701C().length > 0) {
                            new Thread(new C0317r(Util.m964k(), this.f106h.m1701C()), "cl").start();
                            this.f106h.m1713b(null);
                        }
                    }
                }
            } catch (Throwable e) {
                Log.w(IM.TAG, "Not able to redirect: ", e);
                m830b(89, getContext(), this.f106h);
            }
        }
        Log.e(IM.TAG, "Redirect url is null: ");
    }

    private void m825a(String str, String str2) {
        try {
            C0299f.m1016a(getContext(), str2, str);
            m835c();
        } catch (Throwable e) {
            Log.w(IM.TAG, e);
            m830b(89, getContext(), this.f106h);
        }
    }

    private void m836c(String str) {
        try {
            C0299f.m1017b(getContext(), str);
            m835c();
        } catch (Throwable e) {
            Log.w(IM.TAG, e);
            m830b(89, getContext(), this.f106h);
        }
    }

    private synchronized void m829b() {
        try {
            if (this.f106h.m1711b().equals("ABL")) {
                m830b(37, getContext(), this.f106h);
            } else if (this.f106h.m1711b().equals("ABS")) {
                m830b(35, getContext(), this.f106h);
            } else if (this.f106h.m1711b().equals("VB")) {
                m830b(36, getContext(), this.f106h);
            } else {
                m830b(14, getContext(), this.f106h);
            }
            if (this.f106h.m1700B() != null && this.f106h.m1700B().length > 0) {
                new Thread(new C0317r(Util.m964k(), this.f106h.m1700B()), "imp").start();
                this.f106h.m1709a(null);
            }
        } catch (Throwable e) {
            Log.w(IM.TAG, "Error while sending imp", e);
        }
    }

    private synchronized void m835c() {
        try {
            int i;
            this.f105g.post(new C02375(this));
            if (this.f106h.m1711b().equals("ABL")) {
                i = 29;
            } else if (this.f106h.m1711b().equals("ABS")) {
                i = 26;
            } else if (this.f106h.m1711b().equals("VB")) {
                i = 56;
            } else {
                i = 13;
            }
            m830b(i, getContext(), this.f106h);
            if (this.f106h.m1701C() != null && this.f106h.m1701C().length > 0) {
                new Thread(new C0317r(Util.m964k(), this.f106h.m1701C()), "cl").start();
                this.f106h.m1713b(null);
            }
        } catch (Throwable e) {
            Log.w(IM.TAG, "Error while sending click", e);
        }
    }

    private void m822a(int i, String str) {
        if (this.f106h.m1704F() == 1) {
            float f = getResources().getDisplayMetrics().density;
            View button = new Button(getContext());
            LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (200.0f * f), (int) (f * 50.0f));
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = 0;
            button.setLayoutParams(layoutParams);
            button.setText("Visit");
            button.setTextColor(-1);
            button.setBackgroundColor(-16776961);
            button.setTextAppearance(getContext(), 16842817);
            button.setTypeface(null, 1);
            button.setOnClickListener(new C02386(this, i, str));
            this.f108j.addView(button);
            return;
        }
        m831b(i, str);
    }

    private void m831b(int i, String str) {
        switch (i) {
            case DetectedActivity.IN_VEHICLE /*0*/:
                m833b(str);
            case DetectedActivity.ON_BICYCLE /*1*/:
                m825a(this.f106h.m1734w(), this.f106h.m1733v());
            case DetectedActivity.ON_FOOT /*2*/:
                m836c(this.f106h.m1734w());
            default:
                m833b(str);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() != 0) {
            return super.dispatchTouchEvent(event);
        }
        if (!f98l) {
            Util.m929a("Click delay running");
            return true;
        } else if (this.f106h.m1714c() != null && this.f106h.m1714c().length() > 0) {
            this.f109k = true;
            return super.dispatchTouchEvent(event);
        } else if (this.f106h.m1717f() != null && this.f106h.m1717f().length() > 0 && (this.f106h.m1711b().equals("ABL") || this.f106h.m1711b().equals("ABS") || this.f106h.m1711b().equals("VB"))) {
            this.f109k = true;
            return super.dispatchTouchEvent(event);
        } else if (!this.f106h.m1725n().equals("BAU") && !this.f106h.m1725n().equals("BACC") && !this.f106h.m1725n().equals("BACM")) {
            return true;
        } else {
            try {
                String n = this.f106h.m1725n();
                if (n.equalsIgnoreCase("BAU")) {
                    Log.i(C0301h.TAG, "SB url Ads.....");
                    m822a(0, this.f106h.m1717f());
                    return true;
                } else if (n.equalsIgnoreCase("BACC")) {
                    Log.i(C0301h.TAG, "SB CC Ads.....");
                    m822a(2, null);
                    return true;
                } else if (n.equalsIgnoreCase("BACM")) {
                    Log.i(C0301h.TAG, "SB CM Ads.....");
                    m822a(1, null);
                    return true;
                } else {
                    Log.w(IM.TAG, "Invalid ad type for banner ad." + n);
                    return super.dispatchTouchEvent(event);
                }
            } catch (Throwable e) {
                Log.w(IM.TAG, "Error occurred while handling click", e);
                m830b(89, getContext(), this.f106h);
                return true;
            }
        }
    }

    private static synchronized void m830b(int i, Context context, C0555c c0555c) {
        synchronized (AbstractWebView.class) {
            if (C0555c.m1698z()) {
                Util.m929a("Ad in test mode. Sending ignored.");
            } else {
                try {
                    if (Util.m977o(context)) {
                        if (c0555c.m1722k() || i != 89) {
                            Log.i(C0301h.TAG, "Sending banner event: ");
                            String a = c0555c.m1705a(i);
                            Util.m929a("event: " + i + " URL: " + a);
                            if (a == null || a.equals("")) {
                                Log.i(C0301h.TAG, "Event url null");
                            } else {
                                new C05447(c0555c, i, a).m1004a();
                            }
                        } else {
                            Util.m929a("Error reporting is off.");
                        }
                    }
                } catch (Throwable e) {
                    Log.w(C0301h.TAG, "Exception: Sending banner event failed:" + e.getMessage());
                    Util.m930a("Error in banner event", e);
                }
            }
        }
    }

    @SuppressLint({"InlinedApi"})
    void m843a(WebSettings webSettings) {
        try {
            if (VERSION.SDK_INT >= 8) {
                webSettings.setPluginState(PluginState.ON);
            }
        } catch (Throwable th) {
        }
    }

    @SuppressLint({"RtlHardcoded"})
    protected synchronized void m842a() {
        try {
            float f = getResources().getDisplayMetrics().density;
            int i = (int) (BitmapDescriptorFactory.HUE_ORANGE * f);
            View imageView = new ImageView(getContext());
            LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
            i = 5;
            if (VERSION.SDK_INT > 14) {
                i = GravityCompat.END;
            }
            if (this.f106h.m1711b().equals("ABL") || this.f106h.m1711b().equals("ABS")) {
                layoutParams.bottomMargin = (int) (((float) this.f110m) - (2.0f * f));
                layoutParams.gravity = i | 80;
            } else {
                layoutParams.gravity = i | 48;
            }
            layoutParams.rightMargin = (int) (1.0f * f);
            imageView.setLayoutParams(layoutParams);
            byte[] decode = Base64.decode(close_icon, 0);
            imageView.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
            imageView.setOnClickListener(new C02398(this));
            this.f108j.addView(imageView);
        } catch (Throwable e) {
            Log.w("addClose", e);
        }
    }

    private void m837d() {
        this.f105g.post(new C02409(this));
        if (this.f106h.m1711b().equals("ABL")) {
            m830b(72, getContext(), this.f106h);
        } else if (this.f106h.m1711b().equals("ABS")) {
            m830b(66, getContext(), this.f106h);
        } else if (this.f106h.m1711b().equals("VB")) {
            m830b(57, getContext(), this.f106h);
        }
    }
}
