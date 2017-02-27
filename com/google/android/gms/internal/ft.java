package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashSet;
import java.util.Set;

public class ft implements Creator<fs> {
    static void m619a(fs fsVar, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        Set di = fsVar.di();
        if (di.contains(Integer.valueOf(1))) {
            C0067b.m131c(parcel, 1, fsVar.getVersionCode());
        }
        if (di.contains(Integer.valueOf(2))) {
            C0067b.m121a(parcel, 2, fsVar.getId(), true);
        }
        if (di.contains(Integer.valueOf(4))) {
            C0067b.m120a(parcel, 4, fsVar.dz(), i, true);
        }
        if (di.contains(Integer.valueOf(5))) {
            C0067b.m121a(parcel, 5, fsVar.getStartDate(), true);
        }
        if (di.contains(Integer.valueOf(6))) {
            C0067b.m120a(parcel, 6, fsVar.dA(), i, true);
        }
        if (di.contains(Integer.valueOf(7))) {
            C0067b.m121a(parcel, 7, fsVar.getType(), true);
        }
        C0067b.m112C(parcel, k);
    }

    public fs m620C(Parcel parcel) {
        String str = null;
        int j = C0066a.m92j(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        fq fqVar = null;
        String str2 = null;
        fq fqVar2 = null;
        String str3 = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0066a.m90i(parcel);
            fq fqVar3;
            switch (C0066a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0066a.m86f(parcel, i2);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str3 = C0066a.m94l(parcel, i2);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    fqVar3 = (fq) C0066a.m77a(parcel, i2, fq.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    fqVar2 = fqVar3;
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str2 = C0066a.m94l(parcel, i2);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    fqVar3 = (fq) C0066a.m77a(parcel, i2, fq.CREATOR);
                    hashSet.add(Integer.valueOf(6));
                    fqVar = fqVar3;
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
            return new fs(hashSet, i, str3, fqVar2, str2, fqVar, str);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public fs[] ah(int i) {
        return new fs[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m620C(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ah(x0);
    }
}
