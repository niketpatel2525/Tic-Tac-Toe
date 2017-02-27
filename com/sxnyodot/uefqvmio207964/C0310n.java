package com.sxnyodot.uefqvmio207964;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import java.util.HashMap;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

/* renamed from: com.sxnyodot.uefqvmio207964.n */
class C0310n extends Dialog implements OnCancelListener, OnDismissListener {
    static final String AD_TYPE_DIALOG_CC = "DCC";
    static final String AD_TYPE_DIALOG_CM = "DCM";
    static final String AD_TYPE_DIALOG_U = "DAU";
    static final String AD_TYPE_OVERLAY = "OLAU";
    private static int f391l;
    private static int f392m;
    private static String f393n;
    private static boolean f394o;
    private static String f395p;
    private static String f396r;
    Activity f397a;
    OnTouchListener f398b;
    private final String f399c;
    private final String f400d;
    private final String f401e;
    private final String f402f;
    private final String f403g;
    private final String f404h;
    private final String f405i;
    private final String f406j;
    private final String f407k;
    private WebView f408q;
    private boolean f409s;
    private boolean f410t;
    private HashMap<String, String> f411u;
    private final String f412v;

    /* renamed from: com.sxnyodot.uefqvmio207964.n.1 */
    class C03061 extends WebViewClient {
        final /* synthetic */ C0310n f387a;

        C03061(C0310n c0310n) {
            this.f387a = c0310n;
        }

