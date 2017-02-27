package com.sxnyodot.uefqvmio207964;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.sxnyodot.uefqvmio207964.AdListener.OptinListener;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* renamed from: com.sxnyodot.uefqvmio207964.e */
class C0556e extends AlertDialog implements OnCancelListener, OnDismissListener, OnShowListener, C0293b<String> {
    private static final String TEXT = "PGh0bWw+PGJvZHkgc3R5bGU9J2JhY2tncm91bmQ6I0M0QzRDNDtmb250LWZhbWlseTpBcmlhbDtmb250LXNpemU6MTFwdDtsaW5lLWhlaWdodDoxOHB4Jz48cCBhbGlnbj0nanVzdGlmeSc+VGhpcyBhcHAgaXMgYWQtc3VwcG9ydGVkIGFuZCBvdXIgYWR2ZXJ0aXNpbmcgbmV0d29yaywgQWlycHVzaCwgSW5jLiwgd2lsbCBwbGFjZSBhZHMgd2l0aGluIHRoaXMgYXBwLiBBaXJwdXNoIGF1dG9tYXRpY2FsbHkgY29sbGVjdHMgY2VydGFpbiBkYXRhIGZyb20geW91ciBkZXZpY2UsIGluY2x1ZGluZyBhIGRldmljZSBJRCBhbmQgSVAgYWRkcmVzcy4gQWlycHVzaCBtYXkgYWxzbyByZWNlaXZlIGluZm9ybWF0aW9uIHZpYSB0aGUgcGVybWlzc2lvbnMgeW91IGdyYW50ZWQgdG8gdGhpcyBhcHAgaW4gdGhlIHByaW9yIHNjcmVlbiBpbmNsdWRpbmcgeW91ciBwcmVjaXNlIGdlb2xvY2F0aW9uLiBUbyBsZWFybiBtb3JlIGFib3V0IEFpcnB1c2gmIzM5O3MgcHJpdmFjeSBwcmFjdGljZXMsIHZpc2l0IGl0cyA8YSBocmVmPSJodHRwOi8vd3d3LmFpcnB1c2guY29tL3RlY2hub2xvZ3lfcHJpdmFjeS8iPlRlY2hub2xvZ3kgUHJpdmFjeSBTdGF0ZW1lbnQ8L2E+LiBCeSBjbGlja2luZyAmcXVvdDtPa2F5LCZxdW90OyB5b3UgcHJvdmlkZSBleHBsaWNpdCBjb25zZW50IHRvIGFsbG93IEFpcnB1c2ggdG8gYXNzb2NpYXRlIHRoZSBHb29nbGUgYWR2ZXJ0aXNlciBJRCBmcm9tIHlvdXIgZGV2aWNlIHdpdGggb3RoZXIgaW5mb3JtYXRpb24gaXQgY29sbGVjdHMgYWJvdXQgeW91ciBkZXZpY2UsIGluY2x1ZGluZyBwZXJzaXN0ZW50IGRldmljZSBpZGVudGlmaWVycyBhbmQvb3IgcGVyc29uYWxseSBpZGVudGlmaWFibGUgaW5mb3JtYXRpb24uIENsaWNrICZxdW90O0NhbmNlbCZxdW90OyB0byB3aXRoaG9sZCBzdWNoIGNvbnNlbnQuPC9wPjwvYm9keT48L2h0bWw+";
    private static final String TITLE = "UHJpdmFjeSBQb2xpY3kgJiBBZHZlcnRpc2luZyBUZXJtcw==";
    private static String f609a;
    private static String f610b;
    private final Activity f611c;
    private OptinListener f612d;
    private WebView f613e;

    /* renamed from: com.sxnyodot.uefqvmio207964.e.1 */
    class C02961 implements OnClickListener {
        final /* synthetic */ C0556e f375a;

        C02961(C0556e c0556e) {
            this.f375a = c0556e;
        }

