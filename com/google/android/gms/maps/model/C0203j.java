package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0067b;

/* renamed from: com.google.android.gms.maps.model.j */
public class C0203j {
    static void m767a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, tileOverlayOptions.getVersionCode());
        C0067b.m118a(parcel, 2, tileOverlayOptions.cP(), false);
        C0067b.m124a(parcel, 3, tileOverlayOptions.isVisible());
        C0067b.m115a(parcel, 4, tileOverlayOptions.getZIndex());
        C0067b.m112C(parcel, k);
    }
}
