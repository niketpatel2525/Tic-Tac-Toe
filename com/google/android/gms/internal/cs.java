package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.location.DetectedActivity;

public class cs extends WebChromeClient {
    private final cq fG;

    /* renamed from: com.google.android.gms.internal.cs.1 */
    static class C01221 implements OnCancelListener {
        final /* synthetic */ JsResult ii;

        C01221(JsResult jsResult) {
            this.ii = jsResult;
        }

        public void onCancel(DialogInterface dialog) {
            this.ii.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.cs.2 */
    static class C01232 implements OnClickListener {
        final /* synthetic */ JsResult ii;

        C01232(JsResult jsResult) {
            this.ii = jsResult;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.ii.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.cs.3 */
    static class C01243 implements OnClickListener {
        final /* synthetic */ JsResult ii;

        C01243(JsResult jsResult) {
            this.ii = jsResult;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.ii.confirm();
        }
    }

    /* renamed from: com.google.android.gms.internal.cs.4 */
    static class C01254 implements OnCancelListener {
        final /* synthetic */ JsPromptResult ij;

        C01254(JsPromptResult jsPromptResult) {
            this.ij = jsPromptResult;
        }

        public void onCancel(DialogInterface dialog) {
            this.ij.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.cs.5 */
    static class C01265 implements OnClickListener {
        final /* synthetic */ JsPromptResult ij;

        C01265(JsPromptResult jsPromptResult) {
            this.ij = jsPromptResult;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.ij.cancel();
        }
    }

    /* renamed from: com.google.android.gms.internal.cs.6 */
    static class C01276 implements OnClickListener {
        final /* synthetic */ JsPromptResult ij;
        final /* synthetic */ EditText ik;

        C01276(JsPromptResult jsPromptResult, EditText editText) {
            this.ij = jsPromptResult;
            this.ik = editText;
        }

        public void onClick(DialogInterface dialog, int which) {
            this.ij.confirm(this.ik.getText().toString());
        }
    }

    /* renamed from: com.google.android.gms.internal.cs.7 */
    static /* synthetic */ class C01287 {
        static final /* synthetic */ int[] il;

        static {
            il = new int[MessageLevel.values().length];
            try {
                il[MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                il[MessageLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                il[MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                il[MessageLevel.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                il[MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public cs(cq cqVar) {
        this.fG = cqVar;
    }

    private static void m321a(Builder builder, String str, JsResult jsResult) {
        builder.setMessage(str).setPositiveButton(17039370, new C01243(jsResult)).setNegativeButton(17039360, new C01232(jsResult)).setOnCancelListener(new C01221(jsResult)).create().show();
    }

    private static void m322a(Context context, Builder builder, String str, String str2, JsPromptResult jsPromptResult) {
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        View textView = new TextView(context);
        textView.setText(str);
        View editText = new EditText(context);
        editText.setText(str2);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        builder.setView(linearLayout).setPositiveButton(17039370, new C01276(jsPromptResult, editText)).setNegativeButton(17039360, new C01265(jsPromptResult)).setOnCancelListener(new C01254(jsPromptResult)).create().show();
    }

    private static boolean m323a(Context context, String str, String str2, String str3, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        Builder builder = new Builder(context);
        builder.setTitle(str);
        if (z) {
            m322a(context, builder, str2, str3, jsPromptResult);
        } else {
            m321a(builder, str2, jsResult);
        }
        return true;
    }

    protected final void m324a(View view, int i, CustomViewCallback customViewCallback) {
        bf au = this.fG.au();
        if (au == null) {
            cn.m299q("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        au.m1797a(view, customViewCallback);
        au.setRequestedOrientation(i);
    }

    public final void onCloseWindow(WebView webView) {
        if (webView instanceof cq) {
            bf au = ((cq) webView).au();
            if (au == null) {
                cn.m299q("Tried to close an AdWebView not associated with an overlay.");
                return;
            } else {
                au.close();
                return;
            }
        }
        cn.m299q("Tried to close a WebView that wasn't an AdWebView.");
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
        switch (C01287.il[consoleMessage.messageLevel().ordinal()]) {
            case DetectedActivity.ON_BICYCLE /*1*/:
                cn.m296n(str);
                break;
            case DetectedActivity.ON_FOOT /*2*/:
                cn.m299q(str);
                break;
            case DetectedActivity.STILL /*3*/:
            case DetectedActivity.UNKNOWN /*4*/:
                cn.m297o(str);
                break;
            case DetectedActivity.TILTING /*5*/:
                cn.m295m(str);
                break;
            default:
                cn.m297o(str);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final void onExceededDatabaseQuota(String url, String databaseIdentifier, long currentQuota, long estimatedSize, long totalUsedQuota, QuotaUpdater quotaUpdater) {
        long j = 5242880 - totalUsedQuota;
        if (j <= 0) {
            quotaUpdater.updateQuota(currentQuota);
            return;
        }
        if (currentQuota == 0) {
            if (estimatedSize > j || estimatedSize > 1048576) {
                estimatedSize = 0;
            }
        } else if (estimatedSize == 0) {
            estimatedSize = Math.min(Math.min(131072, j) + currentQuota, 1048576);
        } else {
            if (estimatedSize <= Math.min(1048576 - currentQuota, j)) {
                currentQuota += estimatedSize;
            }
            estimatedSize = currentQuota;
        }
        quotaUpdater.updateQuota(estimatedSize);
    }

    public final void onHideCustomView() {
        bf au = this.fG.au();
        if (au == null) {
            cn.m299q("Could not get ad overlay when hiding custom view.");
        } else {
            au.m1795R();
        }
    }

    public final boolean onJsAlert(WebView webView, String url, String message, JsResult result) {
        return m323a(webView.getContext(), url, message, null, result, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String url, String message, JsResult result) {
        return m323a(webView.getContext(), url, message, null, result, null, false);
    }

    public final boolean onJsConfirm(WebView webView, String url, String message, JsResult result) {
        return m323a(webView.getContext(), url, message, null, result, null, false);
    }

    public final boolean onJsPrompt(WebView webView, String url, String message, String defaultValue, JsPromptResult result) {
        return m323a(webView.getContext(), url, message, defaultValue, null, result, true);
    }

    public final void onReachedMaxAppCacheSize(long spaceNeeded, long totalUsedQuota, QuotaUpdater quotaUpdater) {
        long j = 131072 + spaceNeeded;
        if (5242880 - totalUsedQuota < j) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j);
        }
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        m324a(view, -1, customViewCallback);
    }
}
