package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.location.DetectedActivity;

public class TileCreator implements Creator<Tile> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void m742a(Tile tile, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, tile.getVersionCode());
        C0067b.m131c(parcel, 2, tile.width);
        C0067b.m131c(parcel, 3, tile.height);
        C0067b.m125a(parcel, 4, tile.data, false);
        C0067b.m112C(parcel, k);
    }

    public Tile createFromParcel(Parcel parcel) {
        int i = 0;
        int j = C0066a.m92j(parcel);
        byte[] bArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i4)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i3 = C0066a.m86f(parcel, i4);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    i2 = C0066a.m86f(parcel, i4);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0066a.m86f(parcel, i4);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    bArr = C0066a.m97o(parcel, i4);
                    break;
                default:
                    C0066a.m80b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new Tile(i3, i2, i, bArr);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public Tile[] newArray(int size) {
        return new Tile[size];
    }
}
