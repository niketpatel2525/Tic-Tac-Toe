package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0067b;

/* renamed from: com.google.android.gms.maps.model.e */
public class C0191e {
    static void m749a(LatLng latLng, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, latLng.getVersionCode());
        C0067b.m114a(parcel, 2, latLng.latitude);
        C0067b.m114a(parcel, 3, latLng.longitude);
        C0067b.m112C(parcel, k);
    }
}
