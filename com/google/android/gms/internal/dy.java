package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.internal.dw.C0421a;
import com.google.android.gms.internal.dz.C0423b;
import com.google.android.gms.location.DetectedActivity;

public class dy implements Creator<C0423b> {
    static void m426a(C0423b c0423b, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, c0423b.versionCode);
        C0067b.m121a(parcel, 2, c0423b.lN, false);
        C0067b.m120a(parcel, 3, c0423b.lO, i, false);
        C0067b.m112C(parcel, k);
    }

    public C0423b[] m427D(int i) {
        return new C0423b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m428p(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m427D(x0);
    }

    public C0423b m428p(Parcel parcel) {
        C0421a c0421a = null;
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
                    c0421a = (C0421a) C0066a.m77a(parcel, i2, C0421a.CREATOR);
                    break;
                default:
                    C0066a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0423b(i, str, c0421a);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }
}
