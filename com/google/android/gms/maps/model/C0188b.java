package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0067b;

/* renamed from: com.google.android.gms.maps.model.b */
public class C0188b {
    static void m746a(CircleOptions circleOptions, Parcel parcel, int i) {
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
}
