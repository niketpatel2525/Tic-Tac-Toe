package com.google.android.gms.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;

public class RecoveryDecisionCreator implements Creator<RecoveryDecision> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m21a(RecoveryDecision recoveryDecision, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, recoveryDecision.iM);
        C0067b.m120a(parcel, 2, recoveryDecision.recoveryIntent, i, false);
        C0067b.m124a(parcel, 3, recoveryDecision.showRecoveryInterstitial);
        C0067b.m124a(parcel, 4, recoveryDecision.isRecoveryInfoNeeded);
        C0067b.m124a(parcel, 5, recoveryDecision.isRecoveryInterstitialAllowed);
        C0067b.m120a(parcel, 6, recoveryDecision.recoveryIntentWithoutIntro, i, false);
        C0067b.m112C(parcel, k);
    }

    public RecoveryDecision createFromParcel(Parcel parcel) {
        PendingIntent pendingIntent = null;
        boolean z = false;
        int j = C0066a.m92j(parcel);
        boolean z2 = false;
        boolean z3 = false;
        PendingIntent pendingIntent2 = null;
        int i = 0;
        while (parcel.dataPosition() < j) {
            int i2 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0066a.m86f(parcel, i2);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    pendingIntent2 = (PendingIntent) C0066a.m77a(parcel, i2, PendingIntent.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    z3 = C0066a.m83c(parcel, i2);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    z2 = C0066a.m83c(parcel, i2);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    z = C0066a.m83c(parcel, i2);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    pendingIntent = (PendingIntent) C0066a.m77a(parcel, i2, PendingIntent.CREATOR);
                    break;
                default:
                    C0066a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new RecoveryDecision(i, pendingIntent2, z3, z2, z, pendingIntent);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public RecoveryDecision[] newArray(int size) {
        return new RecoveryDecision[size];
    }
}
