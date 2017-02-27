package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import com.google.android.gms.internal.dl;
import com.google.android.gms.location.DetectedActivity;

public final class ConnectionResult {
    public static final int DATE_INVALID = 12;
    public static final int DEVELOPER_ERROR = 10;
    public static final int INTERNAL_ERROR = 8;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 7;
    public static final int RESOLUTION_REQUIRED = 6;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final ConnectionResult iP;
    private final int iC;
    private final PendingIntent mPendingIntent;

    static {
        iP = new ConnectionResult(0, null);
    }

    public ConnectionResult(int statusCode, PendingIntent pendingIntent) {
        this.iC = statusCode;
        this.mPendingIntent = pendingIntent;
    }

    private String aH() {
        switch (this.iC) {
            case DetectedActivity.IN_VEHICLE /*0*/:
                return "SUCCESS";
            case SERVICE_MISSING /*1*/:
                return "SERVICE_MISSING";
            case SERVICE_VERSION_UPDATE_REQUIRED /*2*/:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case SERVICE_DISABLED /*3*/:
                return "SERVICE_DISABLED";
            case SIGN_IN_REQUIRED /*4*/:
                return "SIGN_IN_REQUIRED";
            case INVALID_ACCOUNT /*5*/:
                return "INVALID_ACCOUNT";
            case RESOLUTION_REQUIRED /*6*/:
                return "RESOLUTION_REQUIRED";
            case NETWORK_ERROR /*7*/:
                return "NETWORK_ERROR";
            case INTERNAL_ERROR /*8*/:
                return "INTERNAL_ERROR";
            case SERVICE_INVALID /*9*/:
                return "SERVICE_INVALID";
            case DEVELOPER_ERROR /*10*/:
                return "DEVELOPER_ERROR";
            case LICENSE_CHECK_FAILED /*11*/:
                return "LICENSE_CHECK_FAILED";
            default:
                return "unknown status code " + this.iC;
        }
    }

    public int getErrorCode() {
        return this.iC;
    }

    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    public boolean hasResolution() {
        return (this.iC == 0 || this.mPendingIntent == null) ? false : true;
    }

    public boolean isSuccess() {
        return this.iC == 0;
    }

    public void startResolutionForResult(Activity activity, int requestCode) throws SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), requestCode, null, 0, 0, 0);
        }
    }

    public String toString() {
        return dl.m387d(this).m386a("statusCode", aH()).m386a("resolution", this.mPendingIntent).toString();
    }
}
