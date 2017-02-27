package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.internal.dt.C0420a;
import com.google.android.gms.location.DetectedActivity;

public class dv implements Creator<C0420a> {
    static void m410a(C0420a c0420a, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, c0420a.versionCode);
        C0067b.m121a(parcel, 2, c0420a.lx, false);
        C0067b.m131c(parcel, 3, c0420a.ly);
        C0067b.m112C(parcel, k);
    }

    public C0420a[] m411B(int i) {
        return new C0420a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m412n(x0);
    }

    public C0420a m412n(Parcel parcel) {
        int i = 0;
        int j = C0066a.m92j(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < j) {
            int i3 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i3)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i2 = C0066a.m86f(parcel, i3);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str = C0066a.m94l(parcel, i3);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0066a.m86f(parcel, i3);
                    break;
                default:
                    C0066a.m80b(parcel, i3);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0420a(i2, str, i);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m411B(x0);
    }
}
