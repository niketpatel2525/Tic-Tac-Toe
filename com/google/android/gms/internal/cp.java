package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.location.DetectedActivity;

public class cp implements Creator<co> {
    static void m300a(co coVar, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, coVar.versionCode);
        C0067b.m121a(parcel, 2, coVar.hP, false);
        C0067b.m131c(parcel, 3, coVar.hQ);
        C0067b.m131c(parcel, 4, coVar.hR);
        C0067b.m124a(parcel, 5, coVar.hS);
        C0067b.m112C(parcel, k);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m301g(x0);
    }

    public co m301g(Parcel parcel) {
        boolean z = false;
        int j = C0066a.m92j(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i4)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i3 = C0066a.m86f(parcel, i4);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    str = C0066a.m94l(parcel, i4);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i2 = C0066a.m86f(parcel, i4);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i = C0066a.m86f(parcel, i4);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    z = C0066a.m83c(parcel, i4);
                    break;
                default:
                    C0066a.m80b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new co(i3, str, i2, i, z);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public co[] m302l(int i) {
        return new co[i];
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m302l(x0);
    }
}
