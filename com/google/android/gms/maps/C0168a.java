package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.C0067b;

/* renamed from: com.google.android.gms.maps.a */
public class C0168a {
    static void m709a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, googleMapOptions.getVersionCode());
        C0067b.m113a(parcel, 2, googleMapOptions.cv());
        C0067b.m113a(parcel, 3, googleMapOptions.cw());
        C0067b.m131c(parcel, 4, googleMapOptions.getMapType());
        C0067b.m120a(parcel, 5, googleMapOptions.getCamera(), i, false);
        C0067b.m113a(parcel, 6, googleMapOptions.cx());
        C0067b.m113a(parcel, 7, googleMapOptions.cy());
        C0067b.m113a(parcel, 8, googleMapOptions.cz());
        C0067b.m113a(parcel, 9, googleMapOptions.cA());
        C0067b.m113a(parcel, 10, googleMapOptions.cB());
        C0067b.m113a(parcel, 11, googleMapOptions.cC());
        C0067b.m112C(parcel, k);
    }
}
