package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.location.DetectedActivity;

public class ed implements Creator<ec> {
    static void m435a(ec ecVar, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, ecVar.getVersionCode());
        C0067b.m119a(parcel, 2, ecVar.bH(), false);
        C0067b.m120a(parcel, 3, ecVar.bI(), i, false);
        C0067b.m112C(parcel, k);
    }

    public ec[] m436G(int i) {
        return new ec[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m437s(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m436G(x0);
    }

    public ec m437s(Parcel parcel) {
        dz dzVar = null;
        int j = C0066a.m92j(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < j) {
            int i2 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i2)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i = C0066a.m86f(parcel, i2);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    parcel2 = C0066a.m108y(parcel, i2);
                    break;
                case DetectedActivity.STILL /*3*/:
                    dzVar = (dz) C0066a.m77a(parcel, i2, dz.CREATOR);
                    break;
                default:
                    C0066a.m80b(parcel, i2);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new ec(i, parcel2, dzVar);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }
}
