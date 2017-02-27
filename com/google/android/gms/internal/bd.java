package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;

public class bd implements Creator<be> {
    static void m200a(be beVar, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, beVar.versionCode);
        C0067b.m121a(parcel, 2, beVar.fy, false);
        C0067b.m121a(parcel, 3, beVar.fz, false);
        C0067b.m121a(parcel, 4, beVar.mimeType, false);
        C0067b.m121a(parcel, 5, beVar.packageName, false);
        C0067b.m121a(parcel, 6, beVar.fA, false);
        C0067b.m121a(parcel, 7, beVar.fB, false);
        C0067b.m121a(parcel, 8, beVar.fC, false);
        C0067b.m112C(parcel, k);
    }

    public be m201c(Parcel parcel) {
        String str = null;
        int j = C0066a.m92j(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0066a.m86f(parcel, i2);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str7 = C0066a.m94l(parcel, i2);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str6 = C0066a.m94l(parcel, i2);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str5 = C0066a.m94l(parcel, i2);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str4 = C0066a.m94l(parcel, i2);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    str3 = C0066a.m94l(parcel, i2);
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    str2 = C0066a.m94l(parcel, i2);
                    break;
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    str = C0066a.m94l(parcel, i2);
                    break;
                default:
                    C0066a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new be(i, str7, str6, str5, str4, str3, str2, str);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m201c(x0);
    }

    public be[] m202g(int i) {
        return new be[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m202g(x0);
    }
}