        public void onLoadResource(WebView view, String url) {
            if (this.f387a.f410t && this.f387a.isShowing()) {
                this.f387a.m1035g(url);
                this.f387a.f408q.stopLoading();
                return;
            }
            super.onLoadResource(view, url);
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            try {
                if (this.f387a.f409s) {
                    Log.i(C0301h.TAG, "Error in loading");
                    this.f387a.dismiss();
                    if (C0310n.f396r.equals(C0310n.AD_TYPE_DIALOG_U) || C0310n.f396r.equals(C0310n.AD_TYPE_DIALOG_CC) || C0310n.f396r.equals(C0310n.AD_TYPE_DIALOG_CM)) {
                        this.f387a.m1036a("184");
                        return;
                    } else {
                        this.f387a.m1036a("183");
                        return;
                    }
                }
                this.f387a.show();
                if (C0310n.f396r.equals(C0310n.AD_TYPE_DIALOG_U) || C0310n.f396r.equals(C0310n.AD_TYPE_DIALOG_CC) || C0310n.f396r.equals(C0310n.AD_TYPE_DIALOG_CM)) {
                    this.f387a.m1036a("43");
                } else {
                    this.f387a.m1036a("23");
                }
                if (Prm.adListener != null) {
                    Prm.adListener.onSmartWallAdShowing();
                }
            } catch (Exception e) {
                e.printStackTrace();
                this.f387a.f397a.finish();
            }
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            this.f387a.f409s = true;
            try {
                this.f387a.dismiss();
                this.f387a.f397a.finish();
            } catch (Throwable th) {
                Log.e(C0301h.TAG, "Error occurred while loading Overlay Ad: code " + errorCode + ", desc: " + description);
            }
            super.onReceivedError(view, errorCode, description, failingUrl);
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            try {
                if (this.f387a.f410t) {
                    this.f387a.m1035g(url);
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                this.f387a.dismiss();
                this.f387a.f397a.finish();
            }
            view.loadUrl(url);
            return true;
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.n.2 */
    class C03072 implements OnTouchListener {
        final /* synthetic */ C0310n f388a;

        C03072(C0310n c0310n) {
            this.f388a = c0310n;
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (v == this.f388a.f408q && event.getAction() == 0) {
                this.f388a.f410t = true;
            }
            return false;
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.n.3 */
    class C03083 implements Runnable {
        final /* synthetic */ String f389a;
        final /* synthetic */ C0310n f390b;

        C03083(C0310n c0310n, String str) {
            this.f390b = c0310n;
            this.f389a = str;
        }

        public void run() {
            try {
                Log.i(C0301h.TAG, "Sending overlay event: ");
                if (C0310n.f394o || !(this.f389a.equals("184") || this.f389a.equals("183"))) {
                    String e = this.f390b.m1037e(this.f389a);
                    Util.m929a("Event: " + this.f389a + ", URL: " + e);
                    if (e == null || e.equals("")) {
                        Log.w(C0301h.TAG, "Event url null");
                        Thread.currentThread().interrupt();
                        return;
                    }
                    HttpClient defaultHttpClient = new DefaultHttpClient();
                    HttpUriRequest httpPost = new HttpPost(e);
                    HttpParams basicHttpParams = new BasicHttpParams();
                    httpPost.setParams(basicHttpParams);
                    HttpConnectionParams.setConnectionTimeout(basicHttpParams, 15000);
                    HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
                    HttpResponse execute = defaultHttpClient.execute(httpPost);
                    int statusCode = execute == null ? 0 : execute.getStatusLine().getStatusCode();
                    Log.i(C0301h.TAG, "Status code: " + statusCode);
                    if (statusCode == 200) {
                        Log.i(C0301h.TAG, "Overlay Data: " + EntityUtils.toString(execute.getEntity()));
                        this.f390b.m1038f(this.f389a);
                        return;
                    }
                    return;
                }
                Util.m929a("Error reporting is off.");
            } catch (Throwable e2) {
                Log.e(C0301h.TAG, "Exception in overlay: ", e2);
            }
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.n.a */
    private class C0309a {
        private C0309a() {
        }

        @JavascriptInterface
        public void close() {
            C0310n.this.dismiss();
            if (C0310n.f396r.equals(C0310n.AD_TYPE_DIALOG_U) || C0310n.f396r.equals(C0310n.AD_TYPE_DIALOG_CC) || C0310n.f396r.equals(C0310n.AD_TYPE_DIALOG_CM)) {
                C0310n.this.m1036a("45");
            } else {
                C0310n.this.m1036a("25");
            }
            C0310n.this.f397a.finish();
        }

        @JavascriptInterface
        public void open(String url) {
            C0310n.this.m1035g(url);
            C0310n.this.f397a.finish();
        }

        @JavascriptInterface
        public void call(String number) {
            try {
                C0310n.this.dismiss();
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + number));
                intent.addFlags(268435456);
                C0310n.this.f397a.startActivity(intent);
                if (C0310n.f396r.equals(C0310n.AD_TYPE_DIALOG_U) || C0310n.f396r.equals(C0310n.AD_TYPE_DIALOG_CC) || C0310n.f396r.equals(C0310n.AD_TYPE_DIALOG_CM)) {
                    C0310n.this.m1036a("44");
                    C0310n.this.f397a.finish();
                }
                C0310n.this.m1036a("24");
                C0310n.this.f397a.finish();
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e2) {
            }
        }

        @JavascriptInterface
        public void sms(String number, String text) {
            try {
                C0310n.this.dismiss();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setType("vnd.android-dir/mms-sms");
                intent.putExtra("address", number);
                intent.putExtra("sms_body", text);
                C0310n.this.f397a.startActivity(intent);
                if (C0310n.f396r.equals(C0310n.AD_TYPE_DIALOG_U) || C0310n.f396r.equals(C0310n.AD_TYPE_DIALOG_CC) || C0310n.f396r.equals(C0310n.AD_TYPE_DIALOG_CM)) {
                    C0310n.this.m1036a("44");
                } else {
                    C0310n.this.m1036a("24");
                }
            } catch (Exception e) {
                C0310n.this.f397a.finish();
                e.printStackTrace();
            }
        }
    }

    static {
        f391l = 250;
        f392m = 300;
        f394o = false;
        f396r = "";
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public C0310n(Activity activity) {
        super(activity);
        this.f399c = C0301h.TAG;
        this.f400d = "23";
        this.f401e = "24";
        this.f402f = "25";
        this.f403g = "43";
        this.f404h = "44";
        this.f405i = "45";
        this.f406j = "184";
        this.f407k = "183";
        this.f409s = false;
        this.f410t = false;
        this.f412v = "imp_url";
        this.f398b = new C03072(this);
        try {
            this.f397a = activity;
            this.f411u = new HashMap();
            if (f396r.equals(AD_TYPE_OVERLAY)) {
                this.f411u.put("imp_url23", m1021a(f395p, "23"));
                this.f411u.put("imp_url24", m1021a(f395p, "24"));
                this.f411u.put("imp_url25", m1021a(f395p, "25"));
                this.f411u.put("imp_url183", m1021a(f395p, "183"));
                Util.m929a("Overlay urls: " + this.f411u);
            } else {
                this.f411u.put("imp_url43", m1021a(f395p, "43"));
                this.f411u.put("imp_url44", m1021a(f395p, "44"));
                this.f411u.put("imp_url45", m1021a(f395p, "45"));
                this.f411u.put("imp_url184", m1021a(f395p, "184"));
                Util.m929a("Dialog urls: " + this.f411u);
            }
            requestWindowFeature(1);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            setCancelable(false);
            setCanceledOnTouchOutside(false);
            setOnCancelListener(this);
            setOnDismissListener(this);
            View relativeLayout = new RelativeLayout(activity);
            relativeLayout.setId(76);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            relativeLayout.setLayoutParams(layoutParams);
            this.f408q = new WebView(activity);
            this.f408q.setId(54);
            this.f408q.getSettings().setJavaScriptEnabled(true);
            this.f408q.setWebChromeClient(new WebChromeClient());
            this.f408q.setHorizontalScrollBarEnabled(false);
            this.f408q.setVerticalScrollBarEnabled(false);
            this.f408q.getSettings().setCacheMode(-1);
            this.f408q.setBackgroundColor(0);
            this.f408q.setScrollBarStyle(33554432);
            this.f408q.addJavascriptInterface(new C0309a(), "Overlay");
            this.f408q.setOnTouchListener(this.f398b);
            this.f408q.setWebViewClient(new C03061(this));
            this.f408q.loadDataWithBaseURL(null, f393n, "text/html", "UTF-8", null);
            layoutParams = new RelativeLayout.LayoutParams(f392m, f391l);
            layoutParams.addRule(13);
            this.f408q.setLayoutParams(layoutParams);
            relativeLayout.addView(this.f408q);
            setContentView(relativeLayout);
        } catch (Exception e) {
            Log.e(C0301h.TAG, "An error occured while starting Overlay Ad.");
            try {
                dismiss();
                activity.finish();
            } catch (Exception e2) {
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m1035g(java.lang.String r6) {
        /*
        r5 = this;
        r5.dismiss();	 Catch:{ ActivityNotFoundException -> 0x009e, Exception -> 0x00c7 }
        r0 = "com.android.browser";
        r1 = "com.android.browser.BrowserActivity";
        r2 = new android.content.Intent;	 Catch:{ ActivityNotFoundException -> 0x0053, Exception -> 0x00c7 }
        r3 = "android.intent.action.VIEW";
        r4 = android.net.Uri.parse(r6);	 Catch:{ ActivityNotFoundException -> 0x0053, Exception -> 0x00c7 }
        r2.<init>(r3, r4);	 Catch:{ ActivityNotFoundException -> 0x0053, Exception -> 0x00c7 }
        r3 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r2.setFlags(r3);	 Catch:{ ActivityNotFoundException -> 0x0053, Exception -> 0x00c7 }
        r3 = 8388608; // 0x800000 float:1.17549435E-38 double:4.144523E-317;
        r2.addFlags(r3);	 Catch:{ ActivityNotFoundException -> 0x0053, Exception -> 0x00c7 }
        r3 = "android.intent.category.LAUNCHER";
        r2.addCategory(r3);	 Catch:{ ActivityNotFoundException -> 0x0053, Exception -> 0x00c7 }
        r2.setClassName(r0, r1);	 Catch:{ ActivityNotFoundException -> 0x0053, Exception -> 0x00c7 }
        r0 = r5.f397a;	 Catch:{ ActivityNotFoundException -> 0x0053, Exception -> 0x00c7 }
        r0.startActivity(r2);	 Catch:{ ActivityNotFoundException -> 0x0053, Exception -> 0x00c7 }
        r0 = f396r;	 Catch:{ ActivityNotFoundException -> 0x0053, Exception -> 0x00c7 }
        r1 = "DAU";
        r0 = r0.equals(r1);	 Catch:{ ActivityNotFoundException -> 0x0053, Exception -> 0x00c7 }
        if (r0 != 0) goto L_0x0047;
    L_0x0033:
        r0 = f396r;	 Catch:{ ActivityNotFoundException -> 0x0053, Exception -> 0x00c7 }
        r1 = "DCC";
        r0 = r0.equals(r1);	 Catch:{ ActivityNotFoundException -> 0x0053, Exception -> 0x00c7 }
        if (r0 != 0) goto L_0x0047;
    L_0x003d:
        r0 = f396r;	 Catch:{ ActivityNotFoundException -> 0x0053, Exception -> 0x00c7 }
        r1 = "DCM";
        r0 = r0.equals(r1);	 Catch:{ ActivityNotFoundException -> 0x0053, Exception -> 0x00c7 }
        if (r0 == 0) goto L_0x004d;
    L_0x0047:
        r0 = "44";
        r5.m1036a(r0);	 Catch:{ ActivityNotFoundException -> 0x0053, Exception -> 0x00c7 }
    L_0x004c:
        return;
    L_0x004d:
        r0 = "24";
        r5.m1036a(r0);	 Catch:{ ActivityNotFoundException -> 0x0053, Exception -> 0x00c7 }
        goto L_0x004c;
    L_0x0053:
        r0 = move-exception;
        r0 = "PrmSDK";
        r1 = "Browser not found.";
        android.util.Log.i(r0, r1);	 Catch:{ ActivityNotFoundException -> 0x009e, Exception -> 0x00c7 }
        r0 = new android.content.Intent;	 Catch:{ ActivityNotFoundException -> 0x009e, Exception -> 0x00c7 }
        r1 = "android.intent.action.VIEW";
        r2 = android.net.Uri.parse(r6);	 Catch:{ ActivityNotFoundException -> 0x009e, Exception -> 0x00c7 }
        r0.<init>(r1, r2);	 Catch:{ ActivityNotFoundException -> 0x009e, Exception -> 0x00c7 }
        r1 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r0.setFlags(r1);	 Catch:{ ActivityNotFoundException -> 0x009e, Exception -> 0x00c7 }
        r1 = 8388608; // 0x800000 float:1.17549435E-38 double:4.144523E-317;
        r0.addFlags(r1);	 Catch:{ ActivityNotFoundException -> 0x009e, Exception -> 0x00c7 }
        r1 = r5.f397a;	 Catch:{ ActivityNotFoundException -> 0x009e, Exception -> 0x00c7 }
        r1.startActivity(r0);	 Catch:{ ActivityNotFoundException -> 0x009e, Exception -> 0x00c7 }
        r0 = f396r;	 Catch:{ ActivityNotFoundException -> 0x009e, Exception -> 0x00c7 }
        r1 = "DAU";
        r0 = r0.equals(r1);	 Catch:{ ActivityNotFoundException -> 0x009e, Exception -> 0x00c7 }
        if (r0 != 0) goto L_0x0093;
    L_0x007f:
        r0 = f396r;	 Catch:{ ActivityNotFoundException -> 0x009e, Exception -> 0x00c7 }
        r1 = "DCC";
        r0 = r0.equals(r1);	 Catch:{ ActivityNotFoundException -> 0x009e, Exception -> 0x00c7 }
        if (r0 != 0) goto L_0x0093;
    L_0x0089:
        r0 = f396r;	 Catch:{ ActivityNotFoundException -> 0x009e, Exception -> 0x00c7 }
        r1 = "DCM";
        r0 = r0.equals(r1);	 Catch:{ ActivityNotFoundException -> 0x009e, Exception -> 0x00c7 }
        if (r0 == 0) goto L_0x00c1;
    L_0x0093:
        r0 = "44";
        r5.m1036a(r0);	 Catch:{ ActivityNotFoundException -> 0x009e, Exception -> 0x00c7 }
    L_0x0098:
        r0 = r5.f397a;	 Catch:{ ActivityNotFoundException -> 0x009e, Exception -> 0x00c7 }
        r0.finish();	 Catch:{ ActivityNotFoundException -> 0x009e, Exception -> 0x00c7 }
        goto L_0x004c;
    L_0x009e:
        r0 = move-exception;
        r1 = "PrmSDK";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Error whlie displaying dialog ad......: ";
        r2 = r2.append(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r0 = r0.toString();
        android.util.Log.e(r1, r0);
        r0 = r5.f397a;
        r0.finish();
        goto L_0x004c;
    L_0x00c1:
        r0 = "24";
        r5.m1036a(r0);	 Catch:{ ActivityNotFoundException -> 0x009e, Exception -> 0x00c7 }
        goto L_0x0098;
    L_0x00c7:
        r0 = move-exception;
        r0.printStackTrace();
        r0 = r5.f397a;
        r0.finish();
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sxnyodot.uefqvmio207964.n.g(java.lang.String):void");
    }

    public void onCancel(DialogInterface dialog) {
        if (dialog != null) {
            try {
                dialog.dismiss();
            } catch (Exception e) {
                return;
            }
        }
        this.f397a.finish();
    }

    public void onDismiss(DialogInterface dialog) {
        if (this != null) {
            try {
                if (this.f408q != null) {
                    this.f408q.stopLoading();
                    this.f408q.removeAllViews();
                    this.f408q.destroy();
                }
                dismiss();
            } catch (Exception e) {
            } catch (Throwable th) {
            }
        }
        try {
            this.f397a.finish();
        } catch (Exception e2) {
            this.f397a.finish();
        }
    }

    final void m1036a(String str) {
        synchronized (str) {
            if (Util.m977o(getContext())) {
                new Thread(new C03083(this, str), "overlay_event").start();
                return;
            }
        }
    }

    public static void m1022a(int i) {
        f391l = i;
    }

    public static void m1028b(int i) {
        f392m = i;
    }

    public static void m1029b(String str) {
        f393n = str;
    }

    public static void m1024a(boolean z) {
        f394o = z;
    }

    public static void m1032c(String str) {
        f395p = str;
    }

    public static void m1034d(String str) {
        f396r = str;
    }

    private String m1021a(String str, String str2) {
        if (str.contains("%event%")) {
            return str.replace("%event%", str2);
        }
        return str;
    }

    public String m1037e(String str) {
        if (this.f411u != null) {
            return (String) this.f411u.get("imp_url" + str);
        }
        return null;
    }

    public void m1038f(String str) {
        if (this.f411u != null) {
            this.f411u.remove("imp_url" + str);
        }
    }
}
