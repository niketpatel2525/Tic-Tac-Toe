package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;

public class CircleOptionsCreator implements Creator<CircleOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m734a(CircleOptions circleOptions, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, circleOptions.getVersionCode());
        C0067b.m120a(parcel, 2, circleOptions.getCenter(), i, false);
        C0067b.m114a(parcel, 3, circleOptions.getRadius());
        C0067b.m115a(parcel, 4, circleOptions.getStrokeWidth());
        C0067b.m131c(parcel, 5, circleOptions.getStrokeColor());
        C0067b.m131c(parcel, 6, circleOptions.getFillColor());
        C0067b.m115a(parcel, 7, circleOptions.getZIndex());
        C0067b.m124a(parcel, 8, circleOptions.isVisible());
        C0067b.m112C(parcel, k);
    }

    public CircleOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int j = C0066a.m92j(parcel);
        LatLng latLng = null;
        double d = 0.0d;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i4)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i3 = C0066a.m86f(parcel, i4);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    latLng = (LatLng) C0066a.m77a(parcel, i4, LatLng.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    d = C0066a.m91j(parcel, i4);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    f2 = C0066a.m89i(parcel, i4);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    i2 = C0066a.m86f(parcel, i4);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    i = C0066a.m86f(parcel, i4);
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    f = C0066a.m89i(parcel, i4);
                    break;
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    z = C0066a.m83c(parcel, i4);
                    break;
                default:
                    C0066a.m80b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new CircleOptions(i3, latLng, d, f2, i2, i, f, z);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public CircleOptions[] newArray(int size) {
        return new CircleOptions[size];
    }
}
