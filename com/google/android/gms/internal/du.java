package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.internal.dt.C0420a;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;

public class du implements Creator<dt> {
    static void m407a(dt dtVar, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, dtVar.getVersionCode());
        C0067b.m130b(parcel, 2, dtVar.bm(), false);
        C0067b.m112C(parcel, k);
    }

    public dt[] m408A(int i) {
        return new dt[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m409m(x0);
    }

    public dt m409m(Parcel parcel) {
        int j = C0066a.m92j(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0066a.m86f(parcel, i2);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    arrayList = C0066a.m82c(parcel, i2, C0420a.CREATOR);
                    break;
                default:
                    C0066a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new dt(i, arrayList);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m408A(x0);
    }
}
