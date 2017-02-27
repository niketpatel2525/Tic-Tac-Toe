package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.ViewSwitcher;
import com.google.android.gms.dynamic.C0071b;
import com.google.android.gms.dynamic.C0566c;
import com.google.android.gms.internal.ac.C0367a;
import com.google.android.gms.internal.bp.C0106a;
import com.google.android.gms.internal.bu.C0112a;

/* renamed from: com.google.android.gms.internal.r */
public final class C0602r extends C0367a implements ag, aq, bi, bl, C0106a, C0161q {
    private final aw dZ;
    private final C0162a ea;
    private final C0164s eb;

    /* renamed from: com.google.android.gms.internal.r.a */
    private static final class C0162a {
        public final String adUnitId;
        public final ViewSwitcher ec;
        public final C0470x ed;
        public final Context ee;
        public final C0152h ef;
        public final co eg;
        public ab eh;
        public cg ei;
        public ce ej;
        public ae ek;

        public C0162a(Context context, C0470x c0470x, String str, co coVar) {
            if (c0470x.ex) {
                this.ec = null;
            } else {
                this.ec = new ViewSwitcher(context);
                this.ec.setMinimumWidth(c0470x.widthPixels);
                this.ec.setMinimumHeight(c0470x.heightPixels);
                this.ec.setVisibility(4);
            }
            this.ed = c0470x;
            this.adUnitId = str;
            this.ee = context;
            this.ef = new C0152h(C0634g.m2122a(coVar.hP, context));
            this.eg = coVar;
        }
    }

    public C0602r(Context context, C0470x c0470x, String str, aw awVar, co coVar) {
        this.ea = new C0162a(context, c0470x, str, coVar);
        this.dZ = awVar;
        this.eb = new C0164s(this);
        cn.m297o("Use AdRequest.Builder.addTestDevice(\"" + cm.m290l(context) + "\") to get test ads on this device.");
        ci.m272i(context);
    }

    private void m1991I() {
        cn.m297o("Ad closing.");
        if (this.ea.eh != null) {
            try {
                this.ea.eh.onAdClosed();
            } catch (Throwable e) {
                cn.m293b("Could not call AdListener.onAdClosed().", e);
            }
        }
    }

    private void m1992J() {
        cn.m297o("Ad leaving application.");
        if (this.ea.eh != null) {
            try {
                this.ea.eh.onAdLeftApplication();
            } catch (Throwable e) {
                cn.m293b("Could not call AdListener.onAdLeftApplication().", e);
            }
        }
    }

    private void m1993K() {
        cn.m297o("Ad opening.");
        if (this.ea.eh != null) {
            try {
                this.ea.eh.onAdOpened();
            } catch (Throwable e) {
                cn.m293b("Could not call AdListener.onAdOpened().", e);
            }
        }
    }

    private void m1994L() {
        cn.m297o("Ad finished loading.");
        if (this.ea.eh != null) {
            try {
                this.ea.eh.onAdLoaded();
            } catch (Throwable e) {
                cn.m293b("Could not call AdListener.onAdLoaded().", e);
            }
        }
    }

    private boolean m1995M() {
        boolean z = true;
        if (!ci.m267a(this.ea.ee.getPackageManager(), this.ea.ee.getPackageName(), "android.permission.INTERNET")) {
            if (!this.ea.ed.ex) {
                cm.m287a(this.ea.ec, this.ea.ed, "Missing internet permission in AndroidManifest.xml.");
            }
            z = false;
        }
        if (!ci.m270h(this.ea.ee)) {
            if (!this.ea.ed.ex) {
                cm.m287a(this.ea.ec, this.ea.ed, "Missing AdActivity with android:configChanges in AndroidManifest.xml.");
            }
            z = false;
        }
        if (!z) {
            this.ea.ec.setVisibility(0);
        }
        return z;
    }

