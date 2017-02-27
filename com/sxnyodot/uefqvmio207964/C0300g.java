package com.sxnyodot.uefqvmio207964;

import android.app.Activity;
import com.sxnyodot.uefqvmio207964.AdListener.AdType;
import com.sxnyodot.uefqvmio207964.AdListener.BannerAdListener;

/* renamed from: com.sxnyodot.uefqvmio207964.g */
interface C0300g {
    void run360Ad(Activity activity, int i, boolean z, BannerAdListener bannerAdListener);

    void runAppWall();

    void runCachedAd(Activity activity, AdType adType) throws Exception;

    void runOverlayAd();

    void runRichMediaInterstitialAd();

    void runSmartWallAd();

    void runVideoAd();
}
