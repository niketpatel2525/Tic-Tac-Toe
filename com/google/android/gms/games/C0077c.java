package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.LocationStatusCodes;

/* renamed from: com.google.android.gms.games.c */
public class C0077c implements Creator<PlayerEntity> {
    static void m149a(PlayerEntity playerEntity, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m121a(parcel, 1, playerEntity.getPlayerId(), false);
        C0067b.m131c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, playerEntity.getVersionCode());
        C0067b.m121a(parcel, 2, playerEntity.getDisplayName(), false);
        C0067b.m120a(parcel, 3, playerEntity.getIconImageUri(), i, false);
        C0067b.m120a(parcel, 4, playerEntity.getHiResImageUri(), i, false);
        C0067b.m116a(parcel, 5, playerEntity.getRetrievedTimestamp());
        C0067b.m112C(parcel, k);
    }

    public PlayerEntity[] m150L(int i) {
        return new PlayerEntity[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m151u(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m150L(x0);
    }

    public PlayerEntity m151u(Parcel parcel) {
        Uri uri = null;
        int j = C0066a.m92j(parcel);
        int i = 0;
        long j2 = 0;
        Uri uri2 = null;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    str2 = C0066a.m94l(parcel, i2);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str = C0066a.m94l(parcel, i2);
                    break;
                case DetectedActivity.STILL /*3*/:
                    uri2 = (Uri) C0066a.m77a(parcel, i2, Uri.CREATOR);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    uri = (Uri) C0066a.m77a(parcel, i2, Uri.CREATOR);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    j2 = C0066a.m87g(parcel, i2);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0066a.m86f(parcel, i2);
                    break;
                default:
                    C0066a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new PlayerEntity(i, str2, str, uri2, uri, j2);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }
}
