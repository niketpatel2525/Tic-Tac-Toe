package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DetectedActivity implements SafeParcelable {
    public static final DetectedActivityCreator CREATOR;
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;
    private final int iM;
    int oy;
    int oz;

    static {
        CREATOR = new DetectedActivityCreator();
    }

    public DetectedActivity(int activityType, int confidence) {
        this.iM = ON_BICYCLE;
        this.oy = activityType;
        this.oz = confidence;
    }

    public DetectedActivity(int versionCode, int activityType, int confidence) {
        this.iM = versionCode;
        this.oy = activityType;
        this.oz = confidence;
    }

    private int m1529W(int i) {
        return i > 6 ? UNKNOWN : i;
    }

    public int describeContents() {
        return IN_VEHICLE;
    }

    public int getConfidence() {
        return this.oz;
    }

    public int getType() {
        return m1529W(this.oy);
    }

    public int getVersionCode() {
        return this.iM;
    }

    public String toString() {
        return "DetectedActivity [type=" + getType() + ", confidence=" + this.oz + "]";
    }

    public void writeToParcel(Parcel out, int flags) {
        DetectedActivityCreator.m704a(this, out, flags);
    }
}
