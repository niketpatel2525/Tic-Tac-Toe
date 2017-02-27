package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.maps.model.CameraPosition;

public class GoogleMapOptionsCreator implements Creator<GoogleMapOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m708a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, googleMapOptions.getVersionCode());
        C0067b.m113a(parcel, 2, googleMapOptions.cv());
        C0067b.m113a(parcel, 3, googleMapOptions.cw());
        C0067b.m131c(parcel, 4, googleMapOptions.getMapType());
        C0067b.m120a(parcel, 5, googleMapOptions.getCamera(), i, false);
        C0067b.m113a(parcel, 6, googleMapOptions.cx());
        C0067b.m113a(parcel, 7, googleMapOptions.cy());
        C0067b.m113a(parcel, 8, googleMapOptions.cz());
        C0067b.m113a(parcel, 9, googleMapOptions.cA());
        C0067b.m113a(parcel, 10, googleMapOptions.cB());
        C0067b.m113a(parcel, 11, googleMapOptions.cC());
        C0067b.m112C(parcel, k);
    }

    public GoogleMapOptions createFromParcel(Parcel parcel) {
        byte b = (byte) 0;
        int j = C0066a.m92j(parcel);
        CameraPosition cameraPosition = null;
        byte b2 = (byte) 0;
        byte b3 = (byte) 0;
        byte b4 = (byte) 0;
        byte b5 = (byte) 0;
        byte b6 = (byte) 0;
        int i = 0;
        byte b7 = (byte) 0;
        byte b8 = (byte) 0;
        int i2 = 0;
        while (parcel.dataPosition() < j) {
            int i3 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i3)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i2 = C0066a.m86f(parcel, i3);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    b8 = C0066a.m84d(parcel, i3);
                    break;
                case DetectedActivity.STILL /*3*/:
                    b7 = C0066a.m84d(parcel, i3);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i = C0066a.m86f(parcel, i3);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    cameraPosition = (CameraPosition) C0066a.m77a(parcel, i3, CameraPosition.CREATOR);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    b6 = C0066a.m84d(parcel, i3);
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    b5 = C0066a.m84d(parcel, i3);
                    break;
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    b4 = C0066a.m84d(parcel, i3);
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    b3 = C0066a.m84d(parcel, i3);
                    break;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    b2 = C0066a.m84d(parcel, i3);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    b = C0066a.m84d(parcel, i3);
                    break;
                default:
                    C0066a.m80b(parcel, i3);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new GoogleMapOptions(i2, b8, b7, i, cameraPosition, b6, b5, b4, b3, b2, b);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public GoogleMapOptions[] newArray(int size) {
        return new GoogleMapOptions[size];
    }
}
