package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.internal.dz.C0422a;
import com.google.android.gms.internal.dz.C0423b;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;

public class eb implements Creator<C0422a> {
    static void m432a(C0422a c0422a, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, c0422a.versionCode);
        C0067b.m121a(parcel, 2, c0422a.className, false);
        C0067b.m130b(parcel, 3, c0422a.lM, false);
        C0067b.m112C(parcel, k);
    }

    public C0422a[] m433F(int i) {
        return new C0422a[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m434r(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m433F(x0);
    }

    public C0422a m434r(Parcel parcel) {
        ArrayList arrayList = null;
        int j = C0066a.m92j(parcel);
        int i = 0;
        String str = null;
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
                    arrayList = C0066a.m82c(parcel, i2, C0423b.CREATOR);
                    break;
                default:
                    C0066a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0422a(i, str, arrayList);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }
}
