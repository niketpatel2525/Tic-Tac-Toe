package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.internal.fv.C0598f;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashSet;
import java.util.Set;

public class gd implements Creator<C0598f> {
    static void m635a(C0598f c0598f, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        Set di = c0598f.di();
        if (di.contains(Integer.valueOf(1))) {
            C0067b.m131c(parcel, 1, c0598f.getVersionCode());
        }
        if (di.contains(Integer.valueOf(2))) {
            C0067b.m121a(parcel, 2, c0598f.getDepartment(), true);
        }
        if (di.contains(Integer.valueOf(3))) {
            C0067b.m121a(parcel, 3, c0598f.getDescription(), true);
        }
        if (di.contains(Integer.valueOf(4))) {
            C0067b.m121a(parcel, 4, c0598f.getEndDate(), true);
        }
        if (di.contains(Integer.valueOf(5))) {
            C0067b.m121a(parcel, 5, c0598f.getLocation(), true);
        }
        if (di.contains(Integer.valueOf(6))) {
            C0067b.m121a(parcel, 6, c0598f.getName(), true);
        }
        if (di.contains(Integer.valueOf(7))) {
            C0067b.m124a(parcel, 7, c0598f.isPrimary());
        }
        if (di.contains(Integer.valueOf(8))) {
            C0067b.m121a(parcel, 8, c0598f.getStartDate(), true);
        }
        if (di.contains(Integer.valueOf(9))) {
            C0067b.m121a(parcel, 9, c0598f.getTitle(), true);
        }
        if (di.contains(Integer.valueOf(10))) {
            C0067b.m131c(parcel, 10, c0598f.getType());
        }
        C0067b.m112C(parcel, k);
    }

    public C0598f m636K(Parcel parcel) {
        int i = 0;
        String str = null;
        int j = C0066a.m92j(parcel);
        Set hashSet = new HashSet();
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        int i2 = 0;
        while (parcel.dataPosition() < j) {
            int i3 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i3)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i2 = C0066a.m86f(parcel, i3);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str7 = C0066a.m94l(parcel, i3);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case DetectedActivity.STILL /*3*/:
                    str6 = C0066a.m94l(parcel, i3);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str5 = C0066a.m94l(parcel, i3);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str4 = C0066a.m94l(parcel, i3);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    str3 = C0066a.m94l(parcel, i3);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    z = C0066a.m83c(parcel, i3);
                    hashSet.add(Integer.valueOf(7));
                    break;
                case GamesClient.STATUS_APP_MISCONFIGURED /*8*/:
                    str2 = C0066a.m94l(parcel, i3);
                    hashSet.add(Integer.valueOf(8));
                    break;
                case ConnectionResult.SERVICE_INVALID /*9*/:
                    str = C0066a.m94l(parcel, i3);
                    hashSet.add(Integer.valueOf(9));
                    break;
                case ConnectionResult.DEVELOPER_ERROR /*10*/:
                    i = C0066a.m86f(parcel, i3);
                    hashSet.add(Integer.valueOf(10));
                    break;
                default:
                    C0066a.m80b(parcel, i3);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0598f(hashSet, i2, str7, str6, str5, str4, str3, z, str2, str, i);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public C0598f[] ap(int i) {
        return new C0598f[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m636K(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ap(x0);
    }
}
