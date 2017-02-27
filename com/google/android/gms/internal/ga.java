package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.internal.fv.C0595b.C0594b;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashSet;
import java.util.Set;

public class ga implements Creator<C0594b> {
    static void m629a(C0594b c0594b, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        Set di = c0594b.di();
        if (di.contains(Integer.valueOf(1))) {
            C0067b.m131c(parcel, 1, c0594b.getVersionCode());
        }
        if (di.contains(Integer.valueOf(2))) {
            C0067b.m131c(parcel, 2, c0594b.getHeight());
        }
        if (di.contains(Integer.valueOf(3))) {
            C0067b.m121a(parcel, 3, c0594b.getUrl(), true);
        }
        if (di.contains(Integer.valueOf(4))) {
            C0067b.m131c(parcel, 4, c0594b.getWidth());
        }
        C0067b.m112C(parcel, k);
    }

    public C0594b m630H(Parcel parcel) {
        int i = 0;
        int j = C0066a.m92j(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i4)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i3 = C0066a.m86f(parcel, i4);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    i2 = C0066a.m86f(parcel, i4);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case DetectedActivity.STILL /*3*/:
                    str = C0066a.m94l(parcel, i4);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i = C0066a.m86f(parcel, i4);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    C0066a.m80b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0594b(hashSet, i3, i2, str, i);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public C0594b[] am(int i) {
        return new C0594b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m630H(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return am(x0);
    }
}
