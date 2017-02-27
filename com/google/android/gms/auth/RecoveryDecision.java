package com.google.android.gms.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RecoveryDecision implements SafeParcelable {
    public static final RecoveryDecisionCreator CREATOR;
    final int iM;
    public boolean isRecoveryInfoNeeded;
    public boolean isRecoveryInterstitialAllowed;
    public PendingIntent recoveryIntent;
    public PendingIntent recoveryIntentWithoutIntro;
    public boolean showRecoveryInterstitial;

    static {
        CREATOR = new RecoveryDecisionCreator();
    }

    public RecoveryDecision() {
        this.iM = 1;
    }

    RecoveryDecision(int versionCode, PendingIntent recoveryIntent, boolean showRecoveryInterstitial, boolean isRecoveryInfoNeeded, boolean isRecoveryInterstitialAllowed, PendingIntent recoveryIntentWithoutIntro) {
        this.iM = versionCode;
        this.recoveryIntent = recoveryIntent;
        this.showRecoveryInterstitial = showRecoveryInterstitial;
        this.isRecoveryInfoNeeded = isRecoveryInfoNeeded;
        this.isRecoveryInterstitialAllowed = isRecoveryInterstitialAllowed;
        this.recoveryIntentWithoutIntro = recoveryIntentWithoutIntro;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.iM;
    }

    public void writeToParcel(Parcel out, int flags) {
        RecoveryDecisionCreator.m21a(this, out, flags);
    }
}
