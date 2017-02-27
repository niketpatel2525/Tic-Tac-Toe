package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.internal.fv.C0597d;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashSet;
import java.util.Set;

public class gc implements Creator<C0597d> {
    static void m633a(C0597d c0597d, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        Set di = c0597d.di();
        if (di.contains(Integer.valueOf(1))) {
            C0067b.m131c(parcel, 1, c0597d.getVersionCode());
        }
        if (di.contains(Integer.valueOf(2))) {
            C0067b.m121a(parcel, 2, c0597d.getFamilyName(), true);
        }
        if (di.contains(Integer.valueOf(3))) {
            C0067b.m121a(parcel, 3, c0597d.getFormatted(), true);
        }
        if (di.contains(Integer.valueOf(4))) {
            C0067b.m121a(parcel, 4, c0597d.getGivenName(), true);
        }
        if (di.contains(Integer.valueOf(5))) {
            C0067b.m121a(parcel, 5, c0597d.getHonorificPrefix(), true);
        }
        if (di.contains(Integer.valueOf(6))) {
            C0067b.m121a(parcel, 6, c0597d.getHonorificSuffix(), true);
        }
        if (di.contains(Integer.valueOf(7))) {
            C0067b.m121a(parcel, 7, c0597d.getMiddleName(), true);
        }
        C0067b.m112C(parcel, k);
    }

    public C0597d m634J(Parcel parcel) {
        String str = null;
        int j = C0066a.m92j(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0066a.m86f(parcel, i2);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str6 = C0066a.m94l(parcel, i2);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case DetectedActivity.STILL /*3*/:
                    str5 = C0066a.m94l(parcel, i2);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str4 = C0066a.m94l(parcel, i2);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str3 = C0066a.m94l(parcel, i2);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    str2 = C0066a.m94l(parcel, i2);
                    hashSet.add(Integer.valueOf(6));
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    str = C0066a.m94l(parcel, i2);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    C0066a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0597d(hashSet, i, str6, str5, str4, str3, str2, str);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public C0597d[] ao(int i) {
        return new C0597d[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m634J(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ao(x0);
    }
}
