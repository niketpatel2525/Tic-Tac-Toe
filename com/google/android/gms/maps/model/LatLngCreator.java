package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.location.DetectedActivity;

public class LatLngCreator implements Creator<LatLng> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m738a(LatLng latLng, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, latLng.getVersionCode());
        C0067b.m114a(parcel, 2, latLng.latitude);
        C0067b.m114a(parcel, 3, latLng.longitude);
        C0067b.m112C(parcel, k);
    }

    public LatLng createFromParcel(Parcel parcel) {
        double d = 0.0d;
        int j = C0066a.m92j(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < j) {
            int i2 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0066a.m86f(parcel, i2);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    d2 = C0066a.m91j(parcel, i2);
                    break;
                case DetectedActivity.STILL /*3*/:
                    d = C0066a.m91j(parcel, i2);
                    break;
                default:
                    C0066a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new LatLng(i, d2, d);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public LatLng[] newArray(int size) {
        return new LatLng[size];
    }
}
