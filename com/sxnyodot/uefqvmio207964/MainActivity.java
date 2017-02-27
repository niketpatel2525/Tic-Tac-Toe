package com.sxnyodot.uefqvmio207964;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.plus.PlusShare;
import com.sxnyodot.uefqvmio207964.AdListener.AdType;

public class MainActivity extends Activity {
    static final String INTENT_ACTION_APPWALL_AD = "appwallad";
    static final String INTENT_ACTION_LANDING_PAGE_AD = "lpad";
    static final String INTENT_ACTION_OVERLAY_AD = "overlayad";
    static final String INTENT_ACTION_RICH_MEDIA_FULL_PAGE_AD = "mfpad";
    private static String f297c;
    private static WebView f298d;
    private static boolean f299i;
    Dialog f300a;
    Handler f301b;
    private String f302e;
    private Intent f303f;
    private MV f304g;
    private AppWall f305h;
    private ProgressDialog f306j;
    private C0310n f307k;
    private AdType f308l;

    /* renamed from: com.sxnyodot.uefqvmio207964.MainActivity.1 */
    class C02781 extends Handler {
        final /* synthetic */ MainActivity f292a;

        C02781(MainActivity mainActivity) {
            this.f292a = mainActivity;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case -4:
                    try {
                        if (this.f292a.f300a != null) {
                            this.f292a.f300a.dismiss();
                        }
                        this.f292a.finish();
                        if (Prm.adListener != null) {
                            Prm.adListener.onAdError("Error occurred while loading ad.");
                        }
                    } catch (Exception e) {
                    }
                case -3:
                    try {
                        if (this.f292a.f300a != null) {
                            this.f292a.f300a.dismiss();
                        }
                        this.f292a.finish();
                    } catch (Exception e2) {
                        this.f292a.finish();
                    }
                case DetectedActivity.IN_VEHICLE /*0*/:
                    try {
                        this.f292a.f300a.show();
                        this.f292a.f300a.getWindow().setFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
                        if (Prm.adListener != null) {
                            Prm.adListener.onSmartWallAdShowing();
                        }
                    } catch (Exception e3) {
                        this.f292a.finish();
                    }
                default:
            }
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.MainActivity.2 */
    class C02792 implements OnCancelListener {
        final /* synthetic */ MainActivity f293a;

        C02792(MainActivity mainActivity) {
            this.f293a = mainActivity;
        }

