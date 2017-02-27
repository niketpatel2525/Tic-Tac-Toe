package com.sxnyodot.uefqvmio207964;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.VideoView;
import com.google.android.gms.plus.PlusShare;
import com.sxnyodot.uefqvmio207964.AdListener.BannerAdListener;
import com.sxnyodot.uefqvmio207964.AdView.C0249a;
import com.sxnyodot.uefqvmio207964.JP.ParseMraidJson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

final class MV extends WebView implements IM {
    static MV f637a;
    boolean f638b;
    ValueCallback<String> f639c;
    private AdView f640d;
    private BannerAdListener f641e;
    private Handler f642f;
    private String f643g;
    private DisplayMetrics f644h;
    private int f645i;
    private int f646j;
    private int f647k;
    private int f648l;
    private C0273a f649m;
    private String f650n;
    private boolean f651o;
    private float f652p;
    private FrameLayout f653q;
    private ViewGroup f654r;
    private int f655s;
    private VideoView f656t;
    private MraidAdUtil f657u;
    private String f658v;
    private boolean f659w;
    private ParseMraidJson f660x;
    private C0249a f661y;

    /* renamed from: com.sxnyodot.uefqvmio207964.MV.1 */
    class C02551 implements OnClickListener {
        final /* synthetic */ MV f252a;

        C02551(MV mv) {
            this.f252a = mv;
        }

        public void onClick(View v) {
            this.f252a.close();
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.MV.2 */
    class C02602 implements DialogInterface.OnClickListener {
        final /* synthetic */ String f258a;
        final /* synthetic */ String f259b;
        final /* synthetic */ MV f260c;

        /* renamed from: com.sxnyodot.uefqvmio207964.MV.2.1 */
        class C02591 implements Runnable {
            final /* synthetic */ C02602 f257a;

            /* renamed from: com.sxnyodot.uefqvmio207964.MV.2.1.1 */
            class C02561 implements Runnable {
                final /* synthetic */ C02591 f253a;

                C02561(C02591 c02591) {
                    this.f253a = c02591;
                }

                public void run() {
                    this.f253a.f257a.f260c.m2057d(IM.MRAID_EVENT_STORE_PICTURE);
                    Log.i(IM.TAG, "Ad image is saved in Gallery.");
                    this.f253a.f257a.f260c.m2051a(true);
                }
            }

            /* renamed from: com.sxnyodot.uefqvmio207964.MV.2.1.2 */
            class C02572 implements Runnable {
                final /* synthetic */ C02591 f254a;

                C02572(C02591 c02591) {
                    this.f254a = c02591;
                }

                public void run() {
                    this.f254a.f257a.f260c.m2050a("storePicture", "Url does not exist.");
                    this.f254a.f257a.f260c.m2051a(true);
                }
            }

            /* renamed from: com.sxnyodot.uefqvmio207964.MV.2.1.3 */
            class C02583 implements Runnable {
                final /* synthetic */ Exception f255a;
                final /* synthetic */ C02591 f256b;

                C02583(C02591 c02591, Exception exception) {
                    this.f256b = c02591;
                    this.f255a = exception;
                }

                public void run() {
                    this.f256b.f257a.f260c.m2050a("storePicture", "Unknown error occured: " + this.f255a.getMessage());
                    if (this.f256b.f257a.f260c.f641e != null) {
                        this.f256b.f257a.f260c.f641e.onCloseListener();
                    }
                    this.f256b.f257a.f260c.m2051a(true);
                }
            }

            C02591(C02602 c02602) {
                this.f257a = c02602;
            }

            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f257a.f258a).openConnection();
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.connect();
                    Bitmap decodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                    File file = new File(this.f257a.f260c.getContext().getApplicationInfo().dataDir, this.f257a.f259b);
                    Log.i("TAG", "file: " + file.getAbsolutePath());
                    OutputStream fileOutputStream = new FileOutputStream(file);
                    decodeStream.compress(CompressFormat.JPEG, 85, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    Media.insertImage(this.f257a.f260c.getContext().getContentResolver(), this.f257a.f260c.getContext().getApplicationInfo().dataDir + "/" + this.f257a.f259b, "My Image", this.f257a.f259b);
                    this.f257a.f260c.post(new C02561(this));
                } catch (FileNotFoundException e2) {
                    this.f257a.f260c.post(new C02572(this));
                    e2.printStackTrace();
                } catch (Exception e3) {
                    this.f257a.f260c.post(new C02583(this, e3));
                    e3.printStackTrace();
                }
            }
        }

