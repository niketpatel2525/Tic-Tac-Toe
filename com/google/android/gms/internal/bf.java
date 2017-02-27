package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.internal.bn.C0399a;
import com.google.android.gms.internal.cr.C0121a;
import com.google.android.gms.location.DetectedActivity;

public final class bf extends C0399a {
    private final Activity fD;
    private bh fE;
    private bj fF;
    private cq fG;
    private C0102b fH;
    private bk fI;
    private FrameLayout fJ;
    private CustomViewCallback fK;
    private boolean fL;
    private boolean fM;
    private RelativeLayout fN;

    /* renamed from: com.google.android.gms.internal.bf.a */
    private static final class C0101a extends Exception {
        public C0101a(String str) {
            super(str);
        }
    }

    /* renamed from: com.google.android.gms.internal.bf.b */
    private static final class C0102b {
        public final LayoutParams fP;
        public final ViewGroup fQ;
        public final int index;

        public C0102b(cq cqVar) throws C0101a {
            this.fP = cqVar.getLayoutParams();
            ViewParent parent = cqVar.getParent();
            if (parent instanceof ViewGroup) {
                this.fQ = (ViewGroup) parent;
                this.index = this.fQ.indexOfChild(cqVar);
                this.fQ.removeView(cqVar);
                cqVar.m307i(true);
                return;
            }
            throw new C0101a("Could not get the parent of the WebView for an overlay.");
        }
    }

    /* renamed from: com.google.android.gms.internal.bf.1 */
    class C03971 implements C0121a {
        final /* synthetic */ bf fO;

        C03971(bf bfVar) {
            this.fO = bfVar;
        }

        public void m1178a(cq cqVar) {
            cqVar.at();
        }
    }

    public bf(Activity activity) {
        this.fL = false;
        this.fM = false;
        this.fD = activity;
    }

    private void m1790T() {
        if (this.fD.isFinishing() && !this.fM) {
            this.fM = true;
            if (this.fD.isFinishing()) {
                if (this.fG != null) {
                    this.fG.as();
                    this.fN.removeView(this.fG);
                    if (this.fH != null) {
                        this.fG.m307i(false);
                        this.fH.fQ.addView(this.fG, this.fH.index, this.fH.fP);
                    }
                }
                if (this.fE != null && this.fE.fT != null) {
                    this.fE.fT.m206B();
                }
            }
        }
    }

