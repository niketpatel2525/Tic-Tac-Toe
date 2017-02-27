package com.sxnyodot.uefqvmio207964;

public interface AdListener {

    public enum AdType {
        smartwall,
        overlay,
        video,
        appwall,
        interstitial
    }

    public interface BannerAdListener {
        void noAdAvailableListener();

        void onAdClickListener();

        void onAdExpandedListner();

        void onAdLoadedListener();

        void onAdLoadingListener();

        void onCloseListener();

        void onErrorListener(String str);
    }

    public interface OptinListener {
        void optinResult(boolean z);

        void showingDialog();
    }

    void noAdAvailableListener();

    void onAdCached(AdType adType);

    void onAdError(String str);

    void onSDKIntegrationError(String str);

    void onSmartWallAdClosed();

    void onSmartWallAdShowing();
}