        C02602(MV mv, String str, String str2) {
            this.f260c = mv;
            this.f258a = str;
            this.f259b = str2;
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            new Thread(new C02591(this)).start();
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.MV.3 */
    class C02613 implements DialogInterface.OnClickListener {
        final /* synthetic */ MV f261a;

        C02613(MV mv) {
            this.f261a = mv;
        }

        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            this.f261a.m2050a("storePicture", "User has canceled.");
            if (this.f261a.f641e != null) {
                this.f261a.f641e.onCloseListener();
            }
            this.f261a.m2051a(true);
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.MV.4 */
    class C02624 implements OnCancelListener {
        final /* synthetic */ MV f262a;

        C02624(MV mv) {
            this.f262a = mv;
        }

        public void onCancel(DialogInterface dialog) {
            dialog.dismiss();
            this.f262a.m2050a("storePicture", "User has canceled.");
            if (this.f262a.f641e != null) {
                this.f262a.f641e.onCloseListener();
            }
            this.f262a.m2051a(true);
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.MV.5 */
    class C02635 implements ValueCallback<String> {
        final /* synthetic */ MV f263a;

        C02635(MV mv) {
            this.f263a = mv;
        }

        public /* synthetic */ void onReceiveValue(Object x0) {
            m911a((String) x0);
        }

        public void m911a(String str) {
            Util.m929a("Value received: " + str);
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.MV.6 */
    class C02646 implements Runnable {
        final /* synthetic */ String f264a;
        final /* synthetic */ MV f265b;

        C02646(MV mv, String str) {
            this.f265b = mv;
            this.f264a = str;
        }

        public void run() {
            if (VERSION.SDK_INT > 18) {
                this.f265b.evaluateJavascript(this.f264a, this.f265b.f639c);
            } else {
                this.f265b.loadUrl("javascript:" + this.f264a);
            }
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.MV.7 */
    class C02657 implements Runnable {
        final /* synthetic */ String f266a;
        final /* synthetic */ MV f267b;

        C02657(MV mv, String str) {
            this.f267b = mv;
            this.f266a = str;
        }

        public void run() {
            try {
                Log.i(IM.TAG, "Sending event: ");
                if (this.f267b.f660x.isErrorReporting() || !this.f266a.equals(IM.MRAID_EVENT_ERROR)) {
                    String impression_url = this.f267b.f660x.getImpression_url();
                    if (impression_url.contains("%event%")) {
                        impression_url = impression_url.replace("%event%", this.f266a);
                    }
                    Util.m929a("URL: " + impression_url);
                    HttpClient defaultHttpClient = new DefaultHttpClient();
                    HttpUriRequest httpPost = new HttpPost(impression_url);
                    HttpParams basicHttpParams = new BasicHttpParams();
                    httpPost.setParams(basicHttpParams);
                    HttpConnectionParams.setConnectionTimeout(basicHttpParams, 15000);
                    HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
                    HttpResponse execute = defaultHttpClient.execute(httpPost);
                    int statusCode = execute == null ? 0 : execute.getStatusLine().getStatusCode();
                    Log.i(IM.TAG, "Status code: " + statusCode);
                    if (statusCode == 200) {
                        Log.i(IM.TAG, "MRAID Data: " + EntityUtils.toString(execute.getEntity()));
                        return;
                    }
                    return;
                }
                Util.m929a("Error reporting is off.");
            } catch (Exception e) {
                Log.e(IM.TAG, "Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static class MraidAdUtil {
        private String f280a;
        private String f281b;
        private String f282c;
        private boolean f283d;
        private boolean f284e;

        public MraidAdUtil() {
            this.f280a = "";
            this.f283d = false;
        }

        public String getResizeProperties() {
            return this.f280a;
        }

        public void setResizeProperties(String resizeProperties) {
            this.f280a = resizeProperties;
        }

        public String getExpandProperties() {
            return this.f281b;
        }

        public void setExpandProperties(String expandProperties) {
            this.f281b = expandProperties;
        }

        public String getForceOrientation() {
            return this.f282c;
        }

        public void setForceOrientation(String forceOrientation) {
            this.f282c = forceOrientation;
        }

        public void setOrientationChange(boolean orientationChange) {
            this.f284e = orientationChange;
        }

        public boolean isOrientationChange() {
            return this.f284e;
        }

        public void setUseCustomClose(boolean useCustomClose) {
            this.f283d = useCustomClose;
        }

        public boolean isUseCustomClose() {
            return this.f283d;
        }

        public int getGravity(String position) {
            if (position.equals(IM.CUSTOM_CLOSE_POSITION_TOP_RIGHT)) {
                return 53;
            }
            if (position.equals(IM.CUSTOM_CLOSE_POSITION_BOTTOM_CENTER)) {
                return 81;
            }
            if (position.equals(IM.CUSTOM_CLOSE_POSITION_BOTTOM_LEFT)) {
                return 83;
            }
            if (position.equals(IM.CUSTOM_CLOSE_POSITION_BOTTOM_RIGHT)) {
                return 85;
            }
            if (position.equals(IM.CUSTOM_CLOSE_POSITION_CENTER)) {
                return 17;
            }
            if (position.equals(IM.CUSTOM_CLOSE_POSITION_TOP_CENTER)) {
                return 49;
            }
            if (position.equals(IM.CUSTOM_CLOSE_POSITION_TOP_LEFT)) {
                return 51;
            }
            return 53;
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.MV.a */
    class C0273a {
        boolean f285a;
        final /* synthetic */ MV f286b;

        C0273a(MV mv) {
            this.f286b = mv;
            this.f285a = false;
        }

        String m912a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(IM.WIDTH, this.f286b.f647k);
                jSONObject.put(IM.HEIGHT, this.f286b.f648l);
                jSONObject.put(IM.USE_CUSTOM_CLOSE, this.f285a);
                jSONObject.put(IM.IS_MODAL, true);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject.toString();
        }

        void m913a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f286b.f645i = jSONObject.isNull(IM.WIDTH) ? this.f286b.f647k : jSONObject.getInt(IM.WIDTH);
                this.f286b.f646j = jSONObject.isNull(IM.HEIGHT) ? this.f286b.f648l : jSONObject.getInt(IM.HEIGHT);
                this.f285a = jSONObject.isNull(IM.USE_CUSTOM_CLOSE) ? false : jSONObject.getBoolean(IM.USE_CUSTOM_CLOSE);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                this.f286b.m2050a("setExpandProperties", "An error occured while parsing expand properties json;");
            }
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.MV.b */
    private class C0276b extends WebChromeClient {
        final /* synthetic */ MV f289a;

        /* renamed from: com.sxnyodot.uefqvmio207964.MV.b.1 */
        class C02741 implements OnCompletionListener {
            final /* synthetic */ C0276b f287a;

            C02741(C0276b c0276b) {
                this.f287a = c0276b;
            }

            public void onCompletion(MediaPlayer player) {
                try {
                    player.stop();
                    this.f287a.f289a.m2057d(IM.MRAID_EVENT_INLINE_VIDEO);
                    this.f287a.f289a.m2051a(true);
                } catch (Exception e) {
                }
            }
        }

        /* renamed from: com.sxnyodot.uefqvmio207964.MV.b.2 */
        class C02752 implements OnErrorListener {
            final /* synthetic */ C0276b f288a;

            C02752(C0276b c0276b) {
                this.f288a = c0276b;
            }

            public boolean onError(MediaPlayer mp, int what, int extra) {
                this.f288a.f289a.m2057d(IM.MRAID_EVENT_ERROR);
                this.f288a.f289a.m2051a(true);
                return false;
            }
        }

        private C0276b(MV mv) {
            this.f289a = mv;
        }

        public void onShowCustomView(View view, CustomViewCallback callback) {
            super.onShowCustomView(view, callback);
            if (view instanceof FrameLayout) {
                FrameLayout frameLayout = (FrameLayout) view;
                if (frameLayout.getFocusedChild() instanceof VideoView) {
                    this.f289a.f656t = (VideoView) ((FrameLayout) view).getFocusedChild();
                    frameLayout.removeView(this.f289a.f656t);
                    ((ViewGroup) this.f289a.getParent()).addView(this.f289a.f656t);
                    this.f289a.f656t.setOnCompletionListener(new C02741(this));
                    this.f289a.f656t.setOnErrorListener(new C02752(this));
                    this.f289a.f656t.start();
                    this.f289a.m2051a(false);
                }
            }
        }

        public void onHideCustomView() {
            if (this.f289a.f656t != null) {
                ((ViewGroup) this.f289a.getParent()).removeView(this.f289a.f656t);
                if (this.f289a.f656t.isPlaying()) {
                    this.f289a.f656t.stopPlayback();
                }
            }
            this.f289a.m2051a(true);
        }
    }

    /* renamed from: com.sxnyodot.uefqvmio207964.MV.c */
    class C0277c extends WebViewClient {
        boolean f290a;
        final /* synthetic */ MV f291b;

        C0277c(MV mv) {
            this.f291b = mv;
            this.f290a = false;
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (!this.f290a) {
                if (this.f291b.f650n == null || !(this.f291b.f650n == IM.STATE_EXPANDED || this.f291b.f650n == IM.STATE_RESIZED)) {
                    this.f291b.m2060g();
                }
                if (this.f291b.f641e != null) {
                    this.f291b.f641e.onAdLoadedListener();
                }
                this.f291b.m2046j();
            }
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            this.f290a = true;
            super.onReceivedError(view, errorCode, description, failingUrl);
            if (this.f291b.f641e != null) {
                this.f291b.f641e.onErrorListener(description);
            }
            if (this.f291b.f642f != null) {
                this.f291b.f642f.sendEmptyMessage(-4);
            }
        }
    }

    public class JavaScriptInterface extends C0557l {

        /* renamed from: com.sxnyodot.uefqvmio207964.MV.JavaScriptInterface.1 */
        class C02661 implements Runnable {
            final /* synthetic */ String f268a;
            final /* synthetic */ JavaScriptInterface f269b;

            C02661(JavaScriptInterface javaScriptInterface, String str) {
                this.f269b = javaScriptInterface;
                this.f268a = str;
            }

            public void run() {
                MV.this.expand(this.f268a);
            }
        }

        /* renamed from: com.sxnyodot.uefqvmio207964.MV.JavaScriptInterface.2 */
        class C02672 implements Runnable {
            final /* synthetic */ JavaScriptInterface f270a;

            C02672(JavaScriptInterface javaScriptInterface) {
                this.f270a = javaScriptInterface;
            }

            public void run() {
                MV.this.close();
            }
        }

        /* renamed from: com.sxnyodot.uefqvmio207964.MV.JavaScriptInterface.3 */
        class C02683 implements Runnable {
            final /* synthetic */ JavaScriptInterface f271a;

            C02683(JavaScriptInterface javaScriptInterface) {
                this.f271a = javaScriptInterface;
            }

            public void run() {
                MV.this.resize();
            }
        }

        /* renamed from: com.sxnyodot.uefqvmio207964.MV.JavaScriptInterface.4 */
        class C02694 implements Runnable {
            final /* synthetic */ String f272a;
            final /* synthetic */ JavaScriptInterface f273b;

            C02694(JavaScriptInterface javaScriptInterface, String str) {
                this.f273b = javaScriptInterface;
                this.f272a = str;
            }

            public void run() {
                MV.this.playVideo(this.f272a);
            }
        }

        /* renamed from: com.sxnyodot.uefqvmio207964.MV.JavaScriptInterface.5 */
        class C02705 implements Runnable {
            final /* synthetic */ String f274a;
            final /* synthetic */ String f275b;
            final /* synthetic */ JavaScriptInterface f276c;

            C02705(JavaScriptInterface javaScriptInterface, String str, String str2) {
                this.f276c = javaScriptInterface;
                this.f274a = str;
                this.f275b = str2;
            }

            public void run() {
                MV.this.storePicture(this.f274a, this.f275b);
            }
        }

        /* renamed from: com.sxnyodot.uefqvmio207964.MV.JavaScriptInterface.6 */
        class C02716 implements Runnable {
            final /* synthetic */ String f277a;
            final /* synthetic */ JavaScriptInterface f278b;

            C02716(JavaScriptInterface javaScriptInterface, String str) {
                this.f278b = javaScriptInterface;
                this.f277a = str;
            }

            public void run() {
                MV.this.createCalendarEvent(this.f277a);
            }
        }

        /* renamed from: com.sxnyodot.uefqvmio207964.MV.JavaScriptInterface.7 */
        class C02727 implements Runnable {
            final /* synthetic */ JavaScriptInterface f279a;

            C02727(JavaScriptInterface javaScriptInterface) {
                this.f279a = javaScriptInterface;
            }

            public void run() {
                MV.this.m2059f();
            }
        }

        @JavascriptInterface
        public void printJSLog(String log) {
            Log.i(IM.TAG, "JS Log: " + log);
        }

        @JavascriptInterface
        public void expand() {
            expand("");
        }

        @JavascriptInterface
        public void expand(String url) {
            MV.this.post(new C02661(this, url));
        }

        @JavascriptInterface
        public void close() {
            MV.this.post(new C02672(this));
        }

        @JavascriptInterface
        public void open(String url) {
            if (MV.this.f641e != null) {
                MV.this.f641e.onAdClickListener();
            }
            Intent intent = new Intent(MV.this.getContext(), BrowserActivity.class);
            intent.setAction("browser");
            intent.addFlags(268435456);
            intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
            intent.putExtra(PlusShare.KEY_CALL_TO_ACTION_URL, url);
            try {
                MV.this.getContext().startActivity(intent);
                MV.this.m2057d(IM.MRAID_EVENT_OPEN);
            } catch (ActivityNotFoundException e) {
                Log.e(IM.TAG, "Required BrowserActivty is not added in manifest please add.");
                if (MV.this.f641e != null) {
                    MV.this.f641e.onErrorListener("Required BrowserActivty is not added in manifest please add.");
                }
                MV.this.m2057d(IM.MRAID_EVENT_ERROR);
            }
            MV.this.m2051a(true);
        }

        @JavascriptInterface
        public void setExpandProperties(String json) {
            Util.m929a("Expand Json: " + json);
            if (MV.this.f649m != null) {
                MV.this.f649m.m913a(json);
                return;
            }
            MV.this.f649m = new C0273a(MV.this);
            MV.this.f649m.m913a(json);
        }

        @JavascriptInterface
        public void setResizeProperties(String properties) {
            if (MV.this.f657u != null) {
                MV.this.f657u.setResizeProperties(properties);
            }
        }

        @JavascriptInterface
        public void resize() {
            MV.this.post(new C02683(this));
        }

        @JavascriptInterface
        public void playVideo(String url) {
            MV.this.post(new C02694(this, url));
        }

        @JavascriptInterface
        public void storePicture(String url, String fileName) {
            MV.this.post(new C02705(this, url, fileName));
        }

        @JavascriptInterface
        public void createCalendarEvent(String json) {
            MV.this.post(new C02716(this, json));
        }

        @JavascriptInterface
        public void setOrientationProperties(String json) {
            Util.m929a("Orientation json: " + json);
            String str = IM.ORIENTATION_NONE;
            try {
                JSONObject jSONObject = new JSONObject(json);
                boolean z = jSONObject.isNull(IM.ALLOW_ORIENTATION_CHANGE) ? true : jSONObject.getBoolean(IM.ALLOW_ORIENTATION_CHANGE);
                if (jSONObject.isNull(IM.FORCE_ORIENTATION)) {
                    str = IM.ORIENTATION_NONE;
                } else {
                    str = jSONObject.getString(IM.FORCE_ORIENTATION);
                }
                MV.this.f657u.setForceOrientation(str);
                MV.this.f657u.setOrientationChange(z);
                MV.this.post(new C02727(this));
            } catch (Exception e) {
                MV.this.m2050a("setOrientationProperties", "Error occured in while parsing orientation json.");
            }
        }

        @JavascriptInterface
        public void showDialer(String phoneNumber) {
            Log.i(IM.TAG, "Showing dialer.....");
            try {
                if (MV.this.f641e != null) {
                    MV.this.f641e.onAdClickListener();
                }
                if (phoneNumber == null || phoneNumber.equals("")) {
                    MV.this.m2050a("showDialer", "Phone numer is null.");
                    return;
                }
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + phoneNumber));
                intent.addFlags(268435456);
                intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                MV.this.getContext().startActivity(intent);
                MV.this.m2057d(IM.MRAID_EVENT_TEL);
                MV.this.m2051a(true);
            } catch (ActivityNotFoundException e) {
                MV.this.m2050a("showDialer", "Error occurred while dialing number.");
                Log.e(IM.TAG, "Error whlie displaying push ad......: " + e.getMessage());
                MV.this.m2057d(IM.MRAID_EVENT_ERROR);
            }
        }

        @JavascriptInterface
        public void sendSms(String number, String sms_text) {
            Log.i(IM.TAG, "Sending SMS.....");
            try {
                if (MV.this.f641e != null) {
                    MV.this.f641e.onAdClickListener();
                }
                if (number == null || number.equals("")) {
                    MV.this.m2050a("sendSms", "Numer is null.");
                } else if (sms_text == null || sms_text.equals("")) {
                    MV.this.m2050a("sendSms", "SMS text is null.");
                } else {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addFlags(268435456);
                    intent.setType("vnd.android-dir/mms-sms");
                    intent.putExtra("address", number);
                    intent.putExtra("sms_body", sms_text);
                    MV.this.getContext().startActivity(intent);
                    MV.this.m2057d(IM.MRAID_EVENT_SMS);
                    MV.this.m2051a(true);
                }
            } catch (Exception e) {
                Log.e(IM.TAG, "Error whlie displaying push ad......: " + e.getMessage());
                MV.this.m2050a("sendSms", "Error occurred while sending message");
                MV.this.m2057d(IM.EVENT_ERROR);
            }
        }

        @JavascriptInterface
        public void downloadApp(String url) {
            try {
                if (MV.this.f641e != null) {
                    MV.this.f641e.onAdClickListener();
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
                intent.setFlags(268435456);
                intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                MV.this.getContext().startActivity(intent);
                MV.this.m2057d(IM.MRAID_EVENT_DOWNLOAD_APP);
            } catch (Exception e) {
                Log.e(IM.TAG, "Error whlie displaying App......: " + e.getMessage());
                MV.this.m2050a("downloadApp", "Error occurred while redirecting to market.");
                MV.this.m2057d(IM.EVENT_ERROR);
            }
            MV.this.m2051a(true);
        }

        @JavascriptInterface
        public void showLocation(String latitude, String longitude) {
            try {
                if (MV.this.f641e != null) {
                    MV.this.f641e.onAdClickListener();
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format(Locale.ENGLISH, "geo:%f,%f", new Object[]{latitude, longitude})));
                intent.setFlags(268435456);
                intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                MV.this.getContext().startActivity(intent);
                MV.this.m2057d(IM.MRAID_EVENT_SHOW_LOCATION);
            } catch (Exception e) {
                Log.e(IM.TAG, "Error occurred whlie displaying Location......: " + e.getMessage());
                MV.this.m2050a("showLoaction", "Error occurred while showing location.");
                MV.this.m2057d(IM.EVENT_ERROR);
            }
            MV.this.m2051a(true);
        }
    }

    @SuppressLint({"InlinedApi"})
    public MV(Context context, ParseMraidJson parseMraidJson, Handler handler) {
        super(context);
        this.f638b = false;
        this.f639c = new C02635(this);
        try {
            if (VERSION.SDK_INT >= 11 && (context instanceof Activity)) {
                ((Activity) context).getWindow().setFlags(ViewCompat.MEASURED_STATE_TOO_SMALL, ViewCompat.MEASURED_STATE_TOO_SMALL);
            }
        } catch (Throwable th) {
        }
        try {
            this.f658v = parseMraidJson.getAd_url();
            this.f642f = handler;
            this.f657u = new MraidAdUtil();
            this.f644h = context.getResources().getDisplayMetrics();
            this.f652p = this.f644h.density;
            try {
                this.f647k = (int) Util.m935b((float) this.f645i, getContext());
                this.f648l = (int) Util.m935b((float) this.f646j, getContext());
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f649m = new C0273a(this);
            this.f660x = parseMraidJson;
            m2042h();
            this.f649m.m912a();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @SuppressLint({"InlinedApi"})
    public MV(Context context, AdView adView, BannerAdListener adListener, Handler handler, C0249a animationDrawListener) {
        super(context);
        this.f638b = false;
        this.f639c = new C02635(this);
        try {
            if (VERSION.SDK_INT >= 11 && (getContext() instanceof Activity)) {
                ((Activity) getContext()).getWindow().setFlags(ViewCompat.MEASURED_STATE_TOO_SMALL, ViewCompat.MEASURED_STATE_TOO_SMALL);
            }
        } catch (Throwable th) {
        }
        this.f661y = animationDrawListener;
        f637a = this;
        this.f660x = adView.f133e;
        this.f640d = adView;
        this.f641e = adListener;
        this.f642f = handler;
        this.f658v = this.f660x.getAd_url();
        this.f638b = adView.m875a();
        this.f657u = new MraidAdUtil();
        this.f643g = adView.getPlacementType();
        this.f644h = context.getResources().getDisplayMetrics();
        this.f652p = this.f644h.density;
        this.f645i = this.f644h.widthPixels;
        this.f646j = this.f644h.heightPixels;
        try {
            this.f647k = (int) Util.m935b((float) this.f645i, getContext());
            this.f648l = (int) Util.m935b((float) this.f646j, getContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Util.m929a("Device Width:" + this.f645i + ", Device Height:" + this.f646j);
        this.f649m = new C0273a(this);
        setLayoutParams(new LayoutParams(adView.getadWidth(), adView.getadHeight()));
        m2042h();
        this.f649m.m912a();
    }

    @SuppressLint({"SetJavaScriptEnabled", "InlinedApi"})
    private void m2042h() {
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setScrollBarStyle(33554432);
        setBackgroundColor(0);
        setWebChromeClient(new C0276b());
        WebSettings settings = getSettings();
        settings.setRenderPriority(RenderPriority.HIGH);
        settings.setCacheMode(2);
        settings.setLoadWithOverviewMode(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setUseWideViewPort(false);
        settings.setJavaScriptEnabled(true);
        addJavascriptInterface(new JavaScriptInterface(), Base64.decodeString("YWlycHVzaF9tcmFpZA=="));
        if (VERSION.SDK_INT >= 8) {
            settings.setPluginState(PluginState.ON);
        }
        setWebViewClient(new C0277c(this));
        m2055c(this.f658v);
        if (this.f641e != null) {
            this.f641e.onAdLoadingListener();
        }
    }

    void m2055c(String str) {
        m2049a(Util.m983r(getContext()));
        if (str != null && str.endsWith(".js")) {
            int lastIndexOf = str.lastIndexOf("/");
            loadDataWithBaseURL(str.substring(0, lastIndexOf - 1), "<html><head><script type=\"text/javascript\" src=\"" + str.substring(lastIndexOf, str.length() - 1) + "\"/>" + "</head><body></body></html>", "text/html", "utf-8", null);
        } else if (this.f660x.isInlineScript()) {
            if (this.f660x.getTag() == null || this.f660x.getTag().equals("")) {
                Log.e(IM.TAG, "Tag data is null");
                return;
            }
            r0 = new StringBuilder();
            r0.append("<style>* {margin:0;padding:0;;}</style>\n");
            r0.append(this.f660x.getTag());
            loadDataWithBaseURL(null, r0.toString(), "text/html", "utf-8", null);
        } else if (this.f660x.isJsAd()) {
            if (this.f660x.getTag() == null || this.f660x.getTag().equals("")) {
                Log.e(IM.TAG, "Tag data is null");
                return;
            }
            r0 = new StringBuilder();
            r0.append("<html><head>\n");
            r0.append(this.f660x.getTag());
            r0.append("\n<style>* {margin:0;padding:0;}</style></head><body>");
            r0.append("</body></html>");
            loadDataWithBaseURL(null, r0.toString(), "text/html", "UTF-8", null);
        } else if (this.f660x.isHtmlAd()) {
            if (this.f660x.getTag() == null || this.f660x.getTag().equals("")) {
                Log.e(IM.TAG, "tag data is null");
                return;
            }
            r0 = new StringBuilder();
            r0.append("<html><head><style>* {margin:0;padding:0;;}</style></head><body>\n");
            r0.append(this.f660x.getTag());
            r0.append("\n</body></html>");
            loadDataWithBaseURL(null, r0.toString(), "text/html", "UTF-8", null);
        } else if (str == null || str.equals("")) {
            Log.e(IM.TAG, "Invalid url: " + str);
        } else {
            loadUrl(str);
        }
    }

    void m2060g() {
        m2049a("mraid.setPlacementType('" + this.f643g + "');");
        Util.m929a("SDK LOG: display Ad called.");
        m2049a("mraid.setExpandProperties(" + this.f649m.m912a() + ");");
        m2044i();
        setState(IM.STATE_DEFAULT);
        m2053b(IM.EVENT_READY);
        if (this.f642f != null) {
            this.f642f.sendEmptyMessage(0);
            onAnimationEnd();
        }
        m2052b();
        Log.i(IM.TAG, "Sending impression data:>");
        m2057d(IM.MRAID_EVENT_IMPRESSION);
    }

    private void m2044i() {
        boolean z;
        if (this.f651o && getVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z != this.f659w && this.f650n == IM.STATE_DEFAULT) {
            this.f659w = z;
            setViewable(this.f659w);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f651o = true;
        m2044i();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f651o = false;
        m2044i();
    }

    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        m2044i();
    }

    public void loadUrl(String url) {
        Util.m929a("Loading url: " + url);
        super.loadUrl(url);
    }

    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        super.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
        if (this.f641e != null) {
            this.f641e.onAdLoadingListener();
        }
    }

    private void m2046j() {
        m2056d();
        m2054c();
        m2058e();
        m2048a();
    }

    protected void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.f661y != null) {
            Util.m929a("Animation end.");
            this.f661y.m844a();
        }
    }

    public void expand(String url) {
        try {
            clearView();
            FrameLayout frameLayout = (FrameLayout) getRootView().findViewById(16908290);
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
            View view = new View(getContext());
            view.setLayoutParams(getLayoutParams());
            this.f653q = new FrameLayout(getContext());
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, -1);
            layoutParams2.gravity = 17;
            this.f653q.setLayoutParams(layoutParams2);
            this.f654r = (ViewGroup) getParent();
            if (this.f654r != null) {
                int childCount = this.f654r.getChildCount();
                int i = 0;
                while (i < childCount && this.f654r.getChildAt(i) != this) {
                    i++;
                }
                this.f655s = i;
                setLayoutParams(layoutParams);
                this.f654r.removeView(this);
                this.f653q.addView(this);
                if (!this.f649m.f285a) {
                    View a = m2047a(5);
                    a.setId(111);
                    ViewGroup.LayoutParams layoutParams3 = new LayoutParams(((int) this.f652p) * 50, ((int) this.f652p) * 50);
                    layoutParams3.gravity = 53;
                    a.setLayoutParams(layoutParams3);
                    this.f653q.addView(a);
                }
                frameLayout.addView(this.f653q);
                this.f654r.addView(view, this.f655s);
                this.f654r.setVisibility(8);
                setState(IM.STATE_EXPANDED);
                if (!(url == null || url.equals(""))) {
                    loadUrl(url);
                }
            }
            if (this.f641e != null) {
                this.f641e.onAdExpandedListner();
            }
            if (this.f640d != null) {
                this.f640d.f132d = false;
            }
            m2057d(IM.MRAID_EVENT_EXPAND);
        } catch (Exception e) {
            m2057d(IM.MRAID_EVENT_ERROR);
            e.printStackTrace();
        }
    }

    public void resize() {
        boolean z = true;
        int i = this.f644h.widthPixels;
        int i2 = this.f644h.heightPixels;
        try {
            int i3;
            int i4;
            int i5;
            boolean z2;
            int i6;
            clearView();
            if (this.f657u == null || this.f657u.getResizeProperties().equals("")) {
                i3 = 0;
                i4 = 0;
                i5 = i2;
                z2 = true;
                i6 = i;
                i = 53;
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(this.f657u.getResizeProperties());
                    if (jSONObject.isNull(IM.WIDTH)) {
                        i4 = this.f644h.widthPixels;
                    } else {
                        i4 = (int) Util.m924a((float) jSONObject.getInt(IM.WIDTH), getContext());
                    }
                    if (jSONObject.isNull(IM.HEIGHT)) {
                        i3 = this.f644h.heightPixels;
                    } else {
                        i3 = (int) Util.m924a((float) jSONObject.getInt(IM.HEIGHT), getContext());
                    }
                    String string = jSONObject.isNull(IM.CUSTOM_CLOSE_POSITION) ? IM.CUSTOM_CLOSE_POSITION_TOP_RIGHT : jSONObject.getString(IM.CUSTOM_CLOSE_POSITION);
                    i = jSONObject.isNull(IM.OFF_SET_X) ? 0 : jSONObject.getInt(IM.OFF_SET_X);
                    i2 = jSONObject.isNull(IM.OFF_SET_Y) ? 0 : jSONObject.getInt(IM.OFF_SET_Y);
                    if (!jSONObject.isNull(IM.ALLOW_OFF_SCREEN)) {
                        z = jSONObject.getBoolean(IM.ALLOW_OFF_SCREEN);
                    }
                    int gravity = this.f657u.getGravity(string);
                    i5 = i3;
                    i3 = i2;
                    z2 = z;
                    i6 = i4;
                    i4 = i;
                    i = gravity;
                } catch (Exception e) {
                    if (this.f641e != null) {
                        this.f641e.onErrorListener(e.getMessage());
                    }
                    m2050a("resize", "Error occured while parsing resizeProperties data.");
                    return;
                }
            }
            if (z2) {
                i2 = i6;
                i6 = i5;
            } else {
                int[] a = m2033a(i6, i5);
                i2 = a[0];
                i6 = a[1];
            }
            FrameLayout frameLayout = (FrameLayout) getRootView().findViewById(16908290);
            ViewGroup.LayoutParams layoutParams = new LayoutParams(i2, i6);
            View view = new View(getContext());
            view.setLayoutParams(getLayoutParams());
            this.f653q = new FrameLayout(getContext());
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(i2, i6);
            layoutParams2.leftMargin = i4;
            layoutParams2.topMargin = i3;
            this.f653q.setLayoutParams(layoutParams2);
            this.f654r = (ViewGroup) getParent();
            if (this.f654r != null) {
                i2 = this.f654r.getChildCount();
                i6 = 0;
                while (i6 < i2 && this.f654r.getChildAt(i6) != this) {
                    i6++;
                }
                this.f655s = i6;
                setLayoutParams(layoutParams);
                this.f654r.removeView(this);
                this.f653q.addView(this);
                try {
                    View linearLayout = new LinearLayout(getContext());
                    ViewGroup.LayoutParams layoutParams3 = new LayoutParams((int) (this.f652p * 50.0f), (int) (this.f652p * 50.0f));
                    layoutParams3.gravity = i;
                    linearLayout.setLayoutParams(layoutParams3);
                    linearLayout.setGravity(i);
                    this.f653q.addView(linearLayout);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                frameLayout.addView(this.f653q);
                this.f654r.addView(view, this.f655s);
                this.f654r.setVisibility(8);
                setState(IM.STATE_RESIZED);
                m2053b(IM.EVENT_SIZE_CHANGE);
            }
            if (this.f641e != null) {
                this.f641e.onAdExpandedListner();
            }
            if (this.f640d != null) {
                this.f640d.f132d = false;
            }
            m2057d(IM.MRAID_EVENT_RESIZE);
        } catch (Exception e3) {
            m2057d(IM.MRAID_EVENT_ERROR);
            e3.printStackTrace();
        }
    }

    private int[] m2033a(int i, int i2) {
        if (i > this.f645i || i2 > this.f646j) {
            float f = ((float) i2) / ((float) i);
            if (((int) (((float) (i - this.f645i)) * f)) > ((int) (((float) (i2 - this.f646j)) * f))) {
                i = this.f645i;
                i2 = (int) (f * ((float) i));
            } else {
                i2 = this.f645i;
                i = (int) (((float) i2) / f);
            }
        }
        return new int[]{i, i2};
    }

    private void setButtonBackground(Button button) {
        if (button != null) {
            try {
                Class cls = Class.forName("com.android.internal.R$drawable");
                button.setBackgroundResource(cls.getField("ic_menu_close_clear_cancel").getInt(cls));
            } catch (Exception e) {
                button.setText("Close");
                button.setTypeface(null, 1);
                button.setBackgroundColor(0);
            }
        }
    }

    Button m2047a(int i) {
        Button button = new Button(getContext());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams((int) (this.f652p * 50.0f), (int) (this.f652p * 50.0f));
        button.setGravity(i);
        button.setLayoutParams(layoutParams);
        setButtonBackground(button);
        button.setOnClickListener(new C02551(this));
        return button;
    }

    public void close() {
        try {
            if (this.f640d != null) {
                this.f640d.f132d = true;
            }
            if (this.f650n.equals(IM.STATE_EXPANDED)) {
                if (!(this.f653q == null || this.f654r == null)) {
                    ((ViewGroup) this.f653q.getParent()).removeView(this.f653q);
                    this.f653q.removeView(this);
                    setLayoutParams(this.f654r.getChildAt(this.f655s).getLayoutParams());
                    this.f654r.removeViewAt(this.f655s);
                    this.f654r.setVisibility(0);
                }
                setState(IM.STATE_DEFAULT);
                if (this.f640d != null) {
                    this.f640d.getAd();
                }
            } else if (this.f650n.equals(IM.STATE_DEFAULT)) {
                ((ViewGroup) getParent()).setVisibility(8);
                setState(IM.STATE_HIDDEN);
                if (this.f642f != null) {
                    this.f642f.sendEmptyMessage(-3);
                }
            } else if (this.f650n.equals(IM.STATE_RESIZED)) {
                if (!(this.f653q == null || this.f654r == null)) {
                    ((ViewGroup) this.f653q.getParent()).removeView(this.f653q);
                    this.f653q.removeView(this);
                    setLayoutParams(this.f654r.getChildAt(this.f655s).getLayoutParams());
                    this.f654r.removeViewAt(this.f655s);
                    this.f654r.setVisibility(0);
                }
                setState(IM.STATE_DEFAULT);
                if (this.f640d != null) {
                    this.f640d.getAd();
                }
            } else {
                ((ViewGroup) getParent()).setVisibility(8);
                setState(IM.STATE_HIDDEN);
                if (this.f642f != null) {
                    this.f642f.sendEmptyMessage(-3);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.f641e != null) {
            this.f641e.onCloseListener();
        }
    }

    public void createCalendarEvent(String jsonString) {
        m2051a(false);
        Util.m929a("SDK LOG: inside createCalendarEvent: " + jsonString);
        if (this.f641e != null) {
            this.f641e.onAdClickListener();
        }
        if (jsonString != null) {
            try {
                if (!jsonString.equals("")) {
                    Intent intent = new Intent(getContext(), BrowserActivity.class);
                    intent.setAction("newCalendarEvent");
                    intent.addFlags(268435456);
                    intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
                    intent.putExtra("json", jsonString);
                    getContext().startActivity(intent);
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                m2057d(IM.MRAID_EVENT_ERROR);
                m2050a("createCalendarEvent", "Error occured in createCalenderEvent.");
                Log.e(IM.TAG, "Error occured in createCalenderEvent.");
                return;
            }
        }
        m2050a("createCalendarEvent", "Calender method called with empty json.");
        Log.e(IM.TAG, "Error occured while creating calendar event.");
    }

    public void playVideo(String url) {
        m2051a(false);
        try {
            if (this.f641e != null) {
                this.f641e.onAdClickListener();
            }
            Intent intent = new Intent(getContext(), BrowserActivity.class);
            intent.setAction("playVideo");
            intent.putExtra(PlusShare.KEY_CALL_TO_ACTION_URL, url);
            intent.addFlags(GravityCompat.RELATIVE_LAYOUT_DIRECTION);
            intent.addFlags(268435456);
            getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            m2057d(IM.MRAID_EVENT_ERROR);
        }
    }

    public void storePicture(String imageURL, String fileNameWithExt) {
        m2051a(false);
        try {
            if (this.f641e != null) {
                this.f641e.onAdClickListener();
            }
            if (imageURL == null || imageURL.equals("")) {
                m2050a("storePicture", "Image url is null.");
            } else if (fileNameWithExt == null || fileNameWithExt.equals("")) {
                m2050a("storePicture", "File name is null.");
            } else if (getContext() instanceof Activity) {
                Builder builder = new Builder(getContext());
                builder.setMessage("This image will be added in gallery. Please confirm ?");
                builder.setPositiveButton("Yes", new C02602(this, imageURL, fileNameWithExt));
                builder.setNegativeButton("No", new C02613(this));
                builder.setOnCancelListener(new C02624(this));
                builder.setCancelable(false);
                builder.show();
            }
        } catch (Exception e) {
            m2050a("storePicture", "Error occured while storing picture.");
            m2057d(IM.EVENT_ERROR);
            if (this.f641e != null) {
                this.f641e.onCloseListener();
            }
            m2051a(true);
        }
    }

    public void m2053b(String str) {
        m2049a("mraid.triggerEvent('" + str + "');");
    }

    public void m2050a(String str, String str2) {
        m2049a("mraid.triggerErrorEvent(" + str + ",'" + str2 + "');");
        if (!this.f638b) {
            m2057d(IM.EVENT_ERROR);
        }
    }

    public void m2048a() {
        try {
            int x;
            int b = (int) Util.m935b((float) getWidth(), getContext());
            int b2 = (int) Util.m935b((float) getHeight(), getContext());
            int left = getLeft();
            if (VERSION.SDK_INT > 10) {
                x = (int) getX();
            } else {
                x = left;
            }
            left = getTop();
            if (VERSION.SDK_INT > 10) {
                left = (int) getY();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("x", x);
            jSONObject.put("y", left);
            jSONObject.put(IM.WIDTH, b);
            jSONObject.put(IM.HEIGHT, b2);
            m2049a("mraid.setCurrentPosition(" + jSONObject + ");");
        } catch (Exception e) {
            m2050a("setCurrentPosition", "Error occured while setting current position.");
            e.printStackTrace();
        }
    }

    public void m2052b() {
        try {
            int x;
            int b = (int) Util.m935b((float) getWidth(), getContext());
            int b2 = (int) Util.m935b((float) getHeight(), getContext());
            int left = getLeft();
            if (VERSION.SDK_INT > 10) {
                x = (int) getX();
            } else {
                x = left;
            }
            left = getTop();
            if (VERSION.SDK_INT > 10) {
                left = (int) getY();
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("x", x);
            jSONObject.put("y", left);
            jSONObject.put(IM.WIDTH, b);
            jSONObject.put(IM.HEIGHT, b2);
            m2049a("mraid.setDefaultPosition(" + jSONObject + ");");
        } catch (Exception e) {
            m2050a("setDefaultPosition", "Error occured while setting default position.");
            e.printStackTrace();
        }
    }

    public void m2054c() {
        try {
            int i = this.f647k;
            int b = (int) Util.m935b((float) (this.f644h.heightPixels - getTokenSize()), getContext());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IM.WIDTH, i);
            jSONObject.put(IM.HEIGHT, b);
            m2049a("mraid.setMaxSize(" + jSONObject + ");");
        } catch (Exception e) {
            m2050a("setMaxSize", "Error occured while setting max size.");
            e.printStackTrace();
        }
    }

    private int getTokenSize() {
        Rect rect = new Rect();
        Window window = ((Activity) getContext()).getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        int top = window.findViewById(16908290).getTop() - i;
        Util.m929a("StatusBar Height= " + i + " , TitleBar Height = " + top);
        return top + i;
    }

    public void m2056d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IM.WIDTH, this.f647k);
            jSONObject.put(IM.HEIGHT, this.f648l);
            m2049a("mraid.setScreenSize(" + jSONObject + ");");
        } catch (Exception e) {
            m2050a("setScreenSize", "Error occured while setting screen size.");
            e.printStackTrace();
        }
    }

    public void m2059f() {
        try {
            Activity activity = (Activity) getContext();
            String forceOrientation = this.f657u.getForceOrientation();
            Configuration configuration = getResources().getConfiguration();
            boolean isOrientationChange = this.f657u.isOrientationChange();
            if (forceOrientation != null && forceOrientation.equals(IM.ORIENTATION_LANDSCAPE)) {
                activity.setRequestedOrientation(0);
                configuration.orientation = 2;
                activity.onConfigurationChanged(configuration);
                Util.m929a("Orientation cahnged to landscape.");
            } else if (forceOrientation != null && forceOrientation.equals(IM.ORIENTATION_PORTRAIT)) {
                activity.setRequestedOrientation(1);
                Util.m929a("Orientation changed to protrait.");
            } else if (forceOrientation != null) {
                if (forceOrientation.equals(IM.ORIENTATION_NONE)) {
                    activity.setRequestedOrientation(-1);
                    Util.m929a("Orientation changed to none.");
                }
            }
            if (!isOrientationChange) {
                activity.setRequestedOrientation(activity.getRequestedOrientation());
                activity.onConfigurationChanged(configuration);
                Util.m929a("Orientation changed to false.");
            }
            Util.m929a("Orientation saved.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m2058e() {
        JSONObject s = Util.m985s(getContext());
        if (s != null) {
            m2049a("mraid.setSupportedFeatures(" + s + ");");
        } else {
            m2050a("supports", "Error occured in supports.");
        }
    }

    public void m2049a(String str) {
        post(new C02646(this, str));
    }

    public void setState(String state) {
        this.f650n = state;
        m2049a("mraid.setState('" + state + "');");
    }

    public void setViewable(boolean isViewable) {
        m2049a("mraid.setViewable(" + isViewable + ");");
    }

    final void m2057d(String str) {
        synchronized (str) {
            if (this.f638b) {
                Util.m929a("Ad in test mode. Sending ignored.");
            } else if (Util.m977o(getContext())) {
                new Thread(new C02657(this, str), "mraid_event").start();
            }
        }
    }

    void m2051a(boolean z) {
        if (this.f640d == null) {
            return;
        }
        if (!z || this.f650n == null || (this.f650n.equalsIgnoreCase(IM.STATE_EXPANDED) && this.f650n.equalsIgnoreCase(IM.STATE_RESIZED))) {
            this.f640d.f132d = false;
            return;
        }
        this.f640d.f132d = true;
        if (this.f643g != null && this.f643g.equals(IM.PLACEMENT_TYPE_INLINE) && this.f640d != null) {
            this.f640d.getAd();
        }
    }
}
