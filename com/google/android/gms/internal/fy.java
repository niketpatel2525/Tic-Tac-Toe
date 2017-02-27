package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.internal.fv.C0595b;
import com.google.android.gms.internal.fv.C0595b.C0593a;
import com.google.android.gms.internal.fv.C0595b.C0594b;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashSet;
import java.util.Set;

public class fy implements Creator<C0595b> {
    static void m625a(C0595b c0595b, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        Set di = c0595b.di();
        if (di.contains(Integer.valueOf(1))) {
            C0067b.m131c(parcel, 1, c0595b.getVersionCode());
        }
        if (di.contains(Integer.valueOf(2))) {
            C0067b.m120a(parcel, 2, c0595b.dM(), i, true);
        }
        if (di.contains(Integer.valueOf(3))) {
            C0067b.m120a(parcel, 3, c0595b.dN(), i, true);
        }
        if (di.contains(Integer.valueOf(4))) {
            C0067b.m131c(parcel, 4, c0595b.getLayout());
        }
        C0067b.m112C(parcel, k);
    }

    public C0595b m626F(Parcel parcel) {
        C0594b c0594b = null;
        int i = 0;
        int j = C0066a.m92j(parcel);
        Set hashSet = new HashSet();
        C0593a c0593a = null;
        int i2 = 0;
        while (parcel.dataPosition() < j) {
            int i3 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i3)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i2 = C0066a.m86f(parcel, i3);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    C0593a c0593a2 = (C0593a) C0066a.m77a(parcel, i3, C0593a.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    c0593a = c0593a2;
                    break;
                case DetectedActivity.STILL /*3*/:
                    C0594b c0594b2 = (C0594b) C0066a.m77a(parcel, i3, C0594b.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    c0594b = c0594b2;
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i = C0066a.m86f(parcel, i3);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    C0066a.m80b(parcel, i3);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0595b(hashSet, i2, c0593a, c0594b, i);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public C0595b[] ak(int i) {
        return new C0595b[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m626F(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ak(x0);
    }
}
