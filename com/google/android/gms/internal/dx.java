package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.internal.dw.C0421a;
import com.google.android.gms.location.DetectedActivity;

public class dx implements Creator<C0421a> {
    static void m423a(C0421a c0421a, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, c0421a.getVersionCode());
        C0067b.m131c(parcel, 2, c0421a.bn());
        C0067b.m124a(parcel, 3, c0421a.bt());
        C0067b.m131c(parcel, 4, c0421a.bo());
        C0067b.m124a(parcel, 5, c0421a.bu());
        C0067b.m121a(parcel, 6, c0421a.bv(), false);
        C0067b.m131c(parcel, 7, c0421a.bw());
        C0067b.m121a(parcel, 8, c0421a.by(), false);
        C0067b.m120a(parcel, 9, c0421a.bA(), i, false);
        C0067b.m112C(parcel, k);
    }

    public C0421a[] m424C(int i) {
        return new C0421a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m425o(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m424C(x0);
    }

    public C0421a m425o(Parcel parcel) {
        dr drVar = null;
        int i = 0;
        int j = C0066a.m92j(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < j) {
            int i5 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i5)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i4 = C0066a.m86f(parcel, i5);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    i3 = C0066a.m86f(parcel, i5);
                    break;
                case DetectedActivity.STILL /*3*/:
                    z2 = C0066a.m83c(parcel, i5);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i2 = C0066a.m86f(parcel, i5);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    z = C0066a.m83c(parcel, i5);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    str2 = C0066a.m94l(parcel, i5);
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    i = C0066a.m86f(parcel, i5);
                    break;
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    str = C0066a.m94l(parcel, i5);
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    drVar = (dr) C0066a.m77a(parcel, i5, dr.CREATOR);
                    break;
                default:
                    C0066a.m80b(parcel, i5);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0421a(i4, i3, z2, i2, z, str2, i, str, drVar);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }
}
