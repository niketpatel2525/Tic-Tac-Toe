package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0067b;

/* renamed from: com.google.android.gms.maps.model.i */
public class C0195i {
    static void m753a(Tile tile, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, tile.getVersionCode());
        C0067b.m131c(parcel, 2, tile.width);
        C0067b.m131c(parcel, 3, tile.height);
        C0067b.m125a(parcel, 4, tile.data, false);
        C0067b.m112C(parcel, k);
    }
}
