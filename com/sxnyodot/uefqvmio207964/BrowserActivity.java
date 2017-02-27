package com.sxnyodot.uefqvmio207964;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.google.android.gms.location.DetectedActivity;

public class BrowserActivity extends Activity implements OnClickListener {
    private static final int BUTTON_BACK_ID = 11;
    private static final int BUTTON_CLOSE_ID = 14;
    private static final int BUTTON_FORWARD_ID = 12;
    private static final int BUTTON_REFRESH_ID = 13;
    static final int CALENDER_CREATE_EVENT_REQUEST_CODE = 7;
    static final String INTENT_ACTION_BROWSE = "browser";
    static final String INTENT_ACTION_CREATE_CALENDAR_EVENT = "newCalendarEvent";
    static final String INTENT_ACTION_PLAY_VIDEO = "playVideo";
    Handler f164a;
    private float f165b;
    private Button f166c;
    private Button f167d;
    private Button f168e;
    private Button f169f;
    private BrowserView f170g;
    private LinearLayout f171h;
    private MV f172i;

    /* renamed from: com.sxnyodot.uefqvmio207964.BrowserActivity.1 */
    class C02501 extends Handler {
        final /* synthetic */ BrowserActivity f157a;

        C02501(BrowserActivity browserActivity) {
            this.f157a = browserActivity;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case -3:
                    this.f157a.finish();
                case DetectedActivity.IN_VEHICLE /*0*/:
                    this.f157a.setContentView(this.f157a.f172i);
                    this.f157a.f172i.setVisibility(0);
                    Toast.makeText(this.f157a, "Ad is showing on screen.", 0).show();
                default:
            }
        }
    }

    class BrowserView extends WebView {
        final /* synthetic */ BrowserActivity f163a;

        /* renamed from: com.sxnyodot.uefqvmio207964.BrowserActivity.BrowserView.1 */
        class C02511 extends WebChromeClient {
            final /* synthetic */ BrowserActivity f158a;
            final /* synthetic */ Activity f159b;
            final /* synthetic */ BrowserView f160c;

            C02511(BrowserView browserView, BrowserActivity browserActivity, Activity activity) {
                this.f160c = browserView;
                this.f158a = browserActivity;
                this.f159b = activity;
            }

            public void onProgressChanged(WebView view, int progress) {
                this.f159b.setTitle("loading....");
                this.f159b.setProgress(progress * 100);
                if (progress == 100) {
                    this.f159b.setTitle(view.getUrl());
                }
            }

            public void onHideCustomView() {
            }

            public void onShowCustomView(View view, CustomViewCallback callback) {
            }
        }

        /* renamed from: com.sxnyodot.uefqvmio207964.BrowserActivity.BrowserView.2 */
        class C02522 extends WebViewClient {
            final /* synthetic */ BrowserActivity f161a;
            final /* synthetic */ BrowserView f162b;

            C02522(BrowserView browserView, BrowserActivity browserActivity) {
                this.f162b = browserView;
                this.f161a = browserActivity;
            }

            public void onPageFinished(WebView view, String url) {
                int i;
                super.onPageFinished(view, url);
                if (((view != null ? 1 : 0) & view.canGoBack()) != 0) {
                    this.f162b.f163a.f166c.setEnabled(true);
                } else {
                    this.f162b.f163a.f166c.setEnabled(false);
                }
                if (view != null) {
                    i = 1;
                } else {
                    i = 0;
                }
                if ((i & view.canGoForward()) != 0) {
                    this.f162b.f163a.f167d.setEnabled(true);
                } else {
                    this.f162b.f163a.f167d.setEnabled(false);
                }
            }

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (!url.startsWith("market://")) {
                    return super.shouldOverrideUrlLoading(view, url);
                }
                view.loadUrl(url);
                return true;
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                Log.i(IM.TAG, "Error code: " + errorCode + " ,description: " + description);
                try {
                    this.f162b.f163a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(failingUrl)));
                    this.f162b.f163a.finish();
                } catch (Exception e) {
                }
            }
        }

        @SuppressLint({"InlinedApi"})
        void m877a() {
            if (VERSION.SDK_INT >= 8) {
                getSettings().setPluginState(PluginState.ON_DEMAND);
            }
        }

        @SuppressLint({"InlinedApi"})
        private void m876b() {
            try {
                if (VERSION.SDK_INT >= BrowserActivity.BUTTON_BACK_ID) {
                    this.f163a.getWindow().setFlags(ViewCompat.MEASURED_STATE_TOO_SMALL, ViewCompat.MEASURED_STATE_TOO_SMALL);
                }
            } catch (Throwable th) {
            }
        }

        @SuppressLint({"SetJavaScriptEnabled"})
        public BrowserView(BrowserActivity browserActivity, Context context, String url) {
            this.f163a = browserActivity;
            super(context);
            setHorizontalScrollBarEnabled(false);
            setVerticalScrollBarEnabled(false);
            setScrollBarStyle(33554432);
            setBackgroundColor(0);
            CookieSyncManager.createInstance(browserActivity);
            CookieSyncManager.getInstance().startSync();
            getSettings().setJavaScriptEnabled(true);
            m877a();
            m876b();
            setWebChromeClient(new C02511(this, browserActivity, browserActivity));
            setWebViewClient(new C02522(this, browserActivity));
        }
    }

    public BrowserActivity() {
        this.f164a = new C02501(this);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r5) {
        /*
        r4 = this;
        super.onCreate(r5);
        r0 = r4.getIntent();	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r1 = r0.getAction();	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r2 = "browser";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        if (r2 == 0) goto L_0x0047;
    L_0x0013:
        r1 = "url";
        r0 = r0.getStringExtra(r1);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r1 = "market://";
        r1 = r0.startsWith(r1);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        if (r1 != 0) goto L_0x0029;
    L_0x0021:
        r1 = "tel:";
        r1 = r0.startsWith(r1);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        if (r1 == 0) goto L_0x003b;
    L_0x0029:
        r1 = new android.content.Intent;	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r2 = "android.intent.action.VIEW";
        r0 = android.net.Uri.parse(r0);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r1.<init>(r2, r0);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r4.startActivity(r1);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r4.finish();	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
    L_0x003a:
        return;
    L_0x003b:
        r4.m879a(r0);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        goto L_0x003a;
    L_0x003f:
        r0 = move-exception;
        r0.printStackTrace();
        r4.finish();
        goto L_0x003a;
    L_0x0047:
        r2 = "playVideo";
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        if (r2 == 0) goto L_0x0084;
    L_0x004f:
        r1 = "url";
        r0 = r0.getStringExtra(r1);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r1 = 1;
        r4.requestWindowFeature(r1);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r1 = 16973840; // 0x1030010 float:2.4060945E-38 double:8.386191E-317;
        r4.setTheme(r1);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        super.onCreate(r5);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r1 = new android.content.Intent;	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r2 = "android.intent.action.VIEW";
        r3 = android.net.Uri.parse(r0);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r1.<init>(r2, r3);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r0 = android.net.Uri.parse(r0);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r2 = "video/*";
        r1.setDataAndType(r0, r2);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r0 = 8;
        r4.startActivityForResult(r1, r0);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        goto L_0x003a;
    L_0x007c:
        r0 = move-exception;
        r0.printStackTrace();
        r4.finish();
        goto L_0x003a;
    L_0x0084:
        r2 = "newCalendarEvent";
        r1 = r1.equals(r2);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        if (r1 == 0) goto L_0x003a;
    L_0x008c:
        r1 = 1;
        r4.requestWindowFeature(r1);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r1 = 16973840; // 0x1030010 float:2.4060945E-38 double:8.386191E-317;
        r4.setTheme(r1);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        super.onCreate(r5);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r1 = "json";
        r0 = r0.getStringExtra(r1);	 Catch:{ ActivityNotFoundException -> 0x00bd, Exception -> 0x00e1, Throwable -> 0x007c }
        if (r0 == 0) goto L_0x00a9;
    L_0x00a1:
        r1 = "";
        r1 = r0.equals(r1);	 Catch:{ ActivityNotFoundException -> 0x00bd, Exception -> 0x00e1, Throwable -> 0x007c }
        if (r1 == 0) goto L_0x00dc;
    L_0x00a9:
        r0 = com.sxnyodot.uefqvmio207964.MV.f637a;	 Catch:{ ActivityNotFoundException -> 0x00bd, Exception -> 0x00e1, Throwable -> 0x007c }
        r1 = "createCalendarEvent";
        r2 = "Invalid jsonc";
        r0.m2050a(r1, r2);	 Catch:{ ActivityNotFoundException -> 0x00bd, Exception -> 0x00e1, Throwable -> 0x007c }
        r0 = com.sxnyodot.uefqvmio207964.MV.f637a;	 Catch:{ ActivityNotFoundException -> 0x00bd, Exception -> 0x00e1, Throwable -> 0x007c }
        r1 = 1;
        r0.m2051a(r1);	 Catch:{ ActivityNotFoundException -> 0x00bd, Exception -> 0x00e1, Throwable -> 0x007c }
        r4.finish();	 Catch:{ ActivityNotFoundException -> 0x00bd, Exception -> 0x00e1, Throwable -> 0x007c }
        goto L_0x003a;
    L_0x00bd:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r0 = com.sxnyodot.uefqvmio207964.MV.f637a;	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r1 = "error";
        r0.m2057d(r1);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r0 = com.sxnyodot.uefqvmio207964.MV.f637a;	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r1 = "createCalendarEvent";
        r2 = "Calendar activity not found.";
        r0.m2050a(r1, r2);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r0 = com.sxnyodot.uefqvmio207964.MV.f637a;	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r1 = 1;
        r0.m2051a(r1);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r4.finish();	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        goto L_0x003a;
    L_0x00dc:
        com.sxnyodot.uefqvmio207964.CE.m886a(r4, r0);	 Catch:{ ActivityNotFoundException -> 0x00bd, Exception -> 0x00e1, Throwable -> 0x007c }
        goto L_0x003a;
    L_0x00e1:
        r0 = move-exception;
        r1 = com.sxnyodot.uefqvmio207964.MV.f637a;	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r2 = "error";
        r1.m2057d(r2);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r0.printStackTrace();	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r0 = com.sxnyodot.uefqvmio207964.MV.f637a;	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r1 = "createCalendarEvent";
        r2 = "Calendar json parsing error";
        r0.m2050a(r1, r2);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r0 = com.sxnyodot.uefqvmio207964.MV.f637a;	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r1 = 1;
        r0.m2051a(r1);	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        r4.finish();	 Catch:{ Exception -> 0x003f, Throwable -> 0x007c }
        goto L_0x003a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sxnyodot.uefqvmio207964.BrowserActivity.onCreate(android.os.Bundle):void");
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CALENDER_CREATE_EVENT_REQUEST_CODE) {
            if (resultCode == -1) {
                try {
                    Util.m929a("Calender event added");
                    MV.f637a.m2057d(IM.MRAID_EVENT_CREATE_CALENDER);
                    MV.f637a.m2051a(true);
                    finish();
                } catch (Exception e) {
                    return;
                }
            } else if (resultCode == 0) {
                MV.f637a.m2051a(true);
                MV.f637a.m2057d(IM.MRAID_EVENT_CREATE_CALENDER);
                finish();
            } else {
                finish();
            }
        }
        if (requestCode != 8) {
            return;
        }
        if (resultCode == -1) {
            Util.m929a("Video played added");
            MV.f637a.m2057d(IM.MRAID_EVENT_PLAY_VIDEO);
            MV.f637a.m2051a(true);
            finish();
        } else if (resultCode == 0) {
            MV.f637a.m2051a(true);
            MV.f637a.m2050a(INTENT_ACTION_PLAY_VIDEO, "Play video is canceled by user.");
            finish();
        } else {
            finish();
        }
    }

    private void m879a(String str) {
        requestWindowFeature(2);
        this.f165b = getResources().getDisplayMetrics().density;
        if (str != null) {
            try {
                if (!str.equals("")) {
                    m881b(str);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                finish();
                return;
            }
        }
        Log.i(IM.TAG, "Url is null.");
        finish();
    }

    private void m881b(String str) {
        this.f171h = new LinearLayout(this);
        this.f171h.setOrientation(1);
        this.f171h.setLayoutParams(new LayoutParams(-1, -1));
        View relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) (40.0f * this.f165b)));
        this.f166c = new Button(this);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        this.f166c.setLayoutParams(layoutParams);
        this.f166c.setText("Back");
        this.f166c.setTypeface(null, 1);
        this.f166c.setTextColor(-1);
        this.f166c.setId(BUTTON_BACK_ID);
        relativeLayout.addView(this.f166c);
        this.f167d = new Button(this);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, BUTTON_BACK_ID);
        layoutParams.addRule(15, -1);
        this.f167d.setLayoutParams(layoutParams);
        this.f167d.setText("Forward");
        this.f167d.setTypeface(null, 1);
        this.f167d.setTextColor(-1);
        this.f167d.setId(BUTTON_FORWARD_ID);
        relativeLayout.addView(this.f167d);
        this.f168e = new Button(this);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(1, BUTTON_FORWARD_ID);
        layoutParams.addRule(15, -1);
        this.f168e.setLayoutParams(layoutParams);
        this.f168e.setText("Refresh");
        this.f168e.setTypeface(null, 1);
        this.f168e.setTextColor(-1);
        this.f168e.setId(BUTTON_REFRESH_ID);
        relativeLayout.addView(this.f168e);
        this.f169f = new Button(this);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(BUTTON_BACK_ID, -1);
        layoutParams.addRule(15, -1);
        this.f169f.setLayoutParams(layoutParams);
        this.f169f.setText("Close");
        this.f169f.setTypeface(null, 1);
        this.f169f.setTextColor(-1);
        this.f169f.setId(BUTTON_CLOSE_ID);
        relativeLayout.addView(this.f169f);
        relativeLayout.setGravity(17);
        this.f171h.addView(relativeLayout);
        this.f170g = new BrowserView(this, this, str);
        this.f170g.setLayoutParams(new LayoutParams(-1, -1));
        this.f171h.addView(this.f170g);
        setContentView(this.f171h);
        this.f170g.loadUrl(str);
        this.f166c.setOnClickListener(this);
        this.f167d.setOnClickListener(this);
        this.f168e.setOnClickListener(this);
        this.f169f.setOnClickListener(this);
        this.f167d.setEnabled(false);
        this.f166c.setEnabled(false);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case BUTTON_BACK_ID /*11*/:
                if (this.f170g != null && this.f170g.canGoBack()) {
                    this.f170g.goBack();
                }
            case BUTTON_FORWARD_ID /*12*/:
                if (this.f170g != null && this.f170g.canGoForward()) {
                    this.f170g.goForward();
                }
            case BUTTON_REFRESH_ID /*13*/:
                if (this.f170g != null) {
                    this.f170g.reload();
                }
            case BUTTON_CLOSE_ID /*14*/:
                finish();
            default:
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getWindow().setFormat(1);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    protected void onPause() {
        super.onPause();
        try {
            CookieSyncManager.getInstance().stopSync();
        } catch (Exception e) {
        }
    }

    protected void onResume() {
        super.onResume();
        try {
            CookieSyncManager.getInstance().startSync();
        } catch (Exception e) {
        }
    }

    protected void onDestroy() {
        try {
            if (this.f170g != null) {
                this.f170g.stopLoading();
                this.f171h.removeView(this.f170g);
                this.f170g.removeAllViews();
                this.f170g.destroy();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        try {
            if (getIntent().getAction().equals(INTENT_ACTION_PLAY_VIDEO)) {
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onBackPressed();
    }
}
