package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0067b;

/* renamed from: com.google.android.gms.maps.model.c */
public class C0189c {
    static void m747a(GroundOverlayOptions groundOverlayOptions, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, groundOverlayOptions.getVersionCode());
        C0067b.m118a(parcel, 2, groundOverlayOptions.cM(), false);
        C0067b.m120a(parcel, 3, groundOverlayOptions.getLocation(), i, false);
        C0067b.m115a(parcel, 4, groundOverlayOptions.getWidth());
        C0067b.m115a(parcel, 5, groundOverlayOptions.getHeight());
        C0067b.m120a(parcel, 6, groundOverlayOptions.getBounds(), i, false);
        C0067b.m115a(parcel, 7, groundOverlayOptions.getBearing());
        C0067b.m115a(parcel, 8, groundOverlayOptions.getZIndex());
        C0067b.m124a(parcel, 9, groundOverlayOptions.isVisible());
        C0067b.m115a(parcel, 10, groundOverlayOptions.getTransparency());
        C0067b.m115a(parcel, 11, groundOverlayOptions.getAnchorU());
        C0067b.m115a(parcel, 12, groundOverlayOptions.getAnchorV());
        C0067b.m112C(parcel, k);
    }
}
