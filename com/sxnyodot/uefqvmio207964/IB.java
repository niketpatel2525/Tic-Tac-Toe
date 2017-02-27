package com.sxnyodot.uefqvmio207964;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout.LayoutParams;
import com.sxnyodot.uefqvmio207964.AdView.C0249a;
import com.sxnyodot.uefqvmio207964.JP.ParseBannerAd;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

final class IB extends WebView {
    private final String f207a;
    private ParseBannerAd f208b;
    private C0249a f209c;
    private boolean f210d;
    private AdView f211e;
    private boolean f212f;

    /* renamed from: com.sxnyodot.uefqvmio207964.IB.1 */
    class C02531 extends WebViewClient {
        final /* synthetic */ Handler f203a;
        final /* synthetic */ IB f204b;

        C02531(IB ib, Handler handler) {
            this.f204b = ib;
            this.f203a = handler;
        }

        public void onLoadResource(WebView view, String url) {
            if (!this.f204b.f212f || url.equals(this.f204b.f208b.getTag())) {
                super.onLoadResource(view, url);
                return;
            }
            this.f204b.m892b(url);
            this.f204b.stopLoading();
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (!this.f204b.f212f || url.equals(this.f204b.f208b.getTag())) {
                view.loadUrl(url);
            } else {
                this.f204b.m892b(url);
            }
            return true;
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            this.f204b.m893c(IM.MRAID_EVENT_ERROR);
            if (this.f203a != null) {
                this.f203a.sendEmptyMessage(8);
                Util.m929a("Error in ad loading.");
            }
            if (AdView.f128b != null) {
                AdView.f128b.onErrorListener(description);
            }
        }