        public void onClick(View arg0) {
            this.f375a.m1743b();
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.e.2 */
    class C02972 implements OnClickListener {
        final /* synthetic */ C0556e f376a;

        C02972(C0556e c0556e) {
            this.f376a = c0556e;
        }

        public void onClick(View arg0) {
            try {
                MainActivity.m919a(false);
                this.f376a.dismiss();
                C0559q.m1750f(this.f376a.f611c);
                Prm.isDialogClosed = true;
                if (Util.m977o(this.f376a.f611c)) {
                    C0556e.f610b = "optIn";
                    this.f376a.m1740a();
                    Prm.startNewAdThread();
                } else {
                    this.f376a.f611c.finish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.f376a.f612d != null) {
                this.f376a.f612d.optinResult(true);
            }
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.e.a */
    private class C0298a extends WebViewClient {
        final /* synthetic */ C0556e f377a;

        private C0298a(C0556e c0556e) {
            this.f377a = c0556e;
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
                intent.addFlags(268435456);
                this.f377a.f611c.startActivity(intent);
            } catch (Exception e) {
            }
            return true;
        }
    }

    static {
        f609a = C0301h.TAG;
        f610b = "optOut";
    }

    protected C0556e(Activity activity, String str) {
        super(activity);
        this.f611c = activity;
        this.f612d = Prm.getOptinListener();
        Log.i(f609a, "Display Privacy & Terms");
        try {
            setOnShowListener(this);
            setOnDismissListener(this);
            setOnCancelListener(this);
            getWindow().requestFeature(2);
            setTitle(Base64.decodeString(TITLE));
            getWindow().setFlags(AccessibilityNodeInfoCompat.ACTION_SET_SELECTION, AccessibilityNodeInfoCompat.ACTION_SET_SELECTION);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            View linearLayout = new LinearLayout(this.f611c);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOrientation(1);
            float f = this.f611c.getResources().getDisplayMetrics().density;
            LinearLayout linearLayout2 = new LinearLayout(this.f611c);
            linearLayout2.setGravity(17);
            m1737a(linearLayout2);
            LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, (int) (f * BitmapDescriptorFactory.HUE_YELLOW), 2.0f);
            layoutParams2.topMargin = (int) (-(BitmapDescriptorFactory.HUE_YELLOW * f));
            layoutParams2.gravity = 80;
            linearLayout2.setOrientation(0);
            linearLayout2.setLayoutParams(layoutParams2);
            View textView = new TextView(this.f611c);
            textView.setGravity(17);
            LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2, 2.0f);
            layoutParams3.gravity = 17;
            textView.setLayoutParams(layoutParams3);
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            textView.setTextAppearance(this.f611c, 16843271);
            CharSequence spannableString = new SpannableString("Cancel");
            spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
            textView.setText(spannableString);
            textView.setId(-2);
            linearLayout2.addView(textView);
            View button = new Button(this.f611c);
            button.setId(-1);
            button.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 2.0f));
            button.setText("Ok");
            linearLayout2.addView(button);
            linearLayout2.setBackgroundColor(-3355444);
            View linearLayout3 = new LinearLayout(this.f611c);
            LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -1);
            layoutParams4.bottomMargin = (int) (f * BitmapDescriptorFactory.HUE_YELLOW);
            linearLayout3.setLayoutParams(layoutParams4);
            this.f613e = new WebView(this.f611c);
            if (str == null || str.equals("")) {
                this.f613e.loadData("" + Base64.decodeString(TEXT), "text/html", "utf-8");
            } else {
                this.f613e.loadData(str, "text/html", "utf-8");
            }
            this.f613e.setWebChromeClient(new WebChromeClient());
            this.f613e.setWebViewClient(new C0298a());
            this.f613e.setScrollBarStyle(33554432);
            linearLayout3.addView(this.f613e);
            linearLayout.addView(linearLayout3);
            linearLayout.addView(linearLayout2);
            setView(linearLayout);
            setCancelable(true);
            textView.setOnClickListener(new C02961(this));
            button.setOnClickListener(new C02972(this));
        } catch (Exception e) {
            this.f611c.finish();
        }
    }

    void m1743b() {
        try {
            MainActivity.m919a(false);
            dismiss();
            Prm.isDialogClosed = true;
            if (Util.m977o(this.f611c)) {
                f610b = "optOut";
                m1740a();
                Prm.startNewAdThread();
            }
            this.f611c.finish();
        } catch (Throwable e) {
            Log.w(f609a, "Warning", e);
        }
        if (this.f612d != null) {
            this.f612d.optinResult(false);
        }
    }

    public void onDismiss(DialogInterface dialog) {
        try {
            if (this.f613e != null) {
                this.f613e.stopLoading();
                this.f613e.removeAllViews();
                this.f613e.destroy();
            }
            this.f611c.finish();
            this.f613e = null;
        } catch (Throwable th) {
            Util.m930a("Error in EULA dismiss.", th);
        }
    }

    public void onCancel(DialogInterface dialog) {
        m1743b();
    }

    public void onShow(DialogInterface dialog) {
        if (this.f612d != null) {
            this.f612d.showingDialog();
        }
    }

    public void m1740a() {
        List arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair(C0304k.EVENT, f610b));
        if (f610b == null || !f610b.equals("optIn")) {
            String c = Util.m940c();
            if (c == null || c.equals("")) {
                throw new NullPointerException("Advertiser ID not found.");
            }
            arrayList.add(new BasicNameValuePair(C0301h.IMEI, Util.m972m(c)));
            arrayList.add(new BasicNameValuePair(C0301h.DEVICE_UNIQUENESS, "ADV"));
            arrayList.add(new BasicNameValuePair("adOpt", "" + Util.m939b()));
        } else {
            arrayList.add(new BasicNameValuePair(C0301h.IMEI, "" + Util.m952g()));
            arrayList.add(new BasicNameValuePair(C0301h.DEVICE_UNIQUENESS, Util.m989w()));
        }
        arrayList.add(new BasicNameValuePair(C0301h.APP_ID, Util.m961j()));
        Log.i(f609a, f610b + " Data: " + arrayList);
        new Thread(new C0305m(this.f611c, this, arrayList, C0301h.URL_OPT_IN, 0, false), "opt_in").start();
    }

    public void m1742a(String str) {
        Log.i(f609a, f610b + " data sent: " + str);
        this.f611c.finish();
    }

    private void m1737a(LinearLayout linearLayout) {
        try {
            Drawable gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#A5A5A5"), Color.parseColor("#9C9C9C"), Color.parseColor("#929493")});
            if (VERSION.SDK_INT >= 16) {
                linearLayout.setBackground(gradientDrawable);
            } else {
                linearLayout.setBackgroundDrawable(gradientDrawable);
            }
        } catch (Throwable e) {
            Util.m930a("Error in eula bg", e);
        }
    }
}