        public void onCancel(DialogInterface dialog) {
            dialog.dismiss();
            this.f293a.finish();
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private class AppWall extends Dialog implements OnCancelListener, OnDismissListener {
        final /* synthetic */ MainActivity f296a;

        /* renamed from: com.sxnyodot.uefqvmio207964.MainActivity.AppWall.1 */
        class C02801 extends WebViewClient {
            final /* synthetic */ MainActivity f294a;
            final /* synthetic */ AppWall f295b;

            C02801(AppWall appWall, MainActivity mainActivity) {
                this.f295b = appWall;
                this.f294a = mainActivity;
            }

            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                try {
                    if (this.f295b.f296a.f306j != null) {
                        this.f295b.f296a.f306j.dismiss();
                    }
                    if (this.f295b.f296a.f305h != null && !this.f295b.f296a.f305h.isShowing()) {
                        this.f295b.show();
                    }
                } catch (Exception e) {
                    this.f295b.f296a.finish();
                }
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                try {
                    if (this.f295b.f296a.f306j != null) {
                        this.f295b.f296a.f306j.dismiss();
                    }
                    if (this.f295b.f296a.f305h != null) {
                        this.f295b.f296a.f305h.dismiss();
                    }
                    String str = "Error occurred while loading AppWall: code " + errorCode + ", desc: " + description;
                    Log.e(MainActivity.f297c, str);
                    if (Prm.adListener != null) {
                        Prm.adListener.onAdError(str);
                    }
                } catch (Throwable th) {
                    Log.e(MainActivity.f297c, "Error occurred while loading AppWall: code " + errorCode + ", desc: " + description);
                }
                this.f295b.f296a.finish();
            }

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                try {
                    Util.m929a("SmartWall Url: " + url);
                    this.f295b.m914a();
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
                    intent.addFlags(268435456);
                    intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                    this.f295b.f296a.startActivity(intent);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }

        public class JavaScriptInterface {
            @JavascriptInterface
            public void closewin() {
                AppWall.this.m914a();
            }

            @JavascriptInterface
            public void triggerEvent(String event) {
            }
        }

        public AppWall(MainActivity mainActivity, Context context, String url) {
            this.f296a = mainActivity;
            super(context);
            requestWindowFeature(1);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            setCancelable(true);
            setCanceledOnTouchOutside(false);
            setOnCancelListener(this);
            setOnDismissListener(this);
            int i = (int) (mainActivity.getResources().getDisplayMetrics().density * 7.0f);
            View relativeLayout = new RelativeLayout(context);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(i, i, i, i);
            layoutParams.addRule(15, -1);
            layoutParams.addRule(14, -1);
            relativeLayout.setLayoutParams(layoutParams);
            MainActivity.f298d = new WebView(context);
            MainActivity.f298d.getSettings().setCacheMode(-1);
            MainActivity.f298d.getSettings().setJavaScriptEnabled(true);
            MainActivity.f298d.addJavascriptInterface(new JavaScriptInterface(), "Appwall");
            MainActivity.f298d.setWebChromeClient(new WebChromeClient());
            MainActivity.f298d.setWebViewClient(new C02801(this, mainActivity));
            MainActivity.f298d.setVerticalScrollBarEnabled(false);
            MainActivity.f298d.setHorizontalScrollBarEnabled(false);
            MainActivity.f298d.setScrollBarStyle(33554432);
            MainActivity.f298d.getSettings().setLayoutAlgorithm(LayoutAlgorithm.NORMAL);
            MainActivity.f298d.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            relativeLayout.addView(MainActivity.f298d);
            setContentView(relativeLayout);
            MainActivity.f298d.loadUrl(url);
        }

        public void onCancel(DialogInterface dialog) {
            m914a();
        }

        public void onDismiss(DialogInterface dialog) {
            m914a();
        }

        private void m914a() {
            try {
                if (this.f296a.f305h != null) {
                    this.f296a.f305h.dismiss();
                }
                this.f296a.f305h = null;
            } catch (Exception e) {
            }
            this.f296a.finish();
        }
    }

    public MainActivity() {
        this.f301b = new C02781(this);
    }

    static {
        f297c = C0301h.TAG;
        f299i = false;
    }

    @SuppressLint({"InlinedApi"})
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            requestWindowFeature(1);
            f299i = true;
            this.f303f = getIntent();
            String action = this.f303f.getAction();
            this.f302e = this.f303f.getStringExtra("adtype");
            if (action.equals(INTENT_ACTION_RICH_MEDIA_FULL_PAGE_AD) && this.f302e.equalsIgnoreCase(C0301h.AD_TYPE_MFP)) {
                this.f308l = AdType.interstitial;
                this.f300a = new Dialog(this, 16973841);
                this.f300a.requestWindowFeature(1);
                this.f300a.getWindow().setLayout(-1, -1);
                this.f304g = new MV(this, Prm.parseMraidJson, this.f301b);
                this.f300a.setContentView(this.f304g);
                this.f300a.setCanceledOnTouchOutside(false);
                this.f300a.setCancelable(false);
                this.f300a.setOnCancelListener(new C02792(this));
            } else if (action.equals(INTENT_ACTION_APPWALL_AD) && this.f302e.equalsIgnoreCase(C0301h.AD_TYPE_AW)) {
                this.f308l = AdType.appwall;
                action = this.f303f.getStringExtra(PlusShare.KEY_CALL_TO_ACTION_URL);
                if (!(action == null || action.equals("") || !Util.m977o(this))) {
                    try {
                        if (VERSION.SDK_INT >= 11) {
                            getWindow().setFlags(ViewCompat.MEASURED_STATE_TOO_SMALL, ViewCompat.MEASURED_STATE_TOO_SMALL);
                        }
                    } catch (Throwable th) {
                    }
                    this.f306j = ProgressDialog.show(this, null, "Loading....");
                    this.f305h = new AppWall(this, this, action);
                    if (Prm.adListener != null) {
                        Prm.adListener.onSmartWallAdShowing();
                        return;
                    }
                    return;
                }
                if (C0559q.m1751g(this)) {
                    f299i = true;
                    r1 = new C0556e(this, getIntent().getStringExtra("data"));
                    r1.setCanceledOnTouchOutside(false);
                    r1.show();
                    return;
                }
                finish();
            } else {
                if (this.f302e.equals("OLAU") || this.f302e.equals(C0301h.AD_TYPE_DAU) || this.f302e.equals(C0301h.AD_TYPE_DCC) || this.f302e.equals(C0301h.AD_TYPE_DCM)) {
                    this.f308l = AdType.overlay;
                    if (this.f307k == null) {
                        this.f307k = new C0310n(this);
                        return;
                    }
                    return;
                }
                if (C0559q.m1751g(this)) {
                    f299i = true;
                    r1 = new C0556e(this, getIntent().getStringExtra("data"));
                    r1.setCanceledOnTouchOutside(false);
                    r1.show();
                    return;
                }
                finish();
            }
        } catch (Exception e) {
        }
    }