    private static RelativeLayout.LayoutParams m1791a(int i, int i2, int i3, int i4) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        return layoutParams;
    }

    public static void m1792a(Context context, bh bhVar) {
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", bhVar.eg.hS);
        bh.m1180a(intent, bhVar);
        intent.addFlags(AccessibilityEventCompat.TYPE_GESTURE_DETECTION_END);
        context.startActivity(intent);
    }

    private void m1793e(boolean z) throws C0101a {
        this.fD.requestWindowFeature(1);
        Window window = this.fD.getWindow();
        window.setFlags(AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT, AccessibilityNodeInfoCompat.ACTION_NEXT_HTML_ELEMENT);
        setRequestedOrientation(this.fE.orientation);
        if (VERSION.SDK_INT >= 11) {
            cn.m295m("Enabling hardware acceleration on the AdActivity window.");
            cj.m279a(window);
        }
        this.fN = new RelativeLayout(this.fD);
        this.fN.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.fD.setContentView(this.fN);
        boolean aD = this.fE.fU.aw().aD();
        if (z) {
            this.fG = cq.m303a(this.fD, this.fE.fU.av(), true, aD, null, this.fE.eg);
            this.fG.aw().m315a(null, null, this.fE.fV, this.fE.fZ, true);
            this.fG.aw().m314a(new C03971(this));
            if (this.fE.fz != null) {
                this.fG.loadUrl(this.fE.fz);
            } else if (this.fE.fY != null) {
                this.fG.loadDataWithBaseURL(this.fE.fW, this.fE.fY, "text/html", "UTF-8", null);
            } else {
                throw new C0101a("No URL or HTML to display in ad overlay.");
            }
        }
        this.fG = this.fE.fU;
        this.fG.setContext(this.fD);
        this.fG.m305a(this);
        this.fN.addView(this.fG, -1, -1);
        if (!z) {
            this.fG.at();
        }
        m1800c(aD);
    }

    public bj m1794Q() {
        return this.fF;
    }

    public void m1795R() {
        if (this.fE != null) {
            setRequestedOrientation(this.fE.orientation);
        }
        if (this.fJ != null) {
            this.fD.setContentView(this.fN);
            this.fJ.removeAllViews();
            this.fJ = null;
        }
        if (this.fK != null) {
            this.fK.onCustomViewHidden();
            this.fK = null;
        }
    }

    public void m1796S() {
        this.fN.removeView(this.fI);
        m1800c(true);
    }

    public void m1797a(View view, CustomViewCallback customViewCallback) {
        this.fJ = new FrameLayout(this.fD);
        this.fJ.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.fJ.addView(view, -1, -1);
        this.fD.setContentView(this.fJ);
        this.fK = customViewCallback;
    }

    public void m1798b(int i, int i2, int i3, int i4) {
        if (this.fF != null) {
            this.fF.setLayoutParams(m1791a(i, i2, i3, i4));
        }
    }

    public void m1799c(int i, int i2, int i3, int i4) {
        if (this.fF == null) {
            this.fF = new bj(this.fD, this.fG);
            this.fN.addView(this.fF, 0, m1791a(i, i2, i3, i4));
            this.fG.aw().m320j(false);
        }
    }

    public void m1800c(boolean z) {
        this.fI = new bk(this.fD, z ? 50 : 32);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.fI.m217d(this.fE.fX);
        this.fN.addView(this.fI, layoutParams);
    }

    public void close() {
        this.fD.finish();
    }

    public void m1801d(boolean z) {
        if (this.fI != null) {
            this.fI.m217d(z);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean z = false;
        if (savedInstanceState != null) {
            z = savedInstanceState.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.fL = z;
        try {
            this.fE = bh.m1179a(this.fD.getIntent());
            if (this.fE == null) {
                throw new C0101a("Could not get info for ad overlay.");
            }
            if (savedInstanceState == null) {
                if (this.fE.fT != null) {
                    this.fE.fT.m207C();
                }
                if (!(this.fE.ga == 1 || this.fE.fS == null)) {
                    this.fE.fS.m692y();
                }
            }
            switch (this.fE.ga) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    m1793e(false);
                case DetectedActivity.ON_FOOT /*2*/:
                    this.fH = new C0102b(this.fE.fU);
                    m1793e(false);
                case DetectedActivity.STILL /*3*/:
                    m1793e(true);
                case DetectedActivity.UNKNOWN /*4*/:
                    if (this.fL) {
                        this.fD.finish();
                    } else if (!bc.m199a(this.fD, this.fE.fR, this.fE.fZ)) {
                        this.fD.finish();
                    }
                default:
                    throw new C0101a("Could not determine ad overlay type.");
            }
        } catch (C0101a e) {
            cn.m299q(e.getMessage());
            this.fD.finish();
        }
    }

    public void onDestroy() {
        if (this.fF != null) {
            this.fF.destroy();
        }
        if (this.fG != null) {
            this.fN.removeView(this.fG);
        }
        m1790T();
    }

    public void onPause() {
        if (this.fF != null) {
            this.fF.pause();
        }
        m1795R();
        if (this.fG != null && (!this.fD.isFinishing() || this.fH == null)) {
            ci.m264a(this.fG);
        }
        m1790T();
    }

    public void onRestart() {
    }

    public void onResume() {
        if (this.fE != null && this.fE.ga == 4) {
            if (this.fL) {
                this.fD.finish();
            } else {
                this.fL = true;
            }
        }
        if (this.fG != null) {
            ci.m269b(this.fG);
        }
    }

    public void onSaveInstanceState(Bundle outBundle) {
        outBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.fL);
    }

    public void onStart() {
    }

    public void onStop() {
        m1790T();
    }

    public void setRequestedOrientation(int requestedOrientation) {
        this.fD.setRequestedOrientation(requestedOrientation);
    }
}
