package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.widget.ExploreByTouchHelper;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.sxnyodot.uefqvmio207964.C0304k;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public final class cq extends WebView implements DownloadListener {
    private final Object eJ;
    private C0470x fg;
    private final C0152h go;
    private final cr hT;
    private final MutableContextWrapper hU;
    private final co hV;
    private bf hW;
    private boolean hX;
    private boolean hY;

    private cq(MutableContextWrapper mutableContextWrapper, C0470x c0470x, boolean z, boolean z2, C0152h c0152h, co coVar) {
        super(mutableContextWrapper);
        this.eJ = new Object();
        this.hU = mutableContextWrapper;
        this.fg = c0470x;
        this.hX = z;
        this.go = c0152h;
        this.hV = coVar;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        ci.m261a((Context) mutableContextWrapper, coVar.hP, settings);
        if (VERSION.SDK_INT >= 17) {
            ck.m284a(getContext(), settings);
        } else if (VERSION.SDK_INT >= 11) {
            cj.m278a(getContext(), settings);
        }
        setDownloadListener(this);
        if (VERSION.SDK_INT >= 11) {
            this.hT = new ct(this, z2);
        } else {
            this.hT = new cr(this, z2);
        }
        setWebViewClient(this.hT);
        if (VERSION.SDK_INT >= 14) {
            setWebChromeClient(new cu(this));
        } else if (VERSION.SDK_INT >= 11) {
            setWebChromeClient(new cs(this));
        }
        aA();
    }

    public static cq m303a(Context context, C0470x c0470x, boolean z, boolean z2, C0152h c0152h, co coVar) {
        return new cq(new MutableContextWrapper(context), c0470x, z, z2, c0152h, coVar);
    }

    private void aA() {
        synchronized (this.eJ) {
            if (this.hX || this.fg.ex) {
                if (VERSION.SDK_INT < 14) {
                    cn.m295m("Disabling hardware acceleration on an overlay.");
                    aB();
                } else {
                    cn.m295m("Enabling hardware acceleration on an overlay.");
                    aC();
                }
            } else if (VERSION.SDK_INT < 18) {
                cn.m295m("Disabling hardware acceleration on an AdView.");
                aB();
            } else {
                cn.m295m("Enabling hardware acceleration on an AdView.");
                aC();
            }
        }
    }

    private void aB() {
        synchronized (this.eJ) {
            if (!this.hY && VERSION.SDK_INT >= 11) {
                cj.m282c(this);
            }
            this.hY = true;
        }
    }

    private void aC() {
        synchronized (this.eJ) {
            if (this.hY && VERSION.SDK_INT >= 11) {
                cj.m283d(this);
            }
            this.hY = false;
        }
    }

    public void m304a(Context context, C0470x c0470x) {
        synchronized (this.eJ) {
            this.hU.setBaseContext(context);
            this.hW = null;
            this.fg = c0470x;
            this.hX = false;
            ci.m269b(this);
            loadUrl("about:blank");
            this.hT.reset();
        }
    }

    public void m305a(bf bfVar) {
        synchronized (this.eJ) {
            this.hW = bfVar;
        }
    }

    public void m306a(String str, Map<String, ?> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:AFMA_ReceiveMessage('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        if (map != null) {
            try {
                String jSONObject = ci.m277l(map).toString();
                stringBuilder.append(",");
                stringBuilder.append(jSONObject);
            } catch (JSONException e) {
                cn.m299q("Could not convert AFMA event parameters to JSON.");
                return;
            }
        }
        stringBuilder.append(");");
        cn.m298p("Dispatching AFMA event: " + stringBuilder);
        loadUrl(stringBuilder.toString());
    }

    public void as() {
        Map hashMap = new HashMap(1);
        hashMap.put(C0304k.VERSION, this.hV.hP);
        m306a("onhide", hashMap);
    }

    public void at() {
        Map hashMap = new HashMap(1);
        hashMap.put(C0304k.VERSION, this.hV.hP);
        m306a("onshow", hashMap);
    }

    public bf au() {
        bf bfVar;
        synchronized (this.eJ) {
            bfVar = this.hW;
        }
        return bfVar;
    }

    public C0470x av() {
        C0470x c0470x;
        synchronized (this.eJ) {
            c0470x = this.fg;
        }
        return c0470x;
    }

    public cr aw() {
        return this.hT;
    }

    public C0152h ax() {
        return this.go;
    }

    public co ay() {
        return this.hV;
    }

    public boolean az() {
        boolean z;
        synchronized (this.eJ) {
            z = this.hX;
        }
        return z;
    }

    public void m307i(boolean z) {
        synchronized (this.eJ) {
            this.hX = z;
            aA();
        }
    }

    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long size) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(url), mimeType);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            cn.m295m("Couldn't find an Activity to view url/mimetype: " + url + " / " + mimeType);
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = Integer.MAX_VALUE;
        synchronized (this.eJ) {
            if (isInEditMode() || this.hX) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                return;
            }
            int mode = MeasureSpec.getMode(widthMeasureSpec);
            int size = MeasureSpec.getSize(widthMeasureSpec);
            int mode2 = MeasureSpec.getMode(heightMeasureSpec);
            int size2 = MeasureSpec.getSize(heightMeasureSpec);
            mode = (mode == ExploreByTouchHelper.INVALID_ID || mode == 1073741824) ? size : Integer.MAX_VALUE;
            if (mode2 == ExploreByTouchHelper.INVALID_ID || mode2 == 1073741824) {
                i = size2;
            }
            if (this.fg.widthPixels > mode || this.fg.heightPixels > r0) {
                cn.m299q("Not enough space to show ad. Needs " + this.fg.widthPixels + "x" + this.fg.heightPixels + ", but only has " + size + "x" + size2);
                if (getVisibility() != 8) {
                    setVisibility(4);
                }
                setMeasuredDimension(0, 0);
            } else {
                if (getVisibility() != 8) {
                    setVisibility(0);
                }
                setMeasuredDimension(this.fg.widthPixels, this.fg.heightPixels);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.go != null) {
            this.go.m664a(event);
        }
        return super.onTouchEvent(event);
    }

    public void setContext(Context context) {
        this.hU.setBaseContext(context);
    }
}
