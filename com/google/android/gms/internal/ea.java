package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.internal.dz.C0422a;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;

public class ea implements Creator<dz> {
    static void m429a(dz dzVar, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, dzVar.getVersionCode());
        C0067b.m130b(parcel, 2, dzVar.bE(), false);
        C0067b.m121a(parcel, 3, dzVar.bF(), false);
        C0067b.m112C(parcel, k);
    }

    public dz[] m430E(int i) {
        return new dz[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m431q(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m430E(x0);
    }

    public dz m431q(Parcel parcel) {
        String str = null;
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
                    arrayList = C0066a.m82c(parcel, i2, C0422a.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    str = C0066a.m94l(parcel, i2);
                    break;
                default:
                    C0066a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new dz(i, arrayList, str);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }
}
