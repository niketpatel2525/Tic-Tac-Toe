package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0067b;

/* renamed from: com.google.android.gms.maps.model.f */
public class C0192f {
    static void m750a(MarkerOptions markerOptions, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, markerOptions.getVersionCode());
        C0067b.m120a(parcel, 2, markerOptions.getPosition(), i, false);
        C0067b.m121a(parcel, 3, markerOptions.getTitle(), false);
        C0067b.m121a(parcel, 4, markerOptions.getSnippet(), false);
        C0067b.m118a(parcel, 5, markerOptions.cN(), false);
        C0067b.m115a(parcel, 6, markerOptions.getAnchorU());
        C0067b.m115a(parcel, 7, markerOptions.getAnchorV());
        C0067b.m124a(parcel, 8, markerOptions.isDraggable());
        C0067b.m124a(parcel, 9, markerOptions.isVisible());
        C0067b.m112C(parcel, k);
    }
}
