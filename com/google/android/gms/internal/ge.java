package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.internal.fv.C0599g;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashSet;
import java.util.Set;

public class ge implements Creator<C0599g> {
    static void m637a(C0599g c0599g, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        Set di = c0599g.di();
        if (di.contains(Integer.valueOf(1))) {
            C0067b.m131c(parcel, 1, c0599g.getVersionCode());
        }
        if (di.contains(Integer.valueOf(2))) {
            C0067b.m124a(parcel, 2, c0599g.isPrimary());
        }
        if (di.contains(Integer.valueOf(3))) {
            C0067b.m121a(parcel, 3, c0599g.getValue(), true);
        }
        C0067b.m112C(parcel, k);
    }

    public C0599g m638L(Parcel parcel) {
        boolean z = false;
        int j = C0066a.m92j(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < j) {
            int i2 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0066a.m86f(parcel, i2);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    z = C0066a.m83c(parcel, i2);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case DetectedActivity.STILL /*3*/:
                    str = C0066a.m94l(parcel, i2);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    C0066a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0599g(hashSet, i, z, str);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public C0599g[] aq(int i) {
        return new C0599g[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m638L(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return aq(x0);
    }
}
