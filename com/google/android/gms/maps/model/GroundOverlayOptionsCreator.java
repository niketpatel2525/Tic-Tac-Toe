package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;

public class GroundOverlayOptionsCreator implements Creator<GroundOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m735a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, groundOverlayOptions.getVersionCode());
        C0067b.m118a(parcel, 2, groundOverlayOptions.cM(), false);
        C0067b.m120a(parcel, 3, groundOverlayOptions.getLocation(), i, false);
        C0067b.m115a(parcel, 4, groundOverlayOptions.getWidth());
        C0067b.m115a(parcel, 5, groundOverlayOptions.getHeight());
        C0067b.m120a(parcel, 6, groundOverlayOptions.getBounds(), i, false);
        C0067b.m115a(parcel, 7, groundOverlayOptions.getBearing());
        C0067b.m115a(parcel, 8, groundOverlayOptions.getZIndex());
        C0067b.m124a(parcel, 9, groundOverlayOptions.isVisible());
        C0067b.m115a(parcel, 10, groundOverlayOptions.getTransparency());
        C0067b.m115a(parcel, 11, groundOverlayOptions.getAnchorU());
        C0067b.m115a(parcel, 12, groundOverlayOptions.getAnchorV());
        C0067b.m112C(parcel, k);
    }

    public GroundOverlayOptions createFromParcel(Parcel parcel) {
        int j = C0066a.m92j(parcel);
        int i = 0;
        IBinder iBinder = null;
        LatLng latLng = null;
        float f = 0.0f;
        float f2 = 0.0f;
        LatLngBounds latLngBounds = null;
        float f3 = 0.0f;
        float f4 = 0.0f;
        boolean z = false;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        while (parcel.dataPosition() < j) {
            int i2 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0066a.m86f(parcel, i2);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    iBinder = C0066a.m95m(parcel, i2);
                    break;
                case DetectedActivity.STILL /*3*/:
                    latLng = (LatLng) C0066a.m77a(parcel, i2, LatLng.CREATOR);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    f = C0066a.m89i(parcel, i2);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    f2 = C0066a.m89i(parcel, i2);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    latLngBounds = (LatLngBounds) C0066a.m77a(parcel, i2, LatLngBounds.CREATOR);
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    f3 = C0066a.m89i(parcel, i2);
                    break;
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    f4 = C0066a.m89i(parcel, i2);
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    z = C0066a.m83c(parcel, i2);
                    break;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    f5 = C0066a.m89i(parcel, i2);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    f6 = C0066a.m89i(parcel, i2);
                    break;
                case ConnectionResult.DATE_INVALID /*12*/:
                    f7 = C0066a.m89i(parcel, i2);
                    break;
                default:
                    C0066a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new GroundOverlayOptions(i, iBinder, latLng, f, f2, latLngBounds, f3, f4, z, f5, f6, f7);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public GroundOverlayOptions[] newArray(int size) {
        return new GroundOverlayOptions[size];
    }
}
