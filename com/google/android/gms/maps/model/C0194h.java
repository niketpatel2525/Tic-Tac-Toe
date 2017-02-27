package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0067b;

/* renamed from: com.google.android.gms.maps.model.h */
public class C0194h {
    static void m752a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, polylineOptions.getVersionCode());
        C0067b.m130b(parcel, 2, polylineOptions.getPoints(), false);
        C0067b.m115a(parcel, 3, polylineOptions.getWidth());
        C0067b.m131c(parcel, 4, polylineOptions.getColor());
        C0067b.m115a(parcel, 5, polylineOptions.getZIndex());
        C0067b.m124a(parcel, 6, polylineOptions.isVisible());
        C0067b.m124a(parcel, 7, polylineOptions.isGeodesic());
        C0067b.m112C(parcel, k);
    }
}
