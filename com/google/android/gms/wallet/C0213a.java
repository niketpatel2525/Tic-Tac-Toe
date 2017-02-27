package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;

/* renamed from: com.google.android.gms.wallet.a */
public class C0213a implements Creator<Address> {
    static void m776a(Address address, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, address.getVersionCode());
        C0067b.m121a(parcel, 2, address.name, false);
        C0067b.m121a(parcel, 3, address.tu, false);
        C0067b.m121a(parcel, 4, address.tv, false);
        C0067b.m121a(parcel, 5, address.tw, false);
        C0067b.m121a(parcel, 6, address.hl, false);
        C0067b.m121a(parcel, 7, address.tx, false);
        C0067b.m121a(parcel, 8, address.ty, false);
        C0067b.m121a(parcel, 9, address.tz, false);
        C0067b.m121a(parcel, 10, address.tA, false);
        C0067b.m124a(parcel, 11, address.tB);
        C0067b.m121a(parcel, 12, address.tC, false);
        C0067b.m112C(parcel, k);
    }

    public Address m777N(Parcel parcel) {
        int j = C0066a.m92j(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        boolean z = false;
        String str10 = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0066a.m86f(parcel, i2);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str = C0066a.m94l(parcel, i2);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str2 = C0066a.m94l(parcel, i2);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str3 = C0066a.m94l(parcel, i2);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str4 = C0066a.m94l(parcel, i2);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    str5 = C0066a.m94l(parcel, i2);
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    str6 = C0066a.m94l(parcel, i2);
                    break;
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    str7 = C0066a.m94l(parcel, i2);
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    str8 = C0066a.m94l(parcel, i2);
                    break;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    str9 = C0066a.m94l(parcel, i2);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                    z = C0066a.m83c(parcel, i2);
                    break;
                case ConnectionResult.DATE_INVALID /*12*/:
                    str10 = C0066a.m94l(parcel, i2);
                    break;
                default:
                    C0066a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new Address(i, str, str2, str3, str4, str5, str6, str7, str8, str9, z, str10);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public Address[] as(int i) {
        return new Address[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m777N(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return as(x0);
    }
}
