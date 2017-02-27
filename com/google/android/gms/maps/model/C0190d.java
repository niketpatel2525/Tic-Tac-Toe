package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0067b;

/* renamed from: com.google.android.gms.maps.model.d */
public class C0190d {
    static void m748a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, latLngBounds.getVersionCode());
        C0067b.m120a(parcel, 2, latLngBounds.southwest, i, false);
        C0067b.m120a(parcel, 3, latLngBounds.northeast, i, false);
        C0067b.m112C(parcel, k);
    }
}