    private void m1996N() {
        if (this.ea.ej == null) {
            cn.m299q("Ad state was null when trying to ping click URLs.");
            return;
        }
        cn.m295m("Pinging click URLs.");
        if (this.ea.ej.eW != null) {
            ci.m262a(this.ea.ee, this.ea.eg.hP, this.ea.ej.eW);
        }
        if (this.ea.ej.hA != null && this.ea.ej.hA.eW != null) {
            au.m186a(this.ea.ee, this.ea.eg.hP, this.ea.ej, this.ea.adUnitId, false, this.ea.ej.hA.eW);
        }
    }

    private void m1997O() {
        if (this.ea.ej != null) {
            this.ea.ej.fU.destroy();
            this.ea.ej = null;
        }
    }

    private void m1998a(int i) {
        cn.m299q("Failed to load ad: " + i);
        if (this.ea.eh != null) {
            try {
                this.ea.eh.onAdFailedToLoad(i);
            } catch (Throwable e) {
                cn.m293b("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
    }

    private void m1999b(View view) {
        this.ea.ec.addView(view, new LayoutParams(-2, -2));
    }

    private void m2000b(boolean z) {
        if (this.ea.ej == null) {
            cn.m299q("Ad state was null when trying to ping impression URLs.");
            return;
        }
        cn.m295m("Pinging Impression URLs.");
        if (this.ea.ej.eX != null) {
            ci.m262a(this.ea.ee, this.ea.eg.hP, this.ea.ej.eX);
        }
        if (!(this.ea.ej.hA == null || this.ea.ej.hA.eX == null)) {
            au.m186a(this.ea.ee, this.ea.eg.hP, this.ea.ej, this.ea.adUnitId, z, this.ea.ej.hA.eX);
        }
        if (this.ea.ej.fm != null && this.ea.ej.fm.eT != null) {
            au.m186a(this.ea.ee, this.ea.eg.hP, this.ea.ej, this.ea.adUnitId, z, this.ea.ej.fm.eT);
        }
    }

    private boolean m2001b(ce ceVar) {
        View view;
        if (ceVar.gI) {
            try {
                view = (View) C0566c.m1772b(ceVar.fn.getView());
                View nextView = this.ea.ec.getNextView();
                if (nextView != null) {
                    this.ea.ec.removeView(nextView);
                }
                try {
                    m1999b(view);
                } catch (Throwable th) {
                    cn.m293b("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            } catch (Throwable th2) {
                cn.m293b("Could not get View from mediation adapter.", th2);
                return false;
            }
        }
        if (this.ea.ec.getChildCount() > 1) {
            this.ea.ec.showNext();
        }
        if (this.ea.ej != null) {
            view = this.ea.ec.getNextView();
            if (view instanceof cq) {
                ((cq) view).m304a(this.ea.ee, this.ea.ed);
            } else if (view != null) {
                this.ea.ec.removeView(view);
            }
            if (this.ea.ej.fn != null) {
                try {
                    this.ea.ej.fn.destroy();
                } catch (RemoteException e) {
                    cn.m299q("Could not destroy previous mediation adapter.");
                }
            }
        }
        this.ea.ec.setVisibility(0);
        return true;
    }

    private C0112a m2002c(C0469v c0469v) {
        PackageInfo packageInfo;
        Bundle bundle;
        ApplicationInfo applicationInfo = this.ea.ee.getApplicationInfo();
        try {
            packageInfo = this.ea.ee.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        if (this.ea.ed.ex || this.ea.ec.getParent() == null) {
            bundle = null;
        } else {
            int[] iArr = new int[2];
            this.ea.ec.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            DisplayMetrics displayMetrics = this.ea.ee.getResources().getDisplayMetrics();
            int width = this.ea.ec.getWidth();
            int height = this.ea.ec.getHeight();
            int i3 = (!this.ea.ec.isShown() || i + width <= 0 || i2 + height <= 0 || i > displayMetrics.widthPixels || i2 > displayMetrics.heightPixels) ? 0 : 1;
            bundle = new Bundle(5);
            bundle.putInt("x", i);
            bundle.putInt("y", i2);
            bundle.putInt(IM.WIDTH, width);
            bundle.putInt(IM.HEIGHT, height);
            bundle.putInt("visible", i3);
        }
        return new C0112a(bundle, c0469v, this.ea.ed, this.ea.adUnitId, applicationInfo, packageInfo, cf.al(), cf.hB, this.ea.eg);
    }

    public void m2003A() {
        m1992J();
    }

    public void m2004B() {
        if (this.ea.ed.ex) {
            m1997O();
        }
        m1991I();
    }

    public void m2005C() {
        if (this.ea.ed.ex) {
            m2000b(false);
        }
        m1993K();
    }

    public void m2006D() {
        m2017y();
    }

    public void m2007E() {
        m2004B();
    }

    public void m2008F() {
        m2003A();
    }

    public void m2009G() {
        m2005C();
    }

    public void m2010H() {
        if (this.ea.ej != null) {
            cn.m299q("Mediation adapter " + this.ea.ej.fo + " refreshed, but mediation adapters should never refresh.");
        }
        m2000b(true);
        m1994L();
    }

    public void m2011a(ab abVar) {
        dm.m395w("setAdListener must be called on the main UI thread.");
        this.ea.eh = abVar;
    }

    public void m2012a(ae aeVar) {
        dm.m395w("setAppEventListener must be called on the main UI thread.");
        this.ea.ek = aeVar;
    }

    public void m2013a(ce ceVar) {
        this.ea.ei = null;
        if (ceVar.errorCode != -1) {
            boolean z = ceVar.gB.extras != null ? ceVar.gB.extras.getBoolean("_noRefresh", false) : false;
            if (this.ea.ed.ex) {
                ci.m264a(ceVar.fU);
            } else if (!z) {
                if (ceVar.fa > 0) {
                    this.eb.m695a(ceVar.gB, ceVar.fa);
                } else if (ceVar.hA != null && ceVar.hA.fa > 0) {
                    this.eb.m695a(ceVar.gB, ceVar.hA.fa);
                } else if (!ceVar.gI && ceVar.errorCode == 2) {
                    this.eb.m696d(ceVar.gB);
                }
            }
            if (!(ceVar.errorCode != 3 || ceVar.hA == null || ceVar.hA.eY == null)) {
                cn.m295m("Pinging no fill URLs.");
                au.m186a(this.ea.ee, this.ea.eg.hP, ceVar, this.ea.adUnitId, false, ceVar.hA.eY);
            }
            if (ceVar.errorCode != -2) {
                m1998a(ceVar.errorCode);
            } else if (this.ea.ed.ex || m2001b(ceVar)) {
                if (!(this.ea.ej == null || this.ea.ej.fp == null)) {
                    this.ea.ej.fp.m1781a(null);
                }
                if (ceVar.fp != null) {
                    ceVar.fp.m1781a((aq) this);
                }
                this.ea.ej = ceVar;
                if (!this.ea.ed.ex) {
                    m2000b(false);
                }
                m1994L();
            } else {
                m1998a(0);
            }
        }
    }

    public void m2014a(String str, String str2) {
        if (this.ea.ek != null) {
            try {
                this.ea.ek.m174a(str, str2);
            } catch (Throwable e) {
                cn.m293b("Could not call the AppEventListener.", e);
            }
        }
    }

    public boolean m2015a(C0469v c0469v) {
        dm.m395w("loadAd must be called on the main UI thread.");
        if (this.ea.ei != null) {
            cn.m299q("An ad request is already in progress. Aborting.");
            return false;
        } else if (this.ea.ed.ex && this.ea.ej != null) {
            cn.m299q("An interstitial is already loading. Aborting.");
            return false;
        } else if (!m1995M()) {
            return false;
        } else {
            cq cqVar;
            cn.m297o("Starting ad request.");
            this.eb.cancel();
            C0112a c = m2002c(c0469v);
            if (this.ea.ed.ex) {
                cq a = cq.m303a(this.ea.ee, this.ea.ed, false, false, this.ea.ef, this.ea.eg);
                a.aw().m315a(this, null, this, this, true);
                cqVar = a;
            } else {
                cq cqVar2;
                View nextView = this.ea.ec.getNextView();
                if (nextView instanceof cq) {
                    cqVar2 = (cq) nextView;
                    cqVar2.m304a(this.ea.ee, this.ea.ed);
                } else {
                    if (nextView != null) {
                        this.ea.ec.removeView(nextView);
                    }
                    nextView = cq.m303a(this.ea.ee, this.ea.ed, false, false, this.ea.ef, this.ea.eg);
                    m1999b(nextView);
                }
                cqVar2.aw().m315a(this, this, this, this, false);
                cqVar = cqVar2;
            }
            this.ea.ei = bp.m221a(this.ea.ee, c, this.ea.ef, cqVar, this.dZ, this);
            return true;
        }
    }

    public void m2016b(C0469v c0469v) {
        ViewParent parent = this.ea.ec.getParent();
        if ((parent instanceof View) && ((View) parent).isShown() && ci.am()) {
            m2015a(c0469v);
            return;
        }
        cn.m297o("Ad is not visible. Not refreshing ad.");
        this.eb.m696d(c0469v);
    }

    public void destroy() {
        dm.m395w("destroy must be called on the main UI thread.");
        this.ea.eh = null;
        this.ea.ek = null;
        this.eb.cancel();
        stopLoading();
        if (this.ea.ec != null) {
            this.ea.ec.removeAllViews();
        }
        if (this.ea.ej != null && this.ea.ej.fU != null) {
            this.ea.ej.fU.destroy();
        }
    }

    public boolean isReady() {
        dm.m395w("isReady must be called on the main UI thread.");
        return this.ea.ei == null && this.ea.ej != null;
    }

    public void pause() {
        dm.m395w("pause must be called on the main UI thread.");
        if (this.ea.ej != null) {
            ci.m264a(this.ea.ej.fU);
        }
    }

    public void resume() {
        dm.m395w("resume must be called on the main UI thread.");
        if (this.ea.ej != null) {
            ci.m269b(this.ea.ej.fU);
        }
    }

    public void showInterstitial() {
        dm.m395w("showInterstitial must be called on the main UI thread.");
        if (!this.ea.ed.ex) {
            cn.m299q("Cannot call showInterstitial on a banner ad.");
        } else if (this.ea.ej == null) {
            cn.m299q("The interstitial has not loaded.");
        } else if (this.ea.ej.fU.az()) {
            cn.m299q("The interstitial is already showing.");
        } else {
            this.ea.ej.fU.m307i(true);
            if (this.ea.ej.gI) {
                try {
                    this.ea.ej.fn.showInterstitial();
                    return;
                } catch (Throwable e) {
                    cn.m293b("Could not show interstitial.", e);
                    m1997O();
                    return;
                }
            }
            bf.m1792a(this.ea.ee, new bh(this, this, this, this.ea.ej.fU, this.ea.ej.orientation, this.ea.eg));
        }
    }

    public void stopLoading() {
        dm.m395w("stopLoading must be called on the main UI thread.");
        if (this.ea.ej != null) {
            this.ea.ej.fU.stopLoading();
            this.ea.ej = null;
        }
        if (this.ea.ei != null) {
            this.ea.ei.cancel();
        }
    }

    public void m2017y() {
        m1996N();
    }

    public C0071b m2018z() {
        dm.m395w("getAdFrame must be called on the main UI thread.");
        return C0566c.m1773g(this.ea.ec);
    }
}
