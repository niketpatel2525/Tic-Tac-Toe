package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;

public class DetectedActivityCreator implements Creator<DetectedActivity> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m704a(DetectedActivity detectedActivity, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, detectedActivity.oy);
        C0067b.m131c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, detectedActivity.getVersionCode());
        C0067b.m131c(parcel, 2, detectedActivity.oz);
        C0067b.m112C(parcel, k);
    }

    public DetectedActivity createFromParcel(Parcel parcel) {
        int i = 0;
        int j = C0066a.m92j(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i4)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i2 = C0066a.m86f(parcel, i4);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    i = C0066a.m86f(parcel, i4);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i3 = C0066a.m86f(parcel, i4);
                    break;
                default:
                    C0066a.m80b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new DetectedActivity(i3, i2, i);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public DetectedActivity[] newArray(int size) {
        return new DetectedActivity[size];
    }
}
