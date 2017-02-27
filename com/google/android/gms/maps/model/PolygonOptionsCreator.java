package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;
import java.util.List;

public class PolygonOptionsCreator implements Creator<PolygonOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m740a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, polygonOptions.getVersionCode());
        C0067b.m130b(parcel, 2, polygonOptions.getPoints(), false);
        C0067b.m132c(parcel, 3, polygonOptions.cO(), false);
        C0067b.m115a(parcel, 4, polygonOptions.getStrokeWidth());
        C0067b.m131c(parcel, 5, polygonOptions.getStrokeColor());
        C0067b.m131c(parcel, 6, polygonOptions.getFillColor());
        C0067b.m115a(parcel, 7, polygonOptions.getZIndex());
        C0067b.m124a(parcel, 8, polygonOptions.isVisible());
        C0067b.m124a(parcel, 9, polygonOptions.isGeodesic());
        C0067b.m112C(parcel, k);
    }

    public PolygonOptions createFromParcel(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int j = C0066a.m92j(parcel);
        List list = null;
        List arrayList = new ArrayList();
        boolean z2 = false;
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
                    list = C0066a.m82c(parcel, i4, LatLng.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    C0066a.m79a(parcel, i4, arrayList, getClass().getClassLoader());
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
                    z2 = C0066a.m83c(parcel, i4);
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    z = C0066a.m83c(parcel, i4);
                    break;
                default:
                    C0066a.m80b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new PolygonOptions(i3, list, arrayList, f2, i2, i, f, z2, z);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public PolygonOptions[] newArray(int size) {
        return new PolygonOptions[size];
    }
}
