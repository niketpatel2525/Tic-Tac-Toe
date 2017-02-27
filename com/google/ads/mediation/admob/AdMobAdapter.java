package com.google.ads.mediation.admob;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.internal.bb;
import com.google.android.gms.internal.cm;
import java.util.Date;
import java.util.Set;

public final class AdMobAdapter implements MediationBannerAdapter<AdMobExtras, AdMobServerParameters>, MediationInterstitialAdapter<AdMobExtras, AdMobServerParameters> {
    private AdView f626h;
    private InterstitialAd f627i;

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter.a */
    private static final class C0341a extends AdListener {
        private final AdMobAdapter f507j;
        private final MediationBannerListener f508k;

        public C0341a(AdMobAdapter adMobAdapter, MediationBannerListener mediationBannerListener) {
            this.f507j = adMobAdapter;
            this.f508k = mediationBannerListener;
        }

        public void onAdClosed() {
            this.f508k.onDismissScreen(this.f507j);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f508k.onFailedToReceiveAd(this.f507j, bb.m198f(errorCode));
        }

        public void onAdLeftApplication() {
            this.f508k.onLeaveApplication(this.f507j);
        }

        public void onAdLoaded() {
            this.f508k.onReceivedAd(this.f507j);
        }

        public void onAdOpened() {
            this.f508k.onClick(this.f507j);
            this.f508k.onPresentScreen(this.f507j);
        }
    }

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter.b */
    private static final class C0342b extends AdListener {
        private final AdMobAdapter f509j;
        private final MediationInterstitialListener f510l;

        public C0342b(AdMobAdapter adMobAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f509j = adMobAdapter;
            this.f510l = mediationInterstitialListener;
        }

        public void onAdClosed() {
            this.f510l.onDismissScreen(this.f509j);
        }

        public void onAdFailedToLoad(int errorCode) {
            this.f510l.onFailedToReceiveAd(this.f509j, bb.m198f(errorCode));
        }

        public void onAdLeftApplication() {
            this.f510l.onLeaveApplication(this.f509j);
        }

        public void onAdLoaded() {
            this.f510l.onReceivedAd(this.f509j);
        }

        public void onAdOpened() {
            this.f510l.onPresentScreen(this.f509j);
        }
    }

    private static AdRequest m1765a(Context context, MediationAdRequest mediationAdRequest, AdMobExtras adMobExtras, AdMobServerParameters adMobServerParameters) {
        NetworkExtras adMobExtras2;
        Builder builder = new Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        Gender gender = mediationAdRequest.getGender();
        if (gender != null) {
            builder.setGender(bb.m194a(gender));
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(cm.m290l(context));
        }
        if (adMobServerParameters.tagForChildDirectedTreatment != -1) {
            builder.tagForChildDirectedTreatment(adMobServerParameters.tagForChildDirectedTreatment == 1);
        }
        if (adMobExtras == null) {
            adMobExtras2 = new AdMobExtras(new Bundle());
        }
        Bundle extras = adMobExtras2.getExtras();
        extras.putInt("gw", 1);
        extras.putString("mad_hac", adMobServerParameters.allowHouseAds);
        extras.putBoolean("_noRefresh", true);
        builder.addNetworkExtras(adMobExtras2);
        return builder.build();
    }

    public void destroy() {
        if (this.f626h != null) {
            this.f626h.destroy();
            this.f626h = null;
        }
        if (this.f627i != null) {
            this.f627i = null;
        }
    }

    public Class<AdMobExtras> getAdditionalParametersType() {
        return AdMobExtras.class;
    }

    public View getBannerView() {
        return this.f626h;
    }

    public Class<AdMobServerParameters> getServerParametersType() {
        return AdMobServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener bannerListener, Activity activity, AdMobServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, AdMobExtras extras) {
        this.f626h = new AdView(activity);
        this.f626h.setAdSize(new com.google.android.gms.ads.AdSize(adSize.getWidth(), adSize.getHeight()));
        this.f626h.setAdUnitId(serverParameters.adUnitId);
        this.f626h.setAdListener(new C0341a(this, bannerListener));
        this.f626h.loadAd(m1765a(activity, mediationAdRequest, extras, serverParameters));
    }

    public void requestInterstitialAd(MediationInterstitialListener interstitialListener, Activity activity, AdMobServerParameters serverParameters, MediationAdRequest mediationAdRequest, AdMobExtras extras) {
        this.f627i = new InterstitialAd(activity);
        this.f627i.setAdUnitId(serverParameters.adUnitId);
        this.f627i.setAdListener(new C0342b(this, interstitialListener));
        this.f627i.loadAd(m1765a(activity, mediationAdRequest, extras, serverParameters));
    }

    public void showInterstitial() {
        this.f627i.show();
    }
}
