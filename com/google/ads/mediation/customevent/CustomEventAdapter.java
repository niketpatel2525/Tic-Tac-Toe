package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.internal.cn;

public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View f633m;
    private CustomEventBanner f634n;
    private CustomEventInterstitial f635o;

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter.a */
    private static final class C0562a implements CustomEventBannerListener {
        private final MediationBannerListener f628k;
        private final CustomEventAdapter f629p;

        public C0562a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f629p = customEventAdapter;
            this.f628k = mediationBannerListener;
        }

        public void onClick() {
            cn.m295m("Custom event adapter called onFailedToReceiveAd.");
            this.f628k.onClick(this.f629p);
        }

        public void onDismissScreen() {
            cn.m295m("Custom event adapter called onFailedToReceiveAd.");
            this.f628k.onDismissScreen(this.f629p);
        }

        public void onFailedToReceiveAd() {
            cn.m295m("Custom event adapter called onFailedToReceiveAd.");
            this.f628k.onFailedToReceiveAd(this.f629p, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            cn.m295m("Custom event adapter called onFailedToReceiveAd.");
            this.f628k.onLeaveApplication(this.f629p);
        }

        public void onPresentScreen() {
            cn.m295m("Custom event adapter called onFailedToReceiveAd.");
            this.f628k.onPresentScreen(this.f629p);
        }

        public void onReceivedAd(View view) {
            cn.m295m("Custom event adapter called onReceivedAd.");
            this.f629p.m1767a(view);
            this.f628k.onReceivedAd(this.f629p);
        }
    }

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter.b */
    private class C0563b implements CustomEventInterstitialListener {
        private final MediationInterstitialListener f630l;
        private final CustomEventAdapter f631p;
        final /* synthetic */ CustomEventAdapter f632q;

        public C0563b(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.f632q = customEventAdapter;
            this.f631p = customEventAdapter2;
            this.f630l = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            cn.m295m("Custom event adapter called onDismissScreen.");
            this.f630l.onDismissScreen(this.f631p);
        }

        public void onFailedToReceiveAd() {
            cn.m295m("Custom event adapter called onFailedToReceiveAd.");
            this.f630l.onFailedToReceiveAd(this.f631p, ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            cn.m295m("Custom event adapter called onLeaveApplication.");
            this.f630l.onLeaveApplication(this.f631p);
        }

        public void onPresentScreen() {
            cn.m295m("Custom event adapter called onPresentScreen.");
            this.f630l.onPresentScreen(this.f631p);
        }

        public void onReceivedAd() {
            cn.m295m("Custom event adapter called onReceivedAd.");
            this.f630l.onReceivedAd(this.f632q);
        }
    }

    private static <T> T m1766a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            cn.m299q("Could not instantiate custom event adapter: " + str + ". " + th.getMessage());
            return null;
        }
    }

    private void m1767a(View view) {
        this.f633m = view;
    }

    public void destroy() {
        if (this.f634n != null) {
            this.f634n.destroy();
        }
        if (this.f635o != null) {
            this.f635o.destroy();
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.f633m;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener listener, Activity activity, CustomEventServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f634n = (CustomEventBanner) m1766a(serverParameters.className);
        if (this.f634n == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f634n.requestBannerAd(new C0562a(this, listener), activity, serverParameters.label, serverParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener listener, Activity activity, CustomEventServerParameters serverParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f635o = (CustomEventInterstitial) m1766a(serverParameters.className);
        if (this.f635o == null) {
            listener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.f635o.requestInterstitialAd(new C0563b(this, this, listener), activity, serverParameters.label, serverParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(serverParameters.label));
        }
    }

    public void showInterstitial() {
        this.f635o.showInterstitial();
    }
}