        public void onPageFinished(WebView view, String url) {
            if (this.f203a != null) {
                this.f203a.sendEmptyMessage(0);
            }
            this.f204b.m893c("14");
            Util.m929a("Ad loading complete");
            if (AdView.f128b != null) {
                AdView.f128b.onAdLoadedListener();
            }
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.IB.2 */
    class C02542 implements Runnable {
        final /* synthetic */ String f205a;
        final /* synthetic */ IB f206b;

        C02542(IB ib, String str) {
            this.f206b = ib;
            this.f205a = str;
        }

        public void run() {
            try {
                if (this.f206b.f208b.m910n() || !this.f205a.equals(IM.MRAID_EVENT_ERROR)) {
                    Log.i(IM.TAG, "Sending banner event: ");
                    String eventUrl = this.f206b.f208b.getEventUrl(this.f205a);
                    Util.m929a("URL: " + eventUrl);
                    if (eventUrl == null || eventUrl.equals("")) {
                        Log.i(IM.TAG, "Event url null");
                        Thread.currentThread().interrupt();
                        return;
                    }
                    HttpClient defaultHttpClient = new DefaultHttpClient();
                    HttpUriRequest httpPost = new HttpPost(eventUrl);
                    HttpParams basicHttpParams = new BasicHttpParams();
                    httpPost.setParams(basicHttpParams);
                    HttpConnectionParams.setConnectionTimeout(basicHttpParams, 15000);
                    HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
                    HttpResponse execute = defaultHttpClient.execute(httpPost);
                    int statusCode = execute == null ? 0 : execute.getStatusLine().getStatusCode();
                    Log.i(IM.TAG, "Status code: " + statusCode);
                    if (statusCode == 200) {
                        Log.i(IM.TAG, "Banner Data: " + EntityUtils.toString(execute.getEntity()));
                        this.f206b.f208b.removeEventUrl(this.f205a);
                        return;
                    }
                    return;
                }
                Util.m929a("Error reporting is off.");
            } catch (Throwable e) {
                Log.w(IM.TAG, "Exception: Sending banner event failed:" + e.getMessage());
                Util.m930a("Error in banner event", e);
            }
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public IB(Context context, int newWidth, int newHeight, Handler loadingListener, ParseBannerAd ad, C0249a animationListener, boolean isTestMode, AdView adView) {
        super(context);
        this.f207a = IM.TAG;
        try {
            this.f210d = isTestMode;
            this.f209c = animationListener;
            this.f211e = adView;
            this.f208b = ad;
            setVerticalScrollBarEnabled(false);
            setHorizontalScrollBarEnabled(false);
            setScrollBarStyle(33554432);
            WebSettings settings = getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setLoadWithOverviewMode(true);
            settings.setLoadsImagesAutomatically(true);
            settings.setUseWideViewPort(false);
            m894a(settings);
            setBackgroundColor(0);
            setWebViewClient(new C02531(this, loadingListener));
            if (VERSION.SDK_INT >= 11) {
                try {
                    getClass().getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(this, new Object[]{Integer.valueOf(1), null});
                } catch (NoSuchMethodException e) {
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                } catch (InvocationTargetException e4) {
                    e4.printStackTrace();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            setLayoutParams(new LayoutParams(this.f211e.getadWidth(), this.f211e.getadHeight()));
            StringBuilder stringBuilder;
            if (this.f208b.m896a()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("<style>* {margin:0;padding:0; width: " + newWidth + "; height: " + newHeight + ";}</style>\n");
                stringBuilder.append(this.f208b.getTag());
                loadDataWithBaseURL(null, stringBuilder.toString(), "text/html", "UTF-8", null);
            } else if (this.f208b.m898b()) {
                if (this.f208b.getTag() == null || this.f208b.getTag().equals("")) {
                    Log.e(IM.TAG, "Url is null");
                } else {
                    loadUrl(this.f208b.getTag());
                }
            } else if (this.f208b.isJsAd()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("<html><head>\n");
                stringBuilder.append(this.f208b.getTag());
                stringBuilder.append("\n<style>* {margin:0;padding:0; width: " + newWidth + "; height: " + newHeight + ";}</style></head><body>");
                stringBuilder.append("</body></html>");
                loadDataWithBaseURL(null, stringBuilder.toString(), "text/html", "UTF-8", null);
            } else if (this.f208b.isHtmlAd()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("<html><head><style>* {margin:0;padding:0; width: " + newWidth + "; height: " + newHeight + ";}</style></head><body>\n").append(this.f208b.getTag()).append("\n</body></html>");
                loadDataWithBaseURL(null, stringBuilder.toString(), "text/html", "UTF-8", null);
            } else if (this.f208b.m902f().equals("text")) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("<html><head><style>* {margin:0;}</style></head><body>");
                stringBuilder.append("<div style='background-color: " + this.f208b.m907k() + "; width: " + newWidth + "; height: " + newHeight + ";'><table><tr>");
                stringBuilder.append("<td rowspan='2' align='center'><img alt='icon' style='padding: 2' src='" + this.f208b.getAdimage() + "'></td>");
                stringBuilder.append("<td><font color='" + this.f208b.m906j() + "'><b>" + this.f208b.m901e() + "</b><br></font>");
                stringBuilder.append("</td><tr><td><font size=2 color='" + this.f208b.m906j() + "'>" + this.f208b.m900d() + "</font></td></tr>");
                stringBuilder.append("</table></div>");
                if (!(this.f208b.getBeaconUrl() == null || this.f208b.getBeaconUrl().equals(""))) {
                    stringBuilder.append("<img src='" + this.f208b.getBeaconUrl() + "' height='1' width='1' />");
                }
                stringBuilder.append("</body></html>");
                loadDataWithBaseURL(null, stringBuilder.toString(), "text/html", "UTF-8", null);
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("<html><head><style>* {margin:0;padding:0;}</style></head><body>").append("<img src=\"" + this.f208b.getAdimage() + "\" height=\"" + newHeight + "\" width=\"" + newWidth + "\"/>");
                if (!(this.f208b.getBeaconUrl() == null || this.f208b.getBeaconUrl().equals(""))) {
                    stringBuilder.append("<img src='" + this.f208b.getBeaconUrl() + "' height='1' width='1' />");
                }
                stringBuilder.append("</body></html>");
                loadDataWithBaseURL(null, stringBuilder.toString(), "text/html", "UTF-8", null);
            }
        } catch (Throwable e6) {
            Log.w(IM.TAG, "Error occurred while laoding banner: ", e6);
            m893c(IM.MRAID_EVENT_ERROR);
        }
    }

    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        m888a(data);
        super.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
    }

    private void m888a(String str) {
    }

    private synchronized void m892b(String str) {
        this.f212f = false;
        if (str != null) {
            try {
                if (!str.equals("")) {
                    Log.i(IM.TAG, "Redirecting>> ");
                    if (this.f210d) {
                        Util.m929a("Ad in test mode.");
                        C0299f.m1015a(getContext(), str);
                    } else {
                        String encode = URLEncoder.encode(str, "UTF-8");
                        String eventUrl = this.f208b.getEventUrl("13");
                        encode = eventUrl + "&airpush_url=" + encode;
                        if (!(eventUrl == null || eventUrl.equals(""))) {
                            str = encode;
                        }
                        Util.m929a("Redirect url: " + str);
                        C0299f.m1015a(getContext(), str);
                    }
                    if (AdView.f128b != null) {
                        AdView.f128b.onAdClickListener();
                    }
                    this.f208b.removeEventUrl("13");
                    this.f211e.f132d = true;
                    this.f211e.f131c = 0;
                    this.f211e.getAd();
                }
            } catch (Throwable e) {
                Log.w(IM.TAG, "Not able to redirect: ", e);
                m893c(IM.MRAID_EVENT_ERROR);
            }
        }
        Log.e(IM.TAG, "Redirect url is null: ");
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() != 0) {
            return super.dispatchTouchEvent(event);
        }
        if (this.f208b.isJsAd() || this.f208b.isHtmlAd() || this.f208b.m896a() || this.f208b.m898b()) {
            this.f212f = true;
            return super.dispatchTouchEvent(event);
        }
        try {
            String g = this.f208b.m903g();
            if (g.equalsIgnoreCase("BAU")) {
                Log.i(C0301h.TAG, "Banner url Ads.....");
                m892b(this.f208b.m899c());
                return true;
            }
            if (g.equalsIgnoreCase("BACC")) {
                Log.i(C0301h.TAG, "Banner CC Ads.....");
                C0299f.m1017b(getContext(), this.f208b.m909m());
            } else if (g.equalsIgnoreCase("BACM")) {
                Log.i(C0301h.TAG, "Banner CM Ads.....");
                C0299f.m1016a(getContext(), this.f208b.m908l(), this.f208b.m909m());
            } else {
                Log.w(IM.TAG, "Invalid ad type for banner ad." + g);
                return super.dispatchTouchEvent(event);
            }
            m893c("13");
            if (AdView.f128b == null) {
                return true;
            }
            AdView.f128b.onAdClickListener();
            return true;
        } catch (Throwable e) {
            Log.w(IM.TAG, "Error occurred while handling click", e);
            m893c(IM.MRAID_EVENT_ERROR);
            return true;
        }
    }

    protected void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.f209c != null) {
            this.f209c.m844a();
        }
    }

    private synchronized void m893c(String str) {
        synchronized (str) {
            if (this.f210d) {
                Util.m929a("Ad in test mode. Sending ignored.");
            } else if (Util.m977o(getContext())) {
                new Thread(new C02542(this, str), "banner_event").start();
            }
        }
    }

    @SuppressLint({"InlinedApi"})
    void m894a(WebSettings webSettings) {
        try {
            if (VERSION.SDK_INT >= 8) {
                webSettings.setPluginState(PluginState.ON);
            }
        } catch (Throwable th) {
        }
    }
}
