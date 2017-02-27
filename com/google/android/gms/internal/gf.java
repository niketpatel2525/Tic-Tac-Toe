package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.internal.fv.C0600h;
import com.google.android.gms.location.DetectedActivity;
import java.util.HashSet;
import java.util.Set;

public class gf implements Creator<C0600h> {
    static void m639a(C0600h c0600h, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        Set di = c0600h.di();
        if (di.contains(Integer.valueOf(1))) {
            C0067b.m131c(parcel, 1, c0600h.getVersionCode());
        }
        if (di.contains(Integer.valueOf(3))) {
            C0067b.m131c(parcel, 3, c0600h.dV());
        }
        if (di.contains(Integer.valueOf(4))) {
            C0067b.m121a(parcel, 4, c0600h.getValue(), true);
        }
        if (di.contains(Integer.valueOf(5))) {
            C0067b.m121a(parcel, 5, c0600h.getLabel(), true);
        }
        if (di.contains(Integer.valueOf(6))) {
            C0067b.m131c(parcel, 6, c0600h.getType());
        }
        C0067b.m112C(parcel, k);
    }

    public C0600h m640M(Parcel parcel) {
        String str = null;
        int i = 0;
        int j = C0066a.m92j(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i4)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i3 = C0066a.m86f(parcel, i4);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0066a.m86f(parcel, i4);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    str = C0066a.m94l(parcel, i4);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case DetectedActivity.TILTING /*5*/:
                    str2 = C0066a.m94l(parcel, i4);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    i2 = C0066a.m86f(parcel, i4);
                    hashSet.add(Integer.valueOf(6));
                    break;
                default:
                    C0066a.m80b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0600h(hashSet, i3, str2, i2, str, i);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public C0600h[] ar(int i) {
        return new C0600h[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m640M(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return ar(x0);
    }
}
