package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

public final class ba<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final ay ft;

    /* renamed from: com.google.android.gms.internal.ba.10 */
    class AnonymousClass10 implements Runnable {
        final /* synthetic */ ba fu;
        final /* synthetic */ ErrorCode fv;

        AnonymousClass10(ba baVar, ErrorCode errorCode) {
            this.fu = baVar;
            this.fv = errorCode;
        }

        public void run() {
            try {
                this.fu.ft.onAdFailedToLoad(bb.m193a(this.fv));
            } catch (Throwable e) {
                cn.m293b("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ba.1 */
    class C00911 implements Runnable {
        final /* synthetic */ ba fu;

        C00911(ba baVar) {
            this.fu = baVar;
        }

        public void run() {
            try {
                this.fu.ft.m190y();
            } catch (Throwable e) {
                cn.m293b("Could not call onAdClicked.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ba.2 */
    class C00922 implements Runnable {
        final /* synthetic */ ba fu;

        C00922(ba baVar) {
            this.fu = baVar;
        }

        public void run() {
            try {
                this.fu.ft.onAdOpened();
            } catch (Throwable e) {
                cn.m293b("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ba.3 */
    class C00933 implements Runnable {
        final /* synthetic */ ba fu;

        C00933(ba baVar) {
            this.fu = baVar;
        }

        public void run() {
            try {
                this.fu.ft.onAdLoaded();
            } catch (Throwable e) {
                cn.m293b("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ba.4 */
    class C00944 implements Runnable {
        final /* synthetic */ ba fu;

        C00944(ba baVar) {
            this.fu = baVar;
        }

        public void run() {
            try {
                this.fu.ft.onAdClosed();
            } catch (Throwable e) {
                cn.m293b("Could not call onAdClosed.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ba.5 */
    class C00955 implements Runnable {
        final /* synthetic */ ba fu;
        final /* synthetic */ ErrorCode fv;

        C00955(ba baVar, ErrorCode errorCode) {
            this.fu = baVar;
            this.fv = errorCode;
        }

        public void run() {
            try {
                this.fu.ft.onAdFailedToLoad(bb.m193a(this.fv));
            } catch (Throwable e) {
                cn.m293b("Could not call onAdFailedToLoad.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ba.6 */
    class C00966 implements Runnable {
        final /* synthetic */ ba fu;

        C00966(ba baVar) {
            this.fu = baVar;
        }

        public void run() {
            try {
                this.fu.ft.onAdLeftApplication();
            } catch (Throwable e) {
                cn.m293b("Could not call onAdLeftApplication.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ba.7 */
    class C00977 implements Runnable {
        final /* synthetic */ ba fu;

        C00977(ba baVar) {
            this.fu = baVar;
        }

        public void run() {
            try {
                this.fu.ft.onAdOpened();
            } catch (Throwable e) {
                cn.m293b("Could not call onAdOpened.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ba.8 */
    class C00988 implements Runnable {
        final /* synthetic */ ba fu;

        C00988(ba baVar) {
            this.fu = baVar;
        }

        public void run() {
            try {
                this.fu.ft.onAdLoaded();
            } catch (Throwable e) {
                cn.m293b("Could not call onAdLoaded.", e);
            }
        }
    }

    /* renamed from: com.google.android.gms.internal.ba.9 */
    class C00999 implements Runnable {
        final /* synthetic */ ba fu;

        C00999(ba baVar) {
            this.fu = baVar;
        }

        public void run() {
            try {
                this.fu.ft.onAdClosed();
            } catch (Throwable e) {
                cn.m293b("Could not call onAdClosed.", e);
            }
        }
    }

    public ba(ay ayVar) {
        this.ft = ayVar;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        cn.m295m("Adapter called onClick.");
        if (cm.ar()) {
            try {
                this.ft.m190y();
                return;
            } catch (Throwable e) {
                cn.m293b("Could not call onAdClicked.", e);
                return;
            }
        }
        cn.m299q("onClick must be called on the main UI thread.");
        cm.hO.post(new C00911(this));
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        cn.m295m("Adapter called onDismissScreen.");
        if (cm.ar()) {
            try {
                this.ft.onAdClosed();
                return;
            } catch (Throwable e) {
                cn.m293b("Could not call onAdClosed.", e);
                return;
            }
        }
        cn.m299q("onDismissScreen must be called on the main UI thread.");
        cm.hO.post(new C00944(this));
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        cn.m295m("Adapter called onDismissScreen.");
        if (cm.ar()) {
            try {
                this.ft.onAdClosed();
                return;
            } catch (Throwable e) {
                cn.m293b("Could not call onAdClosed.", e);
                return;
            }
        }
        cn.m299q("onDismissScreen must be called on the main UI thread.");
        cm.hO.post(new C00999(this));
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, ErrorCode errorCode) {
        cn.m295m("Adapter called onFailedToReceiveAd with error. " + errorCode);
        if (cm.ar()) {
            try {
                this.ft.onAdFailedToLoad(bb.m193a(errorCode));
                return;
            } catch (Throwable e) {
                cn.m293b("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        cn.m299q("onFailedToReceiveAd must be called on the main UI thread.");
        cm.hO.post(new C00955(this, errorCode));
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, ErrorCode errorCode) {
        cn.m295m("Adapter called onFailedToReceiveAd with error " + errorCode + ".");
        if (cm.ar()) {
            try {
                this.ft.onAdFailedToLoad(bb.m193a(errorCode));
                return;
            } catch (Throwable e) {
                cn.m293b("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        cn.m299q("onFailedToReceiveAd must be called on the main UI thread.");
        cm.hO.post(new AnonymousClass10(this, errorCode));
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        cn.m295m("Adapter called onLeaveApplication.");
        if (cm.ar()) {
            try {
                this.ft.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                cn.m293b("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        cn.m299q("onLeaveApplication must be called on the main UI thread.");
        cm.hO.post(new C00966(this));
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        cn.m295m("Adapter called onLeaveApplication.");
        if (cm.ar()) {
            try {
                this.ft.onAdLeftApplication();
                return;
            } catch (Throwable e) {
                cn.m293b("Could not call onAdLeftApplication.", e);
                return;
            }
        }
        cn.m299q("onLeaveApplication must be called on the main UI thread.");
        cm.hO.post(new Runnable() {
            final /* synthetic */ ba fu;

            {
                this.fu = r1;
            }

            public void run() {
                try {
                    this.fu.ft.onAdLeftApplication();
                } catch (Throwable e) {
                    cn.m293b("Could not call onAdLeftApplication.", e);
                }
            }
        });
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        cn.m295m("Adapter called onPresentScreen.");
        if (cm.ar()) {
            try {
                this.ft.onAdOpened();
                return;
            } catch (Throwable e) {
                cn.m293b("Could not call onAdOpened.", e);
                return;
            }
        }
        cn.m299q("onPresentScreen must be called on the main UI thread.");
        cm.hO.post(new C00977(this));
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        cn.m295m("Adapter called onPresentScreen.");
        if (cm.ar()) {
            try {
                this.ft.onAdOpened();
                return;
            } catch (Throwable e) {
                cn.m293b("Could not call onAdOpened.", e);
                return;
            }
        }
        cn.m299q("onPresentScreen must be called on the main UI thread.");
        cm.hO.post(new C00922(this));
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        cn.m295m("Adapter called onReceivedAd.");
        if (cm.ar()) {
            try {
                this.ft.onAdLoaded();
                return;
            } catch (Throwable e) {
                cn.m293b("Could not call onAdLoaded.", e);
                return;
            }
        }
        cn.m299q("onReceivedAd must be called on the main UI thread.");
        cm.hO.post(new C00988(this));
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        cn.m295m("Adapter called onReceivedAd.");
        if (cm.ar()) {
            try {
                this.ft.onAdLoaded();
                return;
            } catch (Throwable e) {
                cn.m293b("Could not call onAdLoaded.", e);
                return;
            }
        }
        cn.m299q("onReceivedAd must be called on the main UI thread.");
        cm.hO.post(new C00933(this));
    }
}
