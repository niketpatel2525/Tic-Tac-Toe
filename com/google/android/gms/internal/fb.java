package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.LocationStatusCodes;

public class fb implements Creator<fa> {
    static void m583a(fa faVar, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m121a(parcel, 1, faVar.getRequestId(), false);
        C0067b.m131c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, faVar.getVersionCode());
        C0067b.m116a(parcel, 2, faVar.getExpirationTime());
        C0067b.m123a(parcel, 3, faVar.co());
        C0067b.m114a(parcel, 4, faVar.getLatitude());
        C0067b.m114a(parcel, 5, faVar.getLongitude());
        C0067b.m115a(parcel, 6, faVar.cp());
        C0067b.m131c(parcel, 7, faVar.cq());
        C0067b.m131c(parcel, 8, faVar.getNotificationResponsiveness());
        C0067b.m131c(parcel, 9, faVar.cr());
        C0067b.m112C(parcel, k);
    }

    public fa[] ac(int i) {
        return new fa[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m584z(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ac(x0);
    }

    public fa m584z(Parcel parcel) {
        int j = C0066a.m92j(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        short s = (short) 0;
        double d = 0.0d;
        double d2 = 0.0d;
        float f = 0.0f;
        long j2 = 0;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < j) {
            int i5 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i5)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    str = C0066a.m94l(parcel, i5);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    j2 = C0066a.m87g(parcel, i5);
                    break;
                case DetectedActivity.STILL /*3*/:
                    s = C0066a.m85e(parcel, i5);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    d = C0066a.m91j(parcel, i5);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    d2 = C0066a.m91j(parcel, i5);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    f = C0066a.m89i(parcel, i5);
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    i2 = C0066a.m86f(parcel, i5);
                    break;
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    i3 = C0066a.m86f(parcel, i5);
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    i4 = C0066a.m86f(parcel, i5);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i = C0066a.m86f(parcel, i5);
                    break;
                default:
                    C0066a.m80b(parcel, i5);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new fa(i, str, i2, s, d, d2, f, j2, i3, i4);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }
}