    protected void onUserLeaveHint() {
        try {
            if (this.f302e != null && (this.f302e.equals("OLAU") || this.f302e.equals(C0301h.AD_TYPE_DAU) || this.f302e.equals(C0301h.AD_TYPE_DCC) || this.f302e.equals(C0301h.AD_TYPE_DCM))) {
                if (this.f307k != null) {
                    this.f307k.dismiss();
                }
                finish();
            }
        } catch (Exception e) {
            finish();
        }
        super.onUserLeaveHint();
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    protected void onPause() {
        super.onPause();
        try {
            if (this.f306j != null) {
                this.f306j.dismiss();
            }
        } catch (Exception e) {
        }
    }

    public void onBackPressed() {
        try {
            if (this.f302e != null && (this.f302e.equals("OLAU") || this.f302e.equals(C0301h.AD_TYPE_DAU) || this.f302e.equals(C0301h.AD_TYPE_DCC) || this.f302e.equals(C0301h.AD_TYPE_DCM))) {
                return;
            }
            if (this.f302e != null && this.f302e.equals(C0301h.AD_TYPE_AW)) {
                if (this.f306j != null) {
                    this.f306j.dismiss();
                }
                if (this.f305h != null) {
                    this.f305h.dismiss();
                }
                finish();
            } else if (this.f302e != null && this.f302e.equals(C0301h.AD_TYPE_MFP)) {
                if (this.f300a != null) {
                    this.f300a.dismiss();
                }
                finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void onDestroy() {
        try {
            f299i = false;
            if (!(Prm.adListener == null || this.f302e == null)) {
                Prm.adListener.onSmartWallAdClosed();
            }
            C0295d c0295d = new C0295d(this);
            if (c0295d.m1008a()) {
                c0295d.m1012c(AdType.smartwall);
                c0295d.m1007a(false);
            } else {
                c0295d.m1012c(this.f308l);
            }
            if (f298d != null) {
                f298d.stopLoading();
                f298d.removeAllViews();
                f298d.destroy();
            }
        } catch (Exception e) {
        } catch (Throwable th) {
        }
        super.onDestroy();
    }

    static boolean m920a() {
        return f299i;
    }

    static void m919a(boolean z) {
        f299i = z;
    }
}
