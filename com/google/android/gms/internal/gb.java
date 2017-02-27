package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.internal.fv.C0596c;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashSet;
import java.util.Set;

public class gb implements Creator<C0596c> {
    static void m631a(C0596c c0596c, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        Set di = c0596c.di();
        if (di.contains(Integer.valueOf(1))) {
            C0067b.m131c(parcel, 1, c0596c.getVersionCode());
        }
        if (di.contains(Integer.valueOf(2))) {
            C0067b.m121a(parcel, 2, c0596c.getUrl(), true);
        }
        C0067b.m112C(parcel, k);
    }

    public C0596c m632I(Parcel parcel) {
        int j = C0066a.m92j(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0066a.m86f(parcel, i2);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str = C0066a.m94l(parcel, i2);
                    hashSet.add(Integer.valueOf(2));
                    break;
                default:
                    C0066a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0596c(hashSet, i, str);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public C0596c[] an(int i) {
        return new C0596c[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m632I(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return an(x0);
    }
}
