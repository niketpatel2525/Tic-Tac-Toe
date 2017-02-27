package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0067b;

/* renamed from: com.google.android.gms.maps.model.g */
public class C0193g {
    static void m751a(PolygonOptions polygonOptions, Parcel parcel, int i) {
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
}
