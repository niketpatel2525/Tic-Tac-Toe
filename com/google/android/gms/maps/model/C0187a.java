package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0067b;

/* renamed from: com.google.android.gms.maps.model.a */
public class C0187a {
    static void m745a(CameraPosition cameraPosition, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, cameraPosition.getVersionCode());
        C0067b.m120a(parcel, 2, cameraPosition.target, i, false);
        C0067b.m115a(parcel, 3, cameraPosition.zoom);
        C0067b.m115a(parcel, 4, cameraPosition.tilt);
        C0067b.m115a(parcel, 5, cameraPosition.bearing);
        C0067b.m112C(parcel, k);
    }
}
