package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.C0066a;
import com.google.android.gms.common.internal.safeparcel.C0066a.C0065a;
import com.google.android.gms.common.internal.safeparcel.C0067b;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.location.LocationStatusCodes;

/* renamed from: com.google.android.gms.common.data.e */
public class C0057e implements Creator<C0345d> {
    static void m45a(C0345d c0345d, Parcel parcel, int i) {
        int k = C0067b.m133k(parcel);
        C0067b.m127a(parcel, 1, c0345d.aK(), false);
        C0067b.m131c(parcel, LocationStatusCodes.GEOFENCE_NOT_AVAILABLE, c0345d.getVersionCode());
        C0067b.m126a(parcel, 2, c0345d.aL(), i, false);
        C0067b.m131c(parcel, 3, c0345d.getStatusCode());
        C0067b.m117a(parcel, 4, c0345d.aM(), false);
        C0067b.m112C(parcel, k);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return m46h(x0);
    }

    public C0345d m46h(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int j = C0066a.m92j(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < j) {
            int i3 = C0066a.m90i(parcel);
            switch (C0066a.m107y(i3)) {
                case DetectedActivity.ON_BICYCLE /*1*/:
                    strArr = C0066a.m105w(parcel, i3);
                    break;
                case DetectedActivity.ON_FOOT /*2*/:
                    cursorWindowArr = (CursorWindow[]) C0066a.m81b(parcel, i3, CursorWindow.CREATOR);
                    break;
                case DetectedActivity.STILL /*3*/:
                    i = C0066a.m86f(parcel, i3);
                    break;
                case DetectedActivity.UNKNOWN /*4*/:
                    bundle = C0066a.m96n(parcel, i3);
                    break;
                case LocationStatusCodes.GEOFENCE_NOT_AVAILABLE /*1000*/:
                    i2 = C0066a.m86f(parcel, i3);
                    break;
                default:
                    C0066a.m80b(parcel, i3);
                    break;
            }
        }
        if (parcel.dataPosition() != j) {
            throw new C0065a("Overread allowed size end=" + j, parcel);
        }
        C0345d c0345d = new C0345d(i2, strArr, cursorWindowArr, i, bundle);
        c0345d.aJ();
        return c0345d;
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return m47s(x0);
    }

    public C0345d[] m47s(int i) {
        return new C0345d[i];
    }
}
