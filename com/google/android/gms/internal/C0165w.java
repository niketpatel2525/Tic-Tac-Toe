package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.location.DetectedActivity;
import java.util.List;

/* renamed from: com.google.android.gms.internal.w */
public class C0165w implements Creator<C0469v> {
    static void m697a(C0469v c0469v, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m131c(parcel, 1, c0469v.versionCode);
        C0067b.m116a(parcel, 2, c0469v.es);
        C0067b.m117a(parcel, 3, c0469v.extras, false);
        C0067b.m131c(parcel, 4, c0469v.et);
        C0067b.m122a(parcel, 5, c0469v.eu, false);
        C0067b.m124a(parcel, 6, c0469v.ev);
        C0067b.m131c(parcel, 7, c0469v.tagForChildDirectedTreatment);
        C0067b.m112C(parcel, k);
    }

    public C0469v m698a(Parcel parcel) {
        List list = null;
        int i = 0;
        int j = C0066a.m92j(parcel);
        long j2 = 0;
        boolean z = false;
        int i2 = 0;
        Bundle bundle = null;
        int i3 = 0;
        while (parcel.dataPosition() < j) {
            int i4 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i4)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    i3 = C0066a.m86f(parcel, i4);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    j2 = C0066a.m87g(parcel, i4);
                    break;
                case DetectedActivity.STILL /*3*/:
                    bundle = C0066a.m96n(parcel, i4);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    i2 = C0066a.m86f(parcel, i4);
                    break;
                case DetectedActivity.TILTING /*5*/:
                    list = C0066a.m106x(parcel, i4);
                    break;
                case GamesClient.STATUS_NETWORK_ERROR_OPERATION_FAILED /*6*/:
                    z = C0066a.m83c(parcel, i4);
                    break;
                case GamesClient.STATUS_LICENSE_CHECK_FAILED /*7*/:
                    i = C0066a.m86f(parcel, i4);
                    break;
                default:
                    C0066a.m80b(parcel, i4);
                    break;
            }
        }
        if (parcel.dataPosition() == j) {
            return new C0469v(i3, j2, bundle, i2, list, z, i);
        }
        throw new C0065a("Overread allowed size end=" + j, parcel);
    }

    public C0469v[] m699b(int i) {
        return new C0469v[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m698a(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m699b(x0);
    }
}
